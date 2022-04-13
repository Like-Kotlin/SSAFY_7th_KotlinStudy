package m4w10

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    val char1 = st.nextToken()
    val char2 = st.nextToken()

    var x = -1L
    var a = -1
    var b = -1

    for (i in 2..36) {

        val changeA = change(i, char1)
        if (changeA == -1L) {
            continue
        }

        for (j in 2..36) {
            if( i == j ){
                continue
            }
            val changeB = change(j, char2)
            if (changeB == -1L) {
                continue
            }

            if (changeA == changeB) {
                if (x == -1L) {
                    x = changeA
                    a = i
                    b = j
                } else {
                    println("Multiple")
                    return
                }
            }
        }
    }

    if (x == -1L) {
        println("Impossible")
    } else {
        println("$x $a $b")
    }
}

fun change(num: Int, char: String): Long {

    var result = 0L
    var mul = 1L

    for (i in char.length - 1 downTo 0) {
        if (changeLong(char[i]) + 1 > num) {
            return -1L
        }
        result += changeLong(char[i]) * mul
        mul *= num

        if (result < 0) {
            return -1L
        }

    }
    return result

}

fun changeLong(ch: Char): Long {
    return if (ch in '0'..'9') {
        (ch - '0').toLong()
    } else {
        (ch - 'a' + 10).toLong()
    }
}
package m6w16

class PG81301 {
    fun solution(s: String): Int {
        var answer: Int = 0

        val c = s
            .replace("zero","0")
            .replace("one","1")
            .replace("two","2")
            .replace("three","3")
            .replace("four","4")
            .replace("five","5")
            .replace("six","6")
            .replace("seven","7")
            .replace("eight","8")
            .replace("nine","9")

        println(c)


        return c.toInt()
    }
}
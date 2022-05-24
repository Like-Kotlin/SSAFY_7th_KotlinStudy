package m5w14

import java.util.*

class Solution1 {
    fun solution(new_id: String): String {
        var answer = new_id

        //1단계
        answer = answer.lowercase(Locale.getDefault())

        var ans = ""

        //2단계
        for (i in answer.indices) {
            if (answer[i] in 'a'..'z' || answer[i] in '0'..'9' || answer[i] == '-' || answer[i] == '_' || answer[i] == '.') {
                ans += answer[i]
            }
        }
        //3단계
        var ansList = ans.toMutableList()
        var i = -1

        while (i != ansList.size){
            i++
            for (j in i until ansList.size - 1) {
                if (ansList[j] == '.' && ansList[j + 1] == '.') {
                    ansList.removeAt(j)
                    i--
                    break
                }

            }

        }
        //4단계

        while (ansList.isNotEmpty() && ansList[0] == '.') {
            ansList.removeAt(0)
        }

        while (ansList.isNotEmpty() && ansList[ansList.size - 1] == '.') {
            ansList.removeAt(ansList.size - 1)
        }

        //5단계
        if (ansList.isEmpty()) {
            ansList.add('a')
        }


        //6단계
        if (ansList.size >= 16) {
            ansList = ansList.subList(0, 15)
        }
        while (ansList[ansList.size - 1] == '.') {
            ansList.removeAt(ansList.size - 1)
        }

        //7단계
        if (ansList.size <= 2) {
            while (ansList.size != 3) {
                ansList.add(ansList[ansList.size - 1])
            }
        }

        var res = ""

        for(i in ansList.indices){
            res+=ansList[i]
        }

        return res
    }
}
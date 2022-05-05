package m4w13

class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        val answer = IntArray(id_list.size)

        report.sort()

        val hm = hashMapOf<String, Int>()
        val hm1 = hashMapOf<String, ArrayList<String>>()

        id_list.forEach {
            hm[it] = 0
            hm1[it] = arrayListOf()
        }

        var preReport = ""
        for (i in report.indices) {

            if (preReport == report[i]) {
                continue
            }
            preReport = report[i]

            val content = report[i].split(" ")
            val p1 = content[0]
            val p2 = content[1]

            hm[p2] = hm[p2]!! + 1
            hm1[p1]!!.add(p2)

        }

        for (i in hm) {
            if (i.value >= k) {
                id_list.forEachIndexed { index, s ->
                    val p = s
                    if (hm1[p]!!.contains(i.key)) {
                        answer[index]++
                    }
                }
            }
        }


        return answer
    }
}
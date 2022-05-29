package m5w15

class PG60057 {
    fun solution(s: String): Int {
        var answer = Int.MAX_VALUE
        if (s.length == 1) return 1

        for (i in 1 until s.length) {
            var now = ""
            var comp = ""
            var temp = ""
            var cnt = 1

            for (j in 0..s.length / i) {
                val from = i * j
                var to = i * (j + 1)

                if (to > s.length) to = s.length

                now = comp
                comp = s.substring(from, to)

                if (now == comp) {
                    cnt++
                } else {
                    if (cnt > 1) {
                        temp += cnt.toString()
                    }
                    temp += now
                    cnt = 1
                }
            }

            if (cnt > 1) temp += cnt.toString()
            temp += comp

            answer = Math.min(temp.length, answer)
        }
        return answer
    }
}
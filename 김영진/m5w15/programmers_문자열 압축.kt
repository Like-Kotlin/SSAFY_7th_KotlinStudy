//https://programmers.co.kr/learn/courses/30/lessons/60057
class Solution {
    fun solution(s: String): Int {
        var answer = s.length

        //solve
        for (len in 1..s.length / 2) {
            var result = 0
            //기준 문자열
            //계속 바뀜
            var cur = ""
            var pressCount = 0
            var rest = 0
            for (i in  0 .. s.length-len step len) {
                val next = s.substring(i, i + len)
                rest = s.length-len-i
                //같으면 다음
                if (cur == next) {
                    pressCount++
                }
                //다르면 길이 더하기
                else {
                    result += len
                    //압축 가능하면 추가로 +
                    if (pressCount > 1) {
                        result += pressCount.toString().length

                    }
                    //기준 문자열 갱신
                    cur = s.substring(i, i + len)
                    //압축 가능 상태 초기화
                    pressCount = 1
                }
            }
            //남은 문자열이 압축 가능한 상태면+

            if (pressCount > 1)
                result += pressCount.toString().length
            //result + 남은 문자열 길이로 비교
            answer = answer.coerceAtMost(result + rest)
        }

        return answer
    }
}

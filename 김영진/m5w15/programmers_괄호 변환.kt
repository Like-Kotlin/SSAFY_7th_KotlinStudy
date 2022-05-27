//https://programmers.co.kr/learn/courses/30/lessons/60058
import java.util.*
class Solution {

    //u v로 나누기
    //u가 올바르다면 v로 재귀
    //u가 올바르지 않다면 ( + v재귀 + ) + u의 첫, 마지막 제거 후 뒤집은 값
    fun solve(p: String): String {
        if (p.isEmpty()) return ""
        var op = 0
        var cl = 0
        var u = ""
        var v = ""
        //u, v 구하기
        for (i in p.indices) {
            if (p[i] == '(') op++
            else cl++
            if (op == cl) {
                u = p.substring(0, i + 1)
                v = p.substring(i + 1)
                break
            }
        }

        var result = ""

        if (isRight(u)) {
            //u가 올바르다면
            result = u + solve(v)
        } else {
            //u가 올바르지 않다면
            var add1 = '('+solve(v)+')'

            var add2 = ""
            for (i in u.indices) {
                if (i == 0 || i == u.length - 1) continue
                add2 += if(u[i]==')') '(' else ')'
            }
            result = add1 + add2
        }
        return result
    }

    fun isRight(p: String): Boolean {
        val stk = Stack<Char>()
        for (i in p.indices) {
            if (p[i] == ')') {
                if (stk.isEmpty()) return false
                stk.pop()
            } else {
                stk.add(p[i])
            }
        }
        return stk.isEmpty()
    }

    fun solution(p: String): String {

        //처음부터 올바른 괄호
        //안 해도 됨
        if (isRight(p)) return p

        return solve(p)
    }
}

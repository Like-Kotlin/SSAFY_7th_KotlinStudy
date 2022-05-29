package m5w15

import java.util.*

class PG60058 {
    fun solution(p: String): String {
        var answer = ""

        if(check(p)){
            return p
        }

        answer = split(p)

        return answer
    }

    fun split(s : String) : String{

        if(s == "") return ""

        var result = ""
        var leftCnt = 0
        var rightCnt = 0

        for(i in s.indices){
            if(s[i] == '(') leftCnt++
            else rightCnt++

            if(leftCnt == rightCnt){
                var u = s.substring(0,i+1)
                var v = s.substring(i+1)

                if(check(u)){
                    u += split(v)
                    result = u
                }else{
                    var sr = "("
                    sr = sr+split(v)+")"

                    var text = ""
                    if(u.length > 2 ){
                        text = u.substring(1,u.length-1)
                    }

                    val st = reverse(text)

                    val str = sr+st

                    result = str

                }
                break
            }


        }
        return result

    }

    fun reverse(str: String) : String{

        var st = ""
        if(str == "") return st

        for(ch in str){
            if(ch == '('){
                st+=')'
            }else{
                st+='('
            }
        }
        return st
    }


    fun check(str : String) : Boolean{

        val stk = Stack<Char>()

        for(ch in str){

            if(stk.isNotEmpty()){

                if(stk.peek() == '(' && ch == ')'){
                    stk.pop()
                }else{
                    stk.push(ch)
                }

            }else{
                stk.push(ch)
            }

        }

        if(stk.isEmpty()) return true

        return false

    }
}
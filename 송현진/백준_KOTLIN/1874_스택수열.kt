import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(){
        var br = BufferedReader(InputStreamReader(System.`in`))
        var N = br.readLine().toInt()

        var arr = Array(N+1){0}
        for(i in 1..N){
                arr[i] = br.readLine().toInt()
        }

        calStack(N, arr)
}

fun calStack(N: Int, arr: Array<Int>){
        var sb = StringBuffer()
        var stack = Stack<Int>()
        var storeStack = Stack<Int>()

        for(i in N downTo 1) {
                storeStack.push(i)
        }

        for(i in 1 until N+1){//arr 4 3 6 8 7 5 2 1
                //스택 비었다면
                if(stack.isEmpty()){
                        //store에서 꺼내서 arr까지 담기
                        while(!storeStack.isEmpty()){
                                sb.append("+\n")
                                stack.push(storeStack.pop())
                                if(arr[i] == stack.peek()) break
                                if(!checkEmpty(stack)) return;
                        }
                }
                //스택 비지 않았다면
                else{
                        //맨 위가 arr값 보다 작으면 같을떄까지 넣기 없으면 no
                        if(stack.peek() < arr[i]){
                                while(!storeStack.isEmpty()){
                                        sb.append("+\n")
                                        stack.push(storeStack.pop())
                                        if(arr[i] == stack.peek()) break;
                                        if(!checkEmpty(storeStack)) return;
                                }
                        }
                        //맨 위가 arr값 보다 크면 같을떄까지 빼기 없으면 no
                        else if(stack.peek() > arr[i]){
                                while(!stack.isEmpty()){
                                        sb.append("-\n")
                                        stack.pop()
                                        if(i == stack.peek()) break;
                                        if(!checkEmpty(stack)) return;
                                }
                        }
                }

                //맨위 같으면 pop
                if(!stack.isEmpty() && stack.peek() == arr[i]){
                        sb.append("-\n")
                        stack.pop()
                }else{
                        println("NO")
                        return
                }
        }
        print(sb)
}

fun checkEmpty(stack: Stack<Int>):Boolean{
        if(stack.isEmpty()){
                println("NO")
                return false
        }
        return true
}
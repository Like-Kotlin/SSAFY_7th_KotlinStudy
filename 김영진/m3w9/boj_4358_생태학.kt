//https://www.acmicpc.net/problem/4358

//1. TreeMap

// O(logN*logN) - TreeMap
//get에 logN
//insert에 logN
// import java.util.*

// val br = System.`in`.bufferedReader()
// fun main() = with(System.out.bufferedWriter()){

//     val map = TreeMap<String, Double>()
//     var size=0
//     while(true){
//         val input = br.readLine() ?: break
//         map[input] = map.getOrDefault(input,0.0)+1
//         size++
//     }

//     map.forEach{
//         write("${it.key} ${String.format("%.4f",it.value/size*100)}\n")
//     }

//     close()
//}


//2. Trie + TreeSet

//길이 : L
//문자열의 수 : M
//O(M*L) - Trie
//TreeSet 삽입 O(logN)
//문제 시간 복잡도 O(M*L)
import java.util.*

val br = System.`in`.bufferedReader()

class Trie(var cnt: Int, val node: MutableMap<Char, Trie>){

    fun insert(word: String){
        var children: Trie = this
        for(ch in word){
            //노드에 ch엣지가 연결되어 있으면 이동
            if(children.node.containsKey(ch)){
                children = children.node[ch]!!
            }
            //엣지가 연결되어 있지 않으면 새로 생성 후 연결
            else{
                children.node[ch] = Trie(0, mutableMapOf())
                children = children.node[ch]!!
            }
        }
        //단어의 끝에 카운팅
        children.cnt++
    }

    fun getCount(word: String): Int{
        var children = this
        //무조건 있을겨
        for(ch in word){
            children = children.node[ch]!!
        }
        return children.cnt
    }

}

fun main() = with(System.out.bufferedWriter()){

    val root = Trie(0, mutableMapOf())
    val treeSet = TreeSet<String>()
    var size=0

    while(true){
        val input = br.readLine() ?: break
        root.insert(input)
        treeSet.add(input)
        size++
    }

    for(set in treeSet) {
        write("$set ${String.format("%.4f", root.getCount(set).toDouble()/size*100)}\n")
    }

    close()
}

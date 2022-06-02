class Solution{

    fun solution(s:String):Int{
        var answer = s.length

        if(s.length == 1){
            return 1;
        }

        //전체 길이가  /2만큼만 같은지 비교 가능
        for(i in 1..s.length/2){
            var tmpAnswer = ""

            var cur = s.substring(0,i)
            var sub_s = s.substring(i,s.length)
            var cnt = 1

            while(true){
                //자를 글자 없으면 기존거 추가
                if(sub_s.length < i){
                    tmpAnswer += if(cnt == 1){
                        cur+sub_s
                    }else{
                        cnt.toString() + cur + sub_s
                    }
                    break
                }

                //다음 글자가 cur과 같다면 압축
                if(sub_s.substring(0,i).equals(cur)){
                    cnt++
                }
                //다음 그랒가 cur과 다르다면
                else{
                    tmpAnswer += if(cnt==1) cur else cnt.toString() + cur
                    cur = sub_s.substring(0,i)
                    cnt = 1
                }
                sub_s = sub_s.substring(i, sub_s.length)
            }

            //압축된 글자 길이가 기존 길이보다 짧다면 answer
            answer = Math.min(tmpAnswer.length, answer)
        }

        return answer
    }
}
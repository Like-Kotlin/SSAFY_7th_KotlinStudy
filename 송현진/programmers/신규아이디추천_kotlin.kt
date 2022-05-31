class Solution{
    //정규식 사용한 다른 풀이

    // 1단계 new_id의 모든 대문자 -> 소문자
    fun solution(newId: String) = newId.toLowerCase()
        //2단계 : new_id에서 알파벳소문자, 숫자, 빼기, 밑줄, 마침표 제외한 모든 문자 제거
        .filter{it.isLowerCase() || it.isDigit() || it=='-' || it=='.'}
        //3단계 : new_id에서 마침표가 2번이상 연속된 부분을 하나의 마침표로 치환
        // [xy] -> 문자선택을 표현하고, x와 y중 하나 의미 (하나는 무조건 선택)
        // * -> 반복여부 표현하고 x문자가 0번 or 그 이상 반복됨을 의미.
        .replace("[.]*[.]".toRegex(), ".")
        //4단계 : new_id에서 마침표가 처음이나 끝에 위치한다면 제거
        //removePrefix -> 가장 앞이 .이면 삭제
        //removeSuffix -> 가장 마지막이 . 이면 삭제
        .removePrefix(".").removeSuffix(".")
        //5단계 : new_id가 빈 문자열이면, new_id에 "a" 대입
        .let{if (it.isEmpty()) "a" else it}
        //6단계 : new_id 길이가 16자 이상이면 , new_id의 첫 15개 문자 제외한 나머지 문자 제거
        //만약 제거 후 마침표가 new_id끝에 위치시 끝에 위치한 마침표 제거
        .let{if (it.length > 15) it.substring(0 until 15) else it}.removeSuffix(".")
        //7단계 : new_id 길이가 2자 이하면, new_id의 마지막 문자를 new_id의 길이가 3이 될때까지 반복해서 끝에 붙임.
        .let{
            if(it.length <= 2)
                StringBuilder(it).run{
                    while(length<3) append(it.last())
                    toString()
                }
            else it
        }
}
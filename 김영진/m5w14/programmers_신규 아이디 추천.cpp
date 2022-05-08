//https://programmers.co.kr/learn/courses/30/lessons/72410
#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(string new_id) {
 	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);




		cin >> new_id;
		string answer = "";
		//1단계,2단계
		for (int i = 0; i < new_id.length(); i++) {
			new_id[i]=	tolower(new_id[i]);
			if (new_id[i] == '-' || new_id[i] == '_' || new_id[i] == '.' || (new_id[i] >= '0'&& new_id[i] <= '9') || (new_id[i] >= 'a'&&new_id[i] <= 'z')) {
				answer += new_id[i];
			}
		}



		//3단계
		while (answer.find("..") != string::npos) {
			int index = answer.find("..");
			answer.erase(answer.begin() + index + 1);

		}

		//4단계
		if (answer[0] == '.') {
			answer.erase(answer.begin());
		}
		if (answer.length() > 0) {
			if (answer[answer.length() - 1]=='.') {
				answer.erase(answer.length() - 1);
			}
		}

		//5단계
		
		if (answer.length() == 0) {
			answer += 'a';
		}

		//6단계
		if (answer.length() > 15) {
			answer = answer.substr(0, 15);
			if(answer[answer.length()-1]=='.')
				answer = answer.substr(0, 14);
		}

		//7단계

		while(answer.length() <= 2) {
			answer += answer[answer.length() - 1];
		}
		
	return answer;
}

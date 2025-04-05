#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main()
{
	int T, cnt, score, tmp = 1;
	char ox[80];
	scanf("%d", &T);

	for (int i = 0; i < T; i++) {
		score = cnt = 0;
		tmp = 1;
		scanf("%s", ox);
		while (ox[cnt] == 'O' || ox[cnt] == 'X') 
			cnt++;
		for (int i = 0; i < cnt; i++) {
			if (ox[i] == 'O')
				score = score + tmp;
			else
				tmp = 0;
			tmp++;
		}
		printf("%d\n", score);
    }
}
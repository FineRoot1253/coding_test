package basic_mathematics_2;

import java.util.ArrayList;
import java.util.Scanner;

public class IsPrimeWithEratos {
    public static void main(String[] arg){
        // ArrayList로 구현
        ArrayList<Boolean> primeList;

        // 사용자로부터의 콘솔 입력
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        // n <= 1 일 때 종료
        if(n <= 1) return;

        // n+1만큼 할당
        primeList = new ArrayList<Boolean>(n+1);
        // 0번째와 1번째를 소수 아님으로 처리
        primeList.add(false);
        primeList.add(false);
        // 2~ n 까지 소수로 설정
        for(int i=2; i<=n; i++ )
            primeList.add(i, true);

        // 2 부터  ~ i*i <= n
        // 각각의 배수들을 지워간다.
        for(int i=2; (i*i)<=n; i++){
            if(primeList.get(i)){
                // j는 i의 배수로 초기화하여 1회 반복당 j는 i의 각 배수를 순회하는 것과 같이 커진다.
                // j가 n보다 초과 될 경우 탈출
                // 즉, n만큼 i의 배수를 순회하는 로직이다.
                for(int j = i*i; j<=n; j+=i) {
                    primeList.set(j, false);
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        for(int i=0; i<=n; i++){
            if(primeList.get(i)){
                sb.append(i);
                sb.append(",");
            }
        }
        sb.setCharAt(sb.length()-1, '}');

        System.out.println(sb.toString());
    }
}

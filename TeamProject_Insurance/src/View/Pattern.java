package View;
import java.util.Scanner;

public class Pattern {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
	
		/*
		String pwPattern = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,15}$";
	    String Num="^[0-9]{3,10}$";
	    String kk = scanner.next();
	    boolean regex1 = Pattern.matches(pwPattern,kk); // 검증1
	    if(regex1==false) {System.out.println("입력할수없다");}
	    if(regex1) {System.out.println("입력성공");}
	    //비밀번호 길이10개 영어 대소문자 숫자 
		*/
	    
		// 정규표현식 숫자,영문,한글 : ^[ 추가할내용 ]*$
	    // { } : 횟수 또는 범위
	    // ( ) : 소괄호 안의 문자를 하나의 문자로 인식
	    // [ ] : 문자의 집합이나 범위, 두 문자의 사이에는 - 기호로 범위 나타냄 ex [1-10] : 1부터 10까지
	    // | : 패턴 안에서의 or 연산
	    // ^ : 문자열의 시작
	    // $ : 문자열의 끝
	    // ? 앞 문자가 없거나 하나 있음
	    
	    // 한글 : ^[가-힣]*$
	    // 영문자 : ^[a-zA-Z]*$
	    // 숫자 : ^[0-9]*$
	   
	    // 주민번호 : \d{6}\-[1-4]\d{6}$  : 앞 6자리, - 뒤 첫자리1~4만가능, 나머지 6자리
	    // 이메일 : \\w+@\\w+\\.\\w+(\\.\\w+)?
	    // 폰번호 :  ^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$ 
	    
	    // ^[?0|1|0|-\d{4}-\d{4}]$ --> 폰번호 010만 쓰려면 이렇게 하면 되나..?
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}

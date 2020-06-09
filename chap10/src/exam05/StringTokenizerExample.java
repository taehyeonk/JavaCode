package exam05;

import java.util.StringTokenizer;

public class StringTokenizerExample {
	public static void main(String[] args) {
		String text = "홍길동/이수홍/박연수";
		
		StringTokenizer st = new StringTokenizer(text, "/");
		
		int countToken = st.countTokens();
		
		for(int i=0; i<countToken; i++) {
			String token = st.nextToken();
			System.out.println(token);
		}
	}
}

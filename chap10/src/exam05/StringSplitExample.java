package exam05;

import java.util.StringTokenizer;

public class StringSplitExample {
	public static void main(String[] args) {
		String s = "홍길동/이수홍/박연수/김자바/최명호";
		
		String[] result = "홍길동&이수홍,박연수,김자바-최명호".split("&|,|-");
		
		for(String s1:result) {
			System.out.println(s1);
		}
		
		StringTokenizer st = new StringTokenizer(s, "/");
	}
}

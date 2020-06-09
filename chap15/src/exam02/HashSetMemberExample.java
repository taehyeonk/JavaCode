package exam02;

import java.util.HashSet;
import java.util.Set;

public class HashSetMemberExample {
	public static void main(String[] args) {
		Member m1 = new Member("홍길동", 34);
		Member m2 = new Member("홍길동", 34);
		Member m3 = new Member("홍길동", 33);
		Member m4 = new Member("김나리", 20);
		
		System.out.println(m1.hashCode());
		System.out.println(m2.hashCode());
		System.out.println(m3.hashCode());
		System.out.println(m4.hashCode());
		
		Set<Member> set = new HashSet<>();
		set.add(m1);
		set.add(m2);
		set.add(m3);
		set.add(m4);
		
		for(Member m:set) {
			System.out.println(m.toString());
		}
	}
}
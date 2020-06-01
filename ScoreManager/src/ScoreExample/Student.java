package ScoreExample;

public class Student {
	String name;
	int id;
	String phone_num;
	
	double kor;
	double eng;
	double math;
	
	static int num = 0;
	
	
	
	public Student() {
		name = "홍길동";
		id = ++num;
		phone_num = "123-1234-1234";
		
		kor = eng = math = 0;
	}
	
	public Student(String name, String phone_num, double kor, double eng, double math) {
		super();
		this.name = name;
		id = ++num;
		this.phone_num = phone_num;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}


	void set_score(double kor, double eng, double math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	double get_score(String subject) {
		double result = 0;
		
		if(subject.equals("국어")) {
			result = kor;
		}
		else if(subject.equals("영어")) {
			result = eng;
		}
		else if(subject.equals("수학")) {
			result = math;
		}
		return result;
	}
	
	double get_student_total() {
		return kor+eng+math;
	}
	
	String get_name() {
		return name;
	}
}

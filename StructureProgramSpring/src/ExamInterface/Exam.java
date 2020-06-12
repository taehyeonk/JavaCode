package ExamInterface;

import java.util.Date;

public class Exam {
	public Subject subject; // Data Class화
	
	private int seq;
	private String title;
	private Date regDate;	
	
	public Exam() {
		subject = new Subject();
	}

	public int getKor() {
		return subject.getKor();
	}

	public void setKor(int kor) {
		subject.setKor(0);
		if(kor >= 0 || kor <= 100)
			subject.setKor(kor);
	}

	public int getEng() {
		return subject.getEng();
	}

	public void setEng(int eng) {
		subject.setEng(0);
		if(eng >= 0 || eng <= 100)
			subject.setEng(eng);
	}

	public int getMath() {
		return subject.getMath();
	}

	public void setMath(int math) {
		subject.setMath(0);
		if(math >= 0 || math <= 100)
			subject.setMath(math);
	}

	public int getTotal() {
		return getKor() + getEng() + getMath();
	}

	public float getEvg() {
		return getTotal() / 3.0f;
	}
	

//	public boolean checkScore() {
//		
//	}
}
package UIExam;

public class ExamList {
	private Exam[] exams;
	private int current;
	
	public ExamList() {
		this(new Exam[3], 0); // 생성자에서 생성자 호출은 this();로 가능
	}

	public ExamList(Exam[] exams, int current) {
		this.exams = exams;
		this.current = current;
	}

	public int getCurrent() {
		return current;
	}	

	public Exam get(int i) {
		return exams[i];
	}

	public void add(Exam exam) {
		if(exams.length >= current) {
			Exam[] temp = new Exam[current + 3];
			for(int i=0; i<current; i++) {
				temp[i] = exams[i];
			}
			exams = temp;
		}
		exams[current] = exam;
		current++;
	}
}
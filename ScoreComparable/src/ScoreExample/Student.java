package ScoreExample;

public class Student implements Comparable<Student>{
	private int id;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private double avg;

	public Student(int id, String name, int kor, int eng, int math) {
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
		this.total = kor + eng + math;
		this.avg = (kor + eng + math) / 3.0;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", total="
				+ total + ", avg=" + avg + "]";
	}

	@Override
	public int compareTo(Student o) {
		return total - o.total;
	}	
}

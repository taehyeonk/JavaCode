package DI.entity;

public class AiExam implements Exam {
	private int nlp;
	private int ml;
	private int dl;
	
	public AiExam() {
		nlp = 0;
		ml = 0;
		dl = 0;
	}

	public AiExam(int nlp, int ml, int dl) {
		this.nlp = nlp;
		this.ml = ml;
		this.dl = dl;
	}

	@Override
	public int getTotal() {
		return nlp + ml + dl;
	}
}

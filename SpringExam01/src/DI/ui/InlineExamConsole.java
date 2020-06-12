package DI.ui;

import DI.entity.Exam;

public class InlineExamConsole implements ExamConsole {
	private Exam exam;

	@Override
	public void print() {
		System.out.println("Total is " + exam.getTotal());
		
	}

	@Override
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	
	
}

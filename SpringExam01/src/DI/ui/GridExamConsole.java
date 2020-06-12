package DI.ui;

import DI.entity.Exam;

public class GridExamConsole implements ExamConsole {
	private Exam exam;

	@Override
	public void print() {
		System.out.println("┌───────────────────────────┐");
		System.out.printf("│        Total is %d         │\n", exam.getTotal());
		System.out.println("└───────────────────────────┘");		
	}

	@Override
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	
	
}

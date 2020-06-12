package DI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import DI.ui.ExamConsole;
import DI.ui.InlineExamConsole;
import DI.entity.AiExam;
import DI.entity.Exam;

public class DIProgram {

	public static void main(String[] args) {
//		Exam exam = new AiExam(10, 10, 10);
//		ExamConsole console = new InlineExamConsole();
//		console.setExam(exam);
		ApplicationContext context = new ClassPathXmlApplicationContext("DI/spring_di.xml");
		ExamConsole console = (ExamConsole)context.getBean("console"); // object로 반환하기때문에 ExamConsole로 type Casting
		console.print();
	}

}

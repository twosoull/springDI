package spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import spring.di.entity.Exam;

@Component("console")
public class InlineExamConsole implements ExamConsole {
	
	@Autowired
	private Exam exam;
	
	public InlineExamConsole() {
		System.out.println("constructor");
	}
	
	public InlineExamConsole(Exam exam) {
		System.out.println("constructor overload");
		this.exam = exam;
	}



	@Override
	public void print() {
		if(exam ==null) {
		System.out.printf("null");
		}else {
			System.out.printf("total is %d, avg is %f\n",exam.total(),exam.avg());
		}
		
	}
	
	
	@Override
	public void setExam(Exam exam) {
		System.out.println("setter");
		// TODO Auto-generated method stub
		this.exam = exam;
	}

}

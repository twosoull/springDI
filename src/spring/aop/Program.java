package spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.aop.entity.Exam;
import spring.aop.entity.NewlecExam;
import spring.di.NewlecDIConfig;

public class Program {
	
	public static void main(String[] args) {
		
		
		ApplicationContext context = 
				//new AnnotationConfigApplicationContext(NewlecDIConfig.class);
				new ClassPathXmlApplicationContext("spring/aop/setting.xml");
	
		Exam exam = (Exam) context.getBean("exam");
		
		System.out.println("total is " +exam.total());
		System.out.println("avg is " +exam.avg());
		
		/*
		Exam proxy = (Exam) Proxy.newProxyInstance(
				NewlecExam.class.getClassLoader(), new Class[] {Exam.class} ,new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				
				 
				long start = System.currentTimeMillis();
				
				Object result = method.invoke(exam, args);
			
				long end = System.currentTimeMillis();
				
				String message = (end - start) + "ms 시간이 걸렸습니다";
				System.out.println(message);
				
				
				
				
				return result;
			}
		});
		System.out.println("total is " +proxy.total());
		System.out.println("total is " +proxy.avg());
		 */
	}
}

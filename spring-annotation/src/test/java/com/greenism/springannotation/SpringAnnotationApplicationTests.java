package com.greenism.springannotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import com.greenism.springannotation.annotation.MyAnnotation;
import com.greenism.springannotation.bean.MyAnnotationTest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringAnnotationApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	void testMyAnnotation() throws Exception {
		Class<MyAnnotationTest> mClass = MyAnnotationTest.class;
		Annotation[] annotations = mClass.getAnnotations();
		for(Annotation annotation:annotations){
			System.out.println("====================>"+annotation.annotationType().getName());
		}
		Method method = mClass.getMethod("hello", new Class[] {});
 
		// hello() 方法上是否有 MyAnnotation 注解
		if (method.isAnnotationPresent(MyAnnotation.class)) {
 
			// 获得注解
			MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
 
			// 获取注解的内容
			System.out.println(annotation.name());
 
		}
		System.out.println("ok");
	}
}

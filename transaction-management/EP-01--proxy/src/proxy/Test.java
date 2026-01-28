package proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

        // how to load a class in java
        // 1
        Class<?> studentInfo = Class.forName("proxy.Student");
        Constructor<?>[] constructors = studentInfo.getConstructors();

        for(Constructor constructor : constructors){
//            System.out.println(constructor);
        }

        Method[] declaredMethods = studentInfo.getDeclaredMethods();

        for(Method method : declaredMethods){
//            System.out.println(method);
        }

        Student student = (Student) studentInfo.newInstance();

        Class[] methodArgsType =  new Class[] {Integer.class};
        Method method = studentInfo.getDeclaredMethod("attendLesson", methodArgsType);
        method.invoke(student, 101);



        //2
//        Class<Student> studentClass = Student.class;

        //3
//        Student student = new Student();
//        Class<? extends Student> aClass = student.getClass();

    }
}

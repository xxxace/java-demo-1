import com.ace.service.AnnotationTestService;
import com.ace.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class ApplicationContextTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

//        UserService userService = (UserService) applicationContext.getBean("userService");
        UserService userService2 = (UserService) applicationContext.getBean("userService2");
        AnnotationTestService annotationTestService = (AnnotationTestService) applicationContext.getBean("annotationTestService");

        System.out.println(annotationTestService);
        userService2.hello("userService2");
        userService2.userDaoSayHello("i'm userDao");
    }
}

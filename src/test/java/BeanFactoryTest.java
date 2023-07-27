import com.ace.dao.UserDao;
import com.ace.service.UserService;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class BeanFactoryTest {
    public static void main(String[] args) {
        // 创建工厂对象
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 创建一个读取器
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        // 读取配置文件给工厂
        xmlBeanDefinitionReader.loadBeanDefinitions("beans.xml");

        // 根据id获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        System.out.println(userService);
        userService.hello("ace");

        // 根据id获取bean
        UserDao userDao = (UserDao) beanFactory.getBean("userDao");
        System.out.println(userDao);
    }
}

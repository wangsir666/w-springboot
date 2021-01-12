import com.magic.aop.Calculator;
import com.magic.aop.MyCalculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @auther: wjx
 * @Date: 2020/11/14 20:23
 * @Description:
 */
public class AopTest {

    @Test
    public void test(){
        MyCalculator calculator = new MyCalculator();
        System.out.println(calculator.subtraction(3, 2));
    }
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Calculator calculator = context.getBean(MyCalculator.class);
        System.out.println(calculator.subtraction(20, 1));
    }
}

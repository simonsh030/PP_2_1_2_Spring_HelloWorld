import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // вызываем бин HelloWorld
        HelloWorld bean1 = (HelloWorld) applicationContext.getBean("helloworld");
        System.out.println(bean1.getMessage());

        // вызываем бин cat 2 раза и сравниваем их ссылки
        Cat cat1 = (Cat) applicationContext.getBean("cat");
        Cat cat2 = (Cat) applicationContext.getBean("cat");
        System.out.println("cat1 == cat2 : " + (cat1 == cat2)); // должно вернуться false

        // вызываем бин HelloWorld еще раз и сравниваем ссылки
        HelloWorld bean2 = (HelloWorld) applicationContext.getBean("helloworld");
        System.out.println("bean1 == bean2 : " + (bean1 == bean2)); // должно вернуться true
    }
}
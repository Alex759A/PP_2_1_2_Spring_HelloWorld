import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        // передача в аргументы (нового объекта класса ApplicationContext)--> класса с аннотац  @Configuration
        ApplicationContext applicationContext =                        // который содержит бины
                new AnnotationConfigApplicationContext(AppConfig.class);
        // получение бина из (applicationContext)--с указанием имени бина в аргументах + каст до класса содерж в бине
        HelloWorld bean =
                (HelloWorld) applicationContext.getBean("helloworld");
        HelloWorld bean_1 =
                (HelloWorld) applicationContext.getBean("helloworld");

        Cat catBean = (Cat) applicationContext.getBean("cat");
        Cat catBean_1 = (Cat) applicationContext.getBean("cat");

        System.out.println(bean);
        System.out.println(bean_1);
        System.out.println(bean==bean_1);

        System.out.println(catBean);
        System.out.println(catBean_1);
        System.out.println(catBean==catBean_1);


    }
}

/*
Всего 3 класса и одна зависимость.
Класс App содержит метод main, который запускает Спринг при создании контекста. В контекст мы передаем класс AppConfig,
который помечен аннотацией @Configuration - так Спринг понимает, что это настроечный класс.
В классе AppConfig содержится метод, помеченный аннотацией как бин, этот метод будет выполнен при запуске и его результат
станет объектом, управляемым Спрингом.
Класс HelloWorld является обычным Java-классом, мы его используем без каких-либо сложностей.
В методе main мы можем получить бин HelloWorld по имени и использовать в любом месте программы.
Спринг позволяет использовать различные типы бинов, одни будут жить от старта до завершения программы, другие будут
 создаваться при каждом запросе или открытии новой сессии, третьи при каждом вызове будут создаваться новые. За это
 отвечает аннотация @Scope.

Задание:
1. Прочитайте про виды бинов.
2. Создайте POJO-класс Cat.
3. В классе AppConfig, по аналогии, создайте бин с именем “cat”.
4. Настройте этот бин так, чтобы он создавался новым при каждом запросе.
5. В классе App, по аналогии, вызовите еще раз бин HelloWorld, затем 2 раза вызовите бин cat. Сравните 2 пары бинов
по ссылке и выведите результат в консоль. Для пары HelloWorld должно вернуться true, для cat - false. Так вы можете
 увидеть результат того, как работает наш контейнер.
6. Раскомментируйте тестовый класс и проверьте своё решение.


 */
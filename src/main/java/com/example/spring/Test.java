package com.example.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {


    public static void main(String[] args) {
        /***
         *     //根据参数类型可以知道，其实可以传入多个annotatedClasses，但是这种情况出现的比较少
         *     public AnnotationConfigApplicationContext(Class<?>... annotatedClasses) {
         *         //调用无参构造函数，会先调用父类GenericApplicationContext的构造函数
         *         //父类的构造函数里面就是初始化DefaultListableBeanFactory，并且赋值给beanFactory
         *         //本类的构造函数里面，初始化了一个读取器：AnnotatedBeanDefinitionReader read，一个扫描器ClassPathBeanDefinitionScanner scanner
         *         //scanner的用处不是很大，它仅仅是在我们外部手动调用 .scan 等方法才有用，常规方式是不会用到scanner对象的
         *         this();
         *         //把传入的类进行注册，这里有两个情况，
         *         //传入传统的配置类
         *         //传入bean（虽然一般没有人会这么做
         *         //看到后面会知道spring把传统的带上@Configuration的配置类称之为FULL配置类，不带@Configuration的称之为Lite配置类
         *         //但是我们这里先把带上@Configuration的配置类称之为传统配置类，不带的称之为普通bean
         *         register(annotatedClasses);
         *         //刷新
         *         refresh();
         *     }
         */
        /***              中的前两行代码，回顾下，这两行代码，主要是把我们的配置类和内置的几个后置处理器放到了两个集合中：
         *                 //beanDefinitionMap是Map<String, BeanDefinition>，
         *                 //这里就是把beanName作为key，beanDefinition作为value，推到map里面
         *                 this.beanDefinitionMap.put(beanName, beanDefinition);
         *
         *                 //beanDefinitionNames就是一个List<String>,这里就是把beanName放到List中去
         *                 this.beanDefinitionNames.add(beanName);
         */
        AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
//        //把我们的这个类 注册到Spring的beanMap中去
//        annotationConfigApplicationContext.register(AppConfig.class);
//        //
//        annotationConfigApplicationContext.refresh();

        System.out.println("========="+annotationConfigApplicationContext.getBean(User.class).hashCode());
        System.out.println("========="+annotationConfigApplicationContext.getBean(Application.class).hashCode());
//        IndexDao indexDao=annotationConfigApplicationContext.getBean(IndexDao.class);
//        indexDao.query();

    }

}

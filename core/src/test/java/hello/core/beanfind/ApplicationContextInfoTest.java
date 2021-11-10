package hello.core.beanfind;

import hello.core.order.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
            Object bean = applicationContext.getBean(beanDefinitionName);
            System.out.println("beanDefinitionName = " + beanDefinitionName + " object = " + bean);

        }

    }@Test
    @DisplayName("app bean 출력하기")
    void findAplicationBean(){
        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
            BeanDefinition beanDefinition = applicationContext.getBeanDefinition(beanDefinitionName);

            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION)
            {
                Object bean = applicationContext.getBean(beanDefinitionName);
                System.out.println("beanDefinitionName = " + beanDefinitionName + " object = " + bean);
            }
        }

    }

}

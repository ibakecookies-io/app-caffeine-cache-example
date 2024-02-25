package io.ibakecookies;

import com.github.benmanes.caffeine.cache.Caffeine;
import io.ibakecookies.cache.example.CaffeineCacheExampleApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(classes = CaffeineCacheExampleApplication.class)
class CaffeineCacheExampleApplicationTests {

    @Test
    void contextLoads(ApplicationContext applicationContext) {
        System.out.println(applicationContext.getApplicationName());
        Arrays.stream(applicationContext.getBeanDefinitionNames())
                .sequential().forEach(
                        System.out::println
                );
    }

    @Test
    void getCaffeineBeanTest(ApplicationContext context) {
        assertThat(context.getBean(Caffeine.class)).isNotNull();
        System.out.println(context.getBean(Caffeine.class));
    }


    @Test
    void getCachedManagerBeanTest(ApplicationContext context) {
        assertThat(context.getBean(CacheManager.class)).isNotNull();
    }

}

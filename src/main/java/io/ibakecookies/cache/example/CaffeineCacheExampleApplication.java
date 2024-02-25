package io.ibakecookies.cache.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@Configuration
@EnableCaching
public class CaffeineCacheExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(CaffeineCacheExampleApplication.class, args);
    }

    @Bean
    public Caffeine configCaffeine (){
        return Caffeine.newBuilder()
                .expireAfterWrite(10, TimeUnit.SECONDS);
    }

    @Bean
    public CacheManager cacheManager (Caffeine caffeine){
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager("person_cache", "persons_cache");
        caffeineCacheManager.setCaffeine(caffeine);
        return caffeineCacheManager;
    }

}

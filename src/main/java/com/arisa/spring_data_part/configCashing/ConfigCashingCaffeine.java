package com.arisa.spring_data_part.configCashing;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class ConfigCashingCaffeine {

    public CacheManager cacheManager(){
        CaffeineCacheManager caffeineCacheManager=new CaffeineCacheManager("categoryCache");
        caffeineCacheManager.setCaffeine(caffeineCacheBuilder());
        return caffeineCacheManager;

    }

    Caffeine<Object, Object> caffeineCacheBuilder() {
        return Caffeine.newBuilder()
                .initialCapacity(512)
                .maximumSize(2048)
                .expireAfterAccess(480, TimeUnit.MINUTES)
                .weakKeys()
                .recordStats();
    }}

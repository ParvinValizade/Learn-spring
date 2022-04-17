package com.company.redisapp.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheService {

    @Cacheable(cacheNames = "mySpecialCache")
    public String longRunnigMethod() throws InterruptedException {
        Thread.sleep(5000L);
        return "The method worked";
    }

    @CacheEvict(cacheNames = "mySpecialCache")
    public void clearCache() {
        System.out.println("Cache cleared");
    }

}

//package com.argus.ems.master.service.impl.rest.caching;
//import java.util.Arrays;
//import org.springframework.cache.Cache;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cache.concurrent.ConcurrentMapCache;
//import org.springframework.cache.interceptor.CacheErrorHandler;
//import org.springframework.cache.interceptor.CacheResolver;
//import org.springframework.cache.interceptor.KeyGenerator;
//import org.springframework.cache.interceptor.SimpleCacheErrorHandler;
//import org.springframework.cache.interceptor.SimpleCacheResolver;
//import org.springframework.cache.interceptor.SimpleKeyGenerator;
//import org.springframework.cache.support.SimpleCacheManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@EnableCaching
//public class CachingConfig extends CachingConfigurerSupport {
//
//    @Bean
//    @Override
//    public CacheManager cacheManager() {
//        SimpleCacheManager cacheManager = new SimpleCacheManager();
//
//        // Create cache1
//        Cache cache1 = new ConcurrentMapCache("state");
//
//        // Create cache2
//        Cache cache2 = new ConcurrentMapCache("type");
//
//        // Set the caches in the cache manager
//        cacheManager.setCaches(Arrays.asList(cache1, cache2));
//
//        return cacheManager;
//    }
//
//    @Override
//    public CacheResolver cacheResolver() {
//        return new SimpleCacheResolver(cacheManager());
//    }
//
//    @Override
//    public KeyGenerator keyGenerator() {
//        return new SimpleKeyGenerator();
//    }
//
//    @Bean
//    @Override
//    public CacheErrorHandler errorHandler() {
//        return new SimpleCacheErrorHandler();
//    }
//}
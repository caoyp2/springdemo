package com.ittest.springdemo.service;

import com.ittest.springdemo.entities.Provider;
import com.ittest.springdemo.mybatis.mapper.ProviderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {

    @Autowired
    ProviderMapper providerMapper;

    public List<Provider> getAll(String providername){
        Provider p = new Provider();
        p.setProviderName(providername);
        return providerMapper.getProvidersAll(p);
    }

    @Cacheable(cacheNames = "provider",key = "#pid")
    public Provider getProviderByPid(Integer pid){
        return providerMapper.getProviderByPid(pid);
    }

    public int addProvider(Provider provider){
        return  providerMapper.addProvider(provider);
    }

    @CachePut(cacheNames = "provider",key = "#provider.pid")
    public Provider updateProvider(Provider provider){
        providerMapper.updateProvider(provider);
        return provider;  //这里返回对象为provider而不是返回int是因为要和@Cacheable缓存的对象一致，不然更新后会报错
    }

    @CacheEvict(cacheNames = "provider",key = "#pid")
    public int deleteProviderBypid(Integer pid){
        return providerMapper.deleteProviderByPid(pid);
    }
}

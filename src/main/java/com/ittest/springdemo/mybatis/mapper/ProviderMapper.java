package com.ittest.springdemo.mybatis.mapper;

import com.ittest.springdemo.entities.Provider;
import com.ittest.springdemo.entities.QueryProvider;
import com.ittest.springdemo.entities.User;

import java.util.List;

public interface ProviderMapper {

    Provider getProviderByPid(Integer pid);

    List<Provider> getProvidersAll(Provider provider);

    int addProvider(Provider provider);

    int updateProvider(Provider provider);

    int deleteProviderByPid(Integer pid);

    List<Provider> getProviderByIdList1(QueryProvider queryProvider);

    List<Provider> getProviderByIdList2(List<Integer> ids);

    List<Provider> getProviderBills();
}

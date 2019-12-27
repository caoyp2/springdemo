package com.ittest.springdemo.entities;

import java.io.Serializable;
import java.util.List;

public class QueryProvider implements Serializable {

    private Provider provider;

    private List<Integer> idlist;

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public List<Integer> getIdlist() {
        return idlist;
    }

    public void setIdlist(List<Integer> idlist) {
        this.idlist = idlist;
    }
}

package com.ittest.springdemo.controller;

import com.ittest.springdemo.entities.Bill;
import com.ittest.springdemo.entities.Provider;
import com.ittest.springdemo.mybatis.mapper.BillMapper;
import com.ittest.springdemo.mybatis.mapper.ProviderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Map;

@Controller
public class BillController {

    @Autowired
    BillMapper billMapper;

    @Autowired
    ProviderMapper providerMapper;


    @GetMapping("/bills")
    public String getBills(Map<String,Object> map,Bill bill){
        Provider provider = new Provider();
        List<Bill> bills = billMapper.getBills(bill);
        map.put("bills",bills);
        map.put("billName",bill.getBillName());
        map.put("pay",bill.getPay());
        map.put("pid",bill.getPid());

        List<Provider> providers = providerMapper.getProvidersAll(provider);
        map.put("providers",providers);

        return "bill/list";
    }

    @GetMapping("/bill/{bid}")
    public String getBillByBid(@PathVariable("bid") Integer bid,
                               @RequestParam(value = "type",defaultValue = "view") String type,
                               Map<String,Object> map){
        Bill bill = billMapper.getBillByBid(bid);
        Provider provider = new Provider();
        List<Provider> providers = providerMapper.getProvidersAll(provider);
        map.put("providers",providers);
        map.put("bill",bill);

        return "bill/" + type;
    }

    @GetMapping("/bill")
    public String toBill(Map<String,Object> map){
        Provider provider = new Provider();
        List<Provider> providers = providerMapper.getProvidersAll(provider);
        map.put("providers",providers);
        return "bill/add";
    }

    @PostMapping("/bill")
    public String addBill(Map<String,Object> map,Bill bill){
        billMapper.addBill(bill);
        return "redirect:/bills";
    }

    @PutMapping("/bill")
    public String updateBill(Map<String,Object> map,Bill bill){
        billMapper.updateBill(bill);
        return "redirect:/bills";
    }

    @DeleteMapping("/bill/{bid}")
    public String deleteBill(Map<String,Object> map,
                             @PathVariable("bid") Integer bid){
        billMapper.deleteBillByBid(bid);
        return "redirect:/bills";
    }

}

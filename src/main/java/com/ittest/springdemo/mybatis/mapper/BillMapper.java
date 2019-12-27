package com.ittest.springdemo.mybatis.mapper;

import com.ittest.springdemo.entities.Bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BillMapper {

    Bill getBillByBid(@Param("bid") Integer bid);

    List<Bill> getBills(Bill bill);

    int addBill(Bill bill);

    int deleteBillByBid(Integer bid);

    int updateBill(Bill bill);
}

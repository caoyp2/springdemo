package com.ittest.springdemo.mybatis.mapper;

import com.ittest.springdemo.entities.Bill;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 使用mybatis注解版
 *
 */
public interface BillConfigurationMapper {

    @Select("select * from bill where bid = #{bid}")
    Bill getBill(Integer bid);

    @Insert("insert into bill(bill_code,bill_name) values(#{billCode},#{billName})")
    int addBill(Bill bill);

    @Delete("delete from bill where bid = #{bid}")
    int deleteBillBybid(Integer bid);

    @Update("update bill set bill_code=#{billCode},bill_name=#{billName},bill_com=#{billCom},bill_num=#{billNum},money=#{money},pay=#{pay}")
    int updateBill(Bill bill);

    @Select("select * from bill")
    List getAllBill();
}

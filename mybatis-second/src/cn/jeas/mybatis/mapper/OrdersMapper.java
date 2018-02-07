package cn.jeas.mybatis.mapper;

import java.util.List;

import cn.jeas.mybatis.pojo.Orders;

public interface OrdersMapper {
	
	
	List<Orders> queryOrderAll();
}

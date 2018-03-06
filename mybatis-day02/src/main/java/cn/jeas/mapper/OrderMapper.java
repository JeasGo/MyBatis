package cn.jeas.mapper;

import java.util.List;

import cn.jeas.pojo.Order;

public interface OrderMapper {
	
	
	Order  queryOrderWithUserByorderNumber(String orderNumber);

	Order queryOrderWithUserAndOrderDetailsByOrderNumber(String orderNumber);
	
	
}

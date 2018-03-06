package cn.jeas.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 订单表
 * 
 */
public class Order implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -205424465982133462L;

	private Integer id;

    private Long userId;

    private String orderNumber;
    
    private User user;
    
    private List<Orderdetail> orderDetails;

    public List<Orderdetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<Orderdetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", orderNumber=" + orderNumber + ", user=" + user
				+ ", orderDetails=" + orderDetails + "]";
	}

	
    
}

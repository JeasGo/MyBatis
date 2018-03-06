package cn.jeas.pojo;

import java.io.Serializable;

public class Orderdetail implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 9046599403510292963L;

	private Integer id;
    
    private Double totalPrice;
    
    private Integer status;
    
    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	@Override
	public String toString() {
		return "Orderdetail [id=" + id + ", totalPrice=" + totalPrice + ", status=" + status + "]";
	}

    
}

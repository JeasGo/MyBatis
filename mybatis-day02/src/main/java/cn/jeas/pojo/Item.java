package cn.jeas.pojo;

import java.io.Serializable;

/**
 * 商品表
 */
public class Item implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -9135246474723354516L;

	private Integer id;

    private String itemName;

    private Float itemPrice;

    private String itemDetail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Float itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemDetail() {
        return itemDetail;
    }

    public void setItemDetail(String itemDetail) {
        this.itemDetail = itemDetail;
    }

}

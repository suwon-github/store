package skhappydelivery;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="Store_table")
public class Store {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long storeId;
    private String storeName;
    private String storeAddress;
    private Long menuId;
    private String customerAddress;
    private Long orderId;
    private Integer menuCount;
    private Integer totalPrice;
    private String customerName;
    private Integer rejectCode;
    private String rejectDetail;
    private Long cookStatus;
    private Integer cancelCode;
    private Long cancelDetail;
    private String orderStatus;

    @PostPersist
    public void onPostPersist(){
        StoreOrderAccepted storeOrderAccepted = new StoreOrderAccepted();
        BeanUtils.copyProperties(this, storeOrderAccepted);
        storeOrderAccepted.publishAfterCommit();


        StoreOrderRejected storeOrderRejected = new StoreOrderRejected();
        BeanUtils.copyProperties(this, storeOrderRejected);
        storeOrderRejected.publishAfterCommit();


        StoreCooked storeCooked = new StoreCooked();
        BeanUtils.copyProperties(this, storeCooked);
        storeCooked.publishAfterCommit();


        StoreOrderCancelled storeOrderCancelled = new StoreOrderCancelled();
        BeanUtils.copyProperties(this, storeOrderCancelled);
        storeOrderCancelled.publishAfterCommit();


    }


    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }
    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public Integer getMenuCount() {
        return menuCount;
    }

    public void setMenuCount(Integer menuCount) {
        this.menuCount = menuCount;
    }
    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public Integer getRejectCode() {
        return rejectCode;
    }

    public void setRejectCode(Integer rejectCode) {
        this.rejectCode = rejectCode;
    }
    public String getRejectDetail() {
        return rejectDetail;
    }

    public void setRejectDetail(String rejectDetail) {
        this.rejectDetail = rejectDetail;
    }
    public Long getCookStatus() {
        return cookStatus;
    }

    public void setCookStatus(Long cookStatus) {
        this.cookStatus = cookStatus;
    }
    public Integer getCancelCode() {
        return cancelCode;
    }

    public void setCancelCode(Integer cancelCode) {
        this.cancelCode = cancelCode;
    }
    public Long getCancelDetail() {
        return cancelDetail;
    }

    public void setCancelDetail(Long cancelDetail) {
        this.cancelDetail = cancelDetail;
    }
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }




}

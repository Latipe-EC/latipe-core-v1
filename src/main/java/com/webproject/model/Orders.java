package com.webproject.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name="order")
public class Order {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "order_id", nullable = false)
    private int orderId;
    @Basic
    @Column(name = "user_id", nullable = false)
    private int userId;
    @Basic
    @Column(name = "store_id", nullable = false)
    private int storeId;
    @Basic
    @Column(name = "delivery_id", nullable = false)
    private int deliveryId;
    @Basic
    @Column(name = "address", nullable = false, length = 255)
    private String address;
    @Basic
    @Column(name = "phone", nullable = false, length = 10)
    private String phone;
    @Basic
    @Column(name = "status", nullable = false)
    private int status;
    @Basic
    @Column(name = "isPaidBefore", nullable = false)
    private boolean isPaidBefore;
    @Basic
    @Column(name = "amountFromUser", nullable = false, precision = 0)
    private double amountFromUser;
    @Basic
    @Column(name = "amountFromStore", nullable = false, precision = 0)
    private double amountFromStore;
    @Basic
    @Column(name = "amountToStore", nullable = false, precision = 0)
    private double amountToStore;
    @Basic
    @Column(name = "amountToGD", nullable = false, precision = 0)
    private double amountToGd;
    @Basic
    @Column(name = "createDate", nullable = false)
    private Date createDate;
    @Basic
    @Column(name = "updateDate", nullable = true)
    private Date updateDate;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false, insertable=false, updatable=false)
    private User userByUserId;
    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "store_id", nullable = false, insertable=false, updatable=false)
    private Store storeByStoreId;
    @ManyToOne
    @JoinColumn(name = "delivery_id", referencedColumnName = "delivery_id", nullable = false, insertable=false, updatable=false)
    private Delivery deliveryByDeliveryId;
    @OneToMany(mappedBy = "orderByOrderId")
    private Collection<OrderItems> orderItemsByOrderId;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isPaidBefore() {
        return isPaidBefore;
    }

    public void setPaidBefore(boolean paidBefore) {
        isPaidBefore = paidBefore;
    }

    public double getAmountFromUser() {
        return amountFromUser;
    }

    public void setAmountFromUser(double amountFromUser) {
        this.amountFromUser = amountFromUser;
    }

    public double getAmountFromStore() {
        return amountFromStore;
    }

    public void setAmountFromStore(double amountFromStore) {
        this.amountFromStore = amountFromStore;
    }

    public double getAmountToStore() {
        return amountToStore;
    }

    public void setAmountToStore(double amountToStore) {
        this.amountToStore = amountToStore;
    }

    public double getAmountToGd() {
        return amountToGd;
    }

    public void setAmountToGd(double amountToGd) {
        this.amountToGd = amountToGd;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId && userId == order.userId && storeId == order.storeId && deliveryId == order.deliveryId && status == order.status && isPaidBefore == order.isPaidBefore && Double.compare(order.amountFromUser, amountFromUser) == 0 && Double.compare(order.amountFromStore, amountFromStore) == 0 && Double.compare(order.amountToStore, amountToStore) == 0 && Double.compare(order.amountToGd, amountToGd) == 0 && Objects.equals(address, order.address) && Objects.equals(phone, order.phone) && Objects.equals(createDate, order.createDate) && Objects.equals(updateDate, order.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, userId, storeId, deliveryId, address, phone, status, isPaidBefore, amountFromUser, amountFromStore, amountToStore, amountToGd, createDate, updateDate);
    }

    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    public Store getStoreByStoreId() {
        return storeByStoreId;
    }

    public void setStoreByStoreId(Store storeByStoreId) {
        this.storeByStoreId = storeByStoreId;
    }

    public Delivery getDeliveryByDeliveryId() {
        return deliveryByDeliveryId;
    }

    public void setDeliveryByDeliveryId(Delivery deliveryByDeliveryId) {
        this.deliveryByDeliveryId = deliveryByDeliveryId;
    }

    public Collection<OrderItems> getOrderItemsByOrderId() {
        return orderItemsByOrderId;
    }

    public void setOrderItemsByOrderId(Collection<OrderItems> orderItemsByOrderId) {
        this.orderItemsByOrderId = orderItemsByOrderId;
    }
}
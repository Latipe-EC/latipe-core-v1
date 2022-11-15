package com.webproject.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "store")
public class Store {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "store_id", nullable = false)
    private int storeId;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "ownId", nullable = false)
    private int ownId;
    @Basic
    @Column(name = "commissionId", nullable = false)
    private int commissionId = 1;
    @Basic
    @Column(name = "bio", nullable = false, length = 255)
    private String bio;
    @Basic
    @Column(name = "isActive", nullable = false)
    private boolean isActive = true;
    @Basic
    @Column(name = "avatar", nullable = true, length = 255)
    private String avatar;
    @Basic
    @Column(name = "cover", nullable = true, length = 255)
    private String cover;
    @Basic
    @Column(name = "featured_images", nullable = true, length = 255)
    private String featuredImages = "feature.jpg";
    @Basic
    @Column(name = "point", nullable = true)
    private Integer point = 0;
    @Basic
    @Column(name = "rating", nullable = true)
    private Integer rating = 0;
    @Basic
    @Column(name = "e_wallet", nullable = true, precision = 0)
    private Double eWallet = 0D;
    @Basic
    @Column(name = "createDate", nullable = true)
    private Date createDate = new Date(new java.util.Date().getTime());
    @Basic
    @Column(name = "updateDate", nullable = true)
    private Date updateDate;
    @OneToMany(mappedBy = "storeByStoreId")
    private Collection<Orders> ordersByStoreId;
    @OneToMany(mappedBy = "storeByStoreId")
    private Collection<Review> reviewsByStoreId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ownId", referencedColumnName = "user_id", nullable = false, insertable = false, updatable = false)
    private User userByOwnId;
    @ManyToOne
    @JoinColumn(name = "commissionId", referencedColumnName = "commissionId", nullable = false, insertable = false, updatable = false)
    private Commission commissionByCommissionId;
    @OneToOne(mappedBy = "storeByStoreId")
    private StoreLevel storeLevelByStoreId;
    @OneToMany(mappedBy = "storeByStoreEmpId")
    private Collection<User> usersByStoreId;
    @OneToMany(mappedBy = "storeByStoreId", fetch = FetchType.LAZY)
    private Collection<UserFollowStore> userFollowStoresByStoreId;

    @OneToMany(mappedBy = "storeByStoreId", fetch = FetchType.LAZY)
    private Collection<Product> productsByStoreId;

    public Collection<Product> getProductsByStoreId() {
        return productsByStoreId;
    }

    public void setProductsByStoreId(Collection<Product> productsByStoreId) {
        this.productsByStoreId = productsByStoreId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOwnId() {
        return ownId;
    }

    public void setOwnId(int ownId) {
        this.ownId = ownId;
    }

    public int getCommissionId() {
        return commissionId;
    }

    public void setCommissionId(int commissionId) {
        this.commissionId = commissionId;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getFeaturedImages() {
        return featuredImages;
    }

    public void setFeaturedImages(String featuredImages) {
        this.featuredImages = featuredImages;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Double geteWallet() {
        return eWallet;
    }

    public void seteWallet(Double eWallet) {
        this.eWallet = eWallet;
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
        Store store = (Store) o;
        return storeId == store.storeId && ownId == store.ownId && commissionId == store.commissionId && isActive == store.isActive && Objects.equals(name, store.name) && Objects.equals(bio, store.bio) && Objects.equals(avatar, store.avatar) && Objects.equals(cover, store.cover) && Objects.equals(featuredImages, store.featuredImages) && Objects.equals(point, store.point) && Objects.equals(rating, store.rating) && Objects.equals(eWallet, store.eWallet) && Objects.equals(createDate, store.createDate) && Objects.equals(updateDate, store.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeId, name, ownId, commissionId, bio, isActive, avatar, cover, featuredImages, point, rating, eWallet, createDate, updateDate);
    }

    public Collection<Orders> getOrdersByStoreId() {
        return ordersByStoreId;
    }

    public void setOrdersByStoreId(Collection<Orders> ordersByStoreId) {
        this.ordersByStoreId = ordersByStoreId;
    }

    public Collection<Review> getReviewsByStoreId() {
        return reviewsByStoreId;
    }

    public void setReviewsByStoreId(Collection<Review> reviewsByStoreId) {
        this.reviewsByStoreId = reviewsByStoreId;
    }

    public User getUserByOwnId() {
        return userByOwnId;
    }

    public void setUserByOwnId(User userByOwnId) {
        this.userByOwnId = userByOwnId;
    }

    public Commission getCommissionByCommissionId() {
        return commissionByCommissionId;
    }

    public void setCommissionByCommissionId(Commission commissionByCommissionId) {
        this.commissionByCommissionId = commissionByCommissionId;
    }

    public StoreLevel getStoreLevelByStoreId() {
        return storeLevelByStoreId;
    }

    public void setStoreLevelByStoreId(StoreLevel storeLevelByStoreId) {
        this.storeLevelByStoreId = storeLevelByStoreId;
    }

    public Collection<User> getUsersByStoreId() {
        return usersByStoreId;
    }

    public void setUsersByStoreId(Collection<User> usersByStoreId) {
        this.usersByStoreId = usersByStoreId;
    }

    public Collection<UserFollowStore> getUserFollowStoresByStoreId() {
        return userFollowStoresByStoreId;
    }

    public void setUserFollowStoresByStoreId(Collection<UserFollowStore> userFollowStoresByStoreId) {
        this.userFollowStoresByStoreId = userFollowStoresByStoreId;
    }
}

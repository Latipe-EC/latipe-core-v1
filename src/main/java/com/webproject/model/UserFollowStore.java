package com.webproject.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "user_follow_store", schema = "final_web_project", catalog = "")
public class UserFollowStore {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "user_id", nullable = false)
    private int userId;
    @Basic
    @Column(name = "store_id", nullable = false)
    private int storeId;
    @Basic
    @Column(name = "isDeleted", nullable = true)
    private Boolean isDeleted = false;
    @Basic
    @Column(name = "createDate", nullable = false)
    private Date createDate= new Date(new java.util.Date().getTime());
    @Basic
    @Column(name = "updateDate", nullable = true)
    private Date updateDate;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false, insertable=false, updatable=false)
    private User userByUserId;
    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "store_id", nullable = false, insertable=false, updatable=false)
    private Store storeByStoreId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
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
        UserFollowStore that = (UserFollowStore) o;
        return id == that.id && userId == that.userId && storeId == that.storeId && Objects.equals(isDeleted, that.isDeleted) && Objects.equals(createDate, that.createDate) && Objects.equals(updateDate, that.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, storeId, isDeleted, createDate, updateDate);
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
}

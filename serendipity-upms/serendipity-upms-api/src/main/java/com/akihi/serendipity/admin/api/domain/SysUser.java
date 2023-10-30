package com.akihi.serendipity.admin.api.domain;

import com.akihi.serendipity.common.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

import java.io.Serial;
import java.util.Objects;
import java.util.StringJoiner;

@Schema(description = "用户")
@Entity
@Table(name = "sys_user")
public class SysUser extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    /**
     * 客户端ID
     */
    @Schema(title = "用户名")
    @Column(name = "username", nullable = false)
    @NotBlank(message = "username不能为空")
    private String username;

    /**
     * 密码
     */
    @Schema(description = "密码")
    @Column(name = "password", nullable = false)
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 随机盐
     */
    @JsonIgnore
    @Schema(description = "随机盐")
    private String salt;

    /**
     * 0-正常，1-删除
     */
    @JsonIgnore
    @Schema(description = "删除标记,1:已删除,0:正常")
    @Column(name = "deleted", nullable = false)
    private Boolean deleted = false;

    /**
     * 锁定标记
     */
    @Schema(description = "锁定标记")
    @Column(name = "lock_flag", nullable = false)
    private String lockFlag;

    /**
     * 手机号
     */
    @Schema(description = "手机号")
    private String phone;

    /**
     * 头像
     */
    @Schema(description = "头像地址")
    private String avatar;

    /**
     * 昵称
     */
    @Schema(description = "昵称")
    private String nickname;


    /**
     * 邮箱
     */
    @Schema(description = "邮箱")
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getLockFlag() {
        return lockFlag;
    }

    public void setLockFlag(String lockFlag) {
        this.lockFlag = lockFlag;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SysUser sysUser = (SysUser) o;
        return Objects.equals(id, sysUser.id) && Objects.equals(username, sysUser.username) && Objects.equals(password, sysUser.password) && Objects.equals(salt, sysUser.salt) && Objects.equals(deleted, sysUser.deleted) && Objects.equals(lockFlag, sysUser.lockFlag) && Objects.equals(phone, sysUser.phone) && Objects.equals(avatar, sysUser.avatar) && Objects.equals(nickname, sysUser.nickname) && Objects.equals(email, sysUser.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, username, password, salt, deleted, lockFlag, phone, avatar, nickname, email);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SysUser.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("username='" + username + "'")
                .add("password='" + password + "'")
                .add("salt='" + salt + "'")
                .add("deleted=" + deleted)
                .add("lockFlag='" + lockFlag + "'")
                .add("phone='" + phone + "'")
                .add("avatar='" + avatar + "'")
                .add("nickname='" + nickname + "'")
                .add("email='" + email + "'")
                .toString();
    }
}

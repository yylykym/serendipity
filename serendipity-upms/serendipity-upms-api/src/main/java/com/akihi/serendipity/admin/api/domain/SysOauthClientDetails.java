package com.akihi.serendipity.admin.api.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@Entity
@Table(name = "sys_oauth_client_details")
public class SysOauthClientDetails implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    /**
     * 客户端ID
     */
    @Column(name = "client_id", nullable = false)
    @NotBlank(message = "client_id 不能为空")
    private String clientId;

    /**
     * 客户端密钥
     */
    @Column(name = "client_secret", nullable = false)
    @NotBlank(message = "client_secret 不能为空")
    private String clientSecret;

    /**
     * 资源ID
     */
    @Column(name = "resource_ids", nullable = false)
    private String resourceIds;

    /**
     * 作用域
     */

    /**
     * 授权方式[A,B,C]
     */
    @Lob
    @Column(name = "authorized_grant_types", nullable = false)
    private List<String> authorizedGrantTypes = new ArrayList<>();

    /**
     * 回调地址
     */
    @Column(name = "web_server_redirect_uri", nullable = false)
    private String webServerRedirectUri = "";

    /**
     * 权限
     */
    @Column(name = "authorities", nullable = false)
    private String authorities = "";

    /**
     * 请求令牌有效时间
     */
    private Integer accessTokenValidity;

    /**
     * 刷新令牌有效时间
     */
    private Integer refreshTokenValidity;

    /**
     * 扩展信息
     */
    private String additionalInformation;

    /**
     * 是否自动放行
     */
    private String autoApprove;

    /**
     * 删除标记
     */
    private String delFlag;

    /**
     * 创建人
     */
    @CreatedBy
    private String createBy;

    /**
     * 修改人
     */
    @LastModifiedBy
    private String updateBy;

    /**
     * 创建时间
     */
    @CreatedDate
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @LastModifiedDate
    private LocalDateTime updateTime;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public List<String> getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    public void setAuthorizedGrantTypes(List<String> authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public String getWebServerRedirectUri() {
        return webServerRedirectUri;
    }

    public void setWebServerRedirectUri(String webServerRedirectUri) {
        this.webServerRedirectUri = webServerRedirectUri;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public Integer getAccessTokenValidity() {
        return accessTokenValidity;
    }

    public void setAccessTokenValidity(Integer accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    public Integer getRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    public void setRefreshTokenValidity(Integer refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getAutoApprove() {
        return autoApprove;
    }

    public void setAutoApprove(String autoApprove) {
        this.autoApprove = autoApprove;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SysOauthClientDetails.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("clientId='" + clientId + "'")
                .add("clientSecret='" + clientSecret + "'")
                .add("resourceIds='" + resourceIds + "'")
                .add("authorizedGrantTypes=" + authorizedGrantTypes)
                .add("webServerRedirectUri='" + webServerRedirectUri + "'")
                .add("authorities='" + authorities + "'")
                .add("accessTokenValidity=" + accessTokenValidity)
                .add("refreshTokenValidity=" + refreshTokenValidity)
                .add("additionalInformation='" + additionalInformation + "'")
                .add("autoApprove='" + autoApprove + "'")
                .add("delFlag='" + delFlag + "'")
                .add("createBy='" + createBy + "'")
                .add("updateBy='" + updateBy + "'")
                .add("createTime=" + createTime)
                .add("updateTime=" + updateTime)
                .toString();
    }
}

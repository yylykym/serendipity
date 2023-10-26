package com.akihi.serendipity.admin.api.domain;

import com.akihi.serendipity.common.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import io.swagger.v3.oas.annotations.media.Schema;
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
import java.util.Objects;
import java.util.StringJoiner;

@Schema(name = "客户端详情")
@Entity
@Table(name = "sys_oauth_client_details")
public class SysOauthClientDetails extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    /**
     * 客户端ID
     */
    @Schema(title = "客户端ID")
    @Column(name = "client_id", nullable = false)
    @NotBlank(message = "client_id 不能为空")
    @JsonProperty("client_id")
    private String clientId;

    /**
     * 客户端密钥
     */
    @Schema(title = "客户端密钥")
    @Column(name = "client_secret", nullable = false)
    @NotBlank(message = "client_secret 不能为空")
    @JsonProperty("client_secret")
    private String clientSecret;

    /**
     * 资源ID
     */
    @Schema(title = "资源ID")
    @Column(name = "resource_ids", nullable = false)
    @JsonProperty("resource_ids")
    private String resourceIds;

    /**
     * 作用域
     */

    /**
     * 授权方式[A,B,C]
     */
    @Schema(title = "授权方式[A,B,C]")
    @Lob
    @Column(name = "authorized_grant_types", nullable = false)
    @JsonProperty("authorized_grant_types")
    private List<String> authorizedGrantTypes = new ArrayList<>();

    /**
     * 回调地址
     */
    @Schema(title = "回调地址")
    @Column(name = "web_server_redirect_uri", nullable = false)
    @JsonProperty("web_server_redirect_uri")
    private String webServerRedirectUri = "";

    /**
     * 权限
     */
    @Schema(title = "权限")
    @Column(name = "authorities", nullable = false)
    @JsonProperty("authorities")
    private String authorities = "";

    /**
     * 请求令牌有效时间
     */
    @Schema(title = "请求令牌有效时间")
    @Column(name = "access_token_validity", nullable = false)
    @JsonProperty("access_token_validity")
    private Integer accessTokenValidity;

    /**
     * 刷新令牌有效时间
     */
    @Schema(title = "刷新令牌有效时间")
    @Column(name = "refresh_token_validity", nullable = false)
    @JsonProperty("refresh_token_validity")
    private Integer refreshTokenValidity;

    /**
     * 扩展信息
     */
    @Schema(title = "扩展信息")
    @Column(name = "additional_info", nullable = false)
    @JsonProperty("additional_info")
    private String additionalInfo;

    /**
     * 是否自动放行
     */
    @Schema(title = "是否自动放行")
    @Column(name = "auto_approve", nullable = false)
    @JsonProperty("auto_approve")
    private String autoApprove;

    /**
     * 删除标记
     */
    @Schema(title = "删除标记")
    @Column(name = "deleted", nullable = false)
    @JsonProperty("deleted")
    private String deleted = "0";


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getAutoApprove() {
        return autoApprove;
    }

    public void setAutoApprove(String autoApprove) {
        this.autoApprove = autoApprove;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SysOauthClientDetails that = (SysOauthClientDetails) o;
        return Objects.equals(id, that.id) && Objects.equals(clientId, that.clientId) && Objects.equals(clientSecret, that.clientSecret) && Objects.equals(resourceIds, that.resourceIds) && Objects.equals(authorizedGrantTypes, that.authorizedGrantTypes) && Objects.equals(webServerRedirectUri, that.webServerRedirectUri) && Objects.equals(authorities, that.authorities) && Objects.equals(accessTokenValidity, that.accessTokenValidity) && Objects.equals(refreshTokenValidity, that.refreshTokenValidity) && Objects.equals(additionalInfo, that.additionalInfo) && Objects.equals(autoApprove, that.autoApprove) && Objects.equals(deleted, that.deleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, clientId, clientSecret, resourceIds, authorizedGrantTypes, webServerRedirectUri, authorities, accessTokenValidity, refreshTokenValidity, additionalInfo, autoApprove, deleted);
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
                .add("additionalInfo='" + additionalInfo + "'")
                .add("autoApprove='" + autoApprove + "'")
                .add("deleted='" + deleted + "'")
                .toString();
    }
}

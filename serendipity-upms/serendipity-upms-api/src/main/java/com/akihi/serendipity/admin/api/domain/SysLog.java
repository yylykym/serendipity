package com.akihi.serendipity.admin.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Schema(name = "日志")
@Entity(name = "sys_log")
public class SysLog implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @Schema(title = "日志ID")
    @Id
    @Column(name = "id", length = 64)
    private String id;

    /**
     * 日志类型
     */
    @Schema(title = "日志类型")
    @NotBlank(message = "日志类型不能为空")
    @Column(name = "log_type", nullable = false)
    @JsonProperty("log_type")
    private String logType = "0";

    /**
     * 日志标题
     */
    @Schema(title = "日志标题")
    @NotBlank(message = "日志标题不能为空")
    @Column(name = "title")
    @JsonProperty("title")
    private String title;

    /**
     * 创建者
     */
    @Schema(title = "创建者")
    @Column(name = "create_by")
    @CreatedBy
    @JsonProperty("create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @Schema(title = "创建时间")
    @Column(name = "create_date")
    @CreatedDate
    @JsonProperty("create_date")
    private LocalDateTime createdDate;

    /**
     * 更新时间
     */
    @Schema(title = "修改时间")
    @Column(name = "last_modified_date")
    @LastModifiedDate
    @JsonProperty("last_modified_date")
    private LocalDateTime lastModifiedDate;

    /**
     * 操作IP地址
     */
    @Schema(title = "操作IP地址")
    @Column(name = "remote_addr")
    @JsonProperty("remote_addr")
    private String remoteAddr;

    /**
     * 用户代理
     */
    @Schema(title = "用户代理")
    @Column(name = "user_agent")
    @JsonProperty("user_agent")
    private String userAgent;

    /**
     * 请求URI
     */
    @Schema(title = "请求URI")
    @Column(name = "request_uri")
    @JsonProperty("request_uri")
    private String requestUri;

    /**
     * 操作方式
     */
    @Schema(title = "操作方式")
    @Column(name = "method")
    @JsonProperty("method")
    private String method;

    /**
     * 操作提交的数据
     */
    @Schema(title = "操作提交的数据")
    @Column(name = "params")
    @JsonProperty("params")
    private String params;

    /**
     * 执行时间
     */
    @Schema(title = "执行时间")
    @Column(name = "execute_time")
    @JsonProperty("execute_time")
    private Long executeTime;

    /**
     * 异常信息
     */
    @Schema(title = "异常信息")
    @Column(name = "exception")
    @JsonProperty("exception")
    private String exception;

    /**
     * 服务ID
     */
    @Schema(title = "服务ID")
    @Column(name = "service_id")
    @JsonProperty("service_id")
    private String serviceId;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getRemoteAddr() {
        return remoteAddr;
    }

    public void setRemoteAddr(String remoteAddr) {
        this.remoteAddr = remoteAddr;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public Long getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(Long executeTime) {
        this.executeTime = executeTime;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysLog sysLog = (SysLog) o;
        return Objects.equals(id, sysLog.id) && Objects.equals(logType, sysLog.logType) && Objects.equals(title, sysLog.title) && Objects.equals(createBy, sysLog.createBy) && Objects.equals(createdDate, sysLog.createdDate) && Objects.equals(lastModifiedDate, sysLog.lastModifiedDate) && Objects.equals(remoteAddr, sysLog.remoteAddr) && Objects.equals(userAgent, sysLog.userAgent) && Objects.equals(requestUri, sysLog.requestUri) && Objects.equals(method, sysLog.method) && Objects.equals(params, sysLog.params) && Objects.equals(executeTime, sysLog.executeTime) && Objects.equals(exception, sysLog.exception) && Objects.equals(serviceId, sysLog.serviceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, logType, title, createBy, createdDate, lastModifiedDate, remoteAddr, userAgent, requestUri, method, params, executeTime, exception, serviceId);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("logType", logType)
                .add("title", title)
                .add("createBy", createBy)
                .add("createdDate", createdDate)
                .add("lastModifiedDate", lastModifiedDate)
                .add("remoteAddr", remoteAddr)
                .add("userAgent", userAgent)
                .add("requestUri", requestUri)
                .add("method", method)
                .add("params", params)
                .add("executeTime", executeTime)
                .add("exception", exception)
                .add("serviceId", serviceId)
                .toString();
    }
}

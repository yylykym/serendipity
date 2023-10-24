package com.akihi.serendipity.admin.api.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.StringJoiner;

@Entity
@Table(name = "sys_log")
public class SysLog implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @Id
    @Column(name = "id", length = 64)
    private String id;

    /**
     * 日志类型
     */
    @NotBlank(message = "日志类型不能为空")
    @Column(name = "log_type", nullable = false)
    private String logType = "0";

    /**
     * 日志标题
     */
    @NotBlank(message = "日志标题不能为空")
    @Column(name = "title")
    private String title;

    /**
     * 创建者
     */
    @Column(name = "create_by")
    @CreatedBy
    private String createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @CreatedDate
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    @LastModifiedDate
    private LocalDateTime updateTime;

    /**
     * 操作IP地址
     */
    @Column(name = "remote_addr")
    private String remoteAddr;

    /**
     * 用户代理
     */
    @Column(name = "user_agent")
    private String userAgent;

    /**
     * 请求URI
     */
    @Column(name = "request_uri")
    private String requestUri;

    /**
     * 操作方式
     */
    @Column(name = "method")
    private String method;

    /**
     * 操作提交的数据
     */
    @Column(name = "params")
    private String params;

    /**
     * 执行时间
     */
    @Column(name = "execute_time")
    private Long executeTime;

    /**
     * 异常信息
     */
    @Column(name = "exception")
    private String exception;

    /**
     * 服务ID
     */
    @Column(name = "service_id")
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
    public String toString() {
        return new StringJoiner(", ", SysLog.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("logType='" + logType + "'")
                .add("title='" + title + "'")
                .add("createBy='" + createBy + "'")
                .add("createTime=" + createTime)
                .add("updateTime=" + updateTime)
                .add("remoteAddr='" + remoteAddr + "'")
                .add("userAgent='" + userAgent + "'")
                .add("requestUri='" + requestUri + "'")
                .add("method='" + method + "'")
                .add("params='" + params + "'")
                .add("executeTime=" + executeTime)
                .add("exception='" + exception + "'")
                .add("serviceId='" + serviceId + "'")
                .toString();
    }
}

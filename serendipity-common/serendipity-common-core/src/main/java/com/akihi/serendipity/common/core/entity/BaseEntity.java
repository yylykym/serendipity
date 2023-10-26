package com.akihi.serendipity.common.core.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

@MappedSuperclass
public abstract class BaseEntity extends AbstractEntity {

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
     * 更新人
     */
    @Schema(title = "修改时间")
    @Column(name = "last_modified_by")
    @LastModifiedBy
    @JsonProperty("last_modified_by")
    private LocalDateTime lastModifiedBy;

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

    public LocalDateTime getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(LocalDateTime lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return Objects.equals(createBy, that.createBy) && Objects.equals(createdDate, that.createdDate) && Objects.equals(lastModifiedDate, that.lastModifiedDate) && Objects.equals(lastModifiedBy, that.lastModifiedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createBy, createdDate, lastModifiedDate, lastModifiedBy);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BaseEntity.class.getSimpleName() + "[", "]")
                .add("createBy='" + createBy + "'")
                .add("createdDate=" + createdDate)
                .add("lastModifiedDate=" + lastModifiedDate)
                .add("lastModifiedBy=" + lastModifiedBy)
                .toString();
    }
}

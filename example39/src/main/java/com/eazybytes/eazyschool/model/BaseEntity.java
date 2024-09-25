package com.eazybytes.eazyschool.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/*
The @JsonIgnore annotation in Jackson (a popular Java library used for processing JSON data) is used to
instruct the serialization process to ignore specific fields or properties when converting a Java object to JSON.
This means that fields annotated with @JsonIgnore will not be included in the generated JSON output.
 */

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @CreatedDate
    @Column(updatable = false)
    @JsonIgnore
    private LocalDateTime createdAt;
    @CreatedBy
    @Column(updatable = false)
    @JsonIgnore
    private  String createdBy;
    @LastModifiedDate
    @Column(insertable = false)
    @JsonIgnore
    private LocalDateTime updatedAt;
    @LastModifiedBy
    @Column(insertable = false)
    @JsonIgnore
    private  String updatedBy;
}

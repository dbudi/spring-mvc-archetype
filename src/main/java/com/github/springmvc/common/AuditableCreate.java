/**
 * 
 */
package com.github.springmvc.common;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author budi
 *
 */
@SuppressWarnings("serial")
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditableCreate extends BaseObject implements IAuditableCreate {
	@Column(name = "CREATED_DATE", nullable=true, updatable=false)	
	@CreatedDate
	private Instant createdDateTime;
	@Column(name = "CREATED_BY", length = 50, nullable=true, updatable=false)
	@CreatedBy
	private String createdBy;
	@Version
    @Column(name="VERSION")
	private Integer version;
	public Instant getCreatedDateTime() {
		return createdDateTime;
	}
	public void setCreatedDateTime(Instant createdDateTime) {
		this.createdDateTime = createdDateTime;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
}

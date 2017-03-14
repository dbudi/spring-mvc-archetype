/**
 * 
 */
package com.github.springmvc.common;

import java.time.Instant;

/**
 * @author budi
 *
 */
public interface IAuditableCreate {
	Instant getCreatedDateTime();	
	String getCreatedBy();	
	void setCreatedDateTime(Instant createdDateTime);
	void setCreatedBy(String createdBy);
}

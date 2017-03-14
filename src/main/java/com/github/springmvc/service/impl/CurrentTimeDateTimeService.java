/**
 * 
 */
package com.github.springmvc.service.impl;

import java.time.ZonedDateTime;

import com.github.springmvc.service.DateTimeService;

/**
 * @author budi
 *
 */
public class CurrentTimeDateTimeService implements DateTimeService {

	/* (non-Javadoc)
	 * @see id.co.quadras.springmvc.service.DateTimeService#getCurrentDateAndTime()
	 */
	@Override
	public ZonedDateTime getCurrentDateAndTime() {
		return ZonedDateTime.now();
	}

}

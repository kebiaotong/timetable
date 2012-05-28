package com.rdc.timetable.entity.account;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.rdc.timetable.entity.IdEntity;

/**
 * 大学信息表
 *
 * @author crd 2012-5-27 下午01:45:38
 */

@Entity
@Table(name = "college")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class College extends IdEntity{
	private String provinceName;
	private String collegeName;
	private boolean enable;
	
	public String getProvinceName() {
		return provinceName;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

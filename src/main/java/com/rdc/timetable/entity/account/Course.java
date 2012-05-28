package com.rdc.timetable.entity.account;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.rdc.timetable.entity.IdEntity;

/**
 * 课程信息表
 *
 * @author crd 2012-5-27 下午01:50:49
 */

@Entity
@Table(name = "course")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Course extends IdEntity {
	private String className;
	private String introduce;
	private boolean enable;
	public String getClassName() {
		return className;
	}
	public String getIntroduce() {
		return introduce;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

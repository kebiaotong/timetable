package com.rdc.timetable.entity.account;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.rdc.timetable.entity.IdEntity;

/**
 * 教师信息表
 *
 * @author crd 2012-5-27 下午02:19:47
 */

@Entity
@Table(name = "teacher")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Teacher extends IdEntity {
	private String name;
	private String instroduce;
	private boolean enable;
	public String getName() {
		return name;
	}
	public String getInstroduce() {
		return instroduce;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setInstroduce(String instroduce) {
		this.instroduce = instroduce;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

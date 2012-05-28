package com.rdc.timetable.entity.account;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.rdc.timetable.entity.IdEntity;

/**
 * 上课信息表
 *
 * @author crd 2012-5-27 下午02:29:34
 */

@Entity
@Table(name = "course_info")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CourseInfo extends IdEntity {
	private College college;
	private Course course;
	private Teacher teacher;
	private Date classTime;
	private String place;
	private boolean enable;
	
	@ManyToOne
	public College getCollege() {
		return college;
	}
	
	@ManyToOne
	public Course getCourse() {
		return course;
	}
	
	@ManyToOne
	public Teacher getTeacher() {
		return teacher;
	}
	public Date getClassTime() {
		return classTime;
	}
	
	public String getPlace() {
		return place;
	}
	
	public boolean isEnable() {
		return enable;
	}
	
	public void setCollege(College college) {
		this.college = college;
	}
	
	public void setCourse(Course course) {
		this.course = course;
	}
	
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public void setClassTime(Date classTime) {
		this.classTime = classTime;
	}
	
	public void setPlace(String place) {
		this.place = place;
	}
	
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}

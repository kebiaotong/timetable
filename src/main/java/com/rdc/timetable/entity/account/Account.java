package com.rdc.timetable.entity.account;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.rdc.timetable.entity.IdEntity;

/**
 * 用户信息表
 *
 * @author crd 2012-5-27 下午01:58:38
 */

@Entity
@Table(name = "account")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Account extends IdEntity {
	private College college;
	private String loginName;
	private String password;
	private String email;
	private String signature;
	private Date registered_date;
	private Date birthday;
	private Attachment avatar;
	private boolean isSuper;
	public boolean isSuper() {
		return isSuper;
	}
	public void setSuper(boolean isSuper) {
		this.isSuper = isSuper;
	}

	private boolean enable;
	
	@ManyToOne
	public College getCollege() {
		return college;
	}
	public String getLoginName() {
		return loginName;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public String getSignature() {
		return signature;
	}
	public Date getRegistered_date() {
		return registered_date;
	}
	public Date getBirthday() {
		return birthday;
	}
	
	@Transient
	public Integer getAge() {
		if (getBirthday() != null) {

			Calendar now = Calendar.getInstance();
			Calendar born = Calendar.getInstance();
			born.setTime(getBirthday());
			Integer nowMonth = now.get(Calendar.MONTH);
			Integer bornMonth = born.get(Calendar.MONTH);
			Integer difference = nowMonth - bornMonth;
			Integer age;
			if (difference == 0) {
				age = now.get(Calendar.DATE) - born.get(Calendar.DATE) > 0 ? 0
						: -1;
			} else {
				age = now.get(Calendar.MONTH) - born.get(Calendar.MONTH) > 0 ? 0
						: -1;
				age += now.get(Calendar.YEAR) - born.get(Calendar.YEAR);
			}
			return age;
		}
		return null;
	}
	
	@ManyToOne
	public Attachment getAvatar() {
		return avatar;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public void setRegistered_date(Date registered_date) {
		this.registered_date = registered_date;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public void setAvatar(Attachment avatar) {
		this.avatar = avatar;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

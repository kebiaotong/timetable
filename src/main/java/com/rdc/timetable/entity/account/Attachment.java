package com.rdc.timetable.entity.account;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.rdc.timetable.entity.IdEntity;

/**
 * 附件表，可存放图片等上传的内容
 *
 * @author crd 2012-5-27 下午01:54:24
 */

@Entity
@Table(name = "attachment")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Attachment extends IdEntity {
	private String name;
	private Date upload_date;
	private String path;
	private String length;
	public String getName() {
		return name;
	}
	public Date getUpload_date() {
		return upload_date;
	}
	public String getPath() {
		return path;
	}
	public String getLength() {
		return length;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUpload_date(Date upload_date) {
		this.upload_date = upload_date;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public void setLength(String length) {
		this.length = length;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}

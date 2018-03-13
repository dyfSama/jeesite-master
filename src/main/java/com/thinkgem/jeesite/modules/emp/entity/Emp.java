/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.emp.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 员工信息管理Entity
 * @author dyf
 * @version 2018-03-01
 */
public class Emp extends DataEntity<Emp> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 员工姓名
	private Integer gender;		// 员工性别
	private Integer age;		// 员工年龄
	private Date birthday;		// 员工生日
	private Double salary;		// 员工薪酬
	private String job;		// 员工工作
	
	public Emp() {
		super();
	}

	public Emp(String id){
		super(id);
	}

	@Length(min=0, max=255, message="员工姓名长度必须介于 0 和 255 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}
	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	@Length(min=0, max=32, message="员工工作长度必须介于 0 和 32 之间")
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
}
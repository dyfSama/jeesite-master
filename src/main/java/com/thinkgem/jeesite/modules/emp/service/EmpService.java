/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.emp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.emp.entity.Emp;
import com.thinkgem.jeesite.modules.emp.dao.EmpDao;

/**
 * 员工信息管理Service
 * @author dyf
 * @version 2018-03-01
 */
@Service
@Transactional(readOnly = true)
public class EmpService extends CrudService<EmpDao, Emp> {

	public Emp get(String id) {
		return super.get(id);
	}
	
	public List<Emp> findList(Emp emp) {
		return super.findList(emp);
	}
	
	public Page<Emp> findPage(Page<Emp> page, Emp emp) {
		return super.findPage(page, emp);
	}
	
	@Transactional(readOnly = false)
	public void save(Emp emp) {
		super.save(emp);
	}
	
	@Transactional(readOnly = false)
	public void delete(Emp emp) {
		super.delete(emp);
	}
	
}
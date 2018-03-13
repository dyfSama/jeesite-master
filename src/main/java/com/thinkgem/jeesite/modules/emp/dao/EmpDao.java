/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.emp.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.emp.entity.Emp;

/**
 * 员工信息管理DAO接口
 * @author dyf
 * @version 2018-03-01
 */
@MyBatisDao
public interface EmpDao extends CrudDao<Emp> {
	
}
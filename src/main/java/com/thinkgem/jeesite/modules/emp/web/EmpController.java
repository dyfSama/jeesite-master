/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.emp.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.emp.entity.Emp;
import com.thinkgem.jeesite.modules.emp.service.EmpService;

/**
 * 员工信息管理Controller
 * @author dyf
 * @version 2018-03-01
 */
@Controller
@RequestMapping(value = "${adminPath}/emp/emp")
public class EmpController extends BaseController {

	@Autowired
	private EmpService empService;
	
	@ModelAttribute
	public Emp get(@RequestParam(required=false) String id) {
		Emp entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = empService.get(id);
		}
		if (entity == null){
			entity = new Emp();
		}
		return entity;
	}
	
//	@RequiresPermissions("emp:emp:view")
	@RequestMapping(value = {"list", ""})
	public String list(Emp emp, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Emp> page = empService.findPage(new Page<Emp>(request, response), emp); 
		model.addAttribute("page", page);
		return "modules/emp/empList";
	}

//	@RequiresPermissions("emp:emp:view")
	@RequestMapping(value = "form")
	public String form(Emp emp, Model model) {
		model.addAttribute("emp", emp);
		return "modules/emp/empForm";
	}

//	@RequiresPermissions("emp:emp:edit")
	@RequestMapping(value = "save")
	public String save(Emp emp, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, emp)){
			return form(emp, model);
		}
		empService.save(emp);
		addMessage(redirectAttributes, "保存员工信息成功");
		return "redirect:"+Global.getAdminPath()+"/emp/emp/?repage";
	}
	
//	@RequiresPermissions("emp:emp:edit")
	@RequestMapping(value = "delete")
	public String delete(Emp emp, RedirectAttributes redirectAttributes) {
		empService.delete(emp);
		addMessage(redirectAttributes, "删除员工信息成功");
		return "redirect:"+Global.getAdminPath()+"/emp/emp/?repage";
	}

}
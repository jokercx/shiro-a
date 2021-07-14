package com.yr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yr.entry.Department;
import com.yr.service.DepartmentService;

/**
 * 部门增删改Controller
 * 
 * @author liucong
 *
 * @date 2017年10月16日
 */
@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService<Department> departmentService;

	private List<Department> deparList;

	/**
	 * 添加
	 * 
	 * @param department
	 * @param modelMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/addDepart", method = RequestMethod.POST)
	public String addDepart(Department department, ModelMap modelMap) {
		System.out.println(department.toString());
		Boolean bool = departmentService.add(department);
		String mark = null;
		if (bool) {
			deparList = queryDepart();
			modelMap.addAttribute("deparList", deparList);
			mark = "s";
		} else {
			mark = "e";
		}
		return mark;
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @param modelMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "delDepart/{id}", method = RequestMethod.POST)
	public String delDepart(@PathVariable Integer id, ModelMap modelMap) {
		Boolean bool = departmentService.del(id);
		String mark = null;
		if (bool) {
			deparList = queryDepart();
			modelMap.addAttribute("deparList", deparList);
			mark = "s";
		} else {
			mark = "e";
		}
		return mark;
	}

	/**
	 * 修改前根据id回显数据
	 * 
	 * @param id
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("{id}/getDepart")
	public String getDepart(@PathVariable Integer id, ModelMap modelMap) {
		deparList = departmentService.getData(id);
		modelMap.addAttribute("deparList", deparList);
		return "updateDepart";
	}

	/**
	 * 修改
	 * 
	 * @param department
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/updateDepart")
	public String updateDepart(Department department, ModelMap modelMap) {
		Boolean bool = departmentService.update(department);
		if (bool) {
			deparList = queryDepart();
			modelMap.addAttribute("deparList", deparList);
			return "welcome";
		} else {
			modelMap.addAttribute("err", 2);
			return "updateDepart";
		}
	}

	/**
	 * 查询
	 * 
	 * @return
	 */
	@ResponseBody // 表示返回json格式数据
	@RequestMapping("/queryDepart")
	public List<Department> queryDepart() {
		deparList = departmentService.queryDepart();
		System.out.println("11111111111");
		return deparList;
	}
}

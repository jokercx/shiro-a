package com.yr.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yr.dao.DepartmentMapper;
import com.yr.entry.Department;
import com.yr.service.DepartmentService;

/**
 * 部门增删改service实现类
 * 
 * @author liucong
 *
 * @date 2017年10月16日
 */
@Service
public class DepartmentServiceImpl implements DepartmentService<Department> {
	@Autowired
	private DepartmentMapper departmentMapper;

	/**
	 * 查询
	 */
	public List<Department> queryDepart() {
		return departmentMapper.queryAll();
	}

	/**
	 * 添加
	 */
	public Boolean add(Department department) {
		try {
			departmentMapper.addDepart(department);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 删除
	 */
	public Boolean del(Integer id) {
		try {
			departmentMapper.delDepart(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	/**
	 * 修改前根据id回显数据
	 */
	public List<Department> getData(Integer id) {
		return departmentMapper.getDepartData(id);

	}

	/**
	 * 修改
	 */
	public Boolean update(Department department) {
		if ("".equals(department.getName()) || "".equals(department.getManager())) {
			return false;
		} else {
			departmentMapper.updateDepart(department);
			return true;
		}
	}
}

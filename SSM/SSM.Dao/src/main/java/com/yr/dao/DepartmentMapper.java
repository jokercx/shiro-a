package com.yr.dao;

import java.util.List;

import com.yr.entry.Department;

/**
 * mybatis映射接口
 * 
 * @author liucong
 *
 * @date 2017年10月16日
 */
public interface DepartmentMapper {

	// 查询
	public List<Department> queryAll();

	// 添加
	public void addDepart(Department t);

	// 删除
	public void delDepart(int id);

	// 修改前根据id回显数据
	public List<Department> getDepartData(int id);

	// 修改
	public void updateDepart(Department department);
}

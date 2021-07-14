package com.yr.service;

import java.util.List;

/**
 * 部门增伤service接口
 * 
 * @author liucong
 *
 * @date 2017年10月16日
 */
public interface DepartmentService<T> {
	// 查询
	public List<T> queryDepart();

	// 添加
	public Boolean add(T t);

	// 删除
	public Boolean del(Integer id);

	// 修改之前根据id回显数据
	public List<T> getData(Integer id);

	// 修改
	public Boolean update(T t);
}

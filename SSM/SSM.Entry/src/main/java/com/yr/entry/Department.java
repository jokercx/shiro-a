package com.yr.entry;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Department implements Serializable {
	private int id;
	private String name;
	private String manager;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", manager=" + manager + "]";
	}

}

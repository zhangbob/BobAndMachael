package com.testdb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hospital {

	private String name;
	private String department;
	private List<Map<String, List<Doctor>>> departments = new ArrayList<Map<String,List<Doctor>>>();
	
	public Hospital(String name) {
		this.name = name;
	}

	public List<Map<String, List<Doctor>>> getDepartments() {
		return departments;
	}

	public void setDepartments(String department, List<Doctor> list) {
		Map<String, List<Doctor>> map = new HashMap<String, List<Doctor>>();
		map.put(department, list);
		departments.add(map);
	}

	public String getName() {
		return name;
	}
	public String getDepartment() {
		return department;
	}
}

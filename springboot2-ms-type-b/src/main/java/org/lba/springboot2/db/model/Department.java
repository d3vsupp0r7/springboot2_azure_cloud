package org.lba.springboot2.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "department_name")
	private String departmentName;
	@Column(name = "department_location")
	private String departmentLocation;
	
	public Department() {
		super();
	}

	public Department(Long id, String departmentName, String departmentLocation) {
		super();
		this.id = id;
		this.departmentName = departmentName;
		this.departmentLocation = departmentLocation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentLocation() {
		return departmentLocation;
	}

	public void setDepartmentLocation(String departmentLocation) {
		this.departmentLocation = departmentLocation;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", departmentName=" + departmentName + ", departmentLocation="
				+ departmentLocation + "]";
	}
	
	
	
	

}

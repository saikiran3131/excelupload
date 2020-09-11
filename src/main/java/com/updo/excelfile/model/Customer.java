package com.updo.excelfile.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "age")
	private int age;
 
	@Column(name = "esiId")
	private String esiId;
	
	public Customer() {
	}
 
	public Customer(long id, String name, String address, int age,String esiId) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.age = age;
		this.esiId=esiId;
	}
 
	public long getId() {
		return id;
	}
 
	public void setId(long id) {
		this.id = id;
	}
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	public String getAddress() {
		return address;
	}
 
	public void setAddress(String address) {
		this.address = address;
	}
 
	public int getAge() {
		return age;
	}
 
	public void setAge(int age) {
		this.age = age;
	}
	
 
	public String getEsiId() {
		return esiId;
	}

	public void setEsiId(String esiId) {
		this.esiId = esiId;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", age=" + age + ", esiId=" + esiId
				+ "]";
	}
	
 
}
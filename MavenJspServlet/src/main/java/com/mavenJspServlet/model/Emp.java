package com.mavenJspServlet.model;

public class Emp {

	private int empid;
	private String empname;
	private int age;
	private String city;
	
	public Emp() {
		super();
	}
	public Emp(int empid, String empname, int age, String city) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.age = age;
		this.city = city;
	}
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "Emp [empid=" + empid + ", empname=" + empname + ", age=" + age + ", city=" + city + "]";
	}
	
	
}

package com.rest.model;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {

	private int sid;
	private String sname;
	private int spoints;

	public Student() {
		super();
	}
	public Student(int sid, String sname, int spoints) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.spoints = spoints;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSpoints() {
		return spoints;
	}
	public void setSpoints(int spoints) {
		this.spoints = spoints;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", spoints=" + spoints + "]";
	}

}

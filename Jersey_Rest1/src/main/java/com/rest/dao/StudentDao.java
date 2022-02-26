package com.rest.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.rest.model.Student;

public class StudentDao {

	public static List<Student> slist = new ArrayList<Student>();

	static {
		slist.add(new Student(101, "Rahul", 80));
		slist.add(new Student(102, "Shubham", 90));
		slist.add(new Student(103, "Vikash", 60));
		slist.add(new Student(104, "Shashank", 75));

	}

	public List<Student> getAllStudent() {
		return slist;
	}

	public Student getStudentById(int stuid) {
		return slist.stream().filter(s -> s.getSid() == stuid).collect(Collectors.toList()).get(0);
	}

	public List<Student> addStudent(Student stu) {
		slist.add(stu);
		return slist;
	}

	public List<Student> removeStudent(int stuid) {
		slist.removeIf(s -> s.getSid() == stuid);
		return slist;
	}

	public List<Student> updateStudent(int sid, Student stu) {
		slist = slist.stream().map(s -> { // map ke "b" aapko Book ka ek-ek obj deta jayega, but it will also expect one obj of same type in return.
			if (s.getSid() == sid) {
				s.setSname(stu.getSname());
				s.setSpoints(stu.getSpoints());
			}
			return s;
		}).collect(Collectors.toList());

		return slist;

	}

}

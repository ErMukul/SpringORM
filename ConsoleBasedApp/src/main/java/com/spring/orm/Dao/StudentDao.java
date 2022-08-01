package com.spring.orm.Dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.entities.Student;

public class StudentDao {
	
	private HibernateTemplate hibernateTemplate;
	
	//Saving Date of Student
	
	@Transactional
	public int insert(Student student)
	{
		Integer i=(Integer)this.hibernateTemplate.save(student);
		
		return i;
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	//Showing data of all Student
	public List<Student> getAllStudent()
	{
		List<Student> list=(List<Student>)this.hibernateTemplate.loadAll(Student.class);
		return list;
	}
	
	//Deleting Data of Student
	@Transactional
	public void deleteStudent(int sid)
	{
		Student sdt=(Student)this.hibernateTemplate.get(Student.class, sid);
		this.hibernateTemplate.delete(sdt);
	}
	
	//Updating Students
	@Transactional
	public void updateStudent(Student student)
	{
		this.hibernateTemplate.update(student);
		
	}

}

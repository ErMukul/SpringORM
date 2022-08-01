package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.Dao.StudentDao;
import com.spring.orm.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Project Started.." );
        ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
        StudentDao sdo=(StudentDao)context.getBean("studentDao");
        
        //Reading from Console
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        //To show option Again and Again
        boolean flag=true;
        while(flag)
        {
        	System.out.println("Press 1 : To add the Student...");
        	System.out.println("Press 2 : Showing all Student Data...");
        	System.out.println("Press 3 : Delete data of a Student...");
        	System.out.println("Press 4 : Update the Data of Student...");
        	System.out.println("Press 5 : To exit from App..");
        	
        	try {
        		int in=Integer.parseInt(br.readLine());
        		
        		
        		
        		switch(in) {
        		
        		case 1:
        			//Add Student
        			
        			System.out.println("Enter the Id : ");
        			int sid=Integer.parseInt(br.readLine());
        			System.out.println("Enter the Name : ");
        			String sName=br.readLine();
        			System.out.println("Enter the City : ");
        			String sCity=br.readLine();
        			
        			//Setting Data to Student Object
        			Student sd=new Student(sid,sName,sCity);
        			
        			//Inserting Data into DataBase
        			int i=sdo.insert(sd);
        			System.out.println("Data of Id: "+i+" Saved Successfully");
        			break;
        		case 2:
        			//Get Details of all Student
        			List<Student> list=(List<Student>)sdo.getAllStudent();
        			
        			//fetching students with for each loop
        			for(Student s:list)
        			{
        				System.out.println("Id : "+s.getId());
        				System.out.println("Name : "+s.getName());
        				System.out.println("City : "+s.getCity());
        			}
        			break;
        		case 3:
        			//Delete a Student data
        			System.out.println("Enter the Id of Student : ");
        			int id=Integer.parseInt(br.readLine());
        			sdo.deleteStudent(id);
        			System.out.println("Student Deleted...");
        			break;
        		case 4:
        			//Update the data of Student
        			System.out.println("Enter the Id : ");
        			int sid1=Integer.parseInt(br.readLine());
        			System.out.println("Enter the Name : ");
        			String sName1=br.readLine();
        			System.out.println("Enter the City : ");
        			String sCity1=br.readLine();
        			Student student1=new Student(sid1,sName1,sCity1);
        			
        			sdo.updateStudent(student1);
        			
        			
        			break;
        		case 5:
        			//To exit from Application
        			
        			flag=false;
        			break;
        		}
        		
        	}catch(Exception e) {System.out.println("Please Enter valid Input...");}
        }
        System.out.println("Thank you for using this App....");
        System.out.println("Please!.. visit again...");
    }
}

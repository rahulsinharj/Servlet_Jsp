package com.rest.controller;

import java.util.Date;
import java.util.List;

import com.rest.dao.StudentDao;
import com.rest.model.Student;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("student")		
public class StudentController {
	
	StudentDao sdao = new StudentDao();
/*
#	If we have mentioned @Produces(MediaType.APPLICATION_XML)	=> then PostMan se data XML parse karke get karne liye we have to also ask Jersey to do XmlMarshelling  
			=> for that we have to put @XmlRootElement in our entity class.  
		
			[OPTIONAL]::	{When Client explicitly/strictly tells server -> For sending data in XML format from SERVER to CLIENT (in PostMan)-> We can also put 'Accept' , 'Content-Type' = application/xml }
							{For sending XML data from Client to Server (eg- in PostMan Client)-> we can select 'XML' in 'Body' in PostMan } 
 ---------------------------------------------------------------------------------------------------------------------------------
#	If we have mentioned @Produces(MediaType.APPLICATION_JSON)	=> then we only need to add required dependency in pom.xml , that's it

			[OPTIONAL]::	{We can also put 'Accept' , 'Content-Type' = application/json (eg- in PostMan Client)} 	
							{For sending JSON data from Client to Server (in PostMan)-> we can select 'JSON' in 'Body' in PostMan } 
			
	“Accept” is a request header and “Content-Type” is both request and response header.	
	
 ----------	
	@Produces(MediaType.APPLICATION_JSON)  or, @Produces(MediaType.APPLICATION_XML) nhi likhege to ByDefault XML hi milega in Jersey, unline in Spring ByDefault JSON milega.
	
 ---------------------------------------------------------------------------------------------------------------------------------		
*/	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_XML)						// This line is SHOWING data to Client in only XML format, from Server 
	public List<Student> getStudent()							// "Produces" matlab server se result kis format me return hoga, i.e, Kis format me client ko response dikhega.
	{
		System.out.println("GetStudent called..at "+new Date());
		
		return sdao.getAllStudent();
	}
	
	@GET
	@Path("/{id}")												// {id} is a placeholder here
 	@Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})				// This is called content negotiation of JSON and XML format data to be shown to Client (sent in response from server)			
	public Student getStudentById(@PathParam("id") int sid)							// From PostMan, client can as preferred ask the type of data format as per his choice, 
	{																						// by putting 'Accept' = application/json , or	'Accept' = application/xml
		return sdao.getStudentById(sid);
	}
	
	@POST
	@Path("/")															// "produces" is somehow like 'return type' of the method ; and "consumes" is somehow like 'accepting parameters Type' of the method.  
 	@Produces(MediaType.APPLICATION_JSON)						// With this line, Server will SEND data to Client (for showing data to client) in only JSON format, as the returned things of this method.
	@Consumes(MediaType.APPLICATION_JSON)						// With this line, Server will ACCEPT data from Client in only JSON format, for here POSTmapping method (creating obj with that data). Consumed data will be stored in this method's parameter Student obj. 
	public List<Student> createStudent(Student stu)						// "consumes" means the type of data that Server will accept from Client.
	{
		System.out.println(stu);
		return sdao.addStudent(stu);
	}
	
	@DELETE
	@Path("/{sid}")
 	@Produces(MediaType.APPLICATION_JSON)				
	public List<Student> removeStudent(@PathParam("sid") int sid)
	{
		return sdao.removeStudent(sid);
	}
	
	@PUT
	@Path("/{sid}")
 	@Produces(MediaType.APPLICATION_JSON)										// If we remove this line, then bydefault data will be returned as XML format to client - bydefault		
	public List<Student> updateStudent(@PathParam("sid") int sid , Student stu)
	{
		return sdao.updateStudent(sid, stu);
	}
	
}

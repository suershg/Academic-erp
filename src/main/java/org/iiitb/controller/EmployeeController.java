package org.iiitb.controller;


import com.google.gson.JsonObject;
import org.iiitb.bean.Employee;
import org.iiitb.service.EmployeeService;
import org.iiitb.service.impl.EmployeeServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.ws.rs.core.Response;

@Path("/employee")
public class EmployeeController {
    EmployeeService emp = new EmployeeServiceImpl();
    public class Status{
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Status()
        {

        }
        String status;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String testM()
    {
        return "hello";
    }


    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes(MediaType.APPLICATION_JSON)
    //@Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response validate(Employee employee)
    {
        Status status = new Status();

        List<Employee> emplist;
        emplist = emp.getall();
        System.out.println(emplist);
        for(Employee e : emplist)
        {
            System.out.println("working.............................................");
            if(employee.getEmail().equals(e.getEmail()))
            {
                if(employee.getPassword().equals(e.getPassword()))
                {
                    status.status = "success";
                   return Response.ok().entity(status).build();
                }
                else
                {
                    status.status =  "invalid";
                    return Response.ok().entity(status).build();
                }
            }
        }
        status.status = "invalid_outside";
        return Response.ok().entity(status).build();
    }

}

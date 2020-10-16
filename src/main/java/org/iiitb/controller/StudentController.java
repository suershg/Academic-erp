package org.iiitb.controller;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.iiitb.bean.Student;
import org.iiitb.service.StudentService;
import org.iiitb.service.impl.StudentServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Path("/student")
public class StudentController {
    private StudentService studentService = new StudentServiceImpl();
    class Studlist{
        String fname;
        String mname;
        String lname;
        String rollno;
        String discipline;
        String branch;
        String specialization;
        public Studlist() {
        }

        public String getFname() {
            return fname;
        }

        public void setFname(String fname) {
            this.fname = fname;
        }

        public String getMname() {
            return mname;
        }

        public void setMname(String mname) {
            this.mname = mname;
        }

        public String getLname() {
            return lname;
        }

        public void setLname(String lname) {
            this.lname = lname;
        }

        public String getRollno() {
            return rollno;
        }

        public void setRollno(String rollno) {
            this.rollno = rollno;
        }

        public String getDiscipline() {
            return discipline;
        }

        public void setDiscipline(String discipline) {
            this.discipline = discipline;
        }

        public String getBranch() {
            return branch;
        }

        public void setBranch(String branch) {
            this.branch = branch;
        }

        public String getSpecialization() {
            return specialization;
        }

        public void setSpecialization(String specialization) {
            this.specialization = specialization;
        }
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response showAllStudent() {
        List<String[]> studentList = studentService.findAll();
        if (studentList == null)
            return Response.noContent().build();

        List<Studlist> list1 = new ArrayList<>();
        for(String[] s1 : studentList)
        {
                  Studlist stud = new Studlist();
                  stud.fname = s1[0];
                  stud.mname = s1[1];
                  stud.lname = s1[2];
                  stud.rollno = s1[3];
                  stud.discipline = s1[4];
                  stud.branch = s1[5];
                  stud.specialization = s1[6];
                  list1.add(stud);
        }

        return Response.ok().entity(list1).build();
    }
}

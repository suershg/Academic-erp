package org.iiitb.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.iiitb.bean.Course;
import org.iiitb.bean.Domain;
import org.iiitb.bean.Student;
import org.iiitb.util.SessionUtil;

import java.util.*;


public class StudentDao {



    public List<String[]> findAll() {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Student";
        Query query = session.createQuery(hql);
        List<Student> studentList = query.list();

        List<String[]> st=new ArrayList<>();


        for(Student s: studentList)
        {

            List<Course> s1=s.getCourses();
            int ans=0;
            HashMap<String,Integer> h=new HashMap<>();
            for(Course c:s1)
            {
                String s2=c.getSpecialization();
                if(h.containsKey(s2))
                {
                    int c1=h.get(s2);
                    c1=c1+c.getCredits();
                    h.replace(s2,c1);
                }
                else
                {
                    int c1=c.getCredits();
                    h.put(s2,c1);
                }

            }
            /*t set=h.entrySet();
            Iterator i=set.iterator();
            while(i.hasNext())
            {

            }*/
            String s3="None";
            for(Map.Entry<String,Integer> m:h.entrySet())
            {
                if(m.getValue()>=2)
                    s3=m.getKey();
            }
            String[] st1=new String[7];
            st1[0]=s.getFirstName();
            st1[1]=s.getMiddleName();
            st1[2]=s.getLastName();
            st1[3]=s.getRollNumber();
            st1[4]= s.getDomain().getDiscipline();
            st1[5]=s.getDomain().getBranch();
            st1[6]=s3;
            st.add(st1);

        }




        transaction.commit();
        session.close();
        return st;
    }

}
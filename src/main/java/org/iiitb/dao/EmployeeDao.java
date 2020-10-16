package org.iiitb.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.iiitb.bean.Employee;
import org.iiitb.util.SessionUtil;
import java.util.List;

public class EmployeeDao {
    Employee employee = new Employee();
    public List<Employee> getall()
    {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Employee";
        Query query = session.createQuery(hql);

        List<Employee> employees = query.list();

        transaction.commit();
        session.close();

        return employees;
    }
}

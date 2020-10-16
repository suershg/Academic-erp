package org.iiitb.service.impl;

import org.iiitb.bean.Student;
import org.iiitb.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    @Override
    public List<String[]> findAll() {
        return studentDao.findAll();
    }
    

}

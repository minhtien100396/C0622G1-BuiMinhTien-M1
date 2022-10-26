package repository.impl;

import bean.Student;
import repository.IStudentRepository;

import java.util.*;

public class StudentRepository implements IStudentRepository {

    static Map<Integer,Student> studentMap;

    static {
        studentMap = new TreeMap<>();
        studentMap.put(1,new Student(1,"Bùi Minh Tiến","1996-03-10",0,2.0));
        studentMap.put(2,new Student(2,"Nguyễn Thị Nguyệt","1999-08-121",1,8.0));
        studentMap.put(3,new Student(3,"Bùi Minh Tuấn","1997-12-27",0,10.0));
        studentMap.put(4,new Student(4,"Nguyễn Văn Huy","2000-02-11",0,7.0));
        studentMap.put(5,new Student(5,"Phan Minh Châu","1999-02-15",1,9.0));
    }
    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentMap.values());
    }

    @Override
    public Student findById(Integer id) {
        return null;
    }

    @Override
    public void save(Student student) {

    }
}
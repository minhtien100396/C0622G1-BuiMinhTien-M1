package repo;

import model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    Student findById(Integer id);
    void save(Student student);
    String callTransaction();
    List<Student> findByKeyWord(String key);
}

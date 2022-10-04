package service.impl;

import model.Student;
import repo.IStudentRepository;
import repo.impl.StudentRepository;
import service.IStudentService;

import java.util.List;

public class StudentService implements IStudentService {
    private IStudentRepository studentRepository = new StudentRepository();

    @Override
    public List<Student> findAll() {
        return this.studentRepository.findAll();
    }

    @Override
    public Student findById(Integer id) {
        return null;
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> findByKeyWord(String key) {
        return studentRepository.findByKeyWord(key);
    }

    @Override
    public String callTransaction() {
        return studentRepository.callTransaction();
    }

}

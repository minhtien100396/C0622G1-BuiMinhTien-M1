package repo.impl;

import model.Student;
import repo.IStudentRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class StudentRepository implements IStudentRepository {
    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        try {
            //Statement: thực thi, ResultSet: hứng kết quả
            Statement statement = BaseRepository.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select id, `name`, birthday\n" +
                    "from student");
            //Để đọc từng hàng trong table thì ta dùng resultSet.next()
            Student student = null;
            while (resultSet.next()) {
                student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setDateOfBirth(resultSet.getString("birthday"));
                studentList.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return studentList;
    }

    @Override
    public Student findById(Integer id) {
        return null;
    }

    @Override
    public void save(Student student) {
        try {
            PreparedStatement preparedStatement = BaseRepository.connection.prepareStatement(
                    "insert into student(`name`, birthday)\n" +
                        "values (?, ?)"
            );
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getDateOfBirth());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

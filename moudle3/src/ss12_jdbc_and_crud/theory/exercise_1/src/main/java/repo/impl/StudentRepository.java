package repo.impl;

import model.Student;
import repo.IStudentRepository;

import java.sql.*;
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
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getDateOfBirth());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public String callTransaction() {
        String msg = "OK, transaction successfully";
        Connection connection = BaseRepository.connection;
        try {
            connection.setAutoCommit(false);
            PreparedStatement pSInsertClass = connection.prepareStatement("insert into class (id, `name`)\n" +
                    "values (?,?)");
            pSInsertClass.setString(1, "6");
            pSInsertClass.setString(2, "c0922G1");
            int rowAffect = pSInsertClass.executeUpdate();

            PreparedStatement pSInsertRoom = connection.prepareStatement("insert into room (id, `name`, class_id)\n" +
                    "values (?,?,?)");
            pSInsertRoom.setString(1, "6");
            pSInsertRoom.setString(2, "Elit");
            pSInsertRoom.setString(3, "6");

            rowAffect += pSInsertRoom.executeUpdate();

            if (rowAffect == 2) {
                PreparedStatement pSInsertStudent = connection.prepareStatement("insert into student (id, `name`,class_id)\n" +
                        "values (?,?,?)");
                pSInsertStudent.setString(1, "20");
                pSInsertStudent.setString(2, "Bia");
                pSInsertStudent.setString(3, "20");

                rowAffect += pSInsertStudent.executeUpdate();
            }

            if (rowAffect == 3) {
                connection.commit();
            } else {
                msg = "rollback try";
                connection.rollback();
            }
        } catch (SQLException e) {
            try {
                msg = "rollback catch";
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return msg;
    }

    @Override
    public List<Student> findByKeyWord(String key) {
        List<Student> studentList = new ArrayList<>();
        try {
            CallableStatement callableStatement = BaseRepository.connection.prepareCall("call find_by_name (?);\n ");
            callableStatement.setString(1, key);
            ResultSet resultSet = callableStatement.executeQuery();
            Student student;
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
}

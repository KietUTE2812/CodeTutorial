package org.example.cuoiki_code_tutorial.Dao;

import org.example.cuoiki_code_tutorial.Models.Student;
import org.example.cuoiki_code_tutorial.Utils.HandleException;
import org.example.cuoiki_code_tutorial.Utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    private static final String SELECT_ALL_STUDENT = "select * from students st join facultys fa on st.idfaculty = fa.id;";
    private static final String ADD_NEW_STUDENT = "Call AddStudent(?, ?, ?, ?, ?, ?)";
    private static final String EDIT_STUDENT = "Call editStudent(?,?, ?, ?, ?, ?, ?)";
    private static final String DELETE_STUDENT = "Delete from students where id = ?";
    public List<Student> selectAllAccount()
    {
        List<Student> listSt = new ArrayList<>();
        try
        {

            Connection conn = MySQLConnection.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ALL_STUDENT);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next())
            {
                int id = rs.getInt("id");
                String code =rs.getString("code");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String gender = rs.getString("gender");
                LocalDate bd = LocalDate.parse(rs.getString("birthday"));
                String fac = rs.getString("name");
                listSt.add(new Student(id, code, firstName, lastName, gender, bd, fac));    		}
        }
        catch(SQLException e)
        {
            HandleException.printSQLException(e);
        }
        return listSt;
    }
    public boolean addStudent(Student s)
    {
        try
        {
            Connection conn = MySQLConnection.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(ADD_NEW_STUDENT);

            preparedStatement.setString(1, s.getCode());
            preparedStatement.setString(2, s.getFirstName());
            preparedStatement.setString(3, s.getLastName());
            preparedStatement.setString(4, s.getGender());
            preparedStatement.setString(5, s.getBirthday().toString());
            preparedStatement.setString(6, s.getFaculty());

            preparedStatement.executeUpdate();

        }
        catch(SQLException e)
        {
            HandleException.printSQLException(e);
            return false;
        }
        return true;
    }
    public boolean editStudent(Student s)
    {
        try
        {
            Connection conn = MySQLConnection.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(EDIT_STUDENT);
            preparedStatement.setInt(1, s.getId());
            preparedStatement.setString(2, s.getCode());
            preparedStatement.setString(3, s.getFirstName());
            preparedStatement.setString(4, s.getLastName());
            preparedStatement.setString(5, s.getGender());
            preparedStatement.setString(6, s.getBirthday().toString());
            preparedStatement.setString(7, s.getFaculty());
            preparedStatement.executeUpdate();

        }
        catch(SQLException e)
        {
            HandleException.printSQLException(e);
            return false;
        }
        return true;
    }
    public boolean removeStudent(int id)
    {
        try
        {
            Connection conn = MySQLConnection.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(DELETE_STUDENT);

            preparedStatement.setInt(1, id);


            preparedStatement.executeUpdate();

        }
        catch(SQLException e)
        {
            HandleException.printSQLException(e);
            return false;
        }
        return true;
    }
}

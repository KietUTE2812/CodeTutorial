package org.example.cuoiki_code_tutorial.Dao;

import org.example.cuoiki_code_tutorial.Models.BaiHoc;
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

public class BaiHocDAO {
    public String noiDungBaiHoc(String maBH, String maChuong) {
        String noiDung = null;
        String query = "call GetNoiDungByMaBHMaChuong(?, ?)";
        try {
            Connection conn = MySQLConnection.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, maBH);
            preparedStatement.setString(2, maChuong);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                noiDung = rs.getString("NoiDung");
            }
            rs.close();
            preparedStatement.close();
            conn.close();
        } catch (SQLException e) {
            HandleException.printSQLException(e);
        }
        return noiDung;
    }

    public String tenBaiHoc(String maBH, String maChuong) {
        String tenBaiHoc = null;
        String query = "call GetTenBaiHocByMaBHMaChuong(?, ?)";
        try {
            Connection conn = MySQLConnection.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, maBH);
            preparedStatement.setString(2, maChuong);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                tenBaiHoc = rs.getString("TenBH");
            }
            rs.close();
            preparedStatement.close();
            conn.close();
        } catch (SQLException e) {
            HandleException.printSQLException(e);
        }
        return tenBaiHoc;
    }

    public List<Integer> getThuTuByMaChuong(String maChuong) throws SQLException {
        List<Integer> thuTuList = new ArrayList<>();
        String query = "CALL getThuTuByMaChuong(?);";

        try {

            Connection conn = MySQLConnection.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, maChuong);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                thuTuList.add(rs.getInt("ThuTu"));
            }
            rs.close();
            preparedStatement.close();
            conn.close();
        } catch (SQLException e) {
            HandleException.printSQLException(e);
        }


        return thuTuList;
    }


}

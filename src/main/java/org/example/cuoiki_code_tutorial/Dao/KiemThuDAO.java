package org.example.cuoiki_code_tutorial.Dao;

import org.example.cuoiki_code_tutorial.Models.KiemThu;
import org.example.cuoiki_code_tutorial.Utils.HandleException;
import org.example.cuoiki_code_tutorial.Utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KiemThuDAO {
    public List<KiemThu> getKiemThu(String maChuong) throws SQLException {
        List<KiemThu> thuTuList = new ArrayList<>();
        String query = "CALL getThuTuByMaChuong(?);";

        try {

            Connection conn = MySQLConnection.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, maChuong);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {

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

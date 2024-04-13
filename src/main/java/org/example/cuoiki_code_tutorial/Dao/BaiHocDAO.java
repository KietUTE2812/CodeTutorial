package org.example.cuoiki_code_tutorial.Dao;

import org.example.cuoiki_code_tutorial.Models.BaiHoc;

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

    public BaiHoc getBaiHocByMaBHMaChuong(String maBH, String maChuong)
    {
        BaiHoc baiHoc = null;
        String query= "call get_baihoc_by_mabh_machuong(?, ?);";
        try
        {
            Connection conn = MySQLConnection.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, maBH);
            preparedStatement.setString(2, maChuong);

            ResultSet rs = preparedStatement.executeQuery();

            if(rs.next())
            {
                String tenBaiHoc = rs.getString("TenBH");
                String noiDung = rs.getString("NoiDung");
                int GHKT = rs.getInt("GioiHanKyTu");
                String mucDo = rs.getString("MucDo");

                baiHoc = new BaiHoc(tenBaiHoc, noiDung, GHKT, mucDo);
            }
            rs.close();
            preparedStatement.close();
            conn.close();
        } catch (SQLException e) {
            HandleException.printSQLException(e);
            throw new RuntimeException(e);
        }
        return baiHoc;
    }
    public BaiHoc getBaiHocByThuTu(int thuTu)
    {
        BaiHoc baiHoc = null;
        String query= "call get_baihoc_by_thutu(?);";
        try
        {
            Connection conn = MySQLConnection.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1,thuTu);


            ResultSet rs = preparedStatement.executeQuery();

            if(rs.next())
            {
                String tenBaiHoc = rs.getString("TenBH");
                String noiDung = rs.getString("NoiDung");
                int GHKT = rs.getInt("GioiHanKyTu");
                String mucDo = rs.getString("MucDo");

                baiHoc = new BaiHoc(tenBaiHoc, noiDung, GHKT, mucDo);
            }
            rs.close();
            preparedStatement.close();
            conn.close();
        } catch (SQLException e) {
            HandleException.printSQLException(e);
            throw new RuntimeException(e);
        }
        return baiHoc;
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

    public String tenBaiHocByThuTu(int thuTu) {
        String tenBaiHoc = null;
        String query = "call GetTenBaiHocByThuTu(?);";
        try {
            Connection conn = MySQLConnection.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, thuTu);

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
    public String noiDungByThuTu(int thuTu) {
        String noiDung = null;
        String query = "call GetNoiDungByThuTu(?);";
        try {
            Connection conn = MySQLConnection.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, thuTu);

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


}

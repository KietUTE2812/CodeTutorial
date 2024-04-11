package org.example.cuoiki_code_tutorial.Dao;

import org.example.cuoiki_code_tutorial.Models.BaiHoc;
import org.example.cuoiki_code_tutorial.Models.Chuong;
import org.example.cuoiki_code_tutorial.Utils.HandleException;
import org.example.cuoiki_code_tutorial.Utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ChuongDAO {
    private static final String SELECT_ALL_CHUONG = "select * from chuong where MaKH = ? Order by thuTu";
    private static final String SELECT_ALL_BAIHOC = "select * from baihoc where MaChuong = ?";
    public List<Chuong> getAllChuong(String MaKH)
    {
        List<Chuong> chuongList = new ArrayList<Chuong>();
        try
        {
            Connection conn = MySQLConnection.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ALL_CHUONG);
            preparedStatement.setString(1, MaKH);

            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next())
            {
                String id = rs.getString("MaChuong");
                String tenChuong = rs.getString("TenChuong");
               int thuTu = rs.getInt("ThuTu");
                chuongList.add(new Chuong(id, tenChuong, thuTu, MaKH));    		}

        }
        catch(SQLException e)
        {
            HandleException.printSQLException(e);
            return null;
        }
        return chuongList;
    }
    public List<BaiHoc> getAllBaiHoc(String MaChuong)
    {
        List<BaiHoc> baiHocList = new ArrayList<BaiHoc>();
        try
        {
            Connection conn = MySQLConnection.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ALL_BAIHOC);
            preparedStatement.setString(1, MaChuong);

            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next())
            {
                String id = rs.getString("MaBH");
                String tenBaiHoc = rs.getString("TenBH");
                String NoiDung = rs.getString("NoiDung");
                int ThoiLuong = rs.getInt("ThoiLuong");
                int ThuTu = rs.getInt("ThuTu");
                int TrangThai = rs.getInt("TrangThai");
                baiHocList.add(new BaiHoc(id, tenBaiHoc, NoiDung, ThoiLuong, MaChuong, ThuTu, TrangThai));    		}

        }
        catch(SQLException e)
        {
            HandleException.printSQLException(e);
            return null;
        }
        return baiHocList;
    }
}

package org.example.cuoiki_code_tutorial.Dao;

import org.example.cuoiki_code_tutorial.Models.Chuong;
import org.example.cuoiki_code_tutorial.Models.KhoaHoc;
import org.example.cuoiki_code_tutorial.Utils.HandleException;
import org.example.cuoiki_code_tutorial.Utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class KhoaHocDAO {
    private static final String SELECT_KHOA_HOC = "select * from khoahoc where MaKH = ?";
    private static final String SELECT_ALL_KHOA_HOC = "select * from khoahoc";
    public KhoaHoc getKhoaHoc(String MaKH)
    {
        KhoaHoc khoaHoc = null;
        try
        {
            Connection conn = MySQLConnection.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_KHOA_HOC);
            preparedStatement.setString(1, MaKH);

            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next())
            {
                String id = rs.getString("MaKH");
                String tenChuong = rs.getString("TenKH");
                String MoTa = rs.getString("MoTa");
                String HinhAnh = rs.getString("HinhAnh");
                String NgayTao = rs.getString("NgayTao");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                int TrangThai = rs.getInt("TrangThai");
                String MaAD = rs.getString("MaAD");
                khoaHoc = new KhoaHoc(id, tenChuong, MoTa, HinhAnh, LocalDate.parse(NgayTao, formatter), TrangThai, MaAD);    		}

        }
        catch(SQLException e)
        {
            HandleException.printSQLException(e);
            return null;
        }
        return khoaHoc;
    }
    public List<KhoaHoc> getAllKhoaHoc()
    {
        List<KhoaHoc> khoaHocs = new ArrayList<>();
        try
        {
            Connection conn = MySQLConnection.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ALL_KHOA_HOC);

            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next())
            {
                String id = rs.getString("MaKH");
                String tenChuong = rs.getString("TenKH");
                String MoTa = rs.getString("MoTa");
                String HinhAnh = rs.getString("HinhAnh");
                String NgayTao = rs.getString("NgayTao");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                int TrangThai = rs.getInt("TrangThai");
                String MaAD = rs.getString("MaAD");
                khoaHocs.add(new KhoaHoc(id, tenChuong, MoTa, HinhAnh, LocalDate.parse(NgayTao, formatter), TrangThai, MaAD));    		}

        }
        catch(SQLException e)
        {
            HandleException.printSQLException(e);
            return null;
        }
        return khoaHocs;
    }
}

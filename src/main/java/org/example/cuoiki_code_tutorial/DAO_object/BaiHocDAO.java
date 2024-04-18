package org.example.cuoiki_code_tutorial.DAO_object;

import org.example.cuoiki_code_tutorial.Models.BaiHoc;
import org.example.cuoiki_code_tutorial.Utils.HandleException;
import org.example.cuoiki_code_tutorial.Utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BaiHocDAO extends SysDAO<BaiHoc, String> {

    @Override
    public void insert(BaiHoc entity) {

    }

    @Override
    public void update(BaiHoc entity) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public BaiHoc selectById(String id) {
        return null;
    }

    @Override
    public List<BaiHoc> selectAll() {
        return null;
    }

    @Override
    protected List<BaiHoc> selectBySql(String sql, Object... args) {
        return null;
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

                String codeMau = rs.getString("CodeMau");

                baiHoc = new BaiHoc(tenBaiHoc, noiDung, GHKT, mucDo, codeMau);
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
}

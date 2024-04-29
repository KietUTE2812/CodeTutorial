package org.example.cuoiki_code_tutorial.DAOv2;

import org.example.cuoiki_code_tutorial.Models.BaiHoc;
import org.example.cuoiki_code_tutorial.Utils.ConnectJDBC;
import org.example.cuoiki_code_tutorial.Utils.HandleException;
import org.example.cuoiki_code_tutorial.Utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaiHocDAO extends SysDAO<BaiHoc, String> {

    @Override
    public void insert(BaiHoc entity) {
        String sql = "INSERT INTO BaiHoc (MaBaiHoc, TenBaiHoc, NoiDung, DinhDang, ThoiLuong, MaChuong, ThuTu, TrangThai, GioiHanKyTu, MucDo, CodeMau, MaKhoaHoc) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        ConnectJDBC.update(sql,
                entity.getMaBaiHoc(),
                entity.getTenBaiHoc(),
                entity.getNoiDung(),
                entity.getDinhDang(),
                entity.getThoiLuong(),
                entity.getMaChuong(),
                entity.getThuTu(),
                entity.getTrangThai(),
                entity.getGioiHanKyTu(),
                entity.getMucDo(),
                entity.getCodeMau(),
                entity.getMaKhoaHoc());
    }

    @Override
    public void update(BaiHoc entity) {
        String sql = "UPDATE BaiHoc SET TenBaiHoc=?, NoiDung=?, DinhDang=?, ThoiLuong=?, MaChuong=?, ThuTu=?, TrangThai=?, GioiHanKyTu=?, MucDo=?, CodeMau=?, MaKhoaHoc=? WHERE MaBaiHoc=?";
        ConnectJDBC.update(sql,
                entity.getTenBaiHoc(),
                entity.getNoiDung(),
                entity.getDinhDang(),
                entity.getThoiLuong(),
                entity.getMaChuong(),
                entity.getThuTu(),
                entity.getTrangThai(),
                entity.getGioiHanKyTu(),
                entity.getMucDo(),
                entity.getCodeMau(),
                entity.getMaKhoaHoc(),
                entity.getMaBaiHoc());
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM BaiHoc WHERE MaBaiHoc=?";
        ConnectJDBC.update(sql, id);
    }

    @Override
    public BaiHoc selectById(String id) {
        String sql = "SELECT * FROM BaiHoc WHERE MaBaiHoc=?";
        List<BaiHoc> list = selectBySql(sql, id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<BaiHoc> selectAll() {
        String sql = "SELECT * FROM BaiHoc";
        return selectBySql(sql);
    }

    @Override
    protected List<BaiHoc> selectBySql(String sql, Object... args) {
        List<BaiHoc> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = ConnectJDBC.query(sql, args);
                while (rs.next()) {
                    BaiHoc entity = new BaiHoc();
                    // Extract values from result set and set them in the BaiHoc object
                    entity.setMaBaiHoc(rs.getString("MaBH"));
                    entity.setTenBaiHoc(rs.getString("TenBH"));
                    entity.setNoiDung(rs.getString("NoiDung"));
                    entity.setDinhDang(rs.getString("DinhDang"));
                    entity.setThoiLuong(rs.getInt("ThoiLuong"));
                    entity.setMaChuong(rs.getString("MaChuong"));
                    entity.setThuTu(rs.getInt("ThuTu"));
                    entity.setTrangThai(rs.getInt("TrangThai")); // Assuming TrangThai is an integer
                    entity.setGioiHanKyTu(rs.getInt("GioiHanKyTu"));
                    entity.setMucDo(rs.getString("MucDo"));
                    entity.setCodeMau(rs.getString("CodeMau"));
                    entity.setMaKhoaHoc(rs.getString("MaKhoaHoc"));

                    list.add(entity);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }

        } catch (SQLException e) {
            HandleException.printSQLException(e);
            throw new RuntimeException(e);
        }
        return list;
    }


    public BaiHoc getBaiHocByThuTu(int thuTu) {
        String sql = "call get_baihoc_by_thutu(?);";
        return (BaiHoc) this.selectBySql(sql, thuTu);
    }

    public BaiHoc getBaiHocByMaBHMaChuong(String maBH, String maChuong) {
        String query = "call get_baihoc_by_mabh_machuong(?, ?);";
        return (BaiHoc) this.selectBySql(query, maBH, maChuong);

    }

    public List<Integer> getThuTuByMaChuong(String maChuong) throws SQLException {
        List<Integer> thuTuList = new ArrayList<>();
        String query = "CALL getThuTuByMaChuong(?);";

        try{
            ResultSet rs = ConnectJDBC.query(query);
            while(rs.next()){
                thuTuList.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return thuTuList;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}

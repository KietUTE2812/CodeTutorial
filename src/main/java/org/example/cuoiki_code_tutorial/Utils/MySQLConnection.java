package org.example.cuoiki_code_tutorial.Utils;

import org.example.cuoiki_code_tutorial.Dao.BaiHocDAO;
import org.example.cuoiki_code_tutorial.Dao.StudentDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLConnection {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/codelearn", "root", "thanhbinh1411");
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return con;
	}
	public static void main(String[] args) throws SQLException {
		Connection conn = MySQLConnection.getConnection();
		if(conn != null) {
			System.out.println("Connect to MySQL successfully!");
			conn.close();
		}else
			System.out.println("Can not connect to MySQL!");

		String maBH = "bai1";
		String maChuong = "chuong4";

		BaiHocDAO baihoc = new BaiHocDAO();
		String noiDung = baihoc.tenBaiHoc(maBH, maChuong);
		List<Integer> thuTu = new ArrayList<>();
		thuTu = baihoc.getThuTuByMaChuong(maChuong);
		for (int item : thuTu){
			System.out.println(item);
		}


//		if (noiDung != null) {
//			System.out.println("Nội dung của bài học có mã " + maBH + " thuộc chương " + maChuong + " là: " + noiDung);
//		} else {
//			System.out.println("Không tìm thấy nội dung cho bài học có mã " + maBH + " thuộc chương " + maChuong);
//		}
	}
	
}

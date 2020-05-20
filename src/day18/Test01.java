package day18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class DB {
	public DB() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void DBconnect() throws SQLException {
		// ip : vmware @192.168.0.10(본인 ip):1521:ex;
		// 로컬 pc : @localhost:1521:xe; 또는 @127.0.0.1, 실제ip:1521:xe
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "java001";
		String pwd = "1234";
		Connection con = null;
		String sql = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, id, pwd);
			/*
			String s = "1234a";
			//sql = "insert into newst values('" + s + "', '홍', 20)";
			sql = "insert into newst values(?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, "다른값12");
			ps.setString(2,  "김");
			ps.setInt(3, 1234);
			//rs = ps.executeQuery();
			int result =ps.executeUpdate();
			if(result==1) {
				System.out.println("성공적으로 저장");
			}
			*/
			//System.out.println("result : " + result);
			//insert는 rs.next()가 없음.
			//select를 제외한 나머지는 보편적으로 executeUpdate() 사용
			/*
			sql = "update newst set name=?, age=? where id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, "zzzz");
			ps.setInt(2, 1111);
			ps.setString(3, "111");
			ps.executeUpdate();
			*/
			sql = "select * from newst";
			ps = con.prepareStatement(sql); // 전송객체로 바꿔줌
			rs = ps.executeQuery(); // 전송객체를 쿼리문으로 실행시켜줌 그리고 resultset으로 변환
			
			sql = "delete from newst where id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, "111");
			ps.executeUpdate();
			
			System.out.println("id\tname\t\tage");
			System.out.println("-------------------------");
			while (rs.next()) {
				System.out.print(rs.getString("id") + "\t");
				System.out.print(rs.getString("name") + "\t\t");
				System.out.println(rs.getString("age"));
				System.out.println("==============");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

public class Test01 {

	public static void main(String[] args) {
		
		DB db = new DB();
		try {
			db.DBconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

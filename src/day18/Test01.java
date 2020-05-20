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
		// ip : vmware @192.168.0.10(���� ip):1521:ex;
		// ���� pc : @localhost:1521:xe; �Ǵ� @127.0.0.1, ����ip:1521:xe
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
			//sql = "insert into newst values('" + s + "', 'ȫ', 20)";
			sql = "insert into newst values(?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, "�ٸ���12");
			ps.setString(2,  "��");
			ps.setInt(3, 1234);
			//rs = ps.executeQuery();
			int result =ps.executeUpdate();
			if(result==1) {
				System.out.println("���������� ����");
			}
			*/
			//System.out.println("result : " + result);
			//insert�� rs.next()�� ����.
			//select�� ������ �������� ���������� executeUpdate() ���
			/*
			sql = "update newst set name=?, age=? where id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, "zzzz");
			ps.setInt(2, 1111);
			ps.setString(3, "111");
			ps.executeUpdate();
			*/
			sql = "select * from newst";
			ps = con.prepareStatement(sql); // ���۰�ü�� �ٲ���
			rs = ps.executeQuery(); // ���۰�ü�� ���������� ��������� �׸��� resultset���� ��ȯ
			
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

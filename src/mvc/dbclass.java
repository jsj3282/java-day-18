package mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.net.aso.e;

class dbclass {

	public dbclass() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "java001";
	String pwd = "1234";
	Connection con = null;
	String sql = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public void createTable() {

		try {
			con = DriverManager.getConnection(url, this.id, this.pwd);
			sql = "create table student(id varchar2(20), name varchar2(20), age number, primary key(id))";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
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
	
		
	public ArrayList<student> memberView() {
		ArrayList<student> arr = new ArrayList<student>();
		try {
			con = DriverManager.getConnection(url, this.id, this.pwd);
			sql = "select * from student";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				student st = new student();
				st.setId(rs.getString("id"));
				st.setName(rs.getString("name"));
				st.setAge(rs.getInt("age"));
				arr.add(st);
				//return arr;
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
		return arr;
	}
	
	public void memberAdd(String id, String name, int age) {
		try {
			con = DriverManager.getConnection(url, this.id, this.pwd);
			sql = "insert into student values(?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setInt(3, age);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
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

	public void memberUpdate(String id, String name, int age) {

		try {
			student st = new student();
			con = DriverManager.getConnection(url, this.id, this.pwd);
			sql = "update student set name=?, age=? where id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1,name);
			ps.setInt(2, age);
			ps.setString(3, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
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

	public void memberDelete(String id) {

		try {
			con = DriverManager.getConnection(url, this.id, this.pwd);
			student st = new student();
			sql = "delete from student where id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
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

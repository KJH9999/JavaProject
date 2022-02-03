package com.java.ex.db.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.java.ex.gui.ResultForm;


public class UserDAO {

	static String driver = "org.mariadb.jdbc.Driver";
	static String url = "jdbc:mariadb://localhost:3307/pj";
	static String uid = "root";
	static String pwd = "1234";
	
	static Connection con = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;
	static PreparedStatement pstmt2 = null;

	
	public UserDAO() {

	}
	//login 성공
	 public static int login(String userID, String userPassword) {
		 
			try {
				Class.forName(driver);
				con=DriverManager.getConnection(url,uid,pwd);
				stmt = con.createStatement();
				
				System.out.println("드라이버 접속 성공");
				
			} catch (ClassNotFoundException e) {
				System.out.println("드라이버 로드 실패");
			}
			catch (SQLException e2) {
				System.out.println("접속 실패");
			}

			String query = null;	
			query = "select m_pw from users where m_id = ?AND m_pw = ?";	
	    	try {
	    		pstmt = con.prepareStatement(query);
				pstmt.setString(1,  userID);
				pstmt.setString(2,  userPassword);
				rs = pstmt.executeQuery();
				if (rs.next()) {
						return 1; 
					}
				return -1; 
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
					if(pstmt2 != null) pstmt2.close();

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
				
			return -2;		 
	 }
	//가입 
	public static int insert(UserDTO dto ) {
		
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,uid,pwd);
			stmt = con.createStatement();
			
			System.out.println("드라이버 접속 성공");
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
		}
		catch (SQLException e2) {
			System.out.println("접속 실패");
		}
	
		String query = null;	
		try {
			query = "insert into users values (?,?,?,?,?,?)";
			
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1,dto.getId());
			pstmt.setString(2,dto.getPw());
			pstmt.setString(3,dto.getName());
			pstmt.setString(4,null);
			pstmt.setString(5,dto.getPosition());
			pstmt.setString(6,null);
	
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
				if(pstmt2 != null) pstmt2.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return -1;
	}

	//매니저 스태프 구분 user
	public static String selectMS(String m_id) {
		
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,uid,pwd);
			stmt = con.createStatement();
			
			System.out.println("드라이버 접속 성공");
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
		}
		catch (SQLException e2) {
			System.out.println("접속 실패");
		}
		String query = null;
		String pos = null;
		
		try {
			query = "SELECT m_position FROM users WHERE m_id = " +'"'+ m_id+'"';
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				pos = rs.getString("m_position");
			}

			return pos;
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
				if(pstmt2 != null) pstmt2.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return pos;
		
	}
	
	public static String selectS() {
		
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,uid,pwd);
			stmt = con.createStatement();
			
			System.out.println("드라이버 접속 성공");
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
		}
		catch (SQLException e2) {
			System.out.println("접속 실패");
		}
		
		String query = null;
		String stf = null;
		try {
			query = "SELECT m_position FROM users WHERE m_id = " +'"' +"1234" +'"';
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				stf = rs.getString("m_position");
			}

			return stf;
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
				if(pstmt2 != null) pstmt2.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return stf;
		
	}
	//staff근무신청
	public static int update_num(String m_id,String m_num) {
		
		String query = null;
		
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,uid,pwd);
			stmt = con.createStatement();
			
			System.out.println("드라이버 접속 성공");
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
		}
		catch (SQLException e2) {
			System.out.println("접속 실패");
		}
		
		try {
			query = "update users set m_num = ? where m_id = ?";
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, m_num);
			pstmt.setString(2, m_id);
			
			int r = pstmt.executeUpdate();
			
			return r;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
				if(pstmt2 != null) pstmt2.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return -1;
		
	}
	//staff 근무신청
	public static int update_str(String m_id,String m_str) {
		
		String query = null;
		
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,uid,pwd);
			stmt = con.createStatement();
			
			System.out.println("드라이버 접속 성공");
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
		}
		catch (SQLException e2) {
			System.out.println("접속 실패");
		}
		
		try {
			query = "update users set m_str = ? where m_id = ?";
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, m_str);
			pstmt.setString(2, m_id);
			
			int r = pstmt.executeUpdate();
			
			return r;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
				if(pstmt2 != null) pstmt2.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return -1;
		
	}

	//manager 매장확인
	public static void staff_str_num(String m_id) {
		String query1 = null;
		String query2 = null;
		String query3 = null;
		String query = null;
		String name = null;
		String marketName = null;
		String id = null;



		try {
			query1 = "select m_name from users where m_id = " + '"'+ m_id+'"';
			rs=stmt.executeQuery(query1);
			
			while(rs.next()) {
				name = rs.getString("m_name");
			}
			
			query = "select marketName from market where manager_name =" +'"'+ name +'"';
			rs = stmt.executeQuery(query);		
			
			while(rs.next()) {
				marketName = rs.getString("marketName");
			}
			
			query2 = "select staff_id from con_m_u wehre marketName = " +'"'+ marketName +'"';
			rs = stmt.executeQuery(query2);
			
			while(rs.next()) {
				id = rs.getString("m_id");
			}
			
			query3 = "select m_name , m_num, m_str from users where m_id";
			rs = stmt.executeQuery(query3);
			
			ResultForm.txtResult.setText("이름\t번호\t자기소개"+ "\n");
			while(rs.next()) {
				String str = rs.getString("m_name") + "\t" + rs.getString("m_num") + "\t" + rs.getString("m_str") + "\n";  
				ResultForm.txtResult.append(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
		
	
	
}
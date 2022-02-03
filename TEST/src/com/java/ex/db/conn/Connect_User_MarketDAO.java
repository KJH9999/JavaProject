package com.java.ex.db.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.java.ex.db.user.UserDAO;
import com.java.ex.gui.ResultForm;
import com.java.ex.gui.staff.Staff;

public class Connect_User_MarketDAO {
	static String driver = "org.mariadb.jdbc.Driver";
	static String url = "jdbc:mariadb://localhost:3307/pj";
	static String uid = "root";
	static String pwd = "1234";
	
	static Connection con = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;
	static PreparedStatement pstmt2 = null;

	
	public Connect_User_MarketDAO() {

	}
	
	//근무 신청시 marketName staff_id con_m_u TB에 추가
	public static int insert_S_M(String market_name, String staff_id) {
		
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
			query = "insert into con_m_u values (?,?)";
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, staff_id);
			pstmt.setString(2, market_name);
			
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;	
	}
	
	//staff 근무 취소
	public static int Delete_S_M(String m_id) {
		
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
		String query1 = null;
		String query2 = null;
		String market_name = null;
		
		try {
			query1 = "select marketName from con_m_u where staff_id =" + '"'+ m_id +'"';
			rs = stmt.executeQuery(query1);
			while(rs.next()) {
				market_name = rs.getString("marketName");
			}
			System.out.println(market_name);
			
			query2 ="update market set staff_cnt = staff_cnt-1 where marketName = " + '"'+ market_name +'"';
			pstmt= con.prepareStatement(query2);
			int res = pstmt.executeUpdate();
			
				try {
					query = "delete from con_m_u where staff_id = " + '"' + m_id + '"';
					pstmt2= con.prepareStatement(query);
					return  res += pstmt2.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				}
						
		}catch(Exception e) {
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
	
	//staff 근무확인 lbl
	public static void true_or_flase(String m_id) {
		
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
			query = "select * from con_m_u where staff_id = " +'"'+ m_id+'"';
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				String str = rs.getString("marketName");
				Staff.lb2.setText(str);
			}
	
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
	}
	
	//manager매장 삭제
	public static int Delete_Market(String market_name) {
		
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
			query = "delete from con_m_u where marketName = " + '"'+ market_name+'"';
			pstmt= con.prepareStatement(query);
			int res = pstmt.executeUpdate();
			return  res;
		}catch(Exception e) {
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
	
	//manager 매장확인을 위한 배열 맞추기
	public static int insert_M(String market_id) {
		
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
		String name = null;
		
		try {
			query = "insert into con_m_u values (?,?)";
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, "a_" + market_id);
			pstmt.setString(2, market_id);
			
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

}

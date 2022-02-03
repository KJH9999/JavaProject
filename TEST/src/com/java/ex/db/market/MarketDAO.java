package com.java.ex.db.market;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import javax.swing.JButton;

import com.java.ex.db.user.UserDAO;
import com.java.ex.gui.ResultForm;

public class MarketDAO {
	static String driver = "org.mariadb.jdbc.Driver";
	static String url = "jdbc:mariadb://localhost:3307/pj";
	static String uid = "root";
	static String pwd = "1234";
	
	static Connection con = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;
	static PreparedStatement pstmt2 = null;
	
	public MarketDAO() {

	}
	
		//staff에서 매장출력
		public static void SelcetMarket() {
			
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
				query = "select * from market";
				rs = stmt.executeQuery(query);

				ResultForm.txtResult.setText("매장이름\t위치\tMANAGER"+ "\n");
				ResultForm.txtResult.append("-------------------------------------------------------------------" +"\n");
					while(rs.next()) {
						String str = rs.getString("marketName") + "\t" + rs.getString("location") + "\t" + rs.getString("manager_name") + "\n";  
						ResultForm.txtResult.append(str);
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
		

		//manager market 생성
		public static int insert_M(String market_name, String location, String m_id) {
			
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
			String query2 = null;
			String name = null;
			
			try {
				query = "insert into market values (?,?,?,?)";
				query2 = "select m_name from users where m_id =" +'"'+ m_id+'"';
				
				rs=stmt.executeQuery(query2);
				
				while(rs.next()) {
					name = rs.getString("m_name");
				}
				//System.out.println(name);
				
				pstmt = con.prepareStatement(query);
				
				pstmt.setString(1, market_name);
				pstmt.setString(2, location);
				pstmt.setInt(3, 0);
				pstmt.setString(4, name);
				
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
		
		//manager 매장확인
		public static void SelcetMarket_Manager(String m_id){
			
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
			String query3 = null;
			String name = null;
			String market_name = null;
			String[] staff_id = new String[7];

			try {
				query1 = "select m_name from users where m_id = " + '"'+ m_id+'"';
				rs=stmt.executeQuery(query1);
				
				while(rs.next()) {
					name = rs.getString("m_name");
				}
				
				
				query = "select * from market where manager_name =" +'"'+ name +'"';
				rs = stmt.executeQuery(query);
				
				ResultForm.txtResult.setText("매장이름\t위치\t신청인원"+ "\n");
				
				while(rs.next()) { 
					String str = rs.getString("marketName") + "\t" + rs.getString("location") + "\t"+ rs.getString("staff_cnt") + "\n";  
					ResultForm.txtResult.append(str);
				}
				
				ResultForm.txtResult.append("---------------------------------------------------------------"+ "\n");
				
				query = "select marketName from market where manager_name =" +'"'+ name +'"';
				rs = stmt.executeQuery(query);
				
				while(rs.next()) {
					market_name = rs.getString("marketName");
				}
				
				query2 = "select staff_id from con_m_u where marketName = "  +'"' +market_name + '"';
				rs = stmt.executeQuery(query2);
				
				while(rs.next()) {
					for(int i=0; rs.next();i++) {
					staff_id[i] = rs.getString("staff_id");
					}
				}
				
				int len = staff_id.length;

				ResultForm.txtResult.append("신청자 이름\t번호\t자기소개"+ "\n");
				
				for(int j = 0; j <len; j++) {
					query3 = "select * from users where m_id = " + '"' + staff_id[j] + '"';
					rs = stmt.executeQuery(query3);
					
					while(rs.next()) {
						String str2 = rs.getString("m_name") + "\t" + rs.getString("m_num") + "\t"+ rs.getString("m_str") + "\n";  
						ResultForm.txtResult.append(str2);
					}
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

		//매장삭제
		public static int DeleteMarket(String market_name) {
			
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
				query = "delete from market where marketName = " + '"'+ market_name+'"';
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
		
		//market TB staff_cnt 증가
		public static int Staffcnt_P(String market_name) {
			
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
				query = "update market set staff_cnt = staff_cnt+1 where marketName = " + '"'+ market_name+'"';
				pstmt= con.prepareStatement(query);
				int res = pstmt.executeUpdate();
				return res;
				
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
		
		//market TB staff_cnt 감소
		public static int Staffcnt_M(String m_id) {
			
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

			String query1 = null;
			String query2 = null;
			String market_name = null;
			
			try {
				query1 = "select marketName from con_m_u where staff_id =" + '"'+ m_id +'"';
				rs = stmt.executeQuery(query1);
				while(rs.next()) {
					market_name = rs.getString("marketName");
				}
				query2 ="update market set staff_cnt = staff_cnt-1 where marketName = " + '"'+ market_name +'"';
				pstmt= con.prepareStatement(query2);
				int res = pstmt.executeUpdate();
				return res;
				
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
		/*
		public static void find_Staff(String m_id) {
			String query1;
			String name = null;
			String query;
			String[] marekt_name = null;
			
			try {
				query1 = "select m_name from users where m_id = " + '"'+ m_id+'"';
				rs=stmt.executeQuery(query1);
				
				while(rs.next()) {
					name = rs.getString("m_name");
				}
				
				query = "select marketName from market where manager_name =" +'"'+ name +'"';
				rs = stmt.executeQuery(query);
				
				int i=0;
				while(rs.next()) {
					
					marekt_name[i] = rs.getString("marketName");
					
					Manage_Market.btn[i] = new JButton(marekt_name[i]);
					Manage_Market.btn[i].setBounds(30,10 + 40*i, 100,30);    
					
					Manage_Market.btn[i].addActionListener(new ActionListener() {  
						public void actionPerformed(ActionEvent e) {
							UserDAO.staff_str_num(marekt_name[i]);
							ResultForm rf = new ResultForm();
			             }  
			          });
					
					i++;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		*/

}

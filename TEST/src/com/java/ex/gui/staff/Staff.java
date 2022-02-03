package com.java.ex.gui.staff;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.java.ex.db.conn.Connect_User_MarketDAO;
import com.java.ex.db.market.MarketDAO;
import com.java.ex.db.user.UserDAO;
import com.java.ex.gui.ResultForm;

public class Staff extends JFrame{

	Font f1,f2,f3;
	
	public static JLabel lb2 = new JLabel(); 
	
	public Staff(String m_id) {
		f1 = new Font("돋움",Font.PLAIN,15);
		f2 = new Font("돋움",Font.PLAIN,9);
		
		JLabel lb1 = new JLabel();            
		lb1.setBounds(20,30, 300,50);  
		lb1.setFont(f1);
		lb1.setText("  Staff : " + m_id + "님");
		
		Connect_User_MarketDAO.true_or_flase(m_id);
		lb2.setBounds(20,100, 300,50);  
		lb2.setFont(f1);
		
		
        JFrame f = new JFrame("Staff");
        
		JButton bt1 = new JButton("매장보기");    
		bt1.setBounds(150,70, 120,30);    
		bt1.setFont(f1);
        
		//매장 클릭시 staff신청내역 체크박스로 포함 체크해서 채용
		
		JButton bt2 = new JButton("닫기");    
		bt2.setBounds(150,150, 120,30);    
		bt2.setFont(f1);
		
		JButton bt0 = new JButton("신청하기");    
		bt0.setBounds(150,30, 120,30);    
		bt0.setFont(f1);
		
		JButton bt3 = new JButton("신청취소");    
		bt3.setBounds(150,110, 120,30);    
		bt3.setFont(f1);
		
		bt0.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {
				//신청창 텍스트 매장이름입력 > market 스테프+1 > 매장,스태프 커넥터
				Request rq = new Request(m_id);
			}  
          });
		
		bt1.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {
				MarketDAO.SelcetMarket();
				ResultForm rf = new ResultForm();
             }  
          });
		
		bt2.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {       
				setVisible(false);
				System.exit(0);
             }  
          });
		
		bt3.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {       
				if(Connect_User_MarketDAO.Delete_S_M(m_id) == 2) {
					JOptionPane.showMessageDialog(null, "신청취소 성공", "신청 취소", JOptionPane.INFORMATION_MESSAGE);
					
				}else {
					JOptionPane.showMessageDialog(null, "신청쉬소 실패", "오류", JOptionPane.ERROR_MESSAGE);

				}
             }  
          });
		
		f.add(lb2);
		f.add(bt3);
		f.add(bt0);
		f.add(bt1);
        f.add(bt2);        
        f.add(lb1);
        f.setSize(300, 250);
        f.setVisible(true);
	
	}

}

package com.java.ex.gui.manager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.java.ex.db.conn.Connect_User_MarketDAO;
import com.java.ex.db.market.MarketDAO;
import com.java.ex.db.user.UserDAO;

public class Create_Market extends JFrame{
	
	Font f1,f2,f3;
	
	Create_Market(String m_id) {
		f1 = new Font("돋움",Font.PLAIN,15);
		f2 = new Font("돋움",Font.PLAIN,9);
		
		JLabel lb2=new JLabel("매장이름 : ");    
		lb2.setBounds(20,50, 80,30);
		lb2.setFont(f1);
		
		JTextField tf1 = new JTextField();
		tf1.setBounds(100,50, 100,30);
		tf1.setFont(f1);
		
		JLabel lb3=new JLabel("매장위치 : ");    
		lb3.setBounds(20,100, 80,30);
		lb3.setFont(f1);
		
		JTextField tf2 = new JTextField();
		tf2.setBounds(100,100, 100,30);
		tf2.setFont(f1);
		
        JButton bt1 = new JButton("매장생성");    
		bt1.setBounds(100,140, 100,30);    
		bt1.setFont(f1);
		
        JButton bt2 = new JButton("닫기");    
		bt2.setBounds(100,180, 100,30);    
		bt2.setFont(f1);
		
		bt1.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {  
				//String manager = select name from user where id="1234"
				String market_name = tf1.getText();
				String location = tf2.getText();
				
				//MarketDAO.insert_M(market_name, location, m_id);
				//MarketDAO.Staffcnt_P(market_name);
				if(	MarketDAO.insert_M(market_name, location, m_id) == 1) {
					Connect_User_MarketDAO.insert_M(market_name);
					JOptionPane.showMessageDialog(null, "매장생성 성공", "프로그램을 재실행 해주세요", JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
				
				}

				else {
					JOptionPane.showMessageDialog(null, "매장생성 실패", "매장생성 실패", JOptionPane.ERROR_MESSAGE);
				}
				
             }  
          });
		
		bt2.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {  
				setVisible(false);
             }  
          });
		
		add(lb2);add(tf1);add(bt1);add(tf2);add(lb3);add(bt2);
		setTitle("Market창");
		setSize(320,260);
		setLayout(null);
		setVisible(true);
	}
}

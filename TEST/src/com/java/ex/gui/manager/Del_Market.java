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

public class Del_Market extends JFrame {
	
	Font f1,f2,f3;
	
	Del_Market(String m_id) {
		f1 = new Font("돋움",Font.PLAIN,15);
		f2 = new Font("돋움",Font.PLAIN,9);
		
		JLabel lb = new JLabel("매장이름 : ");
		lb.setBounds(30,50, 100,30);
		lb.setFont(f1);
		
		JTextField tf1 = new JTextField();
		tf1.setBounds(100,50, 100,30);
		tf1.setFont(f1);
		
        JButton bt1 = new JButton("삭제");    
		bt1.setBounds(100,90, 100,30);    
		bt1.setFont(f1);
		
        JButton bt2 = new JButton("닫기");    
		bt2.setBounds(100,130, 100,30);    
		bt2.setFont(f1);
		
		
		
		bt1.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {  
				//삭제 쿼리
				String market_name = tf1.getText();
				
				if(MarketDAO.DeleteMarket(market_name) == 1) {
					Connect_User_MarketDAO.Delete_Market(market_name);
					JOptionPane.showMessageDialog(null, "매장 삭제", "삭제 성공", JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);

				}
				else {
					JOptionPane.showMessageDialog(null, "오류", "삭제 실패", JOptionPane.ERROR_MESSAGE);

				}
				
             }  
          });
		
		bt2.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {  
				setVisible(false);
             }  
          });
		
		add(lb);
		add(tf1);add(bt1);add(bt2);
		setTitle("Market 삭제");
		setSize(320,230);
		setLayout(null);
		setVisible(true);
	}
}

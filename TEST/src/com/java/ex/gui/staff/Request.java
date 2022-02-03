package com.java.ex.gui.staff;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.java.ex.db.conn.Connect_User_MarketDAO;
import com.java.ex.db.market.MarketDAO;
import com.java.ex.db.user.UserDAO;

public class Request extends JFrame{
	Font f1,f2,f3;
	
	Request(String m_id) {
		f1 = new Font("돋움",Font.PLAIN,15);
		f2 = new Font("돋움",Font.PLAIN,9);
		
		JLabel lb2=new JLabel("매장이름 : ");    
		lb2.setBounds(20,10, 80,30);
		lb2.setFont(f1);
		
		JTextField tf1 = new JTextField();
		tf1.setBounds(100,10, 100,30);
		tf1.setFont(f1);
		//번호
		
		JLabel lb3=new JLabel("번호 : ");    
		lb3.setBounds(20,50, 80,30);
		lb3.setFont(f1);
		
		JTextField tf2 = new JTextField();
		tf2.setBounds(100,50, 100,30);
		tf2.setFont(f1);
		
        JButton bt1 = new JButton("근무 신청");    
		bt1.setBounds(30,300, 100,30);    
		bt1.setFont(f1);

		
        JButton bt2 = new JButton("닫기");    
		bt2.setBounds(150,300, 100,30);    
		bt2.setFont(f1);
		
		JTextArea txt = new JTextArea();
		txt.setBounds(10, 90 , 280,200);
		txt.setText("전달할 메시지를 입력해주세요.(100자 이내)");
		
		bt1.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {
				
				String market_name = tf1.getText();
				String m_num = tf2.getText();
				String m_str = txt.getText();
				
				if(Connect_User_MarketDAO.insert_S_M(market_name, m_id) == 1) {
					JOptionPane.showMessageDialog(null, "성공", "신청 완료", JOptionPane.INFORMATION_MESSAGE);
					UserDAO.update_num(m_id,m_num);
					UserDAO.update_str(m_id,m_str);
					MarketDAO.Staffcnt_P(market_name);
					setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "오류", "신청실패", JOptionPane.ERROR_MESSAGE);
				}
             }  
          });
		
		bt2.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
             }  
          });
		
		add(lb2);add(tf1);add(bt1);add(bt2);add(txt);add(lb3);add(tf2);
		setTitle("Request창");
		setSize(320,380);
		setLayout(null);
		setVisible(true);
	}



}

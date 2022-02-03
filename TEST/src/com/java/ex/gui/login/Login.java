package com.java.ex.gui.login;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.java.ex.db.user.UserDAO;
 
public class Login extends JFrame {
	Font f1,f2;
	
	public Login(){
		
		f1 = new Font("돋움",Font.PLAIN,15);
		f2 = new Font("돋움",Font.PLAIN,9);
		
		JLabel lb1 = new JLabel();            
		lb1.setBounds(20,200, 300,50);  
		lb1.setFont(f1);
   
		JLabel lb2=new JLabel("       ID  :");    
		lb2.setBounds(20,50, 80,30);
		lb2.setFont(f1);
		
		JTextField tf1 = new JTextField();  
		tf1.setBounds(100,50, 100,30);
		tf1.setFont(f1);
		
		JLabel lb3=new JLabel("      PW  :");    
		lb3.setBounds(20,100, 80,30);
		lb3.setFont(f1);
		
		JPasswordField pw1 = new JPasswordField();   
		pw1.setBounds(100,100,100,30);
		pw1.setFont(f1);
		
		JButton bt1 = new JButton("Login");    
		bt1.setBounds(100,150, 80,30);    
		bt1.setFont(f1);
		//버튼 클릭시 로그인
		
		JButton bt2 = new JButton("회원가입");    
		bt2.setBounds(50,200, 80,30);    
		bt2.setFont(f2);
		//회원가입창 이동
		
		JButton bt3 = new JButton("닫기");    
		bt3.setBounds(150,200, 80,30);    
		bt3.setFont(f2);
		
		
		bt1.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {       
				   //login =>  tf1=id , pw1= pw
				// select id from M S dto
 				// -> M S 폼화면
				
				String lid = tf1.getText();
				String lpw = pw1.getText();
				
				if(UserDAO.login(lid,lpw) == 1) {
					JOptionPane.showMessageDialog(null, "Login", "로그인 성공", JOptionPane.INFORMATION_MESSAGE);
					Select_M_S users = new Select_M_S(lid);
					setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "Login", "Login 실패", JOptionPane.ERROR_MESSAGE);
				}
				
             }  
          });
		
		bt2.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {       
				Sign_up  create = new Sign_up();
             }  
          });
		
		bt3.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {       
				setVisible(false);
				System.exit(0);
             }  
          });
		
		
 
		add(lb1);add(pw1);
		add(lb2);add(tf1);
		add(lb3);add(bt1);
		add(bt2);add(bt3);
		setTitle("로그인 창");
		setSize(320,320);
		setLayout(null);
		setVisible(true);
		
	}

}
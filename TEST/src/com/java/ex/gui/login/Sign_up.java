package com.java.ex.gui.login;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.java.ex.db.user.UserDAO;
import com.java.ex.db.user.UserDTO;

 
public class Sign_up extends JFrame{
	Font f1,f2;
	
    JRadioButton[] rb=new JRadioButton[2];
    String[] names={"manager", "staff"};
	
	Sign_up(){
		
		f1 = new Font("돋움",Font.PLAIN,15);
		f2 = new Font("돋움",Font.PLAIN,9);
		
		JLabel lb1 = new JLabel();            
		lb1.setBounds(20,200, 300,50);  
		lb1.setFont(f1);
   
		JLabel lb2=new JLabel("ID:");    
		lb2.setBounds(20,50, 80,30);
		lb2.setFont(f1);
		
		JLabel lb3=new JLabel("PW:");    
		lb3.setBounds(20,100, 80,30);
		lb3.setFont(f1);
		
		JLabel lb4=new JLabel("Name:");    
		lb4.setBounds(20,150, 80,30);
		lb4.setFont(f1);
		
		JTextField tf1 = new JTextField();  
		tf1.setBounds(100,50, 100,30);
		tf1.setFont(f1);
		
		JTextField tf2 = new JTextField();  
		tf2.setBounds(100,150, 100,30);
		tf2.setFont(f1);
	
		JButton btn = new JButton("회원가입");    
		btn.setBounds(50,250, 80,30);    
		btn.setFont(f2);
		
		JButton bt1 = new JButton("닫기");    
		bt1.setBounds(150,250, 80,30);    
		bt1.setFont(f2);
		
		
		JPasswordField pw1 = new JPasswordField();   
		pw1.setBounds(100,100,100,30);
		pw1.setFont(f1);
		
		ButtonGroup group=new ButtonGroup();

        for(int i=0; i<rb.length; i++){
            rb[i]=new JRadioButton(names[i]);
            group.add(rb[i]);
            rb[i].setBounds(50+100*i,200, 100,30);
            this.add(rb[i]);
        }
        rb[0].setSelected(true);
  
		btn.addActionListener(new ActionListener() {  
			private String m_id = null;
			private String m_pw = null;
			private String m_name = null;
			private String m_positon = null;
			private String m_str = null;
			private String m_num = null;

			public void actionPerformed(ActionEvent e) {      
				 m_id = tf1.getText();
				 m_pw = pw1.getText();
				 m_name = tf2.getText();
				 m_positon = null;
				 m_str = null;
				 m_num = null;
				
				if ( rb[0].isSelected() == true ) {
					m_positon = "manager";
				}
				else if ( rb[1].isSelected() == true ) {
					m_positon = "staff";
				}
				 
				UserDTO dao = new UserDTO(m_id,m_pw,m_name,m_positon,m_str,m_num);
				//UserDAO.insert(dao);
							
				if(UserDAO.insert(dao) == 1) {
					JOptionPane.showMessageDialog(null, "회원가입 성공", "프로그램을 재실행 해주세요", JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
				}

				else if(tf1.getText() == null || tf2.getText() == null || pw1.getText() == null){
					JOptionPane.showMessageDialog(null, "회원가입 실패", "회원가입 실패", JOptionPane.ERROR_MESSAGE);

				}else {
					JOptionPane.showMessageDialog(null, "회원가입 실패", "회원가입 실패", JOptionPane.ERROR_MESSAGE);
					
				}
				

             }  
          });
        
		bt1.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {       
				setVisible(false);
             }  
          });
		
		add(lb1);add(pw1);
		add(lb2);add(tf2);
		add(lb3);add(lb4);
		add(tf1);add(bt1);
		add(lb3);add(btn);
		setTitle("회원가입");
		setSize(320,350);
		setLayout(null);
		setVisible(true);
	}

}
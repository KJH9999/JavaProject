package com.java.ex.gui.manager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.java.ex.db.market.MarketDAO;
import com.java.ex.db.user.UserDAO;
import com.java.ex.gui.ResultForm;

public class Manager extends JFrame{
	Font f1,f2,f3;
	

	public Manager(String m_id) {
		f1 = new Font("����",Font.PLAIN,15);
		f2 = new Font("����",Font.PLAIN,9);
		
		JLabel lb1 = new JLabel();            
		lb1.setBounds(20,30, 300,50);  
		lb1.setFont(f1);
		lb1.setText("  Manager : " + m_id + "��");
		
        JFrame f = new JFrame("Manager");

        JButton bt = new JButton("���� ����");    
		bt.setBounds(150,110, 120,30);    
		bt.setFont(f1);
        
        
        JButton bt0 = new JButton("���� Ȯ��");    
		bt0.setBounds(150,70, 120,30);    
		bt0.setFont(f1);
        
        JButton bt1 = new JButton("�������");    
		bt1.setBounds(150,30, 120,30);    
		bt1.setFont(f1);
		
		//���� Ŭ���� staff��û���� üũ�ڽ��� ���� üũ�ؼ� ä��x
		//���� ��û ��Ȳ���� -> print
		
		JButton bt2 = new JButton("�ݱ�");    
		bt2.setBounds(150,150, 120,30);    
		bt2.setFont(f1);
		
		bt.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {
				//���� ���� ���� MarketDAO
				//DropMarket class -> �Է�â
				Del_Market dm = new Del_Market(m_id);             }  
          });
		
		bt0.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {
				MarketDAO.SelcetMarket_Manager(m_id);
				ResultForm rf = new ResultForm();
             }  
          });
		
		bt1.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {  
				Create_Market market = new Create_Market(m_id);
             }  
          });
		
		bt2.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {       
				setVisible(false);
				System.exit(0);
             }  
          });
		
		f.add(bt);
		f.add(bt0);
        f.add(bt1);
        f.add(bt2);        
        f.add(lb1);
        f.setSize(300, 250);
        f.setVisible(true);
	
	}
	

}

package com.java.ex.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class ResultForm extends JFrame{

	Font f1,f2,f3;
	public static JTextArea txtResult = new JTextArea();
	public ResultForm() {
		JFrame f = new JFrame("���");

		f1 = new Font("����",Font.PLAIN,15);
		f2 = new Font("����",Font.PLAIN,9);

        JButton bt = new JButton("�ݱ�");    
		bt.setBounds(170,170, 80,30);    
		bt.setFont(f1);
		
		bt.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {  
				f.setVisible(false);
             }  
          });
        
		f.add(bt);
		f.add(txtResult);
        f.setSize(300, 250);	        
        f.setVisible(true);
		
	}

}
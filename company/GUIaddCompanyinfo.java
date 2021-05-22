package company;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUIaddCompanyinfo extends JPanel{
	
	public GUIaddCompanyinfo() {
	
		this.setLayout(new BorderLayout());
		
		this.setPreferredSize(new Dimension(500, 90)); // �г� ũ�� ����
		
		
		JLabel label = new JLabel("�߰��� ȸ���� ��� ���� ��Ȳ�� �����ϼ���.");
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		add(label, BorderLayout.NORTH);
		
		JPanel select = new JPanel();
		select.setLayout(new FlowLayout());
		add(select ,BorderLayout.CENTER);
	
		
		JButton HV = new JButton("��ź���");
		select.add(HV);
		HV.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new GUIaddHavevaccineComInfo();
				
	
		
				
				
			}
		});
		
		
		JButton CPV = new JButton("�����Ź����");
		select.add(CPV);
		CPV.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new GUIaddCPcomInfo();
				
			}
		});
		
		
		
		JButton UDV = new JButton("��Ű�����");
		select.add(UDV);
		UDV.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				new GUIaddUDcomInfo();
				
			}
		});
		

	}
	
	

}

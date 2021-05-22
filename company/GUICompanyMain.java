package company;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.color.*;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import vaccine.Moderna;
import vaccine.SideEffect;
import vaccine.VaccineProduct;
import vaccine.VaccineType;
import vaccineView.*;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class GUICompanyMain extends JFrame implements ActionListener{
	
	
	
	public static final int WIDTH = 1050;
	public static final int HEIGHT = 300;
	static String header[] = {"����з�","����̸�", "���/���ߴܰ�/��Ź��û���", "��� �Ǹű���", "��� �Ѵ޻��귮"};//, "CEO" , "������" ,"������ġ", "��� ��"
	static DefaultTableModel model = new DefaultTableModel(null, header);
	public JTable table = new JTable( model);
	public JPanel infomenu = new JPanel();
	public static JPanel in1 = new JPanel();
	public static JPanel in2 = new JPanel();
	public boolean addj = true;
	public TextAdaptor TA = new TextAdaptor();
	private VaccineType.VaccineTypes[] vaccineTypes = VaccineType.VaccineTypes.values();
	
	private ArrayList<Company> companies = new ArrayList<Company>();
	
	
	
//	public static void main(String[] args) {
//		GUICompanyMain gui = new GUICompanyMain();		
//		gui.setVisible(true); 
//		
//
//	}
	
	public GUICompanyMain() {
		
		
		super("�ڷγ� ��� ȸ��");
		setSize(WIDTH, HEIGHT);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());	
		this.setVisible(true);
		setLocationRelativeTo(null);
		this.start(); // ǥ ������ �ҷ�����
		

		
		
		
		
		table.setPreferredScrollableViewportSize(new Dimension(1000, 100)); // ��ũ�� ���� ũ��
		table.setFillsViewportHeight(true); //�����̳��� ��ü���̸� ���̺��� ���� ���
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //���̺� ���� �ϳ��� ���� ����
//		table.getColumnModel().getColumn(3).setWidth(60);
//		table.getColumnModel().getColumn(3).setMinWidth(60);
//		table.getColumnModel().getColumn(3).setMaxWidth(60);
		
		JPanel tablePanel = new JPanel();
		tablePanel.setSize(1000, 100);
		tablePanel.add(new JScrollPane(table));
		add(tablePanel, BorderLayout.CENTER);
		

		

		infomenu.setLayout(new GridLayout(1,2));
		//infomenu.add(infoinsert);
		JPanel in1 = new JPanel();
		in1.setSize(600, 100);
		in2.setSize(600, 100);
		JPanel in2 = new JPanel();
		
		infomenu.add(in1);
		infomenu.add(in2);
		add(infomenu, BorderLayout.SOUTH);
		
		
		

		JPanel buttonpanel = new JPanel();
		buttonpanel.setLayout(new FlowLayout());
		GUIaddCompanyinfo gac = new GUIaddCompanyinfo();
		
		
		JButton addC = new JButton("��� �߰�");
		addC.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(addj == true) {
				in1.add(gac);
				in1.revalidate(); // �г� �ʱ�ȭ�ؼ� add�޴��� ���
				addj = false;
				}else {
					in1.remove(gac);
					in1.revalidate();
					addj = true;
				}

				
				
				
			}		
		});
		buttonpanel.add(addC);
		
		
		
		JButton addS = new JButton("ȸ�� ���� ����");
		addS.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int selectrow = table.getSelectedRow();
				if(selectrow == -1) {
					JOptionPane.showMessageDialog(table, "���� �������ּ���.");
					return;
				}else {
					Object seltype = model.getValueAt(selectrow, 0);
					Object selname = model.getValueAt(selectrow, 1);
					new SeeDetailGUI(seltype, selname);
				}
						
			}			
		});
		buttonpanel.add(addS);
	
		
		JButton reset = new JButton("���� ��ħ"); // �ؽ�Ʈ -> ���̺� ����ȭ
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				model.setNumRows(0);
				String filePath = "ȸ�絥����.txt";
				File file = new File(filePath);
				
				if(file.exists()) {
					try {
						String s;
						String[] array;
						BufferedReader reader = new BufferedReader(new FileReader(file));
						while((s=reader.readLine()) != null) {
							
							array=s.split("-");
							model.addRow(array);
						}
						reader.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}

				
			}
			
			
		});
		buttonpanel.add(reset);
		reset.doClick();
		
		
		
		JButton del = new JButton("����");
		del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int selectrow = table.getSelectedRow();
				if(selectrow == -1) {
					JOptionPane.showMessageDialog(table, "������ ���� �������ּ���.");
					return;
				}
				String dummy ="";
				String filePath = "ȸ�絥����.txt";
				File file = new File(filePath);
				try {
					BufferedReader reader = new BufferedReader(new FileReader(file));
					String line;
					for(int i=0; i<selectrow; i++) {
						line = reader.readLine();
						dummy += (line+"\r\n");
					}
					String delDate = reader.readLine();
					while((line = reader.readLine()) != null) {
						dummy += (line + "\r\n");
					}
					
					FileWriter fw = new FileWriter(file);
					fw.write(dummy);
					fw.close();
					reader.close();
				}catch(Exception e1) {
					e1.printStackTrace();
				}

				TA.readtext(); // �ؽ�Ʈ -> ȸ�� ��ü ����Ʈ ����ȭ
				reset.doClick();

				
				
			}
			
		});
		buttonpanel.add(del);
		
		
		
		JLabel expl = new JLabel("��ư�� �� �� ���� �� ���� ���� ����");
		buttonpanel.add(expl);
		
		add(buttonpanel, BorderLayout.NORTH);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void save(String adata) {
		
	}
	
	public void start() {
		String filePath = "ȸ�絥����.txt";
		File file = new File(filePath);
		if(file.exists()) {
			try {
				String s;
				String[] array;
				BufferedReader reader = new BufferedReader(new FileReader(file));
				while((s=reader.readLine()) != null) {
					
					array=s.split("/0");
					model.addRow(array);
				}
				reader.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		TA.readtext();
		
	}

}

 package hotel;

import java.awt.*;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Employee extends JFrame {
	Connection conn = null;
	 JPanel contentPane;
	 JTable table;
	 JLabel lblNewLabel;
	 JLabel lblJob;
	 JLabel lblName;
	 JLabel lblDepartment;

 
	public static void main(String[] args) {
 		
		try {
			Employee frame = new Employee();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 
	 
	public Employee() throws SQLException {
 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(260, 100, 1050, 600);
 		//contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(4, 4, 4, 4));
		//setContentPane(contentPane);
		setLayout(null);
		
		 Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Prachi\\Desktop\\bird.png");
         setIconImage(icon);  
           
		 ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("tenth.jpg"));
	        Image i2 = i1.getImage().getScaledInstance(1040, 600,Image.SCALE_DEFAULT);
	        ImageIcon i3 = new ImageIcon(i2); 
		JLabel NewLabel = new JLabel(i3);
		NewLabel.setBounds(0, 0, 1040, 600); 
		 add(NewLabel);
		
		table = new JTable();
		table.setBounds(3, 35, 1040, 450);
	 add(table);
		
		JButton btnLoadData = new JButton("Load Data");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
                                    conn c = new conn();
				String sql = "select * from Employee";
				ResultSet rs = c.s.executeQuery(sql);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
			
		});
		btnLoadData.setBounds(350, 500, 120, 30);
                btnLoadData.setBackground(Color.BLACK);
                btnLoadData.setForeground(Color.WHITE);
                NewLabel.add(btnLoadData);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(510, 500, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
                NewLabel.add(btnExit);
		
		lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(31, 11, 46, 14);
		NewLabel.add(lblNewLabel);
		
		lblJob = new JLabel("Age");
		lblJob.setBounds(139, 11, 46, 14);
		NewLabel.add(lblJob);
		
		lblName = new JLabel("Gender");
		lblName.setBounds(253, 11, 46, 14);
		NewLabel.add(lblName);
		
		lblDepartment = new JLabel("Job");
		lblDepartment.setBounds(396, 11, 86, 14);
		NewLabel.add(lblDepartment);
                
                JLabel l1 = new JLabel("Salary");
		l1.setBounds(516, 11, 86, 14);
		NewLabel.add(l1);
                
                JLabel l2 = new JLabel("Phone");
		l2.setBounds(636, 11, 86, 14);
		NewLabel.add(l2);
                
                JLabel l3 = new JLabel("Aadhar");
		l3.setBounds(742, 11, 86, 14);
		NewLabel.add(l3);
                
                JLabel l4 = new JLabel("Gmail");
		l4.setBounds(856, 11, 86, 14);
		NewLabel.add(l4);
		
		   JLabel l5 = new JLabel("Date");
			l5.setBounds(966, 11, 86, 14);
			NewLabel.add(l5);
                
               setBackground(Color.WHITE);
	}
}
package hotel;

import java.awt.*;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ManagerInfo extends JFrame {
	Connection conn = null;
	 JPanel contentPane;
	 JTable table;
	 JLabel lblNewLabel;
	 JLabel lblJob;
	 JLabel lblName;
	 JLabel lblDepartment;
	
	 
	public static void main(String[] args) {

		try {
			ManagerInfo frame = new ManagerInfo();
			frame.setVisible(true);
 		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 
	 
	public ManagerInfo() throws SQLException {
 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(20, 100, 1300, 600);
		getContentPane();
setLayout(null);
		
		 Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Prachi\\Desktop\\bird.png");
         setIconImage(icon);  
           
		 ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("man33.png"));
         Image i3 = i1.getImage().getScaledInstance(400, 450,Image.SCALE_DEFAULT);
         ImageIcon i2 = new ImageIcon(i3);
         JLabel l22 = new JLabel(i2);
         l22.setBounds(950,10,350,450);
         add(l22);
		
		table = new JTable();
		table.setBounds(10, 34, 1000, 450);
		 add(table);
		
		JButton btnld = new JButton("Load Data");
		 btnld .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
                                    conn c = new conn();
				String displayCustomersql = "select * from Employee where job = 'Manager'";
				ResultSet rs = c.s.executeQuery(displayCustomersql);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
			
		});
		 btnld .setBounds(350, 500, 120, 30);
		 btnld .setBackground(Color.BLACK);
		 btnld .setForeground(Color.WHITE);
		 add( btnld );
		
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
		 add(btnExit);
		
		lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(41, 11, 46, 14);
		 add(lblNewLabel);
		
		lblJob = new JLabel("Age");
		lblJob.setBounds(139, 11, 46, 14);
		 add(lblJob);
		
		lblName = new JLabel("Gender");
		lblName.setBounds(243, 11, 46, 14);
		 add(lblName);
		
		lblDepartment = new JLabel("Job");
		lblDepartment.setBounds(376, 11, 86, 14);
	 add(lblDepartment);
                
                JLabel l1 = new JLabel("Salary");
		l1.setBounds(496, 11, 86, 14);
		 add(l1);
                
                JLabel l2 = new JLabel("Phone");
		l2.setBounds(606, 11, 86, 14);
		 add(l2);
                
                JLabel l3 = new JLabel("Aadhar");
		l3.setBounds(706, 11, 86, 14);
		 add(l3);
                
                JLabel l4 = new JLabel("Gmail");
		l4.setBounds(806, 11, 86, 14);
		 add(l4);
		 
		 JLabel l5= new JLabel("Date");
			l5.setBounds(904, 11, 86, 14);
			 add(l5);
		//setLocation(280, 100);
                
			 getContentPane().setBackground(Color.gray);
	}
}
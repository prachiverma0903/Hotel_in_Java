 
package hotel;

import java.awt.*;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
 
//import net.proteanit.sql.DbUtils;
import java.sql.*;	
import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerInfo extends JFrame {
	Connection conn = null;
	  JPanel contentPane;

	 JTable table;
 DefaultTableModel model;

	 
	public static void main(String[] args) {

				try {
					CustomerInfo frame = new CustomerInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
 
	}
 
	 
	public CustomerInfo() throws SQLException {
		
		
		  
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("print.jpg"));
        Image i3 = i1.getImage().getScaledInstance( 900, 600,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(0,10, 900, 600);
         add(l1);
         setContentPane(l1);
 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 100, 900, 600);
		
		 Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Prachi\\Desktop\\bird.png");
         setIconImage(icon);  
           
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(350, 510, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		 add(btnExit);
		 
        JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 900, 450);
 		 add(scrollPane);
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
 	
		
		
		
		try {

			  conn c = new conn();
			String query="select * from customer ";
			ResultSet rs=c.s.executeQuery(query);
			ResultSetMetaData rsmd=(ResultSetMetaData) rs.getMetaData();
			  model = (DefaultTableModel)table.getModel();
			int cols=rsmd.getColumnCount();
			String[] colName=new String[cols];
			for(int i=0;i<cols;i++) 
				
				colName[i]=rsmd.getColumnName(i+1);
			model.setColumnIdentifiers(colName);
			
			String s1,s2,s3,s4,s5,s6,s7,s8;
			while(rs.next()) {
				
			     s1 = rs.getString(1);
				s2 =rs.getString(2);
				 s3 = rs.getString(3);
				 s4 = rs.getString(4);
				  s5 =rs.getString(5);
				  s6 =rs.getString(6);
				  s7 = rs.getString(7);
				   s8= rs.getString(8);
				    
			String[] row= { s1,s2,s3,s4,s5,s6,s7,s8};
				model.addRow(row);
				
			}
		
			
		}
			catch(Exception ex){
				ex.printStackTrace();
				System.out.println("hiii");
			}
		
		
//		JButton btnLoadData = new JButton("Load Data");
//		btnLoadData.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				try{
//                                    conn c  = new conn();
//                                    
//				String displayCustomersql = "select * from Customer";
//				ResultSet rs = c.s.executeQuery(displayCustomersql);
//				table.setModel(DbUtils.resultSetToTableModel(rs));
//			}
//				catch(Exception e)
//				{
//					e.printStackTrace();
//				}
//			}
//				
//			
//		});
//		btnLoadData.setBounds(300, 510, 120, 30);
//                btnLoadData.setBackground(Color.BLACK);
//                btnLoadData.setForeground(Color.WHITE);
//		contentPane.add(btnLoadData);
		
//		lblId = new JLabel("ID");
//		lblId.setBounds(31, 11, 46, 14);
//		contentPane.add(lblId);
//                
//                JLabel l1 = new JLabel("Number");
//		l1.setBounds(150, 11, 46, 14);
//		contentPane.add(l1);
//		
//		lblNewLabel = new JLabel("Name");
//		lblNewLabel.setBounds(270, 11, 65, 14);
//		contentPane.add(lblNewLabel);
//		
//		lblGender = new JLabel("Gender");
//		lblGender.setBounds(360, 11, 46, 14);
//		contentPane.add(lblGender);
//		
////		table = new JTable();
////		table.setBounds(0, 40, 900, 450);
////		contentPane.add(table);
////		
//		lblCountry = new JLabel("Country");
//		lblCountry.setBounds(480, 11, 46, 14);
//		contentPane.add(lblCountry);
//		
//		lblRoom = new JLabel("Room");
//		lblRoom.setBounds(600, 11, 46, 14);
//		contentPane.add(lblRoom);
//		
//		lblStatus = new JLabel("Check-in Status");
//		lblStatus.setBounds(680, 11, 100, 14);
//		contentPane.add(lblStatus);
//		
//		lblNewLabel_1 = new JLabel("Deposit");
//		lblNewLabel_1.setBounds(800, 11, 100, 14);
//		contentPane.add(lblNewLabel_1);
//                
//                getContentPane().setBackground(Color.WHITE);
	}
}
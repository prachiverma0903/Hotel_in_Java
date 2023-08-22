 package hotel;



import java.awt.*;

import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PickUp extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JPanel contentPane;
	private JTable table;
        Choice c1;

	 
	public static void main(String[] args) {
		 
				try {
					PickUp frame = new PickUp();
					frame.setVisible(true);
//					frame.setLocation(100,30);
				} catch (Exception e) {
					e.printStackTrace();
				}
			 
	}
	 
	public PickUp() throws SQLException {
 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Prachi\\Desktop\\bird.png");
         setIconImage(icon);  
           
		
		JLabel lblPickUpService = new JLabel("Pick Up Service");
		lblPickUpService.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblPickUpService.setBounds(320, 11, 208, 35);
		contentPane.add(lblPickUpService);
		lblPickUpService.setForeground(Color.white);
		
		JLabel lblTypeOfCar = new JLabel("Type of Car");
		lblTypeOfCar.setBounds(32, 97, 89, 14);
		contentPane.add(lblTypeOfCar);
		lblTypeOfCar.setForeground(Color.white);
		
                c1 = new Choice();
                try{
                    hotel.conn c = new hotel.conn();
                    ResultSet rs = c.s.executeQuery("select * from driver");
                    while(rs.next()){
                        c1.add(rs.getString("brand"));    
                    }
                }catch(Exception e){ }
                c1.setBounds(123, 94, 150, 25);
		contentPane.add(c1);

                
		
		JLabel lblInfo = new JLabel("Name");
		lblInfo.setBounds(24, 208, 46, 14);
		contentPane.add(lblInfo);
		lblInfo.setForeground(Color.white);
		
		JButton btnRegister = new JButton("Display");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String SQL = "select * from driver where brand = '"+c1.getSelectedItem()+"'";
				try{
				
					conn c = new conn();
					rs = c.s.executeQuery(SQL);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					
				}catch (SQLException ss)
				{
					ss.printStackTrace();
				}
				
				
			}
		});
		btnRegister.setBounds(200, 500, 120, 30);
                btnRegister.setBackground(Color.BLACK);
                btnRegister.setForeground(Color.WHITE);
		contentPane.add(btnRegister);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(420, 500, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
		
		table = new JTable();
		table.setBounds(0, 233, 800, 250);
		table.setBackground(Color.gray);
		table.setForeground(Color.white);
		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("Age");
		lblNewLabel.setBounds(165, 208, 46, 14);
		contentPane.add(lblNewLabel);
		lblNewLabel.setForeground(Color.white);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(264, 208, 46, 14);
		contentPane.add(lblGender);
		lblGender.setForeground(Color.white);
		
		JLabel lblTypeOfDriver = new JLabel("Company");
		lblTypeOfDriver.setBounds(366, 208, 80, 14);
		contentPane.add(lblTypeOfDriver);
		lblTypeOfDriver.setForeground(Color.white);
		
		JLabel lblDateOfThe = new JLabel("Brand");
		lblDateOfThe.setBounds(486, 208, 105, 14);
		contentPane.add(lblDateOfThe);
		lblDateOfThe.setForeground(Color.white);
		
	
		JLabel lblAirport = new JLabel("Available");
		lblAirport.setBounds(600, 208, 86, 14);
		contentPane.add(lblAirport);
		lblAirport.setForeground(Color.white);
		
		JLabel lblAvailable = new JLabel("Location");
		lblAvailable.setBounds(700, 208, 73, 14);
		contentPane.add(lblAvailable);
		lblAvailable.setForeground(Color.white);
		
                
                
                getContentPane().setBackground(Color.gray);
	}
}
 package hotel;

import java.awt.*;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Department extends JFrame {
	Connection conn = null;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	 
	public static void main(String[] args) {
		
		try {
		Department frame = new Department();
		frame.setVisible(true);
		}
		 catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	 
	 
	public Department() throws SQLException {
		 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 100, 1000, 500);
		//setLocation(100,30);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	//	setTitle("Department");
		
		 Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Prachi\\Desktop\\bird.png");
         setIconImage(icon);  
           
		  
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("print.jpg"));
        Image i12 = i11.getImage().getScaledInstance(1000, 500,Image.SCALE_DEFAULT);
        ImageIcon i13 = new ImageIcon(i12); 
	JLabel NewLabel1 = new JLabel(i13);
	NewLabel1.setBounds(0, 0,1000, 500); 
        add(NewLabel1);
	
		 ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("emp.png"));
	        Image i2 = i1.getImage().getScaledInstance(300, 350,Image.SCALE_DEFAULT);
	        ImageIcon i3 = new ImageIcon(i2); 
		JLabel NewLabel = new JLabel(i3);
		NewLabel.setBounds(650, 40, 300, 350); 
		NewLabel1.   add(NewLabel);
	      
		table = new JTable();
		table.setBounds(10, 40, 600, 350);
		NewLabel1.add(table);
		
//		
				try{
                                    conn c = new conn();
                                    
					String displayCustomersql = "select * from Department";
					ResultSet rs = c.s.executeQuery(displayCustomersql);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}
				catch (Exception e1){
					e1.printStackTrace();
				}
//				
//			}
//		});
				JButton btnNewButton = new JButton("Reload Data");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
				try{
                    conn c = new conn();
                    
	String displayCustomersql = "select * from Department";
	ResultSet rs = c.s.executeQuery(displayCustomersql);
	table.setModel(DbUtils.resultSetToTableModel(rs));
	
	
}
catch (Exception e1){
	e1.printStackTrace();
}

}
});
		btnNewButton.setBounds(170, 410, 120, 30);
                btnNewButton.setBackground(Color.BLACK);
                btnNewButton.setForeground(Color.WHITE);
            	NewLabel1. add(btnNewButton);
//		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					new Reception().setVisible(true);
                                        setVisible(false);
			}
		});
		btnNewButton_1.setBounds(400, 410, 120, 30);
                btnNewButton_1.setBackground(Color.BLACK);
                btnNewButton_1.setForeground(Color.WHITE);
            	NewLabel1. add(btnNewButton_1);
		
		lblNewLabel = new JLabel("Department");
		lblNewLabel.setBounds(145, 11, 105, 14);
		NewLabel1. add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Budget");
		lblNewLabel_1.setBounds(431, 11, 75, 14);
		NewLabel1. add(lblNewLabel_1);
                
                getContentPane().setBackground(Color.WHITE);
	}

}
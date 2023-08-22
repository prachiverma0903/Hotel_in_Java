 
package hotel;

import java.awt.*;

import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class NewCustomer extends JFrame {
	private static final long serialVersionUID = -5958400261052405735L;
	 
	private JPanel contentPane;
	 JTextField t1,t2,t3,t4,t5,t6;
        JComboBox<?> comboBox;
        JRadioButton r1,r2;
        Choice c1;
	
	public static void main(String[] args) {

		try {
			NewCustomer frame = new NewCustomer();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })

	
	
	
	
	public NewCustomer()   {
 
		
         setBounds(280, 100, 850, 550);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		  Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Prachi\\Desktop\\bird.png");
	      setIconImage(icon);  
	        
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("man.jpg"));
                Image i3 = i1.getImage().getScaledInstance(300, 400,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(480,10,300,500);
                add(l1);
		
		JLabel l = new JLabel("NEW CUSTOMER FORM");
		l.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		l.setBounds(118, 11, 260, 53);
		contentPane.add(l);
                
                JLabel lblId = new JLabel("ID :");
		lblId.setBounds(35, 76, 200, 14);
		contentPane.add(lblId);
                
                comboBox = new JComboBox(new String[] {"Passport", "Aadhar Card", "Voter Id", "Driving license"});
		comboBox.setBounds(271, 73, 150, 20);
		contentPane.add(comboBox);
                
                JLabel l2 = new JLabel("ID Number:");
		l2.setBounds(35, 111, 200, 14);
		contentPane.add(l2);
                
                t1 = new JTextField();
		t1.setBounds(271, 111, 150, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		
//		try {
//			conn c = new conn();
//			String sql = "select  Number from  customer order by  Number desc limit 1";
//			
//			ResultSet rs = c.s.executeQuery(sql);
//		    while(rs.next()) {
//		    	 int id = rs.getInt(1);
//				    int n=id+1;
//				    	t1 .setText(Integer.toString(n));
//				    	
//		    	
//		    }
//			}
//			catch(Exception e) {
//				
//				System.out.println("nullllllll"+e);
//				
//			}
		
		JLabel lblName_1 = new JLabel("Name :");
		lblName_1.setBounds(35, 151, 200, 14);
		contentPane.add(lblName_1);
		
		t2 = new JTextField();
		t2.setBounds(271, 151, 150, 20);
		contentPane.add(t2);
		t2.setColumns(10);

                
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(35, 191, 200, 14);
		contentPane.add(lblGender);
                
                r1 = new JRadioButton("Male");
                r1.setFont(new Font("Raleway", Font.BOLD, 14));
                r1.setBackground(Color.WHITE);
                r1.setBounds(271, 191, 80, 12);
                add(r1);
                
                r2 = new JRadioButton("Female");
                r2.setFont(new Font("Raleway", Font.BOLD, 14));
                r2.setBackground(Color.WHITE);
                r2.setBounds(350, 191, 100, 12);
		add(r2);
                
		JLabel lblCountry = new JLabel("Country :");
		lblCountry.setBounds(35, 231, 200, 14);
		contentPane.add(lblCountry);
		
		JLabel lr = new JLabel("Allocated Room Number :");
		lr .setBounds(35, 274, 200, 14);
		contentPane.add(lr );
                
                c1 = new Choice();
                try{
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("select * from room");
                    while(rs.next()){
                        c1.add(rs.getString("RoomNumber"));    
                    }
                }catch(Exception e){ }
                c1.setBounds(271, 274, 150, 20);
		contentPane.add(c1);
		
		JLabel lcin = new JLabel("Checked-In :");
		lcin.setBounds(35, 316, 200, 14);
		contentPane.add(lcin);
		
		JLabel lbld = new JLabel("Deposit :");
		lbld .setBounds(35, 359, 200, 14);
		contentPane.add(lbld );
		
		
		
		
		
		t3 = new JTextField();
		t3.setBounds(271, 231, 150, 20);
		contentPane.add(t3);
		t3.setColumns(10);
		
		
		t5 = new JTextField();
		t5.setBounds(271, 316, 150, 20);
		contentPane.add(t5);
		t5.setColumns(10);
		
		t6 = new JTextField();
		t6.setBounds(271, 359, 150, 20);
		contentPane.add(t6);
		t6.setColumns(10);

		JButton btnadd = new JButton("Add");
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(t2.getText().trim().isEmpty()||t1.getText().trim().isEmpty()) {
	    			JOptionPane.showMessageDialog(null, "Please Insert Full Detail...");

				}
				else {
				
				
                            conn c = new conn();
                            String radio = null;
                            
                            if(r1.isSelected()){ 
                                radio = "Male";
                            }
                            else if(r2.isSelected()){ 
                                radio = "Female";
                            }
                            
                         //   String s6 = c1.getSelectedItem();
                          
                            try{
	    			
                                String s1 = (String)comboBox.getSelectedItem(); 
	    		            	String s2 =  t1.getText();
	    		            	String s3 =  t2.getText();
                                String s4 =  radio;
	    	            		String s5 =  t3.getText();
	    		            	String s7 =  t5.getText();
                                String s8 =  t6.getText();
                                String s6 = c1.getSelectedItem();
                                String q1 = "insert into customer values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
                                String q2 = "update room set Availability = 'Occupied' where RoomNumber= "+s6;
                                c.s.executeUpdate(q1);
                                c.s.executeUpdate(q2);
	    			
	    			
	    			JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
                                new Reception().setVisible(true);
                                setVisible(false);
	    		}catch(SQLException e1){
	    			System.out.println( e1 );
	    		}
		    		catch(NumberFormatException s){
		    			JOptionPane.showMessageDialog(null, "Please enter a valid Number");
			}
			}}
		});
		btnadd.setBounds(100, 430, 120, 30);
		btnadd.setBackground(new  Color(0, 167, 157));
		btnadd.setForeground(new  Color(255, 255, 255));
		btnadd.setBorderPainted(false);
		btnadd.setBorder( BorderFactory.createLineBorder(new  Color(0, 167, 157)));
		contentPane.add(btnadd);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
             new Reception().setVisible(true);
                   setVisible(false);
			}
		}); 
		btnExit.setBounds(260, 430, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
                
                getContentPane().setBackground(Color.WHITE);
	}
	
	
	
	
	
	
	
}
package hotel;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class AddEmployee extends JFrame{  

    
	JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6;
        JComboBox c1;
        JDateChooser dcdob;
         public AddEmployee(){
            getContentPane().setForeground(Color.BLUE);
            getContentPane().setBackground(Color.WHITE);
            setTitle("ADD EMPLOYEE DETAILS");
		 
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
             getContentPane().setLayout(null);
             Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Prachi\\Desktop\\bird.png");
             setIconImage(icon);  
               
			
            JLabel name = new JLabel("NAME");
            name.setFont(new Font("Tahoma", Font.PLAIN, 17));
           name.setBounds(60, 30, 150, 27);
            add(name);
            
            textField = new JTextField();
            textField.setBounds(200, 30, 150, 27);
            add(textField);
			
            JButton Next = new JButton("SAVE");
            Next.setBounds(150, 500, 100, 30);
            Next.setBackground(Color.BLACK);
            Next.setForeground(Color.WHITE);
            add(Next);
           
            JLabel date = new JLabel("DATE");
            date.setFont(new Font("Tahoma", Font.PLAIN, 17));
           date.setBounds(60, 420, 150, 27);
            add(date);
            
            dcdob = new  JDateChooser();
            dcdob.setBounds(200, 420,  150, 27);
            add(dcdob);
            
            JButton back = new JButton("BACK");
            back.setBounds(300, 500, 100, 30);
           back.setBackground(Color.BLACK);
           back.setForeground(Color.WHITE);
            add(back);
            back.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					 setVisible(false);
					
				}
            	
            });
			
            JLabel age = new JLabel("AGE");
          age.setFont(new Font("Tahoma", Font.PLAIN, 17));
          age.setBounds(60, 80, 150, 27);
            add(age);
			
            textField_1 = new JTextField();
            textField_1.setBounds(200, 80, 150, 27);
            add(textField_1);
            
            JLabel Gender = new JLabel("GENDER");
            Gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Gender.setBounds(60, 120, 150, 27);
            add(Gender);
		
            JRadioButton male = new JRadioButton("MALE");
            male .setBackground(Color.WHITE);
            male .setBounds(200, 120, 70, 27);
            add( male );
	
            JRadioButton Female = new JRadioButton("FEMALE");
            Female.setBackground(Color.WHITE);
            Female.setBounds(280, 120, 70, 27);
            add(Female);
            
            ButtonGroup bg=new ButtonGroup();
            bg.add( male );
            bg.add( Female );
            
            JLabel job = new JLabel("JOB");
           job.setFont(new Font("Tahoma", Font.PLAIN, 17));
          job.setBounds(60, 170, 150, 27);
            add(job);
			
            String course[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
            c1 = new JComboBox(course);
            c1.setBackground(Color.WHITE);
            c1.setBounds(200,170,150,30);
            add(c1);
            		
            JLabel salary = new JLabel("SALARY");
           salary.setFont(new Font("Tahoma", Font.PLAIN, 17));
           salary.setBounds(60, 220, 150, 27);
            add(salary);
			
            textField_3 = new JTextField();
            textField_3.setBounds(200, 220, 150, 27);
            add(textField_3);
	
            JLabel phone = new JLabel("PHONE");
            phone.setFont(new Font("Tahoma", Font.PLAIN, 17));
            phone.setBounds(60, 270, 150, 27);
            add(phone);
	
            textField_4 = new JTextField();
            textField_4.setBounds(200, 270, 150, 27);
            add(textField_4);
	
            JLabel Phno = new JLabel("AADHAR");
            Phno.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Phno.setBounds(60, 320, 150, 27);
            add(Phno);
			
            textField_5 = new JTextField();
            textField_5.setBounds(200, 320, 150, 27);
            add(textField_5);
	
            
            JLabel email = new JLabel("EMAIL");
            email.setFont(new Font("Tahoma", Font.PLAIN, 17));
            email.setBounds(60, 370, 150, 27);
            add(email);
			
            textField_6 = new JTextField();
            textField_6.setBounds(200, 370, 150, 27);
            add(textField_6);
	
            setVisible(true);
	
            JLabel AddPassengers = new JLabel("ADD EMPLOYEE DETAILS");
            AddPassengers.setForeground(Color.BLUE);
            AddPassengers.setFont(new Font("Times New Roman", Font.PLAIN, 31));
            AddPassengers.setBounds(450, 24, 442, 35);
            add(AddPassengers);
			
     
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("delete.png"));
            Image i3 = i1.getImage().getScaledInstance(450, 500,Image.SCALE_DEFAULT);
            ImageIcon i2 = new ImageIcon(i3);
            JLabel image = new JLabel(i2);
            image.setBounds(410,0,450,500);
            add(image);

            
            Next.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                	if(textField.getText().trim().isEmpty()) {
    	    			JOptionPane.showMessageDialog(null, "Please Insert Name...");

    				}else {
                    String name = textField.getText();
                    String age = textField_1.getText();
                    String salary = textField_3.getText();
                    String phone = textField_4.getText();
                    String aadhar = textField_5.getText();
                    String email = textField_6.getText();
                    String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
                    String gender = null;
                    
                    if(male.isSelected()){
                        gender = "male";
                    
                    }else if(Female.isSelected()){
                        gender = "female";
                    }

                            
                    String s6 = (String)c1.getSelectedItem();
                    
                    try {
                        conn c = new conn();
                        String str = "INSERT INTO employee values( '"+name+"', '"+age+"', '"+gender+"','"+s6+"', '"+salary+"', '"+phone+"','"+aadhar+"', '"+email+"','"+dob+"')";
                        
                        c.s.executeUpdate(str);
                        JOptionPane.showMessageDialog(null,"Employee Added");
                        setVisible(false);
                    
                    } catch (Exception e) {
                        e.printStackTrace();
        	    }
		}
                }  });
            
            setSize(900,600);
            setVisible(true);
            setLocation(280, 100);
			
	}
        
    public static void main(String[] args){
        new AddEmployee();
    }   
}
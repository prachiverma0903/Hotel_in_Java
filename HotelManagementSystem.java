package hotel;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener{

        private static final long serialVersionUID = -6402140776214919891L;
		JLabel l1;
        JButton b1,b2;
        
        public HotelManagementSystem() {
		
                setSize(1300,700);       
                setLayout(null);
                setLocation(30,30);
                Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Prachi\\Desktop\\bird.png");
                setIconImage(icon);  
                  
                
            
		        l1 = new JLabel("");
                b1 = new JButton("Click here to start");
                b2 = new JButton("EXIT");
                
                b2.setBackground(Color.BLACK);
                b2.setForeground(Color.white);
				
                
                ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("htl.jpg"));
                Image i2 = i1.getImage().getScaledInstance(1300, 700, Image.SCALE_DEFAULT);
                ImageIcon i3 = new ImageIcon(i2);
                JLabel image = new JLabel(i3);
                image.setBounds(0, 00, 1300, 700);
                add(image);
                
//                JLabel lid=new JLabel("HOTEL MANAGEMENT SYSTEM");
//                lid.setBounds(30,300,1500,100);
//                lid.setFont(new Font("serif",Font.PLAIN,70));
//                lid.setForeground(Color.red);
//                l1.add(lid);
                
                b1.setBounds(500,450,300,50);
                b2.setBounds(500,550,300,50);
		        l1.setBounds(0, 0, 1366, 390);
                
		        image .add(b1);
		        image. add(b2);
		        add(l1);
 
                b1.addActionListener(this);
                b2.addActionListener(this);
                setVisible(true);
                
               /* while(true){
                        lid.setVisible(false); // lid =  j label
                    try{
                        Thread.sleep(500); //1000 = 1 second
                    }catch(Exception e){} 
                        lid.setVisible(true);
                    try{
                        Thread.sleep(500);
                    }catch(Exception e){}
                }*/
	}
        
        public void actionPerformed(ActionEvent ae){
        	  if(ae.getSource()==b1) {
                new Login().setVisible(true);
                this.setVisible(false);
        	  }
        	  else {
        		  if(ae.getSource()==b2) {
        			  setVisible(false);
        		  }
        	  }
        }
        
        public static void main(String[] args) {
                HotelManagementSystem window = new HotelManagementSystem();
                window.setVisible(true);			
	}
}

 package hotel;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    private static final long serialVersionUID = -2249561501285317798L;
	JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;

    Login(){

 
        setLayout(null);
         
        JLabel     l11 = new JLabel("LOGIN");
        l11.setBounds(140,20,100,30);
        add(l11);
        l11.setForeground(Color.white);
        l11.setFont(new Font("Times New Roman",Font.BOLD,25));
       
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Prachi\\Desktop\\bird.png");
      setIconImage(icon);  
        
        l1 = new JLabel("Username");
        l1.setBounds(40,350,100,30);
        add(l1);
        l1.setFont(new Font("Times New Roman", Font.BOLD, 20));

        l1.setForeground(Color.white);
      //  l1.setFont(new Font("serif",Font.BOLD,15));
        
        
        l2 = new JLabel("Password");
        l2.setFont(new Font("Times New Roman", Font.BOLD, 20));

        l2.setBounds(40,400,100,30);
        add(l2);
        l2.setForeground(Color.white);
    //    l2.setFont(new Font("serif",Font.BOLD,15));
        
        t1=new JTextField();
        t1.setBounds(150,350,150,30);
        t1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(t1);

        t2=new JPasswordField();
        t2.setBounds(150,400,100,30);
        ((JPasswordField) t2) .setEchoChar('*');
        add(t2);
//        
//        JToggleButton sh = new JToggleButton();
//        getContentPane().add(sh);
//        sh.setSelected(true);
//        sh.setBounds(270, 400, 30, 30);
//        sh.setIcon(new ImageIcon("C:\\Users\\Prachi\\Desktop\\hide.png"));
//        sh.setBackground(Color.WHITE);
//         sh.addMouseListener(new MouseAdapter() {
//	
//	public void mouseClicked(MouseEvent e) {
//		if(sh.isSelected()) {
//			 ((JPasswordField) t2).setEchoChar((char)0);
// 			 sh.setIcon(new ImageIcon("C:\\Users\\Prachi\\Desktop\\eye.png"));
// 			 
// 		       
//		}else {
//			
//			 ((JPasswordField) t2) .setEchoChar('*');//\u25cf
//			 sh.setIcon(new ImageIcon("C:\\Users\\Prachi\\Desktop\\hide.png"));  
//		}
//	}
//});        add(sh);

        JToggleButton sh = new JToggleButton("1");
        sh.setBounds(250, 400, 50, 31);
        sh.setBackground(Color.white);
        sh.setForeground(Color.black);
        sh.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				if(sh.isSelected()) {
					 ((JPasswordField) t2).setEchoChar((char)0);
					sh.setText("*");
				}else {
					
					 ((JPasswordField) t2) .setEchoChar('*');//\u25cf
					sh.setText("1");
				}
			}
		});
        add(sh);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("log.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700,600,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,-20,700,600);
        add(l3);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("Profile.png"));
        Image i12 = i11.getImage().getScaledInstance(300,270,Image.SCALE_DEFAULT);
        ImageIcon i13 =  new ImageIcon(i12);
        JLabel l13 = new JLabel(i13);
        l13.setBounds(20,60,300,270);
        add(l13);

       
        b1 = new JButton("Login");
        b1.setBounds(40,500,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
//        b1.addKeyListener( new KeyListener() {
//
//			@Override
//			private void b1Typed(KeyEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void keyPressed(KeyEvent e) {
//				 
//					 if(e.getKeyCode()==KeyEvent.VK_ENTER) {
//						  new Dashboard().setVisible(true);
//				          setVisible(false); 
//					 }
//
//			@Override
//			public void keyReleased(KeyEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//					
//			 
//        	
//	});
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
         add(b1);
         

        b2=new JButton("Cancel");
        b2.setBounds(180,500,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);

        b2.addActionListener(this);
        
        setVisible(true);
        getContentPane().setBackground(Color.gray);

        setVisible(true);
        setSize(1000,600);
        setLocation(250, 10);

    }
 
	public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
        try{
            conn c1 = new conn();
            String u = t1.getText();
            @SuppressWarnings("deprecation")
			String v = t2.getText();
            
            String q = "select * from login where username='"+u+"' and password='"+v+"'";
            
            ResultSet rs = c1.s.executeQuery(q); 
            if(rs.next()){ 
                new Home().setVisible(true);
                setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Invalid login! Try Again");
               // setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
       }
        else if(ae.getSource()==b2){
        	 setVisible(false);
        }                                
    }
    public static void main(String[] arg){
        new Login();
    }

	 }
 package hotel;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Home extends JFrame{

    private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
        new Home().setVisible(true);
    }
    
    public Home() {
        super("HOTEL MANAGEMENT SYSTEM");
	
        setForeground(Color.CYAN);
        setLayout(null); 
        
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Prachi\\Desktop\\bird.png");
        setIconImage(icon);  
          

        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
	JLabel NewLabel = new JLabel(i3);
	NewLabel.setBounds(0, 0, 1500, 700); 
	NewLabel.setOpaque(true);
        add(NewLabel);
        
        
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("bird.png"));
        Image i12 = i11.getImage().getScaledInstance(80, 80,Image.SCALE_DEFAULT);
        ImageIcon i13 = new ImageIcon(i12); 
	JLabel NewLabel1 = new JLabel(i13);
	NewLabel1.setBounds(330,65, 80, 80); 
	NewLabel. add(NewLabel1);
        
        
        JLabel lbl= new JLabel(" WELCOME TO SKY HOTEL");
	lbl.setForeground(Color.WHITE);
	lbl.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 46));// Bodoni MT Black
	lbl.setBounds(400, 60, 1000, 85);
	NewLabel.add(lbl);
 		
        JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
		
        JMenu m1 = new JMenu("HOTEL MANAGEMENT");
       m1.setForeground(Color.BLUE);
	menuBar.add(m1);
		
        JMenuItem mn = new JMenuItem("RECEPTION");
	m1.add(mn);
		
	JMenu m2 = new JMenu("ADMIN");
       m2.setForeground(Color.RED);
	menuBar.add(m2);
        
        JMenuItem addemp = new JMenuItem("ADD EMPLOYEE");
	m2.add(addemp);
        
       addemp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddEmployee().setVisible(true);
                }catch(Exception e ){}
            }
	});
        

        JMenuItem m4= new JMenuItem("ADD ROOMS");
	m2.add(m4);
        
       m4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddRoom().setVisible(true);
                }catch(Exception e ){}
            }
	});
        

	mn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Reception();
            }
	});
        
        
        JMenuItem m3 = new JMenuItem("ADD DRIVERS");
	m2.add(m3);
        
	m3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddDrivers().setVisible(true);
                }catch(Exception e ){}
            }
	});
        
		setLocation(-10,0);
        setSize(1400,800);
	setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }
}

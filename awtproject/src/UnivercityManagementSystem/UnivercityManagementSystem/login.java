package UnivercityManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*
;
public class login implements  ActionListener{
JLabel username;
JLabel password;
JTextField tname;
JTextField tpassword;
JButton submit;
JButton cancel;
JFrame f;

public login() {
    f = new JFrame();
    username = new JLabel("Username:");
    password = new JLabel("Password:");
    tname = new JTextField();
    tpassword = new JTextField();
    submit = new JButton("Submit");
    cancel = new JButton("Cancel");

    // Set bounds for components
    username.setBounds(50, 50, 100, 30);
    password.setBounds(50, 100, 100, 30);
    tname.setBounds(160, 50, 200, 30);
    tpassword.setBounds(160, 100, 200, 30);
    submit.setBounds(120, 150, 100, 30);
    cancel.setBounds(250, 150, 100, 30);
    
    submit.setBackground(Color.BLACK);
    cancel.setBackground(Color.BLACK);
    
    submit.setForeground(Color.WHITE);
    cancel.setForeground(Color.WHITE);
    

    // Add components to the frame
    f.add(username);
    f.add(password);
    f.add(tname);
    f.add(tpassword);
    f.add(submit);
    f.add(cancel);
    
    submit.addActionListener(this);
    
    cancel.addActionListener(this);
    
    f.setLayout(null); // Set layout to null for manual component positioning 
    f.setLocation(433, 234); // Center the frame on the screen
    f.setSize(500, 300);
    f.setVisible(true);
}

public void actionPerformed(ActionEvent e) {
	String users=tname.getText();
	String passs=tpassword.getText();

	 if (e.getSource() == submit) {
		
		    String url = "jdbc:mysql://localhost:3306/univercitymanagementsystem";
			String user = "root";
			String pass = "faizan";
	        
	        try {
	        	
	        	
	        	Connection c = DriverManager.getConnection(url, user, pass); 
	    		String query = "select * from login where username = ? And password = ? ";
	    		
	        	PreparedStatement pst = c.prepareStatement(query);
	        	pst.setString(1, users);
	        	pst.setString(2, passs);
	        
	        	ResultSet rs = pst.executeQuery();
	        	if (rs.next()) {
	        	    f.setVisible(false);
	        	    proj p=new proj();
	        	}
                   else if (users.isEmpty()){
            		
            			JOptionPane.showMessageDialog(null, "please fill the username");
            		   }
            	   else if ( passs.isEmpty()) {
            			JOptionPane.showMessageDialog(null, "please fill the password");
            		   }
            		
            	else  {
            			JOptionPane.showMessageDialog(null, "Invalid username and password");
            		f.setVisible(false);
            	}
	                }
	        
	        catch(Exception e12) {
	        	e12.printStackTrace();
	        	
	        }
	    }
	 else if(e.getSource()==cancel) {
		 f.dispose();
	 }
	}


public static void main(String[] args) {
	// TODO Auto-generated method stub
	login s1 =new login();
}


}

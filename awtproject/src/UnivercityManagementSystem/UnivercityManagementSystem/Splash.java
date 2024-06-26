package UnivercityManagementSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Splash {

    JFrame f;
    JLabel imagelabel;
    JLabel uni;

    Splash() {
        f = new JFrame();
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/islamic.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1366, 768, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        imagelabel = new JLabel(i3);
        f.add(imagelabel);
 
        

        // Set the location of the frame
        f.setLocation(220, 50); // to open it from the middle of the window
        f.setSize(1000, 700);
        f.setVisible(true);

        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose(); // Close the window
                login s =new login();
                
            }
        });
        timer.setRepeats(false); // Set to execute only once
        timer.start();
    }

    public static void main(String[] args) {
        Splash sp = new Splash();
     
    }
}

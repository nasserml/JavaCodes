package handleevent;
import javax.swing.*;
import java.awt.event.*;
public class HandleEvent extends JFrame {
    public HandleEvent() {
        // Create tow buttons
        JButton jbtOk = new JButton("OK");
        JButton jbtCancel = new JButton("Cancel");
        
        // Create a panel to hold buttons
        JPanel panel = new JPanel();
        panel.add(jbtOk);
        panel.add(jbtCancel);
        
        add(panel); // Add panel to the frame
        
        //Register listener
        OkListenerClass listener1 = new OkListenerClass();
        CancelListenerClass listener2 = new CancelListenerClass();
        jbtOk.addActionListener(listener1);
        jbtCancel.addActionListener(listener2);
    }
    public static void main(String[] args) {
        JFrame frame = new HandleEvent();
        frame.setTitle("Handle Event");
        frame.setSize(200, 150);
        frame.setLocation(200, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class OkListenerClass implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Ok button clicked");
    }
}

class CancelListenerClass implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e){
        System.out.println("Cancel button clicked");
    }
}
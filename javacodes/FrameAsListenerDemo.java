package frameaslistenerdemo;
import javax.swing.*;
import java.awt.event.*;

public class FrameAsListenerDemo extends JFrame
    implements ActionListener{
    // Create four buttons
    JButton jbtNew = new JButton("New");
    JButton jbtOpen = new JButton("Open");
    JButton jbtSave = new JButton("Save");
    JButton jbtPrint = new JButton("Print");
    
    public FrameAsListenerDemo() {
        // Create a panel to hold buttons
        JPanel panel = new JPanel();
        panel.add(jbtNew);
        panel.add(jbtOpen);
        panel.add(jbtSave);
        panel.add(jbtPrint);
        
        add(panel);
        
        // Register listener with buttons
        jbtNew.addActionListener(this);
        jbtOpen.addActionListener(this);
        jbtSave.addActionListener(this);
        jbtPrint.addActionListener(this);
    }
    
    @Override // Implement actionPerformed
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbtNew)
            System.out.println("Process new");
        else if (e.getSource() == jbtOpen)
            System.out.println("Process open");
        else if (e.getSource() == jbtSave)
            System.out.println("Process save");
        else if (e.getSource() == jbtPrint)
            System.out.println("Process print");
    }
    
    // Main method
    public static void main(String[] args) {
        JFrame frame = new FrameAsListenerDemo();
        frame.setTitle("FrameAsListenerDemo");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    
}

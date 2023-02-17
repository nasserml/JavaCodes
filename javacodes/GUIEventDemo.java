package guieventdemo;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class GUIEventDemo extends JFrame {
    private JLabel jlblMessage = new JLabel("Hello", JLabel.CENTER);
    
    // Create check boxes to set the font for the message
    private JCheckBox jchkBold = new JCheckBox("Bold");
    private JCheckBox jchkItalic = new JCheckBox("Italic");
    
    // Create three radio buttons to set message colors
    private JRadioButton jrbRed = new JRadioButton("Red");
    private JRadioButton jrbGreen = new JRadioButton("Green");
    private JRadioButton jrbBlue = new JRadioButton("Blue");
    
    // Create a text field for setting a new message
    private JTextField jtfMessage = new JTextField(10);
    
    public static void main(String[] args) {
        GUIEventDemo frame = new GUIEventDemo();
        frame.pack();
        frame.setTitle("GUIEventDemo");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public GUIEventDemo() {
        jlblMessage.setBorder(new LineBorder(Color.BLACK, 2));
        add(jlblMessage, BorderLayout.CENTER);
        
        // Create a panel to hold check box
        JPanel jpCheckBoxes = new JPanel();
        jpCheckBoxes.setLayout(new GridLayout(2, 1));
        jpCheckBoxes.add(jchkBold);
        jpCheckBoxes.add(jchkItalic);
        add(jpCheckBoxes, BorderLayout.EAST);
        
        // Create a panel to hold radio buttons
        JPanel jpRadioButtons = new JPanel();
        jpRadioButtons.setLayout(new GridLayout(2, 1));
        jpRadioButtons.add(jrbRed);
        jpRadioButtons.add(jrbGreen);
        jpRadioButtons.add(jrbBlue);
        add(jpRadioButtons, BorderLayout.WEST);
        
        // Create a radio-button group to group three buttons
        ButtonGroup group = new ButtonGroup();
        group.add(jrbRed);
        group.add(jrbGreen);
        group.add(jrbBlue);
        
        // Set initial message color to blue
        jrbBlue.setSelected(true);
        jlblMessage.setForeground(Color.blue);
        
        // Create a panel to hold label and text field
        JPanel jpTextField = new JPanel();
        jpTextField.setLayout(new BorderLayout(5, 0));
        jpTextField.add(
            new JLabel("Enter a new message"), BorderLayout.WEST);
        jpTextField.add(jtfMessage, BorderLayout.CENTER);
        jtfMessage.setHorizontalAlignment(JTextField.RIGHT);
        add(jpTextField, BorderLayout.NORTH);
        
        // Set mnemonic keys for check boxes and radio buttons
        jchkBold.setMnemonic('B');
        jchkItalic.setMnemonic('I');
        jrbRed.setMnemonic('E');
        jrbGreen.setMnemonic('G');
        jrbBlue.setMnemonic('U');
        
        // Register listeners with check boxes
    }
     
}

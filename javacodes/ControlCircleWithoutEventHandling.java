package controlcirclewithouteventhandling;
import javax.swing.*;
import java.awt.*;

public class ControlCircleWithoutEventHandling extends JFrame {
    private JButton jbtEnlarge = new JButton("Enlarge");
    private JButton jbtShrink = new JButton("Shrink");
    private CirclePanel canves = new CirclePanel();
    
    public ControlCircleWithoutEventHandling() {
        JPanel panel = new JPanel(); // Use the panel to group buttons
        panel.add(jbtEnlarge);
        panel.add(jbtShrink);
        
        this.add(canves, BorderLayout.CENTER); // Add canaves to the center
        this.add(panel, BorderLayout.SOUTH); // Add buttons to the frame
    }
    
    // Main method
    public static void main(String[] args) {
        JFrame frame = new ControlCircleWithoutEventHandling();
        frame.setTitle("ControlCircleWithoutEventHNDLING");
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }
}

class CirclePanel extends JPanel {
    private int radius = 5; // Default radius circle
    
    @Override // Repaint the circle
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawOval(getWidth() / 2 - radius, getHeight() / 2 - radius,
                2 * radius, 2 * radius);
    }
}

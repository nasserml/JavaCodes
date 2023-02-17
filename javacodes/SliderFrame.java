
package sliderdemo;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class SliderFrame extends JFrame {
    private JSlider diameterJSlider; // slider to select diameter
    private OvalPanel myPanel; // panel to draw a circle
    
    // n0-argument constructor
    public SliderFrame() {
        super( "Slider Demo" );
        myPanel = new OvalPanel(); // create panel to draw circle
        
    }
    
}

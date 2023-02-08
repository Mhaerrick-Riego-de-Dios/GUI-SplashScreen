import javax.swing.ImageIcon; import 
javax.swing.JFrame; import javax.swing.JPanel; 
import javax.swing.border.EmptyBorder; 
import javax.swing.JLabel; import 
java.awt.Font; import 
javax.swing.JProgressBar; import 
javax.swing.SwingConstants; import 
java.awt.Color; 
 
public class SplashScreen extends JFrame { 
 
/** 
* */ private static final long serialVersionUID = 1L; 
public JProgressBar progressBar; 
 
/** 
* Create the frame. 
*/ public SplashScreen() { setUndecorated(true); 
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
setBounds(100, 100, 637, 559); 
setLocationRelativeTo(null); 
 
JPanel contentPane = new JPanel(); contentPane.setBorder(new 
EmptyBorder(5, 5, 5, 5)); setContentPane(contentPane); 
contentPane.setLayout(null); 
 
progressBar = new JProgressBar(); progressBar.setFont(new 
Font("Serif", Font.PLAIN, 20)); 
progressBar.setForeground(Color.YELLOW); 
progressBar.setStringPainted(true); 
progressBar.setBounds(47, 490, 551, 31); 
contentPane.add(progressBar); 
 
JLabel lblImage = new JLabel(""); lblImage.setFont(new Font("Serif", 
Font.PLAIN, 11)); 
lblImage.setHorizontalAlignment(SwingConstants.CENTER); 
lblImage.setBounds(47, 11, 551, 455); lblImage.setIcon(new 
ImageIcon("GIF/spongebob.gif")); 
contentPane.add(lblImage); 
} 
}
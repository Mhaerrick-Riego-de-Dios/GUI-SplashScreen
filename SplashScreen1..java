import java.awt.BorderLayout; import 
java.awt.EventQueue; import 
javax.swing.ImageIcon; import 
javax.swing.JFrame; import 
javax.swing.JPanel; import 
javax.swing.border.EmptyBorder; import 
javax.swing.JLabel; import 
javax.swing.SwingConstants; import 
java.awt.Font; 
 
public class Main extends JFrame { 
 
/** 
* */ private static final long serialVersionUID = 1L; /** *
Launch the application. 
*/ public static void main(String[] 
args) { counter(); // calling a 
method. 
EventQueue.invokeLater(() -> { 
try { 
 Main frame = new Main(); 
 frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH); 
frame.setVisible(true); 
 } catch (Exception e) { 
 e.printStackTrace(); 
 } 
}); 
} 
 
/** 
* Create the frame. 
*/ public Main() 
{ 
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
setBounds(100, 100, 450, 300); 
setLocationRelativeTo(null); 
 
JPanel contentPane = new JPanel(); 
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); 
contentPane.setLayout(new BorderLayout(0, 0)); setContentPane(contentPane); 
 
JLabel lblGIF = new JLabel(""); 
lblGIF.setFont(new Font("Serif", Font.PLAIN, 11)); 
lblGIF.setHorizontalAlignment(SwingConstants.CENTER); 
lblGIF.setIcon(new ImageIcon("GIF/loading.gif")); contentPane.add(lblGIF, 
BorderLayout.CENTER); 
} 
// Method. private static void counter() { // a method for determining how long the splash screen will be 
displayed for. SplashScreen splash = new SplashScreen(); 
splash.setVisible(true); 
 
int counter = 0; 
 
while (counter <= 100) { 
 splash.progressBar.setValue(counter); 
 
 try { 
Thread.sleep(50); 
 } catch (InterruptedException e) { 
 // TODO Auto-generated catch block 
e.printStackTrace(); 
} 
 
 if (counter == 100) { 
 splash.dispose(); 
 } 
++counter; 
} 
} }
import java.awt.EventQueue; import javax.swing.*; 
import javax.swing.border.EmptyBorder; 
import java.awt.Font; 
 
public class Main extends JFrame { 
 
// Data. 
private boolean isLeapYear = false; 
 
// Component private final JPanel 
contentPane; 
private final JSpinner spnDay, spnMonth, spnYear; 
 
/** 
* Launch the application. */ public static void main(String[] 
args) { EventQueue.invokeLater(() -> 
{ try { 
 Main frame = new Main(); 
frame.setVisible(true); 
 } catch (Exception e) { 
 e.printStackTrace(); 
 } 
}); 
} 
 
/** 
* Create the frame. 
*/ public Main() { setTitle("SIMPLE DATE APPLICATION"); 
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
setBounds(100, 100, 450, 300); 
setLocationRelativeTo(null); 
 
contentPane = new JPanel(); contentPane.setBorder(new 
EmptyBorder(5, 5, 5, 5)); setContentPane(contentPane); 
contentPane.setLayout(null); 
 
// Day Spinner. 
spnDay = new JSpinner(); spnDay.setFont(new 
Font("Serif", Font.PLAIN, 14)); spnDay.setModel(new 
SpinnerNumberModel(1, 1, 31, 1)); spnDay.setBounds(170, 
53, 181, 25); 
contentPane.add(spnDay); 
 
String[] months = {"January", "February", "March", 
 "April", "May", "June", "July", "August", 
 "September", "October", "Novemeber", "December"}; 
 
// Month Spinner. 
spnMonth = new JSpinner(); spnMonth.setFont(new 
Font("Serif", Font.PLAIN, 14)); 
spnMonth.setModel(new SpinnerListModel(months)); 
spnMonth.addChangeListener(e -> dayDisplay()); 
spnMonth.setBounds(170, 100, 181, 25); 
contentPane.add(spnMonth); 
 
// Year Spinner. 
spnYear = new JSpinner(); spnYear.setFont(new Font("Serif", 
Font.PLAIN, 14)); spnYear.setModel(new 
SpinnerNumberModel(1950, 1950, 2022, 1)); 
spnYear.addChangeListener(e -> isLeapYear()); 
spnYear.setBounds(170, 146, 181, 25); contentPane.add(spnYear); 
 
// Day Spinner Default Editor. 
JSpinner.DefaultEditor dayEditor = (JSpinner.DefaultEditor) spnDay.getEditor(); 
dayEditor.getTextField().setEditable(false); 
 
// Month Spinner Default Editor. 
JSpinner.DefaultEditor monthEditor = (JSpinner.DefaultEditor) spnMonth.getEditor(); 
monthEditor.getTextField().setEditable(false); 
monthEditor.getTextField().setHorizontalAlignment(JTextField.RIGHT); 
 
// Year Spinner Default Editor. 
JSpinner.DefaultEditor yearEditor = new JSpinner.NumberEditor(spnYear, 
"#"); yearEditor.getTextField().setEditable(false); spnYear.setEditor(yearEditor); 
 
// Day Label. 
JLabel lblDay = new JLabel("Day"); 
lblDay.setFont(new Font("Serif", Font.PLAIN, 14)); lblDay.setBounds(100, 
53, 60, 25); 
contentPane.add(lblDay); 
 
// Month Label. 
JLabel lblMonth = new JLabel("Month"); lblMonth.setFont(new 
Font("Serif", Font.PLAIN, 14)); lblMonth.setBounds(100, 105, 
60, 25); 
contentPane.add(lblMonth); 
 
// Year Label. 
JLabel lblYear = new JLabel("Year"); 
lblYear.setFont(new Font("Serif", Font.PLAIN, 14)); 
lblYear.setBounds(100, 146, 60, 25); contentPane.add(lblYear); 
 
// Display Button. 
JButton btnDisplay = new JButton("DISPLAY"); 
btnDisplay.addActionListener(e -> dateDisplay()); 
btnDisplay.setFocusable(false); btnDisplay.setFont(new 
Font("Serif", Font.PLAIN, 14)); 
btnDisplay.setBounds(303, 216, 110, 23); 
contentPane.add(btnDisplay); 
} 
// Methods. 
private void dayDisplay() { // a method for displaying the day value according to the selected month. if 
("January March May July August October December".contains(spnMonth.getValue().toString())) { 
 spnDay.setModel(new SpinnerNumberModel(1, 1, 31, 1)); 
} else if ("April June September November".contains(spnMonth.getValue().toString())) { 
spnDay.setModel(new SpinnerNumberModel(1, 1, 30, 1)); 
} else { 
spnDay.setModel(new SpinnerNumberModel(1, 1, isLeapYear ? 29 : 28, 1)); 
} 
 
// Day Spinner Default Editor. 
JSpinner.DefaultEditor dayEditor = (JSpinner.DefaultEditor) spnDay.getEditor(); 
dayEditor.getTextField().setEditable(false); 
} 
 
private void isLeapYear() { // a method for leap year. 
isLeapYear = Integer.parseInt(spnYear.getValue().toString()) % 4 == 0; 
 
if (spnMonth.getValue().toString().equals("February")) { spnDay.setModel(new 
SpinnerNumberModel(1, 1, isLeapYear ? 29 : 28, 1)); 
 
 // Day Spinner Default Editor. 
 JSpinner.DefaultEditor dayEditor = (JSpinner.DefaultEditor) spnDay.getEditor(); 
dayEditor.getTextField().setEditable(false); 
} 
} 
 
private void dateDisplay() { // a method for displaying the date value. 
JOptionPane.showMessageDialog(contentPane, "Date : " + spnMonth.getValue() 
+ " " + spnDay.getValue() + ", " + spnYear.getValue()); 
} 
}
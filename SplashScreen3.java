import java.awt.EventQueue; import 
javax.swing.ButtonGroup; import 
javax.swing.DefaultComboBoxModel; import 
javax.swing.JFrame; import javax.swing.JPanel; 
import javax.swing.border.EmptyBorder; import 
javax.swing.tree.DefaultMutableTreeNode; import 
javax.swing.tree.DefaultTreeModel; import 
javax.swing.JTree; import javax.swing.JScrollPane; 
import javax.swing.JLabel; import 
javax.swing.JOptionPane; import java.awt.Font; import 
javax.swing.SwingConstants; import
javax.swing.JRadioButton; import 
javax.swing.JComboBox; import 
javax.swing.JTextField; 
import javax.swing.JButton; 
 
public class Main extends JFrame { 
 
 private final JPanel contentPane; private final 
JTextField txtName; private JComboBox<Object> cboCategory; 
private final JRadioButton 
rdoCategory; private final 
DefaultMutableTreeNode categories; private final 
DefaultTreeModel treeModel; 
 
 /** 
 * Launch the application. 
 */ 
 public static void main(String[] args) { 
EventQueue.invokeLater(() -> { try 
{ 
 Main frame = new Main(); 
frame.setVisible(true); 
 } catch (Exception e) { 
 e.printStackTrace(); 
 } 
 }); 
 } 
 
 /** 
 * Create the frame. 
 */ 
 public Main() { 
 setTitle("JTree Simple Application"); 
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
 setBounds(100, 100, 949, 690); 
 setLocationRelativeTo(null); 
 
 contentPane = new JPanel(); contentPane.setBorder(new 
EmptyBorder(5, 5, 5, 5)); 
setContentPane(contentPane); 
 contentPane.setLayout(null); 
 
 // Creating a Tree Node. 
 categories = new DefaultMutableTreeNode("CATEGORIES"); 
 
 // Creating a sub Tree Node. 
 DefaultMutableTreeNode category1 = new DefaultMutableTreeNode("Category 1"); 
 DefaultMutableTreeNode category2 = new DefaultMutableTreeNode("Category 2"); 
DefaultMutableTreeNode category3 = new DefaultMutableTreeNode("Category 3"); 
 
 // Adding item to Category 1. category1.add(new 
DefaultMutableTreeNode("Item 1")); 
category1.add(new DefaultMutableTreeNode("Item 2")); category1.add(new 
DefaultMutableTreeNode("Item 3")); 
 
 // Adding item to Category 2. 
 category2.add(new DefaultMutableTreeNode("Item 4")); category2.add(new 
DefaultMutableTreeNode("Item 5")); category2.add(new 
DefaultMutableTreeNode("Item 6")); 
 
 // Adding item to Category 3. 
 category3.add(new DefaultMutableTreeNode("Item 7")); category3.add(new 
DefaultMutableTreeNode("Item 8")); category3.add(new 
DefaultMutableTreeNode("Item 9")); 
 
 // Adding sub Category to the root Category. 
 categories.add(category1); categories.add(category2); 
categories.add(category3); 
 
 JScrollPane scrollPane = new JScrollPane(); scrollPane.setBounds(10, 
11, 456, 470); 
contentPane.add(scrollPane); 
 
 // Creating Tree Node Model. 
 treeModel = new DefaultTreeModel(categories); 
 
 JTree tree = new JTree(treeModel); tree.setFont(new 
Font("Serif", Font.PLAIN, 11)); 
scrollPane.setViewportView(tree); 
 
 JLabel lblNewLabel = new JLabel("NEW :"); 
lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT); 
lblNewLabel.setFont(new Font("Serif", Font.BOLD, 14)); lblNewLabel.setBounds(500, 
86, 91, 46); 
 contentPane.add(lblNewLabel); 
 
 // Category Radio Button. rdoCategory = new 
JRadioButton("CATEGORY"); rdoCategory.addActionListener(e -
> cboCategory.setEnabled(false)); 
rdoCategory.setFocusable(false); rdoCategory.setSelected(true); 
rdoCategory.setFont(new Font("Serif", Font.PLAIN, 14)); 
rdoCategory.setBounds(630, 140, 116, 46); 
contentPane.add(rdoCategory); 
 
 // Item Radio Button. 
 JRadioButton rdoItem = new JRadioButton("ITEM"); 
rdoItem.addActionListener(e -> cboCategory.setEnabled(true)); 
rdoItem.setFocusable(false); rdoItem.setFont(new Font("Serif", Font.PLAIN, 
14)); rdoItem.setBounds(630, 86, 91, 41); contentPane.add(rdoItem); 
 
 // Grouping the radio button. ButtonGroup 
bg = new ButtonGroup(); 
 bg.add(rdoCategory); 
 bg.add(rdoItem); 
 
 JLabel lblNewLabel_1 = new JLabel("SELECT A CATEGORY :"); 
lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT); 
lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 14)); lblNewLabel_1.setBounds(478, 
214, 176, 36); contentPane.add(lblNewLabel_1); 
 
 // Creating Combo Box Model. 
 DefaultComboBoxModel<Object> categoryModel = new DefaultComboBoxModel<> 
(new String[]{"Category 1", "Category 2", "Category 3"}); 
 
 // Category Combo Box. 
 cboCategory = new JComboBox<>(categoryModel); 
cboCategory.setEnabled(false); cboCategory.setFont(new 
Font("Serif", Font.PLAIN, 14)); cboCategory.setBounds(572, 
261, 267, 31); 
contentPane.add(cboCategory); 
 
 JLabel lblNewLabel_1_1 = new JLabel("NAME :"); 
 lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT); 
lblNewLabel_1_1.setFont(new Font("Serif", Font.BOLD, 14)); 
lblNewLabel_1_1.setBounds(483, 341, 108, 36); contentPane.add(lblNewLabel_1_1); 
 
 // Name TextField. 
txtName = new JTextField(); 
txtName.setFont(new Font("Serif", Font.PLAIN, 14)); txtName.setBounds(572, 
401, 267, 36); 
contentPane.add(txtName); 
 txtName.setColumns(10); 
 
 // Save Button. 
 JButton btnSave = new JButton("SAVE"); btnSave.addActionListener(e 
-> save()); btnSave.setFocusable(false); btnSave.setFont(new Font("Serif", 
Font.PLAIN, 14)); 
btnSave.setBounds(705, 553, 134, 36); contentPane.add(btnSave); 
 
 JButton btnExit = new JButton("EXIT"); 
btnExit.addActionListener(e -> exit()); 
btnExit.setFont(new Font("Serif", Font.PLAIN, 14)); 
 btnExit.setFocusable(false); btnExit.setBounds(549, 
553, 134, 36); 
contentPane.add(btnExit); 
 } 
 // Methods. private void exit() { int response = 
JOptionPane.showConfirmDialog(contentPane, "Are you sure you want to exit?", 
"Confirmation", JOptionPane.YES_NO_OPTION); 
 
 if (response == 0) { 
 System.exit(0); 
 } 
 } 
 
 private void save() { // a method for saving output. 
 if (txtName.getText().isBlank()) { 
 JOptionPane.showMessageDialog(contentPane, "The text field should not be empty!"); 
 } else { 
 if (rdoCategory.isSelected()) { 
 category(); 
 } else { 
 for (int i = 0; i < categories.getChildCount(); i++ ) { if 
(categories.getChildAt(i).toString().equals(cboCategory.getSelectedItem())) { 
item(i); break; 
 } 
 } 
 } 
 treeModel.reload(); // Reloading for changes. 
 } 
 } 
 
 private void category() { // a method for adding a category. 
 boolean isExist = false; 
 
 for (int i = 0; i < categories.getChildCount(); i++) { if 
(categories.getChildAt(i).toString().equals(txtName.getText())) { isExist 
= true; 
 break; 
 } 
 } 
 
 if (isExist) { 
 JOptionPane.showMessageDialog(contentPane, "The "+ txtName.getText() 
+ " is already exist."); 
 } else { 
 int response = JOptionPane.showConfirmDialog(contentPane, 
 "Are you sure you want to add a new category?", 
 "Confirmation", JOptionPane.YES_NO_OPTION); 
 
 if (response == 0) { categories.add(new 
DefaultMutableTreeNode(txtName.getText())); 
cboCategory.addItem(txtName.getText()); 
 txtName.setText(null); 
 
 JOptionPane.showMessageDialog(contentPane, "Adding a new category has been a success."); 
 } 
 } 
 } 
 
 private void item(int i) { // a method for adding an item. 
 boolean isExist = false; 
 // Getting the selected node. 
 DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) categories.getChildAt(i); 
 
 for (int j = 0; j < selectedNode.getChildCount(); j++) { if 
(selectedNode.getChildAt(j).toString().equals(txtName.getText())) { isExist 
= true; 
 break; 
 } 
 } 
 
 if (isExist) { 
 JOptionPane.showMessageDialog(contentPane, "Item is already exist."); 
 } else { 
 int response = JOptionPane.showConfirmDialog(contentPane, 
 "Are you sure you want to add new Item in " + categories.getChildAt(i)+ 
 "?", "Confirmation", JOptionPane.YES_NO_OPTION); 
 
 if (response == 0) { 
 DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(txtName.getText()); 
selectedNode.add(newNode); // Adding item in the selected node. 
 
 txtName.setText(null); 
 
 JOptionPane.showMessageDialog(contentPane, "Adding a new item in " + 
categories.getChildAt(i) + " has been a success."); 
 } 
 } 
 } 
} 
 

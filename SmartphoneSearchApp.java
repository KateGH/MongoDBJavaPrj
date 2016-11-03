package ecommerceGUI;
// run on this Main class

import java.awt.BorderLayout;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

public class SmartphoneSearchApp extends JFrame
{

	public static Smartphone mySmartphone;
	private JPanel contentPane;
	private JTextField brandnameTextField;

	private SmartphoneDAO smartphoneDAO;
	private JTable table;
	

	public SmartphoneSearchApp() throws Exception
	{
		smartphoneDAO = new SmartphoneDAO();
		
		setTitle("SmartphonesSearchApp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel topPanel = new JPanel();
		contentPane.add(topPanel, BorderLayout.NORTH);
		
		JLabel lblBrand = new JLabel("Enter Brandname");
		lblBrand.setHorizontalAlignment(SwingConstants.LEFT);
		topPanel.add(lblBrand);
		
		brandnameTextField = new JTextField();
		topPanel.add(brandnameTextField);
		brandnameTextField.setColumns(10);
		
		JPanel buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		
		JButton btnInsert = new JButton("Insert Newphone");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddSmartphoneDialog dialog = new AddSmartphoneDialog();
				
				dialog.setVisible(true);
			}
		});
		buttonPanel.add(btnInsert);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int row = table.getSelectedRow();
				
				if(row<0){
					JOptionPane.showMessageDialog(SmartphoneSearchApp.this, "You must select one Smartphone to update", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				// get the current smartphone obj
				String product_id = (String) table.getValueAt(row, SmartphoneTableModel.PRODUCTID_COL);
				String title = (String) table.getValueAt(row, SmartphoneTableModel.TITLE_COL);
				String des = (String) table.getValueAt(row, SmartphoneTableModel.DESCRIPTIONs_COL);
				String screen = (String) table.getValueAt(row, SmartphoneTableModel.SCREEN_COL);
				String camera = (String) table.getValueAt(row, SmartphoneTableModel.CAMERA_COL);
				String manu = (String) table.getValueAt(row, SmartphoneTableModel.MANUFACTUREs_COL);
				String ship = (String) table.getValueAt(row, SmartphoneTableModel.SHIPPINGs_COL);
				String quan = (String) table.getValueAt(row, SmartphoneTableModel.QUANTITY_COL);
				String pris = (String) table.getValueAt(row, SmartphoneTableModel.PRICING_COL);
				String categories = (String) table.getValueAt(row, SmartphoneTableModel.CATEGORIES_COL);
				
				Smartphone tempSmartphone = new Smartphone(product_id, title, des, screen, camera, manu, ship, quan, pris, categories); 				
				
				//create dialog
				UpdateSmartphoneDialog dialog = new UpdateSmartphoneDialog(SmartphoneSearchApp.this, smartphoneDAO, tempSmartphone, true);
				
				//show dialog
				dialog.setVisible(true);
			}
		});
		buttonPanel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try{
					//select row from JTable
					
					int row = table.getSelectedRow();
//					System.out.println("row is: " + row);
					
					//make sure a row is selected	
					if(row<0){
						JOptionPane.showMessageDialog(SmartphoneSearchApp.this, "You must select one Smartphone to delete", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
						
					//prompt the user
					int response = JOptionPane.showConfirmDialog(SmartphoneSearchApp.this, "Delete this Smartphone?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					
					if(response != JOptionPane.YES_OPTION){
						return; // if answer 'No', return same page/do nothing		
					}
					
					// answer 'Yes', run this below part to delete JavaObj/DBObj
//					System.out.println("answer yes here");
					
					//??get the current smartphone, get JavaObj !!get row => get product_id and use this as 'key' to delete the whole obj in DB 
					Object product_id = table.getValueAt(row, SmartphoneTableModel.PRODUCTID_COL);
										
//					System.out.println("product_id is: " + product_id);
					
					//delete the smartphone from DB
					smartphoneDAO.deleteSmartphone((String) product_id);
					refreshSmartphoneView();
					
					// show success message
					JOptionPane.showMessageDialog(SmartphoneSearchApp.this, "Smartphone deleted successfully.", "Smartphone Deleted", JOptionPane.INFORMATION_MESSAGE);
				}catch(Exception exc){
					JOptionPane.showMessageDialog(SmartphoneSearchApp.this, "Error deleting Smartphone" + exc.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				}finally{
					
				}
			}
		});
		buttonPanel.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/* Instructions about SearchApp: 
				1. get Brand name
				2. call DAO and get SmartphoneObj for that 'title'
				3. if brandnameTextField is empty, then call all Smartphones
				4. print Smartphones
				*/
				
				String titleInput = brandnameTextField.getText();
								
				List<Smartphone> smartphones = null;
				
				try{
							
					if(titleInput!=null && titleInput.trim().length()>0){
						smartphones = smartphoneDAO.searchSmartphones(titleInput);			
					} else{
						smartphones = smartphoneDAO.getAllSmartphones();			
					}
					
//				textArea.setText(textArea.getText() + "\n" + smartphones.toString());	
							
				// ใช้ table แสดง obj แทนการแสดงใน textArea
				SmartphoneTableModel model = new SmartphoneTableModel(smartphones);
				table.setModel(model);
				
				for(Smartphone temp: smartphones){
					System.out.println(temp);
				}
				
				}catch(Exception e1){
					JOptionPane.showMessageDialog(SmartphoneSearchApp.this, "Error: " + e1, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		topPanel.add(btnNewButton);		
	}
	
	public void refreshSmartphoneView(){
		try{
			List<Smartphone> smartphones = smartphoneDAO.getAllSmartphones();
			
			// create the model and update table
			SmartphoneTableModel model = new SmartphoneTableModel(smartphones);
			
			table.setModel(model);
		}catch(Exception exc){
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					SmartphoneSearchApp frame = new SmartphoneSearchApp();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

}

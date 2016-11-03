package ecommerceGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;

import javax.swing.JButton;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateSmartphoneDialog extends JFrame
{
	
	private JPanel contentPane;
	private JTextField pIdTextField;
	private JTextField titleTextField;
	private JTextField descTextField;
	private JTextField screenTextField;
	private JTextField cameraTextField;
	private JTextField manuTextField;
	private JTextField shipTextField;
	private JTextField quanTextField;
	private JTextField prisTextField;
	private JTextField cateTextField;
	
	private SmartphoneSearchApp smartphoneSearchApp;
	private SmartphoneDAO smartphoneDAO;
	private Smartphone previousSmartphone = null;
	private boolean updateMode = false;
	
	// constructors
	public UpdateSmartphoneDialog(SmartphoneSearchApp theSmartphoneSearchApp, SmartphoneDAO theSmartphoneDAO){
		this(theSmartphoneSearchApp, theSmartphoneDAO, null, false);
	}
	
	public UpdateSmartphoneDialog(SmartphoneSearchApp theSmartphoneSearchApp, SmartphoneDAO theSmartphoneDAO, Smartphone thePreviousSmartphone, boolean theUpdateMode){
		this();
		smartphoneSearchApp = theSmartphoneSearchApp;
		smartphoneDAO = theSmartphoneDAO;
		previousSmartphone = thePreviousSmartphone;
		updateMode = theUpdateMode;
		
		if(updateMode){
			setTitle("Update Smartphone");
			
			populateGui(previousSmartphone);
			
		}
	}
	
	
	private void populateGui(Smartphone theSmartphone)
	{
		pIdTextField.setText(theSmartphone.getProductId());
		titleTextField.setText(theSmartphone.getTitle());
		descTextField.setText(theSmartphone.getDescriptions());
		screenTextField.setText(theSmartphone.getScreen());
		cameraTextField.setText(theSmartphone.getCamera());
		manuTextField.setText(theSmartphone.getManufacture_details());
		shipTextField.setText(theSmartphone.getShipping_details());
		quanTextField.setText(theSmartphone.getQuantity());
		prisTextField.setText(theSmartphone.getPricing());
		cateTextField.setText(theSmartphone.getCategories());
		
	}


	public UpdateSmartphoneDialog()
	{
		setTitle("Update Smartphone");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("ProductId");
		panel_1.add(lblNewLabel, "2, 2, right, default");
		
		pIdTextField = new JTextField();
		panel_1.add(pIdTextField, "4, 2, fill, default");
		pIdTextField.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title");
		panel_1.add(lblTitle, "2, 4, right, default");
		
		titleTextField = new JTextField();
		panel_1.add(titleTextField, "4, 4, fill, default");
		titleTextField.setColumns(10);
		
		JLabel lblDescriptions = new JLabel("Descriptions");
		panel_1.add(lblDescriptions, "2, 6, right, default");
		
		descTextField = new JTextField();
		panel_1.add(descTextField, "4, 6, fill, default");
		descTextField.setColumns(10);
		
		JLabel lblScreenSizemm = new JLabel("Screen size (mm)");
		panel_1.add(lblScreenSizemm, "2, 8, right, default");
		
		screenTextField = new JTextField();
		panel_1.add(screenTextField, "4, 8, fill, default");
		screenTextField.setColumns(10);
		
		JLabel lblCameramp = new JLabel("Camera (MP)");
		panel_1.add(lblCameramp, "2, 10, right, default");
		
		cameraTextField = new JTextField();
		panel_1.add(cameraTextField, "4, 10, fill, default");
		cameraTextField.setColumns(10);
		
		JLabel lblManufacture = new JLabel("Manufacture");
		panel_1.add(lblManufacture, "2, 12, right, default");
		
		manuTextField = new JTextField();
		panel_1.add(manuTextField, "4, 12, fill, default");
		manuTextField.setColumns(10);
		
		JLabel lblShipping = new JLabel("Shipping");
		panel_1.add(lblShipping, "2, 14, right, default");
		
		shipTextField = new JTextField();
		panel_1.add(shipTextField, "4, 14, fill, default");
		shipTextField.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity");
		panel_1.add(lblQuantity, "2, 16, right, default");
		
		quanTextField = new JTextField();
		panel_1.add(quanTextField, "4, 16, fill, default");
		quanTextField.setColumns(10);
		
		JLabel lblPricingusd = new JLabel("Pricing (USD)");
		panel_1.add(lblPricingusd, "2, 18, right, default");
		
		prisTextField = new JTextField();
		panel_1.add(prisTextField, "4, 18, fill, default");
		prisTextField.setColumns(10);
		
		JLabel lblCategories = new JLabel("Categories");
		panel_1.add(lblCategories, "2, 20, right, default");
		
		cateTextField = new JTextField();
		panel_1.add(cateTextField, "4, 20, fill, default");
		cateTextField.setColumns(10);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				saveSmartphone();
			}
		});
		panel.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// close dialog
				setVisible(false);
				dispose();
			}
		});
		panel.add(btnCancel);
	}
	

	protected void saveSmartphone()
	{
		// get - save - close - refresh - show	
		String productIdStr = pIdTextField.getText();
		String titleStr = titleTextField.getText();
		String desStr = descTextField.getText();
		String screenStr = screenTextField.getText();
		String cameraStr = cameraTextField.getText();
		String manuStr = manuTextField.getText();
		String shipStr = shipTextField.getText();
		String quanStr = quanTextField.getText();
		String prisStr = prisTextField.getText();
		String cateStr = cateTextField.getText();
				
		Smartphone tempSmartphone = null;
		if(updateMode){
			
			tempSmartphone = previousSmartphone;
			
			tempSmartphone.setProductId(productIdStr);
			tempSmartphone.setTitle(titleStr);
			tempSmartphone.setDescriptions(desStr);
			tempSmartphone.setScreen(screenStr);
			tempSmartphone.setCamera(cameraStr);
			tempSmartphone.setManufacture_details(manuStr);
			tempSmartphone.setShipping_details(shipStr);
			tempSmartphone.setQuantity(quanStr);
			tempSmartphone.setPricing(prisStr);
			tempSmartphone.setCategories(cateStr);
				
		}else{
			tempSmartphone = new Smartphone(productIdStr, titleStr, desStr, screenStr, cameraStr, manuStr, shipStr, quanStr, prisStr, cateStr);
		}
		
		try{
			//save to DB
			if(updateMode){
				smartphoneDAO.updateSmartphone(previousSmartphone, tempSmartphone);
			}else{
				smartphoneDAO.addSmartphone(tempSmartphone);
			}
	
			//close dialog
			setVisible(false);
			dispose();
			
			//refresh Gui list
			smartphoneSearchApp.refreshSmartphoneView();
			
			//show success message
			JOptionPane.showMessageDialog(smartphoneSearchApp, "Smartphone updated successfully", "Smartphone added", JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception exc){
			
			JOptionPane.showMessageDialog(smartphoneSearchApp, "Error saving smartphone: " + exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	
		}			
	}
}

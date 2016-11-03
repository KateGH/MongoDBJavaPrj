package ecommerceGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class AddSmartphoneDialog extends JFrame
{

	private JPanel contentPane;
	private JTextField pIDTextField;
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
	
	// Connect to MongoDB
		MongoClient mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("ecom");							
		DBCollection collection = db.getCollection("smartphones");
	

	public AddSmartphoneDialog(SmartphoneSearchApp theSmartphoneSearchApp, SmartphoneDAO theSmartphoneDAO){
		this();
		smartphoneSearchApp = theSmartphoneSearchApp;
		smartphoneDAO = theSmartphoneDAO;
	}

	public AddSmartphoneDialog()
	{
		
		setTitle("Add New Phone");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblProductid = new JLabel("ProductId");
		contentPane.add(lblProductid, "2, 2, right, default");
		
		pIDTextField = new JTextField();
		contentPane.add(pIDTextField, "4, 2, fill, default");
		pIDTextField.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title");
		contentPane.add(lblTitle, "2, 4, right, default");
		
		titleTextField = new JTextField();
		contentPane.add(titleTextField, "4, 4, fill, default");
		titleTextField.setColumns(10);
		
		JLabel lblDescriptions = new JLabel("Descriptions");
		lblDescriptions.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblDescriptions, "2, 6, right, default");
		
		descTextField = new JTextField();
		contentPane.add(descTextField, "4, 6, fill, default");
		descTextField.setColumns(10);
		
		JLabel lblScreenSizemm = new JLabel("Screen size (mm)");
		lblScreenSizemm.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblScreenSizemm, "2, 8, right, default");
		
		screenTextField = new JTextField();
		contentPane.add(screenTextField, "4, 8, fill, default");
		screenTextField.setColumns(10);
		
		JLabel lblCameramp = new JLabel("Camera (MP)");
		contentPane.add(lblCameramp, "2, 10, right, default");
		
		cameraTextField = new JTextField();
		contentPane.add(cameraTextField, "4, 10, fill, default");
		cameraTextField.setColumns(10);
		
		JLabel lblManufacturedetails = new JLabel("Manufacture_details");
		contentPane.add(lblManufacturedetails, "2, 12, right, default");
		
		manuTextField = new JTextField();
		contentPane.add(manuTextField, "4, 12, fill, default");
		manuTextField.setColumns(10);
		
		JLabel lblShippingdetails = new JLabel("Shipping_details");
		contentPane.add(lblShippingdetails, "2, 14, right, default");
		
		shipTextField = new JTextField();
		contentPane.add(shipTextField, "4, 14, fill, default");
		shipTextField.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity");
		contentPane.add(lblQuantity, "2, 16, right, default");
		
		quanTextField = new JTextField();
		contentPane.add(quanTextField, "4, 16, fill, default");
		quanTextField.setColumns(10);
		
		JLabel lblPricingusd = new JLabel("Pricing (USD)");
		contentPane.add(lblPricingusd, "2, 18, right, default");
		
		prisTextField = new JTextField();
		contentPane.add(prisTextField, "4, 18, fill, default");
		prisTextField.setColumns(10);
		
		JLabel lblCategories = new JLabel("Categories");
		contentPane.add(lblCategories, "2, 20, right, default");
		
		cateTextField = new JTextField();
		contentPane.add(cateTextField, "4, 20, fill, default");
		cateTextField.setColumns(10);
		
		JPanel buttonPanel = new JPanel();
		contentPane.add(buttonPanel, "2, 24, 3, 1, fill, fill");
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				saveSmartphone();
	
			}		
		});
		buttonPanel.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// close dialog
				setVisible(false);
				dispose();
			}
		});
		buttonPanel.add(btnCancel);
	}
	
	
	protected void saveSmartphone()
	{	
		// !!very simple way in MongoDB (get - save - show) compare with MySQL (get - save - close - refresh - show)
		BasicDBObject document = new BasicDBObject();
			
		document.put("productId", pIDTextField.getText());
		document.put("title", titleTextField.getText());
		document.put("descriptions", descTextField.getText());
		document.put("screen", screenTextField.getText());
		document.put("camera", cameraTextField.getText());
		document.put("manufacture", manuTextField.getText());
		document.put("shipping", shipTextField.getText());
		document.put("quantity", quanTextField.getText());
		document.put("pricing", prisTextField.getText());
		document.put("categories", cateTextField.getText());
			
		collection.insert(document);
		
		//close dialog
		setVisible(false);
		dispose();
			
		// refresh GUI list
		smartphoneSearchApp.refreshSmartphoneView();
			
	}

	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					AddSmartphoneDialog frame = new AddSmartphoneDialog();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

}

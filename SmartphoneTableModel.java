package ecommerceGUI;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class SmartphoneTableModel extends AbstractTableModel
{
	static final int OBJECT_COL = -1;
	static final int PRODUCTID_COL = 0;
	static final int TITLE_COL = 1;
	static final int DESCRIPTIONs_COL = 2;
	static final int SCREEN_COL = 3;
	static final int CAMERA_COL = 4;
	static final int MANUFACTUREs_COL = 5;
	static final int SHIPPINGs_COL = 6;
	static final int QUANTITY_COL = 7;
	static final int PRICING_COL = 8;
	static final int CATEGORIES_COL = 9;
	
	private String [] columnNames = {"ProductId", "Title", "Descriptions", "Screen", "Camera", "Manufacture", "Shippings", "Quantity", "Pricing", "Categories"};
	private List <Smartphone> smartphones;
	
	//constructor
	public SmartphoneTableModel(){
	}
	
	public SmartphoneTableModel(List<Smartphone> theSmartphones){
		smartphones = theSmartphones;
	}
	
	/*Override 5 methods below:-
	1.getRowCount()
	2.getColumnCount()
	3.getColumnName(int col)
	4.getColumnClass(int col) => does not need like MySQL
	5.getValueAt(int row, int col)
	*/
	
	
	@Override
	public int getRowCount()
	{
		return smartphones.size();
	}

	@Override
	public int getColumnCount()
	{
		return columnNames.length;
	}
	
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}
	
//	@Override
//	public Class getColumnClass(int c) {
//		return getValueAt(0, c).getClass();
//	}

	// this method is called to set the value of each cell
	@Override
	public Object getValueAt(int row, int col)
	{
		Smartphone tempSmartphone = smartphones.get(row); 
					
		switch (col){
			case PRODUCTID_COL:
				return tempSmartphone.getProductId();
			case TITLE_COL:
				return tempSmartphone.getTitle();
			case DESCRIPTIONs_COL:
				return tempSmartphone.getDescriptions();
			case SCREEN_COL:
				return tempSmartphone.getScreen();	
			case CAMERA_COL:
				return tempSmartphone.getCamera();
			case MANUFACTUREs_COL:
				return tempSmartphone.getManufacture_details();
			case SHIPPINGs_COL:
				return tempSmartphone.getShipping_details();
			case QUANTITY_COL:
				return tempSmartphone.getQuantity();
			case PRICING_COL:
				return tempSmartphone.getPricing();
			case CATEGORIES_COL:
				return tempSmartphone.getCategories();	
			case OBJECT_COL:
				return tempSmartphone.getObjId();
			default:	
				return tempSmartphone;
		}		
	}
}

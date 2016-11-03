package ecommerceGUI;
// JavaBean class

public class Smartphone
{
	private String productId;
	private String title;
	private String descriptions;
	private String screen;
	private String camera;
	private String manufacture_details;
	private String shipping_details;
	private String quantity;
	private String pricing;
	private String categories;
	private String objId;
	
	
	//constructor#1
//	public Smartphone(int i, String title2, String descriptions2, String screen2, String camera2, String manufacture_details2, String shipping_details2, int quantity2, int pricing2, String categories2){
//		
//	}
	
	//constructor#2
	public Smartphone(String ObjId, String productId, String title, String descriptions, double screen, String camera, String manufacture_details, String shipping_details, int quantity, int pricing, String categories){
//		this(0, productId, title, descriptions, screen, camera, manufacture_details, shipping_details, quantity, pricing, categories);
	}
		
	//constructor#3
	public Smartphone(String productId, String title, String descriptions, String screen, String camera, String manufacture_details, String shipping_details, String quantity, String pricing, String categories){
		super();
		this.setProductId(productId);
		this.setTitle(title);
		this.setDescriptions(descriptions);
		this.setScreen(screen);
		this.setCamera(camera);
		this.setManufacture_details(manufacture_details);
		this.setShipping_details(shipping_details);
		this.setQuantity(quantity);
		this.setPricing(pricing);
		this.setCategories(categories);
	}

	// method getter and setter of each variable
	public String getProductId()
	{
		return productId;
	}

	public void setProductId(String productId)
	{
		this.productId = productId;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getDescriptions()
	{
		return descriptions;
	}

	public void setDescriptions(String descriptions)
	{
		this.descriptions = descriptions;
	}

	public String getScreen()
	{
		return screen;
	}

	public void setScreen(String screen)
	{
		this.screen = screen;
	}

	public String getCamera()
	{
		return camera;
	}

	public void setCamera(String camera)
	{
		this.camera = camera;
	}

	public String getManufacture_details()
	{
		return manufacture_details;
	}

	public void setManufacture_details(String manufacture_details)
	{
		this.manufacture_details = manufacture_details;
	}

	public String getShipping_details()
	{
		return shipping_details;
	}

	public void setShipping_details(String shipping_details)
	{
		this.shipping_details = shipping_details;
	}

	public String getQuantity()
	{
		return quantity;
	}

	public void setQuantity(String quantity)
	{
		this.quantity = quantity;
	}

	public String getPricing()
	{
		return pricing;
	}

	public void setPricing(String pricing)
	{
		this.pricing = pricing;
	}

	public String getCategories()
	{
		return categories;
	}

	public void setCategories(String categories)
	{
		this.categories = categories;
	}
	
	public String toString(){
		
		return String.format("Smartphone [productId=%s, title=%s, descriptions=%s, screen=%s, camera=%s, manufacture_details=%s, shipping_details=%s, quantity=%s, pricing=%s, categories=%s]", 
				productId, title, descriptions, screen, camera, manufacture_details, shipping_details, quantity, pricing, categories);
	}

	public String getObjId()
	{
		return objId;
	}

	public void setObjId(String objId)
	{
		this.objId = objId;
	}
	

}

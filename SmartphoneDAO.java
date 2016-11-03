package ecommerceGUI;
//DB from MongoDB > ecom > smartphones

import java.util.ArrayList;
import java.util.List;

import org.bson.BasicBSONObject;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.bulk.WriteRequest.Type;

public class SmartphoneDAO
{
	// variables
	DBCollection collection;
	
	// constructor
	public SmartphoneDAO() throws Exception{
		
		// Connect to MongoDB
		MongoClient mongo = new MongoClient("localhost", 27017);
					
		// Get DB
		DB db = mongo.getDB("ecom");
					
		// Get Collection
		collection = db.getCollection("smartphones"); // if there is 'DBCollection' as type here it means new object which makes collection in line39 error:NullPointException
		
		System.out.println("Connected!!");		
	}
	
	
	private Smartphone convertDBObjToSmartphone(DBObject dbObj)
	{
				String productId = ((BasicBSONObject) dbObj).getString("productId");
				String title = ((BasicBSONObject) dbObj).getString("title");
				String descriptions = ((BasicBSONObject) dbObj).getString("descriptions");
				String screen = ((BasicBSONObject) dbObj).getString("screen");
				String camera = ((BasicBSONObject) dbObj).getString("camera");
				String manufacture_details= ((BasicBSONObject) dbObj).getString("manufacture_details");
				String shipping_details = ((BasicBSONObject) dbObj).getString("shipping_details");
				String quantity = ((BasicBSONObject) dbObj).getString("quantity");
				String pricing = ((BasicBSONObject) dbObj).getString("pricing");
				String categories = ((BasicBSONObject) dbObj).getString("categories");
				
				Smartphone smartphone = new Smartphone(productId, title, descriptions, screen, camera, manufacture_details, shipping_details, quantity, pricing, categories);
							
		return smartphone;
	}
	
		
	public List<Smartphone> getAllSmartphones() throws Exception{
			
		List <Smartphone> list = new ArrayList<>();
	
		// myCursor คือ หัวตาราง, dbObj คือ แต่ละ obj ใน database
		DBCursor myCursor = collection.find();	// Display all Phones, use DBCursor to get all obj to display in TextArea
		
		try{	
		
		while(myCursor.hasNext()){
			
			DBObject dbObj = myCursor.next();
			
			Smartphone tempSmartphone = convertDBObjToSmartphone(dbObj);	
		
			list.add(tempSmartphone); 
		}		
		}catch(MongoException e){
			e.printStackTrace();
		}finally{
			myCursor.close();
		}
		return list;		
	}
	

	public List<Smartphone> searchSmartphones(String titleInput) throws Exception{
		
		List<Smartphone> list = new ArrayList<>();
		
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("title", titleInput);
		
		DBCursor myCursor = collection.find(searchQuery);
	
		try{
			
			while(myCursor.hasNext()){
				
				DBObject dbObj = myCursor.next();
				
				Smartphone tempSmartphone = convertDBObjToSmartphone(dbObj);
				
				list.add(tempSmartphone);
			
			}			
		}catch(MongoException e){
			e.printStackTrace();
		}finally{
			myCursor.close();
		}
		
		return list;
	}

	
	public void addSmartphone(Smartphone theSmartphone) throws Exception{
		
		try{
			
			BasicDBObject document = new BasicDBObject();
			
			document.put("productId", theSmartphone.getProductId());
			document.put("title", theSmartphone.getTitle());
			document.put("descriptions", theSmartphone.getDescriptions());
			document.put("screen", theSmartphone.getScreen());
			document.put("camera", theSmartphone.getCamera());
			document.put("manufacture", theSmartphone.getManufacture_details());
			document.put("shipping", theSmartphone.getShipping_details());
			document.put("quantity", theSmartphone.getQuantity());
			document.put("pricing", theSmartphone.getPricing());
			document.put("categories", theSmartphone.getCategories());
				
			collection.insert(document); //?? how to know this collection save back to DB??
			
			System.out.println("inserted!!");
			System.out.println("collection " + collection.insert(document));
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
	}
	
	
	public void updateSmartphone(Smartphone previousSmartphone, Smartphone theSmartphone){
		
		try{
			
			BasicDBObject newDocument = new BasicDBObject();
			newDocument.put("productId", theSmartphone.getProductId());
			newDocument.put("title", theSmartphone.getTitle());
			newDocument.put("descriptions", theSmartphone.getDescriptions());
			newDocument.put("screen", theSmartphone.getScreen());
			newDocument.put("camera", theSmartphone.getCamera());
			newDocument.put("manufacture", theSmartphone.getManufacture_details());
			newDocument.put("shipping", theSmartphone.getShipping_details());
			newDocument.put("quantity", theSmartphone.getQuantity());
			newDocument.put("pricing", theSmartphone.getPricing());
			newDocument.put("categories", theSmartphone.getCategories());

//			!! Here how to update DBObject, delete old one and save new (#01 didnot work, use #02)	
			
/*			#01 
 			BasicDBObject updateObj = new BasicDBObject();
			updateObj.put("$set", newDocument);	
			collection.update((DBObject) previousSmartphone, updateObj);
*/		
//			#02
			deleteSmartphone(theSmartphone.getProductId());
			collection.save(newDocument);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}		
	}
	
	public void deleteSmartphone(String product_id){
		
		BasicDBObject removeQuery = new BasicDBObject();
		removeQuery.put("productId", product_id);
		
		collection.remove(removeQuery);		
	}
	
	
	public static void main(String[] args) throws Exception
	{
		SmartphoneDAO dao = new SmartphoneDAO();
		
	}

}

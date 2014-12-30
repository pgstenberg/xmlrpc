package se.stonepath.framework.xmlrpc.respond;

import java.util.HashMap;
import java.util.Iterator;

import se.stonepath.framework.xmlrpc.XmlRpcRespond;

public class XmlRpcCollectionRespond extends HashMap<String, Object> implements XmlRpcRespond{

	private static final long serialVersionUID = 1L;
	
	

	@SuppressWarnings("unchecked")
	public void processRespond(Object object) {
		HashMap<String, Object> objectMap = (HashMap<String, Object>)object;
		putAll(objectMap);
	}

	
	@SuppressWarnings("unchecked")
	public XmlRpcCollectionRespond getChild(String key){
		return buildFromHashMap((HashMap<String, Object>)get(key));
	}
	
	public static XmlRpcCollectionRespond buildFromHashMap(HashMap<String, Object> hashMap){
		Iterator<Entry<String, Object>> iterator = hashMap.entrySet().iterator();
		XmlRpcCollectionRespond collectionRespond = new XmlRpcCollectionRespond();
		while(iterator.hasNext()){
			Entry<String, Object> entry = iterator.next();
			
			collectionRespond.put(entry.getKey(), entry.getValue());
		}
		
		return collectionRespond;
	}
	
	public static boolean StringNullOrEmpty(XmlRpcCollectionRespond collectionRespond,String key)
	{

		if(collectionRespond.get(key) == null)
			return true;
		
		if(collectionRespond.get(key) != null)
			if( ((String)collectionRespond.get(key)).equals("") )
				return true;
		
		return false;
	}
}

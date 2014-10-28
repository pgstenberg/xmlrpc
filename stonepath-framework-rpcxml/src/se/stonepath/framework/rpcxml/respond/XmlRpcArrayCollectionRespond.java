package se.stonepath.framework.rpcxml.respond;

import java.util.HashMap;
import java.util.Vector;

import se.stonepath.framework.rpcxml.XmlRpcRespond;


public class XmlRpcArrayCollectionRespond extends Vector<HashMap<String, Object>> implements XmlRpcRespond{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public void processRespond(Object object) {
		Object[] objectArray = (Object[])object;
		
		for(Object objectEntry : objectArray){
			add((HashMap<String, Object>)objectEntry);
		}
	}

}

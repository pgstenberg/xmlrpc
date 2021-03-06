package se.stonepath.framework.xmlrpc.respond;

import se.stonepath.framework.xmlrpc.XmlRpcRespond;

public class XmlRpcValueRespond<T> implements XmlRpcRespond{

	private T value;
	private Class<T> classType;
	
	public XmlRpcValueRespond(Class<T> classType){
		this.classType = classType;
	}
	
	public void processRespond(Object object) {
		this.value = classType.cast(object);
	}
	
	public T getValue(){
		return value;
	}

}

package se.stonepath.framework.xmlrpc;


import java.util.ArrayList;


public abstract class XmlRpcRequest extends ArrayList<Object>{


	/**
	 * 
	 */
	private static final long serialVersionUID = -3551627968879287091L;

	public abstract String getMethodName();
	

}

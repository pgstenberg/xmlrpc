package se.stonepath.framework.xmlrpc;


public class XmlRpcException extends Exception{

	private static final long serialVersionUID = 1L;

	public XmlRpcException(Exception e) {
		super(e.getMessage());
	}

}

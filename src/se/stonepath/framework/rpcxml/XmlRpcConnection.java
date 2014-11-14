package se.stonepath.framework.rpcxml;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;




public class XmlRpcConnection {

	private XmlRpcClient connection;
	private String connectionUrl;
	
	
	public XmlRpcConnection(String connectionUrl){
		this.connectionUrl = connectionUrl;
	}
	
	public <T extends XmlRpcRespond> T sendRequest(XmlRpcRequest request,T respond) throws XmlRpcException, InstantiationException, IllegalAccessException{	
		try{
			respond.processRespond(connection.execute(request.methodName(), request.toArray()));
			
		}catch(org.apache.xmlrpc.XmlRpcException e){
			throw new XmlRpcException(e);
		}
		return respond;
	}
	
	public <T extends XmlRpcRespond> T sendRequest(XmlRpcRequest request,Class<T> respond) throws InstantiationException, IllegalAccessException, XmlRpcException {
		return sendRequest(request, respond.newInstance());
	}
	
	
	public boolean connect() throws MalformedURLException{
		connection = new XmlRpcClient(); 
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		config.setServerURL(new URL(connectionUrl));
		connection.setTypeFactory(new XmlRpcTypeNil(connection));
		connection.setConfig(config);	
		
		return true;
	}
}

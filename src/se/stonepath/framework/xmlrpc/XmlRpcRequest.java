package se.stonepath.framework.xmlrpc;


import java.util.Vector;
import java.util.stream.Stream;

public abstract class XmlRpcRequest extends Vector<Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public abstract String methodName();
	
	
	public Stream<Object> stream() {
		return null;
	}

	public Stream<Object> parallelStream() {
		return null;
	}
}

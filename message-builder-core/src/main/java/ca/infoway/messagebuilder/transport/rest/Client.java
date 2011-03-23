package ca.infoway.messagebuilder.transport.rest;

import java.io.IOException;

import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;

/**
 * @sharpen.ignore - transport - TBD!
 */
interface Client {
	public HttpState getState();
	public HttpClientParams getParams();
	public int executeMethod(PostMethod method) throws IOException;
}

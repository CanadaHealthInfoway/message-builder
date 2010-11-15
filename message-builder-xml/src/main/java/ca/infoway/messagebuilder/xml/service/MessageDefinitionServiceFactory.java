package ca.infoway.messagebuilder.xml.service;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.List;

/**
 * <p>The message defintion service factory provides a list of all message definitions
 * that are available from the classpath.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore  - xml.service - translated manually
 */
public class MessageDefinitionServiceFactory extends ServiceFactory<MessageDefinitionService> {
	
	private static MessageDefinitionService instance;

	/**
	 * <p>Standard constructor.
	 */
	public MessageDefinitionServiceFactory() {
		super(MessageDefinitionService.class);
	}

	@Override
	protected MessageDefinitionService chooseImplementationOfService(List<MessageDefinitionService> services) {
		return new CompositeMessageDefinitionService(services);
	}

	@Override
	protected MessageDefinitionService createTrivialService() {
		return new TrivialService();
	}
	
	/**
	 * <p>Create an instance of the message definition service.
	 * @return the message definition service
	 */
	@Override
	public MessageDefinitionService create() {
		synchronized (getClass()) {
			if (instance == null) {
				instance = super.create();
			}
			return instance;
		}
	}
	
	@Override
	protected List<MessageDefinitionService> getServices(Enumeration<URL> resources) throws IOException {
		List<MessageDefinitionService> result = super.getServices(resources);
		result.add(new ManifestMessageDefinitionService());
		return result;
	}
}

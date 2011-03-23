package ca.infoway.messagebuilder.marshalling;

import org.junit.Before;

import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

public abstract class BaseTealMlTransformerTestCase {
	
	protected MessageBeanTransformerImpl transformer;
	protected DocumentFactory factory;

	@Before
	public void setUp() throws Exception {
		this.transformer = new MessageBeanTransformerImpl();
		this.factory = new DocumentFactory();
		CodeResolverRegistry.register(new TrivialCodeResolver());
	}

	@Before
	public void tearDown() throws Exception {
		CodeResolverRegistry.unregisterAll();
	}
}

package ca.infoway.messagebuilder.marshalling;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ca.infoway.messagebuilder.platform.ClassUtil;
import ca.infoway.messagebuilder.platform.GenericClassUtil;
import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Interaction;

/**
 * <p>A class that helps to instantiate instances of message builder beans.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class Instantiator {
	
	private static Instantiator instance;
	
	/**
	 * <p>Static accessor.   This class is implemented as a singleton, and the
	 * static accessor provides access to the single instance.
	 * 
	 * @return - the instance
	 */
	public static Instantiator getInstance() {
		if (instance == null){
			initializeInstance();
		}
		return instance;
	}

	private static void initializeInstance() {
		Instantiator factory = new Instantiator();
		instance = factory;
	}
	
	private final Log log = LogFactory.getLog(Instantiator.class);


	private Instantiator() {
	}

	/**
	 * <p>Instantiate a bean that models the part under question.
	 * 
	 * @param version - the version code
	 * @param type - the part type
	 * @return an instance of a bean that represents the part type
	 */
	public Object instantiateMessagePartBean(String version, String type, Interaction interaction) {
		try {
			Class<?> partClass = MessageBeanRegistry.getInstance().getMessagePartClass(version, type);
			if (partClass == null) {
				throw createMarshallingException("Did not find", version, type);
			} else if (!ClassUtil.isGeneric(partClass)) {
				this.log.debug("Instantiating bean: " + partClass.getName());
				return partClass.newInstance();
			} else {
				this.log.debug("Instantiating parameterized bean: " + partClass.getName());
				return GenericClassUtil.instantiate(partClass, createParameterMap(interaction, version));
			}
		} catch (IllegalAccessException e) {
			throw createMarshallingException("Error instantiating", version, type, e);
		} catch (InstantiationException e) {
			throw createMarshallingException("Error instantiating", version, type, e);
		} 
	}
	
	private Map<String,Class<?>> createParameterMap(Interaction interaction, String version) {
		Map<String,Class<?>> map = new HashMap<String,Class<?>>();
		createParameterMap(version, map, interaction.getArguments());
		
		System.out.println(map);
		return map;
	}

	private void createParameterMap(String version, Map<String, Class<?>> map,
			List<Argument> arguments) {
		for (Argument argument : arguments) {
			map.put(TemplateVariableNameUtil.transform(argument.getTemplateParameterName()), 
					MessageBeanRegistry.getInstance().getMessagePartClass(version, argument.getName()));
			createParameterMap(version, map, argument.getArguments());
		}
	}

	private MarshallingException createMarshallingException(String errorPrefix, String version, String type){
		return createMarshallingException(errorPrefix, version, type, null);
	}

	private MarshallingException createMarshallingException(String errorPrefix, String version, String type, Exception e){
		StringBuilder builder = new StringBuilder();
		builder.append(errorPrefix);
		builder.append(" Bean for Hl7 Part Type:");
		builder.append(type);
		builder.append(" for version ");
		builder.append(version.toString());
		log.debug(builder.toString());
		if (e == null) {
			return new MarshallingException(builder.toString());
		} else {
			return new MarshallingException(builder.toString(), e);
		}
	}
}

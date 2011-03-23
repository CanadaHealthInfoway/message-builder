package ca.infoway.messagebuilder.generator;

import static java.lang.String.format;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;

import com.google.common.base.Function;
import com.google.common.base.Functions;

class WrappedParameterAppenderRegistry {
	
	public static WrappedParameterAppenderRegistry instance;
	
	private final Map<StandardDataType, ParameterAppender> appenders;

	WrappedParameterAppenderRegistry(Map<StandardDataType, ParameterAppender> appenders) {
		this.appenders = appenders;
	}

	public static WrappedParameterAppenderRegistry getInstance() {
		if (instance == null) {
			initialize();
		}
		return instance;
	}

	private static synchronized void initialize() {
		if (instance == null) {
			Map<StandardDataType, ParameterAppender> map = new HashMap<StandardDataType, ParameterAppender>();
			map.put(StandardDataType.LIST, new ParameterAppenderForListOrSet());
			map.put(StandardDataType.SET, new ParameterAppenderForListOrSet());
			map.put(StandardDataType.RTO, new ParameterAppenderForRto());
			map.put(StandardDataType.CD, new ParameterAppenderForCode());
			map.put(StandardDataType.CV, new ParameterAppenderForCode());
			map.put(StandardDataType.CE, new ParameterAppenderForCode());
			map.put(StandardDataType.CS, new ParameterAppenderForCode());
			map.put(StandardDataType.IVL, new ParameterAppenderForIvl());
			map.put(StandardDataType.ANY, new ParameterAppenderForAny());
			map.put(StandardDataType.PIVL_TS_DATETIME, new ParameterAppenderForPivl());
			map.put(StandardDataType.PIVL, new ParameterAppenderForPivl());
			map.put(StandardDataType.ED, new ParameterAppenderForEd());
			map.put(StandardDataType.URG, new ParameterAppenderForUrg());
			instance = new WrappedParameterAppenderRegistry(map);
		}
	}
	
	public ParameterAppender getAppender(StandardDataType dataType) {
		ParameterAppender appender = DefaultWrappedParameterAppender.INSTANCE; 
		if (dataType!=null && this.appenders.containsKey(dataType.getRootDataType())) {
			appender = this.appenders.get(dataType.getRootDataType());
		}
		return appender;
	}
	
	static class DefaultWrappedParameterAppender implements ParameterAppender {
		static final DefaultWrappedParameterAppender INSTANCE = new DefaultWrappedParameterAppender(); 
		
		public void appendWrapped(StringBuilder builder, DataType dataType, List<DataType> parameters, ProgrammingLanguage language) {
			if (!CollectionUtils.isEmpty(parameters)) {
				builder.append("<");
				boolean first = true;
				for (DataType parameter : parameters) {
					if (!first) {
						builder.append(", ");
					}
					builder.append(parameter.getShortWrappedName());
					first = false;
				}
				builder.append(">");
			}
		}
		
		public void append(StringBuilder builder, DataType dataType, List<DataType> parameters, ProgrammingLanguage language) {
			if (!CollectionUtils.isEmpty(parameters)) {
				builder.append("<");
				boolean first = true;
				for (DataType parameter : parameters) {
					if (!first) {
						builder.append(", ");
					}
					parameter.getShortName(builder, language);
					first = false;
				}
				builder.append(">");
			}
		}
		
	}

	static class ParameterAppenderForEd extends DefaultWrappedParameterAppender {
		@Override
		public void appendWrapped(StringBuilder builder, DataType dataType, List<DataType> parameters, ProgrammingLanguage language) {
			builder.append("<");
			builder.append(dataType.getShortName());
			builder.append(">");
		}
	}
	
	static class ParameterAppenderForAny extends DefaultWrappedParameterAppender {
		@Override
		public void appendWrapped(StringBuilder builder, DataType dataType, List<DataType> parameters, ProgrammingLanguage language) {
			builder.append("<");
			builder.append(dataType.getShortName());
			builder.append(">");
		}
	}

	static class ParameterAppenderForListOrSet extends DefaultWrappedParameterAppender {
		@Override
		public void appendWrapped(StringBuilder builder, DataType dataType, List<DataType> parameters, ProgrammingLanguage language) {
			if (!CollectionUtils.isEmpty(parameters)) {
				builder.append("<");
				List<String> flattenedParameters = flatten(parameters, language);
				if (parameters.get(0).isCodedType()) {
					builder.append(flattenedParameters.get(0));
					builder.append(", ");
					builder.append(Code.class.getSimpleName());
				} else {
					boolean first = true;
					for (String parameter : flattenedParameters) {
						if (!first) {
							builder.append(", ");
						}
						builder.append(parameter);
						first = false;
					}
				}
				builder.append(">");
			}
		}
	}
	
	static class ParameterAppenderForUrg extends DefaultWrappedParameterAppender {
		@Override
		public void appendWrapped(StringBuilder builder, DataType dataType, List<DataType> parameters, ProgrammingLanguage language) {
			if (!CollectionUtils.isEmpty(parameters)) {
				List<String> flattenedParameters = flatten(parameters, language);
				builder.append("<");
				boolean first = true;
				for (String parameter : flattenedParameters) {
					if (!first) {
						builder.append(", ");
					}
					builder.append(parameter);
					first = false;
				}
				builder.append(">");
			}
		}
	}

	static class ParameterAppenderForRto extends DefaultWrappedParameterAppender {
		@Override
		public void appendWrapped(StringBuilder builder, DataType dataType, List<DataType> parameters, ProgrammingLanguage language) {
			if (!CollectionUtils.isEmpty(parameters)) {
				builder.append("<");
				boolean first = true;
				for (DataType parameter : parameters) {
					if (!first) {
						builder.append(", ");
					}
					builder.append(parameter.getShortName());
					first = false;
				}
				builder.append(">");
			}
		}
	}

	static class ParameterAppenderForCode extends DefaultWrappedParameterAppender {
		@Override
		public void appendWrapped(StringBuilder builder, DataType dataType, List<DataType> parameters, ProgrammingLanguage language) {
		}
	}

	static class ParameterAppenderForIvl extends DefaultWrappedParameterAppender {
		@Override
		public void appendWrapped(StringBuilder builder, DataType dataType, List<DataType> parameters, ProgrammingLanguage language) {
			if (!CollectionUtils.isEmpty(parameters)) {
				List<String> flattenedParameters = flatten(parameters, language, new Function<String, String>() {
					public String apply(String shortName) {
						return format("Interval<%s>", shortName);
					}
				});
				builder.append("<");
				boolean first = true;
				for (String parameter : flattenedParameters) {
					if (!first) {
						builder.append(", ");
					}
					builder.append(parameter);
					first = false;
				}
				builder.append(">");
			}
		}
	}

	static class ParameterAppenderForPivl extends DefaultWrappedParameterAppender {
		@Override
		public void appendWrapped(StringBuilder builder, DataType dataType, List<DataType> parameters, ProgrammingLanguage language) {
		}
		@Override
		public void append(StringBuilder builder, DataType dataType, List<DataType> parameters, ProgrammingLanguage language) {
		}
	}
	
	private static List<String> flatten(List<DataType> parameters, ProgrammingLanguage language) {
		return flatten(parameters, language, Functions.<String>identity());
	}

	private static List<String> flatten(List<DataType> parameters, ProgrammingLanguage language, Function<String, String> shortNameDecorator) {
		ArrayList<String> flattenedParameters = new ArrayList<String>();
		for (DataType dataType : parameters) {
			flattenedParameters.add(dataType.getShortWrappedName());
		}
		for (DataType dataType : parameters) {
			flattenedParameters.add(shortNameDecorator.apply(dataType.getShortName(language)));
		}
		return flattenedParameters;
	}
	
}

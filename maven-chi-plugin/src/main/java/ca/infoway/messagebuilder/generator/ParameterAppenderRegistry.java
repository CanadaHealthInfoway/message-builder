/**
 * Copyright 2013 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.generator;

import static java.lang.String.format;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ClassUtils;

import com.google.common.base.Function;
import com.google.common.base.Functions;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.generator.util.ProgrammingLanguage;

class ParameterAppenderRegistry {
	
	public static ParameterAppenderRegistry instance;
	
	private final Map<StandardDataType, ParameterAppender> appenders;

	ParameterAppenderRegistry(Map<StandardDataType, ParameterAppender> appenders) {
		this.appenders = appenders;
	}

	public static ParameterAppenderRegistry getInstance() {
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
			map.put(StandardDataType.COLLECTION, new ParameterAppenderForCollection());
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
			map.put(StandardDataType.SC, new ParameterAppenderForSc());
			map.put(StandardDataType.EN, new ParameterAppenderForEn());
			instance = new ParameterAppenderRegistry(map);
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
			builder.append(dataType.getShortName(language));
			builder.append(">");
		}
	}
	
	static class ParameterAppenderForSc extends DefaultWrappedParameterAppender {
		@Override
		public void appendWrapped(StringBuilder builder, DataType dataType,	List<DataType> parameters, ProgrammingLanguage language) {
			if (!parameters.isEmpty()) {
				builder.append("<");
				builder.append(ClassUtils.getShortClassName(parameters.get(0).getTypeName()));
				builder.append(">");
			}
		}
		@Override
		public void append(StringBuilder builder, DataType dataType, List<DataType> parameters, ProgrammingLanguage language) {
			if (!parameters.isEmpty()) {
				builder.append("<");
				builder.append(ClassUtils.getShortClassName(parameters.get(0).getTypeName()));
				builder.append(">");
			}
		}
	}
	
	static class ParameterAppenderForEn extends DefaultWrappedParameterAppender {
		@Override
		public void appendWrapped(StringBuilder builder, DataType dataType, List<DataType> parameters, ProgrammingLanguage language) {
			builder.append("<");
			builder.append(dataType.getShortName(language));
			builder.append(">");
		}
	}
	
	static class ParameterAppenderForAny extends DefaultWrappedParameterAppender {
		@Override
		public void appendWrapped(StringBuilder builder, DataType dataType, List<DataType> parameters, ProgrammingLanguage language) {
			builder.append("<");
			builder.append(dataType.getShortName(language));
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

	static class ParameterAppenderForCollection extends DefaultWrappedParameterAppender {
		@Override
		public void appendWrapped(StringBuilder builder, DataType dataType, List<DataType> parameters, ProgrammingLanguage language) {
			if (!CollectionUtils.isEmpty(parameters)) {
				builder.append("<");
				if (parameters.get(0).isCodedType()) {
					builder.append(parameters.get(0).getShortName(language));
					builder.append(", ");
					builder.append(Code.class.getSimpleName());
				} else {
					boolean first = true;
					for (DataType parameter : parameters) {
						if (!first) {
							builder.append(", ");
						}
						builder.append(ClassUtils.getShortClassName(parameter.getType().getHl7TypeName()));
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
					builder.append(parameter.getShortName(language));
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
	
	protected static List<String> flatten(List<DataType> parameters, ProgrammingLanguage language) {
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

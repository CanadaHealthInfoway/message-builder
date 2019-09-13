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
 * Author:        $LastChangedBy: jroberts $
 * Last modified: $LastChangedDate: 2014-07-10 12:26:14 -0400 (Thu, 10 Jul 2014) $
 * Revision:      $LastChangedRevision: 8803 $
 */

package ca.infoway.messagebuilder.generator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.generator.util.ProgrammingLanguage;

class ParameterAppenderRegistryR2 extends ParameterAppenderRegistry {
	
	public static ParameterAppenderRegistryR2 instance;
	
	private ParameterAppenderRegistryR2(Map<StandardDataType, ParameterAppender> appenders) {
		super(appenders);
	}

	public static ParameterAppenderRegistryR2 getInstance() {
		if (instance == null) {
			initialize();
		}
		return instance;
	}

	private static synchronized void initialize() {
		if (instance == null) {
			Map<StandardDataType, ParameterAppender> map = new HashMap<StandardDataType, ParameterAppender>();
			map.put(StandardDataType.LIST, new ParameterAppenderForListOrSetR2());
			map.put(StandardDataType.SET, new ParameterAppenderForListOrSetR2());
			map.put(StandardDataType.COLLECTION, new ParameterAppenderForCollection());
			map.put(StandardDataType.RTO, new ParameterAppenderForRto());
			map.put(StandardDataType.IVL, new ParameterAppenderForIvlR2());
			map.put(StandardDataType.ANY, new ParameterAppenderForAny());
			map.put(StandardDataType.PIVL, new ParameterAppenderForPivl());
			map.put(StandardDataType.ED, new ParameterAppenderForEd());
			map.put(StandardDataType.EN, new ParameterAppenderForEn());
			map.put(StandardDataType.URG, new ParameterAppenderForUrg());
			
			map.put(StandardDataType.CD, new ParameterAppenderForCodeR2());
			map.put(StandardDataType.CE, new ParameterAppenderForCodeR2());
			map.put(StandardDataType.CV, new ParameterAppenderForCodeR2());
			map.put(StandardDataType.CS, new ParameterAppenderForCodeR2());
			map.put(StandardDataType.CO, new ParameterAppenderForCodeR2());
			map.put(StandardDataType.SC, new ParameterAppenderForCodeR2());
			map.put(StandardDataType.PQR, new ParameterAppenderForCodeR2());

			map.put(StandardDataType.BXIT, new ParameterAppenderForBxitHxit());
			map.put(StandardDataType.EIVL, new ParameterAppenderForEivl());
			map.put(StandardDataType.HXIT, new ParameterAppenderForBxitHxit());
			map.put(StandardDataType.SXCM, new ParameterAppenderForSxcm());
			
			instance = new ParameterAppenderRegistryR2(map);
		}
	}
	
	static class ParameterAppenderForListOrSetR2 extends DefaultWrappedParameterAppender {

		@Override
		public void appendWrapped(StringBuilder builder, DataType dataType, List<DataType> parameters, ProgrammingLanguage language) {
			if (!CollectionUtils.isEmpty(parameters)) {
				builder.append("<");
				List<String> flattenedParameters = flatten(parameters, language);
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

	static class ParameterAppenderForBxitHxit extends DefaultWrappedParameterAppender {
		@Override
		public void appendWrapped(StringBuilder builder, DataType dataType, List<DataType> parameters, ProgrammingLanguage language) {
			builder.append("<");
			dataType.appendParameters(builder, language);
			builder.append(">");
		}
		
		@Override
		public void append(StringBuilder builder, DataType dataType, List<DataType> parameters, ProgrammingLanguage language) {
			String unparameterizedShortName = dataType.getUnparameterizedShortName(language);
			int lastIndexOf = builder.lastIndexOf(unparameterizedShortName);
			if (lastIndexOf >= 0) {
				builder.delete(lastIndexOf, builder.length());
			}

			builder.append("CodedTypeR2<");
			builder.append(parameters.get(0).getUnparameterizedShortName(language));
			builder.append(">");
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
	
	static class ParameterAppenderForIvlR2 extends ca.infoway.messagebuilder.generator.ParameterAppenderRegistry.ParameterAppenderForIvl {
		@Override
		public void append(StringBuilder builder, DataType dataType, List<DataType> parameters, ProgrammingLanguage language) {
			if (isIvlTs(dataType)) {
				// do nothing
			} else {
				super.append(builder, dataType, parameters, language);
			}
		}

		@Override
		public void appendWrapped(StringBuilder builder, DataType dataType,	List<DataType> parameters, ProgrammingLanguage language) {
			if (isIvlTs(dataType)) {
				// do nothing
			} else {
				super.appendWrapped(builder, dataType, parameters, language);
			}
		}
		
		private boolean isIvlTs(DataType dataType) {
			if (dataType != null && dataType.getType() != null) {
				return "IVL<TS>".equals(dataType.getType().getType());
			}
			return false;
		}
	}
	
	static class ParameterAppenderForEivl extends DefaultWrappedParameterAppender {
		@Override
		public void appendWrapped(StringBuilder builder, DataType dataType, List<DataType> parameters, ProgrammingLanguage language) {
			builder.append("<");
			builder.append(dataType.getUnparameterizedShortName(language));
			builder.append(">");
		}

		@Override
		public void append(StringBuilder builder, DataType dataType, List<DataType> parameters, ProgrammingLanguage language) {
		}
	}

	static class ParameterAppenderForSxcm extends DefaultWrappedParameterAppender {
		@Override
		public void appendWrapped(StringBuilder builder, DataType dataType, List<DataType> parameters, ProgrammingLanguage language) {
			if (dataType.isCodedType()) {
				builder.append("<");
				dataType.appendParameters(builder, language);
				builder.append(">");
			} else {
				builder.append("<");
				builder.append(dataType.getShortName(language));
				builder.append(">");
			}
		}
		
		@Override
		public void append(StringBuilder builder, DataType dataType, List<DataType> parameters, ProgrammingLanguage language) {
			if (dataType.isCodedType()) {
				String unparameterizedShortName = dataType.getUnparameterizedShortName(language);
				int lastIndexOf = builder.lastIndexOf(unparameterizedShortName);
				if (lastIndexOf >= 0) {
					builder.delete(lastIndexOf, builder.length());
				}

				builder.append("CodedTypeR2<");
				builder.append(parameters.get(0).getUnparameterizedShortName(language));
				builder.append(">");
			}
		}
	}
	
	static class ParameterAppenderForCodeR2 extends DefaultWrappedParameterAppender {
		@Override
		public void appendWrapped(StringBuilder builder, DataType dataType, List<DataType> parameters, ProgrammingLanguage language) {
			builder.append("<");
			builder.append(getTypeNameForDotNet(dataType, language));
			builder.append(">");
		}
		
		@Override
		public void append(StringBuilder builder, DataType dataType, List<DataType> parameters, ProgrammingLanguage language) {
			String unparameterizedShortName = dataType.getUnparameterizedShortName(language);
			int lastIndexOf = builder.lastIndexOf(unparameterizedShortName);
			builder.delete(lastIndexOf, builder.length());
			builder.append("CodedTypeR2<");
			builder.append(getTypeNameForDotNet(dataType, language));
			builder.append(">");
		}
		
		private String getTypeNameForDotNet(DataType dataType, ProgrammingLanguage language) {
			//Workaround name collisions in .NET. Note the programming language passed in is sometime hard-coded to JAVA so it cannot be relied on.
			//For Java, this will always return the unparameterized short name
			boolean isDomainValueDataType = dataType.getTypeName().indexOf("Domainvalue") >= 0;
			return isDomainValueDataType ? dataType.getTypeName() : dataType.getUnparameterizedShortName(language);
		}
	}
}

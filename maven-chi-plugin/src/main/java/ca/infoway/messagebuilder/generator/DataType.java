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

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.ClassUtils;

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.generator.util.ProgrammingLanguage;
import ca.infoway.messagebuilder.xml.Hl7TypeName;

public class DataType {

	private final String qualifier;
	private final DataType[] parameters;
	private final DataTypeGenerationDetails type;
	
	private final ParameterAppenderRegistry parameterAppenderRegistry;
	private final boolean isR2; 

	DataType(DataTypeGenerationDetails type, String qualifier, boolean isR2, DataType... parameters) {
		this.qualifier = qualifier;
		this.isR2 = isR2;
		if (DataTypeGenerationDetails.IVL_TS_R2 == type) {
			this.parameters = new DataType[0];
		} else {
			this.parameters = parameters;
		}
		this.type = type;
		this.parameterAppenderRegistry = new ParameterAppenderRegistryFactory().create(isR2);
	}
	
	public boolean isR2() {
		return isR2;
	}

	DataType(DataTypeGenerationDetails type, String typeName, boolean isR2, List<DataType> parameters) {
		this(type, typeName, isR2, parameters == null ? new DataType[0] : parameters.toArray(new DataType[parameters.size()]));
	}
	
	public String getShortName(ProgrammingLanguage language) {
		StringBuilder builder = new StringBuilder();
		getShortName(builder, language);
		return builder.toString();
	}

	void getShortName(StringBuilder builder, ProgrammingLanguage language) {
		builder.append(getUnparameterizedShortName(language));
		appendParameters(builder, language);
	}

	public void appendParameters(StringBuilder builder, ProgrammingLanguage language) {
		getWrappedParameterAppender().append(builder, this, Arrays.asList(this.parameters), language);
	}
	
	public String getUnparameterizedShortName(ProgrammingLanguage language) {
		if (this.type.isCoded()) {
			return ClassUtils.getShortClassName(this.qualifier);
		} else {
			return ClassUtils.getShortClassName(this.type.getLanguageSpecificTypeName(language));
		}
	}

	public String getUnparameterizedShortWrappedName() {
		return ClassUtils.getShortClassName(this.type.getHl7TypeName());
	}
	
	public String getTypeParameters(ProgrammingLanguage language) {
		StringBuilder builder = new StringBuilder();
		appendParameters(builder, language);
		return builder.toString();
	}

	public String getCollectionParameterWrappedTypeImpl() {
		String collectionWrappedParameter = "Object";
		if (this.parameters.length>0) {
			collectionWrappedParameter = this.parameters[0].getUnparameterizedShortWrappedNameImpl();
		}
		return collectionWrappedParameter;
	}

	/**
	 * @return <b>true</b> if the underlying HL7 type is a LIST or a SET. 
	 */
	public boolean isWrappedTypeListOrSet() {
		boolean isListOrSet = false;
		if (getShortWrappedName()!=null) {
			Hl7TypeName typeName = Hl7TypeName.parse(getShortWrappedName());
			isListOrSet = StandardDataType.isSetOrList(typeName!=null ? typeName.getRootName() : null) ;
		}
		return isListOrSet;
	}
	
	/**
	 * @return <b>true</b> if the underlying HL7 type is a LIST or a SET. 
	 */
	public boolean isWrappedTypeSet() {
		boolean isSet = false;
		if (getShortWrappedName()!=null) {
			Hl7TypeName typeName = Hl7TypeName.parse(getShortWrappedName());
			isSet = StandardDataType.isSet(typeName!=null ? typeName.getRootName() : null) ;
		}
		return isSet;
	}
	
	/**
	 * @return <b>true</b> if the java type used to represent this data type is a collection.
	 */
	public boolean isTypeCollection() {
		return "Set".equals(getUnparameterizedShortName(ProgrammingLanguage.JAVA)) ||
			"List".equals(getUnparameterizedShortName(ProgrammingLanguage.JAVA)) ||
			"Collection".equals(getUnparameterizedShortName(ProgrammingLanguage.JAVA));
	}

	private boolean isTypeNotRequiringUnparameterizedImplTypeImports() {
		String rootType = this.type.getRootType();
		return "IVL".equals(rootType) || "URG".equals(rootType) || "RTO".equals(rootType) || "PIVL".equals(rootType);
	}
	
	public Set<String> getImportTypes() {
		return getImportTypes(true);
	}
	
	private Set<String> getImportTypes(boolean addUnparameterizedImplType) {
		Set<String> result = new HashSet<String>();
		result.add(this.qualifier);
		addWrappedTypeIfNecessary(result, addUnparameterizedImplType);
		for (DataType dataType : this.parameters) {
			result.addAll(dataType.getImportTypes(!isTypeNotRequiringUnparameterizedImplTypeImports()));
		}
		return result;
	}
	private void addWrappedTypeIfNecessary(Set<String> result, boolean addUnparameterizedImplType) {
		if (getHl7ClassName() != null) {
			result.add(getHl7ClassName());
			if (addUnparameterizedImplType) {
				result.add(getUnparameterizedImplementationType());
			}
		}
	}

	public String getTypeName(ProgrammingLanguage language) {
		if (this.type.isCoded()) {
			return this.qualifier;
		} else {
			return this.type.getLanguageSpecificTypeName(language);
		}
	}
	public String getTypeName() {
		return this.qualifier;
	}

	public String getShortWrappedName() {
		return getShortWrappedName(ProgrammingLanguage.JAVA);
	}
	
	public String getShortWrappedName(ProgrammingLanguage language) {
		StringBuilder builder = new StringBuilder();
		getShortWrappedName(builder, language);
		return builder.toString();
	}

	public String getShortWrappedNameImpl(ProgrammingLanguage language) {
		StringBuilder builder = new StringBuilder();
		getShortWrappedNameImpl(builder, language);
		return builder.toString();
	}
	
	public String getShortWrappedNameImpl() {
		return getShortWrappedNameImpl(ProgrammingLanguage.JAVA);
	}

	public String getUnparameterizedShortWrappedNameImpl() {
		StringBuilder builder = new StringBuilder();
		getUnparameterizedShortImplementationType(builder);
		return builder.toString();
	}

	/**
	 * <p>Returns the name of the Java class that defines the interface for the 
	 * HL7 type.  Examples might include "ca.infoway.messagebuilder.datatype.ST".
	 * @return - the Java class name of the HL7 interface type
	 */
	public String getHl7ClassName() {
		return this.type.getHl7TypeName();
	}
	
	private void getShortWrappedName(StringBuilder builder, ProgrammingLanguage language) {
		builder.append(getUnparameterizedShortWrappedName());
		getWrappedParameterAppender().appendWrapped(builder, this, Arrays.asList(this.parameters), language);
	}
	private ParameterAppender getWrappedParameterAppender() {
		ParameterAppender appender = this.parameterAppenderRegistry.getAppender(StandardDataType.getByTypeName(getUnparameterizedShortWrappedName()));
		return appender;
	}
	
	private void getShortWrappedNameImpl(StringBuilder builder, ProgrammingLanguage language) {
		getUnparameterizedShortImplementationType(builder);
		getWrappedParameterAppender().appendWrapped(builder, this, Arrays.asList(this.parameters), language);
	}
	protected String getUnparameterizedImplementationType() {
		String packageName = ClassUtils.getPackageName(this.type.getHl7TypeName());
		String implementationPackageName = packageName + ".impl";
		
		return implementationPackageName + "." + getUnparameterizedShortImplementationType(null);
	}
	/**
	 * <p>Returns the type used for a field definition initializer.  Examples might
	 * include "STImpl", "LISTImpl" or ANYImpl".
	 * 
	 * @param builder
	 * @return 
	 */
	private String getUnparameterizedShortImplementationType(StringBuilder builder) {
		StringBuilder stringBuilder = new StringBuilder();
		if (isBasicCollection()) {
			stringBuilder.append(ClassUtils.getShortClassName(DataTypeGenerationDetails.LIST.getHl7TypeName()));
		} else {
			stringBuilder.append(getUnparameterizedShortWrappedName());
		}
		stringBuilder.append("Impl");
		
		String result = stringBuilder.toString();
		if (builder != null) {
			builder.append(result);
		}
		return result;
	}
	
	/**
	 * <p>BAG and COLLECTION types are not really supported by the pan-Canadian standards,
	 * and yet we've seen instances where we need to support them.  For all intents
	 * and purposes, we'll treat them like LISTs.
	 * @return
	 */
	private boolean isBasicCollection() {
		return this.type == DataTypeGenerationDetails.COLLECTION || 
			this.type == DataTypeGenerationDetails.BAG;
	}
	
	@Override
	public String toString() {
		return getShortWrappedName() + "/" + getShortName(ProgrammingLanguage.JAVA);
	}
	public DataTypeGenerationDetails getType() {
		return this.type;
	}
	public boolean isCodedType() {
		return getType().isCoded();
	}
	public DataType[] getParameters() {
		return this.parameters;
	}
	/**
	 * <p>Provide a parameterized version of the implementation type.  The result includes
	 * all generic parameters, but none of the classes are qualified with package names.
	 * 
	 * <p>Examples:
	 * 
	 * <p>The implementation type of a ST field is STImpl;
	 * 
	 * <p>The implementation type of a LIST&lt;II&gt; field is LISTImpl&lt;II, Identifier&gt;
	 * 
	 * @param language
	 * @return
	 */
	public String getParameterizedImplementationType(ProgrammingLanguage language) {
		StringBuilder builder = new StringBuilder();
		getUnparameterizedShortImplementationType(builder);
		ParameterAppender appender = getImplementationParameterAppender();
		appender.appendWrapped(builder, this, Arrays.asList(this.parameters), language);
		
		return builder.toString();
	}
	private ParameterAppender getImplementationParameterAppender() {
		if (isBasicCollection()) {
			return parameterAppenderRegistry.getAppender(StandardDataType.LIST);
		} else {
			return parameterAppenderRegistry.getAppender(StandardDataType.getByTypeName(getUnparameterizedShortWrappedName()));
		}
	}
}

package ca.infoway.messagebuilder.generator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.ClassUtils;

import ca.infoway.messagebuilder.datatype.Hl7TypeName;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;

public class DataType {

	private final String qualifier;
	private final DataType[] parameters;
	private final DataTypeGenerationDetails type;
	
	private final ParameterAppenderRegistry parameterAppenderRegistry = ParameterAppenderRegistry.getInstance(); 

	DataType(DataTypeGenerationDetails type, String qualifier, DataType... parameters) {
		this.qualifier = qualifier;
		this.parameters = parameters;
		this.type = type;
	}
	DataType(DataTypeGenerationDetails type, String typeName, List<DataType> parameters) {
		this(type, typeName, parameters == null ? new DataType[0] : parameters.toArray(new DataType[parameters.size()]));
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

	private void appendParameters(StringBuilder builder, ProgrammingLanguage language) {
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
	 * @return <b>true</b> if the underlaying HL7 type is a LIST or a SET. 
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
	 * @return <b>true</b> if the java type used to represent this data type is a collection.
	 */
	public boolean isTypeCollection() {
		return "Set".equals(getUnparameterizedShortName(ProgrammingLanguage.JAVA)) ||
			"List".equals(getUnparameterizedShortName(ProgrammingLanguage.JAVA)) ||
			"Collection".equals(getUnparameterizedShortName(ProgrammingLanguage.JAVA));
	}
	
	public Set<String> getImportTypes() {
		Set<String> result = new HashSet<String>();
		result.add(this.qualifier);
		addWrappedTypeIfNecessary(result);
		for (DataType dataType : this.parameters) {
			result.addAll(dataType.getImportTypes());
		}
		return result;
	}
	private void addWrappedTypeIfNecessary(Set<String> result) {
		if (getHl7ClassName() != null) {
			result.add(getHl7ClassName());
			result.add(getUnparameterizedImplementationType());
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
	 * <p>Returns the type used for a field definition initialier.  Examples might
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
	DataTypeGenerationDetails getType() {
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
		
		// TODO: BCH/TM: consider whether or not constructor arguments should be added here.
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

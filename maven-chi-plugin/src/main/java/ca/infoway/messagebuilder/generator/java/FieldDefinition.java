package ca.infoway.messagebuilder.generator.java;


interface FieldDefinition {
	
	boolean isWritable();
	String getFieldName();
	String getCapitalizedPropertyName();
	/** 
	 * <p>Get the field type.  The field type is used in internal field defintion. 
	 */
	String getFieldType();
	String getFieldImplementationType();
	/** 
	 * <p>Get the property type.  The property type is used in the public getter and setter. 
	 */
	String getPropertyType();
	/** 
	 * <p>Get the collection coded property element type.  The collection coded property element type is used in the body of the public getter and setter. 
	 */
	String getCollectionOfCodedPropertyElementType();
	
	String[] getXmlPathName();
	GetterBodyStyle getGetterBodyStyle();
	SetterBodyStyle getSetterBodyStyle();
	GetterBodyStyle getDerivedChoiceHasBodyStyle();
	String getInitializationArguments();
	/** 
	 * <p>Get the implementation type of individual field elements.  
	 * 
	 * <p>If the field is a collapsed relationship, then the field type is a list, and 
	 * this type is the implementation type of elements in the list.  If the field
	 * is not a collapsed relationship, the the field type and the field element type are
	 * the same thing.
	 */
	String getFieldElementImplementationType();
	
	/**
	 * <p>If the field is a collapsed relationship, then the field type is a list, and 
	 * this type is the type of elements in the list.  If the field
	 * is not a collapsed relationship, the the field type and the field element type are
	 * the same thing.	*/
	String getFieldElementType();
	
	/** 
	 * <p>Get the implementation type of individual field elements.  
	 * 
	 * <p>If the field is a collapsed relationship, then the field type is a list, and 
	 * this type is the implementation type of elements in the list.  If the field
	 * is not a collapsed relationship, the the field type and the field element type are
	 * the same thing.
	 */
	String getPropertyElementImplementationType();
	
	boolean isDerivedChoice();

	boolean isInitializedAtConstructionTime();
	
	void initializeContext(ClassNameManager manager, BaseRelationshipNameResolver resolver);
	void resetContext();
}

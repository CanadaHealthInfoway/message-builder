package ca.infoway.messagebuilder.datatype.impl;

import static org.junit.Assert.assertNotNull;

import java.text.MessageFormat;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * @sharpen.ignore - datatype - translated manually
 */
public class DataTypeImplementationFactoryTest {
	
	public static StandardDataType[] DATA_TYPES = EnumPattern.values(StandardDataType.class).toArray(new StandardDataType[0]); 
	
	@Test
	public void makeSureDataTypeHasAnImplemenation() throws Exception {
		for (StandardDataType type : DATA_TYPES) {
			if (type != StandardDataType.COLLECTION && type != StandardDataType.BAG) {
				assertNotNull(MessageFormat.format("no implementation for: {0}", 
						type.getType()), 
						DataTypeImplementationFactory.getImplementation(type.getType()));
			}
		}
	}

}

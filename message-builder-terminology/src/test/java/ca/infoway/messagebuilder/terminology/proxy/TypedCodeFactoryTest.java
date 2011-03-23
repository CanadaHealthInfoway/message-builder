package ca.infoway.messagebuilder.terminology.proxy;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.Test;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.AcknowledgementDetailType;
import ca.infoway.messagebuilder.domainvalue.ActIssuePriority;


public class TypedCodeFactoryTest {

	@Test
	public void shouldProduceResultThatImplementsAllInterfaces() throws Exception {
		
		Code code = new TypedCodeFactory().create(AcknowledgementDetailType.class, 
				new HashSet<Class<?>>(Arrays.asList(
						AcknowledgementDetailType.class, ActIssuePriority.class)),
				"E", CodeSystem.VOCABULARY_ACKNOWLEDGEMENT_DETAIL_TYPE.getRoot(), 
				new HashMap<String,String>(), 0, true, true);
		
		assertTrue("AcknowledgementDetailType", code instanceof AcknowledgementDetailType);
		assertTrue("ActIssuePriority", code instanceof ActIssuePriority);
	}
}

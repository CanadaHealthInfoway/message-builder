package ca.infoway.messagebuilder.marshalling;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.Relationship;


public class BeanWrapperTest {

	@Test
	public void shouldWriteSimpleAttribute() throws Exception {
		BeanB beanB = new BeanB();
		BeanWrapper wrapper = new BeanWrapper(beanB);
		wrapper.write(new Relationship("text", "ST", Cardinality.create("0-1")), "This is my text");
		assertEquals("text", "This is my text", beanB.getText());
	}
	
	@Test
	public void shouldWriteSimpleAssociation() throws Exception {
		BeanB beanB = new BeanB();
		BeanC beanC = new BeanC();
		BeanWrapper wrapper = new BeanWrapper(beanC);
		wrapper.write(new Relationship("textHolder", "ABCD_IN123456CA.BeanB", Cardinality.create("0-1")), beanB);
		assertNotNull("bean b", beanC.getBeanB());
	}
	
	@Test
	public void shouldWriteMultipleCardinalityAttribute() throws Exception {
		BeanBPrime beanB = new BeanBPrime();
		BeanWrapper wrapper = new BeanWrapper(beanB);
		wrapper.write(new Relationship("text", "ST", Cardinality.create("0-10")), "This is my text");
		assertEquals("text", "This is my text", beanB.getText().get(0));
	}
}

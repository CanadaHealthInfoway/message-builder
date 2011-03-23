package ca.infoway.messagebuilder.simple.xml.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.datatype.RTO;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterContextImpl;
import ca.infoway.messagebuilder.simple.xml.FormatterException;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

public class RatioDrugQuantityPerTimeXmlFormatterTest {

	private final String ns = " xmlns=\"" + AbstractSimpleXmlFormatter.NAMESPACE + "\"";
	
	@Before
	public void initialize() {
		CodeResolverRegistry.register(new TrivialCodeResolver());
	}
	
	@Test
	public void shouldTransformXmlToPhysicalQuantity() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<drugOverTime"+this.ns+"><drugQuantity unit=\"ml\" value=\"5.3\" /><time unit=\"days\" value=\"10\" /></drugOverTime>");
	
		RatioDrugQuantityPerTimeXmlFormatter formatter = new RatioDrugQuantityPerTimeXmlFormatter(new FormatterConfiguration());
		
		RTO<PhysicalQuantity, PhysicalQuantity> rto = formatter.format(new FormatterContextImpl(StandardDataType.RTO_PQ_DRUG_PQ_TIME, null), document.getDocumentElement());
		assertNotNull("rto", rto);
		Assert.assertEquals(new BigDecimal("5.3"), rto.getValue().getNumerator().getQuantity());
		Assert.assertEquals("ml", rto.getValue().getNumerator().getUnit().getCodeValue());
		Assert.assertEquals(new BigDecimal("10"), rto.getValue().getDenominator().getQuantity());
		Assert.assertEquals("days", rto.getValue().getDenominator().getUnit().getCodeValue());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfDrugQuantityIsMissing() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<drugOverTime"+this.ns+"><time unit=\"days\" value=\"10\" /></drugOverTime>");
		RatioDrugQuantityPerTimeXmlFormatter formatter = new RatioDrugQuantityPerTimeXmlFormatter(new FormatterConfiguration());
		formatter.format(new FormatterContextImpl(StandardDataType.RTO_PQ_DRUG_PQ_TIME, null), document.getDocumentElement());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfDrugQuantityIsEmpty() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<drugOverTime"+this.ns+"><drugQuantity/><time unit=\"days\" value=\"10\" /></drugOverTime>");
		RatioDrugQuantityPerTimeXmlFormatter formatter = new RatioDrugQuantityPerTimeXmlFormatter(new FormatterConfiguration());
		formatter.format(new FormatterContextImpl(StandardDataType.RTO_PQ_DRUG_PQ_TIME, null), document.getDocumentElement());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfTimeIsMissing() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<drugOverTime"+this.ns+"><drugQuantity unit=\"ml\" value=\"5.3\" /></drugOverTime>");
		RatioDrugQuantityPerTimeXmlFormatter formatter = new RatioDrugQuantityPerTimeXmlFormatter(new FormatterConfiguration());
		formatter.format(new FormatterContextImpl(StandardDataType.RTO_PQ_DRUG_PQ_TIME, null), document.getDocumentElement());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfTimeIsEmpty() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<drugOverTime"+this.ns+"><drugQuantity unit=\"ml\" value=\"5.3\" /><time/></drugOverTime>");
		RatioDrugQuantityPerTimeXmlFormatter formatter = new RatioDrugQuantityPerTimeXmlFormatter(new FormatterConfiguration());
		formatter.format(new FormatterContextImpl(StandardDataType.RTO_PQ_DRUG_PQ_TIME, null), document.getDocumentElement());
	}
	
	@Test
	public void shouldAllowInvalidRatioIfConfigurationIsPermissive() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<drugOverTime"+this.ns+"><drugQuantity unit=\"ml\" value=\"5.3\" /></drugOverTime>");
		
		RatioDrugQuantityPerTimeXmlFormatter formatter = new RatioDrugQuantityPerTimeXmlFormatter(new FormatterConfiguration(true));
		
		FormatterContextImpl formatContext = new FormatterContextImpl(StandardDataType.RTO_PQ_DRUG_PQ_TIME, null);
		RTO<PhysicalQuantity, PhysicalQuantity> rto = formatter.format(formatContext, document.getDocumentElement());

		assertNull("rto", rto);
		assertEquals(1, formatContext.getErrors().size());
		assertEquals("Invalid ratio format. Both drugQuantity and time are required.", formatContext.getErrors().get(0).getMessage());
	}
	
}

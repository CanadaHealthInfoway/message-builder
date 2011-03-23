package ca.infoway.messagebuilder.marshalling.datatypeadapter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;

/**
 * @sharpen.ignore data type adapter
 */
public class TsToIvlAdapterTest {

	private TsToIvlAdapter adapter;
	
	@Before
	public void setUp() {
		this.adapter = new TsToIvlAdapter();
		CodeResolverRegistry.register(new TrivialCodeResolver());
	}
	
	@Test
	public void shouldMatch() throws Exception {
		assertTrue("FULL_DATE_IVL", this.adapter.canAdapt(TS.class, StandardDataType.IVL_FULL_DATE.getType()));
		assertTrue("IVL_FULL_DATE_WITH_TIME", this.adapter.canAdapt(TS.class, StandardDataType.IVL_FULL_DATE_WITH_TIME.getType()));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldAdaptCorrectly() throws Exception {
		TSImpl ts = new TSImpl(new Date());
		BareANY adapted = this.adapter.adapt(ts);
		assertTrue(adapted instanceof IVL);
		assertEquals("low", ((IVL<TS, Interval<Date>>) adapted).getValue().getLow(), ts.getValue());
	}
	
}

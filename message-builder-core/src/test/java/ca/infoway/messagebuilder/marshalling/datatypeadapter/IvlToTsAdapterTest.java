package ca.infoway.messagebuilder.marshalling.datatypeadapter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;

/**
 * @sharpen.ignore data type adapter
 */
public class IvlToTsAdapterTest {

	private IvlToTsAdapter adapter;
	
	@Before
	public void setUp() {
		this.adapter = new IvlToTsAdapter();
		CodeResolverRegistry.register(new TrivialCodeResolver());
	}
	
	@Test
	public void shouldMatch() throws Exception {
		assertTrue("FULL_DATE_IVL", this.adapter.canAdapt(StandardDataType.IVL_FULL_DATE.getType(), TS.class));
		assertTrue("IVL_FULL_DATE_WITH_TIME", this.adapter.canAdapt(StandardDataType.IVL_FULL_DATE_WITH_TIME.getType(), TS.class));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldAdaptCorrectly() throws Exception {
		IVLImpl<TS, Interval<Date>> ivl = new IVLImpl<TS, Interval<Date>>(IntervalFactory.<Date>createLow(new Date()));
		BareANY adapted = this.adapter.adapt(ivl);
		assertTrue(adapted instanceof TS);
		assertEquals("low", ((TS) adapted).getValue(), ivl.getValue().getLow());
	}
	
}

package ca.infoway.messagebuilder.generator.dotnet;

import static org.junit.Assert.assertEquals;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.generator.java.NameTranslator;
import ca.infoway.messagebuilder.xml.TypeName;


@RunWith(JMock.class)
public class CsharpPackageNameAdjustingDecoratorTest {

	private Mockery jmock = new Mockery();
	
	@Test
	public void shouldCapitalizePackageName() throws Exception {
		
		final NameTranslator translator = this.jmock.mock(NameTranslator.class);
		this.jmock.checking(new Expectations() {{
			allowing(translator).getPackageName(with(any(TypeName.class))); will(returnValue("ca.infoway.messagebuilder.something"));
		}});
		
		CsharpPackageNameAdjustingDecorator fixture = new CsharpPackageNameAdjustingDecorator(translator);
		assertEquals("package name", "Ca.Infoway.Messagebuilder.Something", fixture.getPackageName(new TypeName("")));
	}
	
}

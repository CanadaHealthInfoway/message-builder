package ca.infoway.messagebuilder.maven.util;

import org.apache.maven.plugin.Mojo;
import org.apache.maven.plugin.logging.Log;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.generator.LogLevel;
import ca.infoway.messagebuilder.maven.util.OutputUIImpl;

@RunWith(JMock.class)
public class OutputUIImplTest {
	
	private Mockery jmock = new Mockery();
	private Mojo mojo = this.jmock.mock(Mojo.class);
	private Log log = this.jmock.mock(Log.class);
	private OutputUIImpl ui;
	
	@Before
	public void setUp() throws Exception {
		this.ui = new OutputUIImpl(this.mojo);
		this.jmock.checking(new Expectations() {{
			one(mojo).getLog(); will(returnValue(log));
		}});
	}
	
	@Test
	public void shouldLogDebug() throws Exception {
		this.jmock.checking(new Expectations() {{
			one(log).debug(with(any(String.class)));
		}});
		this.ui.log(LogLevel.DEBUG, "I am a very interesting message");
	}
	
	@Test
	public void shouldLogInfo() throws Exception {
		this.jmock.checking(new Expectations() {{
			one(log).info(with(any(String.class)));
		}});
		this.ui.log(LogLevel.INFO, "I am a very interesting message");
	}
	@Test
	public void shouldLogWithNoValue() throws Exception {
		this.jmock.checking(new Expectations() {{
			one(log).info(with(any(String.class)));
		}});
		this.ui.log(null, "I am a very interesting message");
	}
	@Test
	public void shouldLogWarn() throws Exception {
		this.jmock.checking(new Expectations() {{
			one(log).warn(with(any(String.class)));
		}});
		this.ui.log(LogLevel.WARN, "I am a very scary message");
	}
	@Test
	public void shouldLogError() throws Exception {
		this.jmock.checking(new Expectations() {{
			one(log).error(with(any(String.class)));
		}});
		this.ui.log(LogLevel.ERROR, "I am a very scary message");
	}
	@Test
	public void shouldLogSevere() throws Exception {
		this.jmock.checking(new Expectations() {{
			one(log).error(with(any(String.class)));
		}});
		this.ui.log(LogLevel.SEVERE, "I am a very scary message");
	}
}

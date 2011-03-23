package ca.infoway.messagebuilder.generator.maven;

import java.io.File;

import org.apache.maven.plugin.MojoFailureException;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class XmlToJavaGeneratorMojoTest {

	@DataPoint public static final File EMPTY = null;
	@DataPoint public static final File DIRECTORY = new File("./src/");
	@DataPoint public static final File NOT_EXISTS = new File("unicorns");
	
	private XmlToJavaGeneratorMojo mojo;

	@Before
	public void setUp() {
		this.mojo = new XmlToJavaGeneratorMojo();
	}
	
	@Test(expected=MojoFailureException.class) @Theory(nullsAccepted=true)
	public void shouldThrowExceptionIfInputFileIsInvalid(File file) throws Exception {
		this.mojo.setMessageSet(file);
		this.mojo.execute();
	}
}

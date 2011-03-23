package ca.infoway.messagebuilder.util.telephone;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * @sharpen.ignore - test - translated manually.
 */
public class TelephoneParserTest {

	private TelephoneParser parser;

	@Before
	public void setUp() throws Exception {
		this.parser = new TelephoneParser();
	}
	
	@Test
	public void shouldParse() throws Exception {
		assertParsable("7620032");
		assertParsable("4167896541");
		assertNotParsable("41696325874");
		assertNotParsable("1-416");
		assertParsable("1-762-0032");  // really?
		assertParsable("+1-416-762-0032 ext: 242");
		assertParsable("+1-416-762-0032;ext=242");
		assertParsable("+1-416-762-0032 x 242");
		assertParsable("+1-416-762-0032");
		assertParsable("1-416-762-0032");
		assertParsable("1-416-7620032");
		assertNotParsable("(762) 0032");
		assertParsable("762-0032");
		assertNotParsable("1-800-MYPIZZA");
		assertParsable("416-762-0032");
		assertParsable("(416)985-2364");
		assertParsable("(416) 985-2364");
		assertParsable("416 985-2364");
		assertParsable("7620032x242");
	}

	private void assertNotParsable(String number) {
		Telephone telephone = this.parser.createTelephone(number);
		assertNull(number, telephone);
	}

	private void assertParsable(String number) {
		Telephone telephone = this.parser.createTelephone(number);
		assertNotNull(number, telephone);
		assertFalse(number, StringUtils.isBlank(telephone.getHl7FormattedPhoneNumber()));
	}
}

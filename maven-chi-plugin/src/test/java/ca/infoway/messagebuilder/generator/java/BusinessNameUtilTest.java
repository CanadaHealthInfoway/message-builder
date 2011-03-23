package ca.infoway.messagebuilder.generator.java;

import static org.junit.Assert.assertEquals;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;


@RunWith(Theories.class)
public class BusinessNameUtilTest {

	@DataPoint public static final String[] CASE1 = {"Service %Location", "ServiceLocation"};
	@DataPoint public static final String[] CASE2 = {"*b1:recorded at", "RecordedAt"};
	@DataPoint public static final String[] CASE3 = {"b1:recorded at?", "RecordedAt"};
	@DataPoint public static final String[] CASE4 = {"policy/account code", "PolicyAccountCode"};
	@DataPoint public static final String[] CASE5 = {"*annotated by", "AnnotatedBy"};
	@DataPoint public static final String[] CASE6 = {"*g:occurred at ", "OccurredAt"};
	@DataPoint public static final String[] CASE7 = {"*g:occurred at\u00A0", "OccurredAt"};
	@DataPoint public static final String[] CASE8 = {"*g:occurred at\u2007", "OccurredAt"};
	@DataPoint public static final String[] CASE9 = {"*g:occurred at\u202F", "OccurredAt"};
	@DataPoint public static final String[] CASE10 ={"\u00A0*g:occurred at", "OccurredAt"};
	@DataPoint public static final String[] CASE11 ={"*g:occurred\u00A0at", "OccurredAt"};
	
	@Theory
	public void shouldCleanUpBusinessName(String[] testCase) throws Exception {
		assertEquals(testCase[1], BusinessNameUtil.cleanUpBusinessName(testCase[0]));
	}	
}

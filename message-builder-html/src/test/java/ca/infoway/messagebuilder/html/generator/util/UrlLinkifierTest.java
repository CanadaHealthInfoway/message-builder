/**
 * Copyright 2013 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */
package ca.infoway.messagebuilder.html.generator.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UrlLinkifierTest {

	@Test
	public void shouldPassThroughPlainText() {
		String input = "This sentence does not contain a raw URL.";
		
		assertEquals(input, UrlLinkifier.linkify(input));
	}
	
	@Test
	public void shouldLinkifySimpleUrls() {
		String input = "This sentence contains http://simple.com/sample/url a raw URL.";
		String expected = "This sentence contains <a href=\"http://simple.com/sample/url\" target=\"_blank\">http://simple.com/sample/url</a> a raw URL.";
		
		assertEquals(expected, UrlLinkifier.linkify(input));
	}
	
	@Test
	public void shouldLinkifyMultipleUrls() {
		String input = "This sentence contains https://simple.com/sample/url two http://www.another.net/different/page?id=1 URLs.";
		String expected = "This sentence contains <a href=\"https://simple.com/sample/url\" target=\"_blank\">https://simple.com/sample/url</a> two <a href=\"http://www.another.net/different/page?id=1\" target=\"_blank\">http://www.another.net/different/page?id=1</a> URLs.";
		
		assertEquals(expected, UrlLinkifier.linkify(input));
	}
	
	@Test
	public void shouldLinkifyEmailAddresses() {
		// Note: example provided by Tib to specify what the algorithm should handle
		String input = "Here it is: tib@infoway.com. Another one: abc-def.something.new@something-else.co.uk\n\nAnd finally@\n\nyet another one: standards@infoway-inforoute.ca";
		String expected = "Here it is: <a href=\"mailto:tib@infoway.com\">tib@infoway.com</a>. Another one: <a href=\"mailto:abc-def.something.new@something-else.co.uk\">abc-def.something.new@something-else.co.uk</a>\n\nAnd finally@\n\nyet another one: <a href=\"mailto:standards@infoway-inforoute.ca\">standards@infoway-inforoute.ca</a>";
		
		assertEquals(expected, UrlLinkifier.linkify(input));
	}
	
	@Test
	public void shouldLinkifyAnExampleFromRealCode() {
		String input = "The filter provided for this value set requires review.  Please contact the SC Infodesk (standards@infoway-inforoute.ca) for assistance with this value set.  New Implementers are encouraged to use the subset ReferralServiceCode available here https://infocentral.infoway-inforoute.ca/2_Standards/1_pan-Canadian_Standards/Terminology/4_SNOMED_CT_Terminologies/PHC_Reference_Sets_-_Current_Release_(Grouped)/PHC_Reference_Sets_-_Current_Release_(Individual)";
		String expected = "The filter provided for this value set requires review.  Please contact the SC Infodesk (<a href=\"mailto:standards@infoway-inforoute.ca\">standards@infoway-inforoute.ca</a>) for assistance with this value set.  New Implementers are encouraged to use the subset ReferralServiceCode available here <a href=\"https://infocentral.infoway-inforoute.ca/2_Standards/1_pan-Canadian_Standards/Terminology/4_SNOMED_CT_Terminologies/PHC_Reference_Sets_-_Current_Release_(Grouped)/PHC_Reference_Sets_-_Current_Release_(Individual)\" target=\"_blank\">https://infocentral.infoway-inforoute.ca/2_Standards/1_pan-Canadian_Standards/Terminology/4_SNOMED_CT_Terminologies/PHC_Reference_Sets_-_Current_Release_(Grouped)/PHC_Reference_Sets_-_Current_Release_(Individual)</a>";
		
		assertEquals(expected, UrlLinkifier.linkify(input));
	}
	
	@Test
	public void shouldNotLinkifyNonUrlText() {
		String input = "This sentence contains:something that looks like a raw URL.";
		
		assertEquals(input, UrlLinkifier.linkify(input));
	}
}

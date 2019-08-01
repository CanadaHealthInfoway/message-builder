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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.mifcomparer.xmlunit;

import java.util.List;

import org.custommonkey.xmlunit.DetailedDiff;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.Difference;
import org.custommonkey.xmlunit.NodeDetail;
import org.custommonkey.xmlunit.XMLUnit;
import org.w3c.dom.Document;



/**
 * A thin wrapper around XmlUnit, which:<ul>
 *		<li>configures it the way we need
 *		<li>saves and restores its (unfortunately, global) state
 *		<li>abstracts this stuff out, so that it can be used in test cases
 * </ul>
 */
public class XmlunitAdapter {
	/**
	 * Compare two {@link org.w3c.dom.Document} instances, using XmlUnit.
	 *
	 * @param	leftDOM		The first Document to be compared
	 * @param	rightDOM	The second Document to be compared
	 *
	 * @return	an {@link XmlunitResult} instance that describes the results of the comparison
	 */
	public XmlunitResult compare(Document leftDOM, Document rightDOM) {
		boolean isIdentical;
		boolean isSimilar;
		List<Difference> diffs;
		
		XmlunitState.save();
		try {
			XMLUnit.setIgnoreWhitespace(true);
			XMLUnit.setCompareUnmatched(false);
			XMLUnit.setIgnoreComments(true);
			DetailedDiff dd = new DetailedDiff(new Diff(leftDOM, rightDOM));
		
			isIdentical = dd.identical();
			isSimilar = dd.similar();
		
			@SuppressWarnings("unchecked")							// Stupid dance because @SuppressWarnings can't be applied
			List<Difference> t_diffs = dd.getAllDifferences();		// to a simple assignment
			diffs = t_diffs;
			
		} finally {
			XmlunitState.restore();
		}
		
		return new XmlunitResult(isIdentical, isSimilar, diffs);
	}
}

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
import org.custommonkey.xmlunit.Difference;

/**
 * Value object that describes the results of an XmlUnit comparison of two XML DOMs.
 */
public class XmlunitResult {
	private boolean isIdentical;
	private boolean isSimilar;
	private List<Difference> differences;
	
	public XmlunitResult(boolean isIdentical, boolean isSimilar, List<Difference> differences) {
			this.isIdentical = isIdentical;
			this.isSimilar = isSimilar;
			this.differences = differences;
	}
	
	/**
	 * @see DetailedDiff#identical()
	 */
	public boolean isIdentical() {
		return isIdentical;
	}
	
	/**
	 * @see DetailedDiff#similar()
	 */
	public boolean isSimilar() {
		return isSimilar;
	}
	
	/**
	 * List of {@link org.custommonkey.xmlunit.Difference}s returned by XmlUnit
	 */
	public List<Difference> getDifferences() {
		return differences;
	}

}

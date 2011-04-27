/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.xml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * <p>A class that models the differences noted during regen.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
@Root
@Namespace(prefix="regen",reference="regen_ns")
public class Difference {

	@Attribute
	private DifferenceType type;
	@Attribute(required=false)
	private DifferenceMatch matchConfidence;
	@Attribute(name="isOk",required=false)
	private boolean ok;
	@ElementList(inline=true, required=false)
	private List<DifferenceValue> differences = new ArrayList<DifferenceValue>();
	
	public Difference() {
	}
	
	public Difference(DifferenceType differenceType, boolean ok, DifferenceValue... values) {
		this.type = differenceType;
		this.ok = ok;
		this.differences.addAll(Arrays.asList(values));
	}
	
	/**
	 * A field indicating what kind of difference is being reported.
	 * 
	 * @return the  type of this difference
	 */
	public DifferenceType getType() {
		return this.type;
	}
	public void setType(DifferenceType type) {
		this.type = type;
	}
	
	public DifferenceMatch getMatchConfidence() {
		return this.matchConfidence;
	}
	public void setMatchConfidence(DifferenceMatch matchConfidence) {
		this.matchConfidence = matchConfidence;
	}
	
	public List<DifferenceValue> getDifferences() {
		return this.differences;
	}
	public void setDifferences(List<DifferenceValue> differences) {
		this.differences = differences;
	}
	
	public boolean isOk() {
		return this.ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}

}

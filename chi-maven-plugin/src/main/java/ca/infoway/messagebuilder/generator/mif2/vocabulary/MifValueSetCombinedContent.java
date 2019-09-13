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
 * Last modified: $LastChangedDate: 2012-03-06 13:41:31 -0500 (Tue, 06 Mar 2012) $
 * Revision:      $LastChangedRevision: 5770 $
 */
package ca.infoway.messagebuilder.generator.mif2.vocabulary;

import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(strict=false)
@Namespace(prefix="mif",reference="urn:hl7-org:v3/mif2")
public class MifValueSetCombinedContent {

	@ElementList(required=false,inline=true,entry="unionWithContent")
	private List<MifValueSetContent> unions;
	@ElementList(required=false,inline=true,entry="intersectionWithContent")
	private List<MifValueSetContent> intersections;
	@ElementList(required=false,inline=true,entry="excludeContent")
	private List<MifValueSetContent> exclusions;

	public List<MifValueSetContent> getUnions() {
		return unions;
	}

	public void setUnions(List<MifValueSetContent> unions) {
		this.unions = unions;
	}

	public List<MifValueSetContent> getIntersections() {
		return intersections;
	}

	public void setIntersections(List<MifValueSetContent> intersections) {
		this.intersections = intersections;
	}

	public List<MifValueSetContent> getExclusions() {
		return exclusions;
	}

	public void setExclusions(List<MifValueSetContent> exclusions) {
		this.exclusions = exclusions;
	}

}

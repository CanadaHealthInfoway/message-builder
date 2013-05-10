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
package ca.infoway.messagebuilder.datatype.mif;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class MifHeader {
	
	@ElementList(entry="contributor",required=false,inline=true)
	private List<MifContributor> contributors = new ArrayList<MifContributor>();
	
	@Element(required=false)
	private MifApprovalInfo approvalInfo;

	public List<MifContributor> getContributors() {
		return contributors;
	}
	public void setContributors(List<MifContributor> contributors) {
		this.contributors = contributors;
	}

	public MifApprovalInfo getApprovalInfo() {
		return approvalInfo;
	}
	public void setApprovalInfo(MifApprovalInfo approvalInfo) {
		this.approvalInfo = approvalInfo;
	}
}
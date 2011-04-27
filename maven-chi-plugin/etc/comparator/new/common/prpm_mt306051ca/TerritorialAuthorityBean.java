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

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.prpm_mt306051ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.PlaceEntityType;
import ca.infoway.messagebuilder.domainvalue.RoleCode;
import ca.infoway.messagebuilder.domainvalue.RoleLinkType;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Territorial Authority 
 * 
 * <p>RoleClass necessary to support the Jurisdiction within 
 * which the scoping organization exists 
 * 
 * <p>Supports business requirement to provide additional 
 * information regarding the jurisdication within the scoping 
 * organization exists. 
 */
@Hl7PartTypeMapping({"PRPM_MT306051CA.TerritorialAuthority"})
public class TerritorialAuthorityBean extends MessagePartBean {

    private CV<RoleCode> territorialAuthorityType = new CVImpl<RoleCode>();
    private CS<RoleLinkType> partTypeCode = new CSImpl<RoleLinkType>();
    private TerritorialAuthorityBean partTerritorialAuthority;
    private CV<PlaceEntityType> jurisdictionType = new CVImpl<PlaceEntityType>();

    @Hl7XmlMapping({"code"})
    public RoleCode getTerritorialAuthorityType() {
        return this.territorialAuthorityType.getValue();
    }
    public void setTerritorialAuthorityType(RoleCode territorialAuthorityType) {
        this.territorialAuthorityType.setValue(territorialAuthorityType);
    }

    @Hl7XmlMapping({"part/typeCode"})
    public RoleLinkType getPartTypeCode() {
        return this.partTypeCode.getValue();
    }
    public void setPartTypeCode(RoleLinkType partTypeCode) {
        this.partTypeCode.setValue(partTypeCode);
    }

    @Hl7XmlMapping({"part/territorialAuthority"})
    public TerritorialAuthorityBean getPartTerritorialAuthority() {
        return this.partTerritorialAuthority;
    }
    public void setPartTerritorialAuthority(TerritorialAuthorityBean partTerritorialAuthority) {
        this.partTerritorialAuthority = partTerritorialAuthority;
    }

    @Hl7XmlMapping({"territory/code"})
    public PlaceEntityType getJurisdictionType() {
        return this.jurisdictionType.getValue();
    }
    public void setJurisdictionType(PlaceEntityType jurisdictionType) {
        this.jurisdictionType.setValue(jurisdictionType);
    }

}

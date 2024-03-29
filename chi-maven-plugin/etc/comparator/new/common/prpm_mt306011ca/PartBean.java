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

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.prpm_mt306011ca;

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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



@Hl7PartTypeMapping({"PRPM_MT306011CA.Part"})
public class PartBean extends MessagePartBean {

    private CS<RoleLinkType> typeCode = new CSImpl<RoleLinkType>();
    private CV<RoleCode> territorialAuthorityType = new CVImpl<RoleCode>();
    private List<PartBean> territorialAuthorityPart = new ArrayList<PartBean>();
    private CV<PlaceEntityType> jurisdictionType = new CVImpl<PlaceEntityType>();

    @Hl7XmlMapping({"typeCode"})
    public RoleLinkType getTypeCode() {
        return this.typeCode.getValue();
    }
    public void setTypeCode(RoleLinkType typeCode) {
        this.typeCode.setValue(typeCode);
    }

    @Hl7XmlMapping({"territorialAuthority/code"})
    public RoleCode getTerritorialAuthorityType() {
        return this.territorialAuthorityType.getValue();
    }
    public void setTerritorialAuthorityType(RoleCode territorialAuthorityType) {
        this.territorialAuthorityType.setValue(territorialAuthorityType);
    }

    @Hl7XmlMapping({"territorialAuthority/part"})
    public List<PartBean> getTerritorialAuthorityPart() {
        return this.territorialAuthorityPart;
    }

    @Hl7XmlMapping({"territorialAuthority/territory/code"})
    public PlaceEntityType getJurisdictionType() {
        return this.jurisdictionType.getValue();
    }
    public void setJurisdictionType(PlaceEntityType jurisdictionType) {
        this.jurisdictionType.setValue(jurisdictionType);
    }

}

/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pr.prpm_mt309000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CE;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CEImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.PlaceEntityType;
import ca.infoway.messagebuilder.domainvalue.RoleCode;
import ca.infoway.messagebuilder.domainvalue.RoleLinkType;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Territorial Authority</p>
 * 
 * <p><p>RoleClass necessary to support the Jurisdiction within 
 * which the scoping organization exists</p></p>
 * 
 * <p><p>Supports business requirement to provide additional 
 * information regarding the jurisdication within the scoping 
 * organization exists.</p></p>
 */
@Hl7PartTypeMapping({"PRPM_MT309000CA.TerritorialAuthority"})
public class TerritorialAuthorityBean extends MessagePartBean {

    private static final long serialVersionUID = 20120215L;
    private CE code = new CEImpl();
    private CV territoryCode = new CVImpl();
    private CS partTypeCode = new CSImpl();
    private TerritorialAuthorityBean partTerritorialAuthority;


    /**
     * <p>Territorial Authority Type</p>
     * 
     * <p><p>The code identifying the specific Territorial 
     * Authority</p></p>
     * 
     * <p><p>Populated attribute supports the validation and 
     * identification of the healthcare provider</p></p>
     */
    @Hl7XmlMapping({"code"})
    public RoleCode getCode() {
        return (RoleCode) this.code.getValue();
    }
    public void setCode(RoleCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Jurisdiction Type</p>
     * 
     * <p><p>A character value that represents the Canadian 
     * provincial or territorial geographical area within which the 
     * Provider is operating.</p></p>
     * 
     * <p><p>Populated attribute supports the validation and 
     * identification of the healthcare provider</p></p>
     * 
     * <p><p>If Jurisdiction is included in the message, then 
     * Territorial Authority Type is Expected to Exist.</p></p>
     */
    @Hl7XmlMapping({"territory/code"})
    public PlaceEntityType getTerritoryCode() {
        return (PlaceEntityType) this.territoryCode.getValue();
    }
    public void setTerritoryCode(PlaceEntityType territoryCode) {
        this.territoryCode.setValue(territoryCode);
    }


    @Hl7XmlMapping({"part/typeCode"})
    public RoleLinkType getPartTypeCode() {
        return (RoleLinkType) this.partTypeCode.getValue();
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

}

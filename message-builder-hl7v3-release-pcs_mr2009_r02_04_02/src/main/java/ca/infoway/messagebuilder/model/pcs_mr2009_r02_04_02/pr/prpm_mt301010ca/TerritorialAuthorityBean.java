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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pr.prpm_mt301010ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.domainvalue.JurisdictionTypeCode;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.domainvalue.TerritorialAuthorityRoleType;



/**
 * <p>Territorial Authority</p>
 * 
 * <p>RoleClass necessary to support the Jurisdiction within 
 * which the scoping organization exists</p>
 * 
 * <p>Supports business requirement to provide additional 
 * information regarding the jurisdication within the scoping 
 * organization exists.</p>
 */
@Hl7PartTypeMapping({"PRPM_MT301010CA.TerritorialAuthority"})
public class TerritorialAuthorityBean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private CV code = new CVImpl();
    private CV territoryCode = new CVImpl();
    private TerritorialAuthorityBean partTerritorialAuthority;


    /**
     * <p>Territorial Authority Type</p>
     * 
     * <p>The code identifying the specific Territorial 
     * Authority</p>
     * 
     * <p>Mandatory attribute supports the validation and 
     * identification of the healthcare provider</p>
     */
    @Hl7XmlMapping({"code"})
    public TerritorialAuthorityRoleType getCode() {
        return (TerritorialAuthorityRoleType) this.code.getValue();
    }

    /**
     * <p>Territorial Authority Type</p>
     * 
     * <p>The code identifying the specific Territorial 
     * Authority</p>
     * 
     * <p>Mandatory attribute supports the validation and 
     * identification of the healthcare provider</p>
     */
    public void setCode(TerritorialAuthorityRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Jurisdiction Type</p>
     * 
     * <p>A character value that represents the Canadian provincial 
     * or territorial geographical area within which the Provider 
     * is operating.</p>
     * 
     * <p>Mandatory attribute supports the validation and 
     * identification of the healthcare provider</p>
     * 
     * <p>If Jurisdiction is included in the message, then 
     * Territorial Authority Type is Expected to Exist.</p>
     */
    @Hl7XmlMapping({"territory/code"})
    public JurisdictionTypeCode getTerritoryCode() {
        return (JurisdictionTypeCode) this.territoryCode.getValue();
    }

    /**
     * <p>Jurisdiction Type</p>
     * 
     * <p>A character value that represents the Canadian provincial 
     * or territorial geographical area within which the Provider 
     * is operating.</p>
     * 
     * <p>Mandatory attribute supports the validation and 
     * identification of the healthcare provider</p>
     * 
     * <p>If Jurisdiction is included in the message, then 
     * Territorial Authority Type is Expected to Exist.</p>
     */
    public void setTerritoryCode(JurisdictionTypeCode territoryCode) {
        this.territoryCode.setValue(territoryCode);
    }


    @Hl7XmlMapping({"part/territorialAuthority"})
    public TerritorialAuthorityBean getPartTerritorialAuthority() {
        return this.partTerritorialAuthority;
    }

    public void setPartTerritorialAuthority(TerritorialAuthorityBean partTerritorialAuthority) {
        this.partTerritorialAuthority = partTerritorialAuthority;
    }

}

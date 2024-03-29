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
package ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.pr.prpm_mt306011ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.domainvalue.JurisdictionTypeCode;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.domainvalue.TerritorialAuthorityRoleType;



/**
 * <p>Business Name: Territorial Authority</p>
 * 
 * <p>Supports business requirement to provide additional 
 * information regarding the jurisdication within the scoping 
 * organization exists.</p>
 * 
 * <p>RoleClass necessary to support the Jurisdiction within 
 * which the scoping organization exists</p>
 */
@Hl7PartTypeMapping({"PRPM_MT306011CA.TerritorialAuthority"})
public class TerritorialAuthorityBean extends MessagePartBean {

    private static final long serialVersionUID = 20190801L;
    private CV code = new CVImpl();
    private CV territoryCode = new CVImpl();
    private TerritorialAuthorityBean partTerritorialAuthority;


    /**
     * <p>Business Name: Territorial Authority Type</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.TerritorialAuthority.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the validation and 
     * identification of the healthcare provider</p>
     * 
     * <p>The code identifying the specific Territorial 
     * Authority</p>
     */
    @Hl7XmlMapping({"code"})
    public TerritorialAuthorityRoleType getCode() {
        return (TerritorialAuthorityRoleType) this.code.getValue();
    }

    /**
     * <p>Business Name: Territorial Authority Type</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.TerritorialAuthority.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the validation and 
     * identification of the healthcare provider</p>
     * 
     * <p>The code identifying the specific Territorial 
     * Authority</p>
     */
    public void setCode(TerritorialAuthorityRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Jurisdiction Type</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.Jurisdiction.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the validation and 
     * identification of the healthcare provider</p><p>.</p>
     * 
     * <p>If Jurisdiction is included in the message, then 
     * Territorial Authority Type is Expected to Exist</p>
     * 
     * <p>A character value that represents the Canadian provincial 
     * or territorial geographical area within which the Provider 
     * is operating.</p>
     */
    @Hl7XmlMapping({"territory/code"})
    public JurisdictionTypeCode getTerritoryCode() {
        return (JurisdictionTypeCode) this.territoryCode.getValue();
    }

    /**
     * <p>Business Name: Jurisdiction Type</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.Jurisdiction.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the validation and 
     * identification of the healthcare provider</p><p>.</p>
     * 
     * <p>If Jurisdiction is included in the message, then 
     * Territorial Authority Type is Expected to Exist</p>
     * 
     * <p>A character value that represents the Canadian provincial 
     * or territorial geographical area within which the Provider 
     * is operating.</p>
     */
    public void setTerritoryCode(JurisdictionTypeCode territoryCode) {
        this.territoryCode.setValue(territoryCode);
    }


    /**
     * <p>Relationship: PRPM_MT306011CA.Part.territorialAuthority</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"part/territorialAuthority"})
    public TerritorialAuthorityBean getPartTerritorialAuthority() {
        return this.partTerritorialAuthority;
    }

    /**
     * <p>Relationship: PRPM_MT306011CA.Part.territorialAuthority</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPartTerritorialAuthority(TerritorialAuthorityBean partTerritorialAuthority) {
        this.partTerritorialAuthority = partTerritorialAuthority;
    }

}

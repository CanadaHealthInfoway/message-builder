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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.x_ActMoodRequestEvent;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.CarrierRoleBean;



/**
 * <p>CoverageExtensions</p>
 * 
 * <p>PORX_MT060160CA.Coverage: Coverage Extensions</p>
 * 
 * <p><p>An authorization issued by a payor to cover a drug not 
 * previously covered by a patient's drug plan.</p></p>
 * 
 * <p><p>Allows conveying special coverage information between 
 * providers.</p></p>
 * 
 * <p>PORX_MT060340CA.Coverage: Coverage Extensions</p>
 * 
 * <p><p>An authorization issued by a payor to cover a drug not 
 * previously covered by a patient's drug plan.</p></p>
 * 
 * <p><p>Allows conveying special coverage information between 
 * providers.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT060160CA.Coverage","PORX_MT060340CA.Coverage"})
public class CoverageExtensions_2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110906L;
    private CS extensionGrantedIndicator = new CSImpl();
    private II coverageExtensionId = new IIImpl();
    private CarrierRoleBean authorCarrierRole;


    /**
     * <p>ExtensionGrantedIndicator</p>
     * 
     * <p>Extension Granted Indicator</p>
     * 
     * <p><p>If set to 'EVN', then coverage has been requested. 
     * Otherwise it has merely been requested.</p></p>
     * 
     * <p><p>Indicates to the pharmacy whether they need to check 
     * the status of coverage prior to dispensing. Mandatory due to 
     * HL7 rules.</p></p>
     * 
     * <p>Extension Granted Indicator</p>
     * 
     * <p><p>If set to 'EVN', then coverage has been granted. 
     * Otherwise it has merely been requested.</p></p>
     * 
     * <p><p>Indicates to the pharmacy whether they need to check 
     * the status of coverage prior to dispensing. The element is 
     * mandatory to satisfy HL7 rules.</p></p>
     */
    @Hl7XmlMapping({"moodCode"})
    public x_ActMoodRequestEvent getExtensionGrantedIndicator() {
        return (x_ActMoodRequestEvent) this.extensionGrantedIndicator.getValue();
    }
    public void setExtensionGrantedIndicator(x_ActMoodRequestEvent extensionGrantedIndicator) {
        this.extensionGrantedIndicator.setValue(extensionGrantedIndicator);
    }


    /**
     * <p>CoverageExtensionId</p>
     * 
     * <p>A:Coverage Extension Id</p>
     * 
     * <p><p>Unique identification for a specific coverage 
     * extension.</p></p>
     * 
     * <p><p>Allows for referencing of a specific coverage 
     * extension.</p><p>This identifier may be needed on claims 
     * against the coverage.</p><p>At times when the ID will not be 
     * available (such as when the request has just been 
     * submitted), the attribute is 'populated'.</p></p>
     * 
     * <p><p>Allows for referencing of a specific coverage 
     * extension.</p><p>This identifier may be needed on claims 
     * against the coverage.</p><p>At times when the ID will not be 
     * available (such as when the request has just been 
     * submitted), the attribute is 'populated'.</p></p>
     * 
     * <p><p>Allows for referencing of a specific coverage 
     * extension.</p><p>This identifier may be needed on claims 
     * against the coverage.</p><p>At times when the ID will not be 
     * available (such as when the request has just been 
     * submitted), the attribute is 'populated'.</p></p>
     * 
     * <p>A:Coverage Extension Id</p>
     * 
     * <p><p>Unique identification for a specific coverage 
     * extension.</p></p>
     * 
     * <p><p>Allows for referencing of a specific coverage 
     * extension.</p><p>This identifier may be needed on claims 
     * against the coverage.</p><p>At times the ID will not be 
     * available (such as when the request has just been 
     * submitted), the attribute is 'populated'.</p></p>
     * 
     * <p><p>Allows for referencing of a specific coverage 
     * extension.</p><p>This identifier may be needed on claims 
     * against the coverage.</p><p>At times the ID will not be 
     * available (such as when the request has just been 
     * submitted), the attribute is 'populated'.</p></p>
     * 
     * <p><p>Allows for referencing of a specific coverage 
     * extension.</p><p>This identifier may be needed on claims 
     * against the coverage.</p><p>At times the ID will not be 
     * available (such as when the request has just been 
     * submitted), the attribute is 'populated'.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getCoverageExtensionId() {
        return this.coverageExtensionId.getValue();
    }
    public void setCoverageExtensionId(Identifier coverageExtensionId) {
        this.coverageExtensionId.setValue(coverageExtensionId);
    }


    @Hl7XmlMapping({"author/carrierRole"})
    public CarrierRoleBean getAuthorCarrierRole() {
        return this.authorCarrierRole;
    }
    public void setAuthorCarrierRole(CarrierRoleBean authorCarrierRole) {
        this.authorCarrierRole = authorCarrierRole;
    }

}

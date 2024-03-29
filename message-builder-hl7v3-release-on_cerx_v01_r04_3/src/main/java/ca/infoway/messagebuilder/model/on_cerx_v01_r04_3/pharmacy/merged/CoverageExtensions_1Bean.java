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
package ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.x_ActMoodOrderEvent;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: CoverageExtensions</p>
 * 
 * <p>PORX_MT060040ON.Coverage: Coverage Extensions</p>
 * 
 * <p>Allows conveying special coverage information between 
 * providers.</p>
 * 
 * <p>An authorization issued by a payor to cover a device not 
 * previously covered by a patient's drug plan.</p>
 * 
 * <p>PORX_MT010110ON.Coverage: Coverage Extensions</p>
 * 
 * <p>Allows conveying special coverage information between 
 * providers.</p>
 * 
 * <p>An authorization issued by a payor to cover a device not 
 * previously covered by a patient's drug plan.</p>
 * 
 * <p>PORX_MT010120ON.Coverage: Coverage Extensions</p>
 * 
 * <p>Allows conveying special coverage information between 
 * providers.</p>
 * 
 * <p>An authorization issued by a payor to cover a drug not 
 * previously covered by a patient's drug plan.</p>
 */
@Hl7PartTypeMapping({"PORX_MT010110ON.Coverage","PORX_MT010120ON.Coverage","PORX_MT060040ON.Coverage"})
public class CoverageExtensions_1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private CS moodCode = new CSImpl();
    private II id = new IIImpl();
    private UnderwriterBean authorUnderwriter;


    /**
     * <p>Business Name: ExtensionGrantedIndicator</p>
     * 
     * <p>Un-merged Business Name: ExtensionGrantedIndicator</p>
     * 
     * <p>Relationship: PORX_MT060040ON.Coverage.moodCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates to the pharmacy whether they need to check the 
     * status of coverage prior to dispensing. Mandatory due to HL7 
     * rules.</p>
     * 
     * <p>If set to 'EVN', then coverage has been granted. 
     * Otherwise it has merely been requested.</p>
     * 
     * <p>Un-merged Business Name: ExtensionGrantedIndicator</p>
     * 
     * <p>Relationship: PORX_MT010110ON.Coverage.moodCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates to the pharmacy whether they need to check the 
     * status of coverage prior to dispensing</p>
     * 
     * <p>If set to 'EVN', then coverage has been granted. 
     * Otherwise it has merely been requested.</p>
     * 
     * <p>Un-merged Business Name: ExtensionGrantedIndicator</p>
     * 
     * <p>Relationship: PORX_MT010120ON.Coverage.moodCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates to the pharmacy whether they need to check the 
     * status of coverage prior to dispensing. The attribute is 
     * mandatory due to HL7 rules.</p>
     * 
     * <p>If set to 'EVN', then coverage has been granted. 
     * Otherwise it has merely been requested.</p>
     */
    @Hl7XmlMapping({"moodCode"})
    public x_ActMoodOrderEvent getMoodCode() {
        return (x_ActMoodOrderEvent) this.moodCode.getValue();
    }

    /**
     * <p>Business Name: ExtensionGrantedIndicator</p>
     * 
     * <p>Un-merged Business Name: ExtensionGrantedIndicator</p>
     * 
     * <p>Relationship: PORX_MT060040ON.Coverage.moodCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates to the pharmacy whether they need to check the 
     * status of coverage prior to dispensing. Mandatory due to HL7 
     * rules.</p>
     * 
     * <p>If set to 'EVN', then coverage has been granted. 
     * Otherwise it has merely been requested.</p>
     * 
     * <p>Un-merged Business Name: ExtensionGrantedIndicator</p>
     * 
     * <p>Relationship: PORX_MT010110ON.Coverage.moodCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates to the pharmacy whether they need to check the 
     * status of coverage prior to dispensing</p>
     * 
     * <p>If set to 'EVN', then coverage has been granted. 
     * Otherwise it has merely been requested.</p>
     * 
     * <p>Un-merged Business Name: ExtensionGrantedIndicator</p>
     * 
     * <p>Relationship: PORX_MT010120ON.Coverage.moodCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates to the pharmacy whether they need to check the 
     * status of coverage prior to dispensing. The attribute is 
     * mandatory due to HL7 rules.</p>
     * 
     * <p>If set to 'EVN', then coverage has been granted. 
     * Otherwise it has merely been requested.</p>
     */
    public void setMoodCode(x_ActMoodOrderEvent moodCode) {
        this.moodCode.setValue(moodCode);
    }


    /**
     * <p>Business Name: CoverageExtensionId</p>
     * 
     * <p>Un-merged Business Name: CoverageExtensionId</p>
     * 
     * <p>Relationship: PORX_MT060040ON.Coverage.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>D64</p>
     * 
     * <p>Claim.462-EV</p>
     * 
     * <p>ZDP.23.3</p>
     * 
     * <p>Authorization identifier</p>
     * 
     * <p>Allows for referencing of a specific coverage 
     * extension.</p><p>This identifier may be needed on claims 
     * against the coverage.</p><p>At times when the ID will not be 
     * available (such as when the request has just been 
     * submitted), the attribute is 'populated'.</p>
     * 
     * <p>Unique identification for a specific coverage 
     * extension.</p>
     * 
     * <p>Un-merged Business Name: CoverageExtensionId</p>
     * 
     * <p>Relationship: PORX_MT010110ON.Coverage.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>D64</p>
     * 
     * <p>Claim.462-EV</p>
     * 
     * <p>ZDP.23.3</p>
     * 
     * <p>Authorization identifier</p>
     * 
     * <p>Allows for referencing of a specific coverage 
     * extension.</p><p>This identifier may be needed on claims 
     * against the coverage.</p><p>At times the ID will not be 
     * available (such as when the request has just been 
     * submitted), the attribute is 'populated'.</p>
     * 
     * <p>Unique identification for a specific coverage 
     * extension.</p>
     * 
     * <p>Un-merged Business Name: CoverageExtensionId</p>
     * 
     * <p>Relationship: PORX_MT010120ON.Coverage.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>D64</p>
     * 
     * <p>Claim.462-EV</p>
     * 
     * <p>ZDP.23.3</p>
     * 
     * <p>Authorization identifier</p>
     * 
     * <p>Allows for referencing of a specific coverage 
     * extension.</p><p>This identifier may be needed on claims 
     * against the coverage.</p><p>At times the ID will not be 
     * available (such as when the request has just been 
     * submitted), the attribute is 'populated'.</p>
     * 
     * <p>Unique identification for a specific coverage 
     * extension.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: CoverageExtensionId</p>
     * 
     * <p>Un-merged Business Name: CoverageExtensionId</p>
     * 
     * <p>Relationship: PORX_MT060040ON.Coverage.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>D64</p>
     * 
     * <p>Claim.462-EV</p>
     * 
     * <p>ZDP.23.3</p>
     * 
     * <p>Authorization identifier</p>
     * 
     * <p>Allows for referencing of a specific coverage 
     * extension.</p><p>This identifier may be needed on claims 
     * against the coverage.</p><p>At times when the ID will not be 
     * available (such as when the request has just been 
     * submitted), the attribute is 'populated'.</p>
     * 
     * <p>Unique identification for a specific coverage 
     * extension.</p>
     * 
     * <p>Un-merged Business Name: CoverageExtensionId</p>
     * 
     * <p>Relationship: PORX_MT010110ON.Coverage.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>D64</p>
     * 
     * <p>Claim.462-EV</p>
     * 
     * <p>ZDP.23.3</p>
     * 
     * <p>Authorization identifier</p>
     * 
     * <p>Allows for referencing of a specific coverage 
     * extension.</p><p>This identifier may be needed on claims 
     * against the coverage.</p><p>At times the ID will not be 
     * available (such as when the request has just been 
     * submitted), the attribute is 'populated'.</p>
     * 
     * <p>Unique identification for a specific coverage 
     * extension.</p>
     * 
     * <p>Un-merged Business Name: CoverageExtensionId</p>
     * 
     * <p>Relationship: PORX_MT010120ON.Coverage.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>D64</p>
     * 
     * <p>Claim.462-EV</p>
     * 
     * <p>ZDP.23.3</p>
     * 
     * <p>Authorization identifier</p>
     * 
     * <p>Allows for referencing of a specific coverage 
     * extension.</p><p>This identifier may be needed on claims 
     * against the coverage.</p><p>At times the ID will not be 
     * available (such as when the request has just been 
     * submitted), the attribute is 'populated'.</p>
     * 
     * <p>Unique identification for a specific coverage 
     * extension.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060040ON.Author2.underwriter</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT010110ON.Author.underwriter</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT010120ON.Author.underwriter</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author/underwriter"})
    public UnderwriterBean getAuthorUnderwriter() {
        return this.authorUnderwriter;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060040ON.Author2.underwriter</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT010110ON.Author.underwriter</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT010120ON.Author.underwriter</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthorUnderwriter(UnderwriterBean authorUnderwriter) {
        this.authorUnderwriter = authorUnderwriter;
    }

}

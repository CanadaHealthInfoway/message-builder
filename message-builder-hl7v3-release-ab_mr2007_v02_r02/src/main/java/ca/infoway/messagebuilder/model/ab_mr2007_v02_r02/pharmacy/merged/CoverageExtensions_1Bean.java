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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.merged;

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
 * <p>CoverageExtensions</p>
 * 
 * <p>PORX_MT010120CA.Coverage: Coverage Extensions</p>
 * 
 * <p><p>An authorization issued by a payor to cover a drug not 
 * previously covered by a patient's drug plan.</p></p>
 * 
 * <p><p>Allows conveying special coverage information between 
 * providers.</p></p>
 * 
 * <p>PORX_MT060040CA.Coverage: Coverage Extensions</p>
 * 
 * <p><p>An authorization issued by a payor to cover a device 
 * not previously covered by a patient's drug plan.</p></p>
 * 
 * <p><p>Allows conveying special coverage information between 
 * providers.</p></p>
 * 
 * <p>PORX_MT010110CA.Coverage: Coverage Extensions</p>
 * 
 * <p><p>An authorization issued by a payor to cover a device 
 * not previously covered by a patient's drug plan.</p></p>
 * 
 * <p><p>Allows conveying special coverage information between 
 * providers.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT010110CA.Coverage","PORX_MT010120CA.Coverage","PORX_MT060040CA.Coverage"})
public class CoverageExtensions_1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20111208L;
    private CS moodCode = new CSImpl();
    private II id = new IIImpl();
    private UnderwriterBean authorUnderwriter;


    /**
     * <p>ExtensionGrantedIndicator</p>
     * 
     * <p>Extension Granted Indicator</p>
     * 
     * <p><p>If set to 'EVN', then coverage has been granted. 
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
     * the status of coverage prior to dispensing. The attribute is 
     * mandatory due to HL7 rules.</p></p>
     * 
     * <p>Extension Granted Indicator</p>
     * 
     * <p><p>If set to 'EVN', then coverage has been granted. 
     * Otherwise it has merely been requested.</p></p>
     * 
     * <p><p>Indicates to the pharmacy whether they need to check 
     * the status of coverage prior to dispensing</p></p>
     */
    @Hl7XmlMapping({"moodCode"})
    public x_ActMoodOrderEvent getMoodCode() {
        return (x_ActMoodOrderEvent) this.moodCode.getValue();
    }
    public void setMoodCode(x_ActMoodOrderEvent moodCode) {
        this.moodCode.setValue(moodCode);
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
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    @Hl7XmlMapping({"author/underwriter"})
    public UnderwriterBean getAuthorUnderwriter() {
        return this.authorUnderwriter;
    }
    public void setAuthorUnderwriter(UnderwriterBean authorUnderwriter) {
        this.authorUnderwriter = authorUnderwriter;
    }

}

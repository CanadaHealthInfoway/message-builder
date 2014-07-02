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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_r02_04_03.common.coct_mt270010ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Administration Precondition</p>
 * 
 * <p>Indicates that prescription is a 'PRN' (as needed) 
 * prescription and that doses to be consumed cannot be 
 * accurately calculated. This has important compliance 
 * implications.</p>
 * 
 * <p>To flag a prescription as '''PRN''' without specifying a 
 * condition, include the association but specify a null flavor 
 * for the Dosage Condition.</p>
 * 
 * <p>This sets the conditions for which a specific 
 * administration of the drug may be undertaken. Example: if 
 * headache persists for 2hrs or more 'take 2 tabs.</p>
 */
@Hl7PartTypeMapping({"COCT_MT270010CA.ActEventCriterion"})
public class AdministrationPreconditionBean extends MessagePartBean {

    private static final long serialVersionUID = 20140515L;
    private ST text = new STImpl();


    /**
     * <p>Business Name: A:Dosage Condition</p>
     * 
     * <p>Relationship: COCT_MT270010CA.ActEventCriterion.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>RepeatPattern.prn (true when present)</p>
     * 
     * <p>ZDP.13.6 (true when present)</p>
     * 
     * <p>ZDP.13.7</p>
     * 
     * <p>Allows un-coded specifications of conditions in which the 
     * medication should be taken.</p>
     * 
     * <p>A free-form textual description of condition that must be 
     * met before the product may be administered to/by the 
     * patient.</p><p>Example: When pressure exceeds 150/90 - Take 
     * 2 tabs</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: A:Dosage Condition</p>
     * 
     * <p>Relationship: COCT_MT270010CA.ActEventCriterion.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>RepeatPattern.prn (true when present)</p>
     * 
     * <p>ZDP.13.6 (true when present)</p>
     * 
     * <p>ZDP.13.7</p>
     * 
     * <p>Allows un-coded specifications of conditions in which the 
     * medication should be taken.</p>
     * 
     * <p>A free-form textual description of condition that must be 
     * met before the product may be administered to/by the 
     * patient.</p><p>Example: When pressure exceeds 150/90 - Take 
     * 2 tabs</p>
     */
    public void setText(String text) {
        this.text.setValue(text);
    }

}
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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>AdministrationPrecondition</p>
 * 
 * <p>COCT_MT270010CA.ActEventCriterion: Administration 
 * Precondition</p>
 * 
 * <p><p>This sets the conditions for which a specific 
 * administration of the drug may be undertaken. Example: if 
 * headache persists for 2hrs or more 'take 2 tabs.</p></p>
 * 
 * <p><p>Indicates that prescription is a 'PRN' (as needed) 
 * prescription and that doses to be consumed cannot be 
 * accurately calculated. This has important compliance 
 * implications.</p></p>
 * 
 * <p><p>To flag a prescription as 
 * &#226;&#128;&#156;PRN&#226;&#128;&#157; without specifying a 
 * condition, include the association but specify a null flavor 
 * for the Dosage Condition.</p></p>
 * 
 * <p>PORX_MT980040CA.ActEventCriterion: Administration 
 * Precondition</p>
 * 
 * <p><p>This sets the conditions for which a specific 
 * administration of the drug may be undertaken. Example: if 
 * headache persists for 2hrs or more 'take 2 tabs.</p></p>
 * 
 * <p><p>Indicates that prescription is a 'PRN' (as needed) 
 * prescription and that doses to be consumed cannot be 
 * accurately calculated. This has important compliance 
 * implications.</p></p>
 * 
 * <p><p>To flag a prescription as PRN without specifying a 
 * condition, include the association but specify a null flavor 
 * for the Dosage Condition.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT270010CA.ActEventCriterion","PORX_MT980040CA.ActEventCriterion"})
public class AdministrationPreconditionBean extends MessagePartBean {

    private static final long serialVersionUID = 20120116L;
    private ST text = new STImpl();


    /**
     * <p>DosageCondition</p>
     * 
     * <p>A:Dosage Condition</p>
     * 
     * <p><p>A free-form textual description of condition that must 
     * be met before the product may be administered to/by the 
     * patient.</p><p>Example: When pressure exceeds 150/90 - Take 
     * 2 tabs</p></p>
     * 
     * <p><p>A free-form textual description of condition that must 
     * be met before the product may be administered to/by the 
     * patient.</p><p>Example: When pressure exceeds 150/90 - Take 
     * 2 tabs</p></p>
     * 
     * <p><p>RepeatPattern.prn (true when present)</p><p>ZDP.13.6 
     * (true when present)</p><p>ZDP.13.7</p></p>
     * 
     * <p><p>RepeatPattern.prn (true when present)</p><p>ZDP.13.6 
     * (true when present)</p><p>ZDP.13.7</p></p>
     * 
     * <p><p>RepeatPattern.prn (true when present)</p><p>ZDP.13.6 
     * (true when present)</p><p>ZDP.13.7</p></p>
     * 
     * <p><p>Allows un-coded specifications of conditions in which 
     * the medication should be taken.</p></p>
     * 
     * <p>A:Dosage Condition</p>
     * 
     * <p><p>A free-form textual description of condition that must 
     * be met before the product may be administered to/by the 
     * patient.</p><p>Example: When pressure exceeds 150/90 - Take 
     * 2 tabs</p></p>
     * 
     * <p><p>A free-form textual description of condition that must 
     * be met before the product may be administered to/by the 
     * patient.</p><p>Example: When pressure exceeds 150/90 - Take 
     * 2 tabs</p></p>
     * 
     * <p><p>RepeatPattern.prn (true when present)</p><p>ZDP.13.6 
     * (true when present)</p><p>ZDP.13.7</p></p>
     * 
     * <p><p>RepeatPattern.prn (true when present)</p><p>ZDP.13.6 
     * (true when present)</p><p>ZDP.13.7</p></p>
     * 
     * <p><p>RepeatPattern.prn (true when present)</p><p>ZDP.13.6 
     * (true when present)</p><p>ZDP.13.7</p></p>
     * 
     * <p><p>Allows un-coded specifications of conditions in which 
     * the medication should be taken.</p></p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }
    public void setText(String text) {
        this.text.setValue(text);
    }

}

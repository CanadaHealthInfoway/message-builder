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
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.SeverityObservation;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>AllergyIntoleranceSeverityLevel</p>
 * 
 * <p>REPC_MT000002CA.SeverityObservation: Allergy/Intolerance 
 * Severity Level</p>
 * 
 * <p><p>This is a ranking/ an assertion of the seriouness of 
 * the diagnosed/reported medical condition.</p></p>
 * 
 * <p><p>Allows providers to determine appropriate managements 
 * for contraindications involving such medical conditions.</p></p>
 * 
 * <p>REPC_MT000009CA.SeverityObservation: Allergy/Intolerance 
 * Severity Level</p>
 * 
 * <p><p>This is a ranking/ an assertion of the seriouness of 
 * the diagnosed/reported medical condition.</p></p>
 * 
 * <p><p>Allows providers to determine appropriate managements 
 * for contraindications involving such medical conditions.</p></p>
 * 
 * <p>REPC_MT000001CA.SeverityObservation: Allergy/Intolerance 
 * Severity Level</p>
 * 
 * <p><p>This is a ranking/ an assertion of the seriouness of 
 * the diagnosed/reported medical condition.</p></p>
 * 
 * <p><p>Allows providers to determine appropriate managements 
 * for contraindications involving such medical conditions.</p></p>
 * 
 * <p>REPC_MT000006CA.SeverityObservation: Allergy/Intolerance 
 * Severity Level</p>
 * 
 * <p><p>This is a ranking/ an assertion of the seriouness of 
 * the diagnosed/reported medical condition.</p></p>
 * 
 * <p><p>Allows providers to determine appropriate managements 
 * for contraindications involving such medical conditions.</p></p>
 * 
 * <p>REPC_MT000013CA.SeverityObservation: Allergy/Intolerance 
 * Severity Level</p>
 * 
 * <p><p>Indicates both the product and how related they are 
 * determined to be to the reaction.</p></p>
 * 
 * <p><p>This is a ranking/ an assertion of the seriouness of 
 * the diagnosed/reported medical condition.</p></p>
 * 
 * <p><p>Allows providers to determine appropriate managements 
 * for contraindications involving such medical conditions.</p></p>
 * 
 * <p>REPC_MT000012CA.SeverityObservation: Allergy/Intolerance 
 * Severity Level</p>
 * 
 * <p><p>This is a ranking/ an assertion of the seriouness of 
 * the diagnosed/reported medical condition.</p></p>
 * 
 * <p><p>Allows providers to determine appropriate managements 
 * for contraindications involving such medical conditions.</p></p>
 * 
 * <p>REPC_MT000005CA.SeverityObservation: Allergy/Intolerance 
 * Severity Level</p>
 * 
 * <p><p>This is a ranking/ an assertion of the seriouness of 
 * the diagnosed/reported medical condition.</p></p>
 * 
 * <p><p>Allows providers to determine appropriate managements 
 * for contraindications involving such medical conditions.</p></p>
 */
@Hl7PartTypeMapping({"REPC_MT000001CA.SeverityObservation","REPC_MT000002CA.SeverityObservation","REPC_MT000005CA.SeverityObservation","REPC_MT000006CA.SeverityObservation","REPC_MT000009CA.SeverityObservation","REPC_MT000012CA.SeverityObservation","REPC_MT000013CA.SeverityObservation"})
public class AllergyIntoleranceSeverityLevelBean extends MessagePartBean {

    private static final long serialVersionUID = 20111208L;
    private CV value = new CVImpl();


    /**
     * <p>SeverityLevel</p>
     * 
     * <p>C:Severity Level</p>
     * 
     * <p><p>Indicates the gravity of the allergy, intolerance or 
     * reaction in terms of its actual or potential impact on the 
     * patient.</p></p>
     * 
     * <p><p>AllergyIntolerance.severity</p></p>
     * 
     * <p><p>Allows for sorting of reactions. May influence whether 
     * contraindications must be managed.</p><p>Because SNOMED 
     * pre-coordinates severity into code, this association is 
     * optional</p></p>
     * 
     * <p><p>Allows for sorting of reactions. May influence whether 
     * contraindications must be managed.</p><p>Because SNOMED 
     * pre-coordinates severity into code, this association is 
     * optional</p></p>
     * 
     * <p>C:Severity Level</p>
     * 
     * <p><p>Indicates the gravity of the allergy, intolerance or 
     * reaction in terms of its actual or potential impact on the 
     * patient.</p></p>
     * 
     * <p><p>AllergyIntolerance.severity</p></p>
     * 
     * <p><p>Allows for sorting of allergy records. May influence 
     * whether contraindications must be managed. Because SNOMED 
     * pre-coordinates severity into 'code', the attribute is 
     * optional.</p></p>
     * 
     * <p>C:Severity Level</p>
     * 
     * <p><p>Indicates the gravity of the allergy, intolerance or 
     * reaction in terms of its actual or potential impact on the 
     * patient.</p></p>
     * 
     * <p><p>AllergyIntolerance.severity</p></p>
     * 
     * <p><p>Allows for sorting of allergy records. May influence 
     * whether contraindications must be managed.</p><p>Because 
     * SNOMED handles this concept by pre-coordinating it into 
     * code, this association is optional.</p></p>
     * 
     * <p><p>Allows for sorting of allergy records. May influence 
     * whether contraindications must be managed.</p><p>Because 
     * SNOMED handles this concept by pre-coordinating it into 
     * code, this association is optional.</p></p>
     * 
     * <p>C:Severity Level</p>
     * 
     * <p><p>Indicates the gravity of the allergy, intolerance or 
     * reaction in terms of its actual or potential impact on the 
     * patient.</p></p>
     * 
     * <p><p>AllergyIntolerance.severity</p></p>
     * 
     * <p><p>Allows for sorting of reactions. May influence whether 
     * contraindications must be managed. Because SNOMED 
     * pre-coordinates this concept with code, the association is 
     * optional.</p></p>
     * 
     * <p>C:Severity Level</p>
     * 
     * <p><p>Indicates the gravity of the allergy, intolerance or 
     * reaction in terms of its actual or potential impact on the 
     * patient.</p></p>
     * 
     * <p><p>Allows for sorting of allergy records. May influence 
     * whether contraindications must be managed.</p><p>Because 
     * SNOMED pre-coordinates severity into code, this association 
     * is optional</p></p>
     * 
     * <p><p>Allows for sorting of allergy records. May influence 
     * whether contraindications must be managed.</p><p>Because 
     * SNOMED pre-coordinates severity into code, this association 
     * is optional</p></p>
     * 
     * <p>C:Severity Level</p>
     * 
     * <p><p>Indicates the gravity of the allergy, intolerance or 
     * reaction in terms of its actual or potential impact on the 
     * patient.</p></p>
     * 
     * <p><p>Allows for sorting of allergy records. May influence 
     * whether contraindications must be managed. Because this 
     * concept is pre-coordinated with code for SNOMED, the 
     * association is optional.</p></p>
     * 
     * <p>C:Severity Level</p>
     * 
     * <p><p>Indicates the gravity of the allergy, intolerance or 
     * reaction in terms of its actual or potential impact on the 
     * patient.</p></p>
     * 
     * <p><p>AllergyIntolerance.severity</p></p>
     * 
     * <p><p>Allows for sorting of reactions. May influence whether 
     * contraindications must be managed. Because SNOMED 
     * pre-coordinates this concept into code, the association is 
     * optional</p></p>
     */
    @Hl7XmlMapping({"value"})
    public SeverityObservation getValue() {
        return (SeverityObservation) this.value.getValue();
    }
    public void setValue(SeverityObservation value) {
        this.value.setValue(value);
    }

}

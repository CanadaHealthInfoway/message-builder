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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.ra.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Patient</p>
 * 
 * <p>RCMR_MT010002CA.Patient: Patient</p>
 * 
 * <p><p>Indicates that the keyword was changed by the patient 
 * themselves.</p></p>
 * 
 * <p><p>Sometimes keywords are changed by the patient, 
 * sometimes by a patient representative.</p></p>
 * 
 * <p>RCMR_MT010001CA.Patient: Patient</p>
 * 
 * <p><p>Indicates that consent was granted by the patient 
 * themselves</p></p>
 * 
 * <p><p>Allows assertion of who issued the consent.</p></p>
 */
@Hl7PartTypeMapping({"RCMR_MT010001CA.Patient","RCMR_MT010002CA.Patient"})
public class PatientBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.Consenter {

    private static final long serialVersionUID = 20111117L;

}
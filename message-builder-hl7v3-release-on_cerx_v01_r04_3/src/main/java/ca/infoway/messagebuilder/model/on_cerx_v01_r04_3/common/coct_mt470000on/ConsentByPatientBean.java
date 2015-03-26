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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.common.coct_mt470000on;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Consent By Patient</p>
 * 
 * <p>Distinguishing whether consent is granted by the patient 
 * or a representative can be important for audit purposes.</p>
 * 
 * <p>Indicates that the consent or keyword has been provided 
 * by the patient themselves (rather than a 
 * representative.)</p>
 */
@Hl7PartTypeMapping({"COCT_MT470000ON.Patient"})
public class ConsentByPatientBean extends MessagePartBean implements Consenter {

    private static final long serialVersionUID = 20150326L;

}

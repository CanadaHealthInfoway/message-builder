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
package ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.mcci_mt002300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.quqi_mt120008ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.pharmacy.pome_mt010050ca.GenericQueryParametersBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.pharmacy.porr_mt050016ca.MedicationDocumentsBean;



/**
 * <p>Business Name: POME_IN010020CA: Drug document query 
 * response</p>
 * 
 * <p>Returns one or more drug, protocol or contraindication 
 * monographs as text, HTML, PDF or CDA documents.</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Control Act: QUQI_MT120008CA.ControlActEvent</p>
 * 
 * <p>--> Payload: PORR_MT050016CA.Document</p>
 * 
 * <p>--> Payload: POME_MT010050CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"POME_IN010020CA"})
public class DrugDocumentQueryResponseBean extends HL7MessageBean<TriggerEventBean<MedicationDocumentsBean,GenericQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20150901L;

}

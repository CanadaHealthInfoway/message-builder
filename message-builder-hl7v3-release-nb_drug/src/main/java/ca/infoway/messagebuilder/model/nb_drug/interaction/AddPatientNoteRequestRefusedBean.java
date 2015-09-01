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
package ca.infoway.messagebuilder.model.nb_drug.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.nb_drug.common.mcai_mt700222nb.TriggerEventBean;
import ca.infoway.messagebuilder.model.nb_drug.common.mcci_mt000300nb.HL7MessageBean;



/**
 * <p>Business Name: COMT_IN300003NB: Add patient note request 
 * refused</p>
 * 
 * <p>Indicates that the request to record the annotation 
 * against a particular patient has been denied.</p>
 * 
 * <p>A receipt of this message means the add note request 
 * message was rejected by the DIS. The &ldquo;text&rdquo; 
 * element in the message path &ldquo;/subjectOf 
 * /detectedIssueEvent&rdquo; will return the detailed error 
 * message describing why the record was rejected.</p> <p>The 
 * most common reasons the request message may have been 
 * refused by the DIS include:<br /> a. The patient record 
 * identifier supplied in the request message was not valid.<br 
 * /> b. The location record identifier supplied in the request 
 * message was not valid.<br /> c. The note exceeded 2,000 
 * characters in length.<br /> d. One or more code values 
 * supplied in the message were invalid.</p> <p></p>
 * 
 * <p>Message: MCCI_MT000300NB.Message</p>
 * 
 * <p>Control Act: MCAI_MT700222NB.ControlActEvent</p>
 */
@Hl7PartTypeMapping({"COMT_IN300003NB"})
public class AddPatientNoteRequestRefusedBean extends HL7MessageBean<TriggerEventBean> implements InteractionBean {

    private static final long serialVersionUID = 20150901L;

}

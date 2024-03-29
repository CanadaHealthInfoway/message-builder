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
package ca.infoway.messagebuilder.model.nb_drug.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.nb_drug.common.mcai_mt700222ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.nb_drug.common.mcci_mt000100ca.HL7MessageBean;



/**
 * <p>Business Name: PORX_IN020230CA: Record supply event (ward 
 * stock) request refused</p>
 * 
 * <p>Indicates that the request to record a bulk supply of a 
 * medication to a facility has been refused.</p>
 * 
 * <p>The error message that describes why the request message 
 * was refused will be in the &ldquo;text&rdquo; element in the 
 * message path: &ldquo;/subjectOf /detectedIssueEvent 
 * /text&rdquo;.</p> <p>Possible reasons for rejecting the 
 * message may include: a. An identifier specified in the 
 * transfer request message, such as the product, provider, or 
 * location identifiers were not valid or could not be 
 * resolved. b. The supply quantities or units of measure 
 * specified were not valid. c. One or more code values 
 * supplied in the message were invalid.</p>
 * 
 * <p>Message: MCCI_MT000100CA.Message</p>
 * 
 * <p>Control Act: MCAI_MT700222CA.ControlActEvent</p>
 */
@Hl7PartTypeMapping({"PORX_IN020230CA"})
public class RecordSupplyEventWardStockRequestRefusedBean extends HL7MessageBean<TriggerEventBean> implements InteractionBean {

    private static final long serialVersionUID = 20190731L;

}

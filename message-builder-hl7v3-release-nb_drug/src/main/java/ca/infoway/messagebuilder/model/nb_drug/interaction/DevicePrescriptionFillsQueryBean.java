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
import ca.infoway.messagebuilder.model.nb_drug.common.mcci_mt000100nb.HL7MessageBean;
import ca.infoway.messagebuilder.model.nb_drug.common.quqi_mt020000nb.TriggerEventBean;
import ca.infoway.messagebuilder.model.nb_drug.pharmacy.porx_mt060080nb.GenericQueryParametersBean;



/**
 * <p>Business Name: PORX_IN060110NB: Device prescription fills 
 * query</p>
 * 
 * <p>Requests retrieval of basic information about all 
 * dispenses performed against a particular device prescription 
 * referenced by id</p>
 * 
 * <p>Message: MCCI_MT000100NB.Message</p>
 * 
 * <p>Control Act: QUQI_MT020000NB.ControlActEvent</p>
 * 
 * <p>--> Payload: PORX_MT060080NB.ParameterList</p>
 */
@Hl7PartTypeMapping({"PORX_IN060110NB"})
public class DevicePrescriptionFillsQueryBean extends HL7MessageBean<TriggerEventBean<GenericQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20150901L;

}

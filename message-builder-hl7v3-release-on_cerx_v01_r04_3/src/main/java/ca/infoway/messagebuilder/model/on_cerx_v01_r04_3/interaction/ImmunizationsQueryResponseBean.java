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
package ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.common.mcci_mt000300on.HL7MessageBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.common.quqi_mt120000on.TriggerEventBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.immunization.poiz_mt060140on.GenericQueryParametersBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.immunization.poiz_mt060150on.ImmunizationsBean;



/**
 * <p>Business Name: POIZ_IN020020ON: Immunizations query 
 * response</p>
 * 
 * <p>Returns detailed information about a patient's 
 * immunizations.</p>
 * 
 * <p>Message: MCCI_MT000300ON.Message</p>
 * 
 * <p>Control Act: QUQI_MT120000ON.ControlActEvent</p>
 * 
 * <p>--&gt; Payload: POIZ_MT060150ON.Immunization</p>
 * 
 * <p>--&gt; Payload: POIZ_MT060140ON.ParameterList</p>
 */
@Hl7PartTypeMapping({"POIZ_IN020020ON"})
public class ImmunizationsQueryResponseBean extends HL7MessageBean<TriggerEventBean<ImmunizationsBean,GenericQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20190731L;

}

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
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.pharmacy.porx_mt050010on.GenericQueryParametersBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.pharmacy.porx_mt980020on.IssuesBean;



/**
 * <p>Business Name: PORX_IN050020ON: Drug regimen 
 * contraindications query response</p>
 * 
 * <p>Indicates the contraindications (if any) associated with 
 * a set of medications. Only includes drug-drug and duplicate 
 * therapy contraindications because that's all that is 
 * deducible based on a list of medications.</p>
 * 
 * <p>Message: MCCI_MT000300ON.Message</p>
 * 
 * <p>Control Act: QUQI_MT120000ON.ControlActEvent</p>
 * 
 * <p>--&gt; Payload: PORX_MT980020ON.DetectedIssueEvent</p>
 * 
 * <p>--&gt; Payload: PORX_MT050010ON.ParameterList</p>
 */
@Hl7PartTypeMapping({"PORX_IN050020ON"})
public class DrugRegimenContraindicationsQueryResponseBean extends HL7MessageBean<TriggerEventBean<IssuesBean,GenericQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20190731L;

}

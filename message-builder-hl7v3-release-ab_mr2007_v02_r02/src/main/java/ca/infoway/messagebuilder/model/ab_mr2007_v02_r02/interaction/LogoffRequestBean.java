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
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.sessionmgmt.comt_mt900002ab.LogoffBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.sessionmgmt.mcai_mt700210ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.sessionmgmt.mcci_mt000100ca.HL7MessageBean;



/**
 * <p>Business Name: COMT_IN900020AB: Logoff request</p>
 * 
 * <p>Message: MCCI_MT000100CA.Message</p>
 * 
 * <p>Control Act: MCAI_MT700210CA.ControlActEvent</p>
 * 
 * <p>--> Payload: COMT_MT900002AB.ActPermission</p>
 */
@Hl7PartTypeMapping({"COMT_IN900020AB"})
public class LogoffRequestBean extends HL7MessageBean<TriggerEventBean<LogoffBean>> implements InteractionBean {

    private static final long serialVersionUID = 20150326L;

}

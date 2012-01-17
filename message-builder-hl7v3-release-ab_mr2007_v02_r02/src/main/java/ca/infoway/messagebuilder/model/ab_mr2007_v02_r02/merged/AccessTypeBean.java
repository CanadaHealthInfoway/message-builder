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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>AccessType</p>
 * 
 * <p>COCT_MT470000CA.InformDefinition: Access Type</p>
 * 
 * <p><p>Defines the types of information permission is being 
 * granted to access.</p></p>
 * 
 * <p><p>Allows discrete control over different types of 
 * information.</p></p>
 * 
 * <p>COCT_MT470012CA.InformDefinition: Access Type</p>
 * 
 * <p><p>Defines the types of information permission is being 
 * granted to access.</p></p>
 * 
 * <p><p>Allows discrete control over different types of 
 * information.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT470000CA.InformDefinition","COCT_MT470012CA.InformDefinition"})
public class AccessTypeBean extends MessagePartBean {

    private static final long serialVersionUID = 20120116L;
    private ConsentGivenToBean receiver;
    private List<Subject3Bean> subject = new ArrayList<Subject3Bean>();


    @Hl7XmlMapping({"receiver"})
    public ConsentGivenToBean getReceiver() {
        return this.receiver;
    }
    public void setReceiver(ConsentGivenToBean receiver) {
        this.receiver = receiver;
    }


    @Hl7XmlMapping({"subject"})
    public List<Subject3Bean> getSubject() {
        return this.subject;
    }

}

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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.coct_mt280001ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Set;



/**
 * <p>Business Name: Previous Billable Act Cross Reference</p>
 * 
 * <p>Used to reference a previous act (e.g. billable act) by 
 * including its Act.id. May only be used to reference a 
 * billable act in the SAME message, not for past messages 
 * (this would require adjudicators to keep a lot of 
 * history).</p>
 * 
 * <p>Used to reference a previous act (e.g. billable act) by 
 * including its Act.id. May only be used to reference a 
 * billable act in the SAME message, not for past messages 
 * (this would require adjudicators to keep a lot of 
 * history).</p>
 */
@Hl7PartTypeMapping({"COCT_MT280001CA.CrossReference"})
public class PreviousBillableActCrossReferenceBean extends MessagePartBean implements A_BillableActChoice {

    private static final long serialVersionUID = 20140506L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);


    /**
     * <p>Business Name: ) (Act.id.</p>
     * 
     * <p>Relationship: COCT_MT280001CA.CrossReference.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to reference a previous act (e.g. billable act) by 
     * including its Act.id. May only be used to reference a 
     * billable act in the SAME message, not for past messages 
     * (this would require adjudicators to keep a lot of 
     * history).</p>
     * 
     * <p>Act.id. referencing a previous act (e.g. billable act) in 
     * the SAME message,</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }

}

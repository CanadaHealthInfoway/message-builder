/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt280001ca;

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
 * <p>Previous Billable Act Cross Reference</p>
 * 
 * <p><p>Used to reference a previous act (e.g. billable act) 
 * by including its Act.id. May only be used to reference a 
 * billable act in the SAME message, not for past messages 
 * (this would require adjudicators to keep a lot of 
 * history).</p></p>
 * 
 * <p><p>Used to reference a previous act (e.g. billable act) 
 * by including its Act.id. May only be used to reference a 
 * billable act in the SAME message, not for past messages 
 * (this would require adjudicators to keep a lot of 
 * history).</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT280001CA.CrossReference"})
public class PreviousBillableActCrossReferenceBean extends MessagePartBean implements A_BillableActChoice {

    private static final long serialVersionUID = 20110407L;
    private SET<II, Identifier> actId = new SETImpl<II, Identifier>(IIImpl.class);


    /**
     * <p>) (Act.id.</p>
     * 
     * <p><p>Act.id. referencing a previous act (e.g. billable act) 
     * in the SAME message,</p></p>
     * 
     * <p><p>Used to reference a previous act (e.g. billable act) 
     * by including its Act.id. May only be used to reference a 
     * billable act in the SAME message, not for past messages 
     * (this would require adjudicators to keep a lot of 
     * history).</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getActId() {
        return this.actId.rawSet();
    }

}

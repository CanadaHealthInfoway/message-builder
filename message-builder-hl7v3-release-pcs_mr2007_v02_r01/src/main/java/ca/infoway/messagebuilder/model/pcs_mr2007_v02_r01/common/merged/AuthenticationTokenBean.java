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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"MCAI_MT700210CA.AuthorizationToken","MCAI_MT700211CA.AuthorizationToken","MCAI_MT700212CA.AuthorizationToken","MCAI_MT700220CA.AuthorizationToken","MCAI_MT700221CA.AuthorizationToken","MCAI_MT700222CA.AuthorizationToken","MCAI_MT700230CA.AuthorizationToken","MCAI_MT700231CA.AuthorizationToken","MCAI_MT700232CA.AuthorizationToken","MFMI_MT700711CA.AuthorizationToken","MFMI_MT700751CA.AuthorizationToken","QUQI_MT020000CA.AuthorizationToken","QUQI_MT020002CA.AuthorizationToken"})
public class AuthenticationTokenBean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private II id = new IIImpl();
    private ST text = new STImpl();


    /**
     * <p>AuthorizationTokenAsId</p>
     * 
     * <p>Authorization Token as Id</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>AuthorizationToken</p>
     * 
     * <p>Authorization Token</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }
    public void setText(String text) {
        this.text.setValue(text);
    }

}

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
package ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.cr.prpa_mt101991ab;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.domainvalue.InformantClass;



@Hl7PartTypeMapping({"PRPA_MT101991AB.Informant"})
public class InformantBean extends MessagePartBean {

    private static final long serialVersionUID = 20150328L;
    private CS typeCode = new CSImpl();
    private DocumentEventBean documentEvent;


    /**
     * <p>Relationship: PRPA_MT101991AB.Informant.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"typeCode"})
    public InformantClass getTypeCode() {
        return (InformantClass) this.typeCode.getValue();
    }

    /**
     * <p>Relationship: PRPA_MT101991AB.Informant.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setTypeCode(InformantClass typeCode) {
        this.typeCode.setValue(typeCode);
    }


    /**
     * <p>Relationship: PRPA_MT101991AB.Informant.documentEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"documentEvent"})
    public DocumentEventBean getDocumentEvent() {
        return this.documentEvent;
    }

    /**
     * <p>Relationship: PRPA_MT101991AB.Informant.documentEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setDocumentEvent(DocumentEventBean documentEvent) {
        this.documentEvent = documentEvent;
    }

}

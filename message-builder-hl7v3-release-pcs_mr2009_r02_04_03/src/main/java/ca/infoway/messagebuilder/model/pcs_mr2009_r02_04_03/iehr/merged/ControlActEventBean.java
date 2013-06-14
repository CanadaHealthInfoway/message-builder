/**
 * Copyright 2013 Canada Health, Inc.
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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.ControlActReason;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: AmendmentSummary</p>
 * 
 * <p>REPC_MT500004CA.ControlActEvent: Amendment Summary</p>
 * 
 * <p> <i>Provides context information about the record.</i> 
 * </p>
 * 
 * <p> <i>Identifies information about the most recent change 
 * to the Care Composition including when it was made, by whom 
 * and why.</i> </p>
 * 
 * <p>REPC_MT500003CA.ControlActEvent: Amendment Summary</p>
 * 
 * <p> <i>Provides context information about the record.</i> 
 * </p>
 * 
 * <p> <i>Identifies information about the most recent change 
 * to the Care Composition including when it was made, by whom 
 * and why.</i> </p>
 */
@Hl7PartTypeMapping({"REPC_MT500003CA.ControlActEvent","REPC_MT500004CA.ControlActEvent"})
public class ControlActEventBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private CV reasonCode = new CVImpl();
    private RequestedByBean author;


    /**
     * <p>Business Name: AmendReason</p>
     * 
     * <p>Un-merged Business Name: AmendReason</p>
     * 
     * <p>Relationship: REPC_MT500004CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p> <i>Understanding the reason for the most recent 
     * amendment provides context for the current state of the 
     * record.</i> </p><p> <i> <i>The element uses CWE to allow for 
     * the capture of Amend Reason concepts not presently supported 
     * by the approved code system(s). In this case, the 
     * human-to-human benefit of capturing additional non-coded 
     * values outweighs the penalties of capturing some information 
     * that will not be amenable to searching or categorizing.</i> 
     * </i> </p>
     * 
     * <p> <i>This indicates the reason for most recent amendment 
     * to the record as indicated by the person who made the 
     * change.</i> </p>
     * 
     * <p>Un-merged Business Name: AmendReason</p>
     * 
     * <p>Relationship: REPC_MT500003CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p> <i>Understanding the reason for the most recent 
     * amendment provides context for the current state of the 
     * record.</i> </p><p> <i> <i>The element uses CWE to allow for 
     * the capture of Amend Reason concepts not presently supported 
     * by the approved code system(s). In this case, the 
     * human-to-human benefit of capturing additional non-coded 
     * values outweighs the penalties of capturing some information 
     * that will not be amenable to searching or categorizing.</i> 
     * </i> </p>
     * 
     * <p> <i>This indicates the reason for most recent amendment 
     * to the record as indicated by the person who made the 
     * change.</i> </p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public ControlActReason getReasonCode() {
        return (ControlActReason) this.reasonCode.getValue();
    }

    /**
     * <p>Business Name: AmendReason</p>
     * 
     * <p>Un-merged Business Name: AmendReason</p>
     * 
     * <p>Relationship: REPC_MT500004CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p> <i>Understanding the reason for the most recent 
     * amendment provides context for the current state of the 
     * record.</i> </p><p> <i> <i>The element uses CWE to allow for 
     * the capture of Amend Reason concepts not presently supported 
     * by the approved code system(s). In this case, the 
     * human-to-human benefit of capturing additional non-coded 
     * values outweighs the penalties of capturing some information 
     * that will not be amenable to searching or categorizing.</i> 
     * </i> </p>
     * 
     * <p> <i>This indicates the reason for most recent amendment 
     * to the record as indicated by the person who made the 
     * change.</i> </p>
     * 
     * <p>Un-merged Business Name: AmendReason</p>
     * 
     * <p>Relationship: REPC_MT500003CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p> <i>Understanding the reason for the most recent 
     * amendment provides context for the current state of the 
     * record.</i> </p><p> <i> <i>The element uses CWE to allow for 
     * the capture of Amend Reason concepts not presently supported 
     * by the approved code system(s). In this case, the 
     * human-to-human benefit of capturing additional non-coded 
     * values outweighs the penalties of capturing some information 
     * that will not be amenable to searching or categorizing.</i> 
     * </i> </p>
     * 
     * <p> <i>This indicates the reason for most recent amendment 
     * to the record as indicated by the person who made the 
     * change.</i> </p>
     */
    public void setReasonCode(ControlActReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT500004CA.ControlActEvent.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT500003CA.ControlActEvent.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author"})
    public RequestedByBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT500004CA.ControlActEvent.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT500003CA.ControlActEvent.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthor(RequestedByBean author) {
        this.author = author;
    }

}

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
package ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.lab.polb_mt004100ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Isolate Participation</p>
 * 
 * <p>Associates the isolate specimen and specimen material 
 * (identification of the microorganism) with the grouper 
 * specimen cluster (object).</p>
 */
@Hl7PartTypeMapping({"POLB_MT004100CA.Specimen2"})
public class IsolateParticipationBean extends MessagePartBean {

    private static final long serialVersionUID = 20150901L;
    private IsolateBean isolate;


    /**
     * <p>Relationship: POLB_MT004100CA.Specimen2.isolate</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"isolate"})
    public IsolateBean getIsolate() {
        return this.isolate;
    }

    /**
     * <p>Relationship: POLB_MT004100CA.Specimen2.isolate</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setIsolate(IsolateBean isolate) {
        this.isolate = isolate;
    }

}

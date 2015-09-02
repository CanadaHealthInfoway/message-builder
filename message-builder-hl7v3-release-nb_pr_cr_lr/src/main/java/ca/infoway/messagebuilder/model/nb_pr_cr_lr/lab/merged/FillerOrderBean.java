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
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.lab.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActClass;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: FillerOrder</p>
 * 
 * <p>POLB_MT004200NB.ActPromise: Filler Order</p>
 * 
 * <p>The filler order communiates the intended testing (as 
 * opposted to the requested tests).</p>
 * 
 * <p>POLB_MT004000NB.ActPromise: Filler Order</p>
 * 
 * <p>The filler order communiates the intended testing (as 
 * opposed to the requested tests).</p>
 * 
 * <p>POLB_MT004100NB.ActPromise: Filler Order</p>
 * 
 * <p>The filler order communiates the intended testing (as 
 * opposted to the requested tests).</p>
 */
@Hl7PartTypeMapping({"POLB_MT004000NB.ActPromise","POLB_MT004100NB.ActPromise","POLB_MT004200NB.ActPromise"})
public class FillerOrderBean extends MessagePartBean implements FulfillmentChoice {

    private static final long serialVersionUID = 20150902L;
    private CS classCode = new CSImpl();
    private II id = new IIImpl();


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POLB_MT004000NB.ActPromise.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POLB_MT004200NB.ActPromise.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POLB_MT004100NB.ActPromise.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"classCode"})
    public ActClass getClassCode() {
        return (ActClass) this.classCode.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POLB_MT004000NB.ActPromise.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POLB_MT004200NB.ActPromise.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POLB_MT004100NB.ActPromise.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setClassCode(ActClass classCode) {
        this.classCode.setValue(classCode);
    }


    /**
     * <p>Un-merged Business Name: FillerOrderIdentifier</p>
     * 
     * <p>Relationship: POLB_MT004000NB.ActPromise.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The promise id is mandatory as it is necessary to create 
     * the association (act relationship).</p>
     * 
     * <p>The unique identfier for the filler order or promise.</p>
     * 
     * <p>Un-merged Business Name: FillerOrderNumber</p>
     * 
     * <p>Relationship: POLB_MT004200NB.ActPromise.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The unique identfier for the filler order or promise.</p>
     * 
     * <p>Un-merged Business Name: FillerOrderNumber</p>
     * 
     * <p>Relationship: POLB_MT004100NB.ActPromise.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The unique identfier for the filler order or promise.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Un-merged Business Name: FillerOrderIdentifier</p>
     * 
     * <p>Relationship: POLB_MT004000NB.ActPromise.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The promise id is mandatory as it is necessary to create 
     * the association (act relationship).</p>
     * 
     * <p>The unique identfier for the filler order or promise.</p>
     * 
     * <p>Un-merged Business Name: FillerOrderNumber</p>
     * 
     * <p>Relationship: POLB_MT004200NB.ActPromise.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The unique identfier for the filler order or promise.</p>
     * 
     * <p>Un-merged Business Name: FillerOrderNumber</p>
     * 
     * <p>Relationship: POLB_MT004100NB.ActPromise.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The unique identfier for the filler order or promise.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }

}

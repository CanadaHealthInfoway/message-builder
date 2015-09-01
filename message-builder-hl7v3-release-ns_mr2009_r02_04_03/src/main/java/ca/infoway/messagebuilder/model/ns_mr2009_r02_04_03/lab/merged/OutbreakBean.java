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
package ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.lab.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Outbreak</p>
 * 
 * <p>POLB_MT004100CA.OutbreakEvent: Outbreak</p>
 * 
 * <p>Used as an indicator to public health that this lab 
 * result may indicate the subject is a part of an outbreak. 
 * This does not confirm that lab result is an outbreak 
 * subject, only that the potential exists and public health 
 * should disposition.</p>
 * 
 * <p>Identifies an outbreak which the reporting lab suspects 
 * this result might be a part of.</p>
 * 
 * <p>POLB_MT004200CA.OutbreakEvent: Outbreak</p>
 * 
 * <p>Used as an indicator to public health that this lab 
 * result may indicate the subject is a part of an outbreak. 
 * This does not confirm that lab result is an outbreak 
 * subject, only that the potential exists and public health 
 * should disposition.</p>
 * 
 * <p>Identifies an outbreak which the reporting lab suspects 
 * this result might be a part of.</p>
 * 
 * <p>POLB_MT004000CA.OutbreakEvent: Outbreak</p>
 * 
 * <p>Used as an indicator to public health that this lab 
 * result may indicate the subject is a part of an outbreak. 
 * This does not confirm that lab result is an outbreak 
 * subject, only that the potential exists and public health 
 * should disposition.</p>
 * 
 * <p>Identifies an outbreak which the reporting lab suspects 
 * this result might be a part of.</p>
 */
@Hl7PartTypeMapping({"POLB_MT001000CA.OutbreakEvent","POLB_MT001010CA.OutbreakEvent","POLB_MT001999CA.OutbreakEvent","POLB_MT002000CA.OutbreakEvent","POLB_MT004000CA.OutbreakEvent","POLB_MT004100CA.OutbreakEvent","POLB_MT004200CA.OutbreakEvent"})
public class OutbreakBean extends MessagePartBean {

    private static final long serialVersionUID = 20150901L;
    private II id = new IIImpl();


    /**
     * <p>Business Name: OutbreakIdentifier</p>
     * 
     * <p>Un-merged Business Name: OutbreakIdentifier</p>
     * 
     * <p>Relationship: POLB_MT002000CA.OutbreakEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: OutbreakIdentifier</p>
     * 
     * <p>Relationship: POLB_MT004100CA.OutbreakEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used as an indicator to public health that this lab 
     * result may indicate the subject is a part of an outbreak. 
     * This does not confirm that lab result is an outbreak 
     * subject, only that the potential exists and public health 
     * should disposition.</p>
     * 
     * <p>Identifies an outbreak which the reporting lab suspects 
     * this result might be a part of.</p>
     * 
     * <p>Un-merged Business Name: OutbreakIdentifier</p>
     * 
     * <p>Relationship: POLB_MT001010CA.OutbreakEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows public health to identify an outbreak for which 
     * this test is being conducted.</p>
     * 
     * <p>Un-merged Business Name: OutbreakIdentifier</p>
     * 
     * <p>Relationship: POLB_MT004200CA.OutbreakEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used as an indicator to public health that this lab 
     * result may indicate the subject is a part of an outbreak. 
     * This does not confirm that lab result is an outbreak 
     * subject, only that the potential exists and public health 
     * should disposition.</p>
     * 
     * <p>Identifies an outbreak which the reporting lab suspects 
     * this result might be a part of.</p>
     * 
     * <p>Un-merged Business Name: OutbreakIdentifier</p>
     * 
     * <p>Relationship: POLB_MT001000CA.OutbreakEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows public health to identify an outbreak for which 
     * this test is being conducted.</p>
     * 
     * <p>Un-merged Business Name: OutbreakIdentifier</p>
     * 
     * <p>Relationship: POLB_MT004000CA.OutbreakEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used as an indicator to public health that this lab 
     * result may indicate the subject is a part of an outbreak. 
     * This does not confirm that lab result is an outbreak 
     * subject, only that the potential exists and public health 
     * should disposition.</p>
     * 
     * <p>Identifies an outbreak which the reporting lab suspects 
     * this result might be a part of.</p>
     * 
     * <p>Un-merged Business Name: OutbreakIdentifier</p>
     * 
     * <p>Relationship: POLB_MT001999CA.OutbreakEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows public health to identify an outbreak for which 
     * this test is being conducted.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: OutbreakIdentifier</p>
     * 
     * <p>Un-merged Business Name: OutbreakIdentifier</p>
     * 
     * <p>Relationship: POLB_MT002000CA.OutbreakEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: OutbreakIdentifier</p>
     * 
     * <p>Relationship: POLB_MT004100CA.OutbreakEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used as an indicator to public health that this lab 
     * result may indicate the subject is a part of an outbreak. 
     * This does not confirm that lab result is an outbreak 
     * subject, only that the potential exists and public health 
     * should disposition.</p>
     * 
     * <p>Identifies an outbreak which the reporting lab suspects 
     * this result might be a part of.</p>
     * 
     * <p>Un-merged Business Name: OutbreakIdentifier</p>
     * 
     * <p>Relationship: POLB_MT001010CA.OutbreakEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows public health to identify an outbreak for which 
     * this test is being conducted.</p>
     * 
     * <p>Un-merged Business Name: OutbreakIdentifier</p>
     * 
     * <p>Relationship: POLB_MT004200CA.OutbreakEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used as an indicator to public health that this lab 
     * result may indicate the subject is a part of an outbreak. 
     * This does not confirm that lab result is an outbreak 
     * subject, only that the potential exists and public health 
     * should disposition.</p>
     * 
     * <p>Identifies an outbreak which the reporting lab suspects 
     * this result might be a part of.</p>
     * 
     * <p>Un-merged Business Name: OutbreakIdentifier</p>
     * 
     * <p>Relationship: POLB_MT001000CA.OutbreakEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows public health to identify an outbreak for which 
     * this test is being conducted.</p>
     * 
     * <p>Un-merged Business Name: OutbreakIdentifier</p>
     * 
     * <p>Relationship: POLB_MT004000CA.OutbreakEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used as an indicator to public health that this lab 
     * result may indicate the subject is a part of an outbreak. 
     * This does not confirm that lab result is an outbreak 
     * subject, only that the potential exists and public health 
     * should disposition.</p>
     * 
     * <p>Identifies an outbreak which the reporting lab suspects 
     * this result might be a part of.</p>
     * 
     * <p>Un-merged Business Name: OutbreakIdentifier</p>
     * 
     * <p>Relationship: POLB_MT001999CA.OutbreakEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows public health to identify an outbreak for which 
     * this test is being conducted.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }

}

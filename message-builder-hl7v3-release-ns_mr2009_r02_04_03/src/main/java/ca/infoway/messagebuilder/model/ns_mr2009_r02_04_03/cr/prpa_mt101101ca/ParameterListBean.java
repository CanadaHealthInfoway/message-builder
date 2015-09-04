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
package ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.cr.prpa_mt101101ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>either a Public or Business Identifier must be supplied 
 * to support this Query</p>
 * 
 * <p>Entry Point</p>
 */
@Hl7PartTypeMapping({"PRPA_MT101101CA.ParameterList"})
@Hl7RootType
public class ParameterListBean extends MessagePartBean {

    private static final long serialVersionUID = 20150901L;
    private II clientIDBusValue = new IIImpl();
    private II clientIDPubValue = new IIImpl();


    /**
     * <p>Business Name: Client Healthcare Identification Number</p>
     * 
     * <p>Relationship: PRPA_MT101101CA.ClientIDBus.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports unique identification of the 
     * client and is a public identifier. E.G. Internal Business 
     * ID</p>
     * 
     * <p>At least 1 client identifier must be present in the 
     * message</p><p>Text constraint exists on the model to support 
     * non mandatory requirements either a Public or Business 
     * Identifier must be supplied to support this Query.</p>
     * 
     * <p>This identification attribute supports capture of a 
     * healthcare identifier specific to the client. This 
     * identifier may be assigned jurisdictionally or by care 
     * facility.</p>
     */
    @Hl7XmlMapping({"clientIDBus/value"})
    public Identifier getClientIDBusValue() {
        return this.clientIDBusValue.getValue();
    }

    /**
     * <p>Business Name: Client Healthcare Identification Number</p>
     * 
     * <p>Relationship: PRPA_MT101101CA.ClientIDBus.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports unique identification of the 
     * client and is a public identifier. E.G. Internal Business 
     * ID</p>
     * 
     * <p>At least 1 client identifier must be present in the 
     * message</p><p>Text constraint exists on the model to support 
     * non mandatory requirements either a Public or Business 
     * Identifier must be supplied to support this Query.</p>
     * 
     * <p>This identification attribute supports capture of a 
     * healthcare identifier specific to the client. This 
     * identifier may be assigned jurisdictionally or by care 
     * facility.</p>
     */
    public void setClientIDBusValue(Identifier clientIDBusValue) {
        this.clientIDBusValue.setValue(clientIDBusValue);
    }


    /**
     * <p>Business Name: Client Healthcare Identification Number</p>
     * 
     * <p>Relationship: PRPA_MT101101CA.ClientIDPub.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports unique identification of the 
     * client and is a public identifier. E.G. Provincial Health 
     * Care Number</p>
     * 
     * <p>At least 1 client identifier must be present in the 
     * message</p><p>Text constraint exists on the model to support 
     * non mandatory requirements either a Public or Business 
     * Identifier must be supplied to support this Query.</p>
     * 
     * <p>This identification attribute supports capture of a 
     * healthcare identifier specific to the client. This 
     * identifier may be assigned jurisdictionally or by care 
     * facility.</p>
     */
    @Hl7XmlMapping({"clientIDPub/value"})
    public Identifier getClientIDPubValue() {
        return this.clientIDPubValue.getValue();
    }

    /**
     * <p>Business Name: Client Healthcare Identification Number</p>
     * 
     * <p>Relationship: PRPA_MT101101CA.ClientIDPub.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports unique identification of the 
     * client and is a public identifier. E.G. Provincial Health 
     * Care Number</p>
     * 
     * <p>At least 1 client identifier must be present in the 
     * message</p><p>Text constraint exists on the model to support 
     * non mandatory requirements either a Public or Business 
     * Identifier must be supplied to support this Query.</p>
     * 
     * <p>This identification attribute supports capture of a 
     * healthcare identifier specific to the client. This 
     * identifier may be assigned jurisdictionally or by care 
     * facility.</p>
     */
    public void setClientIDPubValue(Identifier clientIDPubValue) {
        this.clientIDPubValue.setValue(clientIDPubValue);
    }

}
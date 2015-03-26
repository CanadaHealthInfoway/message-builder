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
package ca.infoway.messagebuilder.model.ab_r02_04_03_imm.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: AuthenticationToken</p>
 * 
 * <p>QUQI_MT020002AB.AuthorizationToken: Authentication Token</p>
 * 
 * <p>If specified, then the concepts covered by the token must 
 * not be specified (i.e. at least one participation of author, 
 * dataEnterer, responsibleParty, location and 
 * dataEntryLocation must not be specified)</p>
 * 
 * <p>Only one of Id or Text must be specified.</p>
 * 
 * <p>Conveys information related to the individuals and/or 
 * locations involved with the action in situations where the 
 * authentication happens on a one-time basis rather than on a 
 * per-message basis.</p>
 * 
 * <p>Conveys an authentication token associated with the 
 * event.</p><p>The token may represent one or all of the 
 * following concepts: author, dataEnterer, responsibleParty, 
 * location and dataEntryLocation.</p>
 * 
 * <p>MCAI_MT700211CA.AuthorizationToken: Authentication Token</p>
 * 
 * <p>If specified, then the concepts covered by the token must 
 * not be specified (i.e. at least one participation of author, 
 * dataEnterer, responsibleParty, location and 
 * dataEntryLocation must not be specified)</p>
 * 
 * <p>Only one of Id or Text must be specified.</p>
 * 
 * <p>Conveys information related to the individuals and/or 
 * locations involved with the action in situations where the 
 * authentication happens on a one-time basis rather than on a 
 * per-message basis.</p>
 * 
 * <p>Conveys an authentication token associated with the 
 * event.</p><p>The token may represent one or all of the 
 * following concepts: author, dataEnterer, responsibleParty, 
 * location and dataEntryLocation.</p>
 * 
 * <p>QUQI_MT020000AB.AuthorizationToken: Authentication Token</p>
 * 
 * <p>If specified, then the concepts covered by the token must 
 * not be specified (i.e. at least one participation of author, 
 * dataEnterer, responsibleParty, location and 
 * dataEntryLocation must not be specified)</p>
 * 
 * <p>Only one of Id or Text must be specified.</p>
 * 
 * <p>Conveys information related to the individuals and/or 
 * locations involved with the action in situations where the 
 * authentication happens on a one-time basis rather than on a 
 * per-message basis.</p>
 * 
 * <p>Conveys an authentication token associated with the 
 * event.</p><p>The token may represent one or all of the 
 * following concepts: author, dataEnterer, responsibleParty, 
 * location and dataEntryLocation.</p>
 */
@Hl7PartTypeMapping({"MCAI_MT700211CA.AuthorizationToken","QUQI_MT020000AB.AuthorizationToken","QUQI_MT020002AB.AuthorizationToken"})
public class AuthenticationTokenBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private II id = new IIImpl();
    private ST text = new STImpl();


    /**
     * <p>Business Name: AuthorizationTokenAsId</p>
     * 
     * <p>Un-merged Business Name: AuthorizationTokenAsId</p>
     * 
     * <p>Relationship: QUQI_MT020002AB.AuthorizationToken.id</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>GUIDs are an effective way of conveying a temporary 
     * authentication token</p>
     * 
     * <p>An authorization token expressed as a GUID.</p><p>The 
     * Authorization token may represent the concepts of author, 
     * data enterer, supervisor (responsible party), responsible 
     * location and/or data entry location.</p>
     * 
     * <p>Un-merged Business Name: AuthorizationTokenAsId</p>
     * 
     * <p>Relationship: MCAI_MT700211CA.AuthorizationToken.id</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>GUIDs are an effective way of conveying a temporary 
     * authentication token</p>
     * 
     * <p>An authorization token expressed as a GUID.</p><p>The 
     * Authorization token may represent the concepts of author, 
     * data enterer, supervisor (responsible party), responsible 
     * location and/or data entry location.</p>
     * 
     * <p>Un-merged Business Name: AuthorizationTokenAsId</p>
     * 
     * <p>Relationship: QUQI_MT020000AB.AuthorizationToken.id</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>GUIDs are an effective way of conveying a temporary 
     * authentication token</p>
     * 
     * <p>An authorization token expressed as a GUID.</p><p>The 
     * Authorization token may represent the concepts of author, 
     * data enterer, supervisor (responsible party), responsible 
     * location and/or data entry location.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: AuthorizationTokenAsId</p>
     * 
     * <p>Un-merged Business Name: AuthorizationTokenAsId</p>
     * 
     * <p>Relationship: QUQI_MT020002AB.AuthorizationToken.id</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>GUIDs are an effective way of conveying a temporary 
     * authentication token</p>
     * 
     * <p>An authorization token expressed as a GUID.</p><p>The 
     * Authorization token may represent the concepts of author, 
     * data enterer, supervisor (responsible party), responsible 
     * location and/or data entry location.</p>
     * 
     * <p>Un-merged Business Name: AuthorizationTokenAsId</p>
     * 
     * <p>Relationship: MCAI_MT700211CA.AuthorizationToken.id</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>GUIDs are an effective way of conveying a temporary 
     * authentication token</p>
     * 
     * <p>An authorization token expressed as a GUID.</p><p>The 
     * Authorization token may represent the concepts of author, 
     * data enterer, supervisor (responsible party), responsible 
     * location and/or data entry location.</p>
     * 
     * <p>Un-merged Business Name: AuthorizationTokenAsId</p>
     * 
     * <p>Relationship: QUQI_MT020000AB.AuthorizationToken.id</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>GUIDs are an effective way of conveying a temporary 
     * authentication token</p>
     * 
     * <p>An authorization token expressed as a GUID.</p><p>The 
     * Authorization token may represent the concepts of author, 
     * data enterer, supervisor (responsible party), responsible 
     * location and/or data entry location.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: AuthorizationToken</p>
     * 
     * <p>Un-merged Business Name: AuthorizationToken</p>
     * 
     * <p>Relationship: QUQI_MT020002AB.AuthorizationToken.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Some systems may choose to use a hashcode or other 
     * approach to token construction.</p>
     * 
     * <p>An authentication token expressed as a non-GUID 
     * string.</p><p>The Authorization token may represent the 
     * concepts of author, data enterer, supervisor (responsible 
     * party), responsible location and/or data entry location.</p>
     * 
     * <p>Un-merged Business Name: AuthorizationToken</p>
     * 
     * <p>Relationship: MCAI_MT700211CA.AuthorizationToken.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Some systems may choose to use a hashcode or other 
     * approach to token construction.</p>
     * 
     * <p>An authentication token expressed as a non-GUID 
     * string.</p><p>The Authorization token may represent the 
     * concepts of author, data enterer, supervisor (responsible 
     * party), responsible location and/or data entry location.</p>
     * 
     * <p>Un-merged Business Name: AuthorizationToken</p>
     * 
     * <p>Relationship: QUQI_MT020000AB.AuthorizationToken.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Some systems may choose to use a hashcode or other 
     * approach to token construction.</p>
     * 
     * <p>An authentication token expressed as a non-GUID 
     * string.</p><p>The Authorization token may represent the 
     * concepts of author, data enterer, supervisor (responsible 
     * party), responsible location and/or data entry location.</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: AuthorizationToken</p>
     * 
     * <p>Un-merged Business Name: AuthorizationToken</p>
     * 
     * <p>Relationship: QUQI_MT020002AB.AuthorizationToken.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Some systems may choose to use a hashcode or other 
     * approach to token construction.</p>
     * 
     * <p>An authentication token expressed as a non-GUID 
     * string.</p><p>The Authorization token may represent the 
     * concepts of author, data enterer, supervisor (responsible 
     * party), responsible location and/or data entry location.</p>
     * 
     * <p>Un-merged Business Name: AuthorizationToken</p>
     * 
     * <p>Relationship: MCAI_MT700211CA.AuthorizationToken.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Some systems may choose to use a hashcode or other 
     * approach to token construction.</p>
     * 
     * <p>An authentication token expressed as a non-GUID 
     * string.</p><p>The Authorization token may represent the 
     * concepts of author, data enterer, supervisor (responsible 
     * party), responsible location and/or data entry location.</p>
     * 
     * <p>Un-merged Business Name: AuthorizationToken</p>
     * 
     * <p>Relationship: QUQI_MT020000AB.AuthorizationToken.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Some systems may choose to use a hashcode or other 
     * approach to token construction.</p>
     * 
     * <p>An authentication token expressed as a non-GUID 
     * string.</p><p>The Authorization token may represent the 
     * concepts of author, data enterer, supervisor (responsible 
     * party), responsible location and/or data entry location.</p>
     */
    public void setText(String text) {
        this.text.setValue(text);
    }

}

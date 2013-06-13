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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt910108ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.x_SimplePersonalRelationship;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Set;



/**
 * <p>Business Name: Related Person</p>
 * 
 * <p>Important for tracking source of information for decision 
 * making and other actions taken on behalf of a patient.</p>
 * 
 * <p>Describes a person (other than a health-care provider or 
 * employee) who is providing information and making decision 
 * on behalf of the patient, in relation to the delivery of 
 * healthcare for the patient. E.g. Patient's mother. Also used 
 * with a relationship of &quot;self&quot; when the patient 
 * themselves is providing the care.</p><p>Represents 
 * information retrieved from the client registry.</p>
 */
@Hl7PartTypeMapping({"COCT_MT910108CA.PersonalRelationship"})
@Hl7RootType
public class RelatedPersonBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt911108ca.ActingPerson {

    private static final long serialVersionUID = 20130613L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private PN relationshipHolderName = new PNImpl();
    private SET<TEL, TelecommunicationAddress> relationshipHolderTelecom = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private AD relationshipHolderAddr = new ADImpl();


    /**
     * <p>Business Name: B:Related Person Identifier</p>
     * 
     * <p>Relationship: COCT_MT910108CA.PersonalRelationship.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>ZPB1.6 (Root)</p>
     * 
     * <p>ZPB1.7 (EXtension)</p>
     * 
     * <p>ZPB2.8 (Root)</p>
     * 
     * <p>ZPB2.9 (EXtension)</p>
     * 
     * <p>ZPB3.11 (Root)</p>
     * 
     * <p>ZPB3.12 (EXtension)</p>
     * 
     * <p>ZPB3.18 (Root)</p>
     * 
     * <p>ZPB3.19 (EXtension)</p>
     * 
     * <p>D60 (Root)</p>
     * 
     * <p>D61 (Extension)</p>
     * 
     * <p>D76</p>
     * 
     * <p>PVD.020-01 (Extension)</p>
     * 
     * <p>PVD.020-02 (Root)</p>
     * 
     * <p>PharmacyProvider.444-E9 (Extension)</p>
     * 
     * <p>PharmacyProvider.465-E7 (Root)</p>
     * 
     * <p>Prescriber.446-EZ (Extension)</p>
     * 
     * <p>PharmacyProvider.411-DB (Root)</p>
     * 
     * <p>ZDP.18.1 (Extension)</p>
     * 
     * <p>ZDP.18.2 (Root)</p>
     * 
     * <p>ZDP.19.1 (Extension)</p>
     * 
     * <p>ZDP.19.2 (Root)</p>
     * 
     * <p>ZDP.10.1 (Extension)</p>
     * 
     * <p>ZDP.10.2 (Root)</p>
     * 
     * <p>Provider.PproviderExternalKey (Extension)</p>
     * 
     * <p>Provider.providerKey (Extension)</p>
     * 
     * <p>Provider.wellnetProviderId (Extension)</p>
     * 
     * <p>ProviderRegistration.Identifier (Extension)</p>
     * 
     * <p>ProviderRegistration.IdentifierDomain (part of 
     * Extension)</p>
     * 
     * <p>ProviderRegistrationjurisdiction (part of Extension)</p>
     * 
     * <p>Allows a person to be uniquely referred to and retrieved 
     * from the client registry and is therefore mandatory.</p>
     * 
     * <p>A unique identifier for the related person (as found in a 
     * client registry).</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: B:Related Person Identifier</p>
     * 
     * <p>Relationship: COCT_MT910108CA.PersonalRelationship.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>ZPB1.6 (Root)</p>
     * 
     * <p>ZPB1.7 (EXtension)</p>
     * 
     * <p>ZPB2.8 (Root)</p>
     * 
     * <p>ZPB2.9 (EXtension)</p>
     * 
     * <p>ZPB3.11 (Root)</p>
     * 
     * <p>ZPB3.12 (EXtension)</p>
     * 
     * <p>ZPB3.18 (Root)</p>
     * 
     * <p>ZPB3.19 (EXtension)</p>
     * 
     * <p>D60 (Root)</p>
     * 
     * <p>D61 (Extension)</p>
     * 
     * <p>D76</p>
     * 
     * <p>PVD.020-01 (Extension)</p>
     * 
     * <p>PVD.020-02 (Root)</p>
     * 
     * <p>PharmacyProvider.444-E9 (Extension)</p>
     * 
     * <p>PharmacyProvider.465-E7 (Root)</p>
     * 
     * <p>Prescriber.446-EZ (Extension)</p>
     * 
     * <p>PharmacyProvider.411-DB (Root)</p>
     * 
     * <p>ZDP.18.1 (Extension)</p>
     * 
     * <p>ZDP.18.2 (Root)</p>
     * 
     * <p>ZDP.19.1 (Extension)</p>
     * 
     * <p>ZDP.19.2 (Root)</p>
     * 
     * <p>ZDP.10.1 (Extension)</p>
     * 
     * <p>ZDP.10.2 (Root)</p>
     * 
     * <p>Provider.PproviderExternalKey (Extension)</p>
     * 
     * <p>Provider.providerKey (Extension)</p>
     * 
     * <p>Provider.wellnetProviderId (Extension)</p>
     * 
     * <p>ProviderRegistration.Identifier (Extension)</p>
     * 
     * <p>ProviderRegistration.IdentifierDomain (part of 
     * Extension)</p>
     * 
     * <p>ProviderRegistrationjurisdiction (part of Extension)</p>
     * 
     * <p>Allows a person to be uniquely referred to and retrieved 
     * from the client registry and is therefore mandatory.</p>
     * 
     * <p>A unique identifier for the related person (as found in a 
     * client registry).</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: C:Responsible Person Type</p>
     * 
     * <p>Relationship: COCT_MT910108CA.PersonalRelationship.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Essential for understanding the authority to perform 
     * certain actions as well as the context of the information 
     * and is therefore mandatory. E.g. A 'friend' may not be able 
     * to make consent decisions, but may be able to pick up 
     * dispenses.</p><p> <i>The element uses CWE to allow for the 
     * capture of Responsible Person Type concepts not presently 
     * supported by the approved code system(s). In this case, the 
     * human-to-human benefit of capturing additional non-coded 
     * values outweighs the penalties of capturing some information 
     * that will not be amenable to searching or categorizing.</i> 
     * </p>
     * 
     * <p>EPHS:this cmet is used for self-reports as well as 
     * reports by other related parties</p>
     * 
     * <p>A coded value indicating how the person is related to the 
     * patient. If the code is &quot;SELF&quot;, it indicates that 
     * the action was performed by the patient themselves.</p>
     */
    @Hl7XmlMapping({"code"})
    public x_SimplePersonalRelationship getCode() {
        return (x_SimplePersonalRelationship) this.code.getValue();
    }

    /**
     * <p>Business Name: C:Responsible Person Type</p>
     * 
     * <p>Relationship: COCT_MT910108CA.PersonalRelationship.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Essential for understanding the authority to perform 
     * certain actions as well as the context of the information 
     * and is therefore mandatory. E.g. A 'friend' may not be able 
     * to make consent decisions, but may be able to pick up 
     * dispenses.</p><p> <i>The element uses CWE to allow for the 
     * capture of Responsible Person Type concepts not presently 
     * supported by the approved code system(s). In this case, the 
     * human-to-human benefit of capturing additional non-coded 
     * values outweighs the penalties of capturing some information 
     * that will not be amenable to searching or categorizing.</i> 
     * </p>
     * 
     * <p>EPHS:this cmet is used for self-reports as well as 
     * reports by other related parties</p>
     * 
     * <p>A coded value indicating how the person is related to the 
     * patient. If the code is &quot;SELF&quot;, it indicates that 
     * the action was performed by the patient themselves.</p>
     */
    public void setCode(x_SimplePersonalRelationship code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: A:Related Person Name</p>
     * 
     * <p>Relationship: COCT_MT910108CA.Person.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>ZPB3.13</p>
     * 
     * <p>PVD.050-01 (PartType = Family)</p>
     * 
     * <p>PVD.050-02 (PartType = Given - 1st rep)</p>
     * 
     * <p>PVD.050-03 PartType = Given - any rep other than the 
     * first)</p>
     * 
     * <p>PVD.050-04 (PartType = Suffix)</p>
     * 
     * <p>PVD.050-05 (PartType = Prefix)</p>
     * 
     * <p>PVD.100-01 (PartType = Family; author/performer when 
     * supervisor is also specified)</p>
     * 
     * <p>PVD.100-02 (PartType = Given - 1st rep; author/performer 
     * when supervisor is also specified )</p>
     * 
     * <p>PVD.100-03 PartType = Given - any rep other than the 
     * first; author/performer when supervisor is also 
     * specified)</p>
     * 
     * <p>PVD.100-04 (PartType = Suffix; author/performer when 
     * supervisor is also specified)</p>
     * 
     * <p>PVD.100-05 (PartType = Prefix; author/performer when 
     * supervisor is also specified)</p>
     * 
     * <p>D1a</p>
     * 
     * <p>Practitioner's Name</p>
     * 
     * <p>04.03</p>
     * 
     * <p>Prescriber.427-DR</p>
     * 
     * <p>Prescribing Physician Name</p>
     * 
     * <p>ZPS.18.3</p>
     * 
     * <p>ZPS.18.4</p>
     * 
     * <p>ZPS.18.5</p>
     * 
     * <p>ZPS.19.3</p>
     * 
     * <p>ZPS.19.4</p>
     * 
     * <p>ZPS.19.5</p>
     * 
     * <p>ZPS.10.3</p>
     * 
     * <p>ZPS.10.4</p>
     * 
     * <p>ZPS.10.5</p>
     * 
     * <p>ProviderPreviewInfo.ProviderName</p>
     * 
     * <p>Used when contacting or addressing the responsible 
     * person. Because this will be the principle means of 
     * identifying the responsible person, it is mandatory.</p>
     * 
     * <p>The name by which the responsible person is known</p>
     */
    @Hl7XmlMapping({"relationshipHolder/name"})
    public PersonName getRelationshipHolderName() {
        return this.relationshipHolderName.getValue();
    }

    /**
     * <p>Business Name: A:Related Person Name</p>
     * 
     * <p>Relationship: COCT_MT910108CA.Person.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>ZPB3.13</p>
     * 
     * <p>PVD.050-01 (PartType = Family)</p>
     * 
     * <p>PVD.050-02 (PartType = Given - 1st rep)</p>
     * 
     * <p>PVD.050-03 PartType = Given - any rep other than the 
     * first)</p>
     * 
     * <p>PVD.050-04 (PartType = Suffix)</p>
     * 
     * <p>PVD.050-05 (PartType = Prefix)</p>
     * 
     * <p>PVD.100-01 (PartType = Family; author/performer when 
     * supervisor is also specified)</p>
     * 
     * <p>PVD.100-02 (PartType = Given - 1st rep; author/performer 
     * when supervisor is also specified )</p>
     * 
     * <p>PVD.100-03 PartType = Given - any rep other than the 
     * first; author/performer when supervisor is also 
     * specified)</p>
     * 
     * <p>PVD.100-04 (PartType = Suffix; author/performer when 
     * supervisor is also specified)</p>
     * 
     * <p>PVD.100-05 (PartType = Prefix; author/performer when 
     * supervisor is also specified)</p>
     * 
     * <p>D1a</p>
     * 
     * <p>Practitioner's Name</p>
     * 
     * <p>04.03</p>
     * 
     * <p>Prescriber.427-DR</p>
     * 
     * <p>Prescribing Physician Name</p>
     * 
     * <p>ZPS.18.3</p>
     * 
     * <p>ZPS.18.4</p>
     * 
     * <p>ZPS.18.5</p>
     * 
     * <p>ZPS.19.3</p>
     * 
     * <p>ZPS.19.4</p>
     * 
     * <p>ZPS.19.5</p>
     * 
     * <p>ZPS.10.3</p>
     * 
     * <p>ZPS.10.4</p>
     * 
     * <p>ZPS.10.5</p>
     * 
     * <p>ProviderPreviewInfo.ProviderName</p>
     * 
     * <p>Used when contacting or addressing the responsible 
     * person. Because this will be the principle means of 
     * identifying the responsible person, it is mandatory.</p>
     * 
     * <p>The name by which the responsible person is known</p>
     */
    public void setRelationshipHolderName(PersonName relationshipHolderName) {
        this.relationshipHolderName.setValue(relationshipHolderName);
    }


    /**
     * <p>Business Name: E:Related Person Phones and Emails</p>
     * 
     * <p>Relationship: COCT_MT910108CA.Person.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     * 
     * <p>Used to contact the related person.</p>
     * 
     * <p>The phone number(s) and email address(s) by which a 
     * related person may be contacted as known by the client 
     * registry.</p>
     */
    @Hl7XmlMapping({"relationshipHolder/telecom"})
    public Set<TelecommunicationAddress> getRelationshipHolderTelecom() {
        return this.relationshipHolderTelecom.rawSet();
    }


    /**
     * <p>Business Name: D:Related Person Address</p>
     * 
     * <p>Relationship: COCT_MT910108CA.Person.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Used to contact the related person.</p>
     * 
     * <p>The mail and/or physical address associated with a 
     * related person as known by the client registry.</p>
     */
    @Hl7XmlMapping({"relationshipHolder/addr"})
    public PostalAddress getRelationshipHolderAddr() {
        return this.relationshipHolderAddr.getValue();
    }

    /**
     * <p>Business Name: D:Related Person Address</p>
     * 
     * <p>Relationship: COCT_MT910108CA.Person.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Used to contact the related person.</p>
     * 
     * <p>The mail and/or physical address associated with a 
     * related person as known by the client registry.</p>
     */
    public void setRelationshipHolderAddr(PostalAddress relationshipHolderAddr) {
        this.relationshipHolderAddr.setValue(relationshipHolderAddr);
    }

}

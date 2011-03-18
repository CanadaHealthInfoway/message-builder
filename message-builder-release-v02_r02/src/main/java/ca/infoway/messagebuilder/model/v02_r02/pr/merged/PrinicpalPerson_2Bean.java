/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r02.pr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.v02_r02.merged.LanguageCommunicationBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>PrinicpalPerson</p>
 * 
 * <p>PRPM_MT306051CA.PrincipalPerson: Prinicpal Person</p>
 * 
 * <p><p>Identification of playing entity is required (0..1) to 
 * support the case in which information directly related to 
 * the playing party is not needed.</p></p>
 * 
 * <p><p>Provides additional information about the person 
 * playing the role of Healthcare Provider</p></p>
 * 
 * <p>PRPM_MT306011CA.PrincipalPerson: Prinicpal Person</p>
 * 
 * <p><p>Identification of playing entity is required (0..1) to 
 * support the case in which information directly related to 
 * the playing party is not needed.</p></p>
 * 
 * <p><p>Provides additional information about the person 
 * playing the role of Healthcare Provider</p></p>
 */
@Hl7PartTypeMapping({"PRPM_MT306011CA.PrincipalPerson","PRPM_MT306051CA.PrincipalPerson"})
public class PrinicpalPerson_2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private SET<II, Identifier> principalPersonAggregateIdentifier = new SETImpl<II, Identifier>(IIImpl.class);
    private LIST<PN, PersonName> principalPersonName = new LISTImpl<PN, PersonName>(PNImpl.class);
    private CV principalPersonGender = new CVImpl();
    private BL principalPersonDeceasedIndicator = new BLImpl();
    private List<LanguageCommunicationBean> languageCommunication = new ArrayList<LanguageCommunicationBean>();
    private TS principalPersonDateOfBirth = new TSImpl();
    private AD birthplaceAddress = new ADImpl();
    private TS principalPersonDeceasedDate = new TSImpl();


    /**
     * <p>PrincipalPersonAggregateIdentifier</p>
     * 
     * <p>Principal Person Aggregate Identifier</p>
     * 
     * <p><p>A unique identifier for the person who may play 
     * various healthcare provider roles. This identifier is 
     * specific to the person not their roles.</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * healthcare provider</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getPrincipalPersonAggregateIdentifier() {
        return this.principalPersonAggregateIdentifier.rawSet();
    }


    /**
     * <p>PrincipalPersonName</p>
     * 
     * <p>Principal Person Name</p>
     * 
     * <p><p>The person'''s name independent of any role they may 
     * play.</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * healthcare provider</p></p>
     * 
     * <p><p>If Principal Person is included in the message, then 
     * Person Name Must Exist.</p></p>
     * 
     * <p>Principal Person Name</p>
     * 
     * <p><p>The person'''s name independent of any role they may 
     * play.</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * healthcare provider</p></p>
     */
    @Hl7XmlMapping({"name"})
    public List<PersonName> getPrincipalPersonName() {
        return this.principalPersonName.rawList();
    }


    /**
     * <p>PrincipalPersonGender</p>
     * 
     * <p>Principal Person Gender</p>
     * 
     * <p><p>The principal person'''s gender.</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * healthcare provider</p></p>
     * 
     * <p><p>If Principal Person is included in the message, then 
     * Person Gender is Expected to Exist.</p></p>
     */
    @Hl7XmlMapping({"administrativeGenderCode"})
    public AdministrativeGender getPrincipalPersonGender() {
        return (AdministrativeGender) this.principalPersonGender.getValue();
    }
    public void setPrincipalPersonGender(AdministrativeGender principalPersonGender) {
        this.principalPersonGender.setValue(principalPersonGender);
    }


    /**
     * <p>PrincipalPersonDeceasedIndicator</p>
     * 
     * <p>Principal Person Deceased Indicator</p>
     * 
     * <p><p>An indication that the principal person is 
     * deceased.</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * healthcare provider</p></p>
     */
    @Hl7XmlMapping({"deceasedInd"})
    public Boolean getPrincipalPersonDeceasedIndicator() {
        return this.principalPersonDeceasedIndicator.getValue();
    }
    public void setPrincipalPersonDeceasedIndicator(Boolean principalPersonDeceasedIndicator) {
        this.principalPersonDeceasedIndicator.setValue(principalPersonDeceasedIndicator);
    }


    @Hl7XmlMapping({"languageCommunication"})
    public List<LanguageCommunicationBean> getLanguageCommunication() {
        return this.languageCommunication;
    }


    /**
     * <p>PrincipalPersonDateOfBirth</p>
     * 
     * <p>Principal Person Date of Birth</p>
     * 
     * <p><p>The principal person'''s date of birth.</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * healthcare provider</p></p>
     * 
     * <p><p>If Principal Person is included in the message, then 
     * Prinicpal Person Date of Birth is Expected to Exist.</p></p>
     */
    @Hl7XmlMapping({"birthTime"})
    public Date getPrincipalPersonDateOfBirth() {
        return this.principalPersonDateOfBirth.getValue();
    }
    public void setPrincipalPersonDateOfBirth(Date principalPersonDateOfBirth) {
        this.principalPersonDateOfBirth.setValue(principalPersonDateOfBirth);
    }


    /**
     * <p>BirthplaceAddress</p>
     * 
     * <p>Birthplace Address</p>
     * 
     * <p><p>Principal person's address at time of birth</p></p>
     * 
     * <p><p>Mandatory attribute supports the identification of the 
     * healthcare provider</p></p>
     * 
     * <p><p>If Birthplace is included in the message, then Address 
     * is Expected to Exist.</p></p>
     */
    @Hl7XmlMapping({"birthplace/addr"})
    public PostalAddress getBirthplaceAddress() {
        return this.birthplaceAddress.getValue();
    }
    public void setBirthplaceAddress(PostalAddress birthplaceAddress) {
        this.birthplaceAddress.setValue(birthplaceAddress);
    }


    /**
     * <p>PrincipalPersonDeceasedDate</p>
     * 
     * <p>Principal Person Deceased Date</p>
     * 
     * <p><p>The date and time that a healthcare provider's death 
     * occurred.</p></p>
     * 
     * <p><p>Required attribute supports verification of death from 
     * official source such as Vital Statistics.</p></p>
     */
    @Hl7XmlMapping({"deceasedTime"})
    public Date getPrincipalPersonDeceasedDate() {
        return this.principalPersonDeceasedDate.getValue();
    }
    public void setPrincipalPersonDeceasedDate(Date principalPersonDeceasedDate) {
        this.principalPersonDeceasedDate.setValue(principalPersonDeceasedDate);
    }

}

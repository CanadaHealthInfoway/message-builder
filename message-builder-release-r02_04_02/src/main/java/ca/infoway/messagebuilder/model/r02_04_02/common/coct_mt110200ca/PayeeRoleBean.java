/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt110200ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Set;



/**
 * <p>Payee Role</p>
 * 
 * <p><p>Role of payee - being played by Organisation, 
 * Person</p></p>
 * 
 * <p><p>Payee: (1) Provider or designate organization with 
 * identifier plays the role of Payee - PayeeRole.id only (no 
 * Account, Person info) (2) Payee is an individual listed on 
 * the insurance (e.g. policy holder or covered party) - 
 * PayeeRole.id must not be specified - Specify 
 * PayeeRelationshipRole (e.g. Policy Holder) - Optionally 
 * specify name, addr, language, bank account info - Account 
 * bank info is likely on file with Payor and is NOT required 
 * for direct deposit - PayeePerson.addr is likely on file with 
 * Payor and is NOT required for mailing of cheque (3) Payee is 
 * an individual not listed on the insurance (e.g. guarantor) - 
 * PayeeRole.id must not be specified - Specify 
 * PayeeRelationshipRole (e.g. Guarantor) - Optionally specify 
 * name, addr, language, bank account info - Account bank info 
 * is likely NOT on file with Payor and is required for direct 
 * deposit - PayeePerson.addr is likely NOT on file with Payor 
 * and is required for mailing of cheque</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT110200CA.PayeeRole"})
public class PayeeRoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private PayeeChoice payeeChoice;
    private SET<II, Identifier> payeeIdentifier = new SETImpl<II, Identifier>(IIImpl.class);


    @Hl7XmlMapping({"payeeChoice"})
    public PayeeChoice getPayeeChoice() {
        return this.payeeChoice;
    }
    public void setPayeeChoice(PayeeChoice payeeChoice) {
        this.payeeChoice = payeeChoice;
    }

    public PayeePersonBean getPayeeChoiceAsPayeePerson() {
        return this.payeeChoice instanceof PayeePersonBean ? (PayeePersonBean) this.payeeChoice : null;
    }
    public boolean hasPayeeChoiceAsPayeePerson() {
        return (this.payeeChoice instanceof PayeePersonBean);
    }

    public PayeeOrganisationBean getPayeeChoiceAsPayeeOrganization() {
        return this.payeeChoice instanceof PayeeOrganisationBean ? (PayeeOrganisationBean) this.payeeChoice : null;
    }
    public boolean hasPayeeChoiceAsPayeeOrganization() {
        return (this.payeeChoice instanceof PayeeOrganisationBean);
    }


    /**
     * <p>payee identifier</p>
     * 
     * <p><p>Policy Holder or covered party</p></p>
     * 
     * <p><p>Payee:</p><p>(1) Provider or designate organization 
     * with identifier plays the role of Payee</p><p>- PayeeRole.id 
     * only (no Account, Person info)</p><p>(2) Payee is an 
     * individual listed on the insurance (e.g. policy holder or 
     * covered party)</p><p>- PayeeRole.id must not be 
     * specified</p><p>- Specify PayeeRelationshipRole (e.g. Policy 
     * Holder)</p><p>- Optionally specify name, addr, language, 
     * bank account info</p><p>- Account bank info is likely on 
     * file with Payor and is NOT required for direct 
     * deposit</p><p>- PayeePerson.addr is likely on file with 
     * Payor and is NOT required for mailing of cheque</p><p>(3) 
     * Payee is an individual not listed on the insurance (e.g. 
     * guarantor) - PayeeRole.id must not be specified - Specify 
     * PayeeRelationshipRole (e.g. Guarantor) - Optionally specify 
     * name, addr, language, bank account info - Account bank info 
     * is likely NOT on file with Payor and is required for direct 
     * deposit - PayeePerson.addr is likely NOT on file with Payor 
     * and is required for mailing of cheque</p></p>
     * 
     * <p><p>Payee:</p><p>(1) Provider or designate organization 
     * with identifier plays the role of Payee</p><p>- PayeeRole.id 
     * only (no Account, Person info)</p><p>(2) Payee is an 
     * individual listed on the insurance (e.g. policy holder or 
     * covered party)</p><p>- PayeeRole.id must not be 
     * specified</p><p>- Specify PayeeRelationshipRole (e.g. Policy 
     * Holder)</p><p>- Optionally specify name, addr, language, 
     * bank account info</p><p>- Account bank info is likely on 
     * file with Payor and is NOT required for direct 
     * deposit</p><p>- PayeePerson.addr is likely on file with 
     * Payor and is NOT required for mailing of cheque</p><p>(3) 
     * Payee is an individual not listed on the insurance (e.g. 
     * guarantor) - PayeeRole.id must not be specified - Specify 
     * PayeeRelationshipRole (e.g. Guarantor) - Optionally specify 
     * name, addr, language, bank account info - Account bank info 
     * is likely NOT on file with Payor and is required for direct 
     * deposit - PayeePerson.addr is likely NOT on file with Payor 
     * and is required for mailing of cheque</p></p>
     * 
     * <p><p>Payee:</p><p>(1) Provider or designate organization 
     * with identifier plays the role of Payee</p><p>- PayeeRole.id 
     * only (no Account, Person info)</p><p>(2) Payee is an 
     * individual listed on the insurance (e.g. policy holder or 
     * covered party)</p><p>- PayeeRole.id must not be 
     * specified</p><p>- Specify PayeeRelationshipRole (e.g. Policy 
     * Holder)</p><p>- Optionally specify name, addr, language, 
     * bank account info</p><p>- Account bank info is likely on 
     * file with Payor and is NOT required for direct 
     * deposit</p><p>- PayeePerson.addr is likely on file with 
     * Payor and is NOT required for mailing of cheque</p><p>(3) 
     * Payee is an individual not listed on the insurance (e.g. 
     * guarantor) - PayeeRole.id must not be specified - Specify 
     * PayeeRelationshipRole (e.g. Guarantor) - Optionally specify 
     * name, addr, language, bank account info - Account bank info 
     * is likely NOT on file with Payor and is required for direct 
     * deposit - PayeePerson.addr is likely NOT on file with Payor 
     * and is required for mailing of cheque</p></p>
     * 
     * <p><p>Payee:</p><p>(1) Provider or designate organization 
     * with identifier plays the role of Payee</p><p>- PayeeRole.id 
     * only (no Account, Person info)</p><p>(2) Payee is an 
     * individual listed on the insurance (e.g. policy holder or 
     * covered party)</p><p>- PayeeRole.id must not be 
     * specified</p><p>- Specify PayeeRelationshipRole (e.g. Policy 
     * Holder)</p><p>- Optionally specify name, addr, language, 
     * bank account info</p><p>- Account bank info is likely on 
     * file with Payor and is NOT required for direct 
     * deposit</p><p>- PayeePerson.addr is likely on file with 
     * Payor and is NOT required for mailing of cheque</p><p>(3) 
     * Payee is an individual not listed on the insurance (e.g. 
     * guarantor) - PayeeRole.id must not be specified - Specify 
     * PayeeRelationshipRole (e.g. Guarantor) - Optionally specify 
     * name, addr, language, bank account info - Account bank info 
     * is likely NOT on file with Payor and is required for direct 
     * deposit - PayeePerson.addr is likely NOT on file with Payor 
     * and is required for mailing of cheque</p></p>
     * 
     * <p><p>Payee:</p><p>(1) Provider or designate organization 
     * with identifier plays the role of Payee</p><p>- PayeeRole.id 
     * only (no Account, Person info)</p><p>(2) Payee is an 
     * individual listed on the insurance (e.g. policy holder or 
     * covered party)</p><p>- PayeeRole.id must not be 
     * specified</p><p>- Specify PayeeRelationshipRole (e.g. Policy 
     * Holder)</p><p>- Optionally specify name, addr, language, 
     * bank account info</p><p>- Account bank info is likely on 
     * file with Payor and is NOT required for direct 
     * deposit</p><p>- PayeePerson.addr is likely on file with 
     * Payor and is NOT required for mailing of cheque</p><p>(3) 
     * Payee is an individual not listed on the insurance (e.g. 
     * guarantor) - PayeeRole.id must not be specified - Specify 
     * PayeeRelationshipRole (e.g. Guarantor) - Optionally specify 
     * name, addr, language, bank account info - Account bank info 
     * is likely NOT on file with Payor and is required for direct 
     * deposit - PayeePerson.addr is likely NOT on file with Payor 
     * and is required for mailing of cheque</p></p>
     * 
     * <p><p>Payee:</p><p>(1) Provider or designate organization 
     * with identifier plays the role of Payee</p><p>- PayeeRole.id 
     * only (no Account, Person info)</p><p>(2) Payee is an 
     * individual listed on the insurance (e.g. policy holder or 
     * covered party)</p><p>- PayeeRole.id must not be 
     * specified</p><p>- Specify PayeeRelationshipRole (e.g. Policy 
     * Holder)</p><p>- Optionally specify name, addr, language, 
     * bank account info</p><p>- Account bank info is likely on 
     * file with Payor and is NOT required for direct 
     * deposit</p><p>- PayeePerson.addr is likely on file with 
     * Payor and is NOT required for mailing of cheque</p><p>(3) 
     * Payee is an individual not listed on the insurance (e.g. 
     * guarantor) - PayeeRole.id must not be specified - Specify 
     * PayeeRelationshipRole (e.g. Guarantor) - Optionally specify 
     * name, addr, language, bank account info - Account bank info 
     * is likely NOT on file with Payor and is required for direct 
     * deposit - PayeePerson.addr is likely NOT on file with Payor 
     * and is required for mailing of cheque</p></p>
     * 
     * <p><p>Payee:</p><p>(1) Provider or designate organization 
     * with identifier plays the role of Payee</p><p>- PayeeRole.id 
     * only (no Account, Person info)</p><p>(2) Payee is an 
     * individual listed on the insurance (e.g. policy holder or 
     * covered party)</p><p>- PayeeRole.id must not be 
     * specified</p><p>- Specify PayeeRelationshipRole (e.g. Policy 
     * Holder)</p><p>- Optionally specify name, addr, language, 
     * bank account info</p><p>- Account bank info is likely on 
     * file with Payor and is NOT required for direct 
     * deposit</p><p>- PayeePerson.addr is likely on file with 
     * Payor and is NOT required for mailing of cheque</p><p>(3) 
     * Payee is an individual not listed on the insurance (e.g. 
     * guarantor) - PayeeRole.id must not be specified - Specify 
     * PayeeRelationshipRole (e.g. Guarantor) - Optionally specify 
     * name, addr, language, bank account info - Account bank info 
     * is likely NOT on file with Payor and is required for direct 
     * deposit - PayeePerson.addr is likely NOT on file with Payor 
     * and is required for mailing of cheque</p></p>
     * 
     * <p><p>Payee:</p><p>(1) Provider or designate organization 
     * with identifier plays the role of Payee</p><p>- PayeeRole.id 
     * only (no Account, Person info)</p><p>(2) Payee is an 
     * individual listed on the insurance (e.g. policy holder or 
     * covered party)</p><p>- PayeeRole.id must not be 
     * specified</p><p>- Specify PayeeRelationshipRole (e.g. Policy 
     * Holder)</p><p>- Optionally specify name, addr, language, 
     * bank account info</p><p>- Account bank info is likely on 
     * file with Payor and is NOT required for direct 
     * deposit</p><p>- PayeePerson.addr is likely on file with 
     * Payor and is NOT required for mailing of cheque</p><p>(3) 
     * Payee is an individual not listed on the insurance (e.g. 
     * guarantor) - PayeeRole.id must not be specified - Specify 
     * PayeeRelationshipRole (e.g. Guarantor) - Optionally specify 
     * name, addr, language, bank account info - Account bank info 
     * is likely NOT on file with Payor and is required for direct 
     * deposit - PayeePerson.addr is likely NOT on file with Payor 
     * and is required for mailing of cheque</p></p>
     * 
     * <p><p>Payee:</p><p>(1) Provider or designate organization 
     * with identifier plays the role of Payee</p><p>- PayeeRole.id 
     * only (no Account, Person info)</p><p>(2) Payee is an 
     * individual listed on the insurance (e.g. policy holder or 
     * covered party)</p><p>- PayeeRole.id must not be 
     * specified</p><p>- Specify PayeeRelationshipRole (e.g. Policy 
     * Holder)</p><p>- Optionally specify name, addr, language, 
     * bank account info</p><p>- Account bank info is likely on 
     * file with Payor and is NOT required for direct 
     * deposit</p><p>- PayeePerson.addr is likely on file with 
     * Payor and is NOT required for mailing of cheque</p><p>(3) 
     * Payee is an individual not listed on the insurance (e.g. 
     * guarantor) - PayeeRole.id must not be specified - Specify 
     * PayeeRelationshipRole (e.g. Guarantor) - Optionally specify 
     * name, addr, language, bank account info - Account bank info 
     * is likely NOT on file with Payor and is required for direct 
     * deposit - PayeePerson.addr is likely NOT on file with Payor 
     * and is required for mailing of cheque</p></p>
     * 
     * <p><p>Payee:</p><p>(1) Provider or designate organization 
     * with identifier plays the role of Payee</p><p>- PayeeRole.id 
     * only (no Account, Person info)</p><p>(2) Payee is an 
     * individual listed on the insurance (e.g. policy holder or 
     * covered party)</p><p>- PayeeRole.id must not be 
     * specified</p><p>- Specify PayeeRelationshipRole (e.g. Policy 
     * Holder)</p><p>- Optionally specify name, addr, language, 
     * bank account info</p><p>- Account bank info is likely on 
     * file with Payor and is NOT required for direct 
     * deposit</p><p>- PayeePerson.addr is likely on file with 
     * Payor and is NOT required for mailing of cheque</p><p>(3) 
     * Payee is an individual not listed on the insurance (e.g. 
     * guarantor) - PayeeRole.id must not be specified - Specify 
     * PayeeRelationshipRole (e.g. Guarantor) - Optionally specify 
     * name, addr, language, bank account info - Account bank info 
     * is likely NOT on file with Payor and is required for direct 
     * deposit - PayeePerson.addr is likely NOT on file with Payor 
     * and is required for mailing of cheque</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getPayeeIdentifier() {
        return this.payeeIdentifier.rawSet();
    }

}
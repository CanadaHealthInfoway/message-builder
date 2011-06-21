/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.porx_mt020050ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.coct_mt220200ca.DrugProductBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged.CommentBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged.SupplyOrderBean;
import java.util.Date;



/**
 * <p>Office Supply</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">This is the 
 * detailed information about a medication being supplied for 
 * office use.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows for 
 * tracking of medications supplied to an office.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT020050CA.SupplyEvent"})
@Hl7RootType
public class OfficeSupplyBean extends MessagePartBean {

    private static final long serialVersionUID = 20110621L;
    private II localDispenseID = new IIImpl();
    private CV dispenseType = new CVImpl();
    private TS supplyDate = new TSImpl();
    private PQ suppliedQuantity = new PQImpl();
    private II shipToFacilityId = new IIImpl();
    private SupplyOrderBean fulfillmentSupplyRequest;
    private DrugProductBean productMedication;
    private CommentBean subjectOfAnnotation;


    /**
     * <p>A:Local Dispense ID</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Identifier 
     * assigned by the dispensing facility.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * formal tracking of centrally recorded dispenses to local 
     * records for audit and related purposes.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getLocalDispenseID() {
        return this.localDispenseID.getValue();
    }
    public void setLocalDispenseID(Identifier localDispenseID) {
        this.localDispenseID.setValue(localDispenseID);
    }


    /**
     * <p>Dispense Type</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the type of dispensing event that is being performed.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">This is a fixed 
     * dispense type of 'Office Supply' unless using SNOMED.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the type of dispensing event that is being performed.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">This is a fixed 
     * dispense type of 'Office Supply' unless using SNOMED.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.activityType</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D52</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.2</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.403-D3</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.343-HD</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.activityType</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D52</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.2</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.403-D3</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.343-HD</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.activityType</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D52</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.2</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.403-D3</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.343-HD</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.activityType</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D52</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.2</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.403-D3</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.343-HD</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.activityType</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D52</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.2</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.403-D3</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.343-HD</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.activityType</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D52</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.2</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.403-D3</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.343-HD</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * reason for the size of dispense. Because it defines what 
     * type of dispense is occurring, the attribute is 
     * mandatory.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getDispenseType() {
        return (ActCode) this.dispenseType.getValue();
    }
    public void setDispenseType(ActCode dispenseType) {
        this.dispenseType.setValue(dispenseType);
    }


    /**
     * <p>A:Supply Date</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Represents 
     * the date medication was supplied.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.9</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.17 
     * (high)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=07, format=102)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=36, format=102)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispense 
     * Date</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispense 
     * Date</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.dispenseDate</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.9</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.17 
     * (high)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=07, format=102)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=36, format=102)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispense 
     * Date</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispense 
     * Date</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.dispenseDate</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.9</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.17 
     * (high)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=07, format=102)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=36, format=102)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispense 
     * Date</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispense 
     * Date</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.dispenseDate</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.9</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.17 
     * (high)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=07, format=102)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=36, format=102)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispense 
     * Date</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispense 
     * Date</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.dispenseDate</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.9</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.17 
     * (high)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=07, format=102)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=36, format=102)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispense 
     * Date</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispense 
     * Date</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.dispenseDate</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.9</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.17 
     * (high)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=07, format=102)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=36, format=102)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispense 
     * Date</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispense 
     * Date</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.dispenseDate</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.9</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.17 
     * (high)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=07, format=102)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=36, format=102)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispense 
     * Date</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispense 
     * Date</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.dispenseDate</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.9</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.17 
     * (high)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=07, format=102)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=36, format=102)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispense 
     * Date</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispense 
     * Date</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.dispenseDate</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.9</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.17 
     * (high)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=07, format=102)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=36, format=102)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispense 
     * Date</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispense 
     * Date</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.dispenseDate</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Needed for 
     * audit purposes.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Because the supply 
     * date is always known, the attribute is mandatory.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Needed for 
     * audit purposes.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Because the supply 
     * date is always known, the attribute is mandatory.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Must be able 
     * to post date a dispense (enter retroactively) e.g. system 
     * failure</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getSupplyDate() {
        return this.supplyDate.getValue();
    }
    public void setSupplyDate(Date supplyDate) {
        this.supplyDate.setValue(supplyDate);
    }


    /**
     * <p>B:Supplied Quantity</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The amount 
     * of medication that has been dispensed. Includes unit of 
     * measure.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">D58</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.4</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.10.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.9.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.9.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-01 (Unit, 
     * qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-02 
     * (Quantity, qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-03 
     * (qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.442-E7</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.460-ET</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.600-28</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Quantity</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.dispensedAmount</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">D58</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.4</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.10.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.9.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.9.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-01 (Unit, 
     * qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-02 
     * (Quantity, qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-03 
     * (qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.442-E7</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.460-ET</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.600-28</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Quantity</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.dispensedAmount</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">D58</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.4</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.10.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.9.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.9.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-01 (Unit, 
     * qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-02 
     * (Quantity, qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-03 
     * (qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.442-E7</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.460-ET</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.600-28</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Quantity</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.dispensedAmount</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">D58</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.4</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.10.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.9.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.9.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-01 (Unit, 
     * qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-02 
     * (Quantity, qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-03 
     * (qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.442-E7</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.460-ET</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.600-28</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Quantity</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.dispensedAmount</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">D58</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.4</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.10.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.9.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.9.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-01 (Unit, 
     * qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-02 
     * (Quantity, qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-03 
     * (qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.442-E7</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.460-ET</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.600-28</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Quantity</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.dispensedAmount</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">D58</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.4</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.10.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.9.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.9.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-01 (Unit, 
     * qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-02 
     * (Quantity, qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-03 
     * (qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.442-E7</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.460-ET</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.600-28</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Quantity</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.dispensedAmount</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">D58</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.4</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.10.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.9.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.9.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-01 (Unit, 
     * qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-02 
     * (Quantity, qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-03 
     * (qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.442-E7</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.460-ET</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.600-28</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Quantity</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.dispensedAmount</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">D58</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.4</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.10.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.9.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.9.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-01 (Unit, 
     * qualifier=38 0r 87)</p><p 
     * ... [rest of documentation truncated due to excessive length]
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getSuppliedQuantity() {
        return this.suppliedQuantity.getValue();
    }
    public void setSuppliedQuantity(PhysicalQuantity suppliedQuantity) {
        this.suppliedQuantity.setValue(suppliedQuantity);
    }


    /**
     * <p>C:Ship-to Facility Id</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Identifier 
     * of the facility where the dispensed medication was 
     * shipped.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * tracking what drugs are dispensed to a facility. The 
     * attribute is mandatory because identification of the 
     * facility must be known.</p></p>
     */
    @Hl7XmlMapping({"destination/serviceDeliveryLocation/id"})
    public Identifier getShipToFacilityId() {
        return this.shipToFacilityId.getValue();
    }
    public void setShipToFacilityId(Identifier shipToFacilityId) {
        this.shipToFacilityId.setValue(shipToFacilityId);
    }


    @Hl7XmlMapping({"fulfillment/supplyRequest"})
    public SupplyOrderBean getFulfillmentSupplyRequest() {
        return this.fulfillmentSupplyRequest;
    }
    public void setFulfillmentSupplyRequest(SupplyOrderBean fulfillmentSupplyRequest) {
        this.fulfillmentSupplyRequest = fulfillmentSupplyRequest;
    }


    @Hl7XmlMapping({"product/medication"})
    public DrugProductBean getProductMedication() {
        return this.productMedication;
    }
    public void setProductMedication(DrugProductBean productMedication) {
        this.productMedication = productMedication;
    }


    @Hl7XmlMapping({"subjectOf/annotation"})
    public CommentBean getSubjectOfAnnotation() {
        return this.subjectOfAnnotation;
    }
    public void setSubjectOfAnnotation(CommentBean subjectOfAnnotation) {
        this.subjectOfAnnotation = subjectOfAnnotation;
    }

}

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.MedicationObservationType;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>AppearanceCharacteristics</p>
 * 
 * <p>POME_MT010100CA.Characteristic: Appearance 
 * Characteristics</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The 
 * characteristics of a manufactured product that visually 
 * distinguish it from other products.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Used for 
 * searching drugs. May be employed as means of communication 
 * between providers and patients.</p></p>
 * 
 * <p>POME_MT010040CA.Characteristic: Appearance 
 * Characteristics</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The 
 * characteristics of a manufactured product that visually 
 * distinguish it from other products.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Used for 
 * searching drugs. May be employed as means of communication 
 * between providers and patients.</p></p>
 */
@Hl7PartTypeMapping({"POME_MT010040CA.Characteristic","POME_MT010100CA.Characteristic"})
public class AppearanceCharacteristicsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110714L;
    private CV characteristicType = new CVImpl();
    private ST characteristic = new STImpl();


    /**
     * <p>CharacteristicType</p>
     * 
     * <p>A:Characteristic Type</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A coded 
     * value denoting the type of physical characteristic being 
     * documented. Kinds of characteristics include: Color, Shape, 
     * Markings, Size, etc.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Identifies 
     * what kind of characteristic is being identified. This is 
     * mandatory as providing the characteristic alone without 
     * specifying the type can result in ambiguity.</p></p>
     * 
     * <p>Characteristic Type</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A coded 
     * value denoting the type of physical characteristic being 
     * documented. Kinds of characteristics include: Color, Shape, 
     * Markings, Size.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Identifies 
     * what kind of characteristic is being identified. This is 
     * mandatory as providing the characteristic alone without 
     * specifying the type can result in ambiguity</p></p>
     */
    @Hl7XmlMapping({"code"})
    public MedicationObservationType getCharacteristicType() {
        return (MedicationObservationType) this.characteristicType.getValue();
    }
    public void setCharacteristicType(MedicationObservationType characteristicType) {
        this.characteristicType.setValue(characteristicType);
    }


    /**
     * <p>Characteristic</p>
     * 
     * <p>E:Characteristic</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Information 
     * pertaining to a specific instance of drug characteristic 
     * (color, shape, markings etc).</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides the 
     * 'value' part of the name-value pair describing the drug 
     * product appearance characteristic.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The attribute is 
     * marked as &quot;mandatory&quot; as there must be a value for 
     * a mandatory code.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides the 
     * 'value' part of the name-value pair describing the drug 
     * product appearance characteristic.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The attribute is 
     * marked as &quot;mandatory&quot; as there must be a value for 
     * a mandatory code.</p></p>
     * 
     * <p>Characteristic</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Information 
     * pertaining to a specific instance of drug characteristic 
     * (color, shape, markings etc)</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides the 
     * 'value' part of the name-value pair describing the drug 
     * product appearance characteristic.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The attribute is 
     * marked as 'mandatory' as there must be a value for a 
     * mandatory code.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides the 
     * 'value' part of the name-value pair describing the drug 
     * product appearance characteristic.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The attribute is 
     * marked as 'mandatory' as there must be a value for a 
     * mandatory code.</p></p>
     */
    @Hl7XmlMapping({"value"})
    public String getCharacteristic() {
        return this.characteristic.getValue();
    }
    public void setCharacteristic(String characteristic) {
        this.characteristic.setValue(characteristic);
    }

}

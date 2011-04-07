/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt960002ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.REAL;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.REALImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.math.BigDecimal;



/**
 * <p>Coordinate Axis</p>
 * 
 * <p><p>Describes the postion of the location along a specific 
 * axis.</p></p>
 * 
 * <p><p>Defines the position of the location</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT960002CA.PositionCoordinate"})
public class CoordinateAxisBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private CV coordinateAxisType = new CVImpl();
    private REAL coordinateAxisValue = new REALImpl();


    /**
     * <p>Coordinate Axis Type</p>
     * 
     * <p><p>Identifies the individual coordinate in the coordinate 
     * system inclusive of any transformations or 
     * projections.</p><p>Examples of corordinate types are: 
     * meridian, range, township, longitude, latitude, lot, block, 
     * etc.</p></p>
     * 
     * <p><p>Identifies the individual coordinate in the coordinate 
     * system inclusive of any transformations or 
     * projections.</p><p>Examples of corordinate types are: 
     * meridian, range, township, longitude, latitude, lot, block, 
     * etc.</p></p>
     * 
     * <p><p>Acts as the &quot;name&quot; in the name-value pair 
     * that expresses a coordinate and is therefore mandatory</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getCoordinateAxisType() {
        return (Code) this.coordinateAxisType.getValue();
    }
    public void setCoordinateAxisType(Code coordinateAxisType) {
        this.coordinateAxisType.setValue(coordinateAxisType);
    }


    /**
     * <p>Coordinate Axis Value</p>
     * 
     * <p><p>Denotes the individual coordinate value as a a 
     * physical quantity. For example, lot number, range number, 
     * latitude, etc.</p></p>
     * 
     * <p><p>Actually expresses the location along the axis. 
     * Because unknown axis positions can simply be omitted, this 
     * attribute is mandatory.</p></p>
     */
    @Hl7XmlMapping({"value"})
    public BigDecimal getCoordinateAxisValue() {
        return this.coordinateAxisValue.getValue();
    }
    public void setCoordinateAxisValue(BigDecimal coordinateAxisValue) {
        this.coordinateAxisValue.setValue(coordinateAxisValue);
    }

}

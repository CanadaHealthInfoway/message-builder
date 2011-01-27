/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.coct_mt960002ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Geographic Coordinates</p>
 * 
 * <p><p>Allows the capturing of a physical location according 
 * to a particular coordinate system, such as GPS, legal 
 * designation (lot, block, plan), range-meridian, etc.</p></p>
 * 
 * <p><p>Some locations cannot be described by postal 
 * addresses. Also, geographic coordinates allow calculation of 
 * distances and proximity</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT960002CA.Position"})
@Hl7RootType
public class GeographicCoordinatesBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private List<CoordinateAxisBean> componentPositionCoordinate = new ArrayList<CoordinateAxisBean>();
    private CV coordinateSystem = new CVImpl();


    @Hl7XmlMapping({"component/positionCoordinate"})
    public List<CoordinateAxisBean> getComponentPositionCoordinate() {
        return this.componentPositionCoordinate;
    }


    /**
     * <p>Coordinate System</p>
     * 
     * <p><p>Identifies the coordinate system inclusive of any 
     * transformation projections.</p></p>
     * 
     * <p><p>Essential for interpretting the specified coordinates 
     * and therefore mandatory</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getCoordinateSystem() {
        return (Code) this.coordinateSystem.getValue();
    }
    public void setCoordinateSystem(Code coordinateSystem) {
        this.coordinateSystem.setValue(coordinateSystem);
    }

}

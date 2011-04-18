package ca.infoway.messagebuilder.model.newfoundland.cerx;

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;

import java.math.BigDecimal;
import java.util.Date;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.x_ActObservationHeightOrWeight;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.QuantityObservationEventBean;

public class QuantityObservationEventBeanBuilder extends BaseBeanBuilder<QuantityObservationEventBean> {

	public QuantityObservationEventBeanBuilder() {
		super(new QuantityObservationEventBean());
	}
	
	public QuantityObservationEventBeanBuilder populate() {
		this.bean.setPatientMeasurementType(lookup(x_ActObservationHeightOrWeight.class, "3137-7", CodeSystem.LOINC.getRoot()));
		this.bean.setPatientMeasurementTime(new Date(20));
		this.bean.setPatientMeasuredValue(new PhysicalQuantity(new BigDecimal(79.0), lookup(UnitsOfMeasureCaseSensitive.class, "kg")));
		return this;
	}

}

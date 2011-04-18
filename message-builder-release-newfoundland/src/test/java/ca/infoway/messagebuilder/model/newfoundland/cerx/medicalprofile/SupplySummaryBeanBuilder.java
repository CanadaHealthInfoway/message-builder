package ca.infoway.messagebuilder.model.newfoundland.cerx.medicalprofile;

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;

import java.math.BigDecimal;
import java.util.Date;

import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.x_DrugUnitsOfMeasure;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprofile.SupplySummaryBean;

public class SupplySummaryBeanBuilder extends BaseBeanBuilder<SupplySummaryBean> {
	
	public SupplySummaryBeanBuilder() {
		super(new SupplySummaryBean());
	}

	public SupplySummaryBeanBuilder populate() {
		this.bean.setEffectiveTime(IntervalFactory.createLow(new Date(0)));
		this.bean.setQuantity(new PhysicalQuantity(new BigDecimal(12), lookup(x_DrugUnitsOfMeasure.class, "G")));
		return this;
	}

}

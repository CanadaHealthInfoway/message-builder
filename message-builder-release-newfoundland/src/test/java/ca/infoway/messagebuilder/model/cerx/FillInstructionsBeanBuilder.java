package ca.infoway.messagebuilder.model.cerx;

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;

import java.math.BigDecimal;
import java.util.Date;

import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.x_DrugUnitsOfMeasure;
import ca.infoway.messagebuilder.model.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.FillInstructionsBean;

public class FillInstructionsBeanBuilder extends BaseBeanBuilder<FillInstructionsBean> {
	
	public FillInstructionsBeanBuilder() {
		super(new FillInstructionsBean());
	}

	public FillInstructionsBeanBuilder populate() {
		this.bean.setExpectedUseTime(IntervalFactory.createLowHigh(new Date(600000000), new Date(700000000)));
		this.bean.setQuantity(new PhysicalQuantity(new BigDecimal(12), lookup(x_DrugUnitsOfMeasure.class, "g")));
		this.bean.setRepeatNumber(1);
		return this;
	}

}

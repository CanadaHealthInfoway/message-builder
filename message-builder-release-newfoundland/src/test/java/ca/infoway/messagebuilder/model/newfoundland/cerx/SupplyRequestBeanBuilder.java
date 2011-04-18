package ca.infoway.messagebuilder.model.newfoundland.cerx;

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;

import java.math.BigDecimal;
import java.util.Date;

import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.x_DrugUnitsOfMeasure;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.SupplyRequestBean;

public class SupplyRequestBeanBuilder extends BaseBeanBuilder<SupplyRequestBean> {
	
	public SupplyRequestBeanBuilder() {
		super(new SupplyRequestBean());
	}

	public SupplyRequestBeanBuilder populate() {
		this.bean.setExpectedUseTime(IntervalFactory.createLowHigh(new Date(600000000), new Date(700000000)));
		this.bean.setQuantity(new PhysicalQuantity(new BigDecimal(12), lookup(x_DrugUnitsOfMeasure.class, "g")));
		this.bean.setProduct(new MedicineBeanBuilder().populate().create());
		this.bean.setSubsequentSupplyRequest(new FillInstructionsBeanBuilder().populate().create());
		this.bean.setIntitialSupplyRequest(new FillInstructionsBeanBuilder().populate().create());
		return this;
	}

}

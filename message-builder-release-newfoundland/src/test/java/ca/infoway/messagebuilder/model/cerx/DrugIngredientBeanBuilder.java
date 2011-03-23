package ca.infoway.messagebuilder.model.cerx;

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;

import java.math.BigDecimal;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActiveIngredientDrugEntityType;
import ca.infoway.messagebuilder.domainvalue.x_DrugUnitsOfMeasure;
import ca.infoway.messagebuilder.model.BaseBeanBuilder;

public class DrugIngredientBeanBuilder extends BaseBeanBuilder<DrugIngredientBean> {

	public DrugIngredientBeanBuilder() {
		super(new DrugIngredientBean());
	}

	public DrugIngredientBeanBuilder populate() {
		this.bean.setName("ibuprofen");
		this.bean.setQuantity(new PhysicalQuantity(new BigDecimal(250), lookup(x_DrugUnitsOfMeasure.class, "g", CodeSystem.VOCABULARY_UNIFORM_UNIT_OF_MEASURE.getRoot())));
		this.bean.setNegationInd(false);
		this.bean.setCode(lookup(ActiveIngredientDrugEntityType.class, "00888982", CodeSystem.DRUG_IDENTIFICATION_NUMBER.getRoot()));
		return this;
	}

	public DrugIngredientBeanBuilder withDin(String din) {
		this.bean.setCode(lookup(ActiveIngredientDrugEntityType.class, din, CodeSystem.DRUG_IDENTIFICATION_NUMBER.getRoot()));
		this.bean.setName("drug with Din=" + din);
		return this;
	}

}

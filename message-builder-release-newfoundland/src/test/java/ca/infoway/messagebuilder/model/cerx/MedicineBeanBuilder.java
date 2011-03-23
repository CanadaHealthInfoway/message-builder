package ca.infoway.messagebuilder.model.cerx;

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;

import java.math.BigDecimal;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.CompliancePackageEntityType;
import ca.infoway.messagebuilder.domainvalue.ManufacturedDrug;
import ca.infoway.messagebuilder.domainvalue.OrderableDrugForm;
import ca.infoway.messagebuilder.domainvalue.x_DrugUnitsOfMeasure;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.model.BaseBeanBuilder;

public class MedicineBeanBuilder extends BaseBeanBuilder<MedicineBean> {

	public MedicineBeanBuilder() {
		super(new MedicineBean());
	}

	public MedicineBeanBuilder populate() {
//		this.bean.setCode(lookup(ManufacturedDrug.class, "02150352", CodeSystem.DRUG_IDENTIFICATION_NUMBER.getRoot()));
		this.bean.setCode(lookup(ManufacturedDrug.class, "00888982", CodeSystem.DRUG_IDENTIFICATION_NUMBER.getRoot()));
		this.bean.setContainerPackagedMedicine(lookup(CompliancePackageEntityType.class, "BLSTRPK", CodeSystem.VOCABULARY_ENTITY_CODE.getRoot()));
		this.bean.setDesc("some medicine containing ibuprofen");
		this.bean.setExpirationTime(IntervalFactory.createSimple(DateUtil.getDate(2009, 0, 1)));
		this.bean.setFormCode(lookup(OrderableDrugForm.class, "DROP", CodeSystem.VOCABULARY_ADMINISTRABLE_DRUG_FORM.getRoot()));
		this.bean.setLotNumberText("lot number 123");
		this.bean.setManufacturerId(new Identifier("manufacturerRoot", "1"));
		this.bean.setManufacturerName("Advil Manufacturer");
		this.bean.setName("advil extra strength");
		this.bean.setQuantity(new PhysicalQuantity(new BigDecimal(12), lookup(x_DrugUnitsOfMeasure.class, "g")));
		this.bean.getIngredients().add(new DrugIngredientBeanBuilder().populate().create());
		
		return this;
	}

	public MedicineBeanBuilder populateWithCompound() {
		this.bean.setDesc("A compound made with ibuprofen");
		this.bean.setExpirationTime(IntervalFactory.createSimple(DateUtil.getDate(2009, 0, 1)));
		this.bean.setFormCode(lookup(OrderableDrugForm.class, "CRM", CodeSystem.VOCABULARY_ADMINISTRABLE_DRUG_FORM.getRoot()));
		this.bean.setName("Ibuprofen in 2% blah blah cream");
		this.bean.setQuantity(new PhysicalQuantity(new BigDecimal(50), lookup(x_DrugUnitsOfMeasure.class, "ml")));
		this.bean.getIngredients().add(new DrugIngredientBeanBuilder().populate().create());
		this.bean.getIngredients().add(new DrugIngredientBeanBuilder().populate().withDin("02150352").create());
		return this;
	}

}

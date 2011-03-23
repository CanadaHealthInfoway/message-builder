package ca.infoway.messagebuilder.model.cerx;

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.IdentifiedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.NoteBeanBuilder;

public class DispenseRequestBeanBuilder extends BaseBeanBuilder<BaseDispenseRequestBean> {
	
	public DispenseRequestBeanBuilder(boolean useType1) {
		super(useType1 ? new DispenseRequest1Bean() : new DispenseRequest2Bean());
	}

	private void populate() {
		this.bean.setIdAssignedByPharmacy(new Identifier("1.2.3", "extension-1"));
		this.bean.getConfidentialityCode().add(
				lookup(x_VeryBasicConfidentialityKind.class, "N", CodeSystem.VOCABULARY_CONFIDENTIALITY.getRoot()));
		this.bean.setPatient(new IdentifiedPersonBeanBuilder().populate().create());		
		this.bean.setNote(new NoteBeanBuilder().populate().create());
	}
	
	public DispenseRequestBeanBuilder populateDevice() {
		populate();
		if (this.bean instanceof DispenseRequest2Bean) {
			((DispenseRequest2Bean) this.bean).setSupplyEvent(new SupplyEventBeanBuilder().populateDevice().create());
			((DispenseRequest2Bean) this.bean).setUsageInstructions("usage instructions");
			((DispenseRequest2Bean) this.bean).setSimpleDeviceRequestBean(new SimpleDeviceRequestBeanBuilder().populate().create());
		}
		return this;
	}
	
	public DispenseRequestBeanBuilder populateMedication() {
		populate();
		if (this.bean instanceof DispenseRequest1Bean) {
			((DispenseRequest1Bean) this.bean).setSupplyEvent(new SupplyEventBeanBuilder().populateMedication().create());
			((DispenseRequest1Bean) this.bean).getDosageInstructions().add(new DosageInstructionBeanBuilder().populate().create());
			((DispenseRequest1Bean) this.bean).setSubstanceAdministrationRequest(new SubstanceAdministrationRequestBeanBuilder().populate().create());
		}
		return this;
	}
	
	public DispenseRequestBeanBuilder withSubstitution() {
		if (this.bean instanceof DispenseRequest1Bean) {
			((DispenseRequest1Bean) this.bean).setSubstitutionMade(new SubstitutionMadeBeanBuilder().populate().create());
		}
		return this;
	}
}
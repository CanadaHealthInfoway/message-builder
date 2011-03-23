package ca.infoway.messagebuilder.model.cerx.allergy;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.NewQueryMessageBean;

@Hl7PartTypeMapping("REPC_IN000015CA")
public class PatientAllergyIntoleranceQueryMessageBeanNew extends NewQueryMessageBean<AllergyIntoleranceQueryCriteriaBean> {

	private static final long serialVersionUID = -1575806647159394384L;

	public PatientAllergyIntoleranceQueryMessageBeanNew() {
		this(new AllergyIntoleranceQueryCriteriaBean());
	}

	public PatientAllergyIntoleranceQueryMessageBeanNew(AllergyIntoleranceQueryCriteriaBean criteria) {
		super(criteria);
	}

}

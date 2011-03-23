package ca.infoway.messagebuilder.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;

public interface IndeterminatePerson {
	
	public PersonName getName();
	public void setName(PersonName names);
	public List<PersonName> getNames();
	public List<TelecommunicationAddress> getTelecom();
	public AdministrativeGender getAdministrativeGenderCode();
	public void setAdministrativeGenderCode(AdministrativeGender administrativeGenderCode);
	public Date getBirthTime();
	public void setBirthTime(Date birthTime);
	public Date getDeceasedTime();
	public void setDeceasedTime(Date deceasedTime);
	public Boolean getDeceasedIndicator();
	public void setDeceasedIndicator(Boolean deceasedIndicator);
	public List<PostalAddress> getAddresses();
	public Set<OtherIdentifiersBean> getAsOtherIds();
	public List<PersonalRelationshipBean> getPersonalRelationships();
	public Set<LanguageCommunicationBean> getLanguageCommunications();
	public Set<Identifier> getIds();
	
}

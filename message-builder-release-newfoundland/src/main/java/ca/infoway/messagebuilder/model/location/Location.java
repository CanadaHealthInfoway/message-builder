package ca.infoway.messagebuilder.model.location;

import java.util.List;

import ca.infoway.messagebuilder.datatype.lang.Identifiable;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryLocationPlaceType;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryLocationRoleType;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryRoleStatus;

public interface Location extends Identifiable {
	
	public void setId(Identifier id);
	public ServiceDeliveryLocationRoleType getCode();
	public void setCode(ServiceDeliveryLocationRoleType code);
	public List<String> getName();
	public PostalAddress getAddr();
	public void setAddr(PostalAddress addr);
	public ServiceDeliveryRoleStatus getStatusCode();
	public void setStatusCode(ServiceDeliveryRoleStatus statusCode);
	public ServiceDeliveryLocationPlaceType getPlaceCode();
	public void setPlaceCode(ServiceDeliveryLocationPlaceType placeCode);
	public Boolean getMobileInd();
	public void setMobileInd(Boolean mobileInd);
	
}

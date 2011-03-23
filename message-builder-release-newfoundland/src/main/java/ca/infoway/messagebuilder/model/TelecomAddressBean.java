package ca.infoway.messagebuilder.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.TelecommunicationAddressUse;
import ca.infoway.messagebuilder.domainvalue.URLScheme;

public class TelecomAddressBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 1781706323166959595L;

    private final ST address = new STImpl();

    private final CD scheme = new CDImpl();

    private final Set<TelecommunicationAddressUse> uses = Collections.synchronizedSet(new HashSet<TelecommunicationAddressUse>());

    public TelecomAddressBean() {
    }

    public TelecomAddressBean(String address, URLScheme scheme, TelecommunicationAddressUse uses) {
        setAddress(address);
        setScheme(scheme);
        this.uses.addAll(Arrays.asList(uses));
    }

    public String getAddress() {
        return this.address.getValue();
    }

    public void setAddress(String address) {
        this.address.setValue(address);
    }

    public URLScheme getScheme() {
        return (URLScheme) this.scheme.getValue();
    }

    public void setScheme(URLScheme scheme) {
        this.scheme.setValue(scheme);
    }

    public Set<TelecommunicationAddressUse> getUses() {
        return this.uses;
    }
}

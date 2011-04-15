package ca.infoway.messagebuilder.model.newfoundland;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.domainvalue.HumanLanguage;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "PRPA_MT101002CA.LanguageCommunication", "PRPA_MT101001CA.LanguageCommunication" })
public class LanguageCommunicationBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 2510745260687171285L;

    private final CD languageCode = new CDImpl();

    private final BL preferenceInd = new BLImpl(false);

    public LanguageCommunicationBean() {
    }

    public LanguageCommunicationBean(HumanLanguage languageCode, boolean preferenceInd) {
        setLanguageCode(languageCode);
        setPreferenceInd(preferenceInd);
    }

    @Hl7XmlMapping("languageCode")
    public HumanLanguage getLanguageCode() {
        return (HumanLanguage) this.languageCode.getValue();
    }

    public void setLanguageCode(HumanLanguage languageCode) {
        this.languageCode.setValue(languageCode);
    }

    @Hl7XmlMapping("preferenceInd")
    public boolean isPreferenceInd() {
        return this.preferenceInd.getValue();
    }

    public void setPreferenceInd(boolean preferenceInd) {
        this.preferenceInd.setValue(preferenceInd);
    }
}

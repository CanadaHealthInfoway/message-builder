package ca.infoway.messagebuilder.datatype;

import java.util.List;

public interface ANYMetaData {

	public String getLanguage();
	public void setLanguage(String language);
	
	public String getDisplayName();
	public void setDisplayName(String displayName);
	
	public List<CD> getTranslations();
	
	public String getOriginalText();
	public void setOriginalText(String originalText);
	
}

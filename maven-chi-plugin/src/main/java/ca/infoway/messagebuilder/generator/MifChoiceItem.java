package ca.infoway.messagebuilder.generator;

import java.util.List;

interface MifChoiceItem {
	public String getClassName();
	public String getTraversalName();
	public List<MifChoiceItem> getChoiceItems();
}

package ca.infoway.messagebuilder.xml;

import java.util.List;

public interface HasDifferences {

	public List<Difference> getDifferences();
	public void addDifference(Difference difference);
	
}

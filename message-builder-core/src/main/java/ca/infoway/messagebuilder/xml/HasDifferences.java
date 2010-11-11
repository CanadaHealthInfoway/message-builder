package ca.infoway.messagebuilder.xml;

import java.util.List;

import ca.infoway.messagebuilder.Named;

public interface HasDifferences extends Named {

	public List<Difference> getDifferences();
	public void addDifference(Difference difference);

}

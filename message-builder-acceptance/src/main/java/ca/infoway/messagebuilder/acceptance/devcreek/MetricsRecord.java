package ca.infoway.messagebuilder.acceptance.devcreek;

import java.util.Date;

import ca.intelliware.commons.dependency.devcreek.Record;

public abstract class MetricsRecord extends Record {
	
	public MetricsRecord() {
		setTimestamp(new Date());
	}
	
}

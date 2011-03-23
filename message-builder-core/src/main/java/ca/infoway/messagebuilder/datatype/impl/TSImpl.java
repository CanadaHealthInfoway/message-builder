package ca.infoway.messagebuilder.datatype.impl;

import java.util.Date;

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

/**
 * <p>HL7 datatype TS backed by a java Date.
 * 
 * <p>A quantity specifying a point on the axis of natural time. A point in time is
 * most often represented as a calendar expression.
 * 
 * <p>Semantically, however, time is independent from calendars and best described
 * by its relationship to elapsed time (measured as a physical quantity in the
 * dimension of time). A TS plus an elapsed time yields another TS. Inversely, a
 * TS minus another TS yields an elapsed time.
 * 
 * <p>As nobody knows when time began, a TS is conceptualized as the amount of time
 * that has elapsed from some arbitrary zero-point, called an epoch. Because
 * there is no absolute zero-point on the time axis; natural time is a
 * difference-scale quantity, where only differences are defined but no ratios.
 * (For example, no TS is - absolutely speaking - "twice as late" as another
 * TS.)
 * 
 * <p>Given some arbitrary zero-point, one can express any point in time as an
 * elapsed time measured from that offset. Such an arbitrary zero-point is
 * called an epoch. This epoch-offset form is used as a semantic representation
 * here, without implying that any system would have to implement TS in that
 * way. Systems that do not need to compute distances between TSs will not need
 * any other representation than a calendar expression literal.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually 
 */
public class TSImpl extends QTYImpl<Date> implements TS {

	/**
	 * <p>Constructs an empty TS.
	 */
	public TSImpl() {
		this((Date) null);
	}

	/**
	 * <p>Constructs a TS using the given date.
	 * 
	 * @param date the initial value
	 */
	public TSImpl(Date date) {
		super(Date.class, date, null, StandardDataType.TS);
	}

	/**
	 * <p>Constructs a TS using the given null flavor.
	 * 
	 * @param nullFlavor a null flavor
	 */
	public TSImpl(NullFlavor nullFlavor) {
		super(Date.class, null, nullFlavor, StandardDataType.TS);
	}

}

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import ca.infoway.messagebuilder.datatype.BareANY;

public interface PropertyFormatter {
    public String format(FormatContext formatContext, BareANY dataType) throws ModelToXmlTransformationException;
    public String format(FormatContext formatContext, BareANY dataType, int indentLevel) throws ModelToXmlTransformationException;
    
}

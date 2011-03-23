package ca.infoway.messagebuilder.generator.java;

import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import ca.infoway.messagebuilder.generator.LogLevel;
import ca.infoway.messagebuilder.generator.LogUI;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;

public class ReportWriter {
	
	public class Counts {
		private final int interactions;
		private final int messageTypes;
		private final int attributes;
		private final int associations;

		public Counts(int interactions, int messageTypes, int attributes, int associations) {
			this.interactions = interactions;
			this.messageTypes = messageTypes;
			this.attributes = attributes;
			this.associations = associations;
		}
		public int getInteractions() {
			return this.interactions;
		}
		public int getMessageTypes() {
			return this.messageTypes;
		}
		public int getAttributes() {
			return this.attributes;
		}
		public int getAssociations() {
			return this.associations;
		}
		public int getTotal() {
			return this.associations + this.attributes + this.interactions + this.messageTypes;
		}
	}
	
	public class ReportData {
		
		private final Counts originalCounts;
		private final Counts simplifiedCounts;

		public ReportData(Counts originalCounts, Counts simplifiedCounts) {
			this.originalCounts = originalCounts;
			this.simplifiedCounts = simplifiedCounts;
		}
		public Counts getOriginalCounts() {
			return this.originalCounts;
		}
		public Counts getSimplifiedCounts() {
			return this.simplifiedCounts;
		}
	}

	private final MessageSet messageSet;
	private final TypeAnalysisResult result;
	private final LogUI log;

	public ReportWriter(TypeAnalysisResult result, MessageSet messageSet, LogUI log) {
		this.result = result;
		this.messageSet = messageSet;
		this.log = log;
	}

	public void write(File report) throws IOException {
		FileWriter writer = new FileWriter(report);
		try {
			write(writer);
			this.log.log(LogLevel.INFO, "Simplification report written to " + report.getAbsolutePath());
		} finally {
			IOUtils.closeQuietly(writer);
		}
	}

	void write(Writer writer) throws IOException {
		
		ReportData data = new ReportData(
				new Counts(getOriginalNumberOfInteractions(),
						getOriginalNumberOfTypes(),
						getOriginalNumberOfAttributes(),
						getOriginalNumberOfAssociations()),
				new Counts(getSimplifiedNumberOfInteractions(), 
						getSimplifiedNumberOfTypes(), 
						getSimplifiedNumberOfAttributes(), 
						getSimplifiedNumberOfAssociations())
		);
		
		writer.write("<html>");
		writer.write(LINE_SEPARATOR);
		writer.write("<head>");
		writer.write("<title>Simplification report</title>");
		writer.write(LINE_SEPARATOR);
		writer.write("<style type=\"text/css\">");
		writer.write("table tfoot td{");
		writer.write("  border-top: 1px solid #000000;");
		writer.write("  border-bottom: 1px solid #000000;");
		writer.write("}");
		writer.write("table tbody tr:nth-child(odd) {");
		writer.write("  background-color: #cccccc;");
		writer.write("}");
		writer.write("table tbody tr td {");
		writer.write("  vertical-align: top;");
		writer.write("  padding-left: 2px;");
		writer.write("  padding-right: 2px;");
		writer.write("}");
		writer.write("</style>");
		writer.write("</head>");
		writer.write(LINE_SEPARATOR);
		writer.write("<body>");
		writer.write(LINE_SEPARATOR);
		
		
		createSummaryTable(writer, data);
		createSimplificationTable(writer);
		
		writer.write("</body>");
		writer.write(LINE_SEPARATOR);
		writer.write("</html>");
		writer.write(LINE_SEPARATOR);
	}

	private void createSimplificationTable(Writer writer) throws IOException {
		Map<TypeName, Type> mergedTypes = getAllCase3MergedTypes();
		writer.write("<table style=\"width: 80%\">");
		writer.write(LINE_SEPARATOR);
		writer.write("<thead><tr><th style=\"text-align: left\">Type Name</th><th>Action</th></tr></thead>");
		writer.write(LINE_SEPARATOR);
		writer.write("<tbody>");
		for (MessagePart part : this.messageSet.getAllMessageParts()) {
			TypeName name = new TypeName(part.getName());
			
			
			writer.write(LINE_SEPARATOR);
			writer.write("<tr><td>");
			writer.write(name.getName());
			writer.write("</td>");

			if (this.result.getTypes().containsKey(name)) {
				writer.write("<td colspan=\"2\">written</td>");
			} else if (mergedTypes.containsKey(name)) {
				writer.write("<td>merged</td><td>");
				Type type = mergedTypes.get(name);
				boolean first = true;
				for (TypeName merged : type.getMergedTypes()) {
					if (!first) {
						writer.write("<br />");
					}
					writer.write(merged.getName());
					first = false;
				}
				writer.write("</td>");
			} else {
				writer.write("<td colspan=\"2\">inlined</td>");
			}
			writer.write("</tr>");
			
		}
		writer.write(LINE_SEPARATOR);
		writer.write("</tfoot>");
		writer.write(LINE_SEPARATOR);
		writer.write("</table>");
		writer.write(LINE_SEPARATOR);
	}

	private Map<TypeName, Type> getAllCase3MergedTypes() {
		Map<TypeName,Type> mergedType = new HashMap<TypeName,Type>();
		for (Type type : this.result.getAllMessageTypes()) {
			TypeName name = type.getName();
			if (name instanceof TemporaryTypeName) {
				for (TypeName mergedName : type.getMergedTypes()) {
					mergedType.put(mergedName, type);
				}
			}
		}
		return mergedType;
	}

	private void createSummaryTable(Writer writer, ReportData data) throws IOException {
		writer.write("<table style=\"width: 80%\">");
		writer.write(LINE_SEPARATOR);
		writer.write("<thead><tr><th style=\"text-align: left\">Parts</th><th>Original</th><th>After simplification</th><th>Simplification</th></tr></thead>");
		writer.write(LINE_SEPARATOR);
		writer.write("<tbody>");
		
		writer.write(LINE_SEPARATOR);
		writer.write("<tr><td>Interactions</td><td style=\"text-align: center\">");
		writer.write(String.valueOf(data.getOriginalCounts().getInteractions()));
		writer.write("</td><td style=\"text-align: center\">");
		writer.write(String.valueOf(data.getSimplifiedCounts().getInteractions()));
		writer.write("</td><td style=\"text-align: center\">");
		writer.write(createPercentage(
				data.getOriginalCounts().getInteractions(),
				data.getSimplifiedCounts().getInteractions()));
		writer.write("</td></tr>");

		writer.write(LINE_SEPARATOR);
		writer.write("<tr><td>Complex message types</td><td style=\"text-align: center\">");
		writer.write(String.valueOf(data.getOriginalCounts().getMessageTypes()));
		writer.write("</td><td style=\"text-align: center\">");
		writer.write(String.valueOf(data.getSimplifiedCounts().getMessageTypes()));
		writer.write("</td><td style=\"text-align: center\">");
		writer.write(createPercentage(
				data.getOriginalCounts().getMessageTypes(),
				data.getSimplifiedCounts().getMessageTypes()));
		writer.write("</td></tr>");
		
		writer.write(LINE_SEPARATOR);
		writer.write("<tr><td>Attributes</td><td style=\"text-align: center\">");
		writer.write(String.valueOf(data.getOriginalCounts().getAttributes()));
		writer.write("</td><td style=\"text-align: center\">");
		writer.write(String.valueOf(data.getSimplifiedCounts().getAttributes()));
		writer.write("</td><td style=\"text-align: center\">");
		writer.write(createPercentage(
				data.getOriginalCounts().getAttributes(),
				data.getSimplifiedCounts().getAttributes()));
		writer.write("</td></tr>");
		
		writer.write(LINE_SEPARATOR);
		writer.write("<tr><td>Associations</td><td style=\"text-align: center\">");
		writer.write(String.valueOf(data.getOriginalCounts().getAssociations()));
		writer.write("</td><td style=\"text-align: center\">");
		writer.write(String.valueOf(data.getSimplifiedCounts().getAssociations()));
		writer.write("</td><td style=\"text-align: center\">");
		writer.write(createPercentage(
				data.getOriginalCounts().getAssociations(),
				data.getSimplifiedCounts().getAssociations()));
		writer.write("</td></tr>");
		
		writer.write(LINE_SEPARATOR);
		writer.write("</tbody>");
		writer.write(LINE_SEPARATOR);
		writer.write("<tfoot>");
		
		writer.write(LINE_SEPARATOR);
		writer.write("<tr><td>Total</td><td style=\"text-align: center\">");
		writer.write(String.valueOf(data.getOriginalCounts().getTotal()));
		writer.write("</td><td style=\"text-align: center\">");
		writer.write(String.valueOf(data.getSimplifiedCounts().getTotal()));
		writer.write("</td><td style=\"text-align: center\">");
		writer.write(createPercentage(
				data.getOriginalCounts().getTotal(),
				data.getSimplifiedCounts().getTotal()));
		writer.write("</td></tr>");
		
		writer.write(LINE_SEPARATOR);
		writer.write("</tfoot>");
		writer.write(LINE_SEPARATOR);
		writer.write("</table>");
		writer.write(LINE_SEPARATOR);
	}

	private String createPercentage(int original, int simplified) {
		NumberFormat formatter = new DecimalFormat("##0.0%");
		if (original == 0) {
			return formatter.format(0);
		} else {
			return formatter.format(((double) original - (double) simplified) / (double) original);
		}
	}

	private int getSimplifiedNumberOfTypes() {
		return this.result.getAllMessageTypes().size();
	}

	private int getOriginalNumberOfTypes() {
		return this.messageSet.getAllMessageParts().size();
	}

	private int getSimplifiedNumberOfAttributes() {
		return countSimplified(RelationshipType.ATTRIBUTE);
	}
	
	private int getOriginalNumberOfAttributes() {
		return countOriginal(RelationshipType.ATTRIBUTE);
	}
	
	private int getSimplifiedNumberOfAssociations() {
		return countSimplified(RelationshipType.ASSOCIATION);
	}
	
	private int countSimplified(RelationshipType relationshipType) {
		int count = 0;
		for (Type type : this.result.getAllMessageTypes()) {
			for (BaseRelationship relationship : type.getRelationships()) {
				if (relationship.getRelationshipType() == relationshipType) {
					count++;
				}
			}
		}
		return count;
	}

	private int getOriginalNumberOfAssociations() {
		return countOriginal(RelationshipType.ASSOCIATION);
	}
	
	private int countOriginal(RelationshipType relationshipType) {
		int count = 0;
		for (MessagePart part : this.messageSet.getAllMessageParts()) {
			for (Relationship relationship : part.getRelationships()) {
				if (relationship.isAssociation() && relationshipType == RelationshipType.ASSOCIATION) {
					count++;
				} else if (relationship.isAttribute() && relationshipType == RelationshipType.ATTRIBUTE) {
					count++;
				}
			}
		}
		return count;
	}

	private int getSimplifiedNumberOfInteractions() {
		return this.result.getAllInteractions().size();
	}

	private int getOriginalNumberOfInteractions() {
		return this.messageSet.getInteractions().size();
	}
}

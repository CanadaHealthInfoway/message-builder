package ca.infoway.messagebuilder.generator.lang;

 import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.SystemUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import ca.infoway.messagebuilder.xml.Documentation;

public class TypeDocumentation {
	
	public abstract class BaseWriter extends Indenter {
	    public String renderText(int indentLevel, String... text) {
	        StringBuilder buffer = new StringBuilder();
	        if (!isEmpty(text)) {
	            indent(indentLevel, buffer);
	            buffer.append("/**");
	                
	            for (int j = 0, numberOfBlocks = text == null ? 0 : text.length; j < numberOfBlocks; j++) {
	            	renderParagraph(getTagName(j), StringUtils.split(text[j]), buffer, indentLevel);
	                if (j < numberOfBlocks-1) {
	                    appendBlankDocLine(indentLevel, buffer);
	                }
	            }
	            buffer.append(SystemUtils.LINE_SEPARATOR);
	            indent(indentLevel, buffer);
	            buffer.append(" */");
	            buffer.append(SystemUtils.LINE_SEPARATOR);
	            
	        }
	        return buffer.toString();
	    }
		protected void renderParagraph(String tagName, String[] words,
				StringBuilder buffer, int indentLevel) {
			for (int i = 0, lineLength = 0, length = words == null ? 0 : words.length; i < length; i++) {
			    if (i == 0 || lineLength + words[i].length() > 60) {
			        appendBlankDocLine(indentLevel, buffer);
			        if (i == 0) {
						buffer.append("<").append(tagName).append(">");
			            lineLength = tagName.length() + 2;
			        } else {
			            lineLength = 0;
			        }
			    }
			    
			    buffer.append(words[i]);
			    if (i == length-1) {
					buffer.append("</").append(tagName).append(">");
			    } else {
			    	buffer.append(" ");
			    }
			    lineLength += words[i].length() + 1;
			}
		}
		protected String getTagName(int blockNumber) {
			return "p";
		}
	    private void appendBlankDocLine(int indentLevel, StringBuilder buffer) {
	        buffer.append(SystemUtils.LINE_SEPARATOR);
	        indent(indentLevel, buffer);
	        buffer.append(" * ");
	    }

	    private boolean isEmpty(String[] text) {
	        boolean empty = true;
	        for (int i = 0, length = text == null ? 0 : text.length; i < length; i++) {
	            empty &= StringUtils.isBlank(text[i]);
	        }
	        return empty;
	    }
	}
	
	public class CSharpWriter extends BaseWriter {
		
		@Override
		protected String getTagName(int blockNumber) {
			if (blockNumber == 0) {
				return "summary";
			} else {
				return "remarks";
			}
		}

		public void writeDoc(int indentLevel, Writer writer) throws IOException {
			String[] text = getText();
			
			if (text == null || text.length == 0) {
				// do nothing
			} else if (text.length == 1) {
				writer.write(renderText(indentLevel, text[0]));
			} else {
				String summary = text[0];
				String rest = StringUtils.join(ArrayUtils.subarray(text, 1, text.length), " ");
				writer.write(renderText(indentLevel, summary, rest));
			}
		}
	}

	public class JavadocWriter extends BaseWriter {

	    public void writeDoc(int indentLevel, Writer writer) throws IOException {
            writer.write(LINE_SEPARATOR);
            writer.write(renderText(indentLevel, getText()));
	    }	
	}
	
	private final Documentation documentation;

	public TypeDocumentation(Documentation documentation) {
		this.documentation = documentation;
	}

	private String[] getText() {
		if (this.documentation == null) {
			return new String[0];
		} else {
			List<String> text = new ArrayList<String>();
			if (StringUtils.isNotBlank(this.documentation.getBusinessName())) {
				text.add(cleanText(this.documentation.getBusinessName()));
			}
			text.addAll(cleanText(this.documentation.getParagraphs()));
	        return text.toArray(new String[0]);
		}
    }

    private List<String> cleanText(List<String> strings) {
    	List<String> results = new ArrayList<String>();
    	for (String string : strings) {
    		results.add(cleanText(string));
    	}
		return results;
	}

	private String cleanText(String string) {
		StringBuilder builder = null;
		byte[] bytes = string == null ? null : string.getBytes();
		if (bytes != null) {
			builder = new StringBuilder(string.length());
			for (byte b : bytes) {
				if (b == '\n') {
					builder.setLength(0);
				}
				if (isSpecialCharacter(b)) {
					// in most cases this will be a single or double quote
					builder.append('\'');
				} else {
					builder.append(new String(new byte[] {b}));
				}
			}
		}
		return builder == null ? null : builder.toString();
	}
	
	private boolean isSpecialCharacter(byte b) {
		return !(128 > b && b >= 0);
	}

	public void write(ProgrammingLanguage language, Writer writer, int indentLevel) throws IOException {
    	if (language == ProgrammingLanguage.C_SHARP) {
    		new CSharpWriter().writeDoc(indentLevel, writer);
    	} else {
    		new JavadocWriter().writeDoc(indentLevel, writer);
    	}
    }
    
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (getClass() != obj.getClass()) {
			return false;
		} else {
			TypeDocumentation that = (TypeDocumentation) obj;
			// some trivial differences will match
			// TODO - TM/AG - might want to cache getText instead of building it each time
			return new EqualsBuilder()
					.append(this.getText(), that.getText()) 
					.isEquals();
		}
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
		.append(this.getText())
		.toHashCode();
	}
}

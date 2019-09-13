/**
 * Copyright 2013 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

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

import ca.infoway.messagebuilder.generator.util.ProgrammingLanguage;
import ca.infoway.messagebuilder.xml.Annotation;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.Relationship;

public class TypeDocumentation {
	
	public abstract class BaseWriter extends Indenter {
//	    private static final int MAX_DOC_SIZE = 10000;

		public String renderText(int indentLevel, String... text) {
	        StringBuilder buffer = new StringBuilder();
	        if (!isEmpty(text)) {
	            indent(indentLevel, buffer);
	            buffer.append("/**");
	                
	            for (int j = 0, numberOfBlocks = text == null ? 0 : text.length; j < numberOfBlocks; j++) {
	            	renderParagraph(getTagName(j), StringUtils.split(cleanHTML(text[j])), buffer, indentLevel);
	                if (j < numberOfBlocks-1) {
	                    appendBlankDocLine(indentLevel, buffer);
	                }
	            }
	            // Disabling, because the truncation was screwing up HTML tags in the Javadoc comments
//	            if (buffer.length() > MAX_DOC_SIZE) {
//	            	buffer.setLength(MAX_DOC_SIZE);
//	                appendBlankDocLine(indentLevel, buffer);
//	            	buffer.append("... [rest of documentation truncated due to excessive length]");
//	            }
	            buffer.append(SystemUtils.LINE_SEPARATOR);
	            indent(indentLevel, buffer);
	            buffer.append(" */");
	            buffer.append(SystemUtils.LINE_SEPARATOR);
	        }
	        return buffer.toString();
	    }
		protected void renderParagraph(String tagName, String[] words,
				StringBuilder buffer, int indentLevel) {
			boolean htmlMarkup = words[0].startsWith("<p") || words[0].startsWith("<div")  || words[0].startsWith("<ul");
			for (int i = 0, lineLength = 0, length = words == null ? 0 : words.length; i < length; i++) {
			    if (i == 0 || lineLength + words[i].length() > 60) {
			        appendBlankDocLine(indentLevel, buffer);
			        if (i == 0 && !htmlMarkup) {
						buffer.append("<").append(tagName).append(">");
			            lineLength = tagName.length() + 2;
			        } else {
			            lineLength = 0;
			        }
			    }
			    
			    buffer.append(words[i]);
			    if (i == length-1 && htmlMarkup) {
			    	// do nothing
			    } else if (i == length-1) {
					buffer.append("</").append(tagName).append(">");
			    } else {
			    	buffer.append(" ");
			    }
			    lineLength += words[i].length() + 1;
			}
		}
		protected String cleanHTML(String text) {
			// Some annotations contain badly formatted HTML, which is causing the Javadoc generation to fail
			String tempString = StringUtils.replace(text, "/*", " ");
			tempString = StringUtils.replace(tempString, "*/", " ");
			
			StringBuffer buf = new StringBuffer(tempString);
			stripTags(buf, "font");
			stripTags(buf, "b");
			stripTags(buf, "o:p");
			stripTags(buf, "st1:place");
			stripTags(buf, "st1:state");
			stripAttribute(buf, "span", "lang");
			balanceTags(buf, "p");
			
			return buf.toString();
		}
		private void stripTags(StringBuffer buf, String tagName) {
			stripTag(buf, "<" + tagName);
			stripTag(buf, "</" + tagName);
		}
		private void stripTag(StringBuffer buf, String tagPrefix) {
			int tagStartIndex = buf.indexOf(tagPrefix);
			while (tagStartIndex >= 0) {
				int tagEndIndex = buf.indexOf(">", tagStartIndex);
				if (tagEndIndex >= tagStartIndex) {
					buf.delete(tagStartIndex, tagEndIndex+1);
				} else {
					buf.setLength(tagStartIndex);
				}
				tagStartIndex = buf.indexOf(tagPrefix);
			}
		}
		private void balanceTags(StringBuffer buf, String tagName) {
			String startTag = "<" + tagName;
			String endTag = "</" + tagName + ">";
			
			balanceNextPairOfTags(buf, 0, startTag, endTag);
			
		}
		private void balanceNextPairOfTags(StringBuffer buf, int cursor, String startTag, String endTag) {
			int tagStartIndex = buf.indexOf(startTag, cursor);
			int tagEndIndex = buf.indexOf(endTag, cursor);
			int tagEndLength = endTag.length();
			
			// if there are any end tags before the first start tag (or there are no start tags), delete them
			while (tagEndIndex >= 0 && (tagEndIndex < tagStartIndex || tagStartIndex == -1)) {
				buf.delete(tagEndIndex, tagEndIndex + tagEndLength);
				tagStartIndex = buf.indexOf(startTag, cursor);
				tagEndIndex = buf.indexOf(endTag, cursor);
			}
			
			if (tagStartIndex >= 0) {
				int nextTagStartIndex = buf.indexOf(startTag, tagStartIndex + 1);
				if (tagEndIndex >= 0 && (tagEndIndex < nextTagStartIndex || nextTagStartIndex == -1)) {
					// we found a balanced pair, so carry on
					cursor = tagEndIndex + tagEndLength;
					balanceNextPairOfTags(buf, cursor, startTag, endTag);
				} else if (nextTagStartIndex >= 0) {
					// we found an implicit close, make it explicit
					buf.insert(nextTagStartIndex, endTag);
					cursor = nextTagStartIndex + tagEndLength;
					balanceNextPairOfTags(buf, cursor, startTag, endTag);
				} else {
					// we didn't find any more tags at all, so close the current tag at the end of the buffer
					buf.append(endTag);
				}
			}
		}
		private void stripAttribute(StringBuffer buf, String tagName, String attributeName) {
			String tagPrefix = "<" + tagName;
			String attributePrefix = attributeName + "=\"";
			
			int tagStartIndex = buf.indexOf(tagPrefix);
			while (tagStartIndex >= 0) {
				int tagEndIndex = buf.indexOf(">", tagStartIndex);
				int attributeStartIndex = buf.indexOf(attributePrefix, tagStartIndex);
				if (attributeStartIndex >= 0 && attributeStartIndex < tagEndIndex) {
					int attributeEndIndex = buf.indexOf("\"", attributeStartIndex + attributePrefix.length());
					if (attributeEndIndex == -1) {
						buf.setLength(attributeStartIndex);
					} else {
						buf.delete(attributeStartIndex, attributeEndIndex+1);
					}
				}
				tagStartIndex = buf.indexOf(tagPrefix, tagEndIndex);
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
	private final Relationship relationship;

	public TypeDocumentation(Documentation documentation) {
		this(documentation, null);
	}
	
	public TypeDocumentation(Documentation documentation, Relationship relationship) {
		this.documentation = documentation;
		this.relationship = relationship;
	}

	private String[] getText() {
		List<String> text = new ArrayList<String>();
		if (this.documentation != null && StringUtils.isNotBlank(this.documentation.getBusinessName())) {
			text.add("Business Name: " + cleanText(this.documentation.getBusinessName()));
		}
		if (this.relationship != null) {
			text.add("Relationship: " + this.relationship.getParentType() + "." + this.relationship.getName());
			text.add("Conformance/Cardinality: " + this.relationship.getConformance() + " (" + this.relationship.getCardinality() + ")");
		}
		if (this.documentation != null) {
			text.addAll(cleanText(this.documentation.getAnnotations()));
		}
        return text.toArray(new String[0]);
    }

    private List<String> cleanText(List<Annotation> list) {
    	List<String> results = new ArrayList<String>();
    	for (Annotation string : list) {
    		results.add(cleanText(string.getText()));
    	}
		return results;
	}

	protected String cleanText(String string) {
		StringBuilder builder = null;
		byte[] bytes = string == null ? null : string.getBytes();
		if (bytes != null) {
			builder = new StringBuilder(string.length());
			for (byte b : bytes) {
				if (b == '\n') {
					builder.append(' ');
//					builder.setLength(0);  // TM - this seemed to be causing information to be lost
				} else if (isSpecialCharacter(b)) {
					// in most cases this will be a single or double quote
					builder.append('\'');
				} else {
					builder.append(new String(new byte[] {b}));
				}
			}
		}
		return builder == null ? null : builder.toString().trim();
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
			// TM/AG - might want to cache getText instead of building it each time
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
	
	public Documentation getOriginalDocumentation() {
		return this.documentation;
	}
}

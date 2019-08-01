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

package ca.infoway.messagebuilder.mifcomparer;

import static ca.infoway.messagebuilder.mifcomparer.Message.MessageType.*;
import static ca.infoway.messagebuilder.mifcomparer.Message.ObjectType.*;
import static ca.infoway.messagebuilder.mifcomparer.Message.Severity.*;

import java.io.File;

import javax.xml.namespace.NamespaceContext;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import ca.infoway.messagebuilder.util.xml.XmlDescriber;

/**
 * Filter which takes an XPath expression, which must match {@link Element}s; and a namespace URI and tag name.
 * For each Element matching the XPath expression, it ensures that the Element's only children are Elements
 * matching the given namespace and tag name.  If there are children that don't match (or aren't Elements),
 * a newly created wrapper Element is interposed between them and their parent.
 * If some children are wrapper Elements and some not, no change is made, but a warning is issued.
 * 
 * (Note that child text nodes that are all whitespace are ignored for purposes of deciding whether to
 * interpose a wrapper element, but if one is interposed, such children <i>are</i> included in it.)
 * 
 * <h3>Namespace handling</h3>
 * 
 * <p>If {@code wrapperNsURI} gives the namespace that any existing wrapper is expected to be in, and that a new wrapper
 * will be put in if it needs to be added.  If passed as {@code null} or {@code ""}, existing wrappers will only match if not in any namespace,
 * and added wrappers won't be in any namespace either.
 * 
 * <p>If a wrapper element needs to be added, and it is to be in a namespace, its namespace prefix will be looked up in
 * {@code nsContext}. An appropriate {@code xmlns} attribute will be added on the new element if necessary.
 * 
 * <h3>Examples</h3>
 * In all of these, the XPath expression matches &lt;target&gt; elements, and the tag name is {@code W}.
 * 
 * <p>{@code <outer><target><a/><b/></target></outer>} produces {@code <outer><target><W><a/><b/></W></target></outer>} .
 * 
 * <p>{@code <outer><target><W>a</W></target></outer>} already satisfies the requirement, so is not modified.
 * 
 * <p>{@code <outer><target><W>a</W><W><sub/></W></target></outer>} likewise.
 * 
 * <p>{@code <outer><target><W>a</W> some text <W><sub/></W></target></outer>} makes no change, but warns about it
 * 
 * 
 * 
 * <p>ISSUE: What to do if the target is empty: leave it alone, or insert an empty wrapper?  Currently we do the former.
 */
public class XmlWrapContentFilter extends XmlIndependentFilterBase {
	private String wrapperNsURI;
	private String wrapperNsPrefix;
	private String wrapperLocalName;
	private String wrapperQName;
	
	public XmlWrapContentFilter(NamespaceContext nsContext, String[] args) {
		if (args.length != 3)
			throw new IllegalArgumentException("Expecting 3 args, but got " + args.length);
		else
			initialize(nsContext, args[0], args[1], args[2]);
	}
	
	/**
	 * Create an {@link XmlWrapContentFilter} instance.
	 * 
	 * @param	nsContext		This maps the namespace prefixes that will be used in this filter to their corresponding namespace URIs
	 * @param	wrapperNsURI	The namespace URI of the desired wrapper element
	 * @param	wrapperTag		The tag name of the desired wrapper element
	 * @param	xpathExpr		Specifies the Element nodes whose content is to be wrapped
	 */ 
	public XmlWrapContentFilter(NamespaceContext nsContext, String wrapperNsURI, String wrapperTag, String xpathExpr) {
		initialize(nsContext, wrapperNsURI, wrapperTag, xpathExpr);
	}
		
	public void initialize(NamespaceContext nsContext, String wrapperNsURI, String wrapperTag, String xpathExpr) {
		super.initialize(nsContext, xpathExpr);
		
		if (wrapperNsURI == null || wrapperNsURI.equals("")) {
			this.wrapperNsURI = null;
			this.wrapperNsPrefix = "";
		} else {
			this.wrapperNsURI = wrapperNsURI;
			this.wrapperNsPrefix = this.nsContext.getPrefix(this.wrapperNsURI);
		}
		
		this.wrapperLocalName = wrapperTag;
		
		if (wrapperNsPrefix.equals("")) {
			wrapperQName = wrapperLocalName;
		} else {
			if (wrapperNsURI == null) {
				throw new FatalConditionException(
						String.format("wrap-content filter for \"%s:%s\" can't have a namespace prefix but no URI",
								wrapperNsPrefix, wrapperLocalName));
			}
			
			wrapperQName = wrapperNsPrefix + ":" + wrapperLocalName;
		}
		
		XPathFactory xpf = XPathFactory.newInstance();
		xpath = xpf.newXPath();
		if (nsContext != null)
			xpath.setNamespaceContext(nsContext);
	}

	@Override
	void filterNode(File f, Node n, MessageList msgs) {
		if (needsWrap(f, n, msgs)) {
			wrap(f, (Element)n, msgs);
		}
	}
	
	boolean needsWrap(File f, Node n, MessageList msgs) {
		if (n.getNodeType() != Node.ELEMENT_NODE) {
			throw new FatalConditionException(String.format("XPath expression \"%s\" matched a non-Element", this.xpathExpr));
		}
		
		Element e = (Element)n;
		
		boolean seenWrapperChild = false;
		boolean seenNonWrapperChild = false;
		
		NodeList children = e.getChildNodes();
		for (int i=0; i<children.getLength(); ++i) {
			Node c = children.item(i);

			switch (c.getNodeType()) {
			case Node.TEXT_NODE:
				if (!((Text)c).getTextContent().trim().equals(""))
					seenNonWrapperChild = true;
				
				break;
			
			case Node.ELEMENT_NODE:
				if (equals(c.getNamespaceURI(), this.wrapperNsURI) &&
						c.getLocalName().equals(this.wrapperLocalName)) {
					seenWrapperChild = true;
				} else {
					seenNonWrapperChild = true;
				}
				
				break;
				
			default:
				seenNonWrapperChild = true;
				break;
			}
		}
		
		/*
		 * Truth table:
		 * 		seenNonWrapper		seenWrapper		needsWrap		Warn?
		 * 		n					n				n				n
		 * 		n					y				n				n
		 * 		y					n				y				n
		 * 		y					y				n				y
		 */
		if (!seenNonWrapperChild) {
			return false;
			
		} else if (!seenWrapperChild) {
			return true;
			
		} else {
			msgs.add(new Message(WARNING, FILTER,
					String.format("Not wrapping children in a (%s,%s) element, because some are already wrapped", this.wrapperNsURI, this.wrapperLocalName),
					f, null,
					XmlDescriber.describePath(e), null,
					ELEMENT, e.getNodeName(), null,
					null, null
					));
			return false;
		}
	}
		
	boolean equals(String s1, String s2) {
		if (s1 == null)
			return (s2 == null);
		else
			return s1.equals(s2);
	}
		
	
	void wrap(File f, Element e, MessageList msgs) {
		Element wrapper = e.getOwnerDocument().createElementNS(this.wrapperNsURI, this.wrapperQName);
		
		NodeList children = e.getChildNodes();
		
		// Subtlety: appending a child to a new Element removes it from the old one -- and also
		// from this NodeList.
		while (children.getLength() > 0) {
			Node c = children.item(0);
			wrapper.appendChild(c);
		}
		
		e.appendChild(wrapper);
	}
}

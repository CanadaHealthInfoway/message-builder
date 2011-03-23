package ca.infoway.messagebuilder.marshalling;

import org.w3c.dom.Document;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionService;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionServiceFactory;

public class MessageBeanTransformerImpl {
	
	private final MessageDefinitionService service;
	private final RenderMode renderMode;

	public MessageBeanTransformerImpl(MessageDefinitionService service, RenderMode renderMode) {
		this.service = service;
		this.renderMode = renderMode;
	}
	public MessageBeanTransformerImpl() {
		this(new MessageDefinitionServiceFactory().create(), RenderMode.STRICT);
	}
	public MessageBeanTransformerImpl(RenderMode renderMode) {
		this(new MessageDefinitionServiceFactory().create(), renderMode);
	}
	
	public XmlToModelResult transformFromHl7(VersionNumber version, Document hl7Message) {
		return new Hl7SourceMapper().mapToTeal(new Hl7MessageSource(version.getVersionLiteral(), hl7Message, this.service));
	}
	
	// FIXME - TM - should return JavaToXmlResult (every transformation test will require changing)
	public String transformToHl7(VersionNumber version, InteractionBean messageBean) {
		return transformToHl7AndReturnResult(version, messageBean).getXmlMessage();
	}
	
	public ModelToXmlResult transformToHl7AndReturnResult(VersionNumber version, InteractionBean messageBean) {
		XmlRenderingVisitor visitor = new XmlRenderingVisitor();
		new TealBeanRenderWalker(messageBean, version, this.service).accept(visitor);
		ModelToXmlResult result = visitor.toXml();
		if (!result.isValid() && isStrict()) {
			throw new InvalidRenderInputException(result.getHl7Errors());
		}
		return result;
	}
	private boolean isStrict() {
		return this.renderMode == RenderMode.STRICT;
	}
}

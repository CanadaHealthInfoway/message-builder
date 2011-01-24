package ca.infoway.messagebuilder.marshalling.hl7.parser;

import ca.infoway.messagebuilder.marshalling.hl7.Registry;

@SuppressWarnings("unchecked")
public class ParserRegistry extends Registry<ElementParser> {

    private static ParserRegistry instance = new ParserRegistry();

    private ParserRegistry() {
    }

    @Override
    protected void registerAll() {
        register(new AdElementParser());
        register(new AnyElementParser());
        register(new BagElementParser());
        register(new BlElementParser());
        register(new CsElementParser());
        register(new CvElementParser());
        register(new EdElementParser());
        register(new EdSignatureElementParser());
        register(new EnElementParser());
        register(new IiElementParser());
        register(new IntElementParser());
        register(new GtsBoundedPivlElementParser());
        register(new PivlTsElementParser());
        register(new PivlTsDateTimeElementParser());
        register(new IvlIntElementParser());
        register(new IvlPqElementParser());
        register(new IvlTsElementParser());
        register(new ListElementParser());
        register(new SetElementParser());
        register(new MoElementParser());
        register(new OnElementParser());
        register(new PnElementParser());
        register(new PqElementParser());
        register(new RealElementParser());
        register(new RtoQtyQtyElementParser());
        register(new RtoPqPqElementParser());
        register(new ScElementParser());
        register(new StElementParser());
        register(new TelElementParser());
        register(new TnElementParser());
        register(new TsElementParser());
        register(new UrgPqElementParser());
    }

    public static ParserRegistry getInstance() {
        return instance;
    }
}

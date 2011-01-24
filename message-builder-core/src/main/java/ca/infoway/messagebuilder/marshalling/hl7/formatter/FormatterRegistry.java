package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import ca.infoway.messagebuilder.marshalling.hl7.Registry;

public class FormatterRegistry extends Registry<PropertyFormatter> {

    private static FormatterRegistry instance = new FormatterRegistry();

    public static FormatterRegistry getInstance() {
        return instance;
    }

    private FormatterRegistry() {
    }

    @Override
    protected void registerAll() {
        register(new AdBasicPropertyFormatter());
        register(new AdPropertyFormatter());
        register(new AnyPropertyFormatter());
        register(new BagPropertyFormatter());
        register(new BlPropertyFormatter());
        register(new GtsBoundedPivlFormatter());
        register(new CdPropertyFormatter());
        register(new CsPropertyFormatter());
        register(new CvPropertyFormatter());
        register(new EdPropertyFormatter());
        register(new EdSignaturePropertyFormatter());
        register(new EnPropertyFormatter());
        register(new IiPropertyFormatter());
        register(new IntPropertyFormatter());
        register(new IntNonNegPropertyFormatter());
        register(new IntPosPropertyFormatter());
        register(new IvlIntPropertyFormatter());
        register(new IvlPqPropertyFormatter());
        register(new IvlTsPropertyFormatter());
        register(new PivlTsPropertyFormatter());
        register(new MoPropertyFormatter());
        register(new OnPropertyFormatter());
        register(new PnPropertyFormatter());
        register(new PqPropertyFormatter());
        register(new PqBasicPropertyFormatter());
        register(new PqDrugPropertyFormatter());
        register(new PqHeightWeightPropertyFormatter());
        register(new RealConfPropertyFormatter());
        register(new RealCoordPropertyFormatter());
        register(new RtoQtyQtyPropertyFormatter());
        register(new RtoPqPqPropertyFormatter());
        register(new ScPropertyFormatter());
        register(new SetPropertyFormatter());
        register(new ListPropertyFormatter());
        register(new StPropertyFormatter());
        registerTelPhonemailFormatter();
        registerTelUriFormatter();
        register(new TnPropertyFormatter());
        register(new TsFullDatePropertyFormatter());
        register(new TsFullDateTimePropertyFormatter());
        register(new UrgPqPropertyFormatter());
    }

    private void registerTelPhonemailFormatter() {
        if (isLenientFormatting()) {
            register(new LenientTelPhonemailPropertyFormatter());
        } else {
            register(new TelPhonemailPropertyFormatter());
        }
    }

    private void registerTelUriFormatter() {
        if (isLenientFormatting()) {
            register(new LenientTelUriPropertyFormatter());
        } else {
            register(new TelUriPropertyFormatter());
        }
    }

    private boolean isLenientFormatting() {
        return true;//BooleanUtils.toBoolean(System.getProperty("lenientCeRxFormatter", "true"))
    }
}

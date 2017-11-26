package bean;

public final class HeaderBuilder {

    private String header;

    private HeaderBuilder() {
    }

    public static HeaderBuilder aHeader() {
        return new HeaderBuilder();
    }

    public HeaderBuilder withHeader(String header) {
        this.header = header;
        return this;
    }

    public Header build() {
        Header object = new Header();
        object.setHeader(header);
        return object;
    }
}

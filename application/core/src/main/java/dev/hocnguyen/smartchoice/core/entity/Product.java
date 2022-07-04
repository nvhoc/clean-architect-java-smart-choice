package dev.hocnguyen.smartchoice.core.entity;


public class Product {
    private final String uuid;
    private final String siteProvider;
    private String name;
    private String link;
    private Price price;
    private Promotion promotion;
    private String metaData;

    public Product(String uuid, String name, String siteProvider, String link, Price price, Promotion promotion, String metaData) {
        this.uuid = uuid;
        this.name = name;
        this.siteProvider = siteProvider;
        this.link = link;
        this.price = price;
        this.promotion = promotion;
        this.metaData = metaData;
    }

    public String getSiteProvider() {
        return siteProvider;
    }

    public String getUuid() {
        return uuid;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getMetaData() {
        return metaData;
    }

    public void setMetaData(String metaData) {
        this.metaData = metaData;
    }
}

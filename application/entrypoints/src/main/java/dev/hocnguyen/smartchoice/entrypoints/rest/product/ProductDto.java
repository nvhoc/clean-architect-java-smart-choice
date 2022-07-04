package dev.hocnguyen.smartchoice.entrypoints.rest.product;

import dev.hocnguyen.smartchoice.core.entity.Price;
import dev.hocnguyen.smartchoice.core.entity.Product;
import dev.hocnguyen.smartchoice.core.entity.Promotion;

public class ProductDto {

  private final String uuid;
  private final String siteProvider;
  private final String name;

  private final String link;
  private final String price;
  private final String promotion;

  public ProductDto (Product product) {
    this.uuid = product.getUuid();
    this.siteProvider = product.getSiteProvider();
    this.name = product.getName();
    this.link = product.getLink();

    Price price = product.getPrice();
    this.price = String.format("%s %s", price.getValue(), price.getUnit());

    Promotion promotion = product.getPromotion();
    this.promotion = String.format("%s %s", promotion.getValue(), promotion.getType());
  }


  public String getSiteProvider() {
    return siteProvider;
  }

  public String getLink() {
    return link;
  }

  public String getName() {
    return name;
  }

  public String getUuid() {
    return uuid;
  }

  public String getPrice() {
    return price;
  }

  public String getPromotion() {
    return promotion;
  }
}

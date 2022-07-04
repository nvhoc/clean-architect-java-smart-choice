package dev.hocnguyen.smartchoice.providers.thirdparty.esite;

import dev.hocnguyen.smartchoice.core.entity.Price;
import dev.hocnguyen.smartchoice.core.entity.PriceUnit;
import dev.hocnguyen.smartchoice.core.entity.Product;
import dev.hocnguyen.smartchoice.core.entity.Promotion;
import dev.hocnguyen.smartchoice.core.entity.PromotionType;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import org.springframework.scheduling.annotation.Async;

public class ShopeeESite implements ESiteFunctional {

  static final String SITE_PROVIDER = "Shopee";

  @Async
  @Override
  public CompletableFuture<Product> searchProduct(String name) {
    Price productPrice = new Price(30, PriceUnit.VND1000000);
    Promotion productPromotion = new Promotion(10, PromotionType.PERCENT);
    Product product = new Product(UUID.randomUUID().toString(), "Television 123", SITE_PROVIDER,
        "https://example.com/mock", productPrice, productPromotion, "{}");
    return CompletableFuture.completedFuture(product);
  }

  @Async
  @Override
  public CompletableFuture<Product> getProductByUUID(String UUID) {
    return null;
  }
}

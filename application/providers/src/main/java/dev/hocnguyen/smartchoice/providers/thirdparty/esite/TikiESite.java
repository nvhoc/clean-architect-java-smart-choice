package dev.hocnguyen.smartchoice.providers.thirdparty.esite;

import dev.hocnguyen.smartchoice.core.entity.*;
import java.util.concurrent.TimeUnit;
import org.springframework.scheduling.annotation.Async;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class TikiESite implements ESiteFunctional {

  static final String SITE_PROVIDER = "Tiki";


  @Async
  @Override
  public CompletableFuture<Product> searchProduct(String name) {
    Price productPrice = new Price(30, PriceUnit.VND1000000);
    Promotion productPromotion = new Promotion(10, PromotionType.PERCENT);
    Product product = new Product(UUID.randomUUID().toString(), "Television 123", SITE_PROVIDER,
        "https://example.com/mock", productPrice, productPromotion, "{}");
    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return CompletableFuture.completedFuture(product);
  }

  @Async
  @Override
  public CompletableFuture<Product> getProductByUUID(String UUID) {
    return null;
  }
}

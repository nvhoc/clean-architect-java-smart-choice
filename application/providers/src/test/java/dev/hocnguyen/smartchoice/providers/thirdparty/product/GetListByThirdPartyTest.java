package dev.hocnguyen.smartchoice.providers.thirdparty.product;

import dev.hocnguyen.smartchoice.core.entity.Price;
import dev.hocnguyen.smartchoice.core.entity.PriceUnit;
import dev.hocnguyen.smartchoice.core.entity.Product;
import dev.hocnguyen.smartchoice.core.entity.Promotion;
import dev.hocnguyen.smartchoice.core.entity.PromotionType;
import dev.hocnguyen.smartchoice.providers.thirdparty.esite.ESiteFunctional;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GetListByThirdPartyTest {

  private static final String SEARCH_NAME = "Television 123";
  private static final String TIKI_PROVIDE = "Tiki";
  private static final String LAZADA_PROVIDE = "Lazada";
  private static final String SHOPEE_PROVIDE = "Shopee";
  private static final String MOCK_LINK = "https://example.com/mock";
  private static final String MOCK_META_DATA = "{}";

  private final ESiteFunctional tikiESite = mock(ESiteFunctional.class);
  private final ESiteFunctional lazadaESite = mock(ESiteFunctional.class);
  private final ESiteFunctional shopeeESite = mock(ESiteFunctional.class);

  @Test
  public void testGetByESite() {
    givenAProductAllESites();
    List<Product> products = new GetListByThirdParty(tikiESite, lazadaESite, shopeeESite)
        .getByESite(SEARCH_NAME);

    for (Product product : products) {
      System.out.println(product.getSiteProvider());
    }
    assertArrayEquals(new String[] {TIKI_PROVIDE, LAZADA_PROVIDE, SHOPEE_PROVIDE},
        products.stream().map(Product::getSiteProvider).toArray());
  }

  private void givenAProductAllESites() {
    givenAProductTiki();
    givenAProductLazada();
    givenAProductShopee();
  }

  private void givenAProductTiki() {
    Price productPrice = new Price(30, PriceUnit.VND1000000);
    Promotion productPromotion = new Promotion(10, PromotionType.PERCENT);
    Product product = new Product(UUID.randomUUID().toString(), SEARCH_NAME, TIKI_PROVIDE,
        MOCK_LINK, productPrice, productPromotion, MOCK_META_DATA);
    when(tikiESite.searchProduct(SEARCH_NAME)).thenReturn(
        CompletableFuture.completedFuture(product));
  }

  private void givenAProductLazada() {
    Price productPrice = new Price(30, PriceUnit.VND1000000);
    Promotion productPromotion = new Promotion(10, PromotionType.PERCENT);
    Product product = new Product(UUID.randomUUID().toString(), SEARCH_NAME, LAZADA_PROVIDE,
        MOCK_LINK, productPrice, productPromotion, MOCK_META_DATA);
    when(lazadaESite.searchProduct(SEARCH_NAME)).thenReturn(
        CompletableFuture.completedFuture(product));
  }

  private void givenAProductShopee() {
    Price productPrice = new Price(30, PriceUnit.VND1000000);
    Promotion productPromotion = new Promotion(10, PromotionType.PERCENT);
    Product product = new Product(UUID.randomUUID().toString(), SEARCH_NAME, SHOPEE_PROVIDE,
        MOCK_LINK, productPrice, productPromotion, MOCK_META_DATA);
    when(shopeeESite.searchProduct(SEARCH_NAME)).thenReturn(
        CompletableFuture.completedFuture(product));
  }
}

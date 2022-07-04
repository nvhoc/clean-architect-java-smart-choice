package dev.hocnguyen.smartchoice.entrypoints.rest.product;

import dev.hocnguyen.smartchoice.core.entity.Price;
import dev.hocnguyen.smartchoice.core.entity.PriceUnit;
import dev.hocnguyen.smartchoice.core.entity.Product;
import dev.hocnguyen.smartchoice.core.entity.Promotion;
import dev.hocnguyen.smartchoice.core.entity.PromotionType;
import dev.hocnguyen.smartchoice.core.usecase.product.search.ProductSearchUC;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductSearchEndPointTest {

  private static final String SEARCH_NAME = "Television 123";
  private static final List<String> E_SITE_PROIVDERS = Arrays.asList("Tiki", "Lazada", "Shopee");
  private static final String MOCK_LINK = "https://example.com/mock";
  private static final String MOCK_META_DATA = "{}";

  ProductSearchUC productSearchUC = mock(ProductSearchUC.class);
  ProductSearchEndPoint productSearchEndPoint = new ProductSearchEndPoint(productSearchUC);

  @Test
  public void returnsListOfProductsWhenSearch() {
    givenAProductExistsInAllESite();
    ProductsDto response = productSearchEndPoint.search(SEARCH_NAME);
    assertArrayEquals(E_SITE_PROIVDERS.toArray(new String[0]),
        response.getData().stream().map(ProductDto::getSiteProvider).toArray());
  }

  private void givenAProductExistsInAllESite() {
    List<Product> products = E_SITE_PROIVDERS
        .stream()
        .map(eSite -> {
          Price productPrice = new Price(30, PriceUnit.VND1000000);
          Promotion productPromotion = new Promotion(10, PromotionType.PERCENT);
          return new Product(UUID.randomUUID().toString(), SEARCH_NAME, eSite,
              MOCK_LINK, productPrice, productPromotion, MOCK_META_DATA);
        })
        .collect(Collectors.toList());
    when(productSearchUC.getProductListByESiteProvider(SEARCH_NAME)).thenReturn(products);
  }
}
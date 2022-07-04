package dev.hocnguyen.smartchoice.entrypoints.rest.product;

import dev.hocnguyen.smartchoice.core.entity.Product;
import dev.hocnguyen.smartchoice.core.usecase.product.search.ProductSearchUC;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class ProductSearchEndPoint {
  public static final String API_PATH = "/product/search/{name}";
  private static final Logger logger = LoggerFactory.getLogger(ProductSearchEndPoint.class);
  private final ProductSearchUC productSearchUC;

  public ProductSearchEndPoint(ProductSearchUC productSearchUC) {
    this.productSearchUC = productSearchUC;
  }

  @RequestMapping(value = API_PATH, method = GET)
  public ProductsDto search(@PathVariable String name) {
    logger.info("Search product by name: {}", name);
    try {
      List<Product> products = productSearchUC.getProductListByESiteProvider(name);
      return toDto(products);
    } catch (Exception e) {
      logger.info("Bad request when search product : {}", name);
      throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

  private ProductsDto toDto(List<Product> products) {
    return new ProductsDto(products);
  }
}

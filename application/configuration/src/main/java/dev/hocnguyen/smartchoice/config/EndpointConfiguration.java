package dev.hocnguyen.smartchoice.config;

import dev.hocnguyen.smartchoice.core.usecase.product.search.ProductSearchUC;
import dev.hocnguyen.smartchoice.entrypoints.rest.product.ProductSearchEndPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EndpointConfiguration {

  @Bean
  public ProductSearchEndPoint productSearchEndPoint(ProductSearchUC productSearchUC) {
    return new ProductSearchEndPoint(productSearchUC);
  }
}

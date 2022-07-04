package dev.hocnguyen.smartchoice.config;

import dev.hocnguyen.smartchoice.core.usecase.product.search.GetProductList;
import dev.hocnguyen.smartchoice.core.usecase.product.search.ProductSearchUC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UCConfiguration {

  @Bean
  public ProductSearchUC productSearchUC(GetProductList getProductList) {
    return new ProductSearchUC(getProductList);
  }
}

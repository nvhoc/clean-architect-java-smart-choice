package dev.hocnguyen.smartchoice.entrypoints.rest.product;

import dev.hocnguyen.smartchoice.core.entity.Price;
import dev.hocnguyen.smartchoice.core.entity.Product;
import dev.hocnguyen.smartchoice.core.entity.Promotion;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsDto {
  private final List<ProductDto> data;

  public ProductsDto(List<Product> products) {
    this.data = products
        .stream()
        .map(ProductDto::new)
        .collect(Collectors.toList());
  }

  public List<ProductDto> getData() {
    return data;
  }
}


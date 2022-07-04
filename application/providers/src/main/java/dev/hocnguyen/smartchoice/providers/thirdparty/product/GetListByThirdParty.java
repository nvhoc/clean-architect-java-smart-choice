package dev.hocnguyen.smartchoice.providers.thirdparty.product;

import dev.hocnguyen.smartchoice.core.entity.Product;
import dev.hocnguyen.smartchoice.core.usecase.product.search.GetProductList;
import dev.hocnguyen.smartchoice.providers.thirdparty.esite.ESiteFunctional;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetListByThirdParty implements GetProductList {
  private static final Logger logger = LoggerFactory.getLogger(GetListByThirdParty.class);

  private final List<ESiteFunctional> eSites;

  public GetListByThirdParty(ESiteFunctional... eSites) {
    this.eSites = Arrays.asList(eSites);
  }

  @Override
  public List<Product> getByESite(String name) {
    logger.info("Search product by name: {}", name);
    List<CompletableFuture<Product>> productFutures = this.eSites.stream()
        .map(e -> e.searchProduct(name))
        .collect(Collectors.toList());
    CompletableFuture.allOf(productFutures.toArray(new CompletableFuture[0])).join();
    return productFutures.stream().map(f -> {
      try {
        return f.get();
      } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
      }
      return null;
    }).filter(Objects::nonNull).collect(Collectors.toList());
  }
}

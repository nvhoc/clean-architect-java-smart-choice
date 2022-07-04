package dev.hocnguyen.smartchoice.providers.thirdparty.esite;

import dev.hocnguyen.smartchoice.core.entity.Product;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;

public interface ESiteFunctional {

    CompletableFuture<Product> searchProduct(String name);

    CompletableFuture<Product> getProductByUUID(String UUID);
}

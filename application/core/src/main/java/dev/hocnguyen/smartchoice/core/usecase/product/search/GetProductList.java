package dev.hocnguyen.smartchoice.core.usecase.product.search;

import dev.hocnguyen.smartchoice.core.entity.Product;

import java.util.List;

public interface GetProductList {
    List<Product> getByESite(String name);
}

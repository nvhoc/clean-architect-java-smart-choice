package dev.hocnguyen.smartchoice.core.usecase.product.search;

import dev.hocnguyen.smartchoice.core.entity.Product;

import java.util.List;

public class ProductSearchUC {

    private final GetProductList getProductList;

    public ProductSearchUC(GetProductList getProductList) {
        this.getProductList = getProductList;
    }

    public List<Product> getProductListByESiteProvider(String name) {
        return this.getProductList.getByESite(name);
    }
}

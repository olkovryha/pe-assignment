package kata.supermarket;

import java.math.BigDecimal;

public class ItemByUnit implements Item {
    private final Product product;

    ItemByUnit(final Product product) {
        this.product = product;
    }

    public String name() { return product.productName();}
    public BigDecimal price() {
        return product.pricePerUnit();
    }
    public DiscountType discountType() { return product.discountType(); }
}

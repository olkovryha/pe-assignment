package kata.supermarket;

import java.math.BigDecimal;

public class Product {
    private final BigDecimal pricePerUnit;
    private DiscountType discountType = DiscountType.NONE;

    public Product(final BigDecimal pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public Product(final BigDecimal pricePerUnit, DiscountType discountType) {
        this.pricePerUnit = pricePerUnit;
        this.discountType = discountType;
    }


    BigDecimal pricePerUnit() {
        return pricePerUnit;
    }

    public DiscountType discountType() { return discountType; }

    public Item oneOf() {
        return new ItemByUnit(this);
    }
}

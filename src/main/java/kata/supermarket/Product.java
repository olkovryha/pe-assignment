package kata.supermarket;

import java.math.BigDecimal;

public class Product {
    private final String name;
    private final BigDecimal pricePerUnit;
    private DiscountType discountType = DiscountType.NONE;

    public Product(final String name, final BigDecimal pricePerUnit) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
    }

    public Product(final String name, final BigDecimal pricePerUnit, DiscountType discountType) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.discountType = discountType;
    }

    public String productName() { return name; }

    BigDecimal pricePerUnit() {
        return pricePerUnit;
    }

    public DiscountType discountType() { return discountType; }

    public Item oneOf() {
        return new ItemByUnit(this);
    }
}

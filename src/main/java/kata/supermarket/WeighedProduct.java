package kata.supermarket;

import java.math.BigDecimal;

public class WeighedProduct {
    private final BigDecimal pricePerKilo;

    private DiscountType discountType = DiscountType.NONE;

    public WeighedProduct(final BigDecimal pricePerKilo) {
        this.pricePerKilo = pricePerKilo;
    }

    public WeighedProduct(final BigDecimal pricePerKilo, DiscountType discountType) {
        this.pricePerKilo = pricePerKilo;
        this.discountType = discountType;
    }

    BigDecimal pricePerKilo() {
        return pricePerKilo;
    }

    public Item weighing(final BigDecimal kilos) {
        return new ItemByWeight(this, kilos);
    }
}

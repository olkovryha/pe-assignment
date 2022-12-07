package kata.supermarket;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

    @Test
    void singleItemHasExpectedNameAndUnitPriceFromProduct() {
        final String name = "Digestives";
        final BigDecimal price = new BigDecimal("2.49");
        assertEquals(price, new Product(name, price).oneOf().price());
        assertEquals(name, new Product(name, price).oneOf().name());
    }
}
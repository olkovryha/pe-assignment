package kata.supermarket;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThreeForTwoDiscountTest {

    @Test
    void discountItemsAreGroupedAsExpected() {
        final List<Item> items = Arrays.asList(new Product("Digestives", new BigDecimal("1.55")).oneOf(),
                new Product("Milk", new BigDecimal("0.49")).oneOf(),
                new Product("Milk", new BigDecimal("0.49")).oneOf());
        final Map<String, List<Item>> groupingItems = new TwoForDollarDiscount(items).getGroupingItems();
        assertEquals(groupingItems.get("Digestives").size(), 1);
        assertEquals(groupingItems.get("Milk").size(), 2);
    }

    @Test
    void discountIsCalculatedAsExpected() {
        final List<Item> items = Arrays.asList(new Product("Candies", new BigDecimal("0.63"), DiscountType.THREE_FOR_TWO).oneOf(),
                new Product("Candies", new BigDecimal("0.63"), DiscountType.THREE_FOR_TWO).oneOf(),
                new Product("Candies", new BigDecimal("0.63"), DiscountType.THREE_FOR_TWO).oneOf());
        Discount discount = Discount.link(new ThreeForTwoDiscount(items));
        assertEquals(discount.handle(), BigDecimal.valueOf(0.63));
    }
}

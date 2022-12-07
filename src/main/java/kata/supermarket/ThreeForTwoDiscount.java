package kata.supermarket;

import java.math.BigDecimal;
import java.util.List;

public class ThreeForTwoDiscount extends Discount{

    public ThreeForTwoDiscount(List<Item> itemList) {
        super(itemList);
    }

    @Override
    public BigDecimal handle() {
        BigDecimal discountAmount = getGroupingItems().values().stream()
                .filter(items -> items.size() >= 3 && items.get(0).discountType().equals(DiscountType.THREE_FOR_TWO))
                .map(items -> BigDecimal.valueOf(items.size() / 3).multiply(items.get(0).price()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return discountAmount.add(next());
    }
}

package kata.supermarket;

import java.math.BigDecimal;
import java.util.List;

public class TwoForDollarDiscount extends Discount {

    public TwoForDollarDiscount(List<Item> itemList) { super(itemList);}

    public BigDecimal handle() {
        BigDecimal discountAmount = getGroupingItems().values().stream()
                .filter(items -> items.get(0).discountType().equals(DiscountType.TWO_FOR_DOLLAR))
                .map(items -> BigDecimal.valueOf(items.size() / 2).multiply((items.get(0).price()
                        .multiply(BigDecimal.valueOf(2))
                        .subtract(BigDecimal.ONE))))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return discountAmount.add(next());
    }
}

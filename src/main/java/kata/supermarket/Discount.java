package kata.supermarket;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Discount implements DiscountLink {
    private Discount next;
    private List<Item> itemList;
    public Discount(List<Item> itemList) {
        this.itemList = itemList;
    }

    public static Discount link(Discount first, Discount... chain) {
        Discount head = first;
        for (Discount nextInChain: chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    public BigDecimal next() {
        if(next != null) {
            return next.handle();
        }
        return new BigDecimal(0);
    }

    protected Map<String, List<Item>> getGroupingItems() {
        if (itemList == null) {
            return Collections.emptyMap();
        }
        return itemList.stream().collect(Collectors.groupingBy(Item::name));
    }

}

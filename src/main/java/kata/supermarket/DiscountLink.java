package kata.supermarket;


import java.math.BigDecimal;

public interface DiscountLink {
    BigDecimal handle();
    BigDecimal next();
}

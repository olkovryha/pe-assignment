package kata.supermarket;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeighedProductTest {

    @ParameterizedTest
    @MethodSource
    void itemFromWeighedProductHasExpectedNameAndUnitPrice(String name, String pricePerKilo, String weightInKilos, String expectedPrice) {
        final WeighedProduct weighedProduct = new WeighedProduct(name, new BigDecimal(pricePerKilo));
        final Item weighedItem = weighedProduct.weighing(new BigDecimal(weightInKilos));
        assertEquals(name, weighedItem.name());
        assertEquals(new BigDecimal(expectedPrice), weighedItem.price());
    }

    static Stream<Arguments> itemFromWeighedProductHasExpectedNameAndUnitPrice() {
        return Stream.of(
                Arguments.of("Digestives", "100.00", "1.00", "100.00"),
                Arguments.of("Digestives", "100.00", "0.33333", "33.33"),
                Arguments.of("Digestives", "100.00", "0.33335", "33.34"),
                Arguments.of("Digestives", "100.00", "0", "0.00")
        );
    }

}
package kata.supermarket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasketTest {

    @DisplayName("basket provides its total value when containing...")
    @MethodSource
    @ParameterizedTest(name = "{0}")
    void basketProvidesTotalValue(String description, String expectedTotal, Iterable<Item> items) {
        final Basket basket = new Basket();
        items.forEach(basket::add);
        assertEquals(new BigDecimal(expectedTotal), basket.total());
    }

    static Stream<Arguments> basketProvidesTotalValue() {
        return Stream.of(
                noItems(),
                aSingleItemPricedPerUnit(),
                multipleItemsPricedPerUnit(),
                multipleItemsPricedPerUnitWithTwoForDollarDiscount(),
                multipleItemsPricedPerUnitWithThreeForTwoDiscount(),
                aSingleItemPricedByWeight(),
                multipleItemsPricedByWeight()
        );
    }

    private static Arguments aSingleItemPricedByWeight() {
        return Arguments.of("a single weighed item", "1.25", Collections.singleton(twoFiftyGramsOfAmericanSweets()));
    }

    private static Arguments multipleItemsPricedByWeight() {
        return Arguments.of("multiple weighed items", "1.85",
                Arrays.asList(twoFiftyGramsOfAmericanSweets(), twoHundredGramsOfPickAndMix())
        );
    }

    private static Arguments multipleItemsPricedPerUnit() {
        return Arguments.of("multiple items priced per unit", "2.04",
                Arrays.asList(aPackOfDigestives(), aPintOfMilk()));
    }

    private static Arguments multipleItemsPricedPerUnitWithTwoForDollarDiscount() {
        return Arguments.of("multiple items priced per unit with 'two for dollar' discount", "2.63",
                Arrays.asList(aPackOfCandiesWithTwoForDollarDiscount(), aPackOfCandiesWithTwoForDollarDiscount(),
                        aPackOfCandiesWithTwoForDollarDiscount(), aPackOfCandiesWithTwoForDollarDiscount(),
                        aPackOfCandiesWithTwoForDollarDiscount()));
    }

    private static Arguments multipleItemsPricedPerUnitWithThreeForTwoDiscount() {
        return Arguments.of("multiple items priced per unit with 'three for two' discount", "7.25",
                Arrays.asList(aPackOfBiscuitsWithThreeForTwoDiscount(), aPackOfBiscuitsWithThreeForTwoDiscount(),
                        aPackOfBiscuitsWithThreeForTwoDiscount(), aPackOfBiscuitsWithThreeForTwoDiscount(),
                        aPackOfBiscuitsWithThreeForTwoDiscount(), aPackOfBiscuitsWithThreeForTwoDiscount(),
                        aPackOfBiscuitsWithThreeForTwoDiscount()));
    }

    private static Arguments aSingleItemPricedPerUnit() {
        return Arguments.of("a single item priced per unit", "0.49", Collections.singleton(aPintOfMilk()));
    }

    private static Arguments noItems() {
        return Arguments.of("no items", "0.00", Collections.emptyList());
    }

    private static Item aPintOfMilk() {
        return new Product("Milk", new BigDecimal("0.49")).oneOf();
    }

    private static Item aPackOfDigestives() {
        return new Product("Digestives", new BigDecimal("1.55")).oneOf();
    }

    private static Item aPackOfCandiesWithTwoForDollarDiscount() {
        return new Product("Candies", new BigDecimal("0.63"), DiscountType.TWO_FOR_DOLLAR).oneOf();
    }
    private static Item aPackOfBiscuitsWithThreeForTwoDiscount() {
        return new Product("Biscuits", new BigDecimal("1.45"), DiscountType.THREE_FOR_TWO).oneOf();
    }

    private static WeighedProduct aKiloOfAmericanSweets() {
        return new WeighedProduct("American Sweets", new BigDecimal("4.99"));
    }

    private static Item twoFiftyGramsOfAmericanSweets() {
        return aKiloOfAmericanSweets().weighing(new BigDecimal(".25"));
    }

    private static WeighedProduct aKiloOfPickAndMix() {
        return new WeighedProduct("Pick And Mix", new BigDecimal("2.99"));
    }

    private static Item twoHundredGramsOfPickAndMix() {
        return aKiloOfPickAndMix().weighing(new BigDecimal(".2"));
    }
}
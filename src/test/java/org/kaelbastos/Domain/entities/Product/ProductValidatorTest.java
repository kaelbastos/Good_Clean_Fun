package org.kaelbastos.Domain.entities.Product;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.kaelbastos.Domain.entities.utils.Notification;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class ProductValidatorTest {

    @ParameterizedTest
    @NullSource
    @MethodSource("validateProductWithErrorProvider")
    void validateProductWithError(Product product) {
        ProductValidator productValidator = new ProductValidator();
        Notification notification = productValidator.validate(product);
        assertTrue(notification.hasErrors());
    }

    private static Stream<Arguments> validateProductWithErrorProvider(){
        return Stream.of(
                Arguments.of(new Product(0, "", -1F, null)),
                Arguments.of(new Product(0, "name", 0F, null)),
                Arguments.of(new Product(0, null, 10, ProductCategory.Utensil)),
                Arguments.of(new Product(0, " ", 10, ProductCategory.Chemical)),
                Arguments.of(new Product(-2, "name", 10, ProductCategory.Chemical)),
                Arguments.of(new Product(-2, "name", -2,10, ProductCategory.Chemical))
        );
    }

    @ParameterizedTest
    @MethodSource("validateWithMultipleErrorsProvider")
    void validateWithMultipleErrors(Product product){
        ProductValidator productValidator = new ProductValidator();
        Notification notification = productValidator.validate(product);
        assertTrue(notification.hasErrors());
        assertTrue(notification.getMessage().split(Notification.getDelimiter()).length > 1);
    }

    private static Stream<Arguments> validateWithMultipleErrorsProvider(){
        return Stream.of(
                Arguments.of(new Product(-2, null, -1F, null)),
                Arguments.of(new Product(0, " ", 0F, null)),
                Arguments.of(new Product(-0, "", -1000F,-10, null)),
                Arguments.of(new Product(-0, "", -10, null)),
                Arguments.of(new Product(0, " ", -1F,10, ProductCategory.Chemical)),
                Arguments.of(new Product(-2, "name",-1F,10, ProductCategory.Chemical))
        );
    }

}

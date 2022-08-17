package test.badpractices;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class DependencyHellTest {

    private CheckoutService checkoutService;

    @Mock
    BasketService basketServiceMock;
    @Mock
    ProductService productServiceMock;
    @Mock
    DiscountService discountServiceMock;
    @Mock
    PaymentService paymentServiceMock;
    @Mock
    OrderService orderServiceMock;
    @Mock
    NotificationService notificationServiceMock;

    @Test
    public void should_BeAVeryVeryLongTest(){
        checkoutService = new CheckoutService(basketServiceMock, productServiceMock, discountServiceMock, paymentServiceMock, orderServiceMock, notificationServiceMock);

        Mockito.when(basketServiceMock.getBasket()).thenReturn(null /* Some basket value */);
        /* and so it goes on for all the mocks */

        checkoutService.checkout();
    }
}

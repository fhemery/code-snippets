package test.badpractices;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class DependencyCascadeTest {

    private CheckoutService checkoutService;

    @Mock
    BasketService basketService;

    @Mock
    BasketDetailsService basketDetailsService;

    @Test
    public void should_beABitPainfulToInitialize() {
        Mockito.when(basketDetailsService.getDetails()).thenReturn(null);
        Mockito.when(basketService.getBasket()).thenReturn(basketDetailsService);
    }
}

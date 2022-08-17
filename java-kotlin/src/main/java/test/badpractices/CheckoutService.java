package test.badpractices;

public class CheckoutService {
    private BasketService basketService;
    private ProductService productService;
    private DiscountService discountService;
    private PaymentService paymentService;
    private OrderService orderService;
    private NotificationService notificationService;

    CheckoutService(BasketService basketService, ProductService productService, DiscountService discountService, PaymentService paymentService, OrderService orderService, NotificationService notificationService) {
        this.basketService = basketService;
        this.productService = productService;
        this.discountService = discountService;
        this.paymentService = paymentService;
        this.orderService = orderService;
        this.notificationService = notificationService;
    }

    public void checkout() {

    }
}

class ProductService {
}

class BasketService {

    private BasketDetailsService basketDetailsService;

    public BasketService(BasketDetailsService basketDetailsService) {
        this.basketDetailsService = basketDetailsService;
    }
    public Object getBasket() {
        return null;
    }


    public BasketDetailsService getBasketDetailsService() {
        return basketDetailsService;
    }
}

class BasketDetailsService {

    public Object getDetails() {
        return null;
    }
}
class DiscountService {

}

class PaymentService {

}

class OrderService {

}

class NotificationService {

}

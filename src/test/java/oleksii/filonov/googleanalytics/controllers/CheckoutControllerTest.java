package oleksii.filonov.googleanalytics.controllers;

import static org.junit.Assert.assertTrue;

import javax.servlet.http.HttpSession;

import oleksii.filonov.googleanalytics.domainmodel.Order;
import oleksii.filonov.googleanalytics.domainmodel.Product;
import oleksii.filonov.googleanalytics.domainmodel.ProductBuilder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CheckoutControllerTest {

	private final CheckoutController checkoutController = new CheckoutController();

	@Mock
	private HttpSession session;


	@Test
	public void shouldCleanCartOnThankYouPage() {
		final Order order = createOrderWithProduct();
		Mockito.when(this.session.getAttribute("cart")).thenReturn(order);
		this.checkoutController.showThankYou(this.session);
		assertTrue("Order should have no products after thank you page", order.getEntries().isEmpty());
	}


	private Order createOrderWithProduct() {
		final String productId = "testProductId";
		final Product testProduct = ProductBuilder.createProduct().withId(productId).withPrice(10).getProduct();
		final Order order = new Order();
		order.addProduct(testProduct);
		return order;
	}

}

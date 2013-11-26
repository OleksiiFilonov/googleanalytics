package oleksii.filonov.googleanalytics.controllers;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpSession;

import oleksii.filonov.googleanalytics.domainmodel.Order;
import oleksii.filonov.googleanalytics.domainmodel.Product;
import oleksii.filonov.googleanalytics.domainmodel.ProductBuilder;
import oleksii.filonov.googleanalytics.utils.SessionUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

@RunWith(MockitoJUnitRunner.class)
public class CheckoutControllerTest {

	private CheckoutController checkoutController;

	@Mock
	private HttpSession session;
	
	@Before
	public void setUp() {
		checkoutController = new CheckoutController();
		ReflectionTestUtils.setField(checkoutController, "sessionUtils", new SessionUtils());
	}


	@Test
	public void shouldCleanCartOnThankYouPage() {
		final Order order = createOrderWithProduct();
		when(this.session.getAttribute("cart")).thenReturn(order);
		final Model model = new ExtendedModelMap();
		this.checkoutController.showThankYou(model, this.session);
		assertNotNull(model.asMap().get("lastOrder"));
		verify(this.session).setAttribute(eq("cart"), any(Order.class));
	}


	private Order createOrderWithProduct() {
		final String productId = "testProductId";
		final Product testProduct = ProductBuilder.createProduct().withId(productId).withPrice(10).getProduct();
		final Order order = new Order();
		order.addProduct(testProduct);
		return order;
	}

	@Test
	public void shouldAddToModelOrderOnConfirmationPage() {
		final Order order = createOrderWithProduct();
		Mockito.when(this.session.getAttribute("cart")).thenReturn(order);
		final Model model = new ExtendedModelMap();
		this.checkoutController.showConfirmation(model, this.session);
		assertNotNull(model.asMap().get("cart"));
	}

}

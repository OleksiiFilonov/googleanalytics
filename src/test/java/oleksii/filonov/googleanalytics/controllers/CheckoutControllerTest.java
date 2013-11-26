package oleksii.filonov.googleanalytics.controllers;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.ReflectionTestUtils.setField;

import javax.servlet.http.HttpSession;

import oleksii.filonov.googleanalytics.domainmodel.Order;
import oleksii.filonov.googleanalytics.domainmodel.Product;
import oleksii.filonov.googleanalytics.domainmodel.ProductBuilder;
import oleksii.filonov.googleanalytics.utils.RandomOrderGenerator;
import oleksii.filonov.googleanalytics.utils.SessionUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

@RunWith(MockitoJUnitRunner.class)
public class CheckoutControllerTest {

	private CheckoutController testInstance;
	@Mock
	private HttpSession session;


	@Before
	public void setUp() {
		final SessionUtils sessionUtils = new SessionUtils();
		setField(sessionUtils, "orderGenerator", new RandomOrderGenerator());
		this.testInstance = new CheckoutController();
		setField(this.testInstance, "sessionUtils", sessionUtils);
	}


	@Test
	public void shouldCleanCartOnThankYouPage() {
		final Order order = createOrderWithProduct();
		when(this.session.getAttribute("cart")).thenReturn(order);
		final Model model = new ExtendedModelMap();
		this.testInstance.showThankYou(model, this.session);
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
		this.testInstance.showConfirmation(model, this.session);
		assertNotNull(model.asMap().get("cart"));
	}

}

package oleksii.filonov.googleanalytics.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.ReflectionTestUtils.setField;

import javax.servlet.http.HttpSession;

import oleksii.filonov.googleanalytics.domainmodel.Order;
import oleksii.filonov.googleanalytics.domainmodel.ProductBuilder;
import oleksii.filonov.googleanalytics.domainmodel.ProductStorage;
import oleksii.filonov.googleanalytics.utils.SessionUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

@RunWith(MockitoJUnitRunner.class)
public class CartControllerTest {

	private static final String TEST_PRODUCT_ID = "testProductId";

	private static final String CART = "cart";

	private CartController cartController;

	@Mock
	private HttpSession session;
	@Mock
	private ProductStorage productStorage;

	private Model model;

	private Order order;


	@Before
	public void setUp() {
		this.cartController = new CartController();
		ReflectionTestUtils.setField(cartController, "sessionUtils", new SessionUtils());
		this.model = new ExtendedModelMap();
		this.order = new Order();
		when(this.session.getAttribute(CART)).thenReturn(this.order);
	}

	@Test
	public void shouldShowCart() {
		this.cartController.showCart(this.model, this.session);
		assertSame(this.order, this.model.asMap().get(CART));
	}

	@Test
	public void shouldAddToCart() {
		setField(this.cartController, "productStorage", this.productStorage);
		when(this.productStorage.getProduct(TEST_PRODUCT_ID)).thenReturn(
				ProductBuilder.createProduct().withId(TEST_PRODUCT_ID).getProduct());
		this.cartController.addToCart(TEST_PRODUCT_ID, this.session);
		assertEquals(TEST_PRODUCT_ID, this.order.getEntry(TEST_PRODUCT_ID).getProduct().getId());
	}

}

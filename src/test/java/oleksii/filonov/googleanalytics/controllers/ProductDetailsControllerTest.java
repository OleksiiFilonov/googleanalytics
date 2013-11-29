package oleksii.filonov.googleanalytics.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.ReflectionTestUtils.setField;
import oleksii.filonov.googleanalytics.domainmodel.Product;
import oleksii.filonov.googleanalytics.domainmodel.ProductStorage;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

@RunWith(MockitoJUnitRunner.class)
public class ProductDetailsControllerTest {

	private ProductDetailsController testInstance;
	@Mock
	private ProductStorage productStorage;

	@Before
	public void setUp() {
		this.testInstance = new ProductDetailsController();
		setField(this.testInstance, "productStorage", this.productStorage);
	}

	@Test
	public void whenProductNotFound_ThenRedirectToProductNotFoundPage() {
		final Model model = new ExtendedModelMap();
		final String testProductId = "13";
		when(this.productStorage.getProduct(testProductId)).thenReturn(null);
		assertEquals("productNotFound", this.testInstance.showProduct(testProductId , model));
	}

	@Test
	public void whenProductFound_ThenRedirectToProductPage() {
		final Model model = new ExtendedModelMap();
		final String testProductId = "13";
		when(this.productStorage.getProduct(testProductId)).thenReturn(new Product());
		assertEquals("product", this.testInstance.showProduct(testProductId , model));
	}

}

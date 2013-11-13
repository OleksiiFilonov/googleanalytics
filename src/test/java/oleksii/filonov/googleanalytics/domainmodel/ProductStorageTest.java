package oleksii.filonov.googleanalytics.domainmodel;

import static org.junit.Assert.assertSame;
import static org.springframework.test.util.ReflectionTestUtils.setField;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class ProductStorageTest {

	private static final String TEST_PRODUCT_ID = "testId";
	private ProductStorage productStorage;

	@Before
	public void setUp() {
		this.productStorage = new ProductStorage();
	}

	@Test
	public void shouldGetProductById() {
		final Product product = new Product();
		product.setId(TEST_PRODUCT_ID);
		final Map<String, Product> testProductMap = new HashMap<>();
		testProductMap.put(TEST_PRODUCT_ID, product);
		setField(this.productStorage, "productMap", testProductMap);
		assertSame(product, this.productStorage.getProduct(TEST_PRODUCT_ID));
	}

}

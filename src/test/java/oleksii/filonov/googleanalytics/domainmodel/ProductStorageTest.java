package oleksii.filonov.googleanalytics.domainmodel;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.ReflectionTestUtils.setField;

import java.util.HashMap;
import java.util.Map;

import oleksii.filonov.googleanalytics.utils.ProductReader;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.io.Resource;

@RunWith(MockitoJUnitRunner.class)
public class ProductStorageTest {

	private static final String TEST_PRODUCT_ID = "testId";
	private ProductStorage productStorage;

	@Mock
	private ProductReader productReader;
	@Mock
	private Resource productsFile;

	@Before
	public void setUp() {
		this.productStorage = new ProductStorage();
	}

	@Test
	public void shouldGetProductById() {
		final Product product = createTestProduct();
		final Map<String, Product> testProductMap = new HashMap<>();
		testProductMap.put(TEST_PRODUCT_ID, product);
		setField(this.productStorage, "productMap", testProductMap);
		assertSame(product, this.productStorage.getProduct(TEST_PRODUCT_ID));
	}

	private Product createTestProduct() {
		final Product product = new Product();
		product.setId(TEST_PRODUCT_ID);
		return product;
	}

	@Test
	public void shouldAfterPropertySet() throws Exception {
		setField(this.productStorage, "productsFile", this.productsFile);
		setField(this.productStorage, "productReader", this.productReader);
		when(this.productReader.readProductsFromFile(this.productsFile)).thenReturn(newArrayList(createTestProduct()));
		this.productStorage.afterPropertiesSet();
		assertSame(TEST_PRODUCT_ID, this.productStorage.getProducts().iterator().next().getId());
	}

}

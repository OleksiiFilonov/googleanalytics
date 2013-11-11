package oleksii.filonov.googleanalytics.utils;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import oleksii.filonov.googleanalytics.domainmodel.Product;

import org.junit.Test;

public class ProductReaderTest {

	private final ProductReader productReader = new ProductReader();

	@Test
	public void shouldReadProductsFromFile() throws IOException {
		final String pathToFile = "/META-INF/products.csv";
		final List<Product> products = this.productReader.readProductsFromFile(pathToFile);
		assertEquals("The countity of read products is incorrect", 4, products.size());
		assertEquals("The first product title is incorrect", "Lenovo", products.get(0).getTitle());
	}
}

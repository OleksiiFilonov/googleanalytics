package oleksii.filonov.googleanalytics.utils;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import oleksii.filonov.googleanalytics.domainmodel.Product;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ProductReaderTest {

	private final ProductReader productReader = new ProductReader();
	ApplicationContext ctx;

	@Before
	public void setUp() {
		this.ctx = new FileSystemXmlApplicationContext();
	}

	@Test
	public void shouldReadProductsFromFile() throws IOException {
		final List<Product> products = this.productReader.readProductsFromFile(this.ctx.getResource("classpath:META-INF/products.csv"));
		assertEquals("The countity of read products is incorrect", 4, products.size());
		assertEquals("The first product title is incorrect", "Lenovo", products.get(0).getTitle());
	}
}

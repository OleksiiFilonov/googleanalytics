package oleksii.filonov.googleanalytics.domainmodel;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OrderTest {

	private final Order order = new Order();

	@Test
	public void shouldAddProducts() {
		final String productId = "testProductId";
		final Product testProduct = ProductBuilder.createProduct().withId(productId).withPrice(10).getProduct();
		this.order.addProduct(testProduct);
		assertEquals(1, this.order.getEntries().size());
		assertEquals(1, this.order.getEntries().iterator().next().getQuantity());
		assertEquals("Total after adding firs product", 10, this.order.getTotal());
		this.order.addProduct(testProduct);
		assertEquals(1, this.order.getEntries().size());
		assertEquals(2, this.order.getEntry(productId).getQuantity());
		final String anotherProductId = "otherTestProductId";
		final Product otherProduct = ProductBuilder.createProduct().withId(anotherProductId).withPrice(5).getProduct();
		this.order.addProduct(otherProduct);
		assertEquals(2, this.order.getEntries().size());
		assertEquals(1, this.order.getEntry(anotherProductId).getQuantity());
		assertEquals("Total after adding the same second product", 25, this.order.getTotal());
	}

	private static class ProductBuilder {

		private final Product product = new Product();

		private static ProductBuilder createProduct() {
			return new ProductBuilder();
		}

		public ProductBuilder withId(final String productId) {
			this.product.setId(productId);
			return this;
		}

		public ProductBuilder withPrice(final int price) {
			this.product.setPrice(price);
			return this;
		}

		public Product getProduct() {
			return this.product;
		}

	}

}

package oleksii.filonov.googleanalytics.domainmodel;

public class ProductBuilder {

	private final Product product = new Product();

	public static ProductBuilder createProduct() {
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
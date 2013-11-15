package oleksii.filonov.googleanalytics.domainmodel;

public class OrderEntry {

	private Product product;

	private int quantity;

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(final Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(final int quantity) {
		this.quantity = quantity;
	}

}

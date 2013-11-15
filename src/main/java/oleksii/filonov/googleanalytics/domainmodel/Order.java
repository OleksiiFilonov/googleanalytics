package oleksii.filonov.googleanalytics.domainmodel;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Order {

	private final Map<String, OrderEntry> entries = new HashMap<>();

	public Collection<OrderEntry> getEntries() {
		return this.entries.values();
	}

	public OrderEntry getEntry(final String productId) {
		return this.entries.get(productId);
	}

	public void addProduct(final Product product) {
		final OrderEntry entry = this.entries.get(product.getId());
		if(entry == null) {
			final OrderEntry orderEntry = new OrderEntry();
			orderEntry.setProduct(product);
			orderEntry.setQuantity(1);
			this.entries.put(product.getId(), orderEntry);
		} else {
			entry.setQuantity(entry.getQuantity()+1);
		}
	}

	public int getTotal() {
		int result = 0;
		for (final OrderEntry entry : this.entries.values()) {
			result +=entry.getQuantity()*entry.getProduct().getPrice();
		}
		return result;
	}

}

package oleksii.filonov.googleanalytics.domainmodel;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oleksii.filonov.googleanalytics.utils.ProductReader;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;

public class ProductStorage implements InitializingBean {

	@Autowired
	private ProductReader productReader;

	private Resource productsFile;

	private Map<String, Product> productMap;

	public Product getProduct(final String productId) {
		return this.productMap.get(productId);
	}

	public Collection<Product> getProducts() {
		return this.productMap.values();
	}

	public void setProductsFile(final Resource productsFile) {
		this.productsFile = productsFile;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		final List<Product> products = this.productReader.readProductsFromFile(this.productsFile);
		this.productMap = new HashMap<>(this.productMap.size());
		for (final Product product : products) {
			this.productMap.put(product.getId(), product);
		}

	}

}

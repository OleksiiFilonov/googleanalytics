package oleksii.filonov.googleanalytics.domainmodel;

import java.util.List;

import oleksii.filonov.googleanalytics.utils.ProductReader;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;

public class ProductStorage implements InitializingBean {

	@Autowired
	private ProductReader productReader;

	private Resource productsFile;

	private List<Product> products;

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProductsFile(final Resource productsFile) {
		this.productsFile = productsFile;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.products = this.productReader.readProductsFromFile(this.productsFile);
	}

}

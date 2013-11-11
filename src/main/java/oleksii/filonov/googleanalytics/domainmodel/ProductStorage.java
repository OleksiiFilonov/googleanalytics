package oleksii.filonov.googleanalytics.domainmodel;

import java.util.List;

import oleksii.filonov.googleanalytics.utils.ProductReader;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductStorage implements InitializingBean {

	@Autowired
	private ProductReader productReader;

	private String pathToProductFile;

	private List<Product> products;

	public List<Product> getProducts() {
		return this.products;
	}

	public void setPathToProductFile(final String pathToProductFile) {
		this.pathToProductFile = pathToProductFile;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.products = this.productReader.readProductsFromFile(this.pathToProductFile);
	}

}

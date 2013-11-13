package oleksii.filonov.googleanalytics.controllers;

import oleksii.filonov.googleanalytics.domainmodel.ProductStorage;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;


public class SearchControllerTest {

	private SearchController searchController;

	@Before
	public void setUp() {
		this.searchController = new SearchController();
		ReflectionTestUtils.setField(this.searchController, "productStorage", new ProductStorage());
	}

	@Test
	public void shouldDoPseudoSearch() {
		final Model model = new ExtendedModelMap();
		this.searchController.doPseudoSearch(model);
	}



}

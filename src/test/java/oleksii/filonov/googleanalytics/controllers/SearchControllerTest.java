package oleksii.filonov.googleanalytics.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.util.ReflectionTestUtils.setField;

import java.util.Collections;

import oleksii.filonov.googleanalytics.domainmodel.Product;
import oleksii.filonov.googleanalytics.domainmodel.ProductStorage;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;


@RunWith(MockitoJUnitRunner.class)
public class SearchControllerTest {

	private SearchController searchController;

	@Mock
	private ProductStorage productStorage;

	@Before
	public void setUp() {
		this.searchController = new SearchController();
		when(this.productStorage.getProducts()).thenReturn(Collections.<Product>emptyList());
		setField(this.searchController, "productStorage", this.productStorage);
	}

	@Test
	public void shouldDoPseudoSearch() {
		final Model model = new ExtendedModelMap();
		this.searchController.doPseudoSearch(model);
	}



}

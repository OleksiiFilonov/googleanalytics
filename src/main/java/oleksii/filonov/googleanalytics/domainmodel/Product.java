package oleksii.filonov.googleanalytics.domainmodel;

import com.googlecode.jcsv.annotations.MapToColumn;

public class Product {

	@MapToColumn(column=0)
	private String id;

	@MapToColumn(column=1)
	private String title;

	@MapToColumn(column=2)
	private String description;

	@MapToColumn(column=3)
	private int price;

	public String getId() {
		return this.id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(final int price) {
		this.price = price;
	}

}

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ tag body-content="empty" %>
<%@ attribute name="order" type="oleksii.filonov.googleanalytics.domainmodel.Order" rtexprvalue="true" required="true" %>

<script>
	ga('require', 'ecommerce', 'ecommerce.js');

	ga('ecommerce:addTransaction', {
		'id' : '${pageContext.session.id}', // Transaction ID. Required.
		'affiliation' : 'Workshop Google Analytics', // Affiliation or store name.
		'revenue' : '${order.total}', // Grand Total.
		'shipping' : 'FREE', // Shipping.
		'tax' : '2.10' // Tax.
	});
    
	<c:forEach var="entry" items="${order.entries}" varStatus="counter">
		ga('ecommerce:addItem', {
			'id' : '${pageContext.session.id}', // Transaction ID. Required.
			'name' : '${entry.product.title}', // Product name. Required.
			'sku' : '${entry.product.id}', // SKU/code.
			'category' : 'Laptops', // Category or variation.
			'price' : '${entry.product.price}', // Unit price.
			'quantity' : '${entry.quantity}' // Quantity.
		});
	</c:forEach>

	ga('ecommerce:send');
</script>
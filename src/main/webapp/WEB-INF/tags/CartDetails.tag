<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ tag body-content="empty" %>
<%@ attribute name="order" type="oleksii.filonov.googleanalytics.domainmodel.Order" rtexprvalue="true" required="true" %>

<div>
  <table>
      <thead>
          <tr>
              <th>Title</th><th>Description</th><th>Price</th><th>Quantity</th>
          </tr>
      </thead>
      <tbody>
          <c:forEach var="entry" items="${order.entries}">
              <tr>
                  <td>${entry.product.title}</td>
                  <td>${entry.product.description}</td>
                  <td>${entry.product.price}</td>
                  <td>${entry.quantity}</td>
              </tr>
          </c:forEach>
          <tr>
           <td colspan="2">Total</td>
           <td colspan="2">${order.total}</td>
          </tr>              
      </tbody>
  </table>
</div>
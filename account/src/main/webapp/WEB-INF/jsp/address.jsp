<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1><fmt:message key="address.addressSearchForm.title" /></h1>
<br />

<form:form id="addressSearchForm" method="POST"  modelAttribute="addressSearchForm" >

<table>
    <tr style="height: 30px">
      <td colspan="2">
          <b><fmt:message key="address.addressSearchForm.criteria" /></b>
      </td>
    </tr>
    <tr>
        <td style="padding-right: 20px;">
            <fmt:message key="address.addressSearchForm.columnName" />
        </td>
        <td style="padding-right: 20px;">
          <form:select path="columnName" items="${addressSearchForm.columnNames}" itemLabel="columnLabel" itemValue="columnValue" />
        </td>
     </tr>
     <tr>
        <td style="padding-right: 20px;">
            <fmt:message key="address.addressSearchForm.columnValue" />
        </td>
        <td style="padding-right: 20px;">
             <form:input path="columnValue" />
        </td>
    </tr>
    <tr style="height: 30px">
      <td colspan="2">
        <input type="submit" id="searchAddresses" name="_eventId_searchAddresses" value="<fmt:message key="address.addressSearchForm.searchAddresses" />"/>
      </td>
    </tr>    
    </table>
    <table id="addressesPanel">
    <tr>
    <td colspan="6">
    <fmt:message key="address.addressSearchForm.addresses.title" />
    </td>
      <c:forEach var="varAddress" items="${addresses}" varStatus="idx">
          <tr>
              <td style="padding-right: 20px;">
                  <strong>${varAddress.account.username}</strong>
              </td>
              <td style="padding-right: 20px;">
                  <strong>${varAddress.line1}</strong>
              </td>
              <td style="padding-right: 20px;">
                  <strong>${varAddress.line2}</strong>
              </td>
              <td style="padding-right: 20px;">
                  <strong>${varAddress.zipcode}</strong>
              </td>
              <td style="padding-right: 20px;">
                  <strong>${varAddress.city}</strong>
              </td>
              <td style="padding-right: 20px;">
                  <strong>${varAddress.state}</strong>
              </td>
          </tr>
      </c:forEach>
</table>
</form:form>
<a href="${flowExecutionUrl}&_eventId=backAccount"><fmt:message key="address.addressSearchForm.back" /></a>.
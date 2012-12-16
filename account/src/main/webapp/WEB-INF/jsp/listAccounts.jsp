<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<h1><fmt:message key="listAccounts.title" /></h1>
<br />
<table>
<c:forEach items="${flowRequestContext.messageContext.allMessages}" var="message">
     <c:if test="${message.severity eq 'INFO'}">
        <tr>
          <td colspan="6" style="background-color: #FFA54F; width: 100px; text-align: center;">
            ${message.text}
          </td>
        </tr>
     </c:if>
     <c:if test="${message.severity eq 'ERROR'}">
         <tr>
          <td colspan="6" style="background-color: red; width: 100px; text-align: center;">
            ${message.text}
          </td>
        </tr>
     </c:if>
    </c:forEach>
    <tr>
    <td colspan="6">
    <fmt:message key="listAccounts.account.title" />
    </td>
    </tr>
    <c:forEach var="varAccount" items="${accounts}">
        <tr>
            <td style="padding-right: 20px;">
                <strong>${varAccount.username}</strong>
            </td>
            <td style="padding-right: 20px;">
                <strong>${varAccount.firstname}</strong>
            </td>
            <td style="padding-right: 20px;">
                <strong>${varAccount.lastname}</strong>
            </td>
            <td style="padding-right: 20px;">
                <a href="${flowExecutionUrl}&_eventId=view&accountId=${varAccount.id}"><fmt:message key="listAccounts.view" /></a>
            </td>
            <td style="padding-right: 20px;">
                <a href="${flowExecutionUrl}&_eventId=edit&accountId=${varAccount.id}"><fmt:message key="listAccounts.edit" /></a>
            </td>
            <td style="padding-right: 20px;">
                <a href="${flowExecutionUrl}&_eventId=remove&accountId=${varAccount.id}"><fmt:message key="listAccounts.delete" /></a>
            </td>
        </tr>
    </c:forEach>
    <tr>
    <td colspan="6">
    <fmt:message key="listAccounts.address.title" />
    </td>
    <c:forEach var="varAccount" items="${accounts}" varStatus="idxAccount">
      <c:forEach var="varAddress" items="${varAccount.addresses}" varStatus="idxAddress">
          <tr>
            <c:if test="${idxAddress.index == 0}">
              <td style="padding-right: 20px;" rowspan='${fn:length(varAddress.account.addresses)}'>
                  <strong>${varAddress.account.username}</strong>
              </td>
            </c:if>
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
    </c:forEach>    
</table>
<a href="${flowExecutionUrl}&_eventId=backAccount"><fmt:message key="listAccounts.back" /></a>.
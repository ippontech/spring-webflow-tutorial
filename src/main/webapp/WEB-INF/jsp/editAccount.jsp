<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title><fmt:message key="editAccount.title" /></title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/styles.css">
</head>
<body>
  <h1><fmt:message key="editAccount.title" /></h1>
  <form:form id="editAccountForm" method="POST" commandName="account" >
    <table border=0>
    <c:forEach items="${flowRequestContext.messageContext.allMessages}" var="message">
     <c:if test="${message.severity eq 'INFO'}">
        <tr>
          <td colspan="2" style="background-color: #FFA54F; width: 100px; text-align: center;">
            ${message.text}
          </td>
        </tr>
     </c:if>
     <c:if test="${message.severity eq 'ERROR'}">
         <tr>
          <td colspan="2" style="background-color: red; width: 100px; text-align: center;">
            ${message.text}
          </td>
        </tr>
     </c:if>
    </c:forEach>
    <tr>
      <td>
        <fmt:message key="editAccount.field.account.username" />
      </td>
      <td>
        <c:if test="${readOnly}">
          ${account.username}
        </c:if>
        <c:if test="${not readOnly}">
          <form:input path="username" cssErrorClass="error" />
          <form:errors path="username" cssClass="error" />
        </c:if>
      </td>
     </tr>
     <tr>
       <td>
        <fmt:message key="editAccount.field.account.firstname" />
      </td>
      <td>
        <c:if test="${readOnly}">
          ${account.firstname}
        </c:if>
        <c:if test="${not readOnly}">
          <form:input  path="firstname" cssErrorClass="error" />
        </c:if>
      </td>
    </tr>
    <tr>
      <td>
        <fmt:message key="editAccount.field.account.lastname" />
      </td>
      <td>
        <c:if test="${readOnly}">
          ${account.lastname}
        </c:if>
        <c:if test="${not readOnly}">
          <form:input path="lastname" cssErrorClass="error" />
        </c:if>
     </td>
    </tr>
    <tr>
      <td>
        <fmt:message key="editAccount.field.account.password" />
      </td>
      <td>
        <c:if test="${readOnly}">
          ${account.password}
        </c:if>
        <c:if test="${not readOnly}">
          <form:password path="password" showPassword="true" />
        </c:if>
       </td>
      </tr>
      <tr>
       <td>
        <fmt:message key="editAccount.field.account.email" />
       </td>
       <td>
        <c:if test="${readOnly}">
          ${account.email}
        </c:if>
        <c:if test="${not readOnly}">
          <form:input path="email" cssErrorClass="error" />
          <form:errors path="email" cssClass="error" />
        </c:if>
       </td>
     </tr>
     <tr>
       <td>
        <fmt:message key="editAccount.field.account.desactivationDate" />
       </td>
       <td>
        <c:if test="${readOnly}">
          ${account.desactivationDateStr}
        </c:if>
        <c:if test="${not readOnly}">
          <form:input path="desactivationDateStr" cssErrorClass="error" />
        </c:if>
       </td>
     </tr>
     <tr> 
       <td>
        <fmt:message key="editAccount.field.account.enabled" />
       </td>
       <td>
        <c:if test="${readOnly}">
          <form:checkbox path="enabled" disabled="true"/> 
        </c:if>
        <c:if test="${not readOnly}">
          <form:checkbox path="enabled"/> 
        </c:if>
      </td>  
     </tr>
     </table>    
    <br /> 
    <div id="addressesPanel">
      <b><fmt:message key="editAccount.field.account.address.title" /></b>
      <br />
      <table border=0>
      <c:forEach var="address" items="${account.addresses}" varStatus="adr">
      <tr>
        <td colspan="3">
          <i><fmt:message key="editAccount.field.account.address.no" />${adr.index+1}:</i>
        </td>
      </tr>
      <tr>
        <td>
            <fmt:message key="editAccount.field.account.address.line1" />
        </td>
        <td colspan="2">
            <c:if test="${readOnly}">
              ${account.addresses[adr.index].line1}
            </c:if>
            <c:if test="${not readOnly}">
              <form:input path="addresses[${adr.index}].line1" cssErrorClass="error" />
            </c:if>
        </td>
        </tr>
        <tr>
        <td>
            <fmt:message key="editAccount.field.account.address.line2" />
        </td>
        <td colspan="2">
            <c:if test="${readOnly}">
              ${account.addresses[adr.index].line2}
            </c:if>
            <c:if test="${not readOnly}">
              <form:input path="addresses[${adr.index}].line2" cssErrorClass="error" />
            </c:if>
        </td>
        </tr>
        <tr> 
          <td>
            <fmt:message key="editAccount.field.account.address.zipcode" />
          </td>
          <td>
            <c:if test="${readOnly}">
              ${account.addresses[adr.index].zipcode}
            </c:if>
            <c:if test="${not readOnly}">
              <form:input path="addresses[${adr.index}].zipcode" cssErrorClass="error" />
            </c:if>
          </td>
          <td>
            <c:if test="${not readOnly}">
              <a href="${flowExecutionUrl}&_eventId=deleteAddress&addressIdx=${adr.index}"><fmt:message key="editAccount.account.delete" /></a>
            </c:if>
          </td>          
        </tr>
        <tr>
          <td>
            <fmt:message key="editAccount.field.account.address.city" />
          </td>
          <td colspan="2">
            <c:if test="${readOnly}">
              ${account.addresses[adr.index].city}
            </c:if>
            <c:if test="${not readOnly}">
              <form:input path="addresses[${adr.index}].city" cssErrorClass="error" />
            </c:if>
          </td>
        </tr>
        <tr>
          <td>
            <fmt:message key="editAccount.field.account.address.state" />
          </td>
          <td colspan="2">
            <c:if test="${readOnly}">
              ${account.addresses[adr.index].state}
            </c:if>
            <c:if test="${not readOnly}">
              <form:input path="addresses[${adr.index}].state" cssErrorClass="error" />
            </c:if>
          </td>
        </tr>
        <br />
      </c:forEach>
      </table>
    </div>
    <br />
    <script type="text/javascript" src="<c:url value="/resources/dojo/dojo.js" />"> </script>  
    <script type="text/javascript" src="<c:url value="/resources/spring/Spring.js" />"> </script>  
    <script type="text/javascript" src="<c:url value="/resources/spring/Spring-Dojo.js" />"> </script>  
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/dijit/themes/tundra/tundra.css" />" />
    <input type="submit" id="back" name="_eventId_back" value="<fmt:message key="editAccount.account.backListAccounts" />" />
    <c:if test="${not readOnly}">
      <input type="submit" id="addAddress" name="_eventId_addAddress" value="<fmt:message key="editAccount.account.add" />" />
      <input type="submit" id="saveAccount" name="_eventId_saveAccount" value="<fmt:message key="editAccount.account.save" />"/>
    </c:if>
    <script type="text/javascript">  
     Spring.addDecoration(new Spring.AjaxEventDecoration({
    	                          formId: 'editAccountForm',
                                  elementId: 'saveAccount',    
                                  event: 'onclick',  
                                  popup: true  
          })); 
    </script> 
  </form:form>
</body>
</html>

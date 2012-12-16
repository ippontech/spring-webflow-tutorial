<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<title><fmt:message key="account.title" /></title>
</head>
<body>
  <div>
    <h1><fmt:message key="account.title" /></h1>
    <div>
      <span style="padding-left: 10px;">
        <span>
          <a href="${flowExecutionUrl}&_eventId=enabledAccounts"><fmt:message key="account.listAccounts.activated" /></a>.
        </span>
        <span style="padding-left: 10px">
          <a href="${flowExecutionUrl}&_eventId=disabledAccounts"><fmt:message key="account.listAccounts.desactivated" /></a>.
        </span>
        <span style="padding-left: 10px">
          <a href="${flowExecutionUrl}&_eventId=addAccount"><fmt:message key="account.add" /></a>.
        </span>
        <span style="padding-left: 10px">
          <a href="${flowExecutionUrl}&_eventId=searchAddresses"><fmt:message key="account.searchAddresses" /></a>.
        </span>
        <span style="padding-left: 10px">
          <a href="${flowExecutionUrl}&_eventId=backHome"><fmt:message key="account.back" /></a>.
        </span>
      </span>
    </div>
  </div>
</body>
</html>

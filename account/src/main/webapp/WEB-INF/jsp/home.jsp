<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<html>
<head>
<title><fmt:message key="home.title" /></title>
</head>
<body>
  <div>
    <h1><fmt:message key="home.title" /></h1>
    <div>
      <span style="padding-left: 10px;">
        <span>
          <a href="${flowExecutionUrl}&_eventId=manageAccounts"><fmt:message key="home.title" /></a>.
        </span>
      </span>
    </div>
  </div>
</body>
</html>

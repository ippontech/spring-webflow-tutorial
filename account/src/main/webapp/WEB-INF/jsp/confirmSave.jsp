<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div style="background-color: LightGrey;padding:10px;">
<form id="popupForm">
  <fmt:message key="account.save.confirm" /><br /><br />
  <div style="text-align: center;">
    <input type="button" id="save" onclick="location.href = '${flowExecutionUrl}&_eventId=save'" value="<fmt:message key="account.save.confirm.yes" />" /> 
    <input type="button" id="cancel" onclick="location.href ='${flowExecutionUrl}&_eventId=cancel'" value="<fmt:message key="account.save.confirm.no" />" />
  </div>
</form>
</div>

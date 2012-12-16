<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"> 
<html>
	<head>
		<title>Error</title>
		<link rel="stylesheet" type="text/css" href="styles/styles.css" />
	</head>
	<body>
		<div>
			<h1>Error occurred!</h1>
			<div style="padding-left: 10px; padding-bottom: 20px;">			
			    <ul>
			    <c:forEach items="${flowRequestContext.messageContext.allMessages}" var="message">    
                    <li class="errors">${message.text}</li>    
                </c:forEach>
                </ul>
            </div>
            <div style="padding-left: 10px;">
			    <a href="${flowExecutionUrl}&_eventId=back">Back</a>
			</div>
		</div>
	</body>
</html>

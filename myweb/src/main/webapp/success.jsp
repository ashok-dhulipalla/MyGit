<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>
<html:html>
<head>
<title>success.jsp</title>
<html:base />
</head>
<body>
<bean:write name="dynamicForm" property="message"/>
<p>Success</p>
<a href="myStart.do">Go to myStart</a>
</body>
</html:html>
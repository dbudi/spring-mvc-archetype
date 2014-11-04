#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
<%@ include file="/common/taglibs.jsp" %>

<head>
    <title>Data Access Error</title>
</head>

<p>
    <h2>Data Access Failure</h2>
    <c:out value="${symbol_dollar}{requestScope.exception.message}"/>
</p>

<!--
<% 
((Exception) request.getAttribute("exception")).printStackTrace(new java.io.PrintWriter(out));  
%>
-->

<a href="home" onclick="history.back();return false">&${symbol_pound}171; Back</a>

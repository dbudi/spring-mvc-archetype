#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
<%-- Error Messages --%>
<c:if test="${symbol_dollar}{not empty errors}">
    <div class="alert alert-danger alert-dismissable">
        <a href="${symbol_pound}" data-dismiss="alert" class="close">&times;</a>
        <c:forEach var="error" items="${symbol_dollar}{errors}">
            <c:out value="${symbol_dollar}{error}"/><br />
        </c:forEach>
    </div>
    <c:remove var="errors"/>
</c:if>

<%-- Success Messages --%>
<c:if test="${symbol_dollar}{not empty successMessages}">
    <div class="alert alert-success alert-dismissable">
        <a href="${symbol_pound}" data-dismiss="alert" class="close">&times;</a>
        <c:forEach var="msg" items="${symbol_dollar}{successMessages}">
            <c:out value="${symbol_dollar}{msg}"/><br />
        </c:forEach>
    </div>
    <c:remove var="successMessages" scope="session"/>
</c:if>

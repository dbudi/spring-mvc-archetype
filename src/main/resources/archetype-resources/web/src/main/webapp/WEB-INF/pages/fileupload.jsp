#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="upload.title"/></title>
    <meta name="menu" content="AdminMenu"/>
</head>

<div class="col-sm-3">
    <h2><fmt:message key="upload.heading"/></h2>
    <p><fmt:message key="upload.message"/></p>
</div>
<div class="col-sm-7">
    <spring:bind path="fileUpload.*">
        <c:if test="${symbol_dollar}{not empty status.errorMessages}">
        <div class="alert alert-danger alert-dismissable">
            <a href="${symbol_pound}" data-dismiss="alert" class="close">&times;</a>
            <c:forEach var="error" items="${symbol_dollar}{status.errorMessages}">
                <c:out value="${symbol_dollar}{error}" escapeXml="false"/><br />
            </c:forEach>
        </div>
        </c:if>
    </spring:bind>

    <form:form commandName="fileUpload" method="post" action="fileupload" enctype="multipart/form-data"
        onsubmit="return validateFileUpload(this)" id="uploadForm" cssClass="well">
        <spring:bind path="fileUpload.name">
        <div class="form-group${symbol_dollar}{(not empty status.errorMessage) ? ' has-error' : ''}">
        </spring:bind>
            <appfuse:label key="uploadForm.name" styleClass="control-label"/>
            <form:input cssClass="form-control" path="name" id="name"/>
            <form:errors path="name" cssClass="help-block"/>
        </div>
        <spring:bind path="fileUpload.file">
        <div class="form-group${symbol_dollar}{(not empty status.errorMessage) ? ' has-error' : ''}">
        </spring:bind>
            <appfuse:label key="uploadForm.file" styleClass="control-label"/>
            <input type="file" name="file" id="file"/>
            <form:errors path="file" cssClass="help-block"/>
        </div>
        <div class="form-group">
            <button type="submit" name="upload" class="btn btn-primary" onclick="bCancel=false">
                <i class="icon-upload icon-white"></i> <fmt:message key="button.upload"/>
            </button>
            <button type="submit" name="cancel" class="btn btn-default" onclick="bCancel=true">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/>
            </button>
        </div>
    </form:form>
</div>
<c:set var="scripts" scope="request">
<v:javascript formName="fileUpload" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value="/scripts/validator.jsp"/>"></script>
</c:set>
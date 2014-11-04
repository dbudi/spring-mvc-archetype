#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="display.title"/></title>
    <meta name="menu" content="AdminMenu"/>
</head>

<div class="col-sm-10">
    <h2><fmt:message key="display.heading"/></h2>
    <p>Below is a list of attributes that were gathered in FileUploadController.java.</p>

    <table class="table-striped" cellpadding="5">
        <tr>
            <th>Friendly Name:</th>
            <td><c:out value="${symbol_dollar}{friendlyName}"/></td>
        </tr>
        <tr>
            <th>Filename:</th>
            <td><c:out value="${symbol_dollar}{fileName}"/></td>
        </tr>
        <tr>
            <th>File content type:</th>
            <td><c:out value="${symbol_dollar}{contentType}"/></td>
        </tr>
        <tr>
            <th>File size:</th>
            <td><c:out value="${symbol_dollar}{size}"/></td>
        </tr>
        <tr>
            <th class="tallCell">File Location:</th>
            <td>The file has been written to: <br />
                <a href="<c:out value="${symbol_dollar}{link}"/>"><c:out value="${symbol_dollar}{location}" escapeXml="false"/></a>
            </td>
        </tr>
    </table>
    <div id="actions" class="form-group">
        <a class="btn btn-primary" href="home" >
            <i class="icon-ok icon-white"></i>
            <fmt:message key="button.done"/>
        </a>
        <a class="btn btn-default" href="fileupload" >
            <i class="icon-upload"></i>
            Upload Another
        </a>
    </div>
</div>



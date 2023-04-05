<%--
  Created by IntelliJ IDEA.
  User: matias
  Date: 4/4/2023
  Time: 5:17 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="Layout" content="main">
    <g:set var="entityName" value="Feedback Form"/>
    <title>Feedback Form</title>
</head>

<body>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"></a></li>
    </ul>
</div>

<div id="create-feedbackForm" class="content scaffold-create" role="main">
    <h1></h1>
    <g:form action="index">
        <fieldset class="form">
            <g:render template="form"/>
        </fieldset>
        <fieldset class="buttons">
            <g:submitButton name="displayForm" class="save" value="submit"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
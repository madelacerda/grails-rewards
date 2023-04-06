<%--
  Created by IntelliJ IDEA.
  User: matia
  Date: 4/5/2023
  Time: 8:58 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Kiosk</title>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.min.css')}">
    <script src="javascript/respond.js"></script>
</head>

<body>
<g:form url="[resource: customerInstance, action: 'customerLookup']">
    <g:render template="kioskForm"/>
</g:form>

<g:javascript library="jquery"/>
<script src="javascript/bootstrap.min.js"></script>
</body>
</html>
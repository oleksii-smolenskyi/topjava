<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="jfn" uri="http://java.sun.com/jsp/jstl/functions" %>

<head>
    <c:set var="url">${pageContext.request.requestURL}</c:set>
    <base href="${jfn:substring(url, 0, jfn:length(url) - jfn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/" />
    <script>var base = document.getElementsByTagName("base")[0].href;</script>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><spring:message code="app.title"/></title>
    <link rel="stylesheet" href="resources/css/style.css">
</head>
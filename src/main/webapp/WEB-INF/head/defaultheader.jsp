<meta charset="utf-8">
<meta name="css/author" content="FINNSEEFLY">
<link href="css/global.css" rel="stylesheet" type="text/css"/>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="lang" value='<%=request.getSession().getAttribute("lang")%>'/>
<fmt:setLocale value='<%=request.getSession().getAttribute("lang")%>'/>
<fmt:setBundle basename="locale" var="loc"/>
<c:set var="isLoggedIn" scope="request" value='<%=request.getSession().getAttribute("isLoggedIn")%>'/>
<c:set var="thisPage" scope="request" value='<%=request.getParameter("command")%>'/>
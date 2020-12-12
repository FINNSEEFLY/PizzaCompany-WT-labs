<html>
<head>
<%@include file="../head/defaultheader.jsp" %>
    <fmt:message bundle="${loc}" key="local.title.main" var="mainTitle"/>
    <title>${mainTitle}</title>
</head>
<body>
<div class="grid">
<%@include file="header.jsp"%>
    <article class="content">

    </article>
    <section class="rightBox">

    </section>
<%@include file="footer.jsp"%>
</div>
</body>
</html>
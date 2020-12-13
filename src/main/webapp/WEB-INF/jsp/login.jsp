<html>
<head>
    <%@include file="../head/defaultheader.jsp" %>
    <fmt:message bundle="${loc}" key="local.title.login" var="loginTitle"/>
    <fmt:message bundle="${loc}" key="local.input.form.login" var="login"/>
    <fmt:message bundle="${loc}" key="local.input.form.password" var="password"/>
    <fmt:message bundle="${loc}" key="local.title.form.authorization" var="authorization"/>
    <fmt:message bundle="${loc}" key="local.input.button.send" var="send"/>
    <title>${loginTitle}</title>
</head>
<body>
<div class="grid">
    <%@include file="header.jsp" %>
    <article class="content" id="authContent">
        <form class="decor" method="post" action="controller?command=login">
            <div class="form-inner">
                <h3 id="auth-h3">${authorization}</h3>
                <input required type="text" name="login" placeholder="${login}">
                <input required type="password" name="password" placeholder="${password}">
                <input type="submit" value="${send}">
            </div>
        </form>
    </article>
    <%@include file="footer.jsp" %>
</div>
</body>
</html>
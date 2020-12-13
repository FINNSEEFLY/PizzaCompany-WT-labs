<html>
<head>
    <%@include file="../head/defaultheader.jsp" %>
    <fmt:message bundle="${loc}" key="local.title.register" var="registerTitle"/>
    <fmt:message bundle="${loc}" key="local.input.form.firstname" var="firstname"/>
    <fmt:message bundle="${loc}" key="local.input.form.lastname" var="lastname"/>
    <fmt:message bundle="${loc}" key="local.input.form.login" var="login"/>
    <fmt:message bundle="${loc}" key="local.input.form.password" var="password"/>
    <fmt:message bundle="${loc}" key="local.title.form.registration" var="registration"/>
    <fmt:message bundle="${loc}" key="local.input.button.send" var="send"/>
    <title>${registerTitle}</title>
</head>
<body>
<div class="grid">
    <%@include file="header.jsp" %>
    <article class="content" id="registerContent">
        <form class="decor" method="post" action="controller?command=register">
            <div class="form-inner">
                <h3 id="register-h3">${registration}</h3>
                <input required type="text" name="login" placeholder="${login}">
                <input required type="email" name="email" placeholder="Email">
                <input required type="password" name="password" placeholder="${password}">
                <input type="text" name="firstname" placeholder="${firstname}">
                <input type="text" name="lastname" placeholder="${lastname}">
                <input type="submit" value="${send}">
            </div>
        </form>
    </article>
    <%@include file="footer.jsp" %>
</div>
</body>
</html>
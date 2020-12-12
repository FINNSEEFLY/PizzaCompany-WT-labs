<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%@include file="../head/defaultheader.jsp" %>
    <fmt:message bundle="${loc}" key="local.title.register" var="registerTitle"/>
    <title>${registerTitle}</title>
</head>
<body>
<div class="grid">
    <%@include file="header.jsp" %>
    <article class="content" id="registerContent">
        <form class="decor" method="post" action="controller?command=">
            <div class="form-inner">
                <h3 id="register-h3">Регистрация</h3>
                <input type="text" name="login" placeholder="Login">
                <input type="email" name="email" placeholder="Email">
                <input type="password" name="password" placeholder="Password">
                <input type="text" name="firstname" placeholder="Firstname">
                <input type="text" name="lastname" placeholder="Lastname">
                <input type="submit" value="Отправить">
            </div>
        </form>
    </article>
    <section class="rightBox">

    </section>
    <%@include file="footer.jsp" %>
</div>
</body>
</html>
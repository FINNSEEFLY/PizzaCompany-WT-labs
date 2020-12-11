<fmt:message bundle="${loc}" key="local.nav.main" var="linkMainPage"/>
<fmt:message bundle="${loc}" key="local.nav.contacts" var="linkContactsPage"/>
<fmt:message bundle="${loc}" key="local.nav.contacts" var="linkContactsPage"/>
<fmt:message bundle="${loc}" key="local.nav.login" var="linkLogInPage"/>
<fmt:message bundle="${loc}" key="local.nav.register" var="linkRegisterPage"/>
<fmt:message bundle="${loc}" key="local.nav.logout" var="linkLogOut"/>
<c:set var="isLoggedIn" value='<%=request.getSession().getAttribute("isLoggedIn")%>'/>
<c:set var="thisPage" value='<%=request.getParameter("command")%>'/>
<header class="header">
    <nav class="nav">
        <div class="logo"></div>
        <a class="lnk1" href="controller?command=go_to_main">${linkMainPage}</a>
        <a class="lnk2" href="controller?command=go_to_contacts">${linkContactsPage}</a>
        <c:if test="${isLoggedIn == true}">
            <a class="logout" href="controller?command=log_out">${linkLogOut}</a>
        </c:if>
        <c:if test="${isLoggedIn == false}">
        <a class="login" href="controller?command=go_to_login">${linkLogInPage}</a>
            <a class="register" href="controller?command=go_to_register">${linkRegisterPage}</a>
        </c:if>
        <form method="post" class="language" id="ru" action="controller?command=${thisPage}">
            <input type="hidden" class="language_elem" name="lang" value="ru" />
            <input type="submit" class="language_elem" value="RU" />
        </form>
        <form method="post" class="language" id="en" action="controller?command=${thisPage}">
            <input type="hidden" class="language_elem" name="lang" value="en" />
            <input type="submit" class="language_elem" value="EN" />
        </form>
    </nav>
</header>
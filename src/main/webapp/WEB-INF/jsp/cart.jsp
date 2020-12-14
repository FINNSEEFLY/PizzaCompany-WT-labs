<html>
<head>
    <%@include file="../head/defaultheader.jsp" %>
    <fmt:message bundle="${loc}" key="local.title.cart" var="cartTitle"/>
    <c:set var="userInfo" value='<%=request.getSession().getAttribute("user")%>'/>
    <fmt:message bundle="${loc}" key="local.title.cart" var="cartTitle"/>
    <fmt:message bundle="${loc}" key="local.rightbox.pizza.size" var="pizzaSizeTitle"/>
    <fmt:message bundle="${loc}" key="local.rightbox.pizza.price" var="rightPizzaPrice"/>
    <fmt:message bundle="${loc}" key="local.rightbox.pcs" var="pcs"/>
    <fmt:message bundle="${loc}" key="local.rightbox.final.price" var="finalPriceTitle"/>
    <fmt:message bundle="${loc}" key="local.input.form.price.cm" var="cm"/>
    <fmt:message bundle="${loc}" key="local.input.form.price.byn" var="byn"/>
    <c:set var="cart" value='<%=request.getSession().getAttribute("cart")%>'/>
    <title>${cartTitle}</title>
</head>
<body>
<div class="grid">
    <%@include file="header.jsp" %>
    <article class="content">
        <section class="cart-wrapper">
            <a class="bigHeader" >
                ${cartTitle}
            </a>
            <c:forEach var="cPos" items="${cart.positions}">
                <div class="cartBox">
                    <img class="pizzaImage" src="${cPos.pizza.imagePath}">
                    <div class="bigCartPizzaInfo">
                        <a class="pizzaName">
                            <c:if test="${lang=='ru'}">
                                ${cPos.pizza.titleRu}
                            </c:if>
                            <c:if test="${lang=='en'}">
                                ${cPos.pizza.title}
                            </c:if>
                        </a>
                        <br/>
                        <a class="cartPizzaInfoBig">
                                ${pizzaSizeTitle}: ${cPos.size.diameterCm} ${cm}
                        </a>
                        <br/>
                        <a>
                                ${rightPizzaPrice}: ${cPos.size.price} ${byn} * ${cPos.numOfPizzas} ${pcs}
                            = ${cPos.size.price*cPos.numOfPizzas} ${byn};
                        </a>
                    </div>
                    <div class="pizzaNumberControl">
                        <form method="post" action="controller?command=edit_cart">
                            <input type="hidden" name="action" value="minus">
                            <input type="hidden" name="cartPos" value=${cPos}>
                            <input type="submit" class="buttonEditCart" id="minus" value="-">
                        </form>
                        <form method="post" action="controller?command=edit_cart">
                            <input type="hidden" name="action" value="plus">
                            <input type="hidden" name="cartPos" value=${cPos}>
                            <input type="submit" class="buttonEditCart" id="plus" value="+">
                        </form>
                    </div>
                </div>
            </c:forEach>
            <a class="bigHeader">${finalPriceTitle}: ${cart.finalSum} ${byn}</a>
        </section>
    </article>
    <%@include file="footer.jsp" %>
</div>
</body>
</html>
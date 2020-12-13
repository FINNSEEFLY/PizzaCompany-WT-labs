<html>
<head>
    <%@include file="../head/defaultheader.jsp" %>
    <fmt:message bundle="${loc}" key="local.title.main" var="mainTitle"/>
    <fmt:message bundle="${loc}" key="local.input.form.price.cm" var="cm"/>
    <fmt:message bundle="${loc}" key="local.input.form.price.byn" var="byn"/>
    <c:set var="pizzas" scope="request" value='<%=request.getAttribute("pizzas")%>'/>
    <title>${mainTitle}</title>
</head>
<body>
<div class="grid">
    <%@include file="header.jsp" %>
    <article class="content">
        <section class="catalog-wrapper">
            <c:forEach var="pizza" items="${pizzas}">
                <div class="pizzaBox">
                    <img class="pizzaImage" src="${pizza.imagePath}">
                    <h3 class="pizzaTitle">
                        <c:if test="${lang=='ru'}">
                            ${pizza.titleRu}
                        </c:if>
                        <c:if test="${lang=='en'}">
                            ${pizza.title}
                        </c:if>
                    </h3>
                    <div class="ingredients">
                        <c:forEach var="ingredient" items="${pizza.ingredients}">
                            <div class="ingredient">
                                <c:if test="${lang=='ru'}">
                                    ${ingredient.nameRu}
                                </c:if>
                                <c:if test="${lang=='en'}">
                                    ${ingredient.name}
                                </c:if>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="buyButtons">
                        <c:forEach var="size" items="${pizza.sizes}">
                            <form class="form-price" method="post" action="controller?command=add_to_card">
                                <input type="hidden" class="pizzaButton" name="pizza" value="${pizza}"/>
                                <input type="hidden" class="pizzaButton" name="size_id" value="${size.id}"/>
                                <input type="submit" class="pizzaButton"
                                       value="${size.diameterCm} ${cm} | ${size.price} ${byn} "/>
                            </form>
                        </c:forEach>
                    </div>
                </div>
            </c:forEach>
        </section>
    </article>
    <section class="rightBox">

    </section>
    <%@include file="footer.jsp" %>
</div>
</body>
</html>
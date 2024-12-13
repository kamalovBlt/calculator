<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="ru-ru">
<jsp:include page="header.jsp"/>
<body>
<jsp:include page="navbar.jsp"/>
<div class="urn-model-container">
    <div class="urn-model">
        <h2>Урновая модель: все одного типа</h2>
        <div class="urn-model-form">
            <form action="${pageContext.request.contextPath}/calculateurnmodel" method="post">

                <input type="hidden" name="formType" value="urnmodel">

                <div class="num-input">
                    <label for="n-urn-model">n = </label>
                    <input type="number" id="n-urn-model" name="n" required>
                </div>

                <div class="num-input">
                    <label for="m-urn-model">m = </label>
                    <input type="number" id="m-urn-model" name="m" required>
                </div>

                <div class="num-input">
                    <label for="k-urn-model">k = </label>
                    <input type="number" id="k-urn-model" name="k" required>
                </div>

                <input type="submit" value="Посчитать" class="submit-button">

            </form>
            <p class="answer">Ответ: ${urnmodel}</p>
        </div>
    </div>

    <div class="urn-model">
        <h2>Урновая модель: некоторое количество одного типа</h2>
        <div class="urn-model-form">
            <form action="${pageContext.request.contextPath}/calculateurnmodel" method="post">

                <input type="hidden" name="formType" value="urnmodelr">

                <div class="num-input">
                    <label for="n-urn-model-r">n = </label>
                    <input type="number" id="n-urn-model-r" name="n" required>
                </div>

                <div class="num-input">
                    <label for="m-urn-model-r">m = </label>
                    <input type="number" id="m-urn-model-r" name="m" required>
                </div>

                <div class="num-input">
                    <label for="k-urn-model-r">k = </label>
                    <input type="number" id="k-urn-model-r" name="k" required>
                </div>

                <div class="num-input">
                    <label for="r-urn-model-r">r = </label>
                    <input type="number" id="r-urn-model-r" name="r" required>
                </div>

                <input type="submit" value="Посчитать" class="submit-button">

            </form>
            <p class="answer">Ответ: ${urnmodelr}</p>
        </div>
    </div>
</div>

</body>
</html>

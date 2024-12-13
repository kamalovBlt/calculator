<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="ru-ru">
<jsp:include page="header.jsp"/>
<body>
<jsp:include page="navbar.jsp"/>

<div class="combinatoric-containers">
    <div class="permutations">

        <h1>Перестановки</h1>

        <div class="permutations-no-repeat">

            <h2>Без повторений</h2>

            <form action="${pageContext.request.contextPath}/calculate" method="post">

                <input type="hidden" name="formType" value="permutations-no-repeat">
                <div class="num-input">
                    <p>n =</p>
                    <label for="n-permutations-no-repeat"></label>
                    <input type="number" id="n-permutations-no-repeat" name="n" required>
                </div>


                <input type="submit" value="Посчитать">

            </form>
            <p>Ответ: ${permutationsnorepeatresult}</p>
        </div>

        <div class="permutations-repeat">

            <h2>С повторениями</h2>

            <div class="num-input">
                <p>n =</p>
                <label for="permutations-repeat-nums-count"></label>
                <input type="number" id="permutations-repeat-nums-count" min="1" required>
            </div>



            <button onclick="createForms()">Ввести</button>
            <button onclick="deleteForms()">Очистить</button>

            <form id="permutations-repeat-form" action="${pageContext.request.contextPath}/calculate" method="post">

            </form>
            <p>Ответ: ${permutationsrepeatresult}</p>
            <script>
                function deleteForms() {
                    const container = document.getElementById("permutations-repeat-form");
                    container.innerHTML = "";
                }

                function createForms() {
                    const container = document.getElementById("permutations-repeat-form");
                    container.innerHTML = "";
                    container.innerHTML += "<input type='hidden' name='formType' value='permutations-repeat'>"
                    const number = parseInt(document.getElementById("permutations-repeat-nums-count").value);
                    if (isNaN(number) || number <= 0) {
                        alert('Введите корректное положительное число');
                        return;
                    }
                    for (let i = 0; i < number; i++) {
                        container.innerHTML += "<div class='num-input' > " + "<label for='form-" + (i + 1) + "'>n" + (i + 1) + "</label>" +
                            "<br>" +
                            "<input type='number' id='form-" + (i + 1) + "' name='" + i + "'><br>" + "</div>";
                    }
                    container.innerHTML += "<input type='submit' value='Посчитать'>"
                }
            </script>
        </div>

    </div>

    <div class="placement">
        <h1>Размещения</h1>

        <div class="placement-no-repeat">
            <h2>Без повторений</h2>
            <form action="${pageContext.request.contextPath}/calculate" method="post">

                <input type="hidden" name="formType" value="placement-no-repeat">
                <div class="num-input">
                    <p>n = </p>
                    <label for="n-placement-no-repeat"></label>
                    <input type="number" id="n-placement-no-repeat" name="n" required>
                </div>
                <div class="num-input">
                    <p>k = </p>
                    <label for="k-placement-no-repeat"></label>
                    <input type="number" id="k-placement-no-repeat" name="k" required>
                </div>
                <input type="submit" value="Посчитать">
            </form>
            <p>Ответ: ${placementnorepeatresult}</p>
        </div>
        <div class="placement-repeat">
            <h2>С повторениями</h2>
            <form action="${pageContext.request.contextPath}/calculate" method="post">

                <input type="hidden" name="formType" value="placement-repeat">
                <div class="num-input">
                    <p>n = </p>
                    <label for="n-placement-repeat"></label>
                    <input type="number" id="n-placement-repeat" name="n" required>
                </div>

                <div class="num-input">
                    <p>k =</p>
                    <label for="k-placement-repeat"></label>
                    <input type="number" id="k-placement-repeat" name="k" required>
                </div>
                <input type="submit" value="Посчитать">

            </form>
            <p>Ответ: ${placementrepeatresult}</p>
        </div>
    </div>
    <div class="combination">
        <h1>Сочетания</h1>
        <div class="combination-no-repeat">
            <h2>Без повторений</h2>
            <form action="${pageContext.request.contextPath}/calculate" method="post">

                <input type="hidden" name="formType" value="combination-no-repeat">
                <div class="num-input">
                    <p>n = </p>
                    <label for="n-combination-no-repeat"></label>
                    <input type="number" id="n-combination-no-repeat" name="n" required>
                </div>

                <div class="num-input">
                    <p>k =</p>
                    <label for="k-combination-no-repeat"></label>
                    <input type="number" id="k-combination-no-repeat" name="k" required>
                </div>


                <input type="submit" value="Посчитать">
            </form>
            <p>Ответ: ${combinationnorepeatresult}</p>
        </div>
        <div class="combination-repeat">
            <h2>С повторениями</h2>
            <form action="${pageContext.request.contextPath}/calculate" method="post">

                <input type="hidden" name="formType" value="combination-repeat">
                <div class="num-input">
                    <p>n = </p>
                    <label for="n-combination-repeat"></label>
                    <input type="number" id="n-combination-repeat" name="n" required>
                </div>

                <div class="num-input">
                    <p>k = </p>
                    <label for="k-combination-repeat"></label>
                    <input type="number" id="k-combination-repeat" name="k" required>
                </div>
                <input type="submit" value="Посчитать">
            </form>
            <p>Ответ: ${combinationrepeatresult}</p>
        </div>
    </div>
</div>
</body>
</html>

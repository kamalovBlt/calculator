<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<jsp:include page="header.jsp"/>
<body>
<jsp:include page="navbar.jsp"/>
<div class="start-title-header">
    <h1>Про ресурс</h1>
</div>
<div class="start-title-text">
    <p><strong>Комбинаторика</strong> - раздел для вычисления сочетаний, размещений и перестановок.</p>
    <div class="section">
        <h2>Основные формулы</h2>
        <p><strong>Сочетания:</strong></p>
        <p>\(C_k^n = \frac{n!}{k!(n-k)!}\)</p>
        <p><strong>Размещения:</strong></p>
        <p>\(A_k^n = \frac{n!}{(n-k)!}\)</p>
        <p><strong>Перестановки:</strong></p>
        <p>\(P_n = n!\)</p>
    </div>
    <p><strong>Урновая модель</strong> - раздел для решения задач с выборкой.</p>
    <div class="section">
        <h2>Типы задач</h2>
        <p><strong>Задача 1:</strong> Наугад извлекаются \(k\) предметов (\(k \leq m\)). Вероятность того, что все извлеченные предметы окажутся мечеными, равна:</p>
        <p>\[
            P(A) = \frac{C_k^m}{C_k^n}
            \]</p>
        <p><strong>Задача 2:</strong> Наугад извлекаются \(k\) предметов (\(k \leq m\)). Вероятность того, что среди извлеченных предметов окажутся \(r\) меченых, равна:</p>
        <p>\[
            P(A) = \frac{C_r^m \cdot C_{k-r}^{n-m}}{C_k^n}
            \]</p>
    </div>
</div>
</body>
</html>

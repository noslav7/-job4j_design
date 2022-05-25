package ru.job4j.design.srp.ocp.violation1;

public class AreaCalculator {

    public Double calculateRectangleArea(Rectangle rectangle){

        return rectangle.length * rectangle.width;
    }

    public Double calculateCircleArea(Circle circle){

        return (22 / 7) * circle.radius * circle.radius;

    }
}

/*
Предположим, появляется какая-либо новая фигура, например, пятиугольник.
В этом случае будет необходимо снова вносить изменения в класс AreaCalculator.
По мере увеличения (изменения) числа типов фигур ситуация становится все более запутанной,
поскольку класс AreaCalculator продолжает меняться, и каждый использующий этот класс должен
будет регулярно обновлять свои библиотеки, которые содержат этот класс.
В результате класс AreaCalculator не будет гарантированно "базовым" ("финализированным"),
поскольку каждый раз, когда появляется новая форма, он будет изменяться.
Таким образом, данная конструкция не закрыта для модификации - нарушает OCP.
 */

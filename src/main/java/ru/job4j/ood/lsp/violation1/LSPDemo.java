package ru.job4j.ood.lsp.violation1;

public class LSPDemo {

    public void calculateArea(Rectangle r) {
        r.setBreadth(2);
        r.setLength(3);

        assert r.getArea() == 6 : printError("area", r);

        assert r.getLength() == 3 : printError("length", r);

        assert r.getBreadth() == 2 : printError("breadth", r);
    }

    private String printError(String errorIdentifier, Rectangle r) {
        return "Unexpected value of " + errorIdentifier + "  for instance of " + r.getClass().getName();
    }

    public static void main(String[] args) {
        LSPDemo lsp = new LSPDemo();

        lsp.calculateArea(new Rectangle());

        lsp.calculateArea(new Square());
    }
}

/*
В соответствии с принципом LSP, функции, использующие ссылки на базовые (родительские) классы, должны иметь
возможность использовать объекты производного класса, не зная об этом. Таким образом, в приведенном примере
функция calculateArea, которая использует ссылку «Rectangle», должна иметь возможность использовать объекты
производного класса, например Square, и выполнять требование, предъявляемое определением Rectangle:
- длина всегда должна быть равна длине, переданной в качестве входных данных для метода setLength,
- ширина всегда должна быть равна ширине, переданной на вход методу setBreadth,
- площадь всегда должна быть равна произведению длины на ширину.

Класс Square не нуждается в таких методах, как setBreadth или setLength, поскольку стороны квадрата равны. Это
расточительно. Представьте себе сотни тысяч квадратных объектов.
Класс LSPDemo должен знать подробности о производных классах Rectangle (например, Square) для правильного кодирования,
чтобы избежать возникновения ошибки. Изменение в существующем коде, чтобы заботиться о производном классе, в первую
очередь нарушает принцип открытого-закрытого.
*/
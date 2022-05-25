package ru.job4j.design.srp.ocp.violation2;

import java.security.InvalidParameterException;

public class SimpleCalculator implements ICalculator {

    @Override
    public void calculate(IOperation operation)
    {
        if(operation == null) {
            throw new InvalidParameterException("Some message");
        }

        if(operation instanceof Addition) {
            Addition obj = (Addition) operation;
            obj.setResult(obj.getFirstOperand() + obj.getSecondOperand());
        } else if(operation instanceof Substraction) {
            Addition obj = (Addition) operation;
            obj.setResult(obj.getFirstOperand() - obj.getSecondOperand());
        }
    }
}

/*
Дело в том, что когда в клиентском приложении разработчик хочет добавить, например,
возможность умножения — у него нет других вариантов, кроме как изменить код класса SimpleCalculator
внутри метода calculate().
Таким образом, поскольку упомянутый класс не "закрыт от изменений", то этот код не соответствует OCP.
 */

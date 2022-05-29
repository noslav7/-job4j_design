package ru.job4j.ood.dip.violation1;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class StringProcessor {
    private final StringReader stringReader;
    private final StringWriter stringWriter;

    public StringProcessor(StringReader stringReader, StringWriter stringWriter) {
        this.stringReader = stringReader;
        this.stringWriter = stringWriter;
    }

    public void printString() throws IOException {
        stringWriter.write(stringReader.read());
    }
}

/*
В данном примере StringReader and StringWriter - не абстрактные классы, компоненты более низкого уровня,
помещенные в один package. StringProcessor, компонент верхнего уровня, помещен в другой package. Класс StringProcessor
зависит от классов StringReader and StringWriter. Следовательно, поскольку в данном примере не соблюдается принцип DIP,
класс StringProcessor нельзя переиспользовать в другом контексте.
 */
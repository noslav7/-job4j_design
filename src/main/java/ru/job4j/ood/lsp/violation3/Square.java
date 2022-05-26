package ru.job4j.ood.lsp.violation3;

public class Square extends Rectangle {

    @Override
    public void setBreadth(int breadth) {
        super.setBreadth(breadth);
        super.setLength(breadth);
    }

    @Override
    public void setLength(int length) {
        super.setLength(length);
        super.setBreadth(length);
    }
}





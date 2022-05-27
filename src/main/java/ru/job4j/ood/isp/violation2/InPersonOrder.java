package ru.job4j.ood.isp.violation2;

public class InPersonOrder implements IOrder {

    @Override
    public void purchase() {
        System.out.println("Something purchased");

    }

    @Override
    public void processPaypalPayment() {
        throw new UnsupportedOperationException("Paypal payment not supported");
    }
}

/*
В данном примере ISP нарушен, поскольку не смотря на то, что классу InPersonOrder
 метод processPaypalPayment() не требуется, в данном классе данный метод должен быть
 реализован.
 */
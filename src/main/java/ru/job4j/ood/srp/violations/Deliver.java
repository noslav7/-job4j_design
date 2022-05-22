package ru.job4j.ood.srp.violations;

public class Deliver {
    private String address;
    private CourierTransport courierTransport;

    public Deliver() {
    }

    public Deliver(String address, CourierTransport courierTransport) {
        this.address = address;
        this.courierTransport = courierTransport;
    }

    public CourierTransport getCourierTransport() {
        return courierTransport;
    }

    public void setCourierTransport(CourierTransport courierTransport) {
        this.courierTransport = courierTransport;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static void main(String[] args) {
        /* принимаем новый вид заказа с базы (псевдокод)
        String type = database.getTypeOfDeliver(); */

        Deliver deliver = new Deliver();

        /* заполняем транспорт в доставку
        deliver.setCourierTransport(getCourierTransportByType(type)); */

        /* доставляем */
        deliver.getCourierTransport().deliver();

    }

    public static CourierTransport getCourierTransportByType(String type) {
        switch (type) {
            case "CarDeliver":
                return new CarCreator().createTransport();
            case "TruckDeliver":
                return new TruckCreator().createTransport();
            default:
                throw new RuntimeException();
        }
    }
}

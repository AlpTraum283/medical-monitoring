package liga.medical.medicalmonitoring.core.solid;
// 1 принцип - single responsibility principle. Заключается в том, что класс должен отвечать за одну какую-либо функцию.
// Данный класс нарушает его тем, что может заниматься сразу несколькими делами - печатать заказы, бронировать машины..
// Нужно разделить этот класс на несколько различных сервисов.
public class AntiS {
//    public Car findCar(String carNo) {
//
//        return car;
//    }
//
//    public Order orderCar(String carNo, Client client) {
//
//        return order;
//    }
//
//    public void printOrder(Order order) {
//
//    }
    public void getCarInterestInfo(String carType) {
        if (carType.equals("sedan")) {
            // print smth about sedan
        }
        if (carType.equals("pickup")) {
            // print smth about pickup
        }
        if (carType.equals("van")) {
            // print smth about van
        }
    }

}


package liga.medical.medicalmonitoring.core.solid;
// 4 принцип - interface segregation principle. Заключается в том, что идеальный интерфейс - интерфейс с одним методом.
// Так нужно делать, чтобы при случае не реализовывать ненужный метод. Данный интерфейс необходимо разделить на 3 разных.

public class AntiI {
    interface Payments {
        void payWebMoney();
        void payCreditCard();
        void payPhoneNumber();
    }
}

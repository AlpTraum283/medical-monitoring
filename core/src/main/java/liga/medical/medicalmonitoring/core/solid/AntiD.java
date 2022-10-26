package liga.medical.medicalmonitoring.core.solid;
// 5 принцип - dependency inversion principle. Класс Shop напрямую зависит от класса Cash и может работать только с ним.
// Но если нужно будет добавить еще пару классов по типу Cash, нужно будет много изменять кода.
// Лучше сделать общий класс, от которого будут наследоваться способы оплаты, например Payment.
// После чего внедрить класс Payment в Shop.
// В таком случае Shop сможет работать с различными реализациями способов оплаты,
// и все что нужно будет сделать при появлении нового способа - унаследовать еще один класс от Payment.
public class AntiD {
    class Cash {
        public void doTransaction(Integer amount){
            // transaction
        }
    }

    class Shop {
        private Cash cash;
        public Shop(Cash cash) {
            this.cash = cash;
        }
        public void doPayment(Object order, Integer amount){
            cash.doTransaction(amount);
        }
    }
}

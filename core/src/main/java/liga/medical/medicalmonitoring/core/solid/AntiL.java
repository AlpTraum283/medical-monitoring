package liga.medical.medicalmonitoring.core.solid;
// 3 принцип - Liskov substitution principle. Нарушением является то,
// что класс DepositAccount не использует методы родительского класса полностью.
// Необходимо убрать метод payment из класса Account, и реализовать его в salaryAccount.
// Таким образом метод будет только в классе, который его использует.
public class AntiL {
    class Account {
        public Integer balance(String numberAccount){
            // return balance
            return 0;
        };
        public void refill(String numberAccount, Integer sum){
            // balance refill
        }
        public void payment(String numberAccount, Integer sum){
            // some transaction
        }

    }
    class SalaryAccount extends Account{
        @Override
        public Integer balance(String numberAccount){
            // return balance
            return 0;
        };
        @Override
        public void refill(String numberAccount, Integer sum){
            // balance refill
        }
        @Override
        public void payment(String numberAccount, Integer sum){
            // some transaction
        }
    }
    class DepositAccount extends Account{
        @Override
        public Integer balance(String numberAccount){
            // return balance
            return 0;
        };
        @Override
        public void refill(String numberAccount, Integer sum){
            // balance refill
        }
        @Override
        public void payment(String numberAccount, Integer sum){
            throw new UnsupportedOperationException("Operation not supported");
        }
    }
}

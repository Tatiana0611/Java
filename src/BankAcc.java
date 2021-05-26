public class BankAcc {
    private int numberBankAcc;
    private Double money;

    BankAcc() {
        numberBankAcc = (int) (Math.random() * 1000000000);
        money = Math.random() * 10000;

    }

    int get_numberBankAcc() {
        return numberBankAcc;
    }

    Double balance() {
        return money;
    }

    void setMoney(Double x) {
        money += x;
    }
}
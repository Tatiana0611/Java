public class Account {

    private String FirstName;
    private String LastName;
    private BankAcc selfBankAcc;

    Account(String userFirstName, String userLastName) {
        FirstName = userFirstName;
        LastName = userLastName;
        selfBankAcc = new BankAcc();
    }

    // get information

    String getName() {
        return (FirstName + " " + LastName);
    }

    int getNumberBankAcc() {
        return selfBankAcc.get_numberBankAcc();
    }

    Double balanceAcc() {
        return selfBankAcc.balance();
    }

    // set information

    void setBankAcc(Double x) {
        selfBankAcc.setMoney(x);
    }

}







import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Transaction {
    static private int count = 0;
    private int ID;
    static Lock lock = new ReentrantLock();

    Date date;

    private boolean result_transaction;
    private String nameAccountSender;
    private String nameAccountRecipient;
    private int senderBankAccNumber;
    private int recipientBankAccNumber;
    private Double transferAmount;

    // initial value
    private Double senderInitialBalanceValue;
    private Double recipientInitialBalanceValue;

    // subsequent value
    private Double senderSubsequentBalanceValue;
    private Double recipientSubsequentBalanceValue;

    Transaction(Account sender, Account recipient, Double amount) {

            nameAccountSender = sender.getName();
            nameAccountRecipient = recipient.getName();
            senderBankAccNumber = sender.getNumberBankAcc();
            recipientBankAccNumber = recipient.getNumberBankAcc();
            transferAmount = amount;

            ///////////////////////////////////////////////////////////////////////////////////
            lock.lock();
            if (sender.balanceAcc() >= amount) {

                senderInitialBalanceValue = sender.balanceAcc();
                sender.setBankAcc(-amount);
                senderSubsequentBalanceValue = sender.balanceAcc();

                recipientInitialBalanceValue = recipient.balanceAcc();
                recipient.setBankAcc(amount);
                recipientSubsequentBalanceValue = recipient.balanceAcc();

                ID = ++count;
                date = new Date();

                lock.unlock();
            ///////////////////////////////////////////////////////////////////////////////////

                result_transaction = true;
            }

             else {
                date = new Date();
                result_transaction = false;
            }


    }

    void printShortInformation() {
        if (result_transaction) {
            System.out.println(ID + " " + date + " " + nameAccountSender + " transferred " + transferAmount + " dollars to " + nameAccountRecipient);
        } else {
            System.out.println("The transaction № " + ID + " was not completed. Insufficient funds in the account.");
        }
    }

    void printFullInformation() {
        System.out.println("transaction number: " + ID + "   |   " + date);
        System.out.println("sender's account: " + "№ " + senderBankAccNumber + " " + nameAccountSender);
        System.out.println("recipient's account: " + "№ " + recipientBankAccNumber + " " + nameAccountRecipient);
        String str = String.format("%.2f", transferAmount);
        System.out.println("transfer amount: $" + str);
        if (result_transaction) {
            String str2 = String.format("%.2f", senderInitialBalanceValue);
            String str3 = String.format("%.2f", senderSubsequentBalanceValue);
            System.out.println("initial amount in the sender's account: $" + str2 + "   subsequent amount in the sender's account: $" + str3);
            String str4 = String.format("%.2f", recipientInitialBalanceValue);
            String str5 = String.format("%.2f", recipientSubsequentBalanceValue);
            System.out.println("initial amount in the recipient's account: $" + str4 + "   subsequent amount in the recipient's account: $" + str5);
        } else {
            System.out.println("The transaction was not completed. Insufficient funds in the account.");
        }
        System.out.println("______________________________________________");
    }

}


/**
 * Transaction
 *
 * Represents a financial transaction.
 *
 * Author: Kabilesh C
 * Email: kabileshc.dev@gmail.com
 */

public class Transaction {

    int id;
    int amount;
    String merchant;
    String account;
    String time;

    public Transaction(int id, int amount, String merchant, String account, String time) {
        this.id = id;
        this.amount = amount;
        this.merchant = merchant;
        this.account = account;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Transaction{id=" + id +
                ", amount=" + amount +
                ", merchant='" + merchant + '\'' +
                ", account='" + account + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
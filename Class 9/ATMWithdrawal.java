import java.util.Scanner;

public class ATMWithdrawal {
    public static void main(String[] args) {

        double balance = 5000;

        System.out.println("Welcome To Nagarjun ATM");

        Scanner sc = new Scanner(System.in);

        // 1. If withdrawal amount exceeds balance, show Insufficient Balance
        // 2. If withdrawal amount is less than balance, show Withdrawal Success
        // 3. If amount is negative, show Invalid Amount
        // 4. If amount equals balance, show Account Balance Is Zero

        System.out.println("Enter cash withdrawal amount:");

        double amount = sc.nextDouble();
        sc.close();

        if (amount < 0) {
            System.out.println("Invalid Amount");
        }
        else if (amount > balance) {
            System.out.println("Insufficient Balance");
        }
        else if (amount == balance) {
            System.out.println(
                "Cash Withdrawal Successful, Account Balance Is Zero"
            );
        }
        else {
            System.out.println("Cash Withdrawal Successful");
        }
    }
}
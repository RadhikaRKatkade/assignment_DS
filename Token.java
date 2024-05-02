import java.util.*;

class Token {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter number of node: ");
        int n = sc.nextInt();
        System.out.print("ring formed below is: ");
        for (int i = 0; i < n; i++) {
            System.out.print(" " + i + "->");
        }
        System.out.print(" " + 0);
        System.out.println();
        int choice = 0;
        do {
            System.out.print("enter sender: ");
            int sender = sc.nextInt();

            System.out.print("enter receiver: ");
            int receiver = sc.nextInt();

            System.out.print("enter data: ");
            String data = sc.next();

            int Token = 0;
            System.out.println("Token passing: ");
            for (int i = 0; i < sender; i++) {
                System.out.print(" " + i + "->");
            }
            System.out.print(sender);
            System.out.println();
            System.out.println("sender: " + sender + " sending data: " + data);

            for (int i = sender; i != receiver; i = (i + 1) % n) {
                System.out.println("Data: " + data + " forwarded by: " + i);

            }
            System.out.println("Receiver: " + receiver + " receiving " + data);
            Token = sender;
            System.out.println("Do you want to continue Yes(1) | No(0)");
            choice = sc.nextInt();
        } while (choice == 1);

    }
}
import java.util.*;

class Bully {
    int coordinator;
    int max_processes;
    boolean processes[];

    public Bully(int max) {
        coordinator = max;
        max_processes = max;
        processes = new boolean[max_processes];

        System.out.println("creating processes....");
        for (int i = 0; i < max; i++) {
            processes[i] = true;
            System.out.println("P" + (i + 1) + " created");
        }
        System.out.println("Process P " + coordinator + " is the coordinator");
    }

    void displayProcesses() {
        for (int i = 0; i < max_processes; i++) {
            if (processes[i]) {
                System.out.println("P" + (i + 1) + " is up");
            } else {
                System.out.println("P" + (i + 1) + " is down");
            }
        }
        System.out.println("Process P" + coordinator + " is the coordinator");
    }

    void upProcesses(int processes_id) {
        if (!processes[processes_id - 1]) {
            processes[processes_id] = true;
            System.out.println("Process P" + processes_id + " is up now");
        } else {
            System.out.println("Process P" + processes_id + " is already up");
        }
    }

    void downProcesses(int processes_id) {
        if (!processes[processes_id - 1]) {
            processes[processes_id] = false;
            System.out.println("Process P" + processes_id + " is already down");
        } else {
            System.out.println("Process P" + processes_id + " is down");
        }
    }

    void runElection(int processes_id) {
        coordinator = processes_id;
        boolean keepGoing = true;

        for (int i = processes_id; i < max_processes && keepGoing; i++) {
            System.out.println("message send from process " + processes_id + " to process P" + (i + 1));

            if (processes[i]) {
                keepGoing = false;
                runElection(i + 1);
            }
        }
    }

    public static void main(String[] args) {
        int max_processes = 0, processes_id = 0;
        Bully bully = null;
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("bully algorithm");
            System.out.println("1.Create Process");
            System.out.println("2.Display Process");
            System.out.println("3.Up process");
            System.out.println("4.Down process");
            System.out.println("5.run election algorithm");
            System.out.println("7.exit system");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("enter number of processes: ");
                    max_processes = sc.nextInt();
                    bully = new Bully(max_processes);
                    break;

                case 2:
                    System.out.print("display Processes: ");
                    bully.displayProcesses();
                    break;

                case 3:
                    System.out.print("Enter process number to up:  ");
                    processes_id = sc.nextInt();
                    bully.upProcesses(processes_id);
                    break;

                case 4:
                    System.out.print("enter process number to Down: ");
                    processes_id = sc.nextInt();
                    bully.downProcesses(processes_id);
                    break;

                case 5:
                    System.out.print("enter process number which will perform election: ");
                    processes_id = sc.nextInt();
                    bully.runElection(processes_id);
                    break;

                case 6:
                    System.exit(0);
                    break;
            }

        }
    }

}
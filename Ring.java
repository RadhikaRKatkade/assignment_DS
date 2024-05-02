import java.util.*;

class Ring {
    int coordinator;
    int max_processes;
    boolean processes[];
    ArrayList<Integer> pid;

    public Ring(int max) {
        coordinator = max;
        max_processes = max;
        processes = new boolean[max];
        pid = new ArrayList<Integer>();

        System.out.print("creating processes...");
        for (int i = 0; i < max; i++) {
            processes[i] = true;
            System.out.println("Process P" + (i + 1) + " created");
        }
        System.out.println("Process P" + coordinator + " is the coordinator");
    }

    void displayProcess(int process_id) {
        for (int i = 0; i < max_processes; i++) {
            if (processes[process_id]) {
                System.out.println("Process p" + process_id + " is up now");
            } else {
                System.out.println("Process P" + process_id + " is down now");
            }
        }
    }

    void upProcesses(int process_id) {
        if (processes[process_id - 1]) {
            processes[process_id - 1] = true;
            System.out.println("Process P" + process_id + " is already up");
        } else {
            System.out.println("process P" + process_id + " is up");
        }
    }

    void downProcesses(int process_id) {
        if (processes[process_id - 1]) {

            System.out.println("Process P" + process_id + " is already down");
        } else {
            processes[process_id - 1] = false;
            System.out.println("process P" + process_id + " is down");
        }
    }

    void displayArrayList(ArrayList<Integer> pid) {
        System.out.println("[");
        for (Integer x : pid) {
            System.out.println(" " + x);
        }
        System.out.println(" ]\n");
    }

    void initElection(int process_id){
        if(processes[process_id-1]){
            pid.add(process_id);
            int temp = process_id;
            System.out.println("Process p "+process_id+" sending the following list:-");
            displayArrayList(pid);
            temp = (temp+1)%max_processes;
        }
        coordinator = Collections.max(pid);
        System.out.println("Process P"+process_id +"declared that coordinator"+coordinator+" as the coordinator ");
        pid.clear();
    }

    public static void main(String[] args) {
        Ring ring = null;
        int max_processes=0, process_id=0;
        int choice =0;
        Scanner sc = new Scanner(System.in);
        
    }

}
package linkedlist;

class ProcessNode {
    int processId;
    int burstTime;
    int priority;
    int remainingTime;
    int waitingTime;
    int turnaroundTime;
    ProcessNode next;
    
    ProcessNode(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.remainingTime = burstTime;
        this.waitingTime = 0;
        this.turnaroundTime = 0;
        this.next = null;
    }
}

class RoundRobinLinkedList {
    private ProcessNode head;
    private ProcessNode current;
    private int processCount;
    private int totalWaitingTime;
    private int totalTurnaroundTime;
    
    RoundRobinLinkedList() {
        this.head = null;
        this.current = null;
        this.processCount = 0;
        this.totalWaitingTime = 0;
        this.totalTurnaroundTime = 0;
    }
    
    void addProcess(int processId, int burstTime, int priority) {
        ProcessNode newProcess = new ProcessNode(processId, burstTime, priority);
        if (this.head == null) {
            this.head = newProcess;
            newProcess.next = newProcess;
            this.current = newProcess;
        } else {
            ProcessNode last = this.head;
            while (last.next != this.head) {
                last = last.next;
            }
            last.next = newProcess;
            newProcess.next = this.head;
        }
        this.processCount++;
    }
    
    boolean removeProcess(int processId) {
        if (this.head == null) {
            return false;
        }
        
        if (this.head.processId == processId) {
            if (this.head.next == this.head) {
                this.head = null;
                this.current = null;
            } else {
                ProcessNode last = this.head;
                while (last.next != this.head) {
                    last = last.next;
                }
                last.next = this.head.next;
                this.head = this.head.next;
                if (this.current.processId == processId) {
                    this.current = this.head;
                }
            }
            this.processCount--;
            return true;
        }
        
        ProcessNode current = this.head;
        do {
            if (current.next.processId == processId) {
                current.next = current.next.next;
                if (this.current.processId == processId) {
                    this.current = current.next;
                }
                this.processCount--;
                return true;
            }
            current = current.next;
        } while (current != this.head);
        
        return false;
    }
    
    void simulateRoundRobin(int timeQuantum) {
        if (this.head == null) {
            System.out.println("No processes to schedule");
            return;
        }
        
        System.out.println("Round Robin Scheduling with time quantum: " + timeQuantum);
        System.out.println("Process ID | Burst Time | Remaining Time | Waiting Time | Turnaround Time");
        System.out.println("-----------|------------|----------------|--------------|----------------");
        
        int currentTime = 0;
        int completedProcesses = 0;
        
        while (completedProcesses < this.processCount) {
            if (this.current.remainingTime > 0) {
                int executionTime = Math.min(timeQuantum, this.current.remainingTime);
                this.current.remainingTime -= executionTime;
                currentTime += executionTime;
                
                System.out.printf("%10d | %10d | %14d | %12d | %14d%n", 
                                this.current.processId, this.current.burstTime, 
                                this.current.remainingTime, this.current.waitingTime, 
                                this.current.turnaroundTime);
                
                if (this.current.remainingTime == 0) {
                    this.current.turnaroundTime = currentTime;
                    this.totalTurnaroundTime += this.current.turnaroundTime;
                    this.totalWaitingTime += this.current.waitingTime;
                    completedProcesses++;
                } else {
                    this.current.waitingTime += timeQuantum;
                }
            }
            
            this.current = this.current.next;
        }
        
        double avgWaitingTime = (double) this.totalWaitingTime / this.processCount;
        double avgTurnaroundTime = (double) this.totalTurnaroundTime / this.processCount;
        
        System.out.println("\nAverage Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
    }
    
    void displayProcesses() {
        if (this.head == null) {
            System.out.println("No processes in the queue");
            return;
        }
        
        System.out.println("Process Queue:");
        ProcessNode current = this.head;
        do {
            System.out.println("Process ID: " + current.processId + 
                             ", Burst Time: " + current.burstTime + 
                             ", Priority: " + current.priority + 
                             ", Remaining Time: " + current.remainingTime);
            current = current.next;
        } while (current != this.head);
    }
    
    ProcessNode getCurrentProcess() {
        return this.current;
    }
    
    void moveToNextProcess() {
        if (this.current != null) {
            this.current = this.current.next;
        }
    }
    
    int getProcessCount() {
        return this.processCount;
    }
    
    void resetProcesses() {
        ProcessNode current = this.head;
        if (current != null) {
            do {
                current.remainingTime = current.burstTime;
                current.waitingTime = 0;
                current.turnaroundTime = 0;
                current = current.next;
            } while (current != this.head);
        }
        this.totalWaitingTime = 0;
        this.totalTurnaroundTime = 0;
    }
}

public class RoundRobinScheduler {
    public static void main(String[] args) {
        RoundRobinLinkedList scheduler = new RoundRobinLinkedList();
        
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 1);
        scheduler.addProcess(4, 12, 3);
        scheduler.addProcess(5, 6, 2);
        
        System.out.println("Initial process queue:");
        scheduler.displayProcesses();
        
        System.out.println("\nCurrent process:");
        ProcessNode currentProcess = scheduler.getCurrentProcess();
        if (currentProcess != null) {
            System.out.println("Process ID: " + currentProcess.processId);
        }
        
        System.out.println("\nSimulating Round Robin with time quantum 3:");
        scheduler.simulateRoundRobin(3);
        
        System.out.println("\nMoving to next process:");
        scheduler.moveToNextProcess();
        currentProcess = scheduler.getCurrentProcess();
        if (currentProcess != null) {
            System.out.println("Current Process ID: " + currentProcess.processId);
        }
        
        System.out.println("\nProcess queue after simulation:");
        scheduler.displayProcesses();
        
        System.out.println("\nResetting processes for new simulation:");
        scheduler.resetProcesses();
        scheduler.displayProcesses();
        
        System.out.println("\nSimulating Round Robin with time quantum 2:");
        scheduler.simulateRoundRobin(2);
        
        System.out.println("\nRemoving process with ID 3:");
        scheduler.removeProcess(3);
        scheduler.displayProcesses();
        
        System.out.println("\nFinal simulation with remaining processes:");
        scheduler.resetProcesses();
        scheduler.simulateRoundRobin(4);
    }
} 
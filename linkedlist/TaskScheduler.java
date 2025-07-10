package linkedlist;
import java.util.ArrayList;
import java.util.List;

class TaskNode {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;
    
    TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskSchedulerLinkedList {
    private TaskNode head;
    private TaskNode current;
    private int taskCount;
    
    TaskSchedulerLinkedList() {
        this.head = null;
        this.current = null;
        this.taskCount = 0;
    }
    
    void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newTask = new TaskNode(taskId, taskName, priority, dueDate);
        if (this.head == null) {
            this.head = newTask;
            newTask.next = newTask;
            this.current = newTask;
        } else {
            TaskNode last = this.head;
            while (last.next != this.head) {
                last = last.next;
            }
            newTask.next = this.head;
            last.next = newTask;
            this.head = newTask;
        }
        this.taskCount++;
    }
    
    void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newTask = new TaskNode(taskId, taskName, priority, dueDate);
        if (this.head == null) {
            this.head = newTask;
            newTask.next = newTask;
            this.current = newTask;
        } else {
            TaskNode last = this.head;
            while (last.next != this.head) {
                last = last.next;
            }
            last.next = newTask;
            newTask.next = this.head;
        }
        this.taskCount++;
    }
    
    void addAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {
        if (position <= 0) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }
        
        if (position >= this.taskCount) {
            addAtEnd(taskId, taskName, priority, dueDate);
            return;
        }
        
        TaskNode newTask = new TaskNode(taskId, taskName, priority, dueDate);
        TaskNode current = this.head;
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }
        newTask.next = current.next;
        current.next = newTask;
        this.taskCount++;
    }
    
    boolean removeByTaskId(int taskId) {
        if (this.head == null) {
            return false;
        }
        
        if (this.head.taskId == taskId) {
            if (this.head.next == this.head) {
                this.head = null;
                this.current = null;
            } else {
                TaskNode last = this.head;
                while (last.next != this.head) {
                    last = last.next;
                }
                last.next = this.head.next;
                this.head = this.head.next;
                if (this.current.taskId == taskId) {
                    this.current = this.head;
                }
            }
            this.taskCount--;
            return true;
        }
        
        TaskNode current = this.head;
        do {
            if (current.next.taskId == taskId) {
                current.next = current.next.next;
                if (this.current.taskId == taskId) {
                    this.current = current.next;
                }
                this.taskCount--;
                return true;
            }
            current = current.next;
        } while (current != this.head);
        
        return false;
    }
    
    TaskNode getCurrentTask() {
        return this.current;
    }
    
    TaskNode moveToNextTask() {
        if (this.current != null) {
            this.current = this.current.next;
        }
        return this.current;
    }
    
    void displayAllTasks() {
        if (this.head == null) {
            System.out.println("No tasks in the scheduler");
            return;
        }
        
        TaskNode current = this.head;
        do {
            System.out.println("Task ID: " + current.taskId + ", Name: " + current.taskName + 
                             ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
            current = current.next;
        } while (current != this.head);
    }
    
    List<TaskNode> searchByPriority(int priority) {
        List<TaskNode> results = new ArrayList<>();
        if (this.head == null) {
            return results;
        }
        
        TaskNode current = this.head;
        do {
            if (current.priority == priority) {
                results.add(current);
            }
            current = current.next;
        } while (current != this.head);
        
        return results;
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        TaskSchedulerLinkedList taskList = new TaskSchedulerLinkedList();
        
        taskList.addAtBeginning(101, "Complete Project", 1, "2024-01-15");
        taskList.addAtEnd(102, "Review Code", 2, "2024-01-20");
        taskList.addAtPosition(1, 103, "Write Documentation", 3, "2024-01-25");
        taskList.addAtEnd(104, "Team Meeting", 1, "2024-01-30");
        
        System.out.println("All tasks:");
        taskList.displayAllTasks();
        
        System.out.println("\nCurrent task:");
        TaskNode currentTask = taskList.getCurrentTask();
        if (currentTask != null) {
            System.out.println("Task ID: " + currentTask.taskId + ", Name: " + currentTask.taskName);
        }
        
        System.out.println("\nMoving to next task:");
        TaskNode nextTask = taskList.moveToNextTask();
        if (nextTask != null) {
            System.out.println("Task ID: " + nextTask.taskId + ", Name: " + nextTask.taskName);
        }
        
        System.out.println("\nSearching for tasks with priority 1:");
        List<TaskNode> highPriorityTasks = taskList.searchByPriority(1);
        for (TaskNode task : highPriorityTasks) {
            System.out.println("Found: " + task.taskName);
        }
        
        System.out.println("\nRemoving task with ID 103:");
        taskList.removeByTaskId(103);
        taskList.displayAllTasks();
        
        System.out.println("\nMoving through tasks in circular manner:");
        for (int i = 0; i < 5; i++) {
            TaskNode task = taskList.getCurrentTask();
            if (task != null) {
                System.out.println("Current: " + task.taskName);
                taskList.moveToNextTask();
            }
        }
    }
} 
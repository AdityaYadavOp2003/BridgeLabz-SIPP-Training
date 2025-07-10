package linkedlist;
class TextStateNode {
    String textContent;
    TextStateNode next;
    TextStateNode prev;
    
    TextStateNode(String textContent) {
        this.textContent = textContent;
        this.next = null;
        this.prev = null;
    }
}

class UndoRedoLinkedList {
    private TextStateNode head;
    private TextStateNode tail;
    private TextStateNode currentState;
    private int stateCount;
    private int maxStates;
    
    UndoRedoLinkedList(int maxStates) {
        this.head = null;
        this.tail = null;
        this.currentState = null;
        this.stateCount = 0;
        this.maxStates = maxStates;
    }
    
    void addNewState(String textContent) {
        TextStateNode newState = new TextStateNode(textContent);
        
        if (this.head == null) {
            this.head = newState;
            this.tail = newState;
            this.currentState = newState;
        } else {
            if (this.currentState != this.tail) {
                this.tail = this.currentState;
                this.tail.next = null;
            }
            
            newState.prev = this.tail;
            this.tail.next = newState;
            this.tail = newState;
            this.currentState = newState;
        }
        
        this.stateCount++;
        
        if (this.stateCount > this.maxStates) {
            removeOldestState();
        }
    }
    
    private void removeOldestState() {
        if (this.head == null) {
            return;
        }
        
        this.head = this.head.next;
        if (this.head != null) {
            this.head.prev = null;
        } else {
            this.tail = null;
            this.currentState = null;
        }
        this.stateCount--;
    }
    
    String undo() {
        if (this.currentState == null || this.currentState.prev == null) {
            return null;
        }
        
        this.currentState = this.currentState.prev;
        return this.currentState.textContent;
    }
    
    String redo() {
        if (this.currentState == null || this.currentState.next == null) {
            return null;
        }
        
        this.currentState = this.currentState.next;
        return this.currentState.textContent;
    }
    
    String getCurrentText() {
        if (this.currentState == null) {
            return "";
        }
        return this.currentState.textContent;
    }
    
    boolean canUndo() {
        return this.currentState != null && this.currentState.prev != null;
    }
    
    boolean canRedo() {
        return this.currentState != null && this.currentState.next != null;
    }
    
    void displayHistory() {
        if (this.head == null) {
            System.out.println("No text history");
            return;
        }
        
        System.out.println("Text History:");
        TextStateNode current = this.head;
        int stateNumber = 1;
        
        while (current != null) {
            String marker = (current == this.currentState) ? " -> " : "    ";
            System.out.println(marker + "State " + stateNumber + ": \"" + current.textContent + "\"");
            current = current.next;
            stateNumber++;
        }
    }
    
    int getStateCount() {
        return this.stateCount;
    }
    
    int getMaxStates() {
        return this.maxStates;
    }
}

class TextEditor {
    private UndoRedoLinkedList undoRedoList;
    private String currentText;
    
    TextEditor(int maxHistorySize) {
        this.undoRedoList = new UndoRedoLinkedList(maxHistorySize);
        this.currentText = "";
        this.undoRedoList.addNewState(this.currentText);
    }
    
    void typeText(String text) {
        this.currentText += text;
        this.undoRedoList.addNewState(this.currentText);
        System.out.println("Typed: \"" + text + "\"");
        System.out.println("Current text: \"" + this.currentText + "\"");
    }
    
    void deleteText(int characters) {
        if (characters > this.currentText.length()) {
            characters = this.currentText.length();
        }
        
        if (characters > 0) {
            this.currentText = this.currentText.substring(0, this.currentText.length() - characters);
            this.undoRedoList.addNewState(this.currentText);
            System.out.println("Deleted " + characters + " characters");
            System.out.println("Current text: \"" + this.currentText + "\"");
        }
    }
    
    void clearText() {
        this.currentText = "";
        this.undoRedoList.addNewState(this.currentText);
        System.out.println("Cleared all text");
    }
    
    void undo() {
        String previousText = this.undoRedoList.undo();
        if (previousText != null) {
            this.currentText = previousText;
            System.out.println("Undo performed");
            System.out.println("Current text: \"" + this.currentText + "\"");
        } else {
            System.out.println("Cannot undo - no previous state");
        }
    }
    
    void redo() {
        String nextText = this.undoRedoList.redo();
        if (nextText != null) {
            this.currentText = nextText;
            System.out.println("Redo performed");
            System.out.println("Current text: \"" + this.currentText + "\"");
        } else {
            System.out.println("Cannot redo - no next state");
        }
    }
    
    void displayCurrentText() {
        System.out.println("Current text: \"" + this.currentText + "\"");
    }
    
    void displayHistory() {
        this.undoRedoList.displayHistory();
    }
    
    boolean canUndo() {
        return this.undoRedoList.canUndo();
    }
    
    boolean canRedo() {
        return this.undoRedoList.canRedo();
    }
    
    int getHistorySize() {
        return this.undoRedoList.getStateCount();
    }
}

public class UndoRedoEditor {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(10);
        
        System.out.println("=== Text Editor with Undo/Redo Functionality ===");
        System.out.println("Max history size: " + editor.getHistorySize());
        
        System.out.println("\n--- Typing text ---");
        editor.typeText("Hello");
        editor.typeText(" World");
        editor.typeText("!");
        
        System.out.println("\n--- Deleting text ---");
        editor.deleteText(1);
        editor.deleteText(2);
        
        System.out.println("\n--- More typing ---");
        editor.typeText(" Java");
        editor.typeText(" Programming");
        
        System.out.println("\n--- Displaying history ---");
        editor.displayHistory();
        
        System.out.println("\n--- Undo operations ---");
        editor.undo();
        editor.undo();
        editor.undo();
        
        System.out.println("\n--- Redo operations ---");
        editor.redo();
        editor.redo();
        
        System.out.println("\n--- Current state ---");
        editor.displayCurrentText();
        
        System.out.println("\n--- More operations ---");
        editor.typeText(" is fun!");
        editor.deleteText(4);
        editor.typeText(" amazing!");
        
        System.out.println("\n--- Final history ---");
        editor.displayHistory();
        
        System.out.println("\n--- Testing undo/redo limits ---");
        while (editor.canUndo()) {
            editor.undo();
        }
        System.out.println("Reached beginning of history");
        
        while (editor.canRedo()) {
            editor.redo();
        }
        System.out.println("Reached end of history");
        
        System.out.println("\n--- Final text ---");
        editor.displayCurrentText();
        
        System.out.println("\n--- Testing history limit ---");
        for (int i = 1; i <= 15; i++) {
            editor.typeText(" " + i);
        }
        
        System.out.println("\n--- History after exceeding limit ---");
        editor.displayHistory();
        System.out.println("Current history size: " + editor.getHistorySize());
    }
} 
interface Worker {
    void performDuties();
}

class Person {
    String badgeLabel;
    int registryNumber;
}

class Chef extends Person implements Worker {
    public void performDuties() {
        System.out.println("Prepares cuisine");
    }
}

class Waiter extends Person implements Worker {
    public void performDuties() {
        System.out.println("Serves guests");
    }
} 
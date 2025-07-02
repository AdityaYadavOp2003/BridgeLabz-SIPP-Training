package JavaClassAndObject.Level2;

class PalindromeChecker {
    String text;

    PalindromeChecker(String text) {
        this.text = text;
    }

    boolean isPalindrome() {
        String clean = text.replaceAll("\s+", "").toLowerCase();
        return clean.equals(new StringBuilder(clean).reverse().toString());
    }

    void displayResult() {
        System.out.println("Text \"" + text + "\" is " + (isPalindrome() ? "" : "not ") + "a palindrome.");
    }

    public static void main(String[] args) {
        PalindromeChecker checker = new PalindromeChecker("Madam");
        checker.displayResult();
    }
}

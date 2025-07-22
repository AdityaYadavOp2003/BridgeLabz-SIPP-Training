package searches;
public class SearchWordInSentences {
    public static String findSentenceWithWord(String[] sentenceArray, String searchWord) {
        for (String sentence : sentenceArray) {
            if (sentence.contains(searchWord)) {
                return sentence;
            }
        }
        return "Not Found";
    }
    public static void main(String[] args) {
        String[] sentences = {"The sky is blue.", "Java is powerful.", "Practice makes perfect."};
        String resultSentence = findSentenceWithWord(sentences, "Java");
        System.out.println(resultSentence);
    }
} 
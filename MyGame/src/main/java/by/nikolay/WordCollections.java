package by.nikolay;


import java.io.IOException;
import java.util.List;
import java.util.Random;

public class WordCollections {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(WordCollections.class);
    private String filename = "dictionary.txt";
    private List<String> dictionary;
    private String randomWord;

    WordCollections() {
        initCollection();
    }

    private void initCollection() {
        try {
            dictionary = InputOutputGame.readFromResource(filename);
        } catch (IOException e) {
            log.warn("IOException in readOneLineFromFile, filename = {}", filename);
        }
    }

    public String getRandomWord() {
        Random randomIndex = new Random();
        randomWord = dictionary.get(randomIndex.nextInt(dictionary.size()));
        return randomWord;
    }

}

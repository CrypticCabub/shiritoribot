package edu.regent.shiritoribot.game;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public interface WordDictionary {
    public boolean contains(String word);

    public static WordDictionary of(String... wordList) {
        return new SimpleWordDictionaryImpl(wordList);
    }

    public static WordDictionary fromFile(File file) throws IOException {
        return fromStream(new FileInputStream(file));
    }

    public static WordDictionary fromStream(InputStream inputStream) throws IOException {
        Scanner scanner = new Scanner(inputStream);
        scanner.useDelimiter(Pattern.compile("[,\n]+"));
        List<String> wordList = new ArrayList<>();
        while(scanner.hasNext()) {
            wordList.add(scanner.next().trim());
        }
        return new SimpleWordDictionaryImpl(wordList);
    }
}

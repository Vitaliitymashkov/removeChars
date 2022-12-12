package edu.tvv.service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static edu.tvv.util.Constants.EMPTY;
import static edu.tvv.util.Constants.EXCEPT_ALLOWED_ALPHABETICAL_CHARS;
import static java.util.Objects.isNull;

public class Service {

    private final String inputString;
    public Service(String inputString) {
        this.inputString = inputString;
    }

    public String removeChars(String charsToRemove) {
        if (!isNull(this.inputString)) {
            Set<Character> charsToRemoveCollection = getCharactersToRemove(charsToRemove);
            List<Character> result = inputString.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
            result.removeIf(charsToRemoveCollection::contains);
            return result.toString();
        }
        return EMPTY;
    }

    private Set<Character> getCharactersToRemove(String charsToRemove) {
        String charsToRemoveCleared = charsToRemove.replaceAll(EXCEPT_ALLOWED_ALPHABETICAL_CHARS, EMPTY);

        Set<Character> mirrorStream = new HashSet<>();
        for (Character c:
             charsToRemoveCleared.toCharArray()) {
            if (c >= 97 && c <= 122) {
                mirrorStream.add((char) (c - 32));
            } else if (c >= 65 && c <= 90) {
                mirrorStream.add((char) (c + 32));
            }
        }
        Set<Character> directStream = charsToRemoveCleared.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        return Stream.concat(directStream.stream(), mirrorStream.stream()).collect(Collectors.toSet());
    }
}

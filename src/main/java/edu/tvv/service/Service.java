package edu.tvv.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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
        return charsToRemoveCleared.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());
    }
}

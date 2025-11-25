package com.example.elearning.utils;

import org.springframework.stereotype.Component;

@Component
public class IdGenerator {

    public String getNextId(String lastId, String prefix) {

        if (lastId == null || lastId.isEmpty()) {
            return prefix + "101";   // If no users exist yet
        }

        // remove prefix (e.g. "US") and extract number
        String numberPart = lastId.substring(prefix.length());  
        int number = Integer.parseInt(numberPart);

        // increment number
        return prefix + (number + 1);
    }
}

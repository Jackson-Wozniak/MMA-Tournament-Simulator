package internal.api.backend.utils;

import internal.api.backend.exception.NameGenerationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class NameUtils {

    private static final String FIRST_NAMES = "names/first_names.txt";
    private static final String LAST_NAMES = "src/main/resources/names/last_names.txt";

    public static List<String> generateNames(int nameCount){
        ClassLoader classLoader = NameUtils.class.getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(FIRST_NAMES)) {
            if(inputStream == null) throw new NameGenerationException("File doesn't exist");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            throw new NameGenerationException("Exception thrown while reading file");
        }
        return null;
    }

    public static boolean isUniqueName(String generatedName, List<String> existingNames){
        for(String name : existingNames){
            if(generatedName.equalsIgnoreCase(name)) return false;
        }
        return true;
    }
}

package internal.api.backend.utils;

import internal.api.backend.exception.NameGenerationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NameUtils {

    private static final Random random = new Random();
    private static final String FIRST_NAMES = "names/first_names.txt";
    private static final String LAST_NAMES = "names/last_names.txt";

    public static String generateName(){
        List<String> firstNames = readNames(FIRST_NAMES);
        List<String> lastNames = readNames(LAST_NAMES);
        String firstName = firstNames.get(random.nextInt(firstNames.size()));
        String lastName = lastNames.get(random.nextInt(lastNames.size()));
        return firstName + " " + lastName;
    }

    public static List<String> generateNames(int nameCount){
        List<String> generatedNames = new ArrayList<>();
        List<String> firstNames = readNames(FIRST_NAMES);
        List<String> lastNames = readNames(LAST_NAMES);
        for(int i = 0; i < nameCount; i++){
            //inner while-loop to ensure no infinite loop if no new names possible
            int iterations = 0;
            while(true){
                if(iterations > 1000) throw new NameGenerationException("No possible unique names");
                String firstName = firstNames.get(random.nextInt(firstNames.size()));
                String lastName = lastNames.get(random.nextInt(lastNames.size()));
                String name = firstName + " " + lastName;
                if(isUniqueName(name, generatedNames)){
                    generatedNames.add(firstName + " " + lastName);
                    break;
                }
                iterations++;
            }
        }
        return generatedNames;
    }

    private static List<String> readNames(String filename){
        List<String> names = new ArrayList<>();
        ClassLoader classLoader = NameUtils.class.getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(filename)) {
            if(inputStream == null) throw new NameGenerationException("File doesn't exist");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    names.add(line);
                }
            }
        } catch (Exception e) {
            throw new NameGenerationException("Exception thrown while reading file");
        }
        return names;
    }

    private static boolean isUniqueName(String generatedName, List<String> existingNames){
        for(String name : existingNames){
            if(generatedName.equalsIgnoreCase(name)) return false;
        }
        return true;
    }
}

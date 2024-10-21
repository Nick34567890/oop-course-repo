package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.enable(SerializationFeature.INDENT_OUTPUT); // Enable pretty-printing

        // Load input JSON file
        File inputFile = new File("C:\\Users\\My\\oop-course-repo\\lab-papers-please\\java-classifcation\\src\\main\\resources\\input.json");
        JsonNode data = mapper.readTree(inputFile).get("data");

        // Initialize universes
        Universe starWars = new Universe("starWars", new ArrayList<>());
        Universe hitchhikers = new Universe("hitchHiker", new ArrayList<>());
        Universe marvel = new Universe("marvel", new ArrayList<>());
        Universe rings = new Universe("rings", new ArrayList<>());

        // Iterate through each individual in the data
        for (JsonNode entry : data) {
            // Convert JsonNode to Individual object
            Individual individual = mapper.treeToValue(entry, Individual.class);

            // Classify based on the classification logic
            int classification = getClassification(individual);

            // Add the individual to the appropriate universe based on the classification
            switch (classification) {
                case 1:
                    starWars.getIndividuals().add(entry);
                    break;
                case 2:
                    marvel.getIndividuals().add(entry);
                    break;
                case 3:
                    hitchhikers.getIndividuals().add(entry);
                    break;
                case 4:
                    rings.getIndividuals().add(entry);
                    break;
                default:
                    System.out.println("Unspecified or unknown classification for individual: " + individual);
            }
        }

        // Save the classified universes into JSON files
        mapper.writeValue(new File("C:\\Users\\My\\oop-course-repo\\lab-papers-please\\java-classifcation\\src\\main\\resources\\output\\starwars.json"), starWars);
        mapper.writeValue(new File("C:\\Users\\My\\oop-course-repo\\lab-papers-please\\java-classifcation\\src\\main\\resources\\output\\hitchhiker.json"), hitchhikers);
        mapper.writeValue(new File("C:\\Users\\My\\oop-course-repo\\lab-papers-please\\java-classifcation\\src\\main\\resources\\output\\rings.json"), rings);
        mapper.writeValue(new File("C:\\Users\\My\\oop-course-repo\\lab-papers-please\\java-classifcation\\src\\main\\resources\\output\\marvel.json"), marvel);
    }


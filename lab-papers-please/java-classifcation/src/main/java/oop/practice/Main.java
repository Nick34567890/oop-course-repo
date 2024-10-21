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



    static class Universe {
        private String name;
        private List<JsonNode> individuals;

        public Universe(String name, List<JsonNode> individuals) {
            this.name = name;
            this.individuals = individuals;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("individuals")
        public List<JsonNode> getIndividuals() {
            return individuals;
        }
    }
}


class Individual {
    private String id;
    private String planet;
    private Integer age;
    private List<String> traits;
    private Boolean humanoidStatus; // Change this to Boolean

    // Getters and Setters
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("planet")
    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    @JsonProperty("age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @JsonProperty("traits")
    public List<String> getTraits() {
        return traits;
    }

    public void setTraits(List<String> traits) {
        this.traits = traits;
    }

    @JsonProperty("isHumanoid")
    public Boolean getHumanoidStatus() { // Change the return type to Boolean
        return humanoidStatus;
    }

    public void setHumanoidStatus(Boolean humanoidStatus) {
        this.humanoidStatus = humanoidStatus;
    }

    @Override
    public String toString() {
        return "Individual{" +
                "id='" + id + '\'' +
                ", planet='" + planet + '\'' +
                ", age=" + age +
                ", traits=" + traits +
                ", humanoidStatus=" + humanoidStatus +
                '}';
    }
}

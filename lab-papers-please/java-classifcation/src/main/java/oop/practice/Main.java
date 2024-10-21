// 1. Universe class, Alien/Creature class, Race class
// 2. Input class that will map the data from input json file to creatures
// 3. Classification logic, the class that will check eaach creature against each Race and attribute it to the right Universe instance
// 4. Output class, save the Universe details/creatures to each output file
package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    File inputFile = new File("src/main/resources/test-input.json");
    JsonNode data = mapper.readTree(inputFile).get("data");

    Universe starWars = new Universe("starWars", new ArrayList<>());
    Universe hitchhikers = new Universe("hitchHiker", new ArrayList<>());
    Universe marvel = new Universe("marvel", new ArrayList<>());
    Universe rings = new Universe("rings", new ArrayList<>());

    // Define races according to your classification rules
    Map<String, Race> races = new HashMap<>();
    races.put("Wookie", new Race("Wookie", false, "Kashyyyk", "0-400", List.of("HAIRY", "TALL")));
    races.put("Ewok", new Race("Ewok", false, "Endor", "0-60", List.of("SHORT", "HAIRY")));
    races.put("Asgardian", new Race("Asgardian", true, "Asgard", "0-5000", List.of("BLONDE", "TALL")));
    races.put("Betelgeusian",
        new Race("Betelgeusian", true, "Betelgeuse", "0-100", List.of("EXTRA_ARMS", "EXTRA_HEAD")));
    races.put("Vogons", new Race("Vogons", false, "Vogsphere", "0-200", List.of("GREEN", "BULKY")));
    races.put("Elf", new Race("Elf", true, "Earth", "indefinite", List.of("BLONDE", "POINTY_EARS")));
    races.put("Dwarf", new Race("Dwarf", true, "Earth", "0-200", List.of("SHORT", "BULKY")));

    Scanner scanner = new Scanner(System.in);

    for (JsonNode entry : data) {
      // Create Alien object from JsonNode and determine race based on conditions
      Race race = determineRace(entry, races);
      if (race != null) {
        Alien alien = new Alien(entry.get("id").asInt(), race);
        String entryAsString = alien.toString();
        System.out.println(entryAsString);
        String userInput = scanner.nextLine();
        switch (userInput) {
          case "1":
            starWars.individuals().add(alien);
            break;
          case "2":
            hitchhikers.individuals().add(alien);
            break;
          case "3":
            marvel.individuals().add(alien);
            break;
          case "4":
            rings.individuals().add(alien);
            break;
          default:
            System.out.println("Invalid input");
        }
      } else {
        System.out.println("No valid race found for entry: " + entry);
      }
    }

    scanner.close();
    // Write the output files
    mapper.writeValue(new File("src/main/resources/output/starwars.json"), starWars);
    mapper.writeValue(new File("src/main/resources/output/hitchhiker.json"), hitchhikers);
    mapper.writeValue(new File("src/main/resources/output/rings.json"), rings);
    mapper.writeValue(new File("src/main/resources/output/marvel.json"), marvel);
  }

  private static Race determineRace(JsonNode entry, Map<String, Race> races) {
    // Logic to determine race based on entry data
    boolean isHumanoid = entry.has("isHumanoid") && entry.get("isHumanoid").asBoolean();
    String planet = entry.has("planet") ? entry.get("planet").asText() : null;
    int age = entry.has("age") ? entry.get("age").asInt() : 0;

    // Check each race to find a match
    for (Race race : races.values()) {
      if (race.isHumanoid() == isHumanoid && race.getPlanet().equalsIgnoreCase(planet)) {
        // Additional age checks based on race classification
        if ((race.getName().equals("Wookie") && age >= 0 && age <= 400) ||
            (race.getName().equals("Ewok") && age >= 0 && age <= 60) ||
            (race.getName().equals("Asgardian") && age >= 0 && age <= 5000) ||
            (race.getName().equals("Betelgeusian") && age >= 0 && age <= 100) ||
            (race.getName().equals("Vogons") && age >= 0 && age <= 200) ||
            (race.getName().equals("Elf") && age >= 0) || // indefinite age
            (race.getName().equals("Dwarf") && age >= 0 && age <= 200)) {
          return race;
        }
      }
    }
    return null; // No valid race found
  }
}

record Universe(String name, List<Alien> individuals) {
}

class Alien {
  private int id;
  private Race race; // Reference to the Race class

  // Constructor
  public Alien(int id, Race race) {
    this.id = id;
    this.race = race;
  }

  // Getters
  public int getId() {
    return id;
  }

  public Race getRace() {
    return race;
  }

  @Override
  public String toString() {
    return "Alien{" +
        "id=" + id +
        ", race=" + race.getName() +
        ", isHumanoid=" + race.isHumanoid() +
        ", planet='" + race.getPlanet() + '\'' +
        ", ageRange='" + race.getAgeRange() + '\'' +
        ", traits=" + race.getTraits() +
        '}';
  }
}

class Race {
  private String name; // Name of the race (e.g., Wookie, Ewok, Asgardian, etc.)
  private boolean isHumanoid;
  private String planet;
  private String ageRange; // Use a String to represent the age range
  private List<String> traits;

  // Constructor
  public Race(String name, boolean isHumanoid, String planet, String ageRange, List<String> traits) {
    this.name = name;
    this.isHumanoid = isHumanoid;
    this.planet = planet;
    this.ageRange = ageRange;
    this.traits = traits != null ? traits : new ArrayList<>();
  }

  // Getters
  public String getName() {
    return name;
  }

  public boolean isHumanoid() {
    return isHumanoid;
  }

  public String getPlanet() {
    return planet;
  }

  public String getAgeRange() {
    return ageRange;
  }

  public List<String> getTraits() {
    return traits;
  }
}

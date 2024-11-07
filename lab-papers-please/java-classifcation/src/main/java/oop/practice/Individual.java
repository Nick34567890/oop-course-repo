package oop.practice;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

class Individual {
    private String id;
    private String planet;
    private Integer age;
    private List<String> traits;
    private Boolean humanoidStatus;

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

package com.json.tutorials;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/*@JsonInclude(JsonInclude.Include.NON_NULL)*///class level
public class Staff {

    private String name;
    private int age;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String[] position;              //  Array
    private List<String> skills;            //  List
    private Map<String, BigDecimal> salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getPosition() {
        return position;
    }

    public void setPosition(String[] position) {
        this.position = position;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public Map<String, BigDecimal> getSalary() {
        return salary;
    }

    public void setSalary(Map<String, BigDecimal> salary) {
        this.salary = salary;
    }

}

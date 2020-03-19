package com.company;

import com.company.compulsory.Hospital;
import com.company.compulsory.Resident;
import com.github.javafaker.Faker;

import java.lang.reflect.Array;
import java.util.*;

public class Problem {

    private List<Hospital> hospitals;
    private List<Resident> residents;
    private Map<Resident, List<Hospital>> residentList;
    private Map<Hospital, List<Resident>> hospitalList;

    Problem() {
        hospitals = new ArrayList<>();
        residents = new ArrayList<>();
        residentList = new HashMap<>();
        hospitalList = new HashMap<>();
    }

    public void init(int numberOfResidents, int numberOfHospitals) {
        Faker faker = new Faker();
        for (int i = 0; i < numberOfResidents; i++) {
            residents.add(new Resident(faker.name().firstName(), faker.name().lastName()));
        }

        for (int i = 0; i < numberOfHospitals; i++) {
            hospitals.add(new Hospital(faker.address().cityName(), numberOfResidents / numberOfHospitals));
        }

        hospitals.get(0).setCapacity(numberOfResidents / numberOfHospitals + numberOfResidents % numberOfHospitals);

        residents.forEach(
                resident -> {
                    List<Hospital> list = new ArrayList<>();
                    list.addAll(hospitals);
                    Collections.shuffle(list);
                    residentList.put(resident, list);
                }
        );

        hospitals.forEach(
                hospital -> {
                    List<Resident> list = new ArrayList<>();
                    list.addAll(residents);
                    Collections.shuffle(list);
                    hospitalList.put(hospital, list);
                }
        );

    }

    public void print() {
        System.out.println("\nGenerated hospitals :");
        hospitals.stream().parallel().forEach(System.out::println);
        System.out.println("\n\nGenerated residents :");
        residents.stream().parallel().forEach(System.out::println);
        System.out.println("\n\nGenerated preferences for residents:");
        for (Map.Entry entry : residentList.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println("\n\nGenerated preferences for hospitals");
        for (Map.Entry<Hospital, List<Resident>> entry : hospitalList.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println();
    }

    public List<Hospital> getHospitals() {
        return hospitals;
    }

    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }

    public List<Resident> getResidents() {
        return residents;
    }

    public void setResidents(List<Resident> residents) {
        this.residents = residents;
    }

    public Map<Resident, List<Hospital>> getResidentList() {
        return residentList;
    }

    public void setResidentList(Map<Resident, List<Hospital>> residentList) {
        this.residentList = residentList;
    }

    public Map<Hospital, List<Resident>> getHospitalList() {
        return hospitalList;
    }

    public void setHospitalList(Map<Hospital, List<Resident>> hospitalList) {
        this.hospitalList = hospitalList;
    }
}

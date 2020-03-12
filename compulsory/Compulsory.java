package com.company.compulsory;

import java.util.*;

public class Compulsory {

    public static void init(List<Resident> candidates, Set<Hospital> hospitals, Map<Resident, List<String>> residentPreferences, Map<Hospital, List<String>> hospitalPreferences) {
        candidates.add(new Resident("Resident0", "Vasilescu"));
        candidates.add(new Resident("Resident1", "Ionescu"));
        candidates.add(new Resident("Resident2", "Popescu"));
        candidates.add(new Resident("Resident3", "Iliescu"));

        hospitals.add(new Hospital("Hospital0", 1));
        hospitals.add(new Hospital("Hospital1", 2));
        hospitals.add(new Hospital("Hospital2", 2));

        residentPreferences.put(candidates.get(0), new ArrayList<String>() {{
            add("Hospital0");
            add("Hospital1");
            add("Hospital2");
        }});

        residentPreferences.put(candidates.get(1), new ArrayList<String>() {{
            add("Hospital0");
            add("Hospital1");
            add("Hospital2");
        }});

        residentPreferences.put(candidates.get(2), new ArrayList<String>() {{
            add("Hospital0");
            add("Hospital1");
        }});

        residentPreferences.put(candidates.get(3), new ArrayList<String>() {{
            add("Hospital0");
            add("Hospital2");
        }});

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        hospitalPreferences.put(
                hospitals.stream()
                        .filter(hospital -> {
                            return hospital.getName().compareTo("Hospital0") == 0;
                        })
                        .findFirst()
                        .get(),
                new ArrayList<String>() {{
                    add("Resident3");
                    add("Resident0");
                    add("Resident1");
                    add("Resident2");
                }});

        hospitalPreferences.put(
                hospitals.stream()
                        .filter(hospital -> {
                            return hospital.getName().compareTo("Hospital1") == 0;
                        })
                        .findFirst()
                        .get(),
                new ArrayList<String>() {{
                    add("Resident0");
                    add("Resident2");
                    add("Resident1");
                }});

        hospitalPreferences.put(
                hospitals.stream()
                        .filter(hospital -> {
                            return hospital.getName().compareTo("Hospital2") == 0;
                        })
                        .findFirst()
                        .get(),
                new ArrayList<String>() {{
                    add("Resident0");
                    add("Resident1");
                    add("Resident3");
                }});
    }

    public static void main(String[] args) {
        List<Resident> candidates = new ArrayList<Resident>();
        Set<Hospital> hospitals = new TreeSet<Hospital>();
        Map<Resident, List<String>> residentPreferences = new HashMap<>();
        Map<Hospital, List<String>> hospitalPreferences = new TreeMap<>();

        init(candidates, hospitals, residentPreferences, hospitalPreferences);

        //System.out.println(candidates.toString());
        //System.out.println(hospitals.toString());
        //System.out.println(residentPreferences);
        //System.out.println(hospitalPreferences);

        for (Map.Entry<Resident, List<String>> info : residentPreferences.entrySet()) {
            if (info.getValue().stream().parallel()
                    .filter(str -> {
                        return str.compareTo("Hospital0") == 0 || str.compareTo("Hospital2") == 0;
                    })
                    .count() > 0) {
                System.out.print(info.getKey().getName() + " " + info.getKey().getFamilyName() + " ");
            }
        }
        System.out.println();

        for (Map.Entry<Hospital, List<String>> info : hospitalPreferences.entrySet()) {
            if( info.getValue().get(0).compareTo("Resident0") == 0 ) {
                System.out.print(info.getKey().getName() + " ");
            }
        }
        System.out.println();
    }
}

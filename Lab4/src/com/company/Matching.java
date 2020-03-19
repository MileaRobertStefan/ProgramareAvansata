package com.company;

import com.company.compulsory.Hospital;
import com.company.compulsory.Resident;

import java.util.*;

public class Matching {
    private List<Hospital> hospitals;
    private List<Resident> residents;
    private Map<Resident, List<Hospital>> residentList;
    private Map<Hospital, List<Resident>> hospitalList;


    public Matching(Problem problem) {
        residents = problem.getResidents();
        hospitals = problem.getHospitals();
        residentList = problem.getResidentList();
        hospitalList = problem.getHospitalList();
    }

    public Map<Resident, Hospital> solve() {
        Map<Resident, Hospital> match = new HashMap<>();
        //https://en.wikipedia.org/wiki/Gale%E2%80%93Shapley_algorithm
        while (!match.keySet().containsAll(residents)) {
            for (Resident resident : residents) {
                if (!match.containsKey(resident)) {
                    List<Hospital> list = residentList.get(resident);
                    for (Hospital hospital : hospitals) {
                        if (hospital.getCapacity() > 0) {
                            hospital.setCapacity(hospital.getCapacity() - 1);
                            match.put(resident, hospital);
                            break;
                        } else {
                            List<Resident> preference = hospitalList.get(hospital);
                            int index = preference.indexOf(resident);
                            boolean stop = false;
                            for (int i = index + 1; i < preference.size(); i++) {
                                if (match.keySet().contains(preference.get(index)) && match.get(preference.get(index)).equals(hospital)) {
                                    match.remove(preference.get(index));
                                    match.put(resident, hospital);
                                    stop = true;
                                    break;
                                }
                            }
                            if (stop) {
                                break;
                            }
                        }
                    }
                }
            }
        }

        for (Map.Entry<Resident, Hospital> entry : match.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        return match;
    }


}


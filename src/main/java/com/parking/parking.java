package com.parking;

import java.util.ArrayList;
import java.util.EventListenerProxy;
import java.util.List;

public class parking {
    private int capacite;
    private List<Vehicule> vehiculesPresents;
    private List<Vehicule> vehiculesAutorises;

    public parking(int capacite) {
        this.capacite = capacite;
        this.vehiculesPresents = new ArrayList<>();
        this.vehiculesAutorises = new ArrayList<>();
    }

    public int getNbVehiculesAutorises() {
        return vehiculesAutorises.size();
    }

    public int getNbVehiculesPresents() {
        return vehiculesPresents.size();
    }

    public void ajouterVehiculeAutorise(Vehicule nouveau) {
        for (Vehicule v : vehiculesAutorises) {
            if (v.getImmatriculation().equals(nouveau.getImmatriculation())) {
                return;
            }
        }
        vehiculesAutorises.add(nouveau);
    }

    private boolean estDejaPresent(Vehicule vehicule) {
        for (Vehicule v : vehiculesPresents) {
            if (v.getImmatriculation().equals(vehicule.getImmatriculation())) {

                return true;
            }

        }
        return false;
    }

    public void EntreeVehicule(Vehicule nouveau) {
        if (estPlein()) {
            return;
        }
        if (estDejaPresent(nouveau)) {
            return;
        }
        for (Vehicule v : vehiculesAutorises) {

            if (v.getImmatriculation().equals(nouveau.getImmatriculation())) {
                vehiculesPresents.add(nouveau);
                return;
            }

        }

    }

    private boolean estPlein() {
        return vehiculesPresents.size() == capacite;
    }

    public void verifierMatricule(Vehicule nouveau) {
        for (Vehicule v : vehiculesPresents) {
            if (v.getImmatriculation().equals(nouveau.getImmatriculation())) {
                return;
            } else {
                vehiculesPresents.add(nouveau);
            }
        }
    }

    public void SortieVehicule(Vehicule vehicule) {
        boolean etaitPresent = vehiculesPresents.remove(vehicule);
        if (!etaitPresent) {
            // prévenir le proprio
        }
    }

    public Boolean verifierVehiculeDansParking(Vehicule nouveau) {
        Boolean res = false;
        for (Vehicule v : vehiculesPresents) {
            if (v.getImmatriculation().equals(nouveau.getImmatriculation())) {
                res = true;
            }
        }
        return res;
    }

    public void getVehiculePresents() {
        for (Vehicule v : vehiculesPresents) {
            System.out.println(v);
        }
    }

    public void getVehiculeAutorises() {
        for (Vehicule v : vehiculesAutorises) {
            System.out.println(v);
        }
    }

    public double getTaux() {
      int  nbVehiculesPresents=getNbVehiculesPresents();
        double taux = (double)nbVehiculesPresents / capacite* 100;
        return taux;
    }
}

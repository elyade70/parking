package com.parking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class parkingtest {

    @Test
    public void vehiculesAutorisesVide_ajouterVehiculeAutorise_VehiculeDansLaListe() {
        // Arranger

        parking parking = new parking(1);
        Vehicule nouveauVehicule = new Vehicule("DKR-221-EKIP");
        Vehicule nouveauVehicule1 = new Vehicule("DKR-21-EKIP");
        Vehicule nouveauVehicule2 = new Vehicule("DKR-221-EKIP");

        // Agir

        parking.ajouterVehiculeAutorise(nouveauVehicule);
        parking.ajouterVehiculeAutorise(nouveauVehicule1);
        parking.ajouterVehiculeAutorise(nouveauVehicule2);

        // ASSert
        assertEquals(2, parking.getNbVehiculesAutorises());

    }

    @Test
    public void vehiculesPresentsVide_enregistrerEntreeAutorisee_vehiculeDansLeParking() {
        // Arranger

        parking parking = new parking(1);
        Vehicule nouveauVehicule = new Vehicule("DKR-221-EKIP");

        parking.ajouterVehiculeAutorise(nouveauVehicule);
        // Agir

        parking.EntreeVehicule(nouveauVehicule);

        // ASSert
        assertEquals(1, parking.getNbVehiculesPresents());

    }

    @Test
    public void vehiculesPresentsVide_enregistrerEntreeNonAutorisee_vehiculeDansLeParking() {
        // Arranger

        parking parking = new parking(1);
        Vehicule nouveauVehicule = new Vehicule("DKR-221-EKIP");

        // Agir

        parking.EntreeVehicule(nouveauVehicule);

        // ASSert
        assertEquals(0, parking.getNbVehiculesPresents());

    }

    @Test
    public void ParkingPlein_enregistrerEntreeAutorisee_Refuse() {
        // Arranger

        parking parking = new parking(2);
        Vehicule nouveauVehicule = new Vehicule("DKR-221-EKIP");
        Vehicule nouveauVehicule1 = new Vehicule("DKR-22-EKIP");

        parking.ajouterVehiculeAutorise(nouveauVehicule);
        parking.ajouterVehiculeAutorise(nouveauVehicule1);

        parking.EntreeVehicule(nouveauVehicule1);
        parking.EntreeVehicule(nouveauVehicule1);
        // Agir

        parking.EntreeVehicule(nouveauVehicule);

        // ASSert
        assertEquals(2, parking.getNbVehiculesPresents());

    }

    @Test
    public void ParkingPlein_enregistrerSortieAutorisee_accepte() {
        // Arranger

        parking parking = new parking(1);
        Vehicule nouveauVehicule = new Vehicule("DKR-221-EKIP");

        parking.ajouterVehiculeAutorise(nouveauVehicule);

        parking.EntreeVehicule(nouveauVehicule);
        // Agir

        parking.SortieVehicule(nouveauVehicule);

        // ASSert
        assertEquals(0, parking.getNbVehiculesPresents());

    }

    @Test
    public void parkingPlein_verifierVehiculeDansParking_present() {
        // Arranger

        parking parking = new parking(2);
        Vehicule nouveauVehicule = new Vehicule("DKR-221-EKIP");
        Vehicule nouveauVehicule1 = new Vehicule("DKR-22-EKIP");
        parking.ajouterVehiculeAutorise(nouveauVehicule);
        parking.ajouterVehiculeAutorise(nouveauVehicule1);

        parking.EntreeVehicule(nouveauVehicule1);
        parking.EntreeVehicule(nouveauVehicule);
        // Agir

        parking.SortieVehicule(nouveauVehicule);
        parking.verifierVehiculeDansParking(nouveauVehicule);

        // ASSert
        assertEquals(true, parking.verifierVehiculeDansParking(nouveauVehicule1));

    }

    @Test
    public void deuxImmatriculationsIdentiques_enregistrerEntree_refuse() {
        // Arranger

        parking parking = new parking(2);
        Vehicule nouveauVehicule = new Vehicule("DKR-221-EKIP");
        Vehicule nouveauVehicule1 = new Vehicule("DKR-221-EKIP");
        parking.ajouterVehiculeAutorise(nouveauVehicule);
        parking.ajouterVehiculeAutorise(nouveauVehicule1);

        parking.EntreeVehicule(nouveauVehicule1);
        parking.EntreeVehicule(nouveauVehicule);
        // Agir

        parking.SortieVehicule(nouveauVehicule);

        // ASSert
        assertEquals(1, parking.getNbVehiculesPresents());

    }

    @Test
    public void vehiculeNonPresent_enregistrersortie_pasDansLeParking() {
        // Arranger

        parking parking = new parking(2);
        Vehicule nouveauVehicule = new Vehicule("DKR-221-EKIP");
        Vehicule nouveauVehicule1 = new Vehicule("DKR-221-EKIP");
        parking.ajouterVehiculeAutorise(nouveauVehicule);
        parking.ajouterVehiculeAutorise(nouveauVehicule1);

        parking.EntreeVehicule(nouveauVehicule);
        // Agir

        parking.SortieVehicule(nouveauVehicule1);

        // ASSert
        assertEquals(1, parking.getNbVehiculesPresents());

    }
    // @Test
    // public void parkingPlein_getvehiculespresentsDansLeParking_Tout() {
    // // Arranger

    // parking parking = new parking(2);
    // Vehicule nouveauVehicule = new Vehicule("DKR-221-EKIP");

    // parking.ajouterVehiculeAutorise(nouveauVehicule);

    // parking.EntreeVehicule(nouveauVehicule);

    // // Agir

    // parking.getVehiculePresents();

    // // ASSert
    // assertEquals(1, parking.getVehiculePresents());

    // }
    @Test
    public void parkingAMoitiePlein_getTaux_50() {
        // Arranger

        parking parking = new parking(2);
        Vehicule nouveauVehicule = new Vehicule("DKR-221-EKIP");
        Vehicule nouveauVehicule1 = new Vehicule("DKR-231-EKIP");

        parking.ajouterVehiculeAutorise(nouveauVehicule);
        parking.ajouterVehiculeAutorise(nouveauVehicule1);

        parking.EntreeVehicule(nouveauVehicule);
        parking.EntreeVehicule(nouveauVehicule1);

        // Agir

        parking.SortieVehicule(nouveauVehicule1);
        
        double taux = parking.getTaux();

        // ASSert
        assertEquals(50.0, taux);

    }
    @Test
    public void parkingVide_getTaux_50() {
        // Arranger

        parking parking = new parking(2);
  


        // Agir

   
        
        double taux = parking.getTaux();

        // ASSert
        assertEquals(0.0, taux);

    }
}
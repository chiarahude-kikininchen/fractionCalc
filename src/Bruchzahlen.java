/* Titel:   Bruchzahlen
   Name:    Chiara Hude
            1a APC, A
   Datum:   24.05.2025
*/

import java.lang.Math;

public class Bruchzahlen {
    private int zaehler;
    private int nenner;

    // Konstruktor
    public Bruchzahlen(int pZaehler, int pNenner) {

        // Fehlermeldung
        if (pNenner == 0) {
            throw new IllegalArgumentException("Nenner darf nicht gleich 0 sein.");
        }

        zaehler = pZaehler;
        nenner = pNenner;;
        //kuerzen();
    }

    // Aktueller Wert der Variablen
    public int getZaehler() {
        return zaehler;
    }
    public int getNenner() {
        return nenner;
    }

    // Methoden, Operatoren
    // Multiplizieren
    public Bruchzahlen mul(Bruchzahlen zweiterBruch) {
        int ergebnisZaehler = zaehler * zweiterBruch.getZaehler();
        int ergebnisNenner = nenner * zweiterBruch.getNenner();
        return new Bruchzahlen(ergebnisZaehler, ergebnisNenner);
    }

    // Dividieren
    public Bruchzahlen div(Bruchzahlen zweiterBruch) {
        int ergebnisZaehler = zaehler * zweiterBruch.getNenner();
        int ergebnisNenner = nenner * zweiterBruch.getZaehler();
        return new Bruchzahlen(ergebnisZaehler, ergebnisNenner);
    }

    // Addieren
    public Bruchzahlen add(Bruchzahlen zweiterBruch) {
        int ergebnisNenner = kgv(nenner, zweiterBruch.getNenner());
        int ergebnisZaehler = zaehler * ergebnisNenner / nenner + zweiterBruch.getZaehler() * ergebnisNenner / zweiterBruch.getNenner();
        return new Bruchzahlen(ergebnisZaehler, ergebnisNenner);
    }

    // Subtrahieren
    public Bruchzahlen sub(Bruchzahlen zweiterBruch) {
        int ergebnisNenner = kgv(nenner, zweiterBruch.getNenner());
        int ergebnisZaehler = zaehler * ergebnisNenner / nenner - zweiterBruch.getZaehler() * ergebnisNenner / zweiterBruch.getNenner();
        return new Bruchzahlen(ergebnisZaehler, ergebnisNenner);
    }

    // Kleinstes gemeinsames Vielfaches
    public static int kgv(int a, int b) {

        int i = 1;
        while (i % a != 0 || i % b != 0) {
            i++;
        }

        return i;

    }

//

   // Grösster gemeinsamer Teiler
   public static int calcGGT(int a, int b) {
       if (a == b) {
           return a;
       }
       else if (a > b) {
           int temp = 1;
           for (int i = 1; i <= a; i++) {
               if (a%i == 0 && b%i ==0) {
                   temp = i;
               }
           }
           return temp;
       } else {
           int temp = 1;
           for (int i = 1; i <= b; i++) {
               if (a%i == 0 && b%i ==0) {
                   temp = i;
               }
           }
           return temp;
       }
    }

    // Kuerzen
    public void kuerzen() {
        int ggt = calcGGT(zaehler, nenner);
            zaehler = zaehler / ggt;
            nenner = nenner / ggt;

    }

    @Override
    public String toString() {

        if (nenner == 1) {
            return zaehler + "";
        }

        else if (zaehler == 0) {
            return zaehler + "";
        }

        else {
            return zaehler + "/" + nenner;
        }
    }
}

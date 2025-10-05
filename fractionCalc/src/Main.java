/* Titel:   Bruchrechner
   Name:    Chiara Hude
            1a APC, A
   Datum:   24.05.2025
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner bruchEinlesen = new Scanner(System.in);

        while (true) {

            int zaehler;
            int nenner;

            System.out.println("Erster Bruch: ");
            System.out.print("Zaehler: ");
            zaehler = bruchEinlesen.nextInt();
            System.out.print("Nenner: ");
            nenner = bruchEinlesen.nextInt();
            Bruchzahlen ErsterBruch = new Bruchzahlen(zaehler,nenner);

            Scanner myInput = new Scanner(System.in);
            System.out.print("Bitte gib einen Operator (+, -, *, /) ein: ");
            char rechenoperationen = myInput.next().toCharArray()[0];

            System.out.println("Zweiter Bruch: ");
            System.out.print("Zaehler: ");
            zaehler = bruchEinlesen.nextInt();
            System.out.print("Nenner: ");
            nenner = bruchEinlesen.nextInt();
            Bruchzahlen ZweiterBruch = new Bruchzahlen(zaehler, nenner);

            Bruchzahlen ergebnis = null;

            switch (rechenoperationen) {
                case '+':
                    ergebnis = ErsterBruch.add(ZweiterBruch);
                    break;

                case '-':
                    ergebnis = ErsterBruch.sub(ZweiterBruch);
                    break;

                case '*':
                    ergebnis = ErsterBruch.mul(ZweiterBruch);
                    break;

                case '/':
                    ergebnis = ErsterBruch.div(ZweiterBruch);
                    break;

                default:
                    System.out.println("Ungueltiger Operator!");
            }

            System.out.println("Ergebnis: " + ergebnis);
        }
    }
}

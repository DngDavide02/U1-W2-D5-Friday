package davidedangelo;

import entities.*;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        CollezioneGiochi collezione = new CollezioneGiochi();

        //VIDEOGIOCHI
        Videogiochi gioco1 = new Videogiochi(
                1,
                "Hollow Knigt",
                2017,
                24.99,
                "PS5",
                30,
                Generi.METROIDVANIA
        );
        Videogiochi gioco2 = new Videogiochi(
                2,
                "Dark Souls 3",
                2016,
                49.99,
                "PS5",
                60,
                Generi.SOULSLIKE
        );
        Videogiochi gioco3 = new Videogiochi(
                3,
                "Skyrim",
                2011,
                49.99,
                "PC",
                80,
                Generi.GDR
        );
        Videogiochi gioco4 = new Videogiochi(
                4,
                "Call Of Duty Black Ops 2",
                2012,
                49.99,
                "PS3",
                10,
                Generi.FPS
        );
        Videogiochi gioco5 = new Videogiochi(
                5,
                "Omori",
                2020,
                24.99,
                "PC",
                20,
                Generi.HORROR
        );
        Videogiochi gioco6 = new Videogiochi(
                6,
                "Limbo",
                2010,
                24.99,
                "PC",
                20,
                Generi.PUZZLE
        );

        //GIOCHI DA TAVOLO
        GiochiDaTavolo tavolo1 = new GiochiDaTavolo(
                7,
                "Monopoly",
                1935,
                25.0,
                6,
                120
        );
        GiochiDaTavolo tavolo2 = new GiochiDaTavolo(
                8,
                "Dungeons & Dragons",
                1974,
                50.0,
                5,
                240
        );

        collezione.aggiungiGioco(gioco1);
        collezione.aggiungiGioco(gioco2);
        collezione.aggiungiGioco(gioco3);
        collezione.aggiungiGioco(gioco4);
        collezione.aggiungiGioco(gioco5);
        collezione.aggiungiGioco(gioco6);

        collezione.aggiungiGioco(tavolo1);
        collezione.aggiungiGioco(tavolo2);

        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Aggiungi gioco");
            System.out.println("2. Cerca per ID");
            System.out.println("3. Cerca per prezzo");
            System.out.println("4. Cerca giochi da tavolo per numero giocatori");
            System.out.println("5. Rimuovi gioco per ID");
            System.out.println("6. Aggiorna gioco per ID");
            System.out.println("7. Statistiche");
            System.out.println("8. Stampa tutti i giochi");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            System.out.println();

            try {
                int scelta = scanner.nextInt();
                scanner.nextLine();

                switch (scelta) {
                    case 1 -> {
                        System.out.print("ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Titolo: ");
                        String titolo = scanner.nextLine();
                        System.out.print("Anno: ");
                        int anno = scanner.nextInt();
                        System.out.print("Prezzo: ");
                        double prezzo = scanner.nextDouble();

                        System.out.print("tipo: 1-videogioco | 2-gioco da tavolo: ");
                        int tipo = scanner.nextInt();
                        scanner.nextLine();

                        if (tipo == 1) {
                            System.out.print("Piattaforma: ");
                            String piattaforma = scanner.nextLine();
                            System.out.print("Durata: ");
                            int durata = scanner.nextInt();
                            System.out.println("Scegli il genere:");
                            System.out.println("1 - METRIDVANIA");
                            System.out.println("2 - SOULSLIKE");
                            System.out.println("3 - GDR");
                            System.out.println("4 - FPS");
                            System.out.println("5 - HORROR");
                            System.out.println("6 - PUZZLE");
                            int sceltaGenere = scanner.nextInt();

                            Generi genere = switch (sceltaGenere) {
                                case 1 -> Generi.METROIDVANIA;
                                case 2 -> Generi.SOULSLIKE;
                                case 3 -> Generi.GDR;
                                case 4 -> Generi.FPS;
                                case 5 -> Generi.HORROR;
                                case 6 -> Generi.PUZZLE;
                                default -> throw new IllegalArgumentException("Genere non valido");
                            };
                            collezione.aggiungiGioco(new Videogiochi(id, titolo, anno, prezzo, piattaforma, durata, genere));
                        } else if (tipo == 2) {
                            System.out.print("Numero giocatori: ");
                            int numeroGiocatori = scanner.nextInt();
                            System.out.print("Durata: ");
                            int durata = scanner.nextInt();

                            collezione.aggiungiGioco(new GiochiDaTavolo(id, titolo, anno, prezzo, numeroGiocatori, durata));
                        } else {
                            System.out.println("Tipo non valido");
                        }
                        System.out.println("Gioco Aggiunto");
                    }//CASE1

                    case 2 -> {
                        System.out.print("ID da cercare: ");
                        int id = scanner.nextInt();
                        var risultato = collezione.cercaID(id);
                        if (risultato.isPresent()) {
                            System.out.println(risultato.get());
                        } else {
                            System.out.println("Gioco non trovato");
                        }
                    }//CASE2

                    case 3 -> {
                        System.out.print("Inserisci il prezzo massimo dei giochi che vuoi cercare: ");
                        double prezzo = scanner.nextDouble();
                        collezione.cercaPrezzo(prezzo).forEach(System.out::println);
                    }//CASE3

                    case 4 -> {
                        System.out.print("Inserisci il numero di giocatori per la ricerca: ");
                        int numGiocatori = scanner.nextInt();
                        collezione.cercaGiocatori(numGiocatori).forEach(System.out::println);
                    }//CASE4

                    case 5 -> {
                        System.out.print("ID da rimuovere: ");
                        int id = scanner.nextInt();
                        if (collezione.rimuoviGioco(id)){
                            System.out.println("Gioco rimosso");
                        }else {
                            System.out.println("ID non trovato");
                        }
                    }//CASE5

                    case 6 -> {
                        System.out.print("ID da aggiornare: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Titolo: ");
                        String titolo = scanner.nextLine();
                        System.out.print("Anno: ");
                        int anno = scanner.nextInt();
                        System.out.print("Prezzo: ");
                        double prezzo = scanner.nextDouble();

                        System.out.print("tipo: 1-videogioco | 2-gioco da tavolo: ");
                        int tipo = scanner.nextInt();
                        scanner.nextLine();

                        Giochi nuovoGioco;

                        if (tipo == 1) {
                            System.out.print("Piattaforma: ");
                            String piattaforma = scanner.nextLine();
                            System.out.print("Durata: ");
                            int durata = scanner.nextInt();
                            System.out.println("Scegli il genere:");
                            System.out.println("1 - METROIDVANIA");
                            System.out.println("2 - SOULSLIKE");
                            System.out.println("3 - GDR");
                            System.out.println("4 - FPS");
                            System.out.println("5 - HORROR");
                            System.out.println("6 - PUZZLE");
                            int sceltaGenere = scanner.nextInt();

                            Generi genere = switch (sceltaGenere) {
                                case 1 -> Generi.METROIDVANIA;
                                case 2 -> Generi.SOULSLIKE;
                                case 3 -> Generi.GDR;
                                case 4 -> Generi.FPS;
                                case 5 -> Generi.HORROR;
                                case 6 -> Generi.PUZZLE;
                                default -> throw new IllegalArgumentException("Genere non valido");
                            };

                            nuovoGioco = new Videogiochi(id, titolo, anno, prezzo, piattaforma, durata, genere);
                    } else if (tipo == 2) {
                            System.out.print("Numero giocatori: ");
                            int numeroGiocatori = scanner.nextInt();
                            System.out.print("Durata: ");
                            int durata = scanner.nextInt();

                            nuovoGioco = new GiochiDaTavolo(id, titolo, anno, prezzo, numeroGiocatori, durata);
                        } else {
                            System.out.println("Tipo non valido");
                            break;
                        }

                        if (collezione.aggiornaGioco(id, nuovoGioco)) {
                            System.out.println("Gioco aggiornato");
                        }else {
                            System.out.println("ID del gioco non trovato");
                        }
                    }//CASE6

                    case 7 -> collezione.statistiche();
                    case 8 -> collezione.stampaTutti();
                    case 0 -> {
                        System.out.println("Uscita");
                        run = false;
                    }
                    default -> System.out.println("scelta non valida, riprova");
                    }//END SWITCH
            } catch (InputMismatchException e) {
                System.out.println("Input non valido. Riprova.");
                scanner.nextLine();
            }catch (IllegalArgumentException | NoSuchElementException e) {
                System.out.println("Errore: " + e.getMessage());
            }
        }
    }
}
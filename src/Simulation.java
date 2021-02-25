import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    // Dlugosc pliku
    private int fileLength;

    public Simulation() {

    }

    /*
     * Method loads all items from a text file and returns an ArrayList of Items.
     * @param fileName1 fileName2 - name of the first and second file
     * @return itemArrayList - array of items read from both files
     * */
    public ArrayList loadItems(String fileName1) {

        try {
            ArrayList<Item> read;
            read = readFile(fileName1);
            Item bb = read.get(7);
            return read;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
          return null;
    }

    /*
    /  Metoda odczytuje plik i kopiuje napotkane elementy do tablicy.
    */
    public ArrayList readFile(String fileName) throws FileNotFoundException {

        ArrayList<Item> itemArrayList = new ArrayList<Item>();

// Plik nr 1,2
        File file = new File(fileName);
        Scanner fileScanner = new Scanner(file);
// Ustala dlugosc pliku
        fileLength = 0;
        while (fileScanner.hasNextLine()) {
            fileLength++;
            String line = fileScanner.nextLine();
        }

// Odczytuje plik i kopiuje dane do tablicy
        File fileRead = new File(fileName);
        Scanner fileScanner2 = new Scanner(fileRead);

        for (int i = 0; i < fileLength; i++) {

            String line = fileScanner2.nextLine();
            int position = line.indexOf('=');
            String itemName = line.substring(0, position);
            String itemWeight = line.substring(position + 1, line.length());

            int itemWeightInt;
            try {
                itemWeightInt = (Integer.parseInt(itemWeight))/1000;
            } catch (NumberFormatException e) {
                itemWeightInt = 0;
            }

            Item item = new Item(itemName, itemWeightInt);
            itemArrayList.add(item);
        }

        return itemArrayList;
    }


    /**
     * Method method takes the ArrayList of Items returned from loadItems and starts creating U1 rockets.
     * It first tries to fill up 1 rocket with as many items as possible before creating a new rocket object and filling
     * that one until all items are loaded. The method then returns the ArrayList of those U1 rockets that are fully loaded.
     *
     * @param -
     * @return - true = success, false = explosion
     */
    public ArrayList loadU1(ArrayList<Item> arrayItems) {
        ArrayList<U1> u1ArrayList = new ArrayList();
        // Petla dla kolejnych itemow
        for (int i = 0; i < arrayItems.size(); i++) {
            if (i == 0) {
                // Stworz pierwsza rakiete U1 i dodaj do listy
                U1 u1 = new U1();
                u1ArrayList.add(u1);
            }

            // Czy ostatnia w tablicy rakieta jest w pelni zaladowana
            int size = u1ArrayList.size();
            // Wydobadz rakiete z konca tablicy czyli ostatnia
            U1 u1Rocket = u1ArrayList.get(size-1);

            if (u1Rocket.getMaxCargoWeight() == 0) {
                // Tak, utworz nowa rakiete
                U1 u1 = new U1();
                u1ArrayList.add(u1);
                // Zmniejsz licznik itemow zeby powrocic do tego samego itemu w nastepnej petli
                i--;
                // Tutaj jest obsluga ladowania itemu do rakiety i dzielenia itemu na dwa
            } else {
                // Pobierz item
                Item item = arrayItems.get(i);
                // czy waga jest <= niz masa dla towaru w rakiecie
                if (item.getWeight() <= u1Rocket.getMaxCargoWeight()) {
                    // Tak, Oblicz ile miejsca zostanie w rakiecie po zaladowaniu
                    int roznicaMasy = u1Rocket.getMaxCargoWeight() - item.getWeight();
                    // Usun rakiete z tablicy
                    u1ArrayList.remove(size - 1);
                    // Uaktualnij wage cargo w rakiecie
                    u1Rocket.setMaxCargoWeight(roznicaMasy);
                    // Zapisz rakiete do tablicy
                    u1ArrayList.add(u1Rocket);
                } else {
                    // Waga itemu jest wieksza niz ilosc miejsca w rakiecie, trzeba podzielic go na dwa itemy
                    // Oblicz o ile item jest za ciezki
                    int roznicaMasy = item.getWeight() - u1Rocket.getMaxCargoWeight();
                    // Usun rakiete z tablicy
                    u1ArrayList.remove(size - 1);
                    // Zapelnij miejsce w rakiecie
                    u1Rocket.setMaxCargoWeight(0);
                    // Zapisz rakiete do tablicy
                    u1ArrayList.add(u1Rocket);
                    // Zaktualizuj wage itemu - teraz wazy tyle ile niezaladowana czesc
                    item.setWeight(roznicaMasy);
                    // Zapisz item do tablicy w to samo miejsce
                    arrayItems.add(i, item);
                }
            }
        }
        return u1ArrayList;
    }


    /**
     * Method method takes the ArrayList of Items returned from loadItems and starts creating U1 rockets.
     * It first tries to fill up 1 rocket with as many items as possible before creating a new rocket object and filling
     * that one until all items are loaded. The method then returns the ArrayList of those U1 rockets that are fully loaded.
     *
     * @param - arrayItems
     * @return - true = success, false = explosion
     */
    public ArrayList loadU2(ArrayList<Item> arrayItems) {
        ArrayList<U2> u2ArrayList = new ArrayList();
        // Petla dla kolejnych itemow
        for (int i = 0; i < arrayItems.size(); i++) {
            if (i == 0) {
                // Stworz pierwsza rakiete U2 i dodaj do listy
                U2 u2 = new U2();
                u2ArrayList.add(u2);
            }
            // Czy ostatnia w tablicy rakieta jest w pelni zaladowana
            int size = u2ArrayList.size();
            // Wydobadz rakiete z konca tablicy czyli ostatnia
            U2 u2Rocket = u2ArrayList.get(size-1);

            if (u2Rocket.getMaxCargoWeight() == 0) {
                // Tak, utworz nowa rakiete
                U2 u2 = new U2();
                u2ArrayList.add(u2);
                // Zmniejsz licznik itemow zeby powrocic do tego samego itemu w nastepnej petli
                i--;
                // Tutaj jest obsluga ladowania itemu do rakiety i dzielenia itemu na dwa
            } else {
                // Pobierz item
                Item item = arrayItems.get(i);
                // czy waga jest <= niz masa dla towaru w rakiecie
                if (item.getWeight() <= u2Rocket.getMaxCargoWeight()) {
                    // Tak, Oblicz ile miejsca zostanie w rakiecie po zaladowaniu
                    int roznicaMasy = u2Rocket.getMaxCargoWeight() - item.getWeight();
                    // Usun rakiete z tablicy
                    u2ArrayList.remove(size - 1);
                    // Uaktualnij wage cargo w rakiecie
                    u2Rocket.setMaxCargoWeight(roznicaMasy);
                    // Zapisz rakiete do tablicy
                    u2ArrayList.add(u2Rocket);
                } else {
                    // Waga itemu jest wieksza niz ilosc miejsca w rakiecie, trzeba podzielic go na dwa itemy
                    // Oblicz o ile item jest za ciezki
                    int roznicaMasy = item.getWeight() - u2Rocket.getMaxCargoWeight();
                    // Usun rakiete z tablicy
                    u2ArrayList.remove(size - 1);
                    // Zapelnij miejsce w rakiecie
                    u2Rocket.setMaxCargoWeight(0);
                    // Zapisz rakiete do tablicy
                    u2ArrayList.add(u2Rocket);
                    // Zaktualizuj wage itemu - teraz wazy tyle ile niezaladowana czesc
                    item.setWeight(roznicaMasy);
                    // Zapisz item do tablicy w to samo miejsce
                    arrayItems.add(i, item);
                }
            }
        }

        return u2ArrayList;
    }

    /**
     * method takes an ArrayList of Rockets and calls launch and land methods for each of the rockets in the ArrayList.
     * Every time a rocket explodes or crashes (i.e if launch or land return false) it will have to send that rocket again.
     * All while keeping track of the total budget required to send each rocket safely to Mars. runSimulation then returns
     * the total budget required to send all rockets (including the crashed ones).
     *
     * @param loadedU1
     * @return budget
     */
    public int[] runSimulationU1(ArrayList<U1> loadedU1) {
        int[] phaseOneResult = new int[3];
        int budget = 0;
        int success = 0;
        int fail = 0;

        for (int i = 0; i < loadedU1.size();i++) {
            if (loadedU1.get(i).launch() && loadedU1.get(i).land()) {
                budget = budget + loadedU1.get(i).getCost();
                success++;
            } else {
                budget = budget + loadedU1.get(i).getCost();
                i--;
                fail++;
            }
        }

        phaseOneResult[0] = success;
        phaseOneResult[1] = fail;
        phaseOneResult[2] = budget;

        return phaseOneResult;
    }

    /**
     * method takes an ArrayList of Rockets and calls launch and land methods for each of the rockets in the ArrayList.
     * Every time a rocket explodes or crashes (i.e if launch or land return false) it will have to send that rocket again.
     * All while keeping track of the total budget required to send each rocket safely to Mars. runSimulation then returns
     * the total budget required to send all rockets (including the crashed ones).
     *
     * @param loadedU2
     * @return budget
     */
    public int[] runSimulationU2(ArrayList<U2> loadedU2) {
        int[] phaseOneResult = new int[3];
        int budget = 0;
        int success = 0;
        int fail = 0;

        for (int i = 0; i < loadedU2.size();i++) {
            if (loadedU2.get(i).launch() && loadedU2.get(i).land()) {
                budget = budget + loadedU2.get(i).getCost();
                success++;
            } else {
                budget = budget + loadedU2.get(i).getCost();
                i--;
                fail++;
            }
        }

        phaseOneResult[0] = success;
        phaseOneResult[1] = fail;
        phaseOneResult[2] = budget;

        return phaseOneResult;
    }
}
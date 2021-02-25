import java.util.ArrayList;

public class SpaceChallenge {

    private String[] summary = new String[10];



    public static void main (String [] args) {

        SpaceChallenge spaceChallenge = new SpaceChallenge();

        Simulation simulation = new Simulation();


        System.out.println("Space Challenge - cost simulator");
        System.out.println("");

// U1 Phase 1
        System.out.println("Rocket U1 - Phase 1:");
        System.out.println("--------------------");
        ArrayList<Item> arrayItems;
        arrayItems = simulation.loadItems("phase-1.txt");

        ArrayList<U1> loadedU1;

        loadedU1 = simulation.loadU1(arrayItems);

        int[] summaryPhaseOne = new int[2];
        summaryPhaseOne = simulation.runSimulationU1(loadedU1);

        System.out.println("      Success number: " + summaryPhaseOne[0]);
        System.out.println("         Fail number: " + summaryPhaseOne[1]);
        System.out.println("Number of U1 rockets: " + (summaryPhaseOne[0] + summaryPhaseOne[1]));
        System.out.println("        Phase 1 cost: " + summaryPhaseOne[2] + " mln $");
        System.out.println("");
        int u1Phase1cost = summaryPhaseOne[2];

// U1 Phase 2
        System.out.println("Rocket U1 - Phase 2:");
        System.out.println("--------------------");
        arrayItems = simulation.loadItems("phase-2.txt");
        loadedU1 = simulation.loadU1(arrayItems);

        int[] summaryPhaseTwo = new int[2];
        summaryPhaseTwo = simulation.runSimulationU1(loadedU1);

        System.out.println("      Success number: " + summaryPhaseTwo[0]);
        System.out.println("         Fail number: " + summaryPhaseTwo[1]);
        System.out.println("Number of U1 rockets: " + (summaryPhaseTwo[0] + summaryPhaseTwo[1]));
        System.out.println("        Phase 2 cost: " + summaryPhaseTwo[2] + " mln $");
        System.out.println("");
        System.out.println("Total cost of Phase 1 + Phase 2 = : " + (summaryPhaseTwo[2] + u1Phase1cost) + " mln $");
        System.out.println("----------------------------------------------------------------------------------");







// U2 Phase 1
        System.out.println("Rocket U2 - Phase 1:");
        System.out.println("--------------------");

        arrayItems = simulation.loadItems("phase-1.txt");

        ArrayList<U2> loadedU2;

        loadedU2 = simulation.loadU2(arrayItems);

        //int[] summaryPhaseOne;// = new int[2];
        summaryPhaseOne = simulation.runSimulationU2(loadedU2);

        System.out.println("      Success number: " + summaryPhaseOne[0]);
        System.out.println("         Fail number: " + summaryPhaseOne[1]);
        System.out.println("Number of U2 rockets: " + (summaryPhaseOne[0] + summaryPhaseTwo[1]));
        System.out.println("        Phase 1 cost: " + summaryPhaseOne[2] + " mln $");
        System.out.println("");
        int u2Phase1cost = summaryPhaseOne[2];

// U2 Phase 2
        System.out.println("Rocket U2 - Phase 2:");
        System.out.println("--------------------");
        arrayItems = simulation.loadItems("phase-2.txt");
        loadedU2 = simulation.loadU2(arrayItems);

        //int[] summaryPhaseTwo = new int[2];
        summaryPhaseTwo = simulation.runSimulationU2(loadedU2);

        System.out.println("      Success number: " + summaryPhaseTwo[0]);
        System.out.println("         Fail number: " + summaryPhaseTwo[1]);
        System.out.println("Number of U2 rockets: " + (summaryPhaseTwo[0] + summaryPhaseTwo[1]));
        System.out.println("        Phase 2 cost: " + summaryPhaseTwo[2] + " mln $");
        System.out.println("");
        System.out.println("Total cost of Phase 1 + Phase 2 = : " + (summaryPhaseTwo[2] + u2Phase1cost) + " mln $");
        System.out.println("----------------------------------------------------------------------------------");

        System.out.println("");
        System.out.println("End.");


    }



    public void setSummary(String text, int number) {
        summary[number] = text;
    }


}

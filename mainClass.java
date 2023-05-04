
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class mainClass {

    public static final String version ="0.1b";
    public static final String author ="Manuel B.";



    public static void main(String[] args){
        System.out.println("PHRASAL VERBS TRAINER version: " + version + " coded by: " + author + "\n\n");
        dataParser phrasalsObj = new dataParser();
        mainClass app = new mainClass();
        app.selectTheRight(phrasalsObj);
    }

    //Game mode. Prints a incomplete phrase and select the right verb between several options
    public void selectTheRight(dataParser phrasals){
        System.out.println("GAMEMODE : WRITE THE RIGHT OPTION\n");
        while(true) {
            String[] right = phrasals.getRandom();
            String[] options = {right[0], phrasals.getRandom()[0], phrasals.getRandom()[0], phrasals.getRandom()[0], phrasals.getRandom()[0]};
            int[] indexes = this.shuffleIndexes(options.length);
            //System.out.println("answer: " + right[0]);
            System.out.println( right[2].toLowerCase().replace(right[0].trim().toLowerCase(), " ____ ") + " / " + right[3]);
            System.out.print("OPCIONES:  ");

            for (int i = 0; i < indexes.length; i++) {
                System.out.print(options[indexes[i]] + "  ");
            }
            System.out.print("\n");
            System.out.print("Respuesta: ");
            Scanner scanObj = new Scanner(System.in);
            String userAnswer = scanObj.nextLine();

            if (userAnswer.toLowerCase().trim().equals(right[0].toLowerCase().trim())) {
                System.out.println("CORRECTO!! " + right[0] + right[1] + " : " + right[2] + " / " + right[3]);
            } else {
                System.out.println("Incorrecto, la respuesta es: " + right[0]);
                System.out.println(right[0] + "-" + right[1] + " : " + right[2] + " / " + right[3]);
            }
            System.out.println("\n");
        }
    }

    //Helper to get randomized indexes
    public int[] shuffleIndexes(int n) {

        Integer[] intArray = new Integer[n];

        for(int i=0 ; i < n ; i++){
            intArray[i] = i;
        }

        List<Integer> intList = Arrays.asList(intArray);
        Collections.shuffle(intList);
        Object[] indexes = intList.toArray();
        int[] retArr = new int[indexes.length];

        for (int i=0 ; i < indexes.length ; i++){
            retArr[i] = (int)(indexes[i]);
        }

        return retArr;
    }

}

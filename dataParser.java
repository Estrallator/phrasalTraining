import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class dataParser {

    //phrasal verbs array. Contains data in 4 indexes 0-verb 1-translation 2-example 3-translated example
    public ArrayList<ArrayList<String>> phrasalVerbs = new ArrayList<>(4);

    //Parser constructor initializes the 4 dimensions of phrasalVerbs array, parses and stores adds to array the data contained in data.txt
    public dataParser(){

        String[] dataArr;

        for(int i=0; i <=3; i++) {
            phrasalVerbs.add(new ArrayList());
        }

        try {
            File myObj = new File("data.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                dataArr=data.split("/");
                //If the line parsed does not contain 4 indexes, data is wrong so we skip line
                if(dataArr.length == 4){
                    for(int n=0; n<=3 ; n++){
                        phrasalVerbs.get(n).add(dataArr[n]);
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        String out = new String();

        try {
            File myObj = new File("data.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                out += myReader.nextLine();
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return out;
    }

    //Returns a random phrasal verb data array
    public String[] getRandom(){
        int index = 0;
        int length = phrasalVerbs.get(0).size();
        String[] verbData = new String[4];
        index = (int)(Math.random()*length);

        for(int i=0 ; i<=3 ; i++){
            verbData[i] = phrasalVerbs.get(i).get(index);
        }

        return verbData;
    }
}

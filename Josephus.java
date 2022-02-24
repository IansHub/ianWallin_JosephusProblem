import java.util.Arrays;
import java.util.Scanner;

public class Josephus {
    public static void main(String[] args) {
        int arrayNum, startNum, skipNum;
        int index=0, skipCounter=0;
        Scanner scanner=new Scanner(System.in);


        System.out.println("Enter number of people: ");
        arrayNum=scanner.nextInt();
        System.out.println("Enter the person number to start counting from: ");
        startNum=scanner.nextInt();
        System.out.println("Enter the number of people to skip: ");
        skipNum=scanner.nextInt();


        Boolean[] alive = new Boolean[arrayNum];
        Arrays.fill(alive,true);
        int i = arrayNum; // "i" will decrement with every "death" to leave one alive

        //while loop to set elements to false until "i" equal 1
        index=startNum;
        while (index<alive.length&&i>1){
            if (skipCounter<skipNum && alive[index] == true){
                System.out.println("Person "+(index+1)+" is alive");
            }

            else if(skipCounter == skipNum && alive[index] == true){
                skipCounter=0;
                alive[index]=false;
                System.out.println("Person "+(index+1)+" is dead");
                i--;
            }
            else if(skipCounter<skipNum && alive[index] == false){
                skipCounter--;
            }
            else if(skipCounter==skipNum && alive[index] == false){
                skipCounter--;
            }
            index++;
            skipCounter++;
            if(index==alive.length){
                index=0;
            }
       }

        //Scans the array to find the only element set to true
        for(int j=0; j<alive.length; j++){
            if(alive[j]==true){
                System.out.println("Person "+(j+1)+" is the winner.");
            }
        }


    }



}

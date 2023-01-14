import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean flag = true;
        ArrayList<String> groceries = new ArrayList<>();
        while (flag) {
            printActions();
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1 -> addItems(groceries); //note that enhanced switch loop doesn't require break statement
                case 2 -> removeItems(groceries);
                default -> flag = false;
            }
            groceries.sort(Comparator.naturalOrder()); //.sort method of arrayList calls a comparator with static method .naturalOrder
            System.out.println(groceries);
        }
    }

    private static void addItems(ArrayList<String> groceries) {

        System.out.println("Add item(s) [separate items by comma]:"); //comma added to separate strings in use input
        String[] items = scanner.nextLine().split(","); //coma used to deconstruct string into String[] by '.split'

        for (String i: items) {
            String trimmed = i.trim(); //first trims any white space in the comma delimited list
            if (groceries.indexOf(trimmed) < 0) { //searches index of all items in the String[]
                groceries.add(trimmed); //only adds item if no index found
            }
        }

    }

    private static void removeItems(ArrayList<String> groceries) {

        System.out.println("Remove item(s) [separate items by comma]:");
        String[] items = scanner.nextLine().split(",");

        for (String i: items) {
            String trimmed = i.trim();
            groceries.remove(trimmed);
        }
    }
    private static void printActions() {
            //can set text block as a variable
        String textBlock = """ 
                Available actions:
                                
                0 - to shutdown
                                
                1 - to add item(s) to list (comma delimited list)
                                
                2 - to remove any items (comma delimited list)
                                
                Enter a number for which action you want to do:""";
        System.out.print(textBlock + " ");
    }
}
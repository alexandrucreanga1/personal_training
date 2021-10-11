package interfaceChallenge1;
/*
Create a simple interface that allows an object to be saved to some sort of storage medium.

Implement the following:

1.  ISaveable (interface)

    -  It has two methods:

        -  write(), takes no arguments and returns a List containing objects of type String.

        -  read(), takes a List of type String and doesn't return anything.

2.  Player (class)

    -  It has four fields. Two Strings called name and weapon. Two ints called hitPoints and strength.

    -  A constructor that accepts a String (name) and two ints (hitPoints and strength). It initialises name, hitPoints and strength with the newly passed in values. It initialises weapon with the default weapon "Sword".

    -  And eleven methods:

        -  Getters and setters for all four fields.

        -  write(), same as interface. Return a List of the fields in the order they appear in toString().

        -  read(), same as interface. Store the values in the List, in the order they appear in toString(). Make sure the List is not null and the size() is greater than 0 before storing the values.

        -  toString(), Players overriding toString() method. It takes no arguments and returns a String in the following format:

Player{name='Tim', hitPoints=10, strength=15, weapon='Sword'}

3.  Monster (class)

    -  It has three fields. One String called name and Two ints called hitPoints and strength.

    -  A constructor that accepts a String (name) and two ints (hitPoints and strength). It initialises name, hitPoints and strength with the newly passed in values.

    -  And six methods:

        -  Only getters for the three fields.

        -  write(), same as interface. Return a List of the fields in the order they appear in toString().

        -  read(), same as interface. Store the values in the List, in the order they appear in toString(). Make sure the List is not null and the size() is greater than 0 before storing the values.

        -  toString(), Monsters overriding toString() method. It takes no arguments and returns a String in the following format:

Monster{name='Werewolf', hitPoints=20, strength=40}

TIP:  Player and Monster need to implement ISaveable.

TIP:  Be extremely careful with the spelling of the names of the fields, constructors and methods.

TIP:  Be extremely careful about spaces and spelling in the returned String from the toString() method.

NOTE:  All fields are private.

NOTE:  Both constructors are public.

NOTE:  All methods are public.

NOTE:  There are no static members.

NOTE:  Do not add a main method to the solution code.

NOTE:  If you get an error from the Evaluate class, it's most likely the constructor. Check if you've added a constructor or if the constructor has the right arguments.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Player tim = new Player("Tim",10,15);
        System.out.println(tim.toString());
        savedObject(tim);

        tim.setHitPoints(8);
        System.out.println(tim);
        tim.setWeapon("Stormbringer");
        savedObject(tim);
     //   loadObject(tim);
        System.out.println(tim);

    Monster werewolf = new Monster("Werewolf",20,40);

        System.out.println(werewolf);
       // System.out.println((Monster) werewolf).getStrength()); de ce nu merge cu Interfata ?
        savedObject(werewolf);



    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 - to enter a string\n" +
                "2 - to quit");
        while (!quit) {
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit =true;
                    break;
                case 1:
                    System.out.println("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index,stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }

    public static void savedObject (ISaveable objectToSave) {
        for(int i=0; i<objectToSave.write().size(); i++) {
            System.out.println("Saving " + objectToSave.write().get(i) + " to storage device");
        }
    }

    public static void loadObject (ISaveable objectToLoad) {
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
    }



}

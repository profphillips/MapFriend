package ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import model.Friend;
import utility.Validator;

/**
 * A black book rating app. Now using Java API data structures. Working toward a
 * map implementation.
 *
 * @author 55jphillip
 */
public class BBApp {

    Map<String, Friend> map;

    public BBApp() {
        this.map = new HashMap();

        map.put("Barb", new Friend("Barb", 9));
        map.put("Steve", new Friend("Steve", 5));
        map.put("Tom", new Friend("Tom", 7));
        map.put("Sue", new Friend("Sue", 3));
        map.put("Mark", new Friend("Mark", 9));
        start();
    }

    private void start() {
        Scanner sc = new Scanner(System.in);
        String choice;
        while (true) {
            menu();
            String regex = "^quit|add|remove|list|name|reverse|rating|search|range$";
            choice = Validator.getLine(sc, "Enter your choice: ", regex);
            if (choice.equalsIgnoreCase("quit")) {
                break;
            } else if (choice.equals("add")) {
                String name = Validator.getLine(sc, "Enter friend's name: ");
                int rating = Validator.getInt(sc, "Enter rating: ");
                map.put(name, new Friend(name, rating));
            } else if (choice.equals("remove")) {
                String name = Validator.getLine(sc, "Enter name to remove: ");
                map.remove(name);
            } else if (choice.equals("list")) {
                System.out.println(map);
            } else if (choice.equals("name")) {
                //Collections.sort(map, (a, b) -> a.getName().compareTo(b.getName()));
//                // If we don't want to change the list then use a temporary array:
//                Friend[] fa = list.toArray(new Friend[0]);
//                Arrays.sort(fa, (a, b) -> a.getName().compareTo(b.getName()));
//                for (Friend f : fa) {
//                    System.out.println(f.toString());
//                }
            } else if (choice.equals("reverse")) {
                //Collections.sort(map, (a, b) -> b.getName().compareTo(a.getName()));
            } else if (choice.equals("rating")) {
                //Collections.sort(map);
            } else if (choice.equals("search")) {
                // sequential search
                String name = Validator.getLine(sc, "Who would you like to find: ");
                Friend f = map.get(name);
                if (f != null) {
                    System.out.println(f);
                } else {
                    System.out.println(name + " not found!");
                }

//                Friend match = null;
//                for (Friend f : map) {
//                    if (f.getName().equalsIgnoreCase(name)) {
//                        match = f;
//                        break;
//                    }
//                }
//                if (match != null) {
//                    System.out.println("Match found: " + match.toString());
//                } else {
//                    System.out.println("Match not found!");
//                }
            } else if (choice.equals("range")) {
//                int low = Validator.getInt(sc, "Enter low end rating: ");
//                int high = Validator.getInt(sc, "Enter high end rating: ");
//                for (Friend f : map) {
//                    if (f.getRating() >= low && f.getRating() <= high) {
//                        System.out.println(f.toString());
//                    }
//                }
            }
        }
    }

    public void menu() {
        System.out.println("\nJohn's Black Book");
        System.out.println("Add - add a new friend");
        System.out.println("Remove - remove a friend");
        System.out.println("List - display list of friends");
        System.out.println("Name - display list of friends ordered by name");
        System.out.println("Reverse - display list of friends ordered by name descending");
        System.out.println("Rating - display list of friends ordered by rating");
        System.out.println("Search - search for a friend");
        System.out.println("Range - display friends in a range of ratings");
        System.out.println("Quit");
    }

    public static void main(String[] args) {
        BBApp app = new BBApp();
    }
}

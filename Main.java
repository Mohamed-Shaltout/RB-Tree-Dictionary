import java.io.*;
import java.util.Scanner;

public class Main {
    private static final String DICTIONARY = "Dictionary.txt";

    private static void loadDictionaryIntoTree(RBTree tree){

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(DICTIONARY))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                tree.insert(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void insertWordIntoDictionary(RBTree tree, Scanner sc) {
        System.out.print("Enter a word to insert: ");
        String word = sc.nextLine();
    
        if (tree.search(tree.getRoot(), word) != null) {
            System.out.println("ERROR: Word already in the dictionary!");
        } else {
            tree.insert(word);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(DICTIONARY, true))) {
                writer.write(word);
                writer.newLine();
                System.out.println("Word inserted and dictionary updated.");
            } catch (IOException e) {
                System.out.println("ERROR: Could not write to dictionary file.");
                e.printStackTrace();
            }
        }
    }
    
    private static void searchWord(RBTree tree, Scanner sc) {
        System.out.print("Enter word to search: ");
        String word = sc.nextLine();
    
        if (tree.search(tree.getRoot(), word) != null) {
            System.out.println("Yes, word found.");
        } else {
            System.out.println("No, word not found.");
        }
    }
    
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RBTree tree = new RBTree();
    
        loadDictionaryIntoTree(tree);
        System.out.println("Dictionary Loaded Successfully");
    
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Search for a word");
            System.out.println("2. Insert a word");
            System.out.println("3. Print black height");
            System.out.println("4. Print total size");
            System.out.println("5. Print tree height");
            System.out.println("6. Exit");
            System.out.print("Choose an option (1-6): ");
    
            int choice = -1;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
    
            switch (choice) {
                case 1:
                    searchWord(tree, sc);
                    break;
                case 2:
                    insertWordIntoDictionary(tree, sc);
                    break;
                case 3:
                    System.out.println("Black Height: " + tree.print_black_height(tree.getRoot()));
                    break;
                case 4:
                    System.out.println("Tree Size: " + tree.print_tree_size(tree.getRoot()));
                    break;
                case 5:
                    System.out.println("Tree Height: " + tree.print_tree_height(tree.getRoot()));
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    sc.close();  
                    return;
                default:
                    System.out.println("Invalid option. Please choose between 1 and 6.");
            }
        }
    }    
}
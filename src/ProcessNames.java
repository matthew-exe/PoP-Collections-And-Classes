import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * ProcessNames Class
 * @author Matthew Gee
 * @since November 2022
 *
 * Reads and interacts with a set of names
 */
public class ProcessNames {

    /**
     * readNames()
     * Reads names from a file into an arraylist
     * @param fileName  name of file
     * @return arraylist of read names
     * @throws FileNotFoundException    error handling
     */
    public ArrayList<String> readNames(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner fileScan = new Scanner(file);
        ArrayList<String> names = new ArrayList<>();
        while (fileScan.hasNext()) {
            names.add(fileScan.nextLine());
        }
        return names;
    }


    /**
     * sortNames()
     * sorts an array list of names alphabetically
     * @param names list of names
     * @return list of sorted names
     */
    public ArrayList<String> sortNames(ArrayList<String> names){
        ArrayList<String> sortedNames = new ArrayList<>(names);
        Collections.sort(sortedNames); // sorting names
        return sortedNames;
    }


    /**
     * findNamePosition()
     * finds the position of a name within an arraylist
     * @param names arraylist of names
     * @param selectedName  name to be found in names
     * @return position where the name was found in names
     */
    public int findNamePosition(ArrayList<String> names, String selectedName) {
        boolean nameFound = false;
        int namePosition = 0;
        while (!nameFound && namePosition < names.size()) { // loop through list until name is found or no more names in list
            if (names.get(namePosition).equals(selectedName)) { // if name is selected name
                nameFound = true; // end loop
            }
            else {
                namePosition++;
            }
        }
        if (!nameFound) { // if name not in loop
            namePosition = -1; // sets name position as -1 to show it was not found
        }
        return namePosition;
    }

    /**
     * deleteName()
     * deletes a selected name from the arraylist
     * @param names original arraylist
     * @param selectedName  name to remove
     * @return arraylist with name removed
     */
    public ArrayList<String> deleteName(ArrayList<String> names, String selectedName){
        ArrayList<String> editedNames = new ArrayList<>(names);
        editedNames.remove(selectedName);
        return editedNames;
    }


    /**
     * changeName()
     * replaces a name in an arraylist with a new name
     * @param names original arraylist
     * @param originalName   name to be replaced
     * @param newName   name to replace
     * @return arraylist with replaced name
     */
    public ArrayList<String> changeName(ArrayList<String> names, String originalName, String newName){
        ArrayList<String> editedNames = new ArrayList<>(names);
        int namePosition = findNamePosition(names, originalName);
        editedNames.set(namePosition, newName);
        return editedNames;
    }

}
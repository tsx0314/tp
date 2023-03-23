package seedu.duke.storage;


import java.util.ArrayList;
import java.util.List;

import seedu.duke.food.FoodList;
import seedu.duke.food.Food;


/**
 * Encodes the {@code FoodList} object into a data file for storage.
 * The code is adapted from
 * https://github.com/se-edu/addressbook-level2/blob/master/src/seedu/addressbook/storage/AddressBookEncoder.java
 */
public class FoodListEncoder {

    /**
     * Encodes all the {@code Food} in the {@code toSave} into a list of decodable and readable string presentation
     * for storage.
     */
    public static List<String> encodeFoodList(FoodList toSave) {
        final ArrayList<String> encodedFoodLists = new ArrayList<>();
        toSave.getFoodList().forEach(food -> encodedFoodLists.add(encodeFoodToString(food)));
        return encodedFoodLists;
    }

    /**
     * Encodes the {@code Food} into a decodable and readable string representation.
     */
    private static String encodeFoodToString(Food food) {
        final StringBuilder encodedFoodBuilder = new StringBuilder();

        encodedFoodBuilder.append(food.getName());
        encodedFoodBuilder.append(" « ").append(food.getExpiryDate());
//        encodedFoodBuilder.append(" « ").append(food.getQuantity());
//        encodedFoodBuilder.append(" « ").append(food.getCategory());

        return encodedFoodBuilder.toString();
    }
}

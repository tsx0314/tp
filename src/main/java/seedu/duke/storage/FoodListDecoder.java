package seedu.duke.storage;

import seedu.duke.food.Food;
import seedu.duke.food.FoodList;

import java.util.ArrayList;
import java.util.List;

/**
 * Decodes the storage data file into an {@code FoodList} object.
 * The code is adapted from
 * https://github.com/se-edu/addressbook-level2/blob/master/src/seedu/addressbook/storage/AddressBookDecoder.java
 */
public class FoodListDecoder {

/**
 * Decodes {@code encodedFoodList} into an {@code FoodList} containing the decoded food.
 */
    public static FoodList decodeFoodList(List<String> encodedFoodList) {
        final ArrayList<Food> decodedFoodList = new ArrayList<>();
        for (String encodedFood : encodedFoodList) {
            decodedFoodList.add(decodeFoodFromString(encodedFood));
        }
        return new FoodList(decodedFoodList);
    }

    /**
     * Decodes {@code encodedFood} into a {@code Food}.
     */
    private static Food decodeFoodFromString(String encodedFood) {
        String[] details = encodedFood.split("-e");
        return new Food(details[0].trim(), details[1].trim());
    }
}

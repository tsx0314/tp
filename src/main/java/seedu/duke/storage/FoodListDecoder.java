package seedu.duke.storage;

import seedu.duke.exceptions.StorageOperationException;
import seedu.duke.food.Food;
import seedu.duke.food.FoodList;
import seedu.duke.general.Ui;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;

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
            try {
                decodedFoodList.add(decodeFoodFromString(encodedFood));
            } catch (StorageOperationException e) {
                Ui.showError(e.getMessage());
            }
        }
        return new FoodList(decodedFoodList);
    }

    /**
     * Decodes {@code encodedFood} into a {@code Food}.
     */
    private static Food decodeFoodFromString(String encodedFood) throws StorageOperationException {
        String[] details = encodedFood.split("«");

        try {
            return new Food(details[0].trim(), details[1].trim()
                    , parseDouble(details[2].trim()), details[3].trim());
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new StorageOperationException("Unable to read file successfully");
        }
    }
}

package seedu.duke.food;

import seedu.duke.exceptions.DukeException;
import seedu.duke.exceptions.InvalidFlagException;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Represents a food list
 */
public class FoodList {
    private ArrayList<Food> foodList = new ArrayList<>();

    /**
     * Constructor
     */
    public FoodList() {
    }

    public void addFood(Food food) {
        foodList.add(food);
    }

    public void removeFood(int index) {
        foodList.remove(index);
    }

    public int getNumberOfFood() {
        return foodList.size();
    }

    public ArrayList<Food> getFoodList(){
        return foodList;
    }

    public Food getFood(int i){
        return foodList.get(i);
    }

    public FoodList findFood(String term, String ...flags) throws DukeException{
        FoodList result = new FoodList();

        foodItemLoop:
        for (Food foodItem: foodList) {
            String name = foodItem.getName();
            LocalDate expiryDate = foodItem.parseExpiryDate();
            boolean hasTerm = name.toLowerCase().contains(term.toLowerCase().trim());

            if (hasTerm) {
                // Filter by flags
                for (String flag: flags) {
                    switch (flag) {
                    case "fresh":
                            boolean isFresh = expiryDate.isAfter(LocalDate.now());
                            if (!isFresh) { continue foodItemLoop; }
                            break;
                    case "expired":
                            boolean isExpired = expiryDate.isBefore(LocalDate.now());
                            if (!isExpired) { continue foodItemLoop; }
                            break;
                    default:
                        throw new InvalidFlagException(flag);
                    }
                }
                // adds the item if all filters passed
                result.addFood(foodItem);
            }

        }
        return result;
    }

    @Override
    public String toString() {
        int index = 1;
        StringBuilder output = new StringBuilder();
        for (Food foodItem : foodList) {
            output.append(index).append(". ").append(foodItem);
            output.append(System.lineSeparator());
            index++;
        }
        return output.toString();
    }
}

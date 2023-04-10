package seedu.duke.food;

import seedu.duke.exceptions.DukeException;
import seedu.duke.exceptions.IllegalValueException;

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

    public FoodList(ArrayList<Food> decodedFoodList) {
        foodList = decodedFoodList;
        try {
            sortFoodList();
        } catch (DukeException e) {
            System.out.println("Unexpected Error.");;
        }
    }

    public void addFood(Food food) {
        foodList.add(food);
    }

    public void removeFood(int index) {
        foodList.remove(index);
    }

    /**
     * Return the total number of food in FoodList.
     *
     * @return number of food
     */
    public int getNumberOfFood() {
        return foodList.size();
    }

    /**
     * Return the FoodList.
     *
     * @return foodList
     */
    public ArrayList<Food> getFoodList() {
        return foodList;
    }

    /**
     * Get the food of type Food at a specific index.
     *
     * @param index
     * @return food of a particular index in the FoodList
     * @throws DukeException
     */
    public Food getFood(int index) throws DukeException {
        try {
            return foodList.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalValueException("No item at such index!");
        }
    }

    /**
     * Sort the FoodList according to the expiry dates of the food.
     *
     * @throws DukeException
     */
    public void sortFoodList () throws DukeException {
        for (int i = 0; i < getNumberOfFood(); i++){
            for(int j = 0; j < getNumberOfFood(); j++){
                long day1 = foodList.get(i).getDaysExpire();
                long day2 = foodList.get(j).getDaysExpire();
                if (day1 < day2) {
                    Food temp = foodList.get(i);
                    foodList.set(i, foodList.get(j));
                    foodList.set(j, temp);
                }
            }
        }
    }

    /**
     * Remove all Food objects from the FoodList.
     */
    public void clearFoodList() {
        int totalNumberFood = getNumberOfFood();
        for (int i = totalNumberFood - 1; i >= 0; i--) {
            removeFood(0);
        }
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

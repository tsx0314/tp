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

    //Constructor to get data from save file
    public FoodList(ArrayList<Food> decodedFoodList) {
        foodList = decodedFoodList;
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

    public ArrayList<Food> getFoodList() {
        return foodList;
    }

    public Food getFood(int i) throws DukeException {
        try {
            return foodList.get(i);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalValueException("No item at such index!");
        }
    }

    public void sortFoodList () throws DukeException {
        for (int i = 0; i < getNumberOfFood(); i++){
            for(int j = 0; j < getNumberOfFood(); j ++){
                long day1 = foodList.get(i).getDaysExpire();
                long day2 = foodList.get(j).getDaysExpire();
                if(day1 < day2){
                    Food temp = foodList.get(i);
                    foodList.set(i, foodList.get(j));
                    foodList.set(j, temp);
                }
            }
        }
    }

    public void clearFoodList() {
        int totalNumberFood = getNumberOfFood();
        for(int i = totalNumberFood-1; i >= 0; i--){
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

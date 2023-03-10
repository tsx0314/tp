package seedu.duke.food;

import java.util.ArrayList;

public class FoodList {
    public ArrayList<Food> foodList = new ArrayList<>();

    public FoodList() {
    }

    public void addFood(Food food) {
        foodList.add(food);
    }
}

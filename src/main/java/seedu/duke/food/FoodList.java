package seedu.duke.food;

import java.util.ArrayList;

public class FoodList {
    private ArrayList<Food> foodList = new ArrayList<>();
    private static int numberOfFood = 0;

    public FoodList() {
    }

    public void addFood(Food food) {
        numberOfFood++;
        foodList.add(food);
    }

    public int getNumberOfFood(){
        return numberOfFood;
    }

    public ArrayList<Food> getFoodList(){
        return foodList;
    }

    public Food getFood(int i){
        return foodList.get(i);
    }
}

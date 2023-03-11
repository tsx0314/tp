package seedu.duke.food;

import java.util.ArrayList;

public class FoodList {
    private ArrayList<Food> foodList = new ArrayList<>();
    private int numberOfFood = 0;

    public FoodList() {
    }

    public void addFood(Food food) {
        numberOfFood++;
        foodList.add(food);
    }

    public void removeFood(int index) {
        numberOfFood--;
        foodList.remove(index);
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

    public FoodList findFood(String term) {
        ArrayList<Food> foodItems = getFoodList();

        FoodList result = new FoodList();

        for (Food foodItem: foodItems) {
            String name = foodItem.getName();
            if (name.toLowerCase().contains(term.toLowerCase())) {
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
            index++;
        }
        return output.toString();
    }
}

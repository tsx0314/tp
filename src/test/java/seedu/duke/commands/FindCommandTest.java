package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.DukeException;
import seedu.duke.food.Food;
import seedu.duke.food.FoodList;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@@author DavidVin357
public class FindCommandTest {
    private String getExpectedFeedback(int expectedNumber) {
        final String FOUND_FOOD = "Found " + expectedNumber + " of food items";
        final String NOT_FOUND = "No food found for such query";
        if (expectedNumber > 0) {
            return FOUND_FOOD;
        }
        return NOT_FOUND;
    }
    @Test
    public void termSearch_withoutFlags_numberOfFoundFood() throws DukeException {
        FoodList foodList = new FoodList();
        foodList.addFood(new Food("Chicken egg", "25/04/2025"));
        foodList.addFood(new Food("Ostrich Egg  ", "26/04/2025"));
        foodList.addFood(new Food("Cow's Milk", "27/04/2025"));

        assertEquals(getExpectedFeedback(2), new FindCommand("EGG ").execute(foodList).feedbackToUser);
    }

    @Test void termSearch_withFreshFlag_numberOfFoundFood() throws DukeException {
        FoodList foodList = new FoodList();
        foodList.addFood(new Food("Expired egg", "25/04/2024"));
        foodList.addFood(new Food("Good Egg  ", "26/04/2025"));
        foodList.addFood(new Food("Expired Milk", "27/04/2024"));
        foodList.addFood(new Food("Good Milk", "27/04/2025"));
        assertEquals(getExpectedFeedback(2), new FindCommand("EGG --fresh").execute(foodList).feedbackToUser);
    }

}

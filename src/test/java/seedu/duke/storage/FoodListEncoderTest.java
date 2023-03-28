package seedu.duke.storage;

import org.junit.jupiter.api.Test;
import seedu.duke.food.Food;
import seedu.duke.food.FoodList;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.duke.food.FoodCategory.GRAIN;

public class FoodListEncoderTest {

    //TODO: Test for case where there is more than 1 food in foodList
    @Test
    void encodeFoodList_withExpiryDate_expectNameAndExpiry() {
        Food food = new Food("peanuts", "11/11/23");
        FoodList fl = new FoodList();
        fl.addFood(food);
        ArrayList<String> encodedFoodLists = FoodListEncoder.encodeFoodList(fl);
        ArrayList<String> expectedOutput = new ArrayList<>();
        expectedOutput.add("peanuts « 11/11/23 « 0.0 « null « UNCLASSIFIED_FOOD");
        assertEquals(expectedOutput, encodedFoodLists);
    }

    @Test
    void encodeFoodList_withExpiryDateAndQuantity_expectNameExpiryAndCategory() {
        Food food = new Food("peanuts", "11/11/23", GRAIN);
        FoodList fl = new FoodList();
        fl.addFood(food);
        ArrayList<String> encodedFoodLists = FoodListEncoder.encodeFoodList(fl);
        ArrayList<String> expectedOutput = new ArrayList<>();
        expectedOutput.add("peanuts « 11/11/23 « 0.0 « null « GRAIN");
        assertEquals(expectedOutput, encodedFoodLists);
    }

    @Test
    void encodeFoodList_withMultipleFood_expectMultipleFoodRecorded() {
        Food peanuts = new Food("peanuts", "11/11/23");
        Food strawberry = new Food("strawberries", "31/03/23");
        FoodList fl = new FoodList();
        fl.addFood(peanuts);
        fl.addFood(strawberry);
        ArrayList<String> encodedFoodLists = FoodListEncoder.encodeFoodList(fl);
        ArrayList<String> expectedOutput = new ArrayList<>();
        expectedOutput.add("peanuts « 11/11/23 « 0.0 « null « UNCLASSIFIED_FOOD");
        expectedOutput.add("strawberries « 31/03/23 « 0.0 « null « UNCLASSIFIED_FOOD");
        assertEquals(expectedOutput, encodedFoodLists);
    }


        @Test
        void encodeFoodList_withExpiryDateAndQuantityWithUnits_expectNameExpiryAndQuantityWithUnits() {
            Food food = new Food("peanuts", "11/11/23", 50.0, "g");
            FoodList fl = new FoodList();
            fl.addFood(food);
            FoodListEncoder fle = new FoodListEncoder();
            ArrayList<String> encodedFoodLists = fle.encodeFoodList(fl);
            ArrayList<String> expectedOutput = new ArrayList<>();
            expectedOutput.add("peanuts « 11/11/23 « 50.0 « g « UNCLASSIFIED_FOOD");
            assertEquals(expectedOutput, encodedFoodLists);
        }
}


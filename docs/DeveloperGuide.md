# Developer Guide

## Design

{To Be Added}

---

## Implementation

### Add feature

The add feature is implemented using a `AddCommand` class extending from `Command` Class. 
`AddCommand` contains an `execute` methods, which utilises the internal `spiltDetails` methods to extract the food details
and to construct new `food` object .
It is also facilitated by `Foodlist` Class, using `addFood` method of `FoodList` Class.

The add feature implementation is as follows:
1. New AddCommand object is created by passing in a String containing food details
2. `splitDetails` is called to split the string
3. boolean `hasQuantity` is used to record whether the string contains `-q` quantity flag
4. Split the string using ` -q ` regardless of whether the string contains the quantity part
5. Check the index of `-n` and `-e` and split the string to save the details of the food name and expiry date
6. If `hasQuantity` is `true`, return a String array with `name`, `date` and `quantity`, else only return
a String array with `name` and `date`.
7. Create a new `Food` object and use `addFood` to add the new food into the food list
8. Return a `CommandResult` to show the successful message to the user


**Class Diagram**

![ClassDiagram](images/AddCommandClassDiagram.png)


**Sequence Diagram**

![ClassDiagram](images/AddCommandSequenceDiagram.png)


### Find feature
The find command is implemented using a `FindCommand` class which
utilizes `findFood` method of the FoodList.

The `findFood` method implementation is as follows:
1. Initialize `FoodList` result variable
2. Start a loop iterating over each foodItem 
3. Do word processing on a term and check if the foodItem name includes it
4. Enter a loop with switch statement for each component of the `flags` argument 
5. If some flag is not satisfied, continue the loop without adding foodItem to the result
6. If the flags loop is over, the flags conditions were satisfied, so add the foodItem to the result

**Class Diagram** 
![ClassDiagram](images/FindCommandClassDiagram.png)


**Sequence Diagram**
![ClassDiagram](images/FindCommandSequenceDiagram.png)

### List feature
The list command is implemented using a `ListCommand` class which utilizes `COMMAND_WORD`
attributes of all other commands within the `commands` package.

The list command is implemented as follows:
1. New `ListCommand` object is created by passing in a String containing arguments from `Parser`.
2. The method `execute` of `Command` class will be called all the way from `Duke`.
3. The method `execute` decides what to append to the string `printToUser` according to `foodList`. 
4. `foodList` is an object of type `FoodList` that is passed as argument to `execute`, it consists of the list of food that has been added by user.
5. Loop through the `foodList` of `numberOfFood` iterations, in which `numberOfFood` is obtained from the `FoodList` function `getNumberOfFood`.
6. While looping through the `foodList`, append the `index`, name and expiry date of food to the string `printToUser`.
7. After looping through the entire `foodList`, this method `execute` will return an object called `CommandResult` and pass
`printToUser` as its argument.
8. `Duke` will then call `printResult` method from `CommandResult` which will print the food list for the user.

**Class Diagram**
{to be added}

**Object Diagram**
{to be added}

### Help feature
The help command is implemented using a `HelpCommand` class which utilizes `COMMAND_WORD` 
attributes of all other commands within the `commands` package. 

The help command is implemented as follows:
1. New `HelpCommand` object is created by passing in a String containing arguments from `Parser`.
2. The constructor `HelpCommand` will split the arguments based on the `--` regex and store them in an array of
strings called `filters`.
3. The method `execute` of `Command` class will then be called all the way from `Duke` with `filters` as its argument. 
4. This method decides what to append to the string `printToUser` as specified by the `filters`. 
5. After looping through all the `filters`, this method will return an object called `CommandResult` and pass
`printToUser` as its argument.
6. `Duke` will then call `printResult` method from `CommandResult` which will print the necessary message.

**Class Diagram**
![ClassDiagram](images/HelpCommandClassDiagram.png)


**Sequence Diagram**
![ClassDiagram](images/HelpCommandSequenceDiagram.png)

---
## Appendix: Requirements
# Product scope
**Project Direction**
- Food Supplies Tracker: Main function is to track expiry dates 
and storage area of foods as to minimise food shortage.

- **Target user profile:**
- Kitchen worker, Homemaker
- has a need to manage food
- prefer desktop apps over other types
- can type fast
- prefers typing to mouse interactions
- is reasonably comfortable using CLI apps

**Value proposition:**
1) Manage food supply faster than a typical mouse / GUI driven app
2) Check the expiry date of a particular food quickly
3) Check the foods in the most recent expiry dates quickly
4) Get suggestions and alert to consume foods that are going to expire soon

Currently, the following functionality was implemented:

`add -n PRODUCT_NAME -e EXPIRY_DATE {-p QUANTITY}`

`add -e EXPIRY_DATE -n PRODUCT_NAME {-p QUANTITY}`

`find {PRODUCT_NAME}`

`find {PRODUCT_NAME} -fresh`

`find {PRODUCT_NAME} -expired`

`help {--COMMAND_WORD}`

The next possible flag to implement will be `-c` which stands for `categories`

# User stories

| Priority | As a...             | I want to ...                                                         | So that I can...                                                | Current Feature Available |
|----------|---------------------|-----------------------------------------------------------------------|-----------------------------------------------------------------|---------------------------|
| `* * *`  | Forgetful cook      | be reminded of what is left in my fridge                              | use the food wisely and avoid repetitive purchasing.            | `list`                    |
| `*`      | Forgetful cook      | get all meals for the next `x` days with their ingredients            | plan my grocery trips accordingly.                              | nil                       |
| `* *`    | Lazy cook           | get recommended recipes based on what I have left in the <br/>fridge  | can spend less time considering what to cook today.             | nil                       |
| `* * *`  | Lazy cook           | have an efficient method of updating what leftover ingredients I have | spend less time using the software.                             | `add -n`                  |
| `* * *`  | Lazy cook           | check the lists of food fast                                          | waste less effort digging through the fridge / kitchen.         | `list`                    |
| `* * *`  | Busy cook           | get reminded on the products which will expire soon                   | prepare a meal based on it.                                     |                           |
| `* * *`  | Busy cook           | get reminded on the products which will expire soon                   | plan my grocery purchases accordingly.                          |                           |
| `* * *`  | Busy cook           | check the availability of certain food fast                           | waste little time digging through the fridge / kitchen.         | `find`                    |
| `* * *`  | Prudent cook        | check the expiry dates of food in fridge / kitchen                    | don't waste food due to food expiring and spoiling.             | `find`                    |
| `* *`    | Disorganised person | organise food by categories at least in a program (fruits,veggies...) | don't spend time looking for the food scattered in the kitchen. | nil                       |
| `* *`    | Prudent cook        | track the amount of different products I have                         | know how many portions I can cook.                              | nil                       |
| `*`      | Creative cook       | replace some products with others                                     | add potential replacement for the product.                      | nil                       |     
| `*`      | Inexperienced cook  | know how much to cook based on the number of people eating            | prepare the correct amount of food.                             | nil                       |  
| `* * *`  | Cook                | add product (name, expiry date, category etc)                         | keep my program updated.                                        | `add -n -e`               |
| `* * *`  | Cook                | remove product                                                        | keep my program updated.                                        | `remove`                  |



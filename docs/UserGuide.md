# User Guide

## Introduction

Food Supply Trackers (FSP) is a desktop app for managing food supplies, optimized for use via a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, FSP can get your food management tasks done faster than traditional GUI apps.

---
+ [Quick Start](#quick-start)
+ [Features](#features)
  + [Viewing help: `help`](#viewing-help--help)
  + [Listing all food products: `list`](#listing-all-food-products--code-list-code)
  + [Adding a food product: `add`](#adding-a-food-product--add)
  + [Removing a food product: `remove`](#removing-a-food-product--remove) 
  + [Finding food products by name: `find`](#finding-food-products-by-name--code-find-code)
+ [FAQ](#faq)
+ [Command Summary](#command-summary)

---

## Quick Start

1. Ensure you have Java 11 installed in your Computer.
2. Download the latest Food Supplies Tracker [here](https://github.com/AY2223S2-CS2113-W13-3/tp/releases).
3. Copy the file to the folder you want your FoodSuppliesTracker to be in. 
4. Open a command terminal, navigate into the folder with your jar file using cd and run the application with java -jar tp.jar
5. Type the command in the command box and press Enter to execute it. E.g. typing help and pressing Enter will open the help window.
6. Go to [Command Summary](#command-summary) for a quick start on command format.

---

## Features
- Viewing help: <code>help</code>
- Listing all food products: <code>list</code>
- Adding a food product: <code>add -n PRODUCT_NAME -e EXPIRY_DATE</code>
- Removing a food product: <code>remove INDEX</code>
- Finding a food product detail: <code>find PRODUCT_NAME</code>
- Exit the programme: <code>exit</code>

### Notes about the command format:
1. Words in UPPER_CASE are the parameters to be supplied by the user.
2. Optional flags are put in curly braces.
3. A parameter is expected only once in the command. If you specify it multiple times, it will be deemed as invalid command.
4. Extraneous parameters for commands that do not take in parameters (such as help, list, exit and clear) will be ignored.

### Viewing help: `help`
Shows a message explaining how to access the help page and the command specified.

- When a filter (prefix <code>--</code>) is applied, the help message will display the helper for the specified command.
- When no filter is applied, only the link to the user guide would be displayed.

Format: `help {--COMMAND_WORD}`

Example of usage:

<bold>Input:</bold>

<code>help --remove --find</code>

<bold>Output:</bold>
```
______________________________
Command 'remove': This command removes the food product from the food supply tracker based on its index.
Format: remove INDEX

Command 'find': This command finds the food product by its name.
Format: find PRODUCT_NAME
______________________________
```

### Listing all food products: <code>list</code>
List all food products available in the tracker regardless of expiry status.

- Adding the filter <code>--fresh</code> would list only the unexpired food products.
- Adding the filter <code>--expired</code> would list only the expired food products.

Format: <code>list</code>

Example of usage:

<bold>Input:</bold>

<code>list</code>

<bold>Output:</bold>
```
______________________________
Below are the food list: 

1. Eggs
       Expiry date: 23/02/2023
2. Peanuts
       Expiry date: 12/12/23


You now have 2 food products in your lists.
______________________________
```

### Adding a food product: `add`
Adds a food product to the list of food items.

Format: `add -n FOOD_NAME -e DD/MM/YYYY {-c CAT} {-q QUANTITY -u UNITS}`

* The `DEADLINE` can be in a natural language format.
* The `FOOD_NAME` cannot contain `-`.
* `{-c CAT}`and`{-q QUANTITY -u UNITS}` are optional
  * However, quantity and units must be added together
  * For example: `add -n milk -e 21/03/2025 -q 10 -u packets`
* For category, we only have `FRUIT, VEGETABLE, MEAT, DAIRY, GRAIN, SEAFOOD, BEVERAGE, OTHERS`
any other category will be deemed as `unknown category`.

Examples of usage:

<bold>Input:</bold>

`add -n milk -e 21/03/2025 -c dairy -q 10 -u packets`

<bold>Output:</bold>
```
______________________________
milk
       Expiry date: 21/03/2025
       Category: dairy
       Remaining quantity: 10.0 packets

I have added this product! :)
______________________________
```

### Removing a food product: `remove`
Remove a food product from the list based on its index.

Format: `remove INDEX`

* Deletes the food according to its `INDEX` in the list which starts from 1.
* `INDEX` must be represented by an integer `i.e. 1, 2, 3`
* Out-of-bounds `INDEX` will result in an error message.

Example of usage:

Input

`remove 1`

Output:
```
Removed Eggs from the food supply list.
There is/are now 0 item(s) in the list.
```

### Finding food products by name: <code>find</code>
Find the food product by its name that was previously added into the list.

Format: <code>find PRODUCT_NAME</code>

- The search is not case-sensitive.
  - E.g. eggs will match Eggs
- Only the name will be searched.
- Only full words will be matched.
  - E.g. Egg will not match Eggs
- Item matching at least one keyword will be returned.
  - E.g. Blueberry will return Blueberry Yogurt, Blueberry

Example of Usage:

<bold>Input:</bold>

<bold>Output:</code>


## FAQ

**Q1**: Do I need other software to support FSP?

**A**: No, you do not need any other software to support FSP.

**Q2**: I am unable to add the food product./I cannot list the food items./ I cannot remove the items.

**A**: Please take note of the command line format shown in the features section. Type ‘help’ to show the command line and please follow the command line exactly. Moreover, please check that the parameters are also in the correct format to avoid meaningless addition of food product.

**Q3**: Is searching case-sensitive?

**A**: No, and items matching at least one keyword will be returned.

**Q4**: Can I write creative names for my food items?

**A**: Yes, you may do that to increase the amusement when listing the food items. However, it might be difficult for you to search for that specific item.

**Q5**: What if I add the item's name incorrectly?

**A**: Currently, we have not implemented the edit features. Please remove the item that you created wrongly and add a new food product.

**Q6**: Can I export my food list into CSV files?

**A**: Sorry, currently FSP does not have such features, but we will work on it in the future.

**Q7**:How do I transfer my data to another Computer?

**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous FSP home folder.

---

## Command Summary

* List - `list  {--fresh or --expired}`
  * e.g., list --fresh OR list --expired
* Add - `add -n FOOD_NAME -e DD/MM/YYYY {-c CAT} {-q QUANTITY -u UNIT}`
  * e.g., add -n Bob's Red Mill Granola -e 20/05/2025 -c others -q 10 -u packets
* Remove - `remove INDEX_NUMBER`
  * e.g., remove 1
* Find - `find KEYWORD`
  * e.g., find egg
* help - `help {--COMMAND_WORD}`
* exit - `exit`





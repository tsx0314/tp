# User Guide

## Introduction

Food Supply Tracker (FSP) is a desktop app for managing food supplies, optimized for use via a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, FSP can get your food management tasks done faster than traditional GUI apps.

---
+ [Quick Start](#quick-start)
+ [Features](#features)
  + [Viewing help: `help`](#viewing-help--help)
  + [Adding a food product: `add`](#adding-a-food-product--add)
  + [Listing all food products: `list`](#listing-all-food-products--code-list-code)
  + [Removing a food product: `remove`](#removing-a-food-product--remove) 
  + [Finding food products by name: `find`](#finding-food-products-by-name--code-find-code)
  + [Update food products by index: `update`](#updating-food-products-by-index--code-update-code)
  + [Exit FSP Program: `exit`](#exiting-FSP-code-exit-code)
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

##### Quick notes about the command format:
1. Words in UPPER_CASE are the parameters to be supplied by the user.
2. Optional flags are put in curly braces.
3. A parameter is expected only once in the command. If you specify it multiple times, it will be deemed as invalid command.
4. Extraneous parameters for commands that do not take in parameters (such as help, list, exit and clear) will be ignored.

### Viewing help: `help`
Shows a message explaining how to access the help page and the command specified.

- When a filter (prefix <code>--</code>) is applied, the help message will display the helper for the specified command.
- By default, all available commands and the link to the user guide would be displayed.

Format: `help {--COMMAND_WORD}`

Example of usage:

Input:

<code>help --remove --find</code>

Output:
```
______________________________
Command 'remove': This command removes the food product from the food supply tracker based on its index.
Format: remove INDEX

Command 'find': This command finds the food product by its name.
Format: find PRODUCT_NAME


List of commands: 'exit', 'help', 'list', 'add', 'remove', 'find'
For more detailed information on usage of specific command, type: help --COMMAND
Refer to our user guide for more in-depth details on how to use our system:
https://docs.google.com/document/d/1WKscnkYy9UqI_tsWmUHIMjgILJc6GQeFn0B1ce6qkQo/edit?usp=sharing
Mar 31, 2023 1:26:06 PM seedu.duke.Duke run
INFO: Processed user command successfully
______________________________

```
### Adding a food product: `add`
Add a food product to the list of food items.

Format: `add -n FOOD_NAME -e DD/MM/YYYY {-c CATEGORY} {-q QUANTITY -u UNITS}`

* `FOOD_NAME` can be in a natural language format but should not contain `-`.
* `{-c CATEGORY}`and`{-q QUANTITY -u UNITS}` are optional.
  * For category, we have `fruit, vegetable, meat, dairy, grain, seafood, beverage, others`.
  * Any other category will be classified as `unknown category`.
  * Quantity and units must be added together.
    * E.g. `add -n milk -e 21/03/2025 -q 10 -u packets`


Examples of usage:

Input:

`add -n milk -e 21/03/2025 -c dairy -q 10 -u packets`

Output:
```
______________________________
milk
       Expiry date: 21/03/2025
       Category: dairy
       Remaining quantity: 10.0 packets

I have added this product! :)
______________________________
```

### Listing all food products: <code>list</code>
List all food products available in the tracker regardless of expiry status.

- All food products will be listed with index, followed by the number of food products in the list.

Format: <code>list</code>

Example of usage:

Input:

<code>list</code>

Output:
```
______________________________

Below are the food list:
1. Eggs
       Expiry date: 23/04/2023
       Category: others
       Remaining quantity: 3.0 pieces
2. Peanuts
       Expiry date: 12/12/2023
       Category: grain
       Remaining quantity: 500.0 grams

You now have 2 food products in your lists.
______________________________
```



### Removing a food product: `remove`
Remove a food product from the list based on its index.

Format: `remove INDEX`

* Deletes the food according to its `INDEX` in the list.
* `INDEX` must be represented by an integer `i.e. 1, 2, 3`
* Out-of-bounds `INDEX` will result in an error message.

Example of usage:

Input:

<code>remove 1</code>

Output:
```
______________________________
Removed Eggs from the food supply list.
There is/are now 0 item(s) in the list.
______________________________
```

### Finding food products by name: <code>find</code>
List all food product with matching name.

Format: <code>find FOOD_NAME {-fresh} {-expired}</code>

- The search is not case-sensitive.
  - E.g. eggs will match Eggs
- Only full words will be matched.
  - E.g. Egg will not match Eggs
- Item matching at least one keyword will be returned.
  - E.g. Blueberry will return Blueberry Yogurt, Blueberry
- Adding the filter <code>-fresh</code> would list only the unexpired food products.
- Adding the filter <code>-expired</code> would list only the expired food products.

Example of Usage:

Input:

`find blueberry`

Output:
```
______________________________
1. Blueberry Yogurt
       Expiry date: 23/04/2023
       Category: dairy
       Remaining quantity: 1.0 cup
2. Blueberry
       Expiry date: 12/04/2023
       Category: fruit
       Remaining quantity: 50.0 g

Found 2 of food items
______________________________
```
### Updating food products by index: <code>update</code>
Change any attribute based on the index in the list.

* Multiple attributes can be changed at once by appending the identifier at the back.

Example of Usage:

Input:

<code>update 1 -q 20</code>

Output:
```
______________________________
Updated food item successfully!
Blueberry
       Expiry date: 12/04/2023
       Category: fruit
       Remaining quantity: 20.0 g
______________________________
```

### Exiting FSP: <code>exit</code>
This command will save the food list in an external file before closing the program.

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

* help - `help {--COMMAND_WORD}`
  * e.g. <code>help --update --add</code> 
* Add - `add -n FOOD_NAME -e DD/MM/YYYY {-c CAT} {-q QUANTITY -u UNIT}`
  * e.g. <code>add -n Bob's Red Mill Granola -e 20/05/2025 -c others -q 10 -u packets</code>
* List - `list`
* Remove - `remove INDEX_NUMBER`
  * e.g. remove 1
* Find - `find KEYWORD {-fresh} {-expired}`
  * e.g. <code>find egg -fresh</code>
* Update - <code>update INDEX -filter UPDATED_VALUE</code>
  * e.g. <code>update 2 -q 1</code>
* exit - `exit`




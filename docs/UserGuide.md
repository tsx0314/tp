# User Guide

## Introduction

Food Supply Trackers (FSP) is a desktop app for managing food supplies, optimized for use via a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, FSP can get your food management tasks done faster than traditional GUI apps.

---
## Quick Start

1. Ensure you have Java 11 installed in your Computer.
2. Download the latest Food Supplies Tracker [here](https://github.com/AY2223S2-CS2113-W13-3/tp/releases).
3. Copy the file to the folder you want your FoodSuppliesTracker to be in. 
4. Open a command terminal, navigate into the folder with your jar file using cd and run the application with java -jar tp.jar
5. Type the command in the command box and press Enter to execute it. E.g. typing help and pressing Enter will open the help window.
6. Go to [Command Summary](##Command Summary) for a quick start on command format.

---

## Features 

### Notes about the command format:
1. Words in UPPER_CASE are the parameters to be supplied by the user.
2. Optional flags are put in curly braces.
3. A parameter is expected only once in the command. If you specify it multiple times, it will be deemed as invalid command.
4. Extraneous parameters for commands that do not take in parameters (such as help, list, exit and clear) will be ignored.

### Adding a food product: `add`
Adds a food product to the list of food items.

Format: `add -n FOOD_NAME -e DD/MM/YYYY {-p QUANTITY}`

* The `DEADLINE` can be in a natural language format.
* The `FOOD_NAME` cannot contain `-`.
* The order of `-n` and `-e` can be swapped
  * For example: `add -n Eggs -e 21/03/2023` and `add -e 21/03/2023 -n Eggs` 

Examples of usage: 

Input

`add -n Eggs -e 21/03/2023`

Output:
```
Egg
       Expiry date: 21/03/2023


I have added this product! :)
```

Input

`add -n Eggs -e 21/03/2023 -q 10`

Output:
```
Egg
       Expiry date: 21/03/2023
       Remaining quantity: 10.0

I have added this product! :)
```
---

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
* Add - `add -n FOOD_NAME -e DD/MM/YYYY {-q QUANTITY}`
  * e.g., add -n Bob's Red Mill Granola -e 20/05/2025
  * e.g., add -e 20/05/2025 -n Bob's Red Mill Granola -q 2
* Remove - `remove INDEX_NUMBER`
  * e.g., remove 1
* Find - `find KEYWORD`
  * e.g., `find egg`
* help - `help`
* exit - `exit`





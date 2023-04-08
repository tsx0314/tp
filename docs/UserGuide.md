# User Guide

## Introduction

Food Supply Tracker (FSP) is a desktop app for managing food supplies, optimized for use via a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, FSP can get your food management tasks done faster than traditional GUI apps.

---
+ [Quick Start](#quick-start)
+ [Features](#features)
  + [Viewing help: `help`](#viewing-help)
  + [Adding a food product: `add`](#adding-a-food-product)
  + [Listing all food products: `list`](#listing-all-food-products)
  + [Removing a food product: `remove`](#removing-a-food-product) 
  + [Finding food products by name: `find`](#finding-food-products-by-name)
  + [Update food products by index: `update`](#updating-food-products-by-index)
  + [Exit FSP Program: `exit`](#exiting-fsp)
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
2. Parameters in the `{ }` are optionals, and `{ }` the bracket characters cannot be included in the command line.
3. Optional flags are put in curly braces.
4. Parameter is expected only once in the command. If you specify it multiple times, it will be deemed as invalid command.

### Viewing help

`help`- Show a message explaining how to access the help page and the command specified.
* Any extraneous parameters input after the command `help` will be ignored.

  (e.g. `help 123 abcde` will still work as `help`)

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
Append the filter '-fresh' for listing unexpired food products and '-expired' for listing expired food products.
Append the filter '-c' followed by CATEGORY to find by category.

List of commands: 'add', 'list', 'remove', 'find', 'update', 'exit'.
For more detailed information on usage of specific command, type: help --COMMAND
Refer to our user guide for more in-depth details on how to use Food Supply Tracker:
https://ay2223s2-cs2113-w13-3.github.io/tp/UserGuide.html
______________________________
```

### Adding a food product 

`add` - Add a food product to the list of food items.

Format: `add -n FOOD_NAME -e DD/MM/YYYY {-c CAT -q QUANTITY -u UNITS}`

* The parameter cannot contain any punctuations, or else it will return as incorrect command.
* `-n FOOD_NAME` and `-e DD/MM/YYYY` are compulsory.
* `-c CAT`and`-q QUANTITY -u UNITS` are optional.
  * `-u UNIT` must be added together with `-q QUANTITY`.
  * `-q QUANTITY` can be added without `-u UNIT`
    * For example, a proper command can be `add -n milk -e 21/03/2025 -q 10.0`. 
However, it cannot be `add -n milk -e 21/03/2025 -u packets`
* For `CATEGORY`, we only have `FRUIT, VEGETABLE, MEAT, DAIRY, GRAIN, SEAFOOD, BEVERAGE, OTHERS`
any other category or no category added will be deemed as `OTHERS`.
* For `UNIT`, we only have `mg`, `g`, `kg`, `ml`, `l`, `unit`, `units`, `serving`, `servings`, `packet`, `packets`, 
`box` and `boxes`. 
  * Default `UNIT` will be deemed as `unit` or `units` according to the value of `QUANTITY`.
  * If `QUANTITY` added is more than 1, then the `UNIT` will automatically change to plural form such as `units`, 
  `servings`, `packets` and `boxes` if applicable.
  * If `QUANTITY` added is 1, then the `UNIT` will automatically change to singular form such as `unit`, `serving`,
  `packet` and `box` if applicable.

Examples of usage:

Input 1: `add -n milk -e 21/03/2025 -c dairy -q 10 -u packets`

Output 1: 

(The product is added on 06/04/2023, thus it shows 715 days left. The display of remaining freshness date will vary,
based on your current date)
```
______________________________
milk (fresh) 
       Expiry date: 21/03/2025 (715 days left)
       Category: dairy
       Remaining quantity: 10.0 packets

I have added this product! :)
______________________________
```

Input 2: `add -n mike's milk -e 21/03/2025 -c da,iry -q 10 -u pac^kets`
* Parameter cannot contain any punctuation such as `mike's milk` as a parameter
for the flag `-n`, `da,iry` and `pac^kets`.

Output 2:

```
______________________________
Oops! Incorrect command format. Type 'help' to see more!!
______________________________

```

Input 3: `add -n bread -e 11/11/2023 -q 2 -u box`

Output 3:

* `QUANTITY` of `bread` is more than 1
* Unit of `bread` is `boxes` instead of `box` which is the value of `UNIT`.

```
______________________________
bread (fresh) 
       Expiry date: 11/11/2023 (218 days left)
       Category: others
       Remaining quantity: 2.0 boxes

I have added this product! :)
______________________________
```

### Listing all food products

`list` - List all food products available in the tracker.
* Maximum number of food products in the list is 9999.
* Any extraneous parameters input after the command `list` will be ignored.

  (e.g. `list 123 abcde` will still work as `list`)

- The list is sorted in order of the expiry dates, regardless of the order of food that is added.
- All food products will be listed with its index, name, freshness, expiry date, number of days left / expired,
category and quantity together with its units.
- Food products without any quantity added or with its quantity as `0.0` will be listed with its index, name, freshness, 
expiry date, number of days left / expired and category.

  - Number of days left will decrease as the day passed by.
  - Number of days expired will increase as the day passed by.
  - Freshness of food will be `(fresh)` if its expiry date is after today (number of days left > 0).
  - Freshness of food will be `(expired)` if its expiry date is today and before today (number of days left <= 0).

Format: `list`

Example of usage:

(Number of days depends on today's date: 07/04/2023)

Input: `list`

Output:
```
______________________________
Below are the food list: 
1. Blueberry (expired) 
       Expiry date: 03/04/2023 (expired 4 days)
       Category: fruit
       Remaining quantity: 2.0 boxes
2. strawberry (fresh) 
       Expiry date: 08/04/2023 (1 days left)
       Category: others
       Remaining quantity: 1.0 box
3. bread (fresh) 
       Expiry date: 14/04/2023 (7 days left)
       Category: others
       Remaining quantity: 0.0 unit
4. Blueberry Yogurt (fresh) 
       Expiry date: 23/04/2023 (16 days left)
       Category: dairy
       Remaining quantity: 1.0 packet

You now have 4 food products in your lists.
______________________________
```

### Removing a food product

`remove` - Remove a food product from the list based on its index.

Format: `remove INDEX`

* Deletes the food according to its `INDEX` in the list.
* `INDEX` must be represented by an integer `i.e. 1, 2, 3`
  * `INDEX` will result in an error message if it is input as a `String` or `Double`.
* Out-of-bounds `INDEX` will result in an error message.

Example of usage:

Input: <code>remove 1</code>

Output:
```
______________________________
Removed 'milk' from the food supply list.
There is/are now 1 item(s) in the list.
______________________________
```

### Finding food products by name

`find` - List all food product with matching name.

Format: <code>find FOOD_NAME {--fresh} {--expired}</code>
or 
Format: <code>find {--fresh} {--expired}</code>
- The search is not case-sensitive.
  - E.g. eggs will match Eggs
- Only full words will be matched.
  - E.g. Egg will not match Eggs
- Item matching at least one keyword will be returned.
  - E.g. Blueberry will return Blueberry Yogurt, Blueberry
- Adding the filter <code>-fresh</code> would list only the unexpired food products.
- Adding the filter <code>-expired</code> would list only the expired food products.

Example of Usage:

(Number of days depends on today's date: 07/04/2023)

Input 1: `find blueberry`


Output 1:
```
______________________________
1. Blueberry (expired) 
       Expiry date: 03/04/2023 (expired 4 days)
       Category: fruit
       Remaining quantity: 2.0 boxes
2. Blueberry Yogurt (fresh) 
       Expiry date: 23/04/2023 (16 days left)
       Category: dairy
       Remaining quantity: 1.0 packet

Found 2 of food items
______________________________
```

Input 2: `find --expired`

Output 2:
```
______________________________
1. Blueberry (expired) 
       Expiry date: 03/04/2023 (expired 4 days)
       Category: fruit
       Remaining quantity: 2.0 boxes

Found 1 of food items
______________________________
```

Input 3: `find blueberry --fresh`

Output 3:
```
______________________________
1. Blueberry Yogurt (fresh) 
       Expiry date: 23/04/2023 (16 days left)
       Category: dairy
       Remaining quantity: 1.0 packet

Found 1 of food items
______________________________
```

### Updating food products by index

`update` - Change any attribute based on the index in the list.

* Multiple attributes can be changed at once by appending the identifier at the back.
* `--u` can be edited individually if its quantity is more than 0.0
* quantity `--q` can be added and edited even if it currently does not have any quantity.
* quantity `--q` and unit `--u` can be added and edited at the same time.
* When only quantity `--q` is edited by the user, the unit will be edited automatically according to the quantity.
  * refer to example of usage Input 3 and Output 3
* Please take note that if **the food quantity is zero**, even if unit is changed, 
the message will not display the quantity and unit

Example of Usage:

Input 1: <code>update 2 --q 10</code>

Output 1:

* Before `update` command:
```
______________________________
2. strawberry (fresh) 
       Expiry date: 08/04/2023 (1 days left)
       Category: others
       Remaining quantity: 20.0 boxes
______________________________
```

* After `update` command:
```
______________________________
Updated food item successfully! 
strawberry (fresh) 
       Expiry date: 08/04/2023 (1 days left)
       Category: others
       Remaining quantity: 10.0 boxes
______________________________
```

Input 2: `update 2 --u packets`

Output 2:

* Before `update` command:
```
______________________________
2. strawberry (fresh) 
       Expiry date: 08/04/2023 (1 days left)
       Category: others
       Remaining quantity: 10.0 boxes
______________________________
```
* After `update` command:
```
______________________________
Updated food item successfully! 
strawberry (fresh) 
       Expiry date: 08/04/2023 (1 days left)
       Category: others
       Remaining quantity: 10.0 packets
______________________________
```

Input 3: `update 2 --q 1 --u boxes`

Output 3:

* Before `update` command:
```
______________________________
2. strawberry (fresh) 
       Expiry date: 08/04/2023 (1 days left)
       Category: others
       Remaining quantity: 10.0 packets
______________________________
```

* After `update` command:
  * Quantity of `strawberry` is 1. 
  * Unit of `strawberry` is `box` instead of `boxes` (user command). 
```
______________________________
Updated food item successfully! 
strawberry (fresh) 
       Expiry date: 08/04/2023 (1 days left)
       Category: others
       Remaining quantity: 1.0 box
______________________________
```

### Clearing the food list
`clear` - This command will clear the entire food list.
* Any extraneous parameters input after the command `clear` will be ignored.
  
  (e.g. `clear 123 abcde` will still work as `clear`)

Output:

```
______________________________
Clearing the food list as requested...
______________________________
```

### Exiting FSP
`exit` - This command will save the food list in an external file before closing the program.
* Any extraneous parameters input after the command `exit` will be ignored.

  (e.g. `exit 123 abcde` will still work as `exit`)

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
* Add - `add -n FOOD_NAME -e DD/MM/YYYY {-c CAT -q QUANTITY -u UNIT}`
  * All possible add command format:
    * e.g. `add -n Red Mill Granola -e 20/05/2025`
    * e.g. `add -n Red Mill Granola -e 20/05/2025 -c others`
    * e.g. `add -n Red Mill Granola -e 20/05/2025 -q 10`
    * e.g. `add -n Red Mill Granola -e 20/05/2025 -c others -q 10`
    * e.g. `add -n Red Mill Granola -e 20/05/2025 -q 10 -u packets`
    * e.g. `add -n Red Mill Granola -e 20/05/2025 -c others -q 10 -u packets`
* List - `list`
* Remove - `remove INDEX_NUMBER`
  * e.g. `remove 1`
* Find - `find KEYWORD {--fresh} {--expired}`
  * e.g. `find egg`, `find egg --fresh`, `find --expired`
* Update - `update INDEX --filter UPDATED_VALUE`
  * e.g. `update 2 --q 1`, `update 2 --q 1 --u packet`
* Clear - `clear`
* exit - `exit`

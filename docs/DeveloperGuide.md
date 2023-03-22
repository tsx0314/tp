# Developer Guide

# Find feature


## Design & implementation

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



## Product scope
Currently, the following functionality was implemented:

`find {product_name}`

`find {product_name} -fresh`

`find {product_name} -expired`

The next possible flag to implement will be `-c` which stands for `categories`
[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/eBBSArda)
# Inventory Management System

## Objective
Build a Java program to manage an inventory file. Users should be able to add new items or update the counts of existing items using Java I/O and file handling.


## File Format
The inventory is stored in a file named `inventory.txt`. Each line in the file represents an inventory item in the following format:

```
item_name,item_count
```

### Example:
```
apple,10
banana,5
orange,8
```

## Requirements

1. **Read Inventory**  
   The program should read the contents of `inventory.txt` and display all items to the user.

2. **Add New Items**  
   If an item does not exist in the inventory, allow the user to add it with a specified count.

3. **Update Existing Items**  
   If an item already exists, allow the user to update its count.

4. **File Handling**  
   - Ensure the `inventory.txt` file is updated after each operation.
   - If the file does not exist, create it.


## Tasks

1. This GitHub repository will be accessible to you once you accept the Playground Challenge.
2. You have to work directly in this GitHub repository. It is like your own copy of the original repository.

3. The folder structure is as given below:
   ```
   src
   ├── inventory.txt
   └── InventoryManager.java
   ```

4. The starter files in the `src` folder include:
   - `InventoryManager.java` (Starter code with method stubs)
   - `inventory.txt` (Initial inventory data - can be empty)


5. Implement the following functionalities in `InventoryManager.java`:
   - Reading and displaying inventory.
   - Adding new items.
   - Updating existing items.
6. To work on the files, you can clone this GitHub repository onto your system and then open it with an IDE like IntelliJ, or Eclipse.
7. Test your implementation thoroughly.
8. Once done, push your changes to this remote GitHub repository.


## Submission Guidelines

1. After completing the challenge and developing the solution code in your system, commit and push the changes to this repository. 
    - Stage your changes and commit the files:
      ```
      git add .
      git commit -m "Completed playground challenge"
      ```
    - Push your changes to the GitHub repository:
      ```
      git push
      ```
2. Ensure your code is properly documented and follows Java conventions.


## Evaluation

Your solution will be evaluated on the following criteria:

1. Correctness: All functionalities work as described.
2. Code Quality: Clean and well-documented code.
3. File Handling: Proper management of `inventory.txt`.
4. Edge Cases: Handles errors gracefully (e.g., file not found, invalid input).


Good luck, and happy coding!

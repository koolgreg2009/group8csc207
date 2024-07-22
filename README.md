# Pet Adoption Website

## Contributors
* [Alex Lambermon](https://github.com/lamberm2)
* [Jane Li](https://github.com/snowykitkat)
* [Jenny Yang](https://github.com/yangje02)
* [Joy Cai](https://github.com/Joyce12345678)
* [Justin Yoon](https://github.com/justinyoon95)
* [Kevin Hu](https://github.com/koolgreg2009)

<hr>

# About
Our project is a platform that lists verified and healthy pets for adoption.
The program will act as a pet adoption site in which users are able to scroll through pets that are up for adoption. 
Users looking to use_case.adopt are able to view all pets currently available for adoption. 
Each user will be prompted to make a profile with their unique identification on the webpage, 
which they have to sign in to view the listed pets. 
Additionally, users can set preferences on their profile page and use those preferences as a filter in the search. 
The preference profile will include questions regarding the preferred pet type (i.e., dog, cat, frog, chinchilla, 
fish, hamster, etc.), size, age, and personality to help find the perfect fit for the pet and the new owner.

* This project was entirely written in Java. 
* Java Swing was used for the GUI.
* This project is strictly adhering to Clean Architecture and the SOLID design principles.

## Getting Started (For Phase 1)
1. Clone the repository.
2. You will need an IDE for Java (IntelliJ IDEA is recommended).
3. Run the project by running the `main` method in `Main.java`.
4. Since our GUI is not yet fully functional, we plan to demonstrate our use cases through terminal commands for now.
5. Terminal execution order as follows:
   1. Signup will execute twice. Test out the fail case first (where you would intentionally input incorrect repeated 
   password or sign in with an existing account information like username, for example). Then, when the second Signup
   executes, test it out properly by creating a new account.
   2. Login will execute twice. Test out the fail case first (where you would intentionally input incorrect password, 
   for example). Then, when the second login executes, test it out properly by logging in with the account you created.
   3. After you log in, the program will ask you to input your preference for the pets. (Empty string will be considered as skip).
   4. Then, the program will display available pets based on your preferences.
   5. Then, the program will again execute set preference, repeat iii. (This is a temporary feature for phase 1, just to
   demonstrate that you can change your preference anytime). Try setting up different preferences from the previous one.
   6. Then, the program will display new available pets based on your new preferences.
   7. To bookmark or remove the bookmark of the displayed pet, input the petID of the desired pet.
   8. Finally, if you would like to adopt a pet, simply input the petID (make sure to check if the pet is availble).

## Getting Started (For later)
1. Clone the repository.
2. You will need an IDE for Java (IntelliJ IDEA is recommended).
3. Run the project by running the `main` method in `Main.java`.
4. (Start guide to be updated)

## APIs Used 
* [RescueGroups.org](https://rescuegroups.org/services/adoptable-pet-data-api/): This is the Adoptable pet data API provided by Rescuegroups.org.

# Technical Problems and Notes
Since our GUI is not yet fully functional, we plan to demonstrate our use cases through terminal commands for now.



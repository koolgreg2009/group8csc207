# Pet Adoption App

### Contributors
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
Users looking to adopt are able to view all pets currently available for adoption.
Each user will be prompted to make a profile with their unique identification on the webpage,
which they have to sign in to view the listed pets.
Additionally, users can set preferences on their profile page and use those preferences as a filter in the search.
The preference profile will include questions regarding the preferred pet type (cat for now), size, age, and
location to help find the perfect fit for the pet and the new owner.
Users can view pet listings that match their preference in the home page. They can interact with pet listings through 
ways such as adding/removing pets as bookmarks, viewing additional information about the pet, and adopting the pet.

In the home page, users can navigate to the notifications page, where they can view notification messages about if 
their bookmarked pet has been adopted, the preference page where they can change their preferences, as well as the 
bookmark page, where they can view bookmarked pets as pet listings. 

* This project was entirely written in Java.
* Java Swing was used for the GUI.
* This project strictly adheres to the Clean Architecture and SOLID design principles.

## Getting Started
1. Clone the repository to your local machine.
2. You will need an IDE for Java (IntelliJ IDEA is recommended).
3. Initialize the database by emptying `users.json` and `pets.json`, locally. (Optional)
4. Run the project by running the `main` method in `Main.java`.
5. Begin by creating an account. You can do this by clicking `Sign Up`. Or, if you would like to skip user creation, you can log in using the default account. `username: johndoe` `password: apple123`
6. After filling in your information, you will be prompted to fill out your preferences for pets. You may skip this part by pressing `Save Preferences` without filling information in.
7. Now, the program will display the list of available pets, and you may adopt, or bookmark listed pets, as desired.

## APIs Used
* [RescueGroups.org](https://rescuegroups.org/services/adoptable-pet-data-api/): API that provides us adoptable pet data.
* [TheCATAPI](https://documenter.getpostman.com/view/5578104/RWgqUxxh#intro): API that returns cat breed information.

# Technical Problems and Notes
N/A (Feel free to fill it out or check currently ongoing issues)
* [Issues](https://github.com/koolgreg2009/group8csc207/issues)

# Documents
* [UML Diagram](https://lucid.app/lucidchart/5fb0ce87-45b4-4f2e-9527-57cff33bf035/edit?viewport_loc=1226%2C-948%2C4386%2C2030%2C0_0&invitationId=inv_282f4d82-22a6-4b58-b2ca-4a74da2ebeb9)
* [Flow Chart](https://lucid.app/lucidchart/d2f8b40e-59de-49e9-9eeb-e733e1e2a166/edit?invitationId=inv_4ff0dbca-a473-4dc7-8d1f-96b53d3bb54a&page=0_0#)
* [Professor Paul Gries's CA Example](https://github.com/paulgries/LoginCleanArchitecture) (Our program is inspired by Paul Gries's user/password manager program example. Thank you!)

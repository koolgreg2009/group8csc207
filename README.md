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
The preference profile will include questions regarding the preferred pet type (cat for now), size, age, and 
personality to help find the perfect fit for the pet and the new owner.

* This project was entirely written in Java. 
* Java Swing was used for the GUI.
* This project is strictly adhering to the Clean Architecture and the SOLID design principles.

## Getting Started (For Phase 1)
1. Clone the repository.
2. You will need an IDE for Java (IntelliJ IDEA is recommended).
3. Run the project by running the `main` method in `Main.java`.
4. Since our GUI is not yet fully functional, we plan to demonstrate our use cases through terminal commands for now.
5. We will execute use cases in order as follows:
   1. Signup will execute twice. Test out the fail case first (where you would intentionally input an incorrect repeated 
   password or sign in with existing account information like username, for example). Then, when the second Signup
   executes, test it out properly by creating a new account.
   2. Login will execute twice. Test out the fail case first (where you would intentionally input an incorrect password, 
   for example). Then, when the second login executes, test it out properly by logging in with the account you created.
      (Justin Use case)
   3. After you log in, the program will ask you to input your preference for the pets. (Empty string will be considered as skip). (Alex use case)
   4. Then, the program will display available pets based on the current logged-in user's preferences. (Team use case) Check the available pets below.
   5. Then, the program will again execute set preference, repeat iii. (This is a temporary feature for phase 1, just to
   demonstrate that you can change your preference anytime). Try setting up different preferences from the previous one.
   6. Then, the program will display newly available pets based on your new preferences. 
   7. To bookmark or remove the bookmark of the displayed pet, input the petID of the desired pet. (Kevin + Jane Usecase) The bookmark changes will changed and stored based on the current logged in user. 
   8. Enter pet ID to find the pet bio. (Jenny use case) 
   9. Enter cat breed to retrieve breed information from TheCATAPI. Currently returns a JSON response will parse in the future. (API call) Can enter example breeds like: "Abyssinian", "Aegean", "bengal".
   8. Finally, if you would like to adopt a pet, simply input the petID (make sure to check if the pet is available). (Team + Joy use case). Once adopted, the pet will become unavailable to other users and disappear from the viewallPets result.

Notes:
We have manually entered some sample pet data. We plan to explore adding pets in other ways in the future.
They can be found in pets.json.
{
"1": {
"owner": "jack",
"email": "gmail",
"phoneNum": "647",
"petID": 1,
"species": "Cat",
"petAge": 1,
"breed": "bengal",
"personality": ["cool"],
"gender": "male",
"activityLevel": "hyper",
"bio": "he's super cool!",
"location": "toronto",
"available": true
},
"2": {
"owner": "greg",
"email": "abcde@gmail.com",
"phoneNum": "123456670",
"petID": 2,
"species": "Cat",
"petAge": 99,
"breed": "Abyssinian",
"personality": ["eats a lot", "fat"],
"gender": "male",
"activityLevel": "Low",
"bio": "he's cool!",
"location": "chad",
"available": true
},
"3": {
"owner": "Voldemort",
"email": "dieharrypotter@hogwarts.com",
"phoneNum": "9994446666",
"petID": 5,
"species": "Snake",
"petAge": 0,
"breed": "Anaconda",
"personality": ["sociopathic", "scary", "antisocial"],
"gender": "male",
"activityLevel": "high",
"bio": "Might kill you in your sleep, or not.",
"location": "chamber of secrets",
"available": true
},
"69": {
"owner": "Oyo",
"email": "uwu@owo.ca",
"phoneNum": "1234567890",
"petID": 69,
"species": "hilichurl",
"petAge": 0,
"breed": "normal",
"personality": ["yah!"],
"gender": "male",
"activityLevel": "high",
"bio": "Muhe ye",
"location": "Teyvat",
"available": true
},
"4": {
"owner": "Gru",
"email": "stealthemoon@evil.com",
"phoneNum": "1987654321",
"petID": 4,
"species": "Minion",
"petAge": 0,
"breed": "normal",
"personality": ["round", "small", "yellow"],
"gender": "male",
"activityLevel": "high",
"bio": "Banana.",
"location": "Grus Evil Lair",
"available": true
},
"6": {
"owner": "Drizzy",
"email": "kdotsucks@ovo.ca",
"phoneNum": "6666666666",
"petID": 6,
"species": "Dog",
"petAge": 0,
"breed": "bichon",
"personality": ["high energy"],
"gender": "male",
"activityLevel": "high",
"bio": "Kendrick Lamar sucks ngl",
"location": "Toronto",
"available": true
},
"7": {
"owner": "Oyo",
"email": "uwu@owo.ca",
"phoneNum": "1234567890",
"petID": 69,
"species": "hilichurl",
"petAge": 0,
"breed": "normal",
"personality": ["yah!"],
"gender": "male",
"activityLevel": "high",
"bio": "Muhe ye",
"location": "Teyvat",
"available": true
}
}

Users can be stored in users.json through the signup use case.

An RI for all use cases is that the input petID must exist in pets.json. This is because when we later introduce the view,
all arguments passed to the controller will be from the list of available pets.

## Getting Started (For later)
1. Clone the repository.
2. You will need an IDE for Java (IntelliJ IDEA is recommended).
3. Run the project by running the `main` method in `Main.java`.
4. (Start guide to be updated)

## APIs Used 
* [TheCATAPI](https://documenter.getpostman.com/view/5578104/RWgqUxxh#intro): API that returns cat information.

# Technical Problems and Notes
Since our GUI is not yet fully functional, we plan to demonstrate our use cases through terminal commands for now.



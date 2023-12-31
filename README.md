# TechnoSignia
This repo contains the tasks related with intern at TechnoSignia
Spring Boot CRUD Application
Project Overview:
This Spring Boot project implements a simple CRUD (Create, Read, Update, Delete) functionality for three modules: User, Hotel, and Rating. The system allows for the management of user information, hotel details, and user ratings for hotels.

Key Features:
User Module:

Attributes: User ID, Username, Email, Mobile, Address, Role (admin, regular user).
CRUD operations for managing user information.
Endpoint to retrieve the list of users.
Hotel Module:

Attributes: Hotel ID, Hotel Name, Address, Contact Information, Number of Rooms, Amenities, Rating.
CRUD operations for managing hotel details.
Endpoint to retrieve the list of hotels.
Rating Module:

Attributes: Rating ID, User ID (who gave the rating), Hotel ID (for which the rating is given), Rating Value (1 to 5 stars), Comments/Feedback, Date of Rating.
CRUD operations for managing user ratings.
Endpoint to retrieve the list of ratings.
Specific endpoint to retrieve ratings for a given hotel, including details such as rating ID, user ID, rating value, comments, and date of rating.
Technologies Used:
Spring Boot
Java
RESTful API
How to Run:
Clone the repository.
Open the project in your preferred IDE.
Run the Spring Boot application.
Access the API endpoints using a tool like Postman or any web browser.
Contributions:
Contributions and improvements to the project are welcome. Feel free to fork the repository and submit a pull request.

Future Enhancements:
Implementing authentication and authorization for user roles.
Adding validation for input data.
Enhancing error handling.
Project Status:
This project is actively maintained and open to contributions.

Contact Information:
Feel free to contact me for any questions or collaboration opportunities.

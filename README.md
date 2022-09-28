## TMS - Your trip management system
This is a minimal web application for managing trips and flights all in one place.

### Spring Security
* User roles, permissions and privileges are **dynamically assigned**.
* Sessions are **stateless**, JWT is used for authorizing requests.
* Endpoints are **authenticated** and requests must bear the **JWT** to succeed.
* HTTP requests are filtered by **SecurityFilterChain** middleware.
* App is protected against attacks like **Cross-Site Request Forgery.**
* Passwords are salted and hashed using **BCrypt** one-way hashing function.

### Swagger UI
Automatically generated OpenAPI specification to visualize and interact with the API’s 
resources without having any of the implementation logic in place.

### Logging using SJF4J
Log errors and exceptional states to console using SLF4J
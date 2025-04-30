# CapitalCities-API-App
This application demonstrates the use of AsyncTask to asynchronously fetch data from a remote REST API, parse the JSON response, and display the results to the user.
# Project Overview:
The app sends a GET request to a remote REST API which returns a list of capital cities in JSON format. Each capital city object contains the following data:
name – Name of the capital city
country – Country the capital belongs to
num_residents – Number of residents
size – Area size of the city (e.g., in km²)
major – Name of the current mayor or primary official

The JSON response is parsed into Java domain objects (CapitalCity class), and the data is displayed in the user interface.

# Features:
Sends HTTP GET request to a REST API endpoint
Receives a JSON list of capital cities
Parses JSON into Java objects
Displays city data in the UI
Uses AsyncTask for background processing
Uses Handler to safely transfer data between threads
Clear separation of concerns (Api class handles API communication)

# Note
Make sure your API is hosted and publicly accessible, and returns data in the expected JSON format.


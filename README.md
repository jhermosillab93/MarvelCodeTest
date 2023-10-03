# MarvelCodeTestApplication

# Definition

This project is just a list of Marvel superheroes that shows some of their info if one of them is clicked.
UI design has been kept basic, while most of the effort has been put into following MVVM/Clean principles and applying correct usage of Dagger injections and other libraries


## Architecture

This app is built following MVVM with Clean architecture.

There are two main modules within the project, one for the app, and another one that allows it to connect to a Marvel Public Api.

Two different build variants have been implemented:
    -Development: A standard build variant, connected to Marvel API
    -Demo: This variant gets data from a mocked repository with demo data. Neccesary to run UI tests

Remote information is only fetched once when loading the characters list. Then, all data is stored an accessed locally 


## API Key storage

Marvel API requires a public key and a private key in order to validate requests and return proper information. They can be found in the build.gradle file inside MarvelBusinessApi named as following:

    -PUBLIC_KEY

    -PRIVATE_KEY

## Testing

### UI Testing

A simple UI Test has been included in the project in order to confirm the proper behaviour of its toolbar. IT IS NEEDED TO SELECT DEMO BUILD VARIANT AFTER RUNNING IT

### Unit Testing

A basic unit test is also included. It was developed to try the function that obtains character thumbnail images from the object that Marvel API returns

### Other information

Glide has been used to load images into its corresponding views


# practice-creator-application
An app that allows you to create a yoga class based on your preferences.
It uses the internal H2 database to work.

This app can be used in conjunction with the practice-creator-ui application which provides the Angular front-end UI for this app.

# How to install
Clone the repository and install the application using
`mvn clean install`

# First time setup
The app is configured to use the persistent H2 DB, but the first time set up might require you to load the pre-set posture list from the csv file provided
_static/postures_master.csv_

Do the following:
1. Uncomment the DB scripts in data_bkup.sql
2. Rename data_bkup.sql to data.sql
3. Start the application by running the PracticeCreatorApplication
4. This will bring up the h2 DB and insert the predefined postures into the H2 DB
5. Stop the application
6. Comment the DB scripts in the file - data.sql
7. Rename the data.sql file to data_bkup.sql
9. Start the application by running the PracticeCreatorApplication

This will ensure that any subsequent additions to the DB will be updated and the DB will not be created afresh with each application start.

# Popup Chinese Mobile Application Backend

A Vue.js Application for learning the Chinese Language

# Introduction

Here you can find the popup-chinese backend based on Spring Boot, Spring Data JPA, Hibernate, Spring Security and Okta.

# Installation

To run the backend successfully on heroku:

1. Configure Okta in application.yml

    ```bash
    okta:  
      oauth2:  
        issuer: ${OKTA_ISSUER}
        client-id: ${OKTA_CLIENT_ID}
        scope: openid profile email
    ```

2. Set Okta environment variables as heroku config vars

    ```bash
    heroku config:set OKTA_ISSUER=https://{yourOktaDomain}.okta.com/oauth2/default
    heroku config:set OKTA_CLIENT_ID={yourOktaClientId}
    ```
3. Set your PostgreSQL DATABASE_URL config var in heroku
    
    ```bash
    heroku config:set DATABASE_URL=postgres://{username}:{password}@{databaseServer}:{port}/{database}
    ```

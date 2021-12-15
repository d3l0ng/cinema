# running
set env variable with run parameters: omdb.token=[token]

login in browser on http://localhost:8080/swagger-ui/index.html with e.g.
username: user
password: user123


# choices
* technical
    * spring boot application (data for persistence layer, security for roles, web for rest, feign for omdb API) with lombok
    * h2 as in-memory database
    * spock for testing
    * swagger for api docs
* requirements
    * two endpoints
        * one for users (fetching movie details, screenings, providing feedback)
        * one for admins (can use also users one, fetching feedback, providing screenings)

# potential prod follow-ups
* TODOs in code
* testing
    * expand on testing, especially on main use cases
* rest
    * add handlers for e.g. bad request, handler not found etc.
    * expand on input validation
* security
    * load authorized users from DB / service / LDAP
    * use JWT
* persistence
    * replace H2 with 'normal' DB

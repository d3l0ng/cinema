# cinema
Using NoSql as we can potentially integrate with many movie systems, thus having lots of different schemas.
For the data we would like to have complex queries I would advise creating data lake/some warehouse with SQL engine of choice.

# running
set env variable with run parameters: omdb.token=[token]
login in browser on http://localhost:8080/swagger-ui/index.html with e.g. 
  username: u
  password: u
use swagger for endpoints


# follow-ups
* TODOs in code
* testing
  * expand on testing, especially on main use cases 
* rest
  * add handlers for e.g. bad request, handler not found etc.
* security
  * load authorized users from DB / service / LDAP
  * use JWT
* persistence
  * replace H2 with 'normal' DB

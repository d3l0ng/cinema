# cinema
Using NoSql as we can potentially integrate with many movie systems, thus having lots of different schemas.
For the data we would like to have complex queries I would advise creating data lake/some warehouse with SQL engine of choice.

# running
run params example: omdbi.token=e4f33820
set env variable: omdb.token=[token]
to login in browser on http://localhost:8080/swagger-ui/index.html provide 
username: u
password: u



# follow-up
* security
  * load authorized users from DB / service / LDAP
  * use JWT
* persistence
  * replace H2 with 'normal' DB
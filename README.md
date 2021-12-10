# cinema
Using NoSql as we can potentially integrate with many movie systems, thus having lots of different schemas.
For the data we would like to have complex queries I would advise creating data lake/some warehouse with SQL engine of choice.

# running
run params example: omdbi.token=e4f33820;dbFilePath=D:\code\cinema\db
set env variable: omdb.token=[token]
to login in browser on localhost:8080 provide 
username: user
password: [generated visible in application logs: 'Using generated security password']


# follow-up
* security
  * load authorized users from DB / service / LDAP
  * use JWT
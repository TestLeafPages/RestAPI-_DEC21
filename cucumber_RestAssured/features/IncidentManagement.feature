Feature: IncidentManagement

Scenario: Create a new Incident

#Given set the endpoint
#And  set up the basic auth with valid credential
When send the post request
Then verify the status code as 201
And  verify the response body contains contentType as 'Json'

Scenario Outline: Create a new Incident with 2 set of data

#Given set the endpoint
#And  set up the basic auth with valid credential
When send the post request with body as '<short_des>' and '<category>'
Then verify the status code as 201
And  verify the response body contains contentType as 'Json'

Examples:
# rows & column
|short_des|category|
# 1 row
|Create incident with body data 1|software|
# 2 row
|Create incident with body data 2|hardware|





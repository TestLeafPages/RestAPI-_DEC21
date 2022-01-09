Feature: IncidentManagement

Scenario: update a new incident with body

Given url 'https://dev113226.service-now.com/api/now/table/incident/190916bf1b7c01106faa2134604bcbbd'
And header Authorization = 'Basic YWRtaW46VHVuYUAxMjM='
And param sysparm_fields = 'number,sys_id,category,short_description'
#And request {"short_description": "Created using katate", "category": "hardware" }
And header Content-Type = 'application/json'
And request karate.readAsString('data/CreateIncident1.json')
When method put
Then status 200
And match responseType == 'json'
And match response.result.short_description == 'update incident with body json as file'
And print response

Scenario: create a new incident without body

Given url 'https://dev113226.service-now.com/api/now/table/incident'
And header Authorization = 'Basic YWRtaW46VHVuYUAxMjM='
And param sysparm_fields = 'number,sys_id,category,short_description'
And request {}
When method post
Then status 201
And match responseType == 'json'
And print response
And def sysID = response.result.sys_id

Given url 'https://dev113226.service-now.com/api/now/table/incident/'+sysID
When method delete
Then status 204
And print response











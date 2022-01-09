Feature: IncidentManagement

Scenario: Get All Incident

# Set Endpoint
Given url 'https://dev113226.service-now.com/api/now/table/incident'
# Set Authorization
And header Authorization = 'Basic YWRtaW46VHVuYUAxMjM='
And header accept = 'application/xml'
# add query param
And param sysparm_fields = 'number,sys_id,category,short_description'
# send request method
When method get
Then status 200
And match responseType == 'xml'
# print response
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

Scenario: create a new incident with body

Given url 'https://dev113226.service-now.com/api/now/table/incident'
And header Authorization = 'Basic YWRtaW46VHVuYUAxMjM='
And param sysparm_fields = 'number,sys_id,category,short_description'
#And request {"short_description": "Created using katate", "category": "hardware" }
And header Content-Type = 'application/json'
And request karate.readAsString('data/CreateIncident1.json')
When method post
Then status 201
And match responseType == 'json'
And match response.result.short_description == 'create incident with body json as file'
And print response
















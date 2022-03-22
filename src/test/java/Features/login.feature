Feature: Login into QaAcademy
Scenario Outline: Positive test validating login
Given Initialize the browser with chrome
When Land on the "http://www.qaclickacademy.com/"
Then click on the login link <username> and <password>


Examples:

|username		|password	|
|nav@gmail.com	|nav123		|
|test99@gmail.com|123456	|

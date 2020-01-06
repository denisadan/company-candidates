# Company- Employees

The Candidate class is characterized by a full name, an integer indicating the level of competence and a string representing the name of the department for which the candidate chooses to be employed. 

Implement a constructor for this class to initialize these attributes and overide also the toString method.

Class Company has a name and contains a list of candidates. A company has at least 2 departments: Marketing and Production.
Each departament has an attribute of integer type representing the minimum value of the level of competencies required for a candidate to be admitted to that department.

The 2 departments implement the Evaluator interface which contains the evaluate() method that, for a candidate received as a parameter changes the candidate's status, in Rejected/Accepted.
Initially, each candidate is assumed to be in Awaiting for a response mode. 
A candidate who has at least the level of competence required by the department he applied for, is considered accepted, otherwise rejected.

The class Company has a method called recruiting() which, on a candidate received as a parameter, delegates it to be evaluated by the department for which it is applying. If a department receives for evaluation a candidate who has not opted for that department, the exception of the type EvaluationIncapacityException is thrown, together with a specific message.

Don't allow a more than 2 deps, one Marketing, one Production. 
Add a number of vacant places on each departament and when after that number fills in, inform the user that.
The proportion of male and females in the marketing department must not be more than 40-60%.
The production department must have at least 20% of employees having the maximum required score.
If there are more candidates than open positions on a dept, make sure you choose them based on this conditions also. 

- Create a main class to test each of the scenarios above.
- Save the result to a file
- Create a method that lets you read and write the candidates from/to a file (.json) - https://www.baeldung.com/jackson-object-mapper-tutorial
- Send an email with the report  (https://dzone.com/articles/sending-mail-using-javamail-api-for-gmail-server)

<h2>How do we write User Stories?</h2>
There are 2 parts to writing User Stories:
1) User Story Statement
2) Acceptance Criteria



<h2>User Story Statement</h2>
**Format**:
As a **[user role]** 
I want **[feature]** 
so that **[benefit]**

When entering stories into JIRA, use the **[user role]** and **[feature]** to create the Title (Summary).

**Title:** A **[user role]** can **[feature]**

**Sample User Story**
Title: A User can log in
As a User
I want to log in
So that I can manage my account

<h2>Acceptance Criteria</h2>
- The acceptance criteria are expectations and characteristics that will determine whether the feature is complete or “done”.
- Acceptance criteria scenarios are written in a Given/When/Then format (originating from the Gherkin language used in Cucumber testing software)

**Format**:
**[Scenario Description (Acceptance Criteria)]**
Given some **[precondition]** 
When I perform some **[action]** 
Then **[result]**

**Sample User Story with Acceptance Criteria**
Title: A User can log in
As a User
I want to log in
So that I can manage my account

Acceptance Criteria:
Description: Valid credentials allow the user to log in
Given a user is on the log in page
When they enter a valid username and password
Then they are taken to the Home page

Description: Invalid credentials present the user with an error
Given a user is on the log in page
When they enter an invalid username or password
Then they are presented with an error message


![](.guides/img/JIRA_example.png)


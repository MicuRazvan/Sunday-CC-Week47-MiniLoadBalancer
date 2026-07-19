# Sunday CC Week47 Mini Load Balancer

## Context
I lost a bet with a friend and he challenged me that for the next 52 weeks, during weekends I need to create from scratch a new project.

For this week, we decided to build a load balancer. I'm allowed to work on it only Sunday.

## The rules are the following:
*   Each Friday night, me and him will talk about what project I need to do.
*   Mostly he will decide for me, but I’m allowed to suggest and do my own ideas if he agrees on them.
*   Once the project is decided, he will tell me if I’m allowed to work Saturday and Sunday, or only Sunday.
(Surely this won’t backfire at some point by underestimating a project, right? 😅)

Missed weeks: Week28, Week36

## About the project
Created a load balancer that allows the user to create "active users" and for every "active user", a REST request will be sent to the server every second. For every request, we will split the writings in 3 DBs.
In 2 of them we will write 1 by 1 while on 3rd one we write only the specific condition is meet, to simply it, the current condition is just a 1/10 chance.
The users can check live how the writes happen for every database.


#### How to run:
1.  Compile and run the Spring Boot application.
2.  Open your browser and navigate to `http://localhost:8080`.

<img width="1488" height="478" alt="image" src="https://github.com/user-attachments/assets/9b2a7057-bc5c-41ef-a4ed-e9e1af6b585a" />





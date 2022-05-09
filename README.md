# coding-challenge
Write Http endpoint API to manage customers and addresses

Business Requirements
customer contains document id, name, age, registration date, last update info and one or more addresses
addresses contains zip code, number and it can belong to one or more customers

We should be able to insert, update, delete and query customers along with their dependencies
We should be able to query customers by zip code

Assumptions
- document id from customer is unique;
- supports more than one customer by address
- one customer can have more than one address
- zip code must have a mask 99999-999  

Technical Spec
Write a standalone Java Application exposing either rest or graphql API
Use ORM implementation as persistency
It must be written in Java8 or higher

Delivery
Preferable to post the code in a public/shared repository such github

spring-webflow-tutorial
=======================
Not finished, missing tests and docs.

Simple Stateful web based application to add and remove accounts and addresses, an account is link with one or more addresses. 

The technologies used are Spring Web Flow, Spring core, Spring JS, with an HQL database.

It’s a simple web application, the features are:
- Create/edit/remove/list an account
- Field validators
- Link an account with one or more address
- Research an address, the research is available on each column of the address, it's a generic part, add a column in the entity and you don't have to change this part

URL access: http://localhost:8080/account/

Another project, a simple Stateless web based app using Spring RESTful, Spring Integration, Long Polling (DeferredResult with Spring 3.2): https://github.com/ebrigand/RSSLiker
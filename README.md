# [Billing Service](https://github.com/charles-arnesus/billing_service)

Purpose
---
This is main service for Billing Payment Application. It handles 
* Bill inquiry
* Bill payment
* Bill history
* Biller listing 

## Running the application
These are the steps to run the application:
* run ``docker-compose up``
These command will run Database, Redis, and all the services related:
    * [Billing Discovery Server](https://github.com/charles-arnesus/billing_discovery_server)
    * [Billing History Service](https://github.com/charles-arnesus/billing_history_service)
    * [Billing Postpaid Client](https://github.com/charles-arnesus/billing_postpaid_client)
    * [Billing PDAM Client](https://github.com/charles-arnesus/billing_pdam_client)
* To see the Swagger page, go to [localhost:8081/swagger-ui/](http://localhost:8081/swagger-ui/)


## Notes
1. As for now, the supported category for the biller are only:
    * pdam
    * postpaid
2. User id is only limited to `userid`
3. As for now, these are the only customer account id and biller id that can be use for each category:
    * pdam:
        * customer account id: ``112233``
        * biller id: ``pdam_bandung``
    * postpaid
        * customer account id: ``08123456789``
        * biller id: ``halo``

## Laundry List
* Add Authentication to the application
* Add User feature
* Add more bill for each category
* Unit Test
* Error Handling
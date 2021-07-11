# Serenity practice demo

- Web testing demo
- Mobile testing demo
- Api testing demo

## Running with remote driver


## Test cases

`docker-compose up`

`mvn verify -Dwebdriver.remote.url=http://localhost:4444/wd/hub -Dwebdriver.remote.driver=chrome`

- Web 

`src/test/java/features/booking/BookingStory.java`
`src/test/java/features/login/LoginStory.java`
`src/test/java/features/order/OrderTrackingStory.java`

- Mobile

`src/test/java/features/calculate/CalculateStory.java`


## Reporting
`mvn serenity:aggregate`
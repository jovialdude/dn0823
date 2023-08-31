This is your typical POS system.

It assumes you have a couple tools handy:
    -You are a human.
    -You have access to Intellij.
    -CMD/Terminal/Postman

If you have the handy tools above, build and run Main and Application.

Use CMD/Terminal/Postman to make an HTTP request to
    
    http://localhost:8080/getAgreement?code=JAKR&date=09/03/15&days=5&discount=101
        Expect a 400
    
    http://localhost:8080/getAgreement?code=LADW&date=07/02/20&numDays=3&discount=10

    http://localhost:8080/getAgreement?code=CHNS&date=07/02/15&days=5&discount=25

    http://localhost:8080/getAgreement?code=JAKD&date=09/03/15&days=6&discount=0

    http://localhost:8080/getAgreement?code=JAKR&date=07/02/15&days=9&discount=0
    
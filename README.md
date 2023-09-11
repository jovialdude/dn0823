This is your typical POS system.

It assumes you have a couple tools handy:
    -You have access to Intellij.
    -CMD/Terminal/Postman

If you have the handy tools above, build and run Main and Application.

Use CMD/Terminal/Postman to make an HTTP request to
    
    http://localhost:8989/getAgreement?code=JAKR&date=09/03/15&duration=5&discount=101
        Expect a 404
    
    http://localhost:8989/getAgreement?code=LADW&date=07/02/20&duration=3&discount=10

    http://localhost:8989/getAgreement?code=CHNS&date=07/02/15&duration=5&discount=25

    http://localhost:8989/getAgreement?code=JAKD&date=09/03/15&duration=6&discount=0

    http://localhost:8989/getAgreement?code=JAKR&date=07/02/15&duration=9&discount=0
    

Improvements:
    Shifting to XML contract base objects will make the records are consistent.
    Database will be created with OracleSQL to fetch consistently written data.
    Visual UI will probably not need but request readability will make it easier to write further request.
    Our users are probably programmers or text oriented people.
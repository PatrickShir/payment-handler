# payment-service

Produces output:
```
--- BUNDLE STARTED! ---
Account: 55555555555555
Date: Tue Mar 15 00:00:00 CET 2011
Currency: SEK
--- INCOMING PAYMENT! ---
Amount: 3000
Reference: 1234567890
--- INCOMING PAYMENT! ---
Amount: 1000
Reference: 2345678901
--- INCOMING PAYMENT! ---
Amount: 300.10
Reference: 3456789012
--- INCOMING PAYMENT! ---
Amount: 400.07
Reference: 4567890123
--- BUNDLE FINISHED! ---
Account created: Account{postType='O', accountNumber='55555555555555', sum=4711.17, quantity=4, date=Tue Mar 15 00:00:00 CET 2011, currency='SEK', payments=[Payment{postType='B', amount=3000, reference='1234567890'}, Payment{postType='B', amount=1000, reference='2345678901'}, Payment{postType='B', amount=300.10, reference='3456789012'}, Payment{postType='B', amount=400.07, reference='4567890123'}]}
--- BUNDLE STARTED! ---
Account: 12341234567897
Date: null
Currency: SEK
--- INCOMING PAYMENT! ---
Amount: 400000
Reference: 9876543210
--- INCOMING PAYMENT! ---
Amount: 100000
Reference: 9876543210
--- INCOMING PAYMENT! ---
Amount: 1030000
Reference: 9876543210
--- BUNDLE FINISHED! ---
Account created: Account{postType='00', accountNumber='12341234567897', sum=1530000, quantity=3, date=null, currency='SEK', payments=[Payment{postType='30', amount=400000, reference='9876543210'}, Payment{postType='30', amount=100000, reference='9876543210'}, Payment{postType='30', amount=1030000, reference='9876543210'}]}
```

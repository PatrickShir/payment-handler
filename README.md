# Payment-Handler by Patrick Shir

An example output should look something like:
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
Account created: Account{id='559a7f9b-619a-4c97-b53b-cc5196e0c908', accountNumber='55555555555555', sum=4711.17, quantity=4, date=Tue Mar 15 00:00:00 CET 2011, currency='SEK', payments=[Payment{id='99401f74-60f1-4a53-8dfd-c83acd7869c8', amount=3000, reference='1234567890'}, Payment{id='d962b73e-d399-4464-ae03-07c9a59bc64d', amount=1000, reference='2345678901'}, Payment{id='9844ba38-8972-413c-a7c5-5efae49cdd3a', amount=300.10, reference='3456789012'}, Payment{id='2c501b6f-1e87-4a27-9e8d-54a7507c5129', amount=400.07, reference='4567890123'}]}
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
Account created: Account{id='3e4e149d-0175-46b7-a050-7cfe93792213', accountNumber='12341234567897', sum=1530000, quantity=3, date=null, currency='SEK', payments=[Payment{id='98576db0-390d-4665-842b-e17ec159907c', amount=400000, reference='9876543210'}, Payment{id='ceba15ba-6ea3-43d3-bf8f-c1cb51a02ab1', amount=100000, reference='9876543210'}, Payment{id='bf2484b1-3407-4364-a5e9-215402ff2db9', amount=1030000, reference='9876543210'}]}
```

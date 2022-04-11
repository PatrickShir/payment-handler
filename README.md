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
Account created: Account{id='867b8e90-bbb4-4192-8478-d01180fde7d7', accountNumber='55555555555555', totalCash=4711.17, amountOfTransactions=4, date=Tue Mar 15 00:00:00 CET 2011, currency='SEK', payments=[Payment{id='dfa95e84-13c5-4e62-99e7-356129b0b4e5', amount=3000, reference='1234567890'}, Payment{id='b3833da7-c035-4147-ba34-37e89ab155a1', amount=1000, reference='2345678901'}, Payment{id='3a0daddf-c12a-4bb5-a7b0-bbd6439c1e6a', amount=300.10, reference='3456789012'}, Payment{id='3b27e3f2-f2b8-4f53-8bd2-7a924f2ffc26', amount=400.07, reference='4567890123'}]}
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
Account created: Account{id='28421f9e-5266-4d05-8931-fe7a59c1c2c8', accountNumber='12341234567897', totalCash=1530000, amountOfTransactions=3, date=null, currency='SEK', payments=[Payment{id='4a9ec8fc-ac49-49cf-b656-968b6a1a794e', amount=400000, reference='9876543210'}, Payment{id='fed40446-e450-4e0c-a1e6-d6297e1bfb01', amount=100000, reference='9876543210'}, Payment{id='00744e56-f350-4bd7-8016-8ae96a0d8cb3', amount=1030000, reference='9876543210'}]}
```

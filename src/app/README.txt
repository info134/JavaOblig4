I denne oppgaven ble designmalene Singleton og Data Object Access brukt. 
Singleton ble lagd i database.java for å sikre at bare en instans av database-connectionen
kan brukes om gangen. Dette sparer ressurser og vi har kontroll på ressursene og koblingen mot databasen.
Konstruktøren i Database.java er gjort privat slik at den ikke kan kalles utenfor
klassen. I stedet er getInstance metoden gjort public og det er denne som brukes. Hvis det ikke finnes
et instance av Database, lager denne metoden en ny connection, hvis koblingen til databasen er stengt
lager den en ny connection. Hvis ingen av disse påstandene er sann så returnerer den null. 

DAO ble brukt for å abstrahere data operasjonene. Den sørger for at Controller klassen
ikke trenger å inneholde all SQL logikken som trengs for å kommunisere med databasen. Istedet blir
dette flyttet til DAO'en. Det gjør at koden blir mer cohesive og sørger for mindre coupling. Så når 
den underliggende databasestrukturen endrer seg fra SQL til f.eks XML så trenger en bare å endre DAO 
klassene siden Controller klassen ikke er kjent med den underliggende logikken i DAO'ene.
handleSubmitButtonAction metoden i Controller kaller DAO klassene når metoden blir kalt i GUI'et.
Metoden findAll i DAOCustomer kjører sql queries mot databasen og returnerer en Liste av invoices
som en iterator i Controller klassen kjører igjennom. 
Designmalen (abstract) factory kunne også blitt brukt i denne oppgaven. Factory er en objekt som lager andre
objekter noe som kan spare tid og gir mer ryddig kode. 
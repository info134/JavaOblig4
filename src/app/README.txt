I denne oppgaven ble designmalene Singleton og Data Object Access brukt. 
Singleton ble lagd i database.java for � sikre at bare en instans av database-connectionen
kan brukes om gangen. Dette sparer ressurser og vi har kontroll p� ressursene og koblingen mot databasen.
Konstrukt�ren i Database.java er gjort privat slik at den ikke kan kalles utenfor
klassen. I stedet er getInstance metoden gjort public og det er denne som brukes. Hvis det ikke finnes
et instance av Database, lager denne metoden en ny connection, hvis koblingen til databasen er stengt
lager den en ny connection. Hvis ingen av disse p�standene er sann s� returnerer den null. 

DAO ble brukt for � abstrahere data operasjonene. Den s�rger for at Controller klassen
ikke trenger � inneholde all SQL logikken som trengs for � kommunisere med databasen. Istedet blir
dette flyttet til DAO'en. Det gj�r at koden blir mer cohesive og s�rger for mindre coupling. S� n�r 
den underliggende databasestrukturen endrer seg fra SQL til f.eks XML s� trenger en bare � endre DAO 
klassene siden Controller klassen ikke er kjent med den underliggende logikken i DAO'ene.
handleSubmitButtonAction metoden i Controller kaller DAO klassene n�r metoden blir kalt i GUI'et.
Metoden findAll i DAOCustomer kj�rer sql queries mot databasen og returnerer en Liste av invoices
som en iterator i Controller klassen kj�rer igjennom. 
Designmalen (abstract) factory kunne ogs� blitt brukt i denne oppgaven. Factory er en objekt som lager andre
objekter noe som kan spare tid og gir mer ryddig kode. 
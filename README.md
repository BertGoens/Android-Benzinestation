# Android-Benzinestation
Test Android Prog5 01/03/16
Door Bert Goens

##Verbeterpunten
* Packages: activities  
Om de een of andere reden is deze package anders verwerkt dan de rest, zet ze goed  

* Bijhouden Kasticket objecten  
Steek ze in een list in MainActivity 

* Zorgen dat de image ook ondersteund wordt:  
Interface         /model/Benzinepomp int getImageId();  
Abstracte klasse  /model/BenzinepompBase getImageId() 

* String notaties verkorten waar mogelijk  
String.valueOf(100) vervangen door 100"l"

* Layout: activity_main.xml progressbar schoonheidsfix  
In de xml de pgb een standaardwaarde geven van 0 (bij rotatie scherm reset dit dan zonder code)

* Layout: Costum Benzinepomp layout maken (+ klasse (bind layout))  
De layout per pomp verschilt niet, dit kun je dus met een layoutinflater vergemakkelijken

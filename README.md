# Android-Benzinestation
Test Android Prog5 01/03/16
Door Bert Goens

##Verbeterpunten
1.
Als je > 5 PompFragments wil laden kan het zijn dat ze niet tegelijk werken.
Dit ligt aan de default maximum asynctask tegelijkrun waarde.
Het kan zijn dat in dat geval een Handler een betere oplossing is.

2. 
Een zwakke interface AfrekenenListener in het PompFragment
Ik steek het op de onduidelijkheid van hoe en wat er precies moest gelogd worden van Kasticketten.

3.
Bij een onResume zou het een PompFragment verder moeten werken
(Realistisch: als je het scherm draait moet hij verder werken)

##Goed
Constanten apart
Strategy Design Pattern voor pompen
Util klasse RoundToDouble om logica gescheiden te houden
Fragment Inladen en een Pomp toewijzen in een Activity en je bent klaar.
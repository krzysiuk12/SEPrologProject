# Systemy ekspertowe

## Tematyka projektu
Projekt zostal utworzony w ramach przedmiotu Systemy Ekspertowe.

## Instalacja
Do poprawnego dzialania projektu należy zainstalować:
  - SWI Prolog: (http://www.swi-prolog.org/Download.html) (w projekcie zostala uzyta wersja 7.1.21)
  - JPL - w przypadku instalacji SWI Prolog w powyższej wersji biblioteka znajduje sie w  %SWI_HOME_DIR%/lib/jpl.jar
  
## Ustawienie zmiennych srodowiskowych
Nalezy ustawic nastepujace zmienne srodowiskowe:
  - SWI_HOME_DIR - wskazuje na folder w którym zostal zainstalowany SWI Prolog
  - PATH - nalezy dodac %SWI_HOME_DIR%/bin oraz  %SWI_HOME_DIR%/lib/jpl.jar 

## Opis
Projekt zawiera pomoc w znadywaniu filmow zaleznych od usposobienia oraz od cech charakteru czlowieka. Dopasowanie zawiera sie w ponizszej tabeli:

|  | Administrator | Adwokat | Animator | Artysta | Doradca | Dyrektor | Entuzjasta | Idealista | Innowator | Inspektor | Logik | Mentor | Opiekun | Praktyk | Prezenter | Choleryk | Flegmatyk | Melancholik | Sangwinik |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| Bezpośredni | TAK |  |  |  |  |  |  |  |  |  |  |  |  |  |  | TAK |  |  |  |
| Błyskotliwy |  |  |  |  | TAK |  |  |  |  |  |  |  |  |  |  |  |  |  |  |
| Cierpliwy |  |  |  |  |  |  |  |  |  |  |  |  | TAK |  |  |  | TAK |  |  |
| Empatyczny |  | TAK |  |  |  |  |  |  |  |  |  | TAK |  |  | TAK | TAK | TAK | TAK |  |
| Energiczny | TAK | TAK | TAK |  |  |  | TAK |  | TAK |  |  |  |  |  | TAK | TAK | NIE |  | TAK |
| Enigmatyczny |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  | TAK |  |  |
| Entuzjastyczny |  | TAK |  | TAK | TAK |  | TAK |  |  |  |  |  |  | TAK |  |  |  |  | TAK |
| Indywidualista |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |
| Inspirujący |  |  | TAK | TAK | TAK | TAK |  |  |  | NIE | TAK |  |  |  | TAK | TAK |  | TAK | TAK |
| Kompetentny |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  | TAK |  |  |  |
| Logiczny | TAK |  | TAK |  | NIE | TAK |  | TAK |  | TAK | TAK | TAK |  |  |  |  | TAK |  |  |
| Lojalny | TAK |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |
| Niezależny |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |
| Odporny na stres |  |  |  |  |  | TAK |  | NIE |  |  |  |  | NIE | TAK |  |  |  |  |  |
| Odpowiedzialny | TAK | TAK |  | NIE |  | TAK | NIE | TAK | NIE | TAK |  | TAK | TAK | TAK | NIE | TAK |  |  | NIE |
| Optymistyczny, pozytywnie nastawiony do życia |  |  |  | TAK | TAK |  | TAK |  | TAK |  |  |  |  | TAK | TAK |  |  | NIE | TAK |
| Pewny siebie |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |
| Pracowity | TAK |  |  |  |  |  |  |  |  |  |  |  | TAK |  |  |  | TAK |  |  |
| Praktyczny |  |  |  |  |  |  |  |  |  |  |  |  | TAK |  | TAK |  |  |  |  |
| Przedsiębiorczy |  |  | TAK |  | NIE | TAK | NIE |  |  | TAK |  |  | TAK |  | NIE |  |  |  |  |
| Racjonalny | TAK |  | TAK |  | NIE | TAK |  | TAK |  | TAK | TAK |  |  |  |  |  |  |  |  |
| Rzeczowy, konkretny | TAK |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |
| Serdeczny |  |  |  |  | TAK |  | TAK | TAK |  |  |  |  | TAK |  |  |  |  |  |  |
| Spontaniczny |  |  | TAK | TAK |  | NIE |  |  | TAK | NIE | NIE |  |  |  |  | TAK |  |  | TAK |
| Sumienny, obowiązkowy | TAK | TAK |  |  |  | TAK | NIE |  | NIE | TAK |  | TAK |  | TAK | NIE |  | TAK |  |  |
| Towarzyski, serdeczny |  | TAK | TAK | TAK | TAK | NIE | TAK | TAK | TAK |  |  |  |  |  |  | NIE |  | NIE | TAK |
| Twórczy, pomysłowy |  |  |  | TAK |  | TAK | TAK |  | TAK | NIE | TAK | TAK |  |  |  |  |  | TAK | TAK |
| Ufny |  |  |  |  |  |  |  |  |  |  |  | TAK |  |  |  |  | NIE | NIE |  |
| Wrażliwy |  |  |  | TAK |  |  |  | TAK |  | NIE |  | TAK |  |  |  | TAK | TAK | TAK | TAK |
| Wytrwały |  |  |  |  |  |  |  |  |  |  |  |  | TAK |  |  |  |  |  |  |
| Zdystansowany |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  | TAK |  |  |  |
| Zorganizowany | TAK | TAK | NIE | NIE |  | TAK | NIE |  |  | TAK |  |  | TAK |  |  |  | TAK | TAK |  |

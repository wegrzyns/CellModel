[Powrót do strony głównej](index)
# Rozwiązania techniczne

## Model symulacyjny

Tworzony model symulacyjny będzie systemem dyskretnym, tworzonym na wzór automatu skończonego.

Modelowanie będzie polegać na obliczaniu stanu komórki w poszczególnym krokach symulacji, które mogą reprezentować upływ czasu.

Poniższa ilustracja przedstawia idee modelu symulacyjnego:
![SymulationModel](img/ModelVisualization.jpg "SymulationModel")


## Wizualizacja

Rozważana jest dwuwymiarowa wizualizacja modelowanej komórki lub jej części, natomiast nie została ona jeszcze zaprojektowana ani zaimplementowana.


## Wykorzystywane technologie

- Java 1.8
- JavaFX
- Gradle
- Jackson
- Guice


# Budowa aplikacji

## Opis przebiegu prac

Prace wykonywane były według modelu przyrostowego. Każda z iteracji, została szczegółowo opisana przez zespół. Wśród zapisów zawarty został zarówno przebieg prac, jak też rozważane pomysły na rozwój aplikacji. 

- [Iteracja 1](iteration1)
- [Iteracja 2](iteration2)


## Aktualne rozwiązanie

Źródła bieżącej aplikacji dostępne są w głównym repozytorium projektu: [Repozytorium główne](https://github.com/miczyg/cell-simulation)

Obecnie, w projekcie istnieją dwie wersje aplikacji, które powstały w ramach prac nad optymalnym rozwiązaniem do efektywnej symulacji reakcji zachodzących w komórce. Są to:

- aplikacja sekwencyjna - każdy krok symulacji jest wykonywany sekwencyjnie w ramach tej samej maszyny wirtualnej. [Aplikacja sekwencyjna](https://github.com/miczyg/cell-simulation)
- aplikacja zrównoleglona - komórka została podzielona na obszary dla których równolegle wykonywane są symulacje przez pewną ilość kroków a następnie rezultaty obliczeń są agregowane do jednej komórki przed ponownym wykonaniem opisanego algorytmu. Równoległe obliczenia mogą być prowadzone w osobnych wątkach czy też w przyszłości na różnych maszynach (fizycznych). [Aplikacja zrównoleglona](https://github.com/miczyg/cell-simulation/tree/simple-parallelization)

Strona projektu hostowana jest na Github pages, źródło strony dostępne w repozytorium strony na branchu gh-pages: [Repozytorium strony](https://github.com/wegrzyns/CellModel/tree/gh-pages)
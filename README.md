# ha2

**Wszystko i nic**

TODO TODO TODO...

1. Zbieramy wymagania co ma robić nasz system;
2. Tworzymy sobie scenariusze testowe dla tzw. 'happy path' - takie ścieżki które mają dla nas zarabiać pieniądze;
3. Scenariusz testowy przerabiamy na test akceptacyjny w naszej aplikacji (groovy: given->when->then);
4. Architektura
5. Na podstawie powyższych staramy się wydzielić bounded context/y, np. obszar artykułów z domenami takimi jak: artykuł, autor, wydawca, użytkownik itd.
6. Weryfikacja architektury na zasadzie co z czym gada, np:
    - użytkownik (tutaj autor) tworzy artykuł (/createArticle), w międzyczasie uruchamiane są walidacje typu np.
    czy artykuł o takiej nazwie już istnieje (zatem powinno być coś na zasadzie /findArticleBy...); 
    - autor może ale nie musi mieć wydawcę, użytkownik odpytuje 
     

**Notatki:**
1. _Serwis aplikacyjny_ w nomenklaturze _DDD_ został tu zaimplementowany poprzez wzorzec fasady;
* integruje wiele zależności (repozytoria, fabryki, serwisy pomocnicze);
* zapewnia transakcyjność i bezpieczeństwo (w tym wypadku poprzez adnotacje i AOP);
* integruje komponenty aplikacyjne (w tym wypadu pracujący w sesji, zalogowany użytkownik);
* orkiestruje obiekty domenowe.  
(źr. <u>https://bottega.com.pl/pdf/materialy/ddd/ddd1.pdf</u>)


**Pytania:**
1. Jak rozróżnić kompetencje w implementacji pomiędzy serwisem aplikacyjnym i domenowym ?
Moje przemyślnia:
- _serwis aplikacyjny_ (u mnie ArticleFacade) jest takim punktem wejścia do modułu (jedynym). 
Ma w sobie wiele zależności do wszystkiego. W ostateczności może mieć też fasadę do innego modułu.
- _serwis domenowy_ (u mnie np. ArticleService) ma w sobie zwykle znacznie mniej zależności. Idealnie 
by było mieć tam max. repository. Dostaje pobrane wcześniej obiekty i wykonuje zadania na agregacie. 
Tu siedzi logika biznesowa naszej aplikacji. Np. opisany niżej przypadek **TO impl**  
 
 
**TO impl:**
- przypadek gdy potrzebujemy zaktualizować cały agregat, bo zmieniło się coś co ma wpływ na jego stan.
 U mnie np. Autor zmienia wydawcę z którym jest powiązany. Metoda do "przepisania" autora 
 może być w aggregate root **Article** 
 
 
-----------------------------------------------------------------------------
 
 
 Wymagania dla domeny 'author':
 1. Dodawanie użytkowników, użytkownik ma mieć unikalny login (logowanie do systemu),
  pseudonim (to będzie wyświetlane pod artykułami oraz na stronie) oraz jakiś personalId;
 2. Wyszukiwanie użytkownika po jego "pseudonimie" lub imieniu plus nazwisku;
 3. Zwraca listę (id) artykułów danego użytkownika;
 
 
**Technikalia**
 
 1. Wspólna klasa bazowa dla agregatów:
    - zaimplementowana w *BaseAggregateRoot*;
    - abstract klasę z której dziedziczymy oznaczamy `@MappedSuperclass` - odpowiednik `@Entity`
    - nadpisujemy *EmbeddedId* z klasy *AggregateId* w klasie *BioEntity*:
    
    ``
        @EmbeddedId
        @AttributeOverrides({
                @AttributeOverride(name = "aggregateId", column = @Column(name = "bioId", nullable = false))})
        private AggregateId bioId;
    ``        
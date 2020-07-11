# ha2

Wszystko i nic

1. Zbieramy wymagania co ma robić nasz system;
2. Tworzymy sobie scenariusze testowe dla tzw. 'happy path' - takie ścieżki które mają dla nas zarabiać pieniądze;
3. Scenariusz testowy przerabiamy na test akceptacyjny w naszej aplikacji (groovy: given->when->then);
4. Architektura
5. Na podstawie powyższych staramy się wydzielić bounded context/y, np. artykuł, autor, wydawca, użytkownik itd.
6. Weryfikacja architektury na zasadzie co z czym gada, np:
    - użytkownik (tutaj autor) tworzy artykuł (/createArticle), w międzyczasie uruchamiane są walidacje typu np.
    czy artykuł o takiej nazwie już istnieje (zatem powinno być coś na zasadzie /findArticleBy...); 
    - autor może ale nie musi mieć wydawcę, użytkownik odpytuje 
     
     
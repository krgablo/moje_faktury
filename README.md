# moje_faktury

Aplikacja moje_faktury, jest programem, który zarządza naszymi fakturami. Możemy wprowadzić naszą nową fakturę,a
plikacja automatycznie przypisuje ją do nas automatycznie. Jednocześnie odlicza dni ile zostało nam do jej opłacenia.

Jeśli nowy użytkownik się rejestruje, to automatycznie zostaje mu przypisana rola USER i nie może podglądać innych użytkowników.
Wyjątkiem jest użytkownik o nazwie ADMIN, któremu to jest automatycznie przypisana rola ADMIN.

===INSTRUKCJA OBSŁUGI===

Aplikacja korzysta z lekkiej bazy danych H2, więc aby ją uruchomić wystarczy ją pobrać. Jest napisana w języku Java 8.
Aby wykorzystać aplikację najlepiej jest używać POSTMAN'a.

Po uruchomieniu aplikacji "moje_faktury" w IDE, należy uruchomić np. Postman i wkleić URL http://localhost:8080/registration.
Tutaj tworzymy swojego użytkownika przez JSON, np.

POST
{
	"id":1,
	"name": "ABC",
	"password": "123"
}

Stworzy nam to urzytkownika "ABC" i przypisze mu automatycznie role USER.
Następnie możemy stworzyć i przypisać do użytkownika fakturę, korzystająć z adresu:
http://localhost:8080/invoice/1
Ostatnia cyfra reprezentuje id użytkownika, w tym przypadku "ABC".

Możemy teraz wpisać nową fakturę, np.

POST

{
	"id":2,
	"invoiceNumber": "FV-01",
	"value": 100,
	"paymentDate": "2019-10-25",
	"invoiceIssuer":"Trek" 
}


W chwili obecnej faktura została wprowadzona i przypisana do użytkownika o id = 1. Automatycznie uzyskała równierz status NOT_PAID.

Obecnie możemy również podglądnąć naszą fakturę przy użyciu URL:

GET
http://localhost:8080/invoices/2

Ostatnia cyfra reprezentuje id faktury.
Możemy odczytać z niej dodatkową informację ile pozostało nam dni do jej opłacenia.

Oczywiście możemy również, dodawać kolejne faktury i użytkowników, możemy je również edytować lub usuwać.

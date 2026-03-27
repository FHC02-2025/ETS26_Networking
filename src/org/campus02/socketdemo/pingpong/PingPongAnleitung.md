
# Client-Server Anwendung

## Server:
- Sendet der Client PONG -> antwortet der Server mit PING
- Sendet der Client PING -> antwortet der Server mit PONG
- Sendet der Client etwas anderes -> antwortet der Client mit ERROR

## Client:
- Der Client soll die zu sendenten Daten über die Kommandozeile einlesen
- Nach dem Senden des Inputs soll die Antwort auf der Kommandozeile ausgegeben werden
- Input = EXIT => Verbindung beenden

# Zusatz
Erweitern Sie das Beispiel um eine Klasse namens Response. Ein Response hat folgende Attribute:

- int status
- String message

Erstellen Sie für diese Klasse einen Konstruktor, welcher alle Attribute setzt und auch die Getter für beide Attribute.

## Server
- Sendet der Client PONG -> antwortet der Server mit einem Response, wobei für status 200 und für message "PING" gesetzt wird
- Sendet der Client PING -> antwortet der Server mit PONG einem Response, wobei für status 200 und für message "PONG" gesetzt wird
- Sendet der Client etwas anderes -> antwortet der Client mit ERROR einem Response, wobei für status 500 und für message "ERROR" gesetzt wird

## Client:
- Der Client soll die zu sendenten Daten über die Kommandozeile einlesen
- Nach dem Senden des Inputs soll die Antwort wie folgt auf der Kommandozeile ausgegeben werden: "Status: <<status>>, Nachricht: <<message>>"
- Input = EXIT => Verbindung beenden
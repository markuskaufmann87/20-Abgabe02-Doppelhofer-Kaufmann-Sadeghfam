##Queue

#### Grundgedanke
> Eine Warteschlange ist eine dynamische Datenstruktur. Die auf dem FIFO-Prinzip basiert.
> Die gespeicherten Elemente können nur in der gleichen Reihenfolge wieder entnommen werden wie sie gespeichert wurden.
> Queue ist das Gegenstück zum Stack.
> Kann auch als Priority Queue implementiert werden sodass sich die Reihenfolge nach der Priorität richtet. Entweder HIFO (highest first out) oder LOFO (lowest first out).

#### Elementare Methoden
> ![Queue](../resources/images/queue.png)
>
> _**enqueue**_
> Zum Hinzufügen von Elementen an das Ende Der Warteschlage.
>
> _**dequeue**_ 
> Zum Entfernen des Elementes das am Anfang der Warteschlange gespeichert ist.
>
> _**getHeadElement**_ 
> Diese Methode gibt das Element am Anfang zurück ohne es zu entfernen. Sehr hilfreich für Abfragen
>

#### Codebeispiele
> _**enqueue**_
> ```java
> if (elements.size() != maxSize) {
> elements.add(object);
> }
> ```

> _**dequeue**_
> ```java
> if (elements.size() > 0) {
>  object = elements.get(0);
>  elements.remove(0);
>  return object;
> }
> ```

#### Links
> [Queue Dokumentation](https://www.geeksforgeeks.org/queue-data-structure/)


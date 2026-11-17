package programmierkonzepte.records;
//
//public record Tuple(int x, int y, int z) {
//}

// Generischer Datentyp
public record Tuple<T1,T2,T3>(T1 x, T2 y, T3 z) {
}
// T1, T2, T3 sind Platzhalter für Datentypen/Klassen

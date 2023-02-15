package e2;
public class SocialDistance {

    /* FUNCIONES AUXILIARES: */

    /* checkCharsAndLength char[][] -> bool. Comprueba que el la matriz no tenga caracteres no validos y no sea 'ragged'  */
    private static boolean checkCharsAndLength(char[][] layout){
        for(int i=0; i<layout.length; i++){
            for(int j=0; j<layout[i].length; j++){
                //Check Chars
                if(layout[i][j] != 'A' && layout[i][j] != '.'){
                    return true;
                }
                //Check Length
                if((i < layout.length - 1) && layout[i].length != layout[i+1].length){ //Primero mira que no sea la utlima fila
                    // (porque entonces la longitud de la ultima fila + 1 produciria un error ) y despues mira que no sean
                    // de distinta longitud la fila actual y la siguiente (ragged)
                    return true;
                }
            }
        }
        return false;
    }
    /* sitEveryone char[][] -> char[][]. Sienta alumnos ('#') en los sitios libres ('A') sin tener en cuenta las restricciones */
    private static void sitEverybody(char[][] layout){
        for(int i=0; i<layout.length; i++){
            for(int j=0; j<layout[i].length; j++){
                if (layout[i][j] == 'A') { layout[i][j] = '#'; }
            }
        }
    }
    /* copyLayout (char[][], char[][]) -> (char[][], char[][]). Copia el contenido de la segunda matriz en la primera matriz */
    private static void copyLayout(char[][] destination, char [][] source){
        for(int i=0; i < destination.length; i++){
            for(int j=0; j<destination[i].length; j++){
                destination[i][j] = source[i][j];
            }
        }
    }
    /* check4adjacent (char[][], int, int ) -> bool . Comprueba que no hay mas de 4 alumnos sentados alrededor del alumno sentado en el sitio[i][j] */
    private static boolean check4adjacent(char[][] layout, int i, int j) {
        int count = -1; // Empieza en -1 porque el bucle va a pasar por encima del '#' que esta en la posicion [i][j]
        int auxi, auxj;

        /* LAYOUTS RARITOS */
        if(layout.length == 1 || layout[i].length == 1){
            return false;
        }

        /* LAS CUATRO ESQUINAS */
        if ((i == 0 && j == 0) || (i == (layout.length - 1) && j == (layout[i].length - 1)) || (i == 0 && j == (layout[i].length - 1)) || (j == 0 && i == (layout.length - 1))) {
            return false;
        }
        /* PRIMERA FILA */
        else if (i == 0){
            for (auxi = i; auxi <= (i + 1); auxi++) {
                for (auxj = (j - 1); auxj <= (j + 1); auxj++) {
                    if (layout[auxi][auxj] == '#') {
                        count = count + 1;
                    }
                }
            }
            return (count >= 4);
        }
        /* ULTIMA FILA */
        else if (i == layout.length -1 ){
            for (auxi= i-1; auxi <= i; auxi++) {
                for (auxj = (j - 1); auxj <= (j + 1); auxj++) {
                    if (layout[auxi][auxj] == '#') {
                        count = count + 1;
                    }
                }
            }
            return (count >= 4);
        }
         /* PRIMERA COLUMNA */
        else if(j == 0){
            for ( auxi = i - 1; auxi <= i + 1; auxi++){
                for ( auxj = j; auxj <= j + 1; auxj++){
                    if (layout[auxi][auxj] == '#') {
                        count = count + 1;
                    }
                }
            }
            return (count >= 4);
        }
        /* ULTIMA COLUMNA */
        else if(j == (layout[i].length - 1)){
            for ( auxi = i - 1; auxi <= i + 1; auxi++){
                for ( auxj = j-1; auxj <= j ; auxj++){
                    if (layout[auxi][auxj] == '#') {
                        count = count + 1;
                    }
                }
            }
            return (count >= 4);
        }

        /* CASO GENERAL */
        else {
            for ( auxi = i - 1; auxi <= i + 1; auxi++) {
                for ( auxj = j - 1; auxj <= j + 1; auxj++) {
                    if (layout[auxi][auxj] == '#') {
                        count = count + 1;
                    }
                }
            }
            return (count >= 4);
        }
    }
    /* check8adjacent (char[][], int, int ) -> bool . Comprueba que no hay ningun alumno sentado alrededor del sitio [i][j] */
    private static boolean check8adjacent(char[][] layout, int i, int j){

        /* EN LOS CASOS DE MATRICES DE LONGITUD UNO, NUNCA VAN A SENTARSE Y LEVANTARSE 'VARIAS VECES', ENTONCES NO HACE FALTA TENER ESE CASO EN CUENTA  */

        if (i == 0 && j == 0){ // LAYOUT[0][0]
            return layout[i][j + 1] != '#' && layout[i + 1][j] != '#' && layout[i + 1][j + 1] != '#';
        }
        else if(i==0 && j == (layout[i].length-1)){ // LAYOUT[0][N]
            return layout[i][j - 1] != '#' && layout[i + 1][j - 1] != '#' && layout[i + 1][j] != '#';
        }
        else if (i == (layout.length-1) && j == 0){ // LAYOUT[M][0]
            return layout[i - 1][j] != '#' && layout[i + 1][j + 1] != '#' && layout[i][j + 1] != '#';
        }
        else if (i == (layout.length-1) && j ==(layout[i].length-1) ){ // LAYOUT[M][N]
            return layout[i - 1][j - 1] != '#' && layout[i - 1][j] != '#' && layout[i][j - 1] != '#';
        }
        /* PRIMERA FILA */
        else if (i == 0){
            for (int auxi = i; auxi <= (i + 1); auxi++) {
                for (int auxj = (j - 1); auxj <= (j + 1); auxj++) {
                    if (layout[auxi][auxj] == '#') {
                        return false;
                    }
                }
            }
            return true;
        }
        /* ULTIMA FILA */
        else if (i == layout.length -1 ){
            for (int auxi = i-1; auxi <= i; auxi++) {
                for (int auxj = (j - 1); auxj <= (j + 1); auxj++) {
                    if (layout[auxi][auxj] == '#') {
                        return false;
                    }
                }
            }
            return true;
        }
        /* PRIMERA COLUMNA */
        else if(j == 0){
            for (int auxi = i - 1; auxi <= i + 1; auxi++){
                for (int auxj = j; auxj <= j + 1; auxj++){
                    if (layout[auxi][auxj] == '#') {
                        return false;
                    }
                }
            }
            return true;
        }
        /* ULTIMA COLUMNA */
        else if(j == (layout[i].length - 1)){
            for (int auxi = i - 1; auxi <= i + 1; auxi++){
                for (int auxj = j-1; auxj <= j ; auxj++){
                    if (layout[auxi][auxj] == '#') {
                        return false;
                    }
                }
            }
            return true;
        }
        /* CASO GENERAL */
        else {
            for (int auxi = i - 1; auxi <= i + 1; auxi++) {
                for (int auxj = j - 1; auxj <= j + 1; auxj++) {
                    if (layout[auxi][auxj] == '#') {
                        return false;
                    }
                }
            }
            return true;
        }

    }
    /* checkLayout char[][] -> bool. Comprueba que el esquema cumple con las restricciones */
    private static boolean checkLayout(char[][] layout){
        for(int i=0; i<layout.length; i++){
            for(int j = 0; j<layout[i].length; j++){
                /*check4adjacent: si hay 4 o mas adyacentes: devuelve true*/
                if(layout[i][j] == '#' && check4adjacent(layout, i, j))
                    return true;
            }
        }
        return false;
    }

    /**
     * Given the layout of a class with available sites marked with an ’A’ and
     * invalid sites marked with a ’.’, returns the resulting layout with the
     * sites occupied by the students marked with a ’#’ following two rules :
     * - Students occupy an empty seat if there are no other adjacent students .
     * - A student leaves a seat empty if he/ she has 4 or more adjacent students .
     * @param layout The initial layout .
     * @return The resulting layout .
     * @throws IllegalArgumentException if the initial layout is invalid (is null ,
     * is ragged , includes characters other than ’.’ or ’A ’)).
     */
    public static char [][] seatingPeople ( char [][] layout ) {
        //Layaout no valido
        if(layout == null || checkCharsAndLength(layout)) {
            throw new IllegalArgumentException();
        }
        else{
            char[][] solution = new char[layout.length][layout[0].length];
            char[][] aux = new char[layout.length][layout[0].length];
            copyLayout(solution, layout);
            /* Sentar a todos */
            sitEverybody(solution);
            do {
                copyLayout(aux, solution);
                for (int i = 0; i < solution.length; i++) {
                    for (int j = 0; j < solution[i].length; j++) {
                        /*check4adjacent: si hay 4 o mas adyacentes: devuelve true*/
                        if (solution[i][j] == '#' && check4adjacent(aux, i, j)) { solution[i][j] = 'A'; }
                    }
                }
                copyLayout(aux, solution);
                for (int i = 0; i < solution.length; i++) {
                    for (int j = 0; j < solution[i].length; j++) {
                        /*check8adjacent: si no hay adyacentes: devuelve true */
                        if (solution[i][j] == 'A' && check8adjacent(aux, i, j)) { solution[i][j] = '#'; }
                    }
                }
            }
            while(checkLayout(solution));
            return solution;
        }
    }
}
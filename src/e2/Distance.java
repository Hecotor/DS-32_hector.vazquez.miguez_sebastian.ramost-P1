package e2;

public class Distance {

    public static char [][] seatingPeople( char [][] layout) {

        if (layout == null) throw new IllegalArgumentException();
        for (int i = 0; i < layout.length; i++){
            if (layout[i] == null || layout[i].length != layout[0].length)
                throw new IllegalArgumentException();
            for (int j = 0; j < layout[0].length; j++){
                if (layout[i][j] != 'A' && layout[i][j] != '.') throw new IllegalArgumentException();
            }
        }

        boolean cambios = true;
        while(cambios) {
            cambios = false;
            for (int i = 0; i < layout.length; i++) {
                for (int j = 0; j < layout[0].length; j++) {
                    int aux = 0;
                    if (layout[i][j] == 'A') {
                        if (i > 0 && j > 0 && layout[i - 1][j - 1] == '#') aux++;
                        if (j > 0 && layout[i][j - 1] == '#') aux++;
                        if (i < layout.length - 1 && j > 0 && layout[i + 1][j - 1] == '#') aux++;
                        if (i > 0 && layout[i - 1][j] == '#') aux++;
                        if (i < layout.length - 1 && layout[i + 1][j] == '#') aux++;
                        if (i > 0 && j < layout[0].length - 1 && layout[i - 1][j + 1] == '#') aux++;
                        if (j < layout[0].length - 1 && layout[i][j + 1] == '#') aux++;
                        if (i < layout.length - 1 && j < layout[0].length - 1 && layout[i + 1][j + 1] == '#') aux++;
                        if (aux == 0) {
                            layout[i][j] = 'X';
                            cambios = true;
                        }
                    }
                }
            }

            for (int i = 0; i < layout.length; i++) {
                for (int j = 0; j < layout[0].length; j++) {
                    int aux = 0;
                    if (layout[i][j] == '#') {
                        if (i > 0 && j > 0 && (layout[i - 1][j - 1] == '#' ||
                                layout[i - 1][j - 1] == 'Y')) aux++;
                        if (j > 0 && (layout[i][j - 1] == '#' || layout[i][j - 1] == 'Y')) aux++;
                        if (i < layout.length - 1 && j > 0 && (layout[i + 1][j - 1] == '#' ||
                                layout[i + 1][j - 1] == 'Y')) aux++;
                        if (i > 0 && (layout[i - 1][j] == '#' || layout[i - 1][j] == 'Y')) aux++;
                        if (i < layout.length - 1 && (layout[i + 1][j] == '#' ||
                                layout[i + 1][j] == 'Y')) aux++;
                        if (i > 0 && j < layout[0].length - 1 && (layout[i - 1][j + 1] == '#' ||
                                layout[i - 1][j + 1] == 'Y')) aux++;
                        if (j < layout[0].length - 1 && (layout[i][j + 1] == '#' ||
                                layout[i][j + 1] == 'Y')) aux++;
                        if (i < layout.length - 1 && j < layout[0].length - 1 && (layout[i + 1][j + 1] == '#' ||
                                layout[i + 1][j + 1] == 'Y')) aux++;
                        if (aux >= 4) {
                            layout[i][j] = 'Y';
                            cambios = true;
                        }
                    }
                }
            }

            for (int i = 0; i < layout.length; i++) {
                for (int j = 0; j < layout[0].length; j++) {
                    if (layout[i][j] == 'X') layout[i][j] = '#';
                    if (layout[i][j] == 'Y') layout[i][j] = 'A';
                }
            }

        }
        return layout;
    }
}
package e1;

public class StringCount {
    public static int countWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }
        int contar = text.split("\\s+").length;
        return contar;
    }
    public static int countChar(String text, char c){
        if (text == null || text.trim().isEmpty()){
            return 0;
        }
        int count = 0;
        for(int i = 0; i < text.length(); i++){
            if(text.charAt(i) == c){
                count++;
            }
        }
        return count;
    }
    public static int countCharIgnoringCase(String text, char c){
        if (text == null || text.trim().isEmpty()){
            return 0;
        }
        int count = 0;
        //mayusculas
        c = Character.toUpperCase(c);
        String textToUpper = text.toUpperCase();

        for(int i = 0; i < text.length(); i++){
            if(textToUpper.charAt(i) == c){
                count++;
            }
        }
        return count;
    }
    public static boolean isPasswordSafe(String password){
        if (password.length() >= 8){
            if (!password.equals(password.toLowerCase()) && !password.equals(password.toUpperCase())){
                for(int i = 0; i < password.length(); i++){
                    if(Character.isDigit(password.charAt(i))){
                        if(password.contains("?") ||password.contains("@") ||password.contains("#")
                                ||password.contains(".") ||password.contains(",") ||password.contains("$")){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}

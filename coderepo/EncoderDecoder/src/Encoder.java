import java.util.Scanner;
public class Encoder {


    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter message: ");
        String msg = scanner.next();
        String cipher = encode(msg);


        System.out.println("Cipher: " +  cipher);
        System.out.println("Message: " + decode(cipher));

    }

    private static String encode(String msg){
        msg = msg.toUpperCase();

        char[] alphabets = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
                'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        String digest = "";

        for(int i = 0, len=msg.length(); i < len; i++){
            int index = ( (msg.charAt(i) - 'A') + 3 ) % 26;
            char d = alphabets[index];
            digest = new StringBuilder(digest).append(d).toString();
        }

        return digest;
    }

    private static String decode(String digest){
        char[] alphabets = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
                'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        String msg = "";

        for(int i = 0, len=digest.length(); i < len; i++){
            int index = (digest.charAt(i) - 'A') - 3;
            if(index < 0){
                index += 26;
            }
            char d = alphabets[index];
            msg = new StringBuilder(msg).append(d).toString();
        }

        return msg;
    }



}


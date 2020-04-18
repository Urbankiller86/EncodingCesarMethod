package programmingwithfriends;
public class Arrays {
    char[] normalOrder={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
     char[] cesarOrder={'D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C'};
    
    public char getEncode(char originalChar){
        char encoded='.';
        for (int i = 0; i < cesarOrder.length; i++) {
            if(originalChar==normalOrder[i]){
                encoded=cesarOrder[i];
            }
        }return encoded;
    }
    
    public char getDecoded(char encodedChar){
        char decoded=' ';
        for (int i = 0; i < cesarOrder.length; i++) {
            if(encodedChar==cesarOrder[i]){
                decoded=normalOrder[i];
            }
        }return decoded;
    }
}

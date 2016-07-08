
public class TheEncryptionDivTwo {

  public String encrypt(String message) {
    byte[] letterAssignment = new byte[26];
    String encrypted = "";

    byte mapped = 1;
    for(int i = 0; i < message.length(); ++i) {
      byte ch  = (byte) message.charAt(i);

      if( letterAssignment[ch - 'a'] == 0 ) {
        letterAssignment[ch-'a'] = mapped;
        mapped++;
      }
      encrypted += (char) ('a' + letterAssignment[ch - 'a'] - 1);
    }
        
    return encrypted;
  } 
 
}

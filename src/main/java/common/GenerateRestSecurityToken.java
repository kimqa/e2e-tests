package common;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.apache.commons.codec.binary.Hex;

public class GenerateRestSecurityToken {

    /*
    метод генерирует Rest-Security-Token для GET, DELETE запросов
    https://www.jokecamp.com/blog/examples-of-creating-base64-hashes-using-hmac-sha256-in-different-languages/#java
    https://stackoverflow.com/questions/41611248/java-convert-base64-to-hex-string
    https://www.liavaag.org/English/SHA-Generator/HMAC/
     */
     public String restSecurityToken(String secret) {

         try {
             //для GET DELETE отдается пустая строка в message
             String message = "";
             Mac hmacSha256 = Mac.getInstance("HmacSHA256");
             System.out.println(message);
             SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(),"HmacSHA256" );
             hmacSha256.init(secretKeySpec);
             System.out.println(Hex.encodeHexString(hmacSha256.doFinal(message.getBytes())));

             return Hex.encodeHexString(hmacSha256.doFinal(message.getBytes()));

         } catch (Exception e) {
             return null;
         }
     }

    /*
   метод генерирует Rest-Security-Token для GET, DELETE запросов
   https://www.jokecamp.com/blog/examples-of-creating-base64-hashes-using-hmac-sha256-in-different-languages/#java
   https://stackoverflow.com/questions/41611248/java-convert-base64-to-hex-string
   https://www.liavaag.org/English/SHA-Generator/HMAC/
    */
    public String postSecurityToken(String secret, Object object) {

        try {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String message = ow.writeValueAsString(object);
            Mac hmacSha256 = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(),"HmacSHA256" );
            hmacSha256.init(secretKeySpec);

            return Hex.encodeHexString(hmacSha256.doFinal((message).getBytes()));

        } catch (Exception e) {
            System.out.println(e);
            return "null";
        }
    }
}

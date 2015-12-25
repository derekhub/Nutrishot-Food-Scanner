import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class MainScan {

    public static void main(String[] args) throws UnirestException {

        // These code snippets use an open-source library.
        // http://unirest.io/java
        HttpResponse<JsonNode> response = Unirest.post("https://camfind.p.mashape.com/image_requests")
                .header("X-Mashape-Key", "GXAEZZIp78mshXbId2kurGfdvAlvp1XlRjsjsn70l25nGbvS0d")
                .header("Content-Type", "application/x-www-form-urlencoded").header("Accept", "application/json")
                .field("focus[x]", "480").field("focus[y]", "640").field("image_request[altitude]", "27.912109375")
                .field("image_request[language]", "en").field("image_request[latitude]", "35.8714220766008")
                .field("image_request[locale]", "en_US").field("image_request[longitude]", "14.3583203002251")
                .field("image_request[remote_image_url]",
                        "http://s3-media1.fl.yelpcdn.com/bphoto/e0b27Zk_u2qpvgPcRy99iw/o.jpg")
                .asJson();

        // TODO: WRITE CODE TO PARSE THE JSON NODES TO GET ARGUMENT IN TOKEN
        System.out.println(response.getBody());

    }

}

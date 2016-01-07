import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class CamFindAPI {

    public String getImageRequestToken(String url) throws UnirestException {

        // These code snippets use an open-source library.
        // http://unirest.io/java
        HttpResponse<JsonNode> response = Unirest.post("https://camfind.p.mashape.com/image_requests")
                .header("X-Mashape-Key", "GXAEZZIp78mshXbId2kurGfdvAlvp1XlRjsjsn70l25nGbvS0d")
                .header("Content-Type", "application/x-www-form-urlencoded").header("Accept", "application/json")
                .field("focus[x]", "480").field("focus[y]", "640").field("image_request[altitude]", "27.912109375")
                .field("image_request[language]", "en").field("image_request[latitude]", "35.8714220766008")
                .field("image_request[locale]", "en_US").field("image_request[longitude]", "14.3583203002251")
                .field("image_request[remote_image_url]", url).asJson();

        // {
        // "token": "fhr1thsRYDm6Vgwx2hTgBw",
        // "url":
        // "//d1spq65clhrg1f.cloudfront.net/uploads/image_request/image/35/35311/35311614/o.jpg"
        // }

        // System.out.println(DEBUG: response.getBody());

        String token = (String) response.getBody().getObject().get("token");
        // System.out.println("TOKEN = " + token);

        return token;
    }

    public String getImageResponse(String token) throws UnirestException {

        // System.out.println("DEBUG: " + token);

        // {
        // "status": "completed",
        // "name": "pepperoni pizza"
        // }

        // These code snippets use an open-source library.
        // http://unirest.io/java
        String tokenUrl = "https://camfind.p.mashape.com/image_responses/" + token;
        // String tokenUrl =
        // "https://camfind.p.mashape.com/image_responses/lAwMibtKlfyjpMIsLP6HSA";

        // System.out.println(tokenUrl);

        HttpResponse<JsonNode> description = Unirest.get(tokenUrl)
                .header("X-Mashape-Key", "GXAEZZIp78mshXbId2kurGfdvAlvp1XlRjsjsn70l25nGbvS0d")
                .header("Accept", "application/json").asJson();

        String status = (String) description.getBody().getObject().get("status");

        System.out.println("DEBUG: returned JSON is: " + description.getBody());

        // System.out.println("Status isssss: " + status);

        if (status.equals("completed")) {
            String name = (String) description.getBody().getObject().get("name");
            return name;

        } else {
            String reason = (String) description.getBody().getObject().get("reason");
            System.out.println("getImageResponse status is 'skipped'. Reason is: " + reason);
        }

        return null;

    }

}

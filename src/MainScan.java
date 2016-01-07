import com.mashape.unirest.http.exceptions.UnirestException;

public class MainScan {

    public static void main(String[] args) throws UnirestException {

        CamFindAPI CamFindAPIObj = new CamFindAPI();
        // String token = CamFindAPIObj
        // .getImageRequestToken("http://s3-media1.fl.yelpcdn.com/bphoto/e0b27Zk_u2qpvgPcRy99iw/o.jpg");

        // System.out.println("Debug: token is: " + token);

        // TODO: hardcoded for now because string concatenation in
        // getImageResponse is having problems
        String token = "lAwMibtKlfyjpMIsLP6HSA";

        String description = CamFindAPIObj.getImageResponse(token);
        System.out.println(description);

    }

}

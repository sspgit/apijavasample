// // This sample uses the Apache HTTP client from HTTP Components (http://hc.apache.org/httpcomponents-client-ga/)

import java.net.URI;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class JavaSample {

    public static void main(String[] args) {
        HttpPost httpPost = new HttpPost(HttpPost.METHOD_NAME);
        HttpGet httpGet = new HttpGet(HttpGet.METHOD_NAME);

        CloseableHttpClient httpclient = HttpClients.createDefault();
//        HttpClient httpclient = HttpClients.createDefault();

        try {
            URIBuilder builder = new URIBuilder("https://services.cat.com/basicDaily/v4/SmuLoc/");

            builder.setParameter("limit", "{integer}");
            builder.setParameter("continuationToken", "{string}");

            URI uri = builder.build();
            HttpGet request = new HttpGet(uri);
            request.setHeader("Ocp-Apim-Subscription-Key", "{subscription key}");
            request.setHeader("Authorization", "{access token}");

            // Request body
            StringEntity reqEntity = new StringEntity("{body}");
//            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                System.out.println(EntityUtils.toString(entity));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

package http;

import jodd.http.HttpBrowser;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import jodd.util.StringPool;

/**
 * Created by reeco_000 on 2015/4/17.
 */
public class MyBrowser extends HttpBrowser {

    @Override
    protected String location(HttpResponse httpResponse) {
        String location = httpResponse.header("location");
        HttpRequest httpRequest = httpResponse.getHttpRequest();
        location = httpRequest.hostUrl() + StringPool.SLASH + "reader" + StringPool.SLASH+location;
        //System.out.println(location);
        return location;
    }

    @Override
    public String getPage() {
        if (httpResponse == null) {
            return null;
        }
        return httpResponse.charset(StringPool.UTF_8).bodyText();
    }
}

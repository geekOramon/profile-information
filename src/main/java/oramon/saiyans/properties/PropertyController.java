package oramon.saiyans.properties;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@RestController
public class PropertyController {

    @Value("${spring.application.name}")
    private String application_name;

    @Value("${config_server_uri}")
    private String uri;

    @Value("${app_profile}")
    private String profile;
    @Autowired
    private Environment environment;

    @GetMapping
    @ResponseBody
    public String properties() throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(uri + "/" + application_name + "/" + profile);
        CloseableHttpResponse response = httpclient.execute(httpGet);
        InputStreamReader input = new InputStreamReader(response.getEntity().getContent());
        String result = new BufferedReader(input).lines()
                .parallel().collect(Collectors.joining("\n"));
        return result;
    }
}

package oramon.saiyans;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import oramon.saiyans.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class UserIntegrationTest extends ApplicationTest {

    @Autowired
    protected RestTemplate restTemplate;
    private ResponseEntity<Map> lastResult;

    @When("^the client calls /user with POST")
    public void clientCallPOSTUser(){
        User suer = executePost("http://localhost:8080/user");
    }

    private User executePost(String url) {
        Map<String, String> vars = new HashMap<>();

        User user = new User();
        user.setName("lola");
        user.setSurName("ruperta");
        user.setEmail("rupertolola@yopmail.com");
        user.setPhone("65656");
        user.setPassword("empty");

        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

        User returns = restTemplate.postForObject(url, user, User.class, vars);

        return returns;
    }

    @Then("the client receives an user created with the id (\\d+)$")
    public void createUser(int id){

    }
}

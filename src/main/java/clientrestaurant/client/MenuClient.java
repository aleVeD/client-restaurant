package clientrestaurant.client;

import com.example.clientrestaurant.dto.MenuDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@ConfigurationProperties(prefix = "com.escalab.recipebook", ignoreUnknownFields = false)
@Component
public class MenuClient {

    private final String MENU_PATH="/menu";
    private String apihost;
    private final RestTemplate restTemplate;

    public MenuClient(RestTemplateBuilder restTemplate) {
        this.restTemplate = restTemplate.build();
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }

    public MenuDto getAllMenu(){
        return restTemplate.getForObject(apihost+MENU_PATH, MenuDto.class);
    }
}

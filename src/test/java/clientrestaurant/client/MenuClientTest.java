package clientrestaurant.client;

import com.example.clientrestaurant.dto.MenuDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MenuClientTest {
    @Autowired
    MenuClient client;
    @Test
    void getAllMenu() {
        MenuDto dto = client.getAllMenu();
        assertNotNull(dto);
    }
}
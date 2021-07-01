package clientrestaurant;
import com.example.clientrestaurant.config.MyRule;
import com.netflix.loadbalancer.BaseLoadBalancer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
public class ClientRestaurantApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ClientRestaurantApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        BaseLoadBalancer blb = new BaseLoadBalancer();
        MyRule mr = new MyRule();
        blb.setRule(mr);
    }
}

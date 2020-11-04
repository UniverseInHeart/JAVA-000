package src.main.java.io.github.kimmking.gateway.router;

import java.util.List;
import java.util.Random;

public class RandomHttpEndpointRouter implements HttpEndpointRouter{


    @Override
    public String route(List<String> endpoints) {
        Random r = new Random();
        int i = r.nextInt(endpoints.size());
        return endpoints.get(i);
    }
}

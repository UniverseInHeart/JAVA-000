package io.kimmking.rpcfx.demo.consumer;

import io.kimmking.rpcfx.anno.InJectT;
import io.kimmking.rpcfx.client.Rpcfx;
import io.kimmking.rpcfx.demo.api.Order;
import io.kimmking.rpcfx.demo.api.OrderService;
import io.kimmking.rpcfx.demo.api.User;
import io.kimmking.rpcfx.demo.api.UserService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RpcfxClientApplication {


    @InJectT
    UserService userService;

    @InJectT
    OrderService orderService;


    public static void main(String[] args) throws Exception {

//		client();
        RpcfxClientApplication rpcfxClientApplication = Rpcfx.Inject(RpcfxClientApplication.class);

        User user = rpcfxClientApplication.userService.findById(1);
        System.err.println("find user id=1 from server: " + user.getName());

        Order order = rpcfxClientApplication.orderService.findOrderById(1992129);
        System.err.println(String.format("find order name=%s, amount=%f", order.getName(), order.getAmount()));
    }

    private static void client() throws InstantiationException, IllegalAccessException {
        UserService userService = Rpcfx.create(UserService.class, "http://localhost:8080/");
        User user = userService.findById(1);
        System.err.println("find user id=1 from server: " + user.getName());

        OrderService orderService = Rpcfx.create(OrderService.class, "http://localhost:8080/");
        Order order = orderService.findOrderById(1992129);
        System.err.println(String.format("find order name=%s, amount=%f", order.getName(), order.getAmount()));
    }
}

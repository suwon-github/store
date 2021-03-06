
package skhappydelivery.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import skhappydelivery.StoreOrderAccepted;

@FeignClient(name="Order", url="http://localhost:8081")
public interface OrderService {
 

    @RequestMapping(method= RequestMethod.POST, path="/order")
    public Order getOrder(@RequestBody StoreOrderAccepted storeOrderAccepted);



}
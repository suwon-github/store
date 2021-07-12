package skhappydelivery;

import skhappydelivery.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired StoreRepository storeRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPayed_OrderCheck(@Payload Payed payed){

        if(!payed.validate()) return;

        System.out.println("\n\n##### listener OrderCheck : " + payed.toJson() + "\n\n");

        // Sample Logic //
        Store store = new Store();
        storeRepository.save(store);
            
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPayCancelled_StoreOrderCacelledCheck(@Payload PayCancelled payCancelled){

        if(!payCancelled.validate()) return;

        System.out.println("\n\n##### listener StoreOrderCacelledCheck : " + payCancelled.toJson() + "\n\n");

        // Sample Logic //
        Store store = new Store();
        storeRepository.save(store);
            
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}

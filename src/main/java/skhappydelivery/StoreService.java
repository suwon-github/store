package skhappydelivery;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
 public class StoreService {     

    @Autowired StoreRepository storeRepository;
	 
	 
   	/*----  POST---- 주문승인   */
	   @Transactional
	   public String StoreOrderAcceptedService(StoreOrderAccepted storeOrderAcceptedObj) throws Exception {
   
		   System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ StoreOrderAcceptedService start "+System.currentTimeMillis()+"□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
   
		   try {

			   Optional<Store> tempObj =  storeRepository.findById(storeOrderAcceptedObj.getOrderId());
			   System.out.println(" OUTput tempObj :  " + tempObj.toString());

			   Store storeObj = new Store();
   
			   if(tempObj.isPresent()){
				  storeObj = tempObj.get();		
			   }else{
				   return "no STORE data" ;
			   }
			  
			   storeObj.setOrderStatus("ORDER ACCEPT"); 
			   System.out.println(" INput storeObj :  " + storeObj.toString());
			 
			   storeRepository.save(storeObj);

			   //System.out.println(" OrderList data all :  " + orderRepository.findAll().toString());
	   
			   return "ORDERACCEPT SUCCESS";
			   
		   } catch (Exception e) {
			   return "save ORDERACCEPT Error" +e.getStackTrace();
		   }
	   }//StoreOrderAcceptedService


	   @Transactional
	   public Iterable<Store> storeListService() throws Exception {
   
		   System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ storeListService start "+System.currentTimeMillis()+"□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
   
		   try {
   
			   return storeRepository.findAll();
			   
		   } catch (Exception e) {
   
			   System.out.println("storeList Error" +e.getStackTrace());
   
			   return null;
		   }
	   }//orderListService
   
   




 }//classPayService\

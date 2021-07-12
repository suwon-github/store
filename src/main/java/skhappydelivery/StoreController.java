package skhappydelivery;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

 @RestController
 public class StoreController {

	@Autowired
    private StoreService storeService;

    	   	/*----  POST-----결재함*/
	@RequestMapping(value="/storeOrderAccepted", method=RequestMethod.POST)
	public String StoreOrderAccepted(@RequestBody StoreOrderAccepted storeOrderAcceptedObj) throws Exception {
		
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□o StoreOrderAccepted Controller start "+System.currentTimeMillis()+"□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
		System.out. println(" INput storeOrderAcceptedObj :  " + storeOrderAcceptedObj.toString());

    return storeService.StoreOrderAcceptedService(storeOrderAcceptedObj);

	} //Payed

	   	/*----  GET-----PAYED 목록 요청 */
		   @GetMapping("/storeList")
		   public Iterable<Store> storeList() throws Exception { 
	   
			   System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ storeList start "+System.currentTimeMillis()+"□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
			   
			   return  storeService.storeListService();       
		   }//payList
	   






 }//ClassStoreController

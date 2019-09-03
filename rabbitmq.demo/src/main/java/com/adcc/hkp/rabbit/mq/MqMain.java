package com.adcc.hkp.rabbit.mq;

//import com.adcc.adsb.parser.service.CatCommonDecoder;

public class MqMain {
	
	public static void main(String[] args) {
		
//		IReciverMessage iReciver = null;
//		RabbitMQReciver rbreciver = new RabbitMQReciver();
//		rbreciver.open();
//		 while(true){
//	            try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//					rbreciver.close();
//				}
//	            rbreciver.startReciver("HKP","HKP", iReciver);
//	        }
		
		RabbitMQReciver reciver = new RabbitMQReciver(); 
	      try { 
	         reciver.open(); 

	         long start = System.currentTimeMillis(); 
	         while(true){
	        	 Thread.sleep(1000);
	        	 reciver.startReciver("HKP",new IReciverMessage() { 
	 	            @Override 
	 	            public void reciver(byte[] message) { 
	 	               System.out.println(System.currentTimeMillis() + "reciver:" 
	 	                     + new String(message)); 
//	 	              Map<String, Object> resultMap = CatCommonDecoder.decode(message, "2.1");
//	 	              System.out.println(resultMap.toString());
	 	            } 
	 	         }); 
	         }
	         

	      } catch (Exception e) { 
	         // TODO Auto-generated catch block 
	         e.printStackTrace(); 
	      } 


	}

}

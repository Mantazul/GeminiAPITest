package newOrders;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestNewOrder {

    public String baseUrl = "https://api.gemini.com";
    public Headers actualHeaders = new Headers();

    @Test
    public void newOrderStatusCode() {
        //Make a call to Rest API. Check the status line, status code and headers.
        Response response = given().when().get(baseUrl + "/v1/order/new").then().statusCode(200).extract().response();
        String statusLine = response.getStatusLine();
        int statusCode = response.getStatusCode();
        Headers expectedHeaders = response.getHeaders();
        Assert.assertEquals(actualHeaders, expectedHeaders);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void onSuccessParametersValidation() {
        /*
         After placing sample order.If Success, verify below response for each parameter.

        {
            "order_id": "22333",
                "client_order_id": "20150102-4738721",
                "symbol": "btcusd",
                "price": "34.23",
                "avg_execution_price": "34.24",
                "side": "buy",
                "type": "exchange limit",
                "timestamp": "128938491",
                "timestampms": 128938491234,
                "is_live": true,
                "is_cancelled": false,
                "options": ["maker-or-cancel"],
                "executed_amount": "12.11",
                "remaining_amount": "16.22",
                "original_amount": "28.33"
        } */
    }

    @Test
    public void onFailureResponse() {

        //After placing sample order.If fails: verify failure response.
    }

    @Test
    public void traderRoleNewOrderRequest() {
        /*
        Check Roles on each New Order API request:

        a) API key that can trade. (for Trader Role)
           if(isRole.equalIgnoreCase("trader")){

               beingTraderAttemptToPlaySuccessfulRole(){
                  //should execute successful action
               }

               beingTraderAttemptToPlayFundManagerRole(){
                 //should give error
               }
               beingTraderAttemptToPlayAuditorRole(){
                 //should give error
               } */

    }

    @Test
    public void fundManagerRoleNewOrderRequest() {
    /*
        b) API key that can withdraw digital assets to a whitelisted address. (for Fund Manager)
           if(isRole.equalIgnoreCase("fundManger")){

               beingFundManagerAttemptToPlaySuccessfulRole(){
                  //should execute successful action
               }
               beingFundManagerAttemptToPlayTraderRole(){
                 //should give error
               }
               beingFundManagerAttemptToPlayAuditorRole(){
                 //should give error
               }

         } */
     }

    @Test
    public void auditorRoleNewOrderRequest() {
        /*

        c) API key to have access to read-only endpoints. (for Auditor)
           if(isRole.equalIgnoreCase("auditor")){

               beingAuditorAttemptToPlaySuccessfulRole(){
                  //should execute successful action
               }
               beingAuditorAttemptToPlayTraderRole(){
                 //should give error
               }
               beingAuditorAttemptToPlayFundManagerRole(){
                 //should give error
               }

            }*/
     }

     @Test
     public void oderExecutionOptions(){
        /*
         Check Order Execution Options:

         a) Maker-or-Cancel:

            if(partialOrderFilled){
                boolean is_cancelled = true;
                placeOnOrderBook();
             }

          b) Immediate-or-cancel:

              if(immediatePartialOrderFilled){
                boolean is_cancelled = true;
                removeFromOrderBook();
             }

           c) Auction-only:

               if((orderSHowUpOnPrivateApiOnly()==true) || (orderNotSHowUpOnPublicApi()==true)){
                      addOrderToAuctionBook();
                   }
               if(unfilledAuctionOnlyOrders){
                      cancelledOrders();
                   }
               if(auctionLock){
                    rejectCancelRequest();
                  }

            d) Indication of Interest:

            verifyOrderIsNotInPublicAPI();
            verifyOrderShowUpInPrivateAPI();
            orderLastPeriodOfTimeAfterSubmission(60 seconds);

            e) Unsupported Options:

             if(unsupportedOptions){
                cancelOrder();
               }

          */

      }
      @Test
      public void privateApiInvocation(){
         /*
         authentication();
         session();
         heartBeat();
         payload();
         */
      }

      @Test
      public void orderStatus(){
          /*
           request();
           pai();
           orderId();
           */
      }


   //Sample of Successful Call without authentication
    @Test
    public void callSymbolApi(){
        Response response = given().when().get("https://api.gemini.com/v1/symbols").then().statusCode(200).extract().response();
        String statusLine = response.getStatusLine();
        int statusCode = response.getStatusCode();
        String body = response.getBody().prettyPrint();
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
        Assert.assertEquals(statusCode, 200);
    }
}

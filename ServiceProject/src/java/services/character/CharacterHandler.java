/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.character;

import java.util.Set;
import java.util.Collections;
import javax.xml.namespace.QName;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.soap.SOAPMessage;

public class CharacterHandler implements SOAPHandler<SOAPMessageContext>
{
  public Set<QName> getHeaders()
  {
    return Collections.emptySet();
  }

  public boolean handleMessage(SOAPMessageContext messageContext)
  {
     Boolean outboundProperty = (Boolean)
         messageContext.get (MessageContext.MESSAGE_OUTBOUND_PROPERTY);

     if (outboundProperty) {
         System.out.println("\nOutbound message:");
     } else {
         System.out.println("\nInbound message:");
     }

     System.out.println("** Response: "+messageContext.getMessage().toString());
    return true;
  }

  public boolean handleFault(SOAPMessageContext messageContext)
  {
    return true;
  }
  public void close(MessageContext messageContext)
  {
  }
}

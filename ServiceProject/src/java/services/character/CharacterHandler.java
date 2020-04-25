/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.character;

import java.util.ArrayList;
import java.util.Set;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.soap.SOAPMessage;
import org.w3c.dom.Document;

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
     try {
        SOAPMessage msg = messageContext.getMessage();
        SOAPEnvelope env = msg.getSOAPPart().getEnvelope();
        SOAPHeader head = env.getHeader();
        SOAPBody body = env.getBody();
        
        Iterator it = head.extractAllHeaderElements();
        while (it.hasNext())
        {
            Node next = (Node) it.next();
            String value = (next == null) ? null : next.getValue();
            System.out.println(value);
        }       
        
        System.out.println("** Response: "+messageContext.getMessage().toString());
     }
     catch (Exception e)
     {
         e.printStackTrace();
     }

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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controllers;

import java.util.Set;
import java.util.Collections;
import java.util.Iterator;
import javax.xml.namespace.QName;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
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
     String inOut;

     if (outboundProperty) {
        System.out.println("\nOutbound message:");
        inOut = "outbound";

     } else {
         System.out.println("\nInbound message:");
         inOut = "inbound";
     }
     try {
        SOAPMessage msg = messageContext.getMessage();
        SOAPEnvelope env = msg.getSOAPPart().getEnvelope();
        SOAPHeader head = env.getHeader();
        
        Iterator it = head.getChildElements();
        while (it.hasNext())
        {
            Node n = (Node)it.next();
            String val = n.getValue();
            if (val != null || val != "\n")
            {
                String message = "Read: " + val + " from " + inOut + " SOAP message header";
                System.out.println(message);
            }
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

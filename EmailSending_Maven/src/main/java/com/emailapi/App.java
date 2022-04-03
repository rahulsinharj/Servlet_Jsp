package com.emailapi;

import java.io.File;
import java.nio.file.Paths;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Message App Running !" );
        
        String textMessage = "Hello dear, This message is only for Demo Purpose. " +"\n"+"\n" +"Thanks & regards," +"\n" +"Rahul Sinha";
        String subject = "Normal Message for check";
        String receiverMail = "rahulkumarsinha.17@gmail.com";
        String senderMail = "rahulsinhainfo1@gmail.com";
        
        App a1 = new App();
//      a1.sendTextEmail(textMessage, subject, receiverMail, senderMail);
        a1.sendAttachmentEmail(textMessage, subject, receiverMail, senderMail);
       
       
    }
 
/*========================================================================================================================	
=================[This method is responsible to sending Normal TEXT email :]==============================================*/ 
    
	public void sendTextEmail(String textMessage, String subject, String receiverMail, String senderMail) 
	{
		Properties properties = System.getProperties();			// Getting System Properties
			System.out.println("Properties : " +properties);
		
	//======{Setting important information to properties object}========
		
		String host = "smtp.gmail.com";							// Variable for Gmail	
		properties.put("mail.smtp.host", host);					// Setting Host
		properties.put("mail.smtp.port", "465");				// Setting Port
		properties.put("mail.smtp.ssl.enable", "true");			// Enabling SSL
		properties.put("mail.smtp.auth", "true");				// Enabling Auth
		
			System.out.println("Properties : " +properties);
			
	//======={STEP1 - Getting SESSION object}===========================
		
		Session session = Session.getInstance(properties, new Authenticator(){

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
			
				return new PasswordAuthentication(senderMail, "Info@1234");
			}
			
		});  
		
		session.setDebug(true);							// For Enabling Debugging facilites as well
		
	//======={STEP2 - Compose the message(Text, Multimedia)}===========================		
		
		MimeMessage mimeMessage = new MimeMessage(session);
		try 
		{
			mimeMessage.setFrom(senderMail);			// Setting Sender's Email 
			
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(receiverMail));		// Setting Receiver's Email , or Recipient Email
			
//			mimeMessage.addRecipients(Message.RecipientType.TO, new InternetAddress[]{
//					new InternetAddress("rahulksinha08@gmail.com") ,
//					new InternetAddress("rahulkumarsinha.17@gmail.com") ,
//					new InternetAddress("rj532903@gmail.com")
//			});
			
			mimeMessage.setSubject(subject);			// Adding Subject to Message
			mimeMessage.setText(textMessage);			// Adding Normal TEXT as message body
	
	//======={STEP3 - Send the Message using Transport class}===========================		
		
		Transport.send(mimeMessage);
			System.out.println("Email send Successfully.......!");
			
		} 
		catch (MessagingException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

/*========================================================================================================================	
=================[This method is responsible to sending email with ATTACHMENT :]==========================================*/

	public void sendAttachmentEmail(String textMessage, String subject, String receiverMail, String senderMail) 
	{
		Properties properties = System.getProperties();			// Getting System Properties
		System.out.println("Properties : " +properties);
	
	//======{Setting important information to properties object}========
		
		String host = "smtp.gmail.com";						// Variable for Gmail	
		properties.put("mail.smtp.host", host);				// Setting Host
		properties.put("mail.smtp.port", "465");			// Setting Port
		properties.put("mail.smtp.ssl.enable", "true");		// Enabling SSL
		properties.put("mail.smtp.auth", "true");			// Enabling Auth
		
			System.out.println("Properties : " +properties);
			
		//======={STEP1 - Getting SESSION object}===========================
		
		Session session = Session.getInstance(properties, new Authenticator(){
	
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
			
				return new PasswordAuthentication(senderMail, "Info@1234");
			}
			
		});  
		
		session.setDebug(true);							// For Enabling Debugging facilites as well
		
	//======={STEP2 - Compose the message(Text, Multimedia)}===========================		
		
		MimeMessage mimeMessage = new MimeMessage(session);
		try 
		{
			mimeMessage.setFrom(senderMail);			// Setting Sender's Email 
			
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(receiverMail));		// Setting Receiver's Email , or Recipient Email
			
			mimeMessage.setSubject(subject);			// Adding Subject to Message
		
			String attachmentFilePath = Paths.get("src/main/java/com/emailAttachment" +File.separator +"contact_logo.jpg").toAbsolutePath().toString();
		    	System.out.println(attachmentFilePath);				// 	E:\Stu\Code Files\eclipse-workspace\EmailSending_Maven\com\emailAttachment\contact_logo.jpg   
		    
		    MimeMultipart mimeMultipart = new MimeMultipart();		// It can contain both Texts & Attatchments. 
		    
		    try {
		    	MimeBodyPart textMime = new MimeBodyPart();
			 		textMime.setText(textMessage); 					// textMime me "textMessage" aagya
		    	
			    MimeBodyPart fileMime = new MimeBodyPart();
			    	File file = new File(attachmentFilePath);
			    	fileMime.attachFile(file);						// fileMime me "attachmentFilePath" aagya
		    	
		    	mimeMultipart.addBodyPart(textMime);				// textMime & fileMime ko "mimeMultipart" me rakh rahe hai.
		    	mimeMultipart.addBodyPart(fileMime);
		    	
			} 
		    catch (Exception e) {
				e.printStackTrace();
			}
		    
		    mimeMessage.setContent(mimeMultipart);					// Adding "mimeMultipart" as Attachment+Text in message body of "mimeMessage".
		    	
		    
	//======={STEP3 - Send the Message using Transport class}===========================		
		
		Transport.send(mimeMessage);
			System.out.println("Email send Successfully.......!");
			
		} 
		catch (MessagingException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}


	




}

package com.studio.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * �����ʼ���
 * 
 * @author zoushun
 *
 */
public class MailUitls {
	/**
	 * �����ʼ��ķ���
	 * 
	 * @param to
	 *            :�ռ���
	 * @param code
	 *            :������
	 * @throws MessagingException
	 * @throws AddressException
	 */
	public static void sendMail(String to, String code) throws AddressException, MessagingException {
		/**
		 * 1.���һ��Session����. 2.����һ�������ʼ��Ķ���Message. 3.�����ʼ�Transport
		 */
		// 1.������Ӷ���
		Properties properties = new Properties();
		properties.put("mail.transport.protocol", "smtp");// ����Э��
		properties.put("mail.smtp.host", "smtp.qq.com");// ������
		properties.put("mail.smtp.port", 465);// �˿ں�
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.ssl.enable", "true");// �����Ƿ�ʹ��ssl��ȫ���� ---һ�㶼ʹ��
		properties.put("mail.debug", "true");// �����Ƿ���ʾdebug��Ϣ true ���ڿ���̨��ʾ�����Ϣ
		// �õ��ػ�����
		Session session = Session.getInstance(properties);
		// ��ȡ�ʼ�����
		Message message = new MimeMessage(session);
		// ���÷����������ַ
		message.setFrom(new InternetAddress("1677474181@qq.com"));
		// �����ռ��˵�ַ m
		message.setRecipients(RecipientType.TO, new InternetAddress[] { new InternetAddress(to) });
		// ���� CC ����BCC
		// ���ñ���
		message.setSubject("�����Ҹ�Ӱ¥�ٷ������ʼ�");
		// �����ʼ�����:
		message.setContent(
				"<h1>�Ҹ�Ӱ¥�ٷ������ʼ�!������������ɼ������!</h1><h3><a href='http://172.27.135.184:8080/photographic_studio/user/userAction_active.action?code="
						+ code + "'>http://172.17.180.117/16:8080/photographic_studio/user/userAction_active.action?code=" + code
						+ "</a></h3>",
				"text/html;charset=UTF-8");
		// 3.�����ʼ�:

		// �õ��������
		Transport transport = session.getTransport();
		// �����Լ��������˻�
		transport.connect("1677474181@qq.com", "zuhgxfliyqhuebcb");// ����Ϊ�ղŵõ�����Ȩ��
		// �����ʼ�
		transport.sendMessage(message, message.getAllRecipients());
	}
	public static void sendPassByMail(String to, String code) throws AddressException, MessagingException {
		/**
		 * 1.���һ��Session����. 2.����һ�������ʼ��Ķ���Message. 3.�����ʼ�Transport
		 */
		// 1.������Ӷ���
		Properties properties = new Properties();
		properties.put("mail.transport.protocol", "smtp");// ����Э��
		properties.put("mail.smtp.host", "smtp.qq.com");// ������
		properties.put("mail.smtp.port", 465);// �˿ں�
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.ssl.enable", "true");// �����Ƿ�ʹ��ssl��ȫ���� ---һ�㶼ʹ��
		properties.put("mail.debug", "true");// �����Ƿ���ʾdebug��Ϣ true ���ڿ���̨��ʾ�����Ϣ
		// �õ��ػ�����
		Session session = Session.getInstance(properties);
		// ��ȡ�ʼ�����
		Message message = new MimeMessage(session);
		// ���÷����������ַ
		message.setFrom(new InternetAddress("1677474181@qq.com"));
		// �����ռ��˵�ַ m
		message.setRecipients(RecipientType.TO, new InternetAddress[] { new InternetAddress(to) });
		// ���� CC ����BCC
		// ���ñ���
		message.setSubject("�����Ҹ�Ӱ¥�ٷ�����Ѱ���ʼ�");
		// �����ʼ�����:
		message.setContent(
				"<h1>�Ҹ�Ӱ¥�ٷ��ʼ�!</h1><h3>���������ǣ�"+ code + "</h3>","text/html;charset=UTF-8");
		// 3.�����ʼ�:

		// �õ��������
		Transport transport = session.getTransport();
		// �����Լ��������˻�
		transport.connect("1677474181@qq.com", "zuhgxfliyqhuebcb");// ����Ϊ�ղŵõ�����Ȩ��
		// �����ʼ�
		transport.sendMessage(message, message.getAllRecipients());
	}
}

package oleksii.filonov.googleanalytics.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import oleksii.filonov.googleanalytics.utils.SessionUtils;

@WebListener
public class CreateCartListener implements HttpSessionListener {

	@Override
	public void sessionCreated(final HttpSessionEvent se) {
		System.out.println("CreateCartListener.sessionCreated()");
		SessionUtils.createCart(se.getSession());
	}

	@Override
	public void sessionDestroyed(final HttpSessionEvent se) {
	}

}

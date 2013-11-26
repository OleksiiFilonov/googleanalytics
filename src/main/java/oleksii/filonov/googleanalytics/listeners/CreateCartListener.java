package oleksii.filonov.googleanalytics.listeners;

import javax.annotation.Resource;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import oleksii.filonov.googleanalytics.utils.SessionUtils;

@WebListener
public class CreateCartListener implements HttpSessionListener {
	
	@Resource
	private SessionUtils sessionUtils;

	@Override
	public void sessionCreated(final HttpSessionEvent se) {
		sessionUtils.createCart(se.getSession());
	}

	@Override
	public void sessionDestroyed(final HttpSessionEvent se) {
	}

}
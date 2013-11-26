package oleksii.filonov.googleanalytics.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import oleksii.filonov.googleanalytics.utils.SessionUtils;

@WebListener
public class CreateCartListener implements HttpSessionListener {
	
	private SessionUtils sessionUtils;

	@Override
	public void sessionCreated(final HttpSessionEvent se) {
		getSessionUtils(se).createCart(se.getSession());
	}

	private SessionUtils getSessionUtils(final HttpSessionEvent se) {
		if(sessionUtils == null) {
			ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(se.getSession().getServletContext());
			sessionUtils = (SessionUtils) ctx.getBean("sessionUtils");
		}
		return sessionUtils;
	}

	@Override
	public void sessionDestroyed(final HttpSessionEvent se) {
	}

}
package oleksii.filonov.googleanalytics.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import oleksii.filonov.googleanalytics.utils.SessionUtils;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebListener
public class CreateCartListener implements HttpSessionListener {

	private SessionUtils sessionUtils;

	@Override
	public void sessionCreated(final HttpSessionEvent se) {
		getSessionUtils(se).createCart(se.getSession());
		se.getSession().getServletContext().log("Session Cart Created");
	}

	private SessionUtils getSessionUtils(final HttpSessionEvent se) {
		if(this.sessionUtils == null) {
			final ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(se.getSession().getServletContext());
			this.sessionUtils = (SessionUtils) ctx.getBean("sessionUtils");
		}
		return this.sessionUtils;
	}

	@Override
	public void sessionDestroyed(final HttpSessionEvent se) {
	}

}
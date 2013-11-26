package oleksii.filonov.googleanalytics.listeners;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.web.context.WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

import oleksii.filonov.googleanalytics.domainmodel.Order;
import oleksii.filonov.googleanalytics.utils.RandomOrderGenerator;
import oleksii.filonov.googleanalytics.utils.SessionUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.context.WebApplicationContext;

@RunWith(MockitoJUnitRunner.class)
public class CreateCartListenerTest {

	private CreateCartListener testInstance;

	@Mock
	private WebApplicationContext ctx;
	@Mock
	private ServletContext servletContext;
	@Mock
	private HttpSession session;

	@Before
	public void setUp() {
		this.testInstance = new CreateCartListener();
		when(this.session.getServletContext()).thenReturn(this.servletContext);
		when(this.servletContext.getAttribute(ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE)).thenReturn(this.ctx);
		final SessionUtils sessionUtils = new SessionUtils();
		ReflectionTestUtils.setField(sessionUtils, "orderGenerator", new RandomOrderGenerator());
		when(this.ctx.getBean("sessionUtils")).thenReturn(sessionUtils);
	}

	@Test
	public void shouldAddCartAttribute() {
		final HttpSessionEvent sessionEvent = new HttpSessionEvent(this.session);
		this.testInstance.sessionCreated(sessionEvent);
		verify(this.session).setAttribute(eq("cart"), any(Order.class));
	}



}

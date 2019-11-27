package com.nomagic.integration.demo.command.handlers;

import com.nomagic.magicdraw.cookies.CloseCookie;
import com.nomagic.magicdraw.cookies.Cookie;
import com.nomagic.magicdraw.cookies.CookieSet;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.runtime.ApplicationExitedException;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.handlers.IHandlerService;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class SampleHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public SampleHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		IHandlerService handlerService = (IHandlerService) window.getService(IHandlerService.class);
		Application application = Application.getInstance();
		try {
			application.start(new String[0]);
		} catch (ApplicationExitedException e) {
			throw new ExecutionException(e.getMessage(), e);
		}
		CookieSet cookieSet = application.getCookieSet();
		Cookie prevCookie = cookieSet.getCookie(CloseCookie.class);
		if (prevCookie != null) {
			cookieSet.remove(prevCookie);
		}
		cookieSet.add(new CloseCookie() {
			@Override
			public void close(byte closeStatus) {
				application.getMainFrame().setVisible(false);
				Display.getDefault().asyncExec(new Runnable() {
					@Override
					public void run() {
						try {
							handlerService.executeCommand("org.eclipse.ui.file.exit", null);
						} catch (Exception e) {
							e.printStackTrace();
							throw new RuntimeException(e);
						}
					}
				});
			}
		});
		return null;
	}
}

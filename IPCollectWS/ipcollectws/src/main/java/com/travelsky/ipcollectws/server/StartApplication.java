package com.travelsky.ipcollectws.server;

import java.io.IOException;

import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.nio.SelectChannelConnector;
import org.mortbay.jetty.webapp.WebAppContext;

/**
 * 
 * <p>
 * <a href="StartApplication.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:wujx21cn@gmail.com">Jason Wu</a>
 */
class JettyServer {
	int port = 9000; // 端口号
	String webContext = "/wsDemo"; // 上下文路径
	String resourceBase = "./src/main/webapp/"; // web工程目录

	public JettyServer(String configFile) throws IOException {
		if (configFile == null) {
		}
	}

	public void startServer() {
		try {
			Server server = new Server();
			Connector connector = new SelectChannelConnector();
			connector.setPort(port);
			server.setConnectors(new Connector[] { connector });
			WebAppContext webapp = new WebAppContext();
			webapp.setContextPath(webContext);
			webapp.setResourceBase(resourceBase);
			server.setHandler(webapp);
			server.start();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class StartApplication {
	public static void main(String[] args) throws Exception {
		JettyServer server = new JettyServer(null);
		server.startServer();
	}
}

package org.jboss.tools.ui.bot.ext.test.config;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.jboss.tools.ui.bot.ext.SWTTestExt;
import org.jboss.tools.ui.bot.ext.config.Annotations.SWTBotTestRequires;
import org.jboss.tools.ui.bot.ext.config.Annotations.Server;
import org.jboss.tools.ui.bot.ext.config.Annotations.ServerType;
import org.jboss.tools.ui.bot.ext.helper.ContextMenuHelper;
import org.jboss.tools.ui.bot.ext.types.IDELabel;
import org.junit.Test;


@SWTBotTestRequires(server=@Server(type=ServerType.EPP),perspective="Java EE")
public class AnnotatedEPPServer extends SWTTestExt {

	@Test
	public void configuredState() {
		assertTrue(configuredState.getServer().isRunning);
		assertTrue(configuredState.getServer().isConfigured);
		assertNotNull(configuredState.getServer().version);
		assertNotNull(configuredState.getServer().type);
		assertNotNull(configuredState.getServer().name);
		assertNotNull(configuredState.getServer().withJavaVersion);
	}
	
	@Test
	public void serverExists() {
		boolean found=false;
		for (SWTBotTreeItem item : servers.show().bot().tree().getAllItems()) {
			if (item.getText().startsWith(configuredState.getServer().name)) {
				found = true;
				break;
			}
		}
		assertTrue(found);
	}
	
	@Test
	public void serverRunning() {
		SWTBotTreeItem server =null;
		SWTBotTree tree = servers.show().bot().tree();
		for (SWTBotTreeItem item : tree.getAllItems()) {
			if (item.getText().startsWith(configuredState.getServer().name)) {
				server = item;
				break;
			}
		}
		if (server!=null) {
			ContextMenuHelper.prepareTreeItemForContextMenu(tree, server);
	        assertTrue(new SWTBotMenu(ContextMenuHelper.getContextMenu(tree, IDELabel.Menu.STOP, false)).isEnabled());
		}
	}
	
}
/******************************************************************************* 
 * Copyright (c) 2011 Red Hat, Inc. 
 * Distributed under license by Red Hat, Inc. All rights reserved. 
 * This program is made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 * Red Hat, Inc. - initial API and implementation 
 ******************************************************************************/ 
package org.jboss.tools.jst.web.kb.preferences;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * @author Viacheslav Kabanovich
 */
public class KBPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {
	
	/**
	 * @see plugin.xml descriptor for ID
	 */
	public static final String ID = "org.jboss.tools.common.model.ui.kb"; //$NON-NLS-1$

	@Override
	protected Control createContents(Composite parent) {
		Composite root = new Composite(parent, SWT.NONE);
		GridLayout gl = new GridLayout(1, false);
		root.setLayout(gl);
		
		Label lable = new Label(root, 0);
		lable.setText(KBPreferencesMessages.KB_DESCRIPTION);

		return root;
	}

	public void init(IWorkbench workbench) {
	}
}
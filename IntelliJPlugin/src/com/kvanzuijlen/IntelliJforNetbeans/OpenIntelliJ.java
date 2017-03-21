/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvanzuijlen.IntelliJforNetbeans;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.awt.NotificationDisplayer;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "System",
        id = "com.kvanzuijlen.IntelliJforNetbeans.OpenIntelliJ"
)
@ActionRegistration(
        displayName = "#CTL_OpenIntelliJ"
)
@ActionReference(path = "Menu/Tools", position = 1800, separatorBefore = 1750)
@Messages("CTL_OpenIntelliJ=Open IntelliJ")
public final class OpenIntelliJ implements ActionListener {
    
    public static final String INTELLIJ_VERSION = "IntelliJ IDEA 2016.3.4";

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            System.out.println("C:\\Program Files (x86)\\Jetbrains\\"+INTELLIJ_VERSION+"\\bin\\idea.exe");
            new ProcessBuilder("C:\\Program Files (x86)\\Jetbrains\\"+INTELLIJ_VERSION+"\\bin\\idea.exe").start();
        } catch (IOException error) {
            NotificationDisplayer displayer = NotificationDisplayer.getDefault();
            String downloadLink = "https://download-cf.jetbrains.com/idea/ideaIU-2016.3.4.exe";
            displayer.notify("Not found", NotificationDisplayer.Priority.HIGH.getIcon(), INTELLIJ_VERSION+" not found download this version from "+downloadLink+" (it's been copied to your clipboard)", null);
            StringSelection stringSelection = new StringSelection(downloadLink);
            Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
            clpbrd.setContents(stringSelection, null);
        }
    }
}

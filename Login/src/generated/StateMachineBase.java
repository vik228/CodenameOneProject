/**
 * This class contains generated code from the Codename One Designer, DO NOT MODIFY!
 * This class is designed for subclassing that way the code generator can overwrite it
 * anytime without erasing your changes which should exist in a subclass!
 * For details about this file and how it works please read this blog post:
 * http://codenameone.blogspot.com/2010/10/ui-builder-class-how-to-actually-use.html
*/
package generated;

import com.codename1.ui.*;
import com.codename1.ui.util.*;
import com.codename1.ui.plaf.*;
import com.codename1.ui.events.*;

public abstract class StateMachineBase extends UIBuilder {
    private Container aboutToShowThisContainer;
    /**
     * this method should be used to initialize variables instead of
     * the constructor/class scope to avoid race conditions
     */
    /**
    * @deprecated use the version that accepts a resource as an argument instead
    
**/
    protected void initVars() {}

    protected void initVars(Resources res) {}

    public StateMachineBase(Resources res, String resPath, boolean loadTheme) {
        startApp(res, resPath, loadTheme);
    }

    public Container startApp(Resources res, String resPath, boolean loadTheme) {
        initVars();
        UIBuilder.registerCustomComponent("Button", com.codename1.ui.Button.class);
        UIBuilder.registerCustomComponent("ComboBox", com.codename1.ui.ComboBox.class);
        UIBuilder.registerCustomComponent("Form", com.codename1.ui.Form.class);
        UIBuilder.registerCustomComponent("Label", com.codename1.ui.Label.class);
        UIBuilder.registerCustomComponent("TextField", com.codename1.ui.TextField.class);
        UIBuilder.registerCustomComponent("Container", com.codename1.ui.Container.class);
        if(loadTheme) {
            if(res == null) {
                try {
                    if(resPath.endsWith(".res")) {
                        res = Resources.open(resPath);
                        System.out.println("Warning: you should construct the state machine without the .res extension to allow theme overlays");
                    } else {
                        res = Resources.openLayered(resPath);
                    }
                } catch(java.io.IOException err) { err.printStackTrace(); }
            }
            initTheme(res);
        }
        if(res != null) {
            setResourceFilePath(resPath);
            setResourceFile(res);
            initVars(res);
            return showForm("Main", null);
        } else {
            Form f = (Form)createContainer(resPath, "Main");
            initVars(fetchResourceFile());
            beforeShow(f);
            f.show();
            postShow(f);
            return f;
        }
    }

    public Container createWidget(Resources res, String resPath, boolean loadTheme) {
        initVars();
        UIBuilder.registerCustomComponent("Button", com.codename1.ui.Button.class);
        UIBuilder.registerCustomComponent("ComboBox", com.codename1.ui.ComboBox.class);
        UIBuilder.registerCustomComponent("Form", com.codename1.ui.Form.class);
        UIBuilder.registerCustomComponent("Label", com.codename1.ui.Label.class);
        UIBuilder.registerCustomComponent("TextField", com.codename1.ui.TextField.class);
        UIBuilder.registerCustomComponent("Container", com.codename1.ui.Container.class);
        if(loadTheme) {
            if(res == null) {
                try {
                    res = Resources.openLayered(resPath);
                } catch(java.io.IOException err) { err.printStackTrace(); }
            }
            initTheme(res);
        }
        return createContainer(resPath, "Main");
    }

    protected void initTheme(Resources res) {
            String[] themes = res.getThemeResourceNames();
            if(themes != null && themes.length > 0) {
                UIManager.getInstance().setThemeProps(res.getTheme(themes[0]));
            }
    }

    public StateMachineBase() {
    }

    public StateMachineBase(String resPath) {
        this(null, resPath, true);
    }

    public StateMachineBase(Resources res) {
        this(res, null, true);
    }

    public StateMachineBase(String resPath, boolean loadTheme) {
        this(null, resPath, loadTheme);
    }

    public StateMachineBase(Resources res, boolean loadTheme) {
        this(res, null, loadTheme);
    }

    public com.codename1.ui.Container findContainer2(Component root) {
        return (com.codename1.ui.Container)findByName("Container2", root);
    }

    public com.codename1.ui.Container findContainer2() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container2", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container2", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer1(Component root) {
        return (com.codename1.ui.Container)findByName("Container1", root);
    }

    public com.codename1.ui.Container findContainer1() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTextField1(Component root) {
        return (com.codename1.ui.TextField)findByName("TextField1", root);
    }

    public com.codename1.ui.TextField findTextField1() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("TextField1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("TextField1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTextField8(Component root) {
        return (com.codename1.ui.TextField)findByName("TextField8", root);
    }

    public com.codename1.ui.TextField findTextField8() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("TextField8", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("TextField8", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findSlongi(Component root) {
        return (com.codename1.ui.Label)findByName("slongi", root);
    }

    public com.codename1.ui.Label findSlongi() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("slongi", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("slongi", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findSlati(Component root) {
        return (com.codename1.ui.Label)findByName("slati", root);
    }

    public com.codename1.ui.Label findSlati() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("slati", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("slati", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTextField9(Component root) {
        return (com.codename1.ui.TextField)findByName("TextField9", root);
    }

    public com.codename1.ui.TextField findTextField9() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("TextField9", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("TextField9", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findButton(Component root) {
        return (com.codename1.ui.Button)findByName("Button", root);
    }

    public com.codename1.ui.Button findButton() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("Button", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("Button", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel1(Component root) {
        return (com.codename1.ui.Label)findByName("Label1", root);
    }

    public com.codename1.ui.Label findLabel1() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel3(Component root) {
        return (com.codename1.ui.Label)findByName("Label3", root);
    }

    public com.codename1.ui.Label findLabel3() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label3", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label3", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel2(Component root) {
        return (com.codename1.ui.Label)findByName("Label2", root);
    }

    public com.codename1.ui.Label findLabel2() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label2", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label2", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLongim(Component root) {
        return (com.codename1.ui.Label)findByName("longim", root);
    }

    public com.codename1.ui.Label findLongim() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("longim", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("longim", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLongis(Component root) {
        return (com.codename1.ui.Label)findByName("longis", root);
    }

    public com.codename1.ui.Label findLongis() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("longis", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("longis", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel17(Component root) {
        return (com.codename1.ui.Label)findByName("Label17", root);
    }

    public com.codename1.ui.Label findLabel17() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label17", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label17", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel16(Component root) {
        return (com.codename1.ui.Label)findByName("Label16", root);
    }

    public com.codename1.ui.Label findLabel16() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label16", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label16", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel15(Component root) {
        return (com.codename1.ui.Label)findByName("Label15", root);
    }

    public com.codename1.ui.Label findLabel15() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label15", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label15", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel10(Component root) {
        return (com.codename1.ui.Label)findByName("Label10", root);
    }

    public com.codename1.ui.Label findLabel10() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label10", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label10", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel6(Component root) {
        return (com.codename1.ui.Label)findByName("Label6", root);
    }

    public com.codename1.ui.Label findLabel6() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label6", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label6", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel7(Component root) {
        return (com.codename1.ui.Label)findByName("Label7", root);
    }

    public com.codename1.ui.Label findLabel7() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label7", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label7", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel4(Component root) {
        return (com.codename1.ui.Label)findByName("Label4", root);
    }

    public com.codename1.ui.Label findLabel4() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label4", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label4", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel5(Component root) {
        return (com.codename1.ui.Label)findByName("Label5", root);
    }

    public com.codename1.ui.Label findLabel5() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label5", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label5", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLongid(Component root) {
        return (com.codename1.ui.Label)findByName("longid", root);
    }

    public com.codename1.ui.Label findLongid() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("longid", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("longid", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel8(Component root) {
        return (com.codename1.ui.Label)findByName("Label8", root);
    }

    public com.codename1.ui.Label findLabel8() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label8", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label8", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findExit(Component root) {
        return (com.codename1.ui.Button)findByName("exit", root);
    }

    public com.codename1.ui.Button findExit() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("exit", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("exit", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel9(Component root) {
        return (com.codename1.ui.Label)findByName("Label9", root);
    }

    public com.codename1.ui.Label findLabel9() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label9", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label9", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel11(Component root) {
        return (com.codename1.ui.Label)findByName("Label11", root);
    }

    public com.codename1.ui.Label findLabel11() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label11", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label11", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.ComboBox findComboBox5(Component root) {
        return (com.codename1.ui.ComboBox)findByName("ComboBox5", root);
    }

    public com.codename1.ui.ComboBox findComboBox5() {
        com.codename1.ui.ComboBox cmp = (com.codename1.ui.ComboBox)findByName("ComboBox5", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.ComboBox)findByName("ComboBox5", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.ComboBox findComboBox1(Component root) {
        return (com.codename1.ui.ComboBox)findByName("ComboBox1", root);
    }

    public com.codename1.ui.ComboBox findComboBox1() {
        com.codename1.ui.ComboBox cmp = (com.codename1.ui.ComboBox)findByName("ComboBox1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.ComboBox)findByName("ComboBox1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.ComboBox findComboBox2(Component root) {
        return (com.codename1.ui.ComboBox)findByName("ComboBox2", root);
    }

    public com.codename1.ui.ComboBox findComboBox2() {
        com.codename1.ui.ComboBox cmp = (com.codename1.ui.ComboBox)findByName("ComboBox2", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.ComboBox)findByName("ComboBox2", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.ComboBox findComboBox3(Component root) {
        return (com.codename1.ui.ComboBox)findByName("ComboBox3", root);
    }

    public com.codename1.ui.ComboBox findComboBox3() {
        com.codename1.ui.ComboBox cmp = (com.codename1.ui.ComboBox)findByName("ComboBox3", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.ComboBox)findByName("ComboBox3", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLongitude(Component root) {
        return (com.codename1.ui.Label)findByName("Longitude", root);
    }

    public com.codename1.ui.Label findLongitude() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Longitude", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Longitude", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.ComboBox findComboBox4(Component root) {
        return (com.codename1.ui.ComboBox)findByName("ComboBox4", root);
    }

    public com.codename1.ui.ComboBox findComboBox4() {
        com.codename1.ui.ComboBox cmp = (com.codename1.ui.ComboBox)findByName("ComboBox4", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.ComboBox)findByName("ComboBox4", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findMlati(Component root) {
        return (com.codename1.ui.Label)findByName("mlati", root);
    }

    public com.codename1.ui.Label findMlati() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("mlati", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("mlati", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.ComboBox findComboBox(Component root) {
        return (com.codename1.ui.ComboBox)findByName("ComboBox", root);
    }

    public com.codename1.ui.ComboBox findComboBox() {
        com.codename1.ui.ComboBox cmp = (com.codename1.ui.ComboBox)findByName("ComboBox", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.ComboBox)findByName("ComboBox", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLatitude(Component root) {
        return (com.codename1.ui.Label)findByName("Latitude", root);
    }

    public com.codename1.ui.Label findLatitude() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Latitude", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Latitude", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer(Component root) {
        return (com.codename1.ui.Container)findByName("Container", root);
    }

    public com.codename1.ui.Container findContainer() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findMin(Component root) {
        return (com.codename1.ui.Label)findByName("min", root);
    }

    public com.codename1.ui.Label findMin() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("min", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("min", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findMlongi(Component root) {
        return (com.codename1.ui.Label)findByName("mlongi", root);
    }

    public com.codename1.ui.Label findMlongi() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("mlongi", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("mlongi", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTextField(Component root) {
        return (com.codename1.ui.TextField)findByName("TextField", root);
    }

    public com.codename1.ui.TextField findTextField() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("TextField", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("TextField", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findDlongi(Component root) {
        return (com.codename1.ui.Label)findByName("dlongi", root);
    }

    public com.codename1.ui.Label findDlongi() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("dlongi", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("dlongi", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findCaptureImage(Component root) {
        return (com.codename1.ui.Button)findByName("CaptureImage", root);
    }

    public com.codename1.ui.Button findCaptureImage() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("CaptureImage", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("CaptureImage", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findDegree(Component root) {
        return (com.codename1.ui.Label)findByName("degree", root);
    }

    public com.codename1.ui.Label findDegree() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("degree", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("degree", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findSec(Component root) {
        return (com.codename1.ui.Label)findByName("sec", root);
    }

    public com.codename1.ui.Label findSec() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("sec", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("sec", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel(Component root) {
        return (com.codename1.ui.Label)findByName("Label", root);
    }

    public com.codename1.ui.Label findLabel() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findDlati(Component root) {
        return (com.codename1.ui.Label)findByName("dlati", root);
    }

    public com.codename1.ui.Label findDlati() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("dlati", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("dlati", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findSave(Component root) {
        return (com.codename1.ui.Button)findByName("Save", root);
    }

    public com.codename1.ui.Button findSave() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("Save", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("Save", aboutToShowThisContainer);
        }
        return cmp;
    }

    public static final int COMMAND_MainLOGIN = 1;

    protected boolean onMainLOGIN() {
        return false;
    }

    protected void processCommand(ActionEvent ev, Command cmd) {
        switch(cmd.getId()) {
            case COMMAND_MainLOGIN:
                if(onMainLOGIN()) {
                    ev.consume();
                    return;
                }
                break;

        }
        if(ev.getComponent() != null) {
            handleComponentAction(ev.getComponent(), ev);
        }
    }

    protected void exitForm(Form f) {
        if("Main".equals(f.getName())) {
            exitMain(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("welcome".equals(f.getName())) {
            exitWelcome(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Capture".equals(f.getName())) {
            exitCapture(f);
            aboutToShowThisContainer = null;
            return;
        }

    }


    protected void exitMain(Form f) {
    }


    protected void exitWelcome(Form f) {
    }


    protected void exitCapture(Form f) {
    }

    protected void beforeShow(Form f) {
    aboutToShowThisContainer = f;
        if("Main".equals(f.getName())) {
            beforeMain(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("welcome".equals(f.getName())) {
            beforeWelcome(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Capture".equals(f.getName())) {
            beforeCapture(f);
            aboutToShowThisContainer = null;
            return;
        }

    }


    protected void beforeMain(Form f) {
    }


    protected void beforeWelcome(Form f) {
    }


    protected void beforeCapture(Form f) {
    }

    protected void beforeShowContainer(Container c) {
    aboutToShowThisContainer = c;
        if("Main".equals(c.getName())) {
            beforeContainerMain(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("welcome".equals(c.getName())) {
            beforeContainerWelcome(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Capture".equals(c.getName())) {
            beforeContainerCapture(c);
            aboutToShowThisContainer = null;
            return;
        }

    }


    protected void beforeContainerMain(Container c) {
    }


    protected void beforeContainerWelcome(Container c) {
    }


    protected void beforeContainerCapture(Container c) {
    }

    protected void postShow(Form f) {
        if("Main".equals(f.getName())) {
            postMain(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("welcome".equals(f.getName())) {
            postWelcome(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Capture".equals(f.getName())) {
            postCapture(f);
            aboutToShowThisContainer = null;
            return;
        }

    }


    protected void postMain(Form f) {
    }


    protected void postWelcome(Form f) {
    }


    protected void postCapture(Form f) {
    }

    protected void postShowContainer(Container c) {
        if("Main".equals(c.getName())) {
            postContainerMain(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("welcome".equals(c.getName())) {
            postContainerWelcome(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Capture".equals(c.getName())) {
            postContainerCapture(c);
            aboutToShowThisContainer = null;
            return;
        }

    }


    protected void postContainerMain(Container c) {
    }


    protected void postContainerWelcome(Container c) {
    }


    protected void postContainerCapture(Container c) {
    }

    protected void onCreateRoot(String rootName) {
        if("Main".equals(rootName)) {
            onCreateMain();
            aboutToShowThisContainer = null;
            return;
        }

        if("welcome".equals(rootName)) {
            onCreateWelcome();
            aboutToShowThisContainer = null;
            return;
        }

        if("Capture".equals(rootName)) {
            onCreateCapture();
            aboutToShowThisContainer = null;
            return;
        }

    }


    protected void onCreateMain() {
    }


    protected void onCreateWelcome() {
    }


    protected void onCreateCapture() {
    }

    protected boolean setListModel(List cmp) {
        String listName = cmp.getName();
        if("ComboBox5".equals(listName)) {
            return initListModelComboBox5(cmp);
        }
        if("ComboBox1".equals(listName)) {
            return initListModelComboBox1(cmp);
        }
        if("ComboBox2".equals(listName)) {
            return initListModelComboBox2(cmp);
        }
        if("ComboBox3".equals(listName)) {
            return initListModelComboBox3(cmp);
        }
        if("ComboBox4".equals(listName)) {
            return initListModelComboBox4(cmp);
        }
        if("ComboBox".equals(listName)) {
            return initListModelComboBox(cmp);
        }
        return super.setListModel(cmp);
    }

    protected boolean initListModelComboBox5(List cmp) {
        return false;
    }

    protected boolean initListModelComboBox1(List cmp) {
        return false;
    }

    protected boolean initListModelComboBox2(List cmp) {
        return false;
    }

    protected boolean initListModelComboBox3(List cmp) {
        return false;
    }

    protected boolean initListModelComboBox4(List cmp) {
        return false;
    }

    protected boolean initListModelComboBox(List cmp) {
        return false;
    }

    protected void handleComponentAction(Component c, ActionEvent event) {
        Container rootContainerAncestor = getRootAncestor(c);
        if(rootContainerAncestor == null) return;
        String rootContainerName = rootContainerAncestor.getName();
        if(c.getParent().getLeadParent() != null) {
            c = c.getParent().getLeadParent();
        }
        if(rootContainerName == null) return;
        if(rootContainerName.equals("Main")) {
            if("TextField".equals(c.getName())) {
                onMain_TextFieldAction(c, event);
                return;
            }
            if("TextField1".equals(c.getName())) {
                onMain_TextField1Action(c, event);
                return;
            }
            if("Button".equals(c.getName())) {
                onMain_ButtonAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("welcome")) {
            if("ComboBox".equals(c.getName())) {
                onWelcome_ComboBoxAction(c, event);
                return;
            }
            if("ComboBox1".equals(c.getName())) {
                onWelcome_ComboBox1Action(c, event);
                return;
            }
            if("ComboBox2".equals(c.getName())) {
                onWelcome_ComboBox2Action(c, event);
                return;
            }
            if("ComboBox3".equals(c.getName())) {
                onWelcome_ComboBox3Action(c, event);
                return;
            }
            if("ComboBox4".equals(c.getName())) {
                onWelcome_ComboBox4Action(c, event);
                return;
            }
            if("ComboBox5".equals(c.getName())) {
                onWelcome_ComboBox5Action(c, event);
                return;
            }
            if("TextField8".equals(c.getName())) {
                onWelcome_TextField8Action(c, event);
                return;
            }
            if("TextField9".equals(c.getName())) {
                onWelcome_TextField9Action(c, event);
                return;
            }
            if("Save".equals(c.getName())) {
                onWelcome_SaveAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("Capture")) {
            if("CaptureImage".equals(c.getName())) {
                onCapture_CaptureImageAction(c, event);
                return;
            }
            if("TextField".equals(c.getName())) {
                onCapture_TextFieldAction(c, event);
                return;
            }
            if("exit".equals(c.getName())) {
                onCapture_ExitAction(c, event);
                return;
            }
        }
    }

      protected void onMain_TextFieldAction(Component c, ActionEvent event) {
      }

      protected void onMain_TextField1Action(Component c, ActionEvent event) {
      }

      protected void onMain_ButtonAction(Component c, ActionEvent event) {
      }

      protected void onWelcome_ComboBoxAction(Component c, ActionEvent event) {
      }

      protected void onWelcome_ComboBox1Action(Component c, ActionEvent event) {
      }

      protected void onWelcome_ComboBox2Action(Component c, ActionEvent event) {
      }

      protected void onWelcome_ComboBox3Action(Component c, ActionEvent event) {
      }

      protected void onWelcome_ComboBox4Action(Component c, ActionEvent event) {
      }

      protected void onWelcome_ComboBox5Action(Component c, ActionEvent event) {
      }

      protected void onWelcome_TextField8Action(Component c, ActionEvent event) {
      }

      protected void onWelcome_TextField9Action(Component c, ActionEvent event) {
      }

      protected void onWelcome_SaveAction(Component c, ActionEvent event) {
      }

      protected void onCapture_CaptureImageAction(Component c, ActionEvent event) {
      }

      protected void onCapture_TextFieldAction(Component c, ActionEvent event) {
      }

      protected void onCapture_ExitAction(Component c, ActionEvent event) {
      }

}

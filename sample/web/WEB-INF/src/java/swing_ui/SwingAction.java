package swing_ui;

import java.awt.event.ActionEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;

/**An action for Swing, which can throw any Exception.*/
public abstract class SwingAction extends AbstractAction {
	

	/**The baseName for locating the exception message text resource bundle.*/ 
	public static final String BASE_NAME = "MessageResources";
	
	/**Initializes a SwingAction.
	 * @param name how to name the button or menu item, which is associated with the action.
	*/
	public SwingAction(final String name){
		super(name);
	}

	public void actionPerformed(final ActionEvent ev) {
	    try{
	    	actionPerformedWithThrows(ev);
	    }catch(Exception ex){
			final java.awt.Component sourceComponent = (java.awt.Component)ev.getSource();
			final Locale defaultLocale = Locale.getDefault();
			final ResourceBundle bundle = ResourceBundle.getBundle(BASE_NAME, defaultLocale);
			multex.Swing.report(sourceComponent, ex, bundle);
		}
	}
	
	/**This method is to be implemented by client actions. It may throw any Exception, 
	 * which will then be reported by MulTEx services.
	*/
	public abstract void actionPerformedWithThrows(final ActionEvent ev) throws Exception;

	
}

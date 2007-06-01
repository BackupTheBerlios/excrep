package swing_ui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

/**An action for Swing, which can throw any Exception.*/
public abstract class SwingAction extends AbstractAction {
	
	
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
	    	 multex.Swing.report(sourceComponent, ex);
	     }
	}
	
	/**This method is to be implemented by client actions. It may throw any Exception, 
	 * which will then be reported by MulTEx services.
	*/
	public abstract void actionPerformedWithThrows(final ActionEvent ev) throws Exception;

	
}

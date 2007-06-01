package swing_ui;

import java.awt.EventQueue;
import java.awt.Window;

/**Services for usage of Swing*/
public class SwingUtil {

	/**Makes the window visible on the EventQueue Thread.*/
	/*package*/ static void show(final Window io_window) {
	  	EventQueue.invokeLater(new SwingUtil.WindowShower(io_window, true));
    }
	
	/**Makes the window invisible on the EventQueue Thread.*/
	/*package*/ static void hide(final Window io_window) {
	  	EventQueue.invokeLater(new SwingUtil.WindowShower(io_window, false));
    }
	
	/**Shows a window in the AWT event queue thread.
	 * @see http://java.sun.com/developer/JDCTechTips/2003/tt1208.html
	 */
	private static class WindowShower implements Runnable {
	    private final Window  window;
	    private final boolean isVisible;
	    
	    public WindowShower(final Window io_window, final boolean isVisible) {
	      this.window = io_window;
	      this.isVisible = isVisible;
	    }
	    
	    public void run() {
		  window.pack();
		  window.setVisible(this.isVisible);
	    }
	}
}

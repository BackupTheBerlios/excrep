package swing_ui;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import lg.Client;
import lg.Session;
import multex.Exc;
import multex.Failure;


/**The list view of all registered clients.*/
public class ClientListDialog extends JDialog {

	private static final long serialVersionUID = -8591653225035745301L;

    private final java.awt.Container contentPane = getContentPane();
	private final ClientSwingApplication owner;
	private final Session session;
	private final JTable table = new JTable();
	
	public ClientListDialog(final ClientSwingApplication owner, final Session session){
		super(owner.getEditFrame(), "Client List");
		this.owner = owner;
		this.session = session;	    

		contentPane.add(table, BorderLayout.CENTER);
		contentPane.add(new JButton(createAction), BorderLayout.SOUTH);
	}
	
	/*package*/ void reload() throws Exc {

		final List<Client> clientList = session.searchAllClients();
		
		final TableModel dataModel = new AbstractTableModel() {
	        public int getColumnCount() { return 7; }
	        @Override
			public String getColumnName(final int column){
	        	switch(column){
	        	case 0: return "ID";
	        	case 1: return "First Name";
	        	case 2: return "Last Name";
	        	case 3: return "Birth Date";
	        	case 4: return "Phone Number";
	        	case 5: return "Actions";
	        	case 6: return "";
	        	default: throw new Failure("Unknown column number {0}", null, column);
	        	}
	        }
	        public int getRowCount() { return clientList.size();}
	        public Object getValueAt(int row, int col) { 
	        	return new Integer(row*col); 
	        }
	    };
	    table.setModel(dataModel);
	    
	}
	
    final Action createAction = new SwingAction("Create"){
        @Override
		public void actionPerformedWithThrows(ActionEvent evt) throws Exc {
            System.out.println("Create ...");
    		owner.reset();
    	    SwingUtil.hide(ClientListDialog.this);
        }
    };

}

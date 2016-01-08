package desktop_codebehind;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import desktop_fields.GUI_Field;

/**
 * Listens to mouse action on fields
 * @author Ronnie
 */
public class FieldMouseListener implements MouseListener{
	private GUI_Field field;
    
    public FieldMouseListener(GUI_Field field){
        this.field = field;
    }
    /**
     * Called when the mouse is over a field
     */
    @Override
    public void mouseEntered(MouseEvent e) {
    	this.field.displayOnCenter();
    }
    /**
     * Called when the mouse is no longer over a field
     */
    @Override
    public void mouseExited(MouseEvent e) {
    	GUI_Center.getInstance().displayDefault();
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        //Do nothing
    }
    @Override
    public void mousePressed(MouseEvent e) {
       //Do nothing
    }
    @Override
    public void mouseReleased(MouseEvent e) {
       //Do nothing
    }
}
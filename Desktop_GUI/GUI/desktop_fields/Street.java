package desktop_fields;

import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import desktop_board.Center;
import desktop_codebehind.SwingComponentFactory;

public final class Street extends Ownable {
    private static final int TITLEHEIGHT = 24;
    private static final int SUBTEXTHEIGHT = 10;
    private JLabel houseLabel;
    private SwingComponentFactory factory = new SwingComponentFactory();
    
    public Street(){
        this(Field.TITLE, Field.SUBTEXT, Field.DESCRIPTION, Field.RENT, Field.BG_COLOR, Field.FG_COLOR);
    }
    public Street(String title, String subText, String description, String rent, Color bgColor, Color fgColor) {
        super(bgColor, fgColor, title, subText, description, rent);
        super.subTextLabel = makeSubTextLabel();
        this.houseLabel = makeHouseLabel();
        
        super.layered.add(super.titleLabel,
            this.factory.createGridBagConstraints(0, 0));
        super.layered.add(this.houseLabel,
            this.factory.createGridBagConstraints(0, 1));
        super.layered.add(super.subTextLabel,
            this.factory.createGridBagConstraints(0, 2));
        super.layered.setLayer(super.titleLabel, 1);
        super.layered.setLayer(super.subTextLabel, 1);
        super.layered.setLayer(this.houseLabel, 0);
    }
    public Street setTextColor(Color textColor) {
        this.titleLabel.setForeground(textColor);
        this.subTextLabel.setForeground(textColor);
        return this;
    }
    private JLabel makeSubTextLabel(/* String subTextStreet */) {
        JLabel l = makeLabel(SUBTEXTHEIGHT);
        l.setHorizontalTextPosition(SwingConstants.CENTER);
        l.setText(super.subText);
        return l;
    }
    private JLabel makeHouseLabel() {
        JLabel l = makeLabel(TITLEHEIGHT);
        l.setOpaque(false);
        return l;
    }
    public void setHouses(int houseCount) {
        Icon icon = null;
        if (houseCount != 0) {
            icon =
                new ImageIcon(getClass().getResource(
                    "/desktop_resources/buildings/" + houseCount + "House.png"));
        }
        this.houseLabel.setIcon(icon);
    }
    public void setHotel(boolean hasHotel) {
        Icon icon =
            hasHotel ? new ImageIcon(getClass().getResource(
                "/desktop_resources/buildings/Hotel.png")) : null;
        this.houseLabel.setIcon(icon);
    }
    @Override
    public void displayOnCenter() {
        super.displayOnCenter();
        Center.label[1].setText("__________________________");
        Center.label[2].setText(this.description);
        Center.label[3].setText(this.subText);
        
        if (this.owner != null) {
            Center.label[4].setText(OWNABLELABEL + this.owner.getName());
            Center.label[5].setText(getLeje());
        }
        Center.label[6].setIcon(this.houseLabel.getIcon());
        
        super.displayCarOnCenter();
    }
}

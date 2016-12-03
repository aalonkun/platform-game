package aalonkun.game;



import java.awt.event.WindowEvent;

import java.awt.event.WindowListener;

import aalonkun.game.gfx.Colours;
import aalonkun.game.gfx.Font;
import aalonkun.game.gfx.Screen;
import aalonkun.game.net.packets.Packet01Disconnect;



public class WindowHandler implements WindowListener {



    private final Game game;
        
    private boolean isFocused = false;


    public WindowHandler(Game game) {

        this.game = game;

        this.game.frame.addWindowListener(this);
        


    }
    
    
    
    public void renderFocusMessage(Screen screen, int x, int y) {
    	if(!isFocused) {
    		Font.render("Focus this window!", screen, x + 9, y + 55, Colours.get(110, -1, -1, 530), 1);
    	}
    }
    
    public boolean isFocused() {
    	return isFocused;
    }

    @Override

    public void windowActivated(WindowEvent event) {
    	isFocused = true;
    }



    @Override

    public void windowClosed(WindowEvent event) {
    	isFocused = false;
    }



    @Override

    public void windowClosing(WindowEvent event) {

        Packet01Disconnect packet = new Packet01Disconnect(this.game.player.getUsername());

        packet.writeData(this.game.socketClient);
        
        isFocused = false;

    }



    @Override

    public void windowDeactivated(WindowEvent event) {
    	isFocused = false;
    }



    @Override

    public void windowDeiconified(WindowEvent event) {

    }



    @Override

    public void windowIconified(WindowEvent event) {

    }



    @Override

    public void windowOpened(WindowEvent event) {

    }



}
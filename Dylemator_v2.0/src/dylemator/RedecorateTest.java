package dylemator;

import java.awt.BorderLayout;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class RedecorateTest extends JFrame {

public static void main(String[] args) {

JFrame frame = new RedecorateTest();
frame.pack();
frame.setVisible(true);

}

JButton redecorate;
GraphicsDevice device;
JButton button = new JButton("Swap Mode");

public RedecorateTest() {
super("RedecorateTest");

GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
device = env.getScreenDevices()[0];
button.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
swap();
}
});
getContentPane().add(button, BorderLayout.NORTH);
}

void swap() {
Window fsw = device.getFullScreenWindow();

setVisible(false);
dispose();

boolean goFullScreen = fsw != this;

System.out.println(fsw + " " + this);
setUndecorated(goFullScreen);
setResizable(!goFullScreen);
if (goFullScreen) {
button.setText("FULL SCREEN MODE");
device.setFullScreenWindow(this);
validate();
} else {
device.setFullScreenWindow(null);
button.setText("WINDOWED MODE");
pack();
setVisible(true);
}
}
}
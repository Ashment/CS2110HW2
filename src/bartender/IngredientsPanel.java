package bartender;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class IngredientsPanel extends JPanel{

	GridBagConstraints gc;
	Border border;
	JLabel qq,ww,ee,rr,tt,yy,uu,aa,ss,dd,ff;
	
	public IngredientsPanel(){
		//Initialize JPanel
		setPreferredSize(new Dimension(600, 200));
		setBackground(Color.GREEN);
		setLayout(new GridBagLayout());
		gc = new GridBagConstraints();
		gc.gridwidth = 1;
		gc.gridheight = 1;
		System.out.println("IngredientsPanel initialization");
		
		//Create Border
		border = BorderFactory.createLineBorder(Color.black);
		
		//Initialize Labels
		qq = new JLabel(" Q-Gin "); qq.setBorder(border);
		ww = new JLabel(" W-Vodka "); ww.setBorder(border);
		ee = new JLabel(" E-Whiskey "); ee.setBorder(border);
		rr = new JLabel(" R-Vermouth "); rr.setBorder(border);
		tt = new JLabel(" T-Tequila "); tt.setBorder(border);
		yy = new JLabel(" Y-Beer "); yy.setBorder(border);
		uu = new JLabel(" U-Rum "); uu.setBorder(border);
		aa = new JLabel(" A-Sugar "); aa.setBorder(border);
		ss = new JLabel(" S-Lime "); ss.setBorder(border);
		dd = new JLabel(" D-Tonic Water "); dd.setBorder(border);
		ff = new JLabel(" F-Juice "); ff.setBorder(border);
		
		gc.insets = new Insets(10, 10, 10, 10);
		//Add Labels
		gc.gridy = 0;
		gc.gridx = 0;
		add(qq, gc);
		gc.gridx = 1;
		add(ww, gc);
		gc.gridx = 2;
		add(ee, gc);
		gc.gridx = 3;
		add(rr, gc);
		gc.gridx = 4;
		add(tt, gc);
		gc.gridx = 5;
		add(yy, gc);
		gc.gridx = 6;
		add(uu, gc);
		gc.gridy = 1;
		gc.gridx = 1;
		add(aa, gc);
		gc.gridx = 2;
		add(ss, gc);
		gc.gridx = 3;
		add(dd, gc);
		gc.gridx = 4;
		add(ff, gc);
	}
	
	
}

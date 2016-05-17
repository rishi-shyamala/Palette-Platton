import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Grid extends JPanel {

	private GamePixel[][] myColors;
	private JLabel[][] myLabels;

	public Grid(int rows, int cols, int cellWidth, double clumpPercentage) {
		myColors = new GamePixel[rows][cols];
		myLabels = new JLabel[rows][cols];

		JLabel myLabel = new JLabel();
//		MyMouseListener myListener = new MyMouseListener(this);
		Dimension labelPrefSize = new Dimension(cellWidth, cellWidth);
		setLayout(new GridLayout(rows, cols));

		int col = (int)(Math.random() * cols);
		int row = (int)(Math.random() * rows);
		GamePixel c = GamePixel.BLUE;
		double ran = Math.random();
		if (ran < 0.24) {
			c = GamePixel.RED;
		} else if (ran < 0.49) {
			c = GamePixel.BLUE;
		} else if (ran < 0.74) {
			c = GamePixel.GREEN;
		} else {
			c = GamePixel.YELLOW;
		}
		GamePixel firstColor = c;
		JLabel firstLabel = new JLabel();
		firstLabel = new JLabel();
		firstLabel.setOpaque(true);
		myColors[row][col] = firstColor;
		GamePixel previousColor = firstColor;
		firstLabel.setBackground(firstColor.getColor());
//		myLabel.addMouseListener(myListener);
		firstLabel.setPreferredSize(labelPrefSize);
		add(firstLabel);
		myLabels[row][col] = firstLabel;
		for (int x = 0; x < (rows)*(cols) - 1; x++) {
			double ran1 = Math.random();
			boolean bool = true;
			while(bool) {
				if (ran1 < 0.5) {
					col = randomizeCol(col,cols);
				} else {
					row = randomizeRow(row,rows);
				}
				if((col == -1) || (row == -1)) {
					bool = true;
				} else {
					bool = false;
				}
			}
			ran = Math.random();
			if (ran < (clumpPercentage)) {
				c = previousColor;
			} else if (ran < (((1 - clumpPercentage)/4) + clumpPercentage)) {
				c = GamePixel.BLUE;
			} else if (ran < ((((1 - clumpPercentage)/4)*2) + clumpPercentage)) {
				c = GamePixel.GREEN;
			} else if (ran < ((((1 - clumpPercentage)/4)*3) + clumpPercentage)){
				c = GamePixel.YELLOW;
			} else {
				c = GamePixel.RED;
			}
			
			previousColor = c;
			GamePixel myColor = c;
			myLabel = new JLabel();
			myLabel.setOpaque(true);
			myColors[row][col] = myColor;
			myLabel.setBackground(myColor.getColor());
//			myLabel.addMouseListener(myListener);
			myLabel.setPreferredSize(labelPrefSize);
			add(myLabel);
			myLabels[row][col] = myLabel;
		}
		
	}

	public GamePixel[][] getColors() {
		return myColors;
	}

	public int randomizeCol(int col, int cols){
		double ran1 = Math.random();
		if ((ran1 < 0.5) && (col != cols)) {
			return col ++;
		} else if (ran1 < 1 && (col != 0)) {
			return col --;
		}else {
			return -1;
		}
	}

	public int randomizeRow(int row, int rows){
		double ran1 = Math.random();
		if ((ran1 < 0.5) && (row != rows)) {
			return row ++;
		} else if (ran1 < 1 && (row != 0)) {
			return row --;
		}else {
			return -1;
		}
	}

	public void labelPressed(JLabel label) {
		for (int row = 0; row < myLabels.length; row++) {
			for (int col = 0; col < myLabels[row].length; col++) {
				// do something
			}
		}
	}
}
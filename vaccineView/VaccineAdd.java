package vaccineView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.*;
import vaccine.*;

public class VaccineAdd extends JFrame
implements ActionListener {
	public static final int FRAME_WIDTH = 500;
	public static final int FRAME_HEIGHT = 500;
	
	public static final int TEXT_SIZE = 20;
	
	public static String[] PROMPTS = {
			"vaccineNum", "capacity", "produceDate YYYY-MM-DD", "expireDate YYYY-MM-DD"
	};
	
	private JTextField[] inputs = {
			new JTextField(TEXT_SIZE),
			new JTextField(TEXT_SIZE),
			new JTextField(TEXT_SIZE),
			new JTextField(TEXT_SIZE),
	};
	
	private VaccineAddable vaccineAddable = null;
	private JButton submit = new JButton("Submit");
	
	public VaccineAdd(VaccineAddable vaccineAddable) {
		super();
		
		this.vaccineAddable = vaccineAddable;
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
		this.setLayout(new GridLayout(5, 1));
		
		JPanel[] items  = {
				new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel()
		};
		
		for(JTextField jtf : inputs) {
			jtf.setEditable(true);
		}
		
		for(int i=0 ; i<4 ; i++) {
			items[i].add(new JLabel(PROMPTS[i]), BorderLayout.WEST);
			items[i].add(inputs[i], BorderLayout.EAST);
		}
		
		submit.addActionListener(this);
		
		items[4].add(submit, BorderLayout.CENTER);
		
		for(JPanel item : items) {
			add(item);
		}
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		StringTokenizer stPD = new StringTokenizer(inputs[2].getText().toString(), "-");
		StringTokenizer stED = new StringTokenizer(inputs[3].getText().toString(), "-");
		
		vaccineAddable.addToFile(new VaccineProduct(
			Integer.parseInt(inputs[0].getText().toString()), Double.parseDouble(inputs[1].getText().toString()),
			new Date(Integer.parseInt(stPD.nextToken()), Integer.parseInt(stPD.nextToken()), Integer.parseInt(stPD.nextToken())),
			new Date(Integer.parseInt(stED.nextToken()), Integer.parseInt(stED.nextToken()), Integer.parseInt(stED.nextToken()))
		));
	}
}

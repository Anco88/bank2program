package Gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import program.Program;

/**
 * 
 */

/**
 * @author 
 * @param <panel>
 *
 */
public class ProgramFrame<panel> extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7454457885878376658L;
	static private final String newline = "\n";
	private ProgramFrame panel;
	 JTextArea log;
	JPanel buttonPanel;
	JButton deleteNode;
	JButton newNode;
	JRadioButton raboButton = new JRadioButton("Rabobank");
	JRadioButton ingButton = new JRadioButton("ING");

	JRadioButton csvButton = new JRadioButton("CSV output");
	JRadioButton qifButton = new JRadioButton("Qif output");
	
	Program p;
	JFileChooser fc;
	JButton addEdge = new JButton("add edge");
	JButton undo = new JButton("undo");
	JButton redo = new JButton("redo");
	JButton load = new JButton("load");
	JButton save = new JButton("save");
	JTextField nameField = new JTextField(10);
	JButton changeName = new JButton("change name");
	Container content;
	boolean newEdge = false;
	private String bank;

	public ProgramFrame(Program p){
		super("hallo");
		JFileChooser fc = new JFileChooser();
		this.p = p;
		 log = new JTextArea(5,20);
	        log.setMargin(new Insets(5,5,5,5));
	        log.setEditable(false);
	        JScrollPane logScrollPane = new JScrollPane(log);
		//this.p).addObserver(this);
		buttonPanel = new JPanel();
		 load.addActionListener(this);
		content = getContentPane();
		
		ingButton.setSelected(true);
		ingButton.addActionListener(this);
		raboButton.addActionListener(this);
		
		ButtonGroup selectBankGroup = new ButtonGroup();
		selectBankGroup.add(raboButton);
		selectBankGroup.add(ingButton);
		
		ButtonGroup selectOutput = new ButtonGroup();
		selectBankGroup.add(csvButton);
		selectBankGroup.add(qifButton);
		
		qifButton.setSelected(true);
		csvButton.addActionListener(this);
		qifButton.addActionListener(this);
		
		JPanel selectBankPanel = new JPanel(new GridLayout(0, 1));
		selectBankPanel.add(raboButton);
		selectBankPanel.add(ingButton);
		
		JPanel selectOutputPanel = new JPanel(new GridLayout(0, 1));
		selectOutputPanel.add(csvButton);
		selectOutputPanel.add(qifButton);
		
		buttonPanel.add(load);
		buttonPanel.add(save);
		
		content.add(buttonPanel, BorderLayout.NORTH);
		content.add(selectBankPanel, BorderLayout.CENTER);
		content.add(selectOutputPanel, BorderLayout.EAST);
		content.add(logScrollPane, BorderLayout.SOUTH);
		this.setSize(800,200);
		this.setVisible(true);
		this.init();

	}
	
	public void init(){
	/*	load.addActionListener(
				new ActionListener(){
					public void actionPerformed (ActionEvent e){
						int returnVal = fc.showOpenDialog(this);

			            if (returnVal == JFileChooser.APPROVE_OPTION) {
			                File file = fc.getSelectedFile();
			                //This is where a real application would open the file.
			                log.append("Opening: " + file.getName() + "." + newline);
			            } else {
			                log.append("Open command cancelled by user." + newline);
			            }
			            log.setCaretPosition(log.getDocument().getLength());

					}
				}
		);*/
		save.addActionListener(
				new ActionListener(){
					public void actionPerformed (ActionEvent e){
						System.out.println("save");
						//((Program) p).save("out.txt");
					}
				}
		);
		
	}

	@Override
    public void actionPerformed(ActionEvent e) {

        //Handle open button action.
        if (e.getSource() == load) {
        	JFileChooser fc = new JFileChooser();
            int returnVal = fc.showOpenDialog(this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //This is where a real application would open the file.
                log.append("Opening: " + file.getName() + "." + newline);
                log.append("Saving: " + file.getAbsolutePath() + "." + newline);
            } else {
                log.append("Open command cancelled by user." + newline);
            }
            log.setCaretPosition(log.getDocument().getLength());

        //Handle save button action.
        } else if (e.getSource() == save) {
        	
            int returnVal = fc.showSaveDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //This is where a real application would save the file.
                log.append("Saving: " + file.getName() + "." + newline);
                log.append("Saving: " + file.getAbsolutePath() + "." + newline);
            } else {
                log.append("Save command cancelled by user." + newline);
            }
            log.setCaretPosition(log.getDocument().getLength());
             
		} else if (e.getSource() == raboButton) {
	    	this.bank = "rabo";
	    	log.append("selected bank: Rabo"+ newline);
	    	log.setCaretPosition(log.getDocument().getLength());
	    }
		else if (e.getSource() == ingButton) {
	    	this.bank = "ing";
	    	log.append("selected bank: ING"+ newline);
	    	log.setCaretPosition(log.getDocument().getLength());
	    }
    }




	

}

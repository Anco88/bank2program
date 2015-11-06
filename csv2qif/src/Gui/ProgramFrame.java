package Gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Enumeration;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import data.Data;
import decode.IngToTransactions;
import decode.RaboToTransactions;
import export.ToQif;

import program.Program;

/**
 * 
 */

/**
 * @author 
 * @param <panel>
 *
 */
public class ProgramFrame extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7454457885878376658L;
	static private final String newline = "\n";
	private ProgramFrame panel;
	JFileChooser fc = new JFileChooser();
	JTextArea log;
	JPanel buttonPanel;
	ButtonGroup selectBankGroup = new ButtonGroup();
	JRadioButton raboButton = new JRadioButton("Rabobank");
	JRadioButton ingButton = new JRadioButton("ING");

	JRadioButton csvButton = new JRadioButton("CSV output");
	JRadioButton qifButton = new JRadioButton("Qif output");
	
	Program p;

	JButton load = new JButton("load");
	JButton save = new JButton("save");
	JTextField nameField = new JTextField(10);
	JButton changeName = new JButton("change name");
	Container content;
	boolean newEdge = false;
	private String bank;
	private Data data;

	public ProgramFrame(Data data){
		super("Bank to program");
		JFileChooser fc = new JFileChooser();
		this.data = data;
		log = new JTextArea(5,20);
	    log.setMargin(new Insets(5,5,5,5));
	    log.setEditable(false);
	    JScrollPane logScrollPane = new JScrollPane(log);
		//this.p).addObserver(this);
		buttonPanel = new JPanel();
		
		load.addActionListener(this);
		save.addActionListener(this);
		content = getContentPane();
		
		ingButton.setSelected(true);
		ingButton.addActionListener(this);
		raboButton.addActionListener(this);
		ingButton.setActionCommand("ING");
		raboButton.setActionCommand("RABO");
		
		
		selectBankGroup.add(raboButton);
		selectBankGroup.add(ingButton);
		
		ButtonGroup selectOutput = new ButtonGroup();
		selectOutput.add(csvButton);
		selectOutput.add(qifButton);
		
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
		
		this.data.setBank(selectBankGroup.getSelection().getActionCommand());
	//	System.out.println("hooi " + selectBankGroup.getSelection().getActionCommand());
	//	System.out.println("hooi " + getSelectedButton(selectBankGroup).getActionCommand());
		
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

	public String getSelectedBank(){
		return selectBankGroup.getSelection().getActionCommand();
	}
	
	@Override
    public void actionPerformed(ActionEvent e) {

        //Handle open button action.
        if (e.getSource() == load) {
        	
            int returnVal = fc.showOpenDialog(this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //This is where a real application would open the file.
                switch(getSelectedBank()){
	                case "RABO":new RaboToTransactions(data, fc.getSelectedFile());
	                case "ING":new IngToTransactions(data, fc.getSelectedFile());
                }
                log.append("Opening: " + file.getName() + "." + newline);
            } else {
                log.append("Open command cancelled by user." + newline);
            }
            log.setCaretPosition(log.getDocument().getLength());

        //Handle save button action.
        } else if (e.getSource() == save) {
        	//fc.setCurrentDirectory(fc.getCurrentDirectory());
            int returnVal = fc.showSaveDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                
                new ToQif(data, fc.getSelectedFile());
               
                
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

/* orinal function works, keep this for backup
    public  JRadioButton getSelectedButton(ButtonGroup group) {
        Enumeration<AbstractButton> e = group.getElements();
        while (e.hasMoreElements()) {
           AbstractButton b =  e.nextElement();
          if (b.isSelected()) return (JRadioButton) b;
        }
        return null;
      }
*/
	
	

}

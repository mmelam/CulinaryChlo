import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.io.*;

 
public class Interface implements ActionListener {
	 JPanel cards;
	 
    //buttons
  	private JButton run = new JButton("Find Recipe");
  	private JButton home = new JButton("Home");
  	private JButton back = new JButton("Back");
  	private JButton next = new JButton("Next Recipe");
  	private JButton surprise = new JButton("Surprise Me!");
  	
  	// check box
  	private JCheckBox saveCheck = new JCheckBox("Mark as used"){
  		@Override public void setBorder(Border border){
  		}
  	};
  		
  	// combo boxes
  	String culture[] = {"-", "Asian", "Italian", "Indian", "Mediterranean", "Mexican", "Other", "Random"};
  	String meat[] = {"-", "Beef", "Chicken", "Pork", "Seafood", "Other","None","Random"};
  	private JComboBox cultureSel = new JComboBox(culture);
  	private JComboBox meatSel = new JComboBox(meat);
  	
  	// labels
  	JLabel title = new JLabel("Culinary Chlo");
  	JLabel description = new JLabel("Hand Selected Recipes for my Favorite Foodie. I love you!");
  	JLabel options = new JLabel("Choose your Options: ");
  	JLabel spacer1 = new JLabel(" ");
  	JLabel spacer2 = new JLabel(" ");
  	JLabel spacer3 = new JLabel(" ");
  	JLabel spacer4 = new JLabel(" ");
  	JLabel spacer5 = new JLabel(" ");
  	JLabel recTitle = new JLabel("Get Cooking!");
  	JLabel recipeSite = new JLabel("Recipe Link:");
  	
  	// text areas
  	private JTextField url = new JTextField(){
  		@Override public void setBorder(Border border){
  		}
  	};
  	private JTextField reason = new JTextField(){
  		@Override public void setBorder(Border border){
  		}
  	};
  	
    public void addComponentToPane(Container pane) {
        run.addActionListener(this);
        home.addActionListener(this);
        back.addActionListener(this);
        next.addActionListener(this);
        saveCheck.addActionListener(this);
        
        title.setFont(new Font("Snell Roundhand", Font.ITALIC, 48));
        recTitle.setFont(new Font("Snell Roundhand", Font.ITALIC, 40));
      	cultureSel.setPreferredSize(new Dimension(83,20));
      	meatSel.setPreferredSize(new Dimension(83,20));
      	home.setPreferredSize(new Dimension(120,20));
      	next.setPreferredSize(new Dimension(120,20));
      	
      	reason.setBackground(new Color(255,216,254));
      	url.setBackground(new Color(255,216,254));
      	saveCheck.setBackground(new Color(255,216,254));
      	
      	// Tab Pane
      	JTabbedPane appTab = new JTabbedPane();
      	
        ///////// 
        // Main Panel 
        /////////
        JPanel mainPanel = new JPanel(new GridBagLayout());
        appTab.add("Home", mainPanel);
        mainPanel.setBackground(new Color(255,216,254));
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = 0;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.NORTH;
		mainPanel.add(title, gc);
		gc.gridx = 0;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.CENTER;
		mainPanel.add(description, gc);
		gc.gridx = 0;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.EAST;
		mainPanel.add(spacer1, gc);
		
		// Column 1
		gc.gridx = 0;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.WEST;
		mainPanel.add(options, gc);
		gc.gridx = 0;
		gc.gridy = 4;
		gc.anchor = GridBagConstraints.WEST;
		mainPanel.add(meatSel, gc);
		gc.gridx = 0;
		gc.gridy = 5;
		gc.anchor = GridBagConstraints.WEST;
		mainPanel.add(cultureSel, gc);	
		gc.gridx = 0;
		gc.gridy = 6;
		gc.anchor = GridBagConstraints.WEST;
		mainPanel.add(spacer2, gc);
		gc.gridx = 0;
		gc.gridy = 7;
		gc.anchor = GridBagConstraints.WEST;
		mainPanel.add(run, gc);
		

		///////// 
        // Recipe Panel 
        /////////
        JPanel recipePanel = new JPanel(new GridBagLayout());
        recipePanel.setBackground(new Color(255,216,254));
        gc.gridx = 0;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.NORTH;
		recipePanel.add(recTitle, gc);
		gc.gridx = 0;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.WEST;
		recipePanel.add(recipeSite, gc);
		gc.gridx = 0;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.WEST;
		recipePanel.add(url, gc);
		gc.gridx = 0;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.WEST;
		recipePanel.add(spacer3, gc);
		gc.gridx = 0;
		gc.gridy = 4;
		gc.anchor = GridBagConstraints.WEST;
		recipePanel.add(reason, gc);
		gc.gridx = 0;
		gc.gridy = 5;
		gc.anchor = GridBagConstraints.WEST;
		recipePanel.add(spacer4, gc);
		gc.gridx = 0;
		gc.gridy = 6;
		gc.anchor = GridBagConstraints.WEST;
		recipePanel.add(saveCheck, gc);
		gc.gridx = 0;
		gc.gridy = 7;
		gc.anchor = GridBagConstraints.WEST;
		recipePanel.add(spacer5, gc);
		gc.gridx = 0;
		gc.gridy = 8;
		gc.anchor = GridBagConstraints.WEST;
		recipePanel.add(next, gc);
		gc.gridx = 0;
		gc.gridy = 9;
		gc.anchor = GridBagConstraints.WEST;
		recipePanel.add(home, gc);
		
		// Saved Panel
		JPanel savedPanel = new JPanel(new GridBagLayout());
		appTab.add("Saved Recipes", savedPanel);
		savedPanel.setBackground(new Color(255,216,254));
         
        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(appTab, "main");
        cards.add(recipePanel, "recipe");
         
        pane.add(cards, BorderLayout.NORTH);
    }
    
    RecipeFinder newRecipe = new RecipeFinder();
    public void actionPerformed(ActionEvent e)
    {
    	CardLayout cl = (CardLayout)(cards.getLayout());
    	String type = String.valueOf(cultureSel.getSelectedItem());
		String meatGo = String.valueOf(meatSel.getSelectedItem());
		String str = "-";
		String rand = "Random";

    	if(e.getSource() == run)
    	{
    		if(type.equals(str) || meatGo.equals(str))
    		{
    			JOptionPane.showMessageDialog(null, "Silly Chlo... please make selections for both options!", "Error", JOptionPane.ERROR_MESSAGE);
    		}
    		else if(type.equals(rand) && meatGo.equals(rand))
    		{
    			newRecipe.randomRecipe();
    			reason.setText(newRecipe.getReason());
    			url.setText(newRecipe.getURL());
        		cl.show(cards, "recipe");
    		}
    		else{
    			newRecipe.findRecipe(type, meatGo);
        		reason.setText(newRecipe.getReason());
        		url.setText(newRecipe.getURL());
        		cl.show(cards, "recipe");
    		}
    	}
    	else if(e.getSource() == home)
    	{
    		cl.show(cards, "main");
    	}
    	else if(e.getSource() == next)
    	{
    		newRecipe.getNext();
    		reason.setText(newRecipe.getReason());
    		url.setText(newRecipe.getURL());
    	}
    	else if(e.getSource() == surprise)
    	{
    		newRecipe.randomRecipe();
    		cl.show(cards, "recipe");
    	}
    	else if(e.getSource() == saveCheck)
    	{
    		JOptionPane.showMessageDialog(null, "Recipe will be saved.\nIt can be viewed in the Saved Recipes tab.\nUncheck the box to undo.", "", JOptionPane.INFORMATION_MESSAGE);
    	}
    }
     
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // frame.setContentPane(new JLabel (new ImageIcon("cuttingBoard.jpg").));
         
        //Create and set up the content pane.
        Interface gui = new Interface();
        gui.addComponentToPane(frame.getContentPane());
         
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
     
    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
         
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
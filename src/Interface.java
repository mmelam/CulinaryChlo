import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

 
public class Interface implements ActionListener {
	 JPanel cards;
	 
    //buttons
  	private JButton run = new JButton("Find Recipe");
  	private JButton home = new JButton("Home");
  	private JButton back = new JButton("Back");
  	private JButton next = new JButton("Next Recipe");
  		
  	// combo boxes
  	String culture[] = {"Asian", "Italian", "Indian", "Mediterranean", "Mexican", "Other"};
  	String meal[] = {"Breakfast", "Lunchie", "Dinner", "Dessert"};
  	String meat[] = {"Beef", "Chicken", "Pork", "Seafood", "Other","None"};
  	private JComboBox cultureSel = new JComboBox(culture);
  	private JComboBox mealSel = new JComboBox(meal);
  	private JComboBox meatSel = new JComboBox(meat);
  	
  	// labels
  	JLabel title = new JLabel("Culinary Chlo");
  	JLabel description = new JLabel("Temp Title"); //("Hand Selected Recipes for my Favorite Foodie. I love you!");
  	JLabel options = new JLabel("Choose your Options: ");
  	JLabel spacer1 = new JLabel(" ");
  	JLabel spacer2 = new JLabel(" ");
  	JLabel spacer3 = new JLabel(" ");
  	JLabel spacer4 = new JLabel(" ");
  	JLabel recTitle = new JLabel("Get Cooking!");
  	JLabel recipeSite = new JLabel("Recipe Link:");
  	
  	// text areas
  	private JTextField url = new JTextField();
  	private JTextField reason = new JTextField();
  	
    public void addComponentToPane(Container pane) {
        run.addActionListener(this);
        home.addActionListener(this);
        back.addActionListener(this);
        next.addActionListener(this);
        
        title.setFont(new Font("Snell Roundhand", Font.ITALIC, 48));
        recTitle.setFont(new Font("Snell Roundhand", Font.ITALIC, 40));
      	cultureSel.setPreferredSize(new Dimension(83,20));
      	mealSel.setPreferredSize(new Dimension(83,20));
      	meatSel.setPreferredSize(new Dimension(83,20));
      	home.setPreferredSize(new Dimension(120,20));
      	next.setPreferredSize(new Dimension(120,20));
        
        ///////// 
        // Main Panel 
        /////////
        JPanel mainPanel = new JPanel(new GridBagLayout());
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
		mainPanel.add(mealSel, gc);
		gc.gridx = 0;
		gc.gridy = 5;
		gc.anchor = GridBagConstraints.WEST;
		mainPanel.add(meatSel, gc);
		gc.gridx = 0;
		gc.gridy = 6;
		gc.anchor = GridBagConstraints.WEST;
		mainPanel.add(cultureSel, gc);	
		gc.gridx = 0;
		gc.gridy = 7;
		gc.anchor = GridBagConstraints.WEST;
		mainPanel.add(spacer2, gc);
		gc.gridx = 0;
		gc.gridy = 8;
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
		recipePanel.add(next, gc);
		gc.gridx = 0;
		gc.gridy = 7;
		gc.anchor = GridBagConstraints.WEST;
		recipePanel.add(home, gc);
        
         
        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(mainPanel, "main");
        cards.add(recipePanel, "recipe");
         
        //pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.NORTH);
    }
    
    public void actionPerformed(ActionEvent e)
    {
    	CardLayout cl = (CardLayout)(cards.getLayout());
    	String type = String.valueOf(cultureSel.getSelectedItem());
		String meatGo = String.valueOf(meatSel.getSelectedItem());
		String mealGo = String.valueOf(mealSel.getSelectedItem());
		RecipeFinder newRecipe = new RecipeFinder();
		
		System.out.println(meatGo);
		System.out.println(mealGo);
    	
    	if(e.getSource() == run)
    	{
    		newRecipe.findRecipe(type, meatGo, mealGo);
    		reason.setText(newRecipe.getReason());
    		url.setText(newRecipe.getURL());
    		cl.show(cards, "recipe");
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
//import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

 class RecipeFinder{
	
	Recipe recArr[] = new Recipe[100];
	Recipe viewedArr[] = new Recipe[100];
	Recipe selected;
	Recipe last;
	int i=0;
	
	public RecipeFinder()
	{	
		try{
			File file = new File("/Users/Mason/Desktop/Chloe/CulinaryChlo/src/recipes.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			int i = 1;
			int index = 0;
			String culture = null;
			String meat = null;
			String meal = null;
			String url = null;
			String reason = null;
			while( br.ready() )
			{
				if(i==1)
				{
					culture = br.readLine();
					System.out.println(culture);
					i++;
				}
				else if(i==2)
				{
					meat = br.readLine();
					System.out.println(meat);
					i++;
				}
				else if(i==3)
				{
					meal = br.readLine();
					System.out.println(meal);
					i++;
				}
				else if(i==4)
				{
					url = br.readLine();
					System.out.println(url);
					i++;
				}
				else if(i==5)
				{
					reason = br.readLine();
					System.out.println(reason);
					Recipe temp = new Recipe(culture, meal, meat, url, reason);
					recArr[index] = temp;
					index++;
					i = 1;
				}
			}
			System.out.println("Done reading file!");
			i = 0;
			br.close();
		}
		catch(IOException e){
			System.out.println("File does not exist!");
		}
	}
	
	public void findRecipe(String culture, String meat, String meal)
	{
		int index = 0;
		boolean found = false;
		while(found == false)
		{	
			if((recArr[index].culture.equals(culture))&&(recArr[index].meal.equals(meal))&&(recArr[index].meat.equals(meat))&&(viewedCheck(recArr[index])==false))
			{
				selected = recArr[i];
				found = true;
				int j=0;
				while(viewedArr[j]!=null)
				{
					j++;
				}
				viewedArr[j] = selected;

			}
			else if(recArr[index]==null)
			{
				
			}
			else{
				System.out.println("here");
				//found = true;
				index++;
			}
		}
	}
	
	public void getNext()
	{
		//if(recArr[])
		i = i+1;
		selected = recArr[i];
	}
	
	public String getReason()
	{
		return selected.reason;
	}
	
	public String getURL()
	{
		return selected.url;
	}
	
	public boolean viewedCheck(Recipe rec)
	{
		int j=0;
		while(viewedArr[j]!=null)
		{
			if(viewedArr[j].equals(rec))
			{
				return true;
			}
		}
		return false;
	}
}

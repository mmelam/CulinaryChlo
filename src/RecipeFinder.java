import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

 class RecipeFinder{
	
	Recipe recArr[];
	Recipe selected;
	Recipe last;
	int i=0;
	boolean rand = false;
	int next = 0;
	String storeCulture;
	String storeMeat;
	
	public RecipeFinder()
	{	
		try{
			File file = new File("/Users/Mason/Desktop/Chloe/CulinaryChlo/src/recipes.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			int i = 1;
			int index = 0;
			String culture = null;
			String meat = null;
			String url = null;
			String reason = null;
			
			String len = br.readLine();
			int arrLen = Integer.parseInt(len);
			recArr = new Recipe[arrLen];
			
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
					url = br.readLine();
					System.out.println(url);
					i++;
				}
				else if(i==4)
				{
					reason = br.readLine();
					System.out.println(reason);
					Recipe temp = new Recipe(culture, meat, url, reason, false);
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
	
	public void findRecipe(String culture, String meat)
	{
		int index = 0;
		boolean found = false;
		storeCulture = culture;
		storeMeat = meat;
		System.out.println(next);
		
		if(next != 0)
		{
			index = next;
		}
		while(found == false)
		{	
			if((recArr[index].culture.equals(culture))&&(recArr[index].meat.equals(meat))&&(recArr[index].saved == false))
			{
				selected = recArr[index];
				found = true;
				
				if(index+1 == recArr.length)
				{
					next = 0;
				}
				else{
					next = index++;
				}
			}
			else if(index+1 == recArr.length)
			{
				next = 0;
			}
			else{
				next = index++;
			}
		}
	}
		
	public void getNext()
	{
		if(rand == true)
		{
			randomRecipe();
		}
		else{
			findRecipe(storeCulture, storeMeat);
		}
	}
	
	public void randomRecipe()
	{
		rand = true;
		int len = recArr.length;
		Random rn = new Random();
		int randomNum = rn.nextInt(len);
		System.out.println(randomNum);
		
		if(recArr[randomNum] == last)
		{
			if(randomNum+1 == len)
			{
				selected = recArr[0];
			}
			else{
				selected = recArr[randomNum+1];
			}
		}
		else{
			selected = recArr[randomNum];
		}
		last = selected;
	}
	
	public String getReason()
	{
		return selected.reason;
	}
	
	public String getURL()
	{
		return selected.url;
	}
	
}

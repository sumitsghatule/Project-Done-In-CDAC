import java.util.*;
public class OptimalSiteVisit  
{  
 static String str="" ;

 static int g(int array1[][],int x, int y)
	{
		return array1[x-1][y-1] ;
	}

	void printPermutations(int array[], int n)  
	{  
		for (int i = 0; i < n; i++)  
		{	str +=array[i];
			
		}
			str+=":";
			
	}  
		
		
	void findPermutation(int array[], int size, int n)  
	{  
		if (size == 1)  
		printPermutations(array, n);  
		for (int i = 0; i < size; i++)   
		{  
			findPermutation(array, size - 1, n);  
   
			if (size % 2 == 1)   
			{  
				
				int temp = array[0];  
				array[0] = array[size - 1];  
				array[size - 1] = temp;  
			}  
			else   
			{  
				int temp;  
				temp = array[i];  
				array[i] = array[size - 1];  
				array[size - 1] = temp;  
			}  
		}  
	}  
	
	public static void main(String args[])  
	{  
		OptimalSiteVisit p = new OptimalSiteVisit();  
		Scanner sc= new Scanner(System.in);
		System.out.println("----- Enter no of site visit ------");
		int max = sc.nextInt();
		System.out.println("-----Please enter unique Id's of sites ------");
		int[] array = new int[max];  
		for(int i=0; i<max; i++)  
		{  
			array[i]=sc.nextInt();  
		}  
		//System.out.println("All possible combination of Your paths are :- ");
		p.findPermutation(array, array.length, array.length);  
		
		int m, n, i, j;  
		m=n=max;
		Scanner s=new Scanner(System.in);   
		int array1[][] = new int[m][n];   
		 System.out.println("enter the distance from one site to next site.. ");   
		for (i = 0; i < m; i++) 
		{ 
			//System.out.print("\n");
			
			for (j = i+1; j < n; j++) 	
			{	
		
				System.out.print("distanace for "+(i+1)+" to "+(j+1)+" : ");
				array1[i][j] = s.nextInt();
				array1[j][i] = array1[i][j];
			}
		}   
		System.out.println("All distances that you have entered in matrix format :- ");   
		for (i = 0; i < m; i++)
		{   
			for (j = 0; j < n; j++)   
				System.out.print(array1[i][j] + " "); 
		System.out.println();
		}
			    
		for (i = 0; i < m; i++)   
			for (j = 0; j < n; j++)   
				if(i!=j &&array1[i][j]==0 )
					array1[i][j]=10000; 
		str=str.substring(0,(str.length()-1));
		//System.out.println(str);
		int f=0;
		String S[]=str.split(":");
		ArrayList<Site> list=new ArrayList<Site>();
		for(int l=0;l<S.length;l++){	
		String SS="";									
		int count=0;
		for(int k=1;k<max;k++)
		{
			
			int a = Character.getNumericValue(S[l].charAt(k-1));
			int b = Character.getNumericValue(S[l].charAt(k));
			count+= g(array1,a,b);
			SS =SS+""+a+"->"+b+" ";	
		} 
		
		if(count<9999)
		list.add(new Site(SS,count));
		}
		System.out.println("\nAll possible paths");
		System.out.print("\nPath");
		for(int b=1;b<max;b++)System.out.print("\t");
		System.out.print("Distance\n");
		for(int e=0;e<list.size();e++){
		System.out.print("\n"+list.get(e).path);
		for(int b=0;b<max-2;b++)
			System.out.print("\t");
		System.out.print(list.get(e).distance);}
		Collections.sort(list,new SiteComparator());
		System.out.println("\n-------------Sorted paths-------------");
		System.out.println("We recomend you to choose the shortest path ");
	
	System.out.println(" Please choose one of the following.");
		for(int e=0;e<2;e++)
			System.out.println(list.get(e).path+list.get(e).distance);
	}   
}  
class Site{
	String path;
	int distance;
	Site(String path,int distance)
	{
		this.path=path;
		this.distance=distance;
	} 
}
class SiteComparator implements Comparator<Site> {
  
    
    public int compare(Site s1, Site s2)
    {
        if (s1.distance == s2.distance)
            return 0;
        else if (s1.distance > s2.distance)
            return 1;
        else
            return -1;
    }
}
		
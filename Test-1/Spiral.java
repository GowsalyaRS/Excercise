class Spiral
{
    public static void main(String[] args) {
       int size = 5;
	   int arr[][] = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
	   int startRow=0,startCol=0;
	   int endRow=size,endCol=size;
	   int count =0;
	   int totalCount = size*size;
	   while(count<totalCount)
	   {
	       for(int i=startRow,j=startCol;i<endCol;)
	       {
	           System.out.print(arr[i][j]+" ");
	           count++;
	           if(j==endCol-1)
	           {
	              i++; 
	           }
	           else{
	               j++;
	           }
	       }
	       for(int i=endRow-1,j=endCol-2;i>=startRow;)
	       {
	           System.out.print(arr[i][j] + " ");
	           count++;
	           if(j==startCol)
	           {
	               i--;
	           }
	           else{
	               j--;
	           }
	       }
        
	       startRow++;
	       startCol++;
	       endCol--;
	       endRow--;
	   }
	  
    } 
}
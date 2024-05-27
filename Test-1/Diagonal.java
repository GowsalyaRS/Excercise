public class Diagonal {
    public static void main(String[] args) {
        // Scanner scan = new Scanner(System.in);
          int size =  3 ;//sacn.nextInt();
          int arr [][] = {{1,2,3},{4,5,6},{7,8,9}};
          int row = size;
          int col = size;
          for(int i=0;i<row;i++)
          {
              int j =i;
              int k=0;
              while(j>=0)
              {
                  System.out.print(arr[j][k] + " ");
                  j-=1;
                  k+=1;
              }
              System.out.println();
          }
          for(int i=1;i<col;i++)
          {
              int j =row-1;
              int k=i;
              while(k<col)
              {
                  System.out.print(arr[j][k] + " ");
                  j-=1;
                  k+=1;
              }
              System.out.println();
          }
    }
}

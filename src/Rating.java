
public class Rating {
    int [][] rtg  = new int[Map.a][Map.b];
    public int rate(int v, int m)

        {

            if(v<0 || m<0)
                return 0;


            for(int i=0;i<Map.a;i++) {
            for(int y=0;y<Map.b;y++)
            {
                rtg[i][y]=0;
            }
            }
            rtg[6][4] = 0;//G SH
            rtg[6][3] = 1; // G CHANGE
            rtg[6][2] = 1;//A3
            rtg[6][1] = 1;//A2
            rtg[6][0] = 1;//A1

            rtg[4][4] = 0;//BOY SH
            rtg[4][3] = 1;//BOY CHANGE
                return (rtg[v][m]);


        }
}

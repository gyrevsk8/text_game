import java.lang.String;


public class Map
{
    static String location = "Входе" ;

    public static int a=8;
   public static int b=5;
    String[][] pls  = new String[a][b];
    Rating rats = new Rating();
   public Map()
   {
       for(int i = 0; i<a;i++)
           for(int y=0;y<b;y++) {
                pls[i][y]="Стена";
           }
       pls[3][0] = "Входе";
       pls[3][1] = "Холле первого этажа";
       pls[2][1] = "Правом коридоре";
       pls[4][1] = "Левом коридоре";

       pls[1][0] = "Верхней части правого крыла";
       pls[1][1] = "Средней части правого крыла";
       pls[1][2] = "Нижней части правого крыла";

       pls[1][3] = "Столовой";
       pls[1][4] = "Кухне";

       pls[5][0] = "Верхней части левого крыла";
       pls[5][1] = "Средней части левого крыла";
       pls[5][2] = "Нижней части левого крыла";

       pls[5][3] = "Входе в раздевалки";
       pls[6][3] = "Раздевалке девочек";
       pls[4][3] = "Раздевалке мальчиков";
       pls[6][4] = "Душевых девочек";
       pls[4][4] = "Душевых мальчиков";
       pls[5][4] = "Бассейне";

       pls[0][0] = "Библиотеке";
       pls[0][1] = "Медпункте";
       pls[0][2] = "Кладовке";

       pls[6][0] = "Классе_А1";
       pls[6][1] = "Классе А2";
       pls[6][2] = "Классе А3";


   }
   public static int[] coords = new int[2];
    void loca()
    {
        String l = location;
        for(int i = 0; i<a;i++)
            for(int y=0;y<b;y++)
            {
                if(pls[i][y].equals("Стена")){
                    continue;}
                if(pls[i][y].equals(l))
                {
                    System.out.print("Я нахожусь в ");
                    System.out.println(l);
                    coords[0]=i;
                    coords[1]=y;

                    if( i+1<=a-1 &&!pls[i+1][y].equals(" ") && !pls[i+1][y].equals("Стена")) {
                        System.out.print("Если пойду влево я окажусь в ");
                        System.out.println(pls[i+1][y]);
                    }
                    if( y+1<=b-1 && !pls[i][y+1].equals(" ") && !pls[i][y+1].equals("Стена")) {
                        System.out.print("Если пойду вперед я окажусь в ");
                        System.out.println(pls[i][y+1]);
                    }
                    if(i-1>=0 && !pls[i-1][y].equals(" ") && !pls[i-1][y].equals("Стена")) {
                        System.out.print("Если пойду вправо я окажусь в ");
                        System.out.println(pls[i-1][y]);
                    }
                    if( y-1>=0 && !pls[i][y-1].equals(" ") && !pls[i][y-1].equals("Стена")) {
                        System.out.print("Если пойду назад я окажусь в ");
                        System.out.println(pls[i][y-1]);
                    }
                }
            }
    }
    void movement(String command)
    {
        if(command.equals("Назад")||command.equals("s"))
        {


            if (coords[1]-1<0 || pls[coords[0]][coords[1]-1].equals("Стена") || rats.rate(coords[0],coords[1])!=0 && rats.rate(coords[0],coords[1]-1)!=0 && rats.rate(coords[0],coords[1]-1)==rats.rate(coords[0],coords[1]) )
            {
                System.out.println("Я не могу ходить сквозь стены!");
            }
            else
            {
                coords[1]--;
            }

        }
        if(command.equals("Вперед")||command.equals("w"))
        {

            if (coords[1]+1>b-1 || pls[coords[0]][coords[1]+1].equals("Стена")  ||  rats.rate(coords[0],coords[1])!=0 && rats.rate(coords[0],coords[1]+1)!=0 && rats.rate(coords[0],coords[1]+1)==rats.rate(coords[0],coords[1]))
            {
                System.out.println("Я не могу ходить сквозь стены!");
            }
            else
            {
                coords[1]++;
            }
        }
        if(command.equals("Вправо")||command.equals("d"))
        {

            if (coords[0]-1<0 || pls[coords[0]-1][coords[1]].equals("Стена")|| rats.rate(coords[0]-1,coords[1])!=0 && rats.rate(coords[0],coords[1])!=0 && rats.rate(coords[0]-1,coords[1])==rats.rate(coords[0],coords[1]))
            {
                System.out.println("Я не могу ходить сквозь стены!");
            }
            else
            {
                coords[0]--;
            }
        }
        if(command.equals("Влево")||command.equals("a"))
        {

            if (coords[0]+1>a-1 || pls[coords[0]+1][coords[1]].equals("Стена")|| rats.rate(coords[0]+1,coords[1])!=0 && rats.rate(coords[0],coords[1])!=0 && rats.rate(coords[0]+1,coords[1])==rats.rate(coords[0],coords[1]))
            {
                System.out.println("Я не могу ходить сквозь стены!");
            }
            else
            {
                coords[0]++;
            }
        }
        location = pls[coords[0]][coords[1]];
        loca();
    }
    void teleportate(int h, int j)
    {
        coords[0]=h;
        coords[1]=j;

    }
    void showMinimap(int level, GUI gui)
    {
        //for(int y=0;y<level;y++)
            //System.out.print("\t");

        for(int i=a-1;i>=0;i--)
        {
            if(coords[0]==i && coords[1]==b-level-1) {
                System.out.print("ВЫ ");
                gui.map.setText(gui.map.getText() + "P&nbsp;&nbsp;&nbsp;");
            }
            else {
                    if(pls[i][b-1-level].equals("Стена"))
                    {
                        System.out.print("   ");
                        gui.map.setText(gui.map.getText() + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  ");
                    }
                    else
                    {
                        System.out.print(i);
                        gui.map.setText(gui.map.getText() + i);

                        System.out.print(b-1-level);
                        String t = String.valueOf(b-1-level);
                        gui.map.setText(gui.map.getText() + t);

                        System.out.print(" ");
                        gui.map.setText(gui.map.getText() + "&nbsp; ");

                    }
                }
        }

        System.out.println(" ");
        gui.map.setText(gui.map.getText() + "<p>");
    }

}

import java.util.Scanner;

public class Main
{
    public static int chapter = 0;
    public static void main (String[] unit)
    {
        System.out.println("Демо, билд 0.8");
        Map m = new Map();
        Map_comm comment = new Map_comm();
        Gamemaster gm = new Gamemaster();
        int gamestate = 0;
        GUI gui = new GUI();
        Scanner in = new Scanner(System.in);
        m.loca();
        String command = "";
        gui.show(true);
        while (true)
        {

            if(gamestate == 0) {
                gui.text.setText("<html>");
                System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
                System.out.println("Действия : w.Вперед s.Назад d.Вправо a.Влево");
                System.out.println("         : q.Осмотреться e.Обыскать x.Выход i.Инвентарь");
                //gui.text.setText(gui.text.getText()+"<p>"+"_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
                gui.text.setText(gui.text.getText()+"<p>"+"Действия : w.Вперед s.Назад d.Вправо a.Влево");
                gui.text.setText(gui.text.getText()+"<p>"+"<&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp>"+": q.Осмотреться e.Обыскать x.Выход i.Инвентарь");
                gui.map.setText("<html>");
                m.showMinimap(0,gui);
                m.showMinimap(1,gui);
                m.showMinimap(2,gui);
                m.showMinimap(3,gui);
                m.showMinimap(4,gui);
            }
            command = in.next();

            if(gamestate == 1)
            {
                gamestate = gm.search(gamestate,command);
            }
            else if(gamestate==2)
            {
                gamestate = gm.inventory(gamestate,command);
            }
            else
            {
                messegeListner(command,comment,gamestate,m,in,gm);
                if(command.equals("Выход")||command.equals("x")||command.equals("X"))
                {
                    break;
                }

            }
           // System.out.println("*");
           // System.out.println(gamestate);
           // System.out.println(" ");
        }


    }
    private static void messegeListner (String command, Map_comm comment, int gamestate, Map m,Scanner in,Gamemaster gm)
    {
        if(command.equals("Назад") || command.equals("Вперед") || command.equals("Вправо") || command.equals("Влево")||command.equals("w")||command.equals("a")||command.equals("s")||command.equals("d"))
        {
            m.movement(command);

        }
        if (command.equals("Осмотреться")||command.equals("q")||command.equals("Q"))
        {
            comment.commentary();

        }
        if (command.equals("Инвентарь") || command.equals("i") || command.equals("I"))
        {

            gamestate=2;
            Gamemaster.inv.chek_inv();
            System.out.println("1. Объеденить предметы");
            System.out.println("2. Выйти из инвентаря");

        }

        if(command.equals("Обыскать")||command.equals("e")||command.equals("E"))
        {

            gamestate = gm.search(gamestate,command);
        }
        if(command.equals("tp"))
        {
            m.teleportate(in.nextInt(), in.nextInt());

        }
        if(command.equals("ch1"))
        {
            chapter =1;
            gm.inv.give("Фонарик");
            gm.inv.give("Батарейки");
            gm.inv.combaine(1,2);

        }



    }

}



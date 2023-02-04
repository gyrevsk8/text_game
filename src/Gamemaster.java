import java.util.Scanner;
public class Gamemaster {
static Inventory inv = new Inventory();
    Scanner in = new Scanner(System.in);
    boolean flashlightMark = true;
    boolean batteryMark = true;
int search ( int state,String command)
    {
        if(state == 0)
        {
            if( Map.location.equals("Библиотеке"))
            {
                System.out.println("1. Обыскать книжные полки");
                System.out.println("2. Обыскать библиотечный стол");
                System.out.println("3. Осмотреть бумаги");
                System.out.println("4. Закончить поиски");
                return 1;
            }
            if( Map.location.equals("Классе А2"))
            {
                System.out.println("1. Обыскать спальные места");
                System.out.println("2. Осмотреть бочку");
                System.out.println("3. Закончить поиски");
                return 1;
            }

        }
        if(state == 1)
        {
            if(Map.location.equals("Библиотеке"))
            {
                if(command.equals("4"))
                {
                    return 0;
                }
                System.out.println("1. Обыскать книжные полки");
                System.out.println("2. Обыскать библиотечный стол");
                System.out.println("3. Осмотреть бумаги");
                System.out.println("4. Закончить поиски");
                if(command.equals("1"))
                {
                    System.out.println("В куче наваленных книг вы видите маленькую паутину. Ничего интересного");
                    return 1;
                }
                if(command.equals("2"))
                {
                    if(flashlightMark) {


                        System.out.println("В одном из ящиков вы находите <Фонарик>. Внутри нет батареек, но лампочка выглядит целой");
                        inv.give("Фонарик");
                        flashlightMark = false;
                    }
                    else
                    {
                        System.out.println("В ящиках только пыль, мертвые пауки и мукулатура. Больше ничего");
                    }

                    return 1;
                }
                if(command.equals("3"))
                {
                    System.out.println("32 презерватива, вибратор к ведерко смазки. Да, библиотеку дети полюбили сразу");
                    return 1;
                }

            }
            if(Map.location.equals("Классе А2")) {
                if (command.equals("3")) {
                    return 0;
                }
                System.out.println("1. Обыскать спальные места");
                System.out.println("2. Заглянуть в бочку");
                System.out.println("3. Закончить поиски");

                if (command.equals("2")) {
                    System.out.println("Внутри бочки остатки костра. Черные угольки наверняка можно использовать чтобы разжечь костер. Так же ими можно рисовать. Оно вам надо?");
                    return 1;
                }
                if (command.equals("1"))
                {
                    if(batteryMark) {
                        System.out.println("За одним из матрацев лежит старое радио. Окрыв занюю панель вы находите <Батарейки>");
                        inv.give("Батарейки");
                        batteryMark = false;
                    }
                    else
                    {
                        System.out.println("Среди матрацев больше нет ничего интересного");
                    }
                    return 1;
                }
            }
        }


        return 0;
    }
 int inventory(int state,String command)
 {
     if(command.equals("2"))
     {
         return 0;
     }
     if(state==0)
     {
         System.out.println("1. Объеденить предметы");
         System.out.println("2. Выйти из инвентаря");
     }
     if(state == 2)
     {
         //System.out.println("1. Объеденить предметы");
        // System.out.println("2. Выйти из инвентаря");

         if (command.equals("1"))
         {
             System.out.println("Номера предметов:");
             String a,b;
             command = in.next();
             a=command;
             command = in.next();
             b=command;
             int a1,b1;

             a1 = Integer.parseInt(a);
             b1 = Integer.parseInt(b);
             inv.combaine(a1,b1);
             return 2;
         }

     }

 return 0;
 }
}

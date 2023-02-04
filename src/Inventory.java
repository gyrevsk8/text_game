

public class Inventory {

    String[] backpack = new String[8];
   public Inventory() {

       for (int i = 0; i < 8 ; i++)
       {
           backpack[i] = "Пусто";
       }
   }
   void chek_inv()
   {
       for(int i=0;i<8;i++)
       {
           System.out.print(i+1);
           System.out.print(".");
           System.out.print(backpack[i]);
           System.out.print(" ");

           if(i%2==1)
           {
               System.out.println(" ");
           }

       }
   }
   void give(String item)
   {
   for(int i=0; i<8;i++)
    {
        if(backpack[i].equals("Пусто"))
        {
            backpack[i]=item;
            chek_inv();
            break;
        }
        if(i==7)
            System.out.println("Закончилось место в рюкзаке. Как?");
    }
    }
    void combaine(int a, int b)
    {
        if(a<1||b<1)
            System.out.println("Это нельзя объеденить!");
        else{
        if(backpack[a-1].equals("Пусто")||backpack[b-1].equals("Пусто"))
        {
            System.out.println("Это нельзя объеденить!");
            System.out.println("1. Объеденить предметы");
            System.out.println("2. Выйти из инвентаря");

        }
        if(backpack[a-1].equals("Фонарик") && backpack[b-1].equals("Батарейки")||backpack[b-1].equals("Фонарик") && backpack[a-1  ].equals("Батарейки"))
        {
            System.out.println("Теперь у вас есть фонарик с батарейками!");
            Main.chapter = 1;
            System.out.println("1. Объеденить предметы");
            System.out.println("2. Выйти из инвентаря");
            if(a>b)
            {
                backpack[b-1]="Фонарик с батарейками";
                backpack[a-1]="Пусто";

            }
            else
            {
                backpack[a-1]="Фонарик с батарейками";
                backpack[b-1]="Пусто";
            }

        }}

    }






}

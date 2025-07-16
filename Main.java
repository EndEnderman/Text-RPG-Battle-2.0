import java.util.Random;
import java.util.Scanner;
class Player{
  public static int[] attack(int Ppower,int Slimelv1Hp){
    Random ran = new Random();
    int[] l = new int[2]; 
    l[0] = Startup.NoZero(ran.nextInt(Ppower));
    l[1] = Slimelv1Hp - l[0];
    return l;
  }

  public static int fire(int t, int Slimelv1Hp){
    Random ran = new Random();
    switch(t){
      default -> Slimelv1Hp -= Startup.NoZero(ran.nextInt(3));
      case 1 -> Slimelv1Hp += Startup.NoZero(ran.nextInt(5));
    }
    return Slimelv1Hp;
  }

  public static int water(int t, int Slimelv1Hp){
    Random ran = new Random();
    switch(t){
      default -> Slimelv1Hp += Startup.NoZero(ran.nextInt(5));
      case 1 -> Slimelv1Hp -= Startup.NoZero(ran.nextInt(3));
    }
    return Slimelv1Hp;
  }

  public static int heal(int PlayerHp, int PlayerMp){
    Random ran = new Random();
    int r;
    if (PlayerMp <= 5){
      r = Startup.NoZero(ran.nextInt(3));
    } 
    else if (PlayerMp < 10){
      r = Startup.NoZero(ran.nextInt(4));
    } 
    else{
      r = Startup.NoZero(ran.nextInt(5));
    }
    PlayerHp += r;
    return PlayerHp;
  }
}

class Slime{
  public static int attack(int t, int SlimeAttack){
    Random ran = new Random();
    int a;
    switch(t){
      default -> a = Startup.NoZero(ran.nextInt(SlimeAttack - 3));
      case 1 -> a = Startup.NoZero(ran.nextInt(SlimeAttack));
    }
    return a;
  }

  public static int heal(int t, int hp){
    Random ran = new Random();
    int a;
      switch(t){
        default -> a = Startup.NoZero(ran.nextInt(5));
        case 1 -> a = Startup.NoZero(ran.nextInt(3));
      }
      hp += a;
      return hp;
  }

  public static int spell(int t){
    Random ran = new Random();
    int a =  Startup.NoZero(ran.nextInt(5));
    switch (t){
      default:
        System.out.println("Slime Casted Water");
      case 1:
        System.out.println("Slime Casted Fire");
    }
    return a;
  }
}

class Startup{
  public static int[] Slimetype(int t){
    //(t = 0 = water) (t = 1 = fire)
    int[] l = new int[4];
    int Slimelv1Hp;
    int SlimeMP;
    int SlimePower;
    switch(t){
      default -> {
          Slimelv1Hp = 12;
          SlimeMP = 10;
          t = 0;
          SlimePower = 5;
          System.out.println("Slime type is Water");
          }
      case 2 -> {
          Slimelv1Hp = 12;
          SlimeMP = 5;
          SlimePower = 7;
          t = 1;
          System.out.println("Slime type is Fire");
          }
      case 3 -> {
          Slimelv1Hp = 10;
          SlimeMP = 10000;
          t = 0;
          SlimePower = 5;
          System.out.println("Slime type is Classic");
          }
    }
    l[0] = SlimeMP;
    l[1] = Slimelv1Hp;
    l[2] = t;
    l[3] = SlimePower;
    return l;
  }

  public static int[] Classpick(int pclass){
    int[] l = {20,10,5};
    switch (pclass){
      default -> System.out.println("Setted Player Class to Default");
      case 2 -> {
          l[0] = 15;
          l[1] = 10;
          System.out.println("Setted Player Class to Warrior");
          }
      case 3 -> {
          l[0] = 15;
          l[1] = 15;
          l[2] = 3;
          System.out.println("Setted Player Class to Wizard");
          }
      case 4 -> {
          l[0] = 20;
          l[1] = 3;
          System.out.println("Setted Player Class to Knight");
          }
      case 5 -> {
          l[0] = 15;
          l[1] = 5;
          l[2] = 5;
          System.out.println("Setted Player Class to Classic");
          }
    }
    //l[0] = PlayerHp;
    //l[1] = Ppower;
    //l[2] = PlayerMPlv1;
    return l;
  }

  public static int NoZero(int n){
    Random ran = new Random();
      while (n == 0){
        n = 3;
        ran.nextInt(n);
      }
    return n;
  }
}

class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Random ran = new Random();
    int[] l;
    int Slimelv1Hp;
    int Sattacklv1;
    int SlimeRA;
    int SlimeMP;
    int SlimePower;
    int PlayerHp;
    int PlayerMPlv1;
    int Spellc;
    int Ppower;
    int pclass;
    int t;
    int time;
    int tc = 0;
    int tcount = 0;
    String go = "Game Over";
    String nope = "\nYou don't have mp so you deicde to attack the Slime";
    String choice = "\nWhat is your choice? ";
    System.out.println("Started Game \n \nA Slime appered\n");
    //Quick Play
    System.out.println("Quick Play? (will auto pick your choices and no round limt)\n1.Yes\n2.No");
    System.out.print(choice);
    int q = scan.nextInt();
    switch(q){
      default -> {
          t = ran.nextInt(2);
          l = Startup.Slimetype(t);
          SlimeMP = l[0];
          Slimelv1Hp = l[1];
          t = l[2];
          SlimePower = l[3];
          pclass = ran.nextInt(5);
          l = Startup.Classpick(pclass);
          PlayerHp = l[0];
          Ppower = l[1];
          PlayerMPlv1 = l[2];
          time = 100;
          }
      case 2 -> {
          //Slime Type
          System.out.println("\nSlime Type:\n1.Water Slime\n2.Fire Slime\n3.Classic Slime");
          System.out.print(choice);
          t = scan.nextInt();
          l = Startup.Slimetype(t);
          SlimeMP = l[0];
          Slimelv1Hp = l[1];
          t = l[2];
          SlimePower = l[3];
          System.out.println("\nSlime type found");
          //Player Class
          System.out.println("\nPlayer Classes:\n1.Default\n2.Warrior\n3.Wizard\n4.Knight\n5.Classic");
          System.out.print(choice);
          pclass = scan.nextInt();
          l = Startup.Classpick(pclass);
          PlayerHp = l[0];
          Ppower = l[1];
          PlayerMPlv1 = l[2];
          System.out.println("Class Picked\n");
          System.out.println("Round Limit? \n 1.Yes \n 2.No");
          tc = scan.nextInt();
          switch(tc){
              default -> time = 100;
              case 1 -> {
                  System.out.print("How many rounds? ");
                  time = scan.nextInt();
                  tcount = time;
              }
          }
          System.out.println("Round Limit setted\n");
          }

    }
    System.out.println("Starting Battle");
    //Battle
    for (int i = 1; i < time; i++){
      System.out.println("");
      System.out.println("Round: " + i);
      if (tc == 1){
        tcount -= 1;
        System.out.println("Rounds left: " + tcount);
      }
      System.out.println("\nSlime: ");
      System.out.println("Hp: " + Slimelv1Hp);
      System.out.println("Mp: " + SlimeMP);
      System.out.println("Power: " + SlimePower);
      System.out.println("\nPlayer: ");
      System.out.println("Hp: " + PlayerHp);
      System.out.println("Mp: " + PlayerMPlv1);
      System.out.println("Power: " + Ppower);
      System.out.print("\nYour actions: \n1. Hit \n2. Spells \n\nWhat will you do? ");
      int lols = scan.nextInt();
      System.out.println("");
      switch (lols){
        default -> {
            System.out.println("That is not a action so you deicde to attack the Slime");
            l = Player.attack(Ppower,Slimelv1Hp);
            Slimelv1Hp = l[1];
            System.out.println("You attack the Slime and losed " + l[0] + " Hp so it has now " + l[1] + " Hp");
            }
        case 1 -> {
            l = Player.attack(Ppower,Slimelv1Hp);
            Slimelv1Hp = l[1];
            System.out.println("You attack the Slime and losed " + l[0] + " Hp so it has now " + l[1] + " Hp");
            }
        case 2 -> {
            System.out.print("Spells: \n1. Fire \n2. Water \n3. Heal \n\nWhat you will do? ");
            Spellc = scan.nextInt();
            switch(Spellc){
                default:
                    l = Player.attack(Ppower,Slimelv1Hp);
                    Slimelv1Hp = l[1];
                    System.out.println("You attack the Slime and losed " + l[0] + " Hp so it has now " + l[1] + " Hp");
                case 1:
                    if (PlayerMPlv1 >= 3){
                        Slimelv1Hp = Player.fire(t,Slimelv1Hp);
                        System.out.println("\nYou Casted Fire to the Slime and now have " + Slimelv1Hp + " Hp");
                        PlayerMPlv1 = PlayerMPlv1 - 3;
                        break;
                    }
                    else{
                        l = Player.attack(Ppower,Slimelv1Hp);
                        Slimelv1Hp = l[1];
                        System.out.println(nope);
                        System.out.println("\nYou attack the Slime and losed " + l[0] + " Hp so it has now " + l[1] + " Hp");
                        break;
                    }
                case 2:
                    if (PlayerMPlv1 >= 3){
                        Slimelv1Hp = Player.water(t,Slimelv1Hp);
                        System.out.println("\nYou Casted Water to the Slime and now have " + Slimelv1Hp + " Hp");
                        PlayerMPlv1 = PlayerMPlv1 - 3;
                        break;
                    }
                    else{
                        l = Player.attack(Ppower,Slimelv1Hp);
                        Slimelv1Hp = l[1];
                        System.out.println(nope);
                        System.out.println("\nYou attack the Slime and losed " + l[0] + " Hp so it has now " + l[1] + " Hp");
                        break;
                    }
                case 3:
                    if (PlayerMPlv1 >= 3){
                        PlayerHp = Player.heal(PlayerHp,PlayerMPlv1);
                        System.out.println("\nYou deicde to Heal yourself now your hp is " + PlayerHp);
                        break;
                    }
                    else{
                        l = Player.attack(Ppower,Slimelv1Hp);
                        Slimelv1Hp = l[1];
                        System.out.println(nope);
                        if (l[1] < 0){
                            l[1] = 0;
                        }
                        System.out.println("\nYou attack the Slime and losed " + l[0] + " Hp so it has now " + l[1] + " Hp");
                        break;
                    }
            } }
      }
      if (Slimelv1Hp < 0){
        System.out.println("The Slime has been killed, Good Job");
        System.out.println(go);
        scan.close();
        System.exit(0);
      }
      SlimeRA = ran.nextInt(2);
      switch(SlimeRA){
        default -> {
            Sattacklv1 = Slime.attack(t,SlimePower);
            PlayerHp -= Sattacklv1;
            System.out.println("The Slime deicde to attack you and you losed " + Sattacklv1 + " Hp");
            }
        case 2 -> {
                if (SlimeMP > 0) {
                    Slimelv1Hp = Slime.heal(t,Slimelv1Hp);
                    System.out.println("The Slime deicde to heal and now have " + Slimelv1Hp);
                    SlimeMP -= 3;
                } else {
                    Sattacklv1 = Slime.attack(t, SlimePower);
                    PlayerHp -= Sattacklv1;
                    System.out.println("The Slime deicde to attack you and you losed " + Sattacklv1 + " Hp");
                }
            }
        case 3 -> {
                if (SlimeMP > 0) {
                    Sattacklv1 = Slime.spell(t);
                    PlayerHp -= Sattacklv1;
                } else {
                    Sattacklv1 = Slime.attack(t, SlimePower);
                    PlayerHp -= Sattacklv1;
                    System.out.println("The Slime deicde to attack you and you losed " + Sattacklv1 + " Hp");
                }
            }
      }
      if (PlayerHp < 0){
        System.out.println("You are dead and the slime still is a live");
        System.out.println(go);
        scan.close();
        System.exit(0);
      }
    }
    if (tcount == 0){
      System.out.println("All your rounds are over and the Slime ran away");
      System.out.println(go);
      scan.close();
      System.exit(0);
    }
  }
}
import java.util.Scanner;

/**
 * Created by jyheo on 2016-04-03.
 */
class Fish {
    private String name;
    private String shape;
    private int x, y;

    public Fish(String name, String shape) {
        this.name = name;
        this.shape = shape;
        x = 0;
        y = 0;
    }

    public Fish() {
        this.name = "Unknown";
        this.shape = "<--<";
        x = 0;
        y = 0;
    }

    public void move(int width, int height) {
        double rand = Math.random();
        this.x = (int) (rand * 80);
        this.y = (int) (rand * 20);

        if (x >= width)
            x = 0;
        if (y >= height)
            y = 0;
    }

    public void move2(int width, int height) {
        x++;
        y++;

        if (x >= width)
            x = 0;
        if (y >= height)
            y = 0;

    }

    public void display(int x, int y) {
        if (this.x == x && this.y == y) {
            System.out.print(shape);
        }
    }
}

public class Lake {
    private int width;
    private int height;
    private Fish fishlist[] = new Fish[10];

    public Lake(int width, int height) {
        this.width = width;
        this.height = height;
        for (int i = 0; i < 10; i++) {
            fishlist[i] = new Fish();
        }
    }

    public void moveFish() {
        for (int i = 0; i < fishlist.length; i++) {
            if (i % 2 == 0) {
                fishlist[i].move2(width, height);
            } else {
                fishlist[i].move(width, height);
            }
        }
    }

    public void display() {
        for (int i = 0; i < width; i++)
            System.out.print("-");
        System.out.println();
        for (int i = 0; i < height; i++) {
            System.out.print("|");
            for (int j = 0; j < width; j++) {
                for (int k = 0; k < 10; k++) {
                    fishlist[k].display(j, i);
                }
                System.out.print(" ");
            }
            System.out.println("|");
        }
        for (int i = 0; i < width; i++)
            System.out.print("-");
        System.out.println();
    }

    public static void main(String args[]) {
        Lake lake = new Lake(80, 20);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            lake.moveFish();
            lake.display();
            scanner.next();
        }
    }
}
